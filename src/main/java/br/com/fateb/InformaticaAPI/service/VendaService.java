package br.com.fateb.InformaticaAPI.service;

import br.com.fateb.InformaticaAPI.dto.request.VendaRequest;
import br.com.fateb.InformaticaAPI.dto.response.VendaResponse;
import br.com.fateb.InformaticaAPI.entity.*;
import br.com.fateb.InformaticaAPI.exception.NotFoundException;
import br.com.fateb.InformaticaAPI.mapper.VendaMapper;
import br.com.fateb.InformaticaAPI.repository.ContasReceberRepository;
import br.com.fateb.InformaticaAPI.repository.VendaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Duration;
import java.time.Instant;
import java.util.List;

@Service
public class VendaService {

    private VendaRepository repositoy;

    private ProdutoVendaService produtoVendaService;

    private UsuarioService usuarioService;

    private ClienteService clienteService;

    private MovimentacaoEstoqueService movimentacaoEstoqueService;


    private ContasReceberRepository contasReceberRepository;


    @Autowired
    public void VendaRepository(VendaRepository repositoy, UsuarioService usuarioService, ProdutoVendaService produtoVendaService,
                                ClienteService clienteService, ContasReceberRepository contasReceberRepository,
                                MovimentacaoEstoqueService movimentacaoEstoqueService) {
        this.repositoy = repositoy;
        this.usuarioService = usuarioService;
        this.clienteService = clienteService;
        this.contasReceberRepository = contasReceberRepository;
        this.produtoVendaService = produtoVendaService;
        this.movimentacaoEstoqueService = movimentacaoEstoqueService;
    }

    @Transactional
    public VendaResponse cadastrar(VendaRequest request) {

        Usuario usuario = usuarioService.getUsuarioById(request.idUsuario());

        Cliente cliente = clienteService.getClienteById(request.idCliente());

        Venda venda = new Venda();
        venda.setIdCliente(cliente);
        venda.setIdUsuario(usuario);
        venda.setDataVenda(Instant.now());
        venda.setParcelas(request.parcelas());
        venda.setTipoPagamento(request.tipoPagamento());
        venda = repositoy.saveAndFlush(venda);

        Venda finalVenda = venda;
        request.produtosVenda().forEach(produtoVenda -> {

            produtoVendaService.cadastrar(finalVenda.getId(), produtoVenda);

            movimentacaoEstoqueService.cadastrar(produtoVenda.idProduto(), 2, produtoVenda.quantidade(), Instant.now());

        });

        cadastrarContasReceber(venda);

        return  VendaMapper.INSTANCE.entityToResponse(venda);
    }

    public Venda getVendaById(Integer id){
        return repositoy.findById(id).orElseThrow(() -> new NotFoundException("Venda não encontrada"));
    }

    public List<Venda> getAllVendas() {
        return repositoy.findAll();
    }

    @Transactional
    public void cadastrarContasReceber(Venda venda) {

        getVendaById(venda.getId());

        List<ProdutosVenda> produtosVendas = produtoVendaService.getProdutosVendaPeloIdVenda(venda.getId());

        BigDecimal valorTotal = BigDecimal.ZERO;

        for(ProdutosVenda produtosVenda : produtosVendas){
            BigDecimal valorProduto = produtosVenda.getPrecoUnitario().multiply(BigDecimal.valueOf(produtosVenda.getQuantidade()));
            valorTotal = valorTotal.add(valorProduto);
        }

        for(int i = 1; i <= venda.getParcelas(); i++) {
            ContasReceber contasReceber = new ContasReceber();
            contasReceber.setStatusPagamento("A Receber");
            contasReceber.setIdVenda(venda);
            contasReceber.setValorParcela(valorTotal.divide(BigDecimal.valueOf(venda.getParcelas()), 2, RoundingMode.HALF_UP));
            contasReceber.setValorTotal(valorTotal);
            contasReceber.setDataVencimento(Instant.now().plus(Duration.ofDays(30L * i)));
            contasReceber.setComissaoVenda(valorTotal.multiply(BigDecimal.valueOf(0.10)));
            contasReceberRepository.saveAndFlush(contasReceber);
        }
    }
}
