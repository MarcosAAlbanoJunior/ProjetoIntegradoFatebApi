package br.com.fateb.InformaticaAPI.service;

import br.com.fateb.InformaticaAPI.dto.request.VendaRequest;
import br.com.fateb.InformaticaAPI.dto.response.ComissaoResponse;
import br.com.fateb.InformaticaAPI.dto.response.ContasReceberResponse;
import br.com.fateb.InformaticaAPI.dto.response.ProdutoResponse;
import br.com.fateb.InformaticaAPI.entity.*;
import br.com.fateb.InformaticaAPI.exception.NotFoundException;
import br.com.fateb.InformaticaAPI.mapper.ContasReceberMapper;
import br.com.fateb.InformaticaAPI.mapper.ProdutoVendaMapper;
import br.com.fateb.InformaticaAPI.repository.ContasReceberRepository;
import br.com.fateb.InformaticaAPI.repository.VendaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
public class ContasReceberService {


    private ContasReceberRepository repository;

    private VendaService vendaService;

    private ProdutoVendaService produtoVendaService;

    @Autowired
    public void VendaRepository(ContasReceberRepository repository, VendaService vendaService, ProdutoVendaService produtoVendaService) {
        this.repository = repository;
        this.vendaService = vendaService;
        this.produtoVendaService = produtoVendaService;
    }

    public ContasReceberResponse getContasReceberById(Integer id){
         ContasReceberResponse response = ContasReceberMapper.INSTANCE.entityToResponse(repository.findById(id).orElseThrow(() -> new NotFoundException("Contas a Receber não encontrada")));

        List<ProdutosVenda> produtosVendas = produtoVendaService.getProdutosVendaPeloIdVenda(response.getIdVenda());

        List<ProdutoResponse> listaProdutoResponse = new ArrayList<>();

        for(ProdutosVenda produtosVenda : produtosVendas){
            listaProdutoResponse.add(ProdutoVendaMapper.INSTANCE.entityToResponse(produtosVenda));
        }

        return response;
    }

    public List<ContasReceber> getAllContasReceber() {
        return repository.findAll();
    }

    public List<ContasReceberResponse> getAllContasReceberResponse() {

        List<ContasReceber> listaEntities = repository.findAll();
        List<ContasReceberResponse> resposta = new ArrayList<>();
        ContasReceberResponse itemLista = new ContasReceberResponse();

        for(ContasReceber x : listaEntities) {
            itemLista = ContasReceberMapper.INSTANCE.entityToResponse(x);
            resposta.add(itemLista);
        }

        return resposta;
    }

    public List<ComissaoResponse> buscarComissoesData(String data){

        String[] partes = data.split("-");
        int ano = Integer.parseInt(partes[0]);
        int mes = Integer.parseInt(partes[1]);

        return repository.findComissaoPorUsuarioNoMesEAno(ano, mes);
    }
}
