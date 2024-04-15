package br.com.fateb.InformaticaAPI.service;

import br.com.fateb.InformaticaAPI.dto.request.PedidoRequest;
import br.com.fateb.InformaticaAPI.dto.response.PedidoResponse;
import br.com.fateb.InformaticaAPI.entity.*;
import br.com.fateb.InformaticaAPI.exception.NotFoundException;
import br.com.fateb.InformaticaAPI.mapper.PedidoMapper;
import br.com.fateb.InformaticaAPI.repository.ContasReceberRepository;
import br.com.fateb.InformaticaAPI.repository.PedidoRepository;
import br.com.fateb.InformaticaAPI.utils.AtualizarEntidade;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

@Service
public class PedidoService {

    PedidoRepository repositoy;

    ProdutoPedidoService produtoPedidoService;

    VendedorService vendedorService;

    ClienteService clienteService;


    FormaPagamentoService formaPagamentoService;

    ContasReceberService contasReceberService;

    AtualizarEntidade atualizarEntidade;


    @Autowired
    public void PedidoRepository(PedidoRepository repositoy, VendedorService vendedorService, ProdutoPedidoService produtoPedidoService,
                                ClienteService clienteService, AtualizarEntidade atualizarEntidade, ContasReceberService contasReceberService,
                                FormaPagamentoService formaPagamentoService) {
        this.repositoy = repositoy;
        this.vendedorService = vendedorService;
        this.clienteService = clienteService;
        this.produtoPedidoService = produtoPedidoService;
        this.atualizarEntidade = atualizarEntidade;
        this.formaPagamentoService = formaPagamentoService;
        this.contasReceberService = contasReceberService;

    }

    @Transactional
    public Pedido cadastrar(PedidoRequest request) {

        Vendedor vendedor = vendedorService.getVendedorById(request.idVendedor());

        Cliente cliente = clienteService.getClienteById(request.idCliente());

        FormaPagamento formaPagamento = formaPagamentoService.getFormaPagamentoById(request.idFormaPagamento());


        Pedido pedido = new Pedido();
        pedido.setIdCliente(cliente);
        pedido.setIdVendedor(vendedor);
        pedido.setDataVenda(LocalDate.now());
        pedido.setQuantidadeParcelas(request.quantidadeParcelas());
        pedido.setIdFormaPagamento(formaPagamento);
        pedido = repositoy.saveAndFlush(pedido);

        Pedido finalPedido = pedido;
        request.produtosPedido().forEach(produtoPedido -> {

            produtoPedidoService.cadastrar(finalPedido.getId(), produtoPedido);

        });

        contasReceberService.cadastrarContasReceber(pedido);

        return  pedido;
    }

    public Pedido getPedidoById(Integer id){
        return repositoy.findById(id).orElseThrow(() -> new NotFoundException("Pedido não encontrada"));
    }

    public List<Pedido> getAllPedidos() {
        return repositoy.findAll();
    }

}
