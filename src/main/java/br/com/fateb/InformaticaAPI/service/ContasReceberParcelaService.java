package br.com.fateb.InformaticaAPI.service;

import br.com.fateb.InformaticaAPI.entity.ContasReceber;
import br.com.fateb.InformaticaAPI.entity.ContasReceberParcela;
import br.com.fateb.InformaticaAPI.entity.Pedido;
import br.com.fateb.InformaticaAPI.entity.ProdutoPedido;
import br.com.fateb.InformaticaAPI.exception.NotFoundException;
import br.com.fateb.InformaticaAPI.repository.ContasReceberParcelaRepository;
import br.com.fateb.InformaticaAPI.utils.AtualizarEntidade;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Duration;
import java.time.LocalDate;
import java.util.List;

@Service
public class ContasReceberParcelaService {


    ContasReceberParcelaRepository repository;

    ProdutoPedidoService produtoPedidoService;


    AtualizarEntidade atualizarEntidade;



    @Autowired
    public void PedidoRepository(ContasReceberParcelaRepository repository, AtualizarEntidade atualizarEntidade,
                                 PedidoService pedidoService) {
        this.repository = repository;
        this.atualizarEntidade = atualizarEntidade;
    }

    public ContasReceberParcela getContasReceberParcelaById(Integer id){

        return repository.findById(id).orElseThrow(() -> new NotFoundException("Contas a receber não encontrada"));
    }

    public List<ContasReceberParcela> getAllContasReceberParcela() {
        return repository.findAll();
    }


    @Transactional
    public void atualizarContasReceberParcela(ContasReceberParcela contasReceberParcela) {

        ContasReceberParcela existente = getContasReceberParcelaById(contasReceberParcela.getId());
        atualizarEntidade.atualizarEntidade(contasReceberParcela, existente);

        repository.saveAndFlush(contasReceberParcela);
    }

    @Transactional
    public void cadastrarContasReceberParcela(ContasReceber contasReceber) {
        ContasReceberParcela contasReceberParcela = new ContasReceberParcela();

        List<ProdutoPedido> produtosVendas = produtoPedidoService.getProdutoPedidoPeloIdPedido(contasReceber.getIdPedido().getId());

        BigDecimal valorTotal = BigDecimal.ZERO;

        for(ProdutoPedido produtosVenda : produtosVendas){
            BigDecimal valorProduto = produtosVenda.getValorProdutoDesconto().multiply(BigDecimal.valueOf(produtosVenda.getQuantidade()));
            valorTotal = valorTotal.add(valorProduto);
        }


        for(int i = 1; i <= contasReceber.getIdPedido().getQuantidadeParcelas(); i++) {

            contasReceberParcela.setDataVencimento(LocalDate.now().plus(Duration.ofDays(30L * i)));
            contasReceberParcela.setValor(valorTotal.divide(BigDecimal.valueOf(contasReceber.getIdPedido().getQuantidadeParcelas()), 2, RoundingMode.HALF_UP));
            contasReceberParcela.setIdContasReceber(contasReceber);
            contasReceberParcela.setParcela(i);

            repository.saveAndFlush(contasReceberParcela);
        }

    }
}
