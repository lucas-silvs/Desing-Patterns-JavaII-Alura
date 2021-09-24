package br.com.alura.loja.orcamento;

import br.com.alura.loja.DomainException;
import br.com.alura.loja.http.HttpAdapter;

import java.util.Map;

public class RegistroDeOrcamento {

    private HttpAdapter http;

    public RegistroDeOrcamento (HttpAdapter http){
        this.http = http;

    }
    public void registroDeOrcamento(Orcamento orcamento){
        if(orcamento.isFinalizado()){
            throw new DomainException("Orcamento não finalizado");

        }
    }

    public void registrar(Orcamento orcamento){
        String url = "http://api.externa/orcamento";
        Map<String,Object> dados = Map.of(
                "valor", orcamento.getValor(),
                "quantidadeItens", orcamento.getQuantidadeItens());
            http.post(url,dados);
        //chamada HTTP para API externa
        //URL Connection, HTTP Client, lib Rest

    }
}
