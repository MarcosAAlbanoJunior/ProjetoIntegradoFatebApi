package br.com.fateb.InformaticaAPI.service;

import br.com.fateb.InformaticaAPI.dto.response.ComissaoResponse;
import br.com.fateb.InformaticaAPI.dto.response.ContasReceberResponse;
import br.com.fateb.InformaticaAPI.dto.response.PedidoResponse;
import br.com.fateb.InformaticaAPI.entity.*;
import br.com.fateb.InformaticaAPI.exception.NotFoundException;
import br.com.fateb.InformaticaAPI.mapper.ContasReceberMapper;
import br.com.fateb.InformaticaAPI.repository.ContasReceberRepository;
import br.com.fateb.InformaticaAPI.utils.AtualizarEntidade;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ContasReceberService {


    ContasReceberRepository repository;


    AtualizarEntidade atualizarEntidade;

    ContasReceberParcelaService contasReceberParcelaService;



    @Autowired
    public void PedidoRepository(ContasReceberRepository repository, AtualizarEntidade atualizarEntidade,
                                 PedidoService pedidoService, ContasReceberParcelaService contasReceberParcelaService) {
        this.repository = repository;
        this.atualizarEntidade = atualizarEntidade;
        this.contasReceberParcelaService = contasReceberParcelaService;
    }

    public ContasReceber getContasReceberById(Integer id){

        return repository.findById(id).orElseThrow(() -> new NotFoundException("Contas a receber não encontrada"));
    }

    public List<ContasReceber> getAllContasReceber() {
        return repository.findAll();
    }


    @Transactional
    public void atualizarContasReceber(ContasReceber contasReceber) {

        ContasReceber existente = getContasReceberById(contasReceber.getId());
        atualizarEntidade.atualizarEntidade(contasReceber, existente);

        repository.saveAndFlush(contasReceber);
    }

    @Transactional
    public void cadastrarContasReceber(Pedido pedido) {

        ContasReceber contasReceber = new ContasReceber();
        contasReceber.setDataEmissao(LocalDate.now());
        contasReceber.setIdPedido(pedido);

        repository.saveAndFlush(contasReceber);

        contasReceberParcelaService.cadastrarContasReceberParcela(contasReceber);

    }
}
