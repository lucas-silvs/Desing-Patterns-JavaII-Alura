package br.com.alura.loja;

import br.com.alura.loja.orcamento.ItemOrcamento;
import br.com.alura.loja.orcamento.Orcamento;
import br.com.alura.loja.orcamento.OrcamentoProxy;

import java.math.BigDecimal;

public class TesteComposicao {
    public static void main(String[] args) {
        Orcamento antigo = new Orcamento();
        antigo.addItem(new ItemOrcamento(new BigDecimal("200")));
        antigo.reprovar();

        Orcamento novo = new Orcamento();
        novo.addItem(new ItemOrcamento(new BigDecimal("500")));
        novo.addItem(antigo);

        OrcamentoProxy proxy = new OrcamentoProxy(novo);
        System.out.println(proxy.getValor());
    }
}
