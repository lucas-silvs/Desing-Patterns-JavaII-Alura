package br.com.alura.loja.orcamento;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import br.com.alura.loja.orcamento.situacao.EmAnalise;
import br.com.alura.loja.orcamento.situacao.Finalizado;
import br.com.alura.loja.orcamento.situacao.SituacaoOrcamento;

public class Orcamento implements  Orcavel{

	private BigDecimal valor;
	private SituacaoOrcamento situacao;
	public List<Orcavel> itens;

	public Orcamento(BigDecimal valor) {
		this.valor = valor;
		itens = new ArrayList<>();
		this.situacao = new EmAnalise();
	}

	public Orcamento() {
		this.valor = BigDecimal.ZERO;
		itens = new ArrayList<>();
		this.situacao = new EmAnalise();
	}

	public void aplicarDescontoExtra() {
		BigDecimal valorDescontoExtra = this.situacao.calcularDescontoExtra(this);
		this.valor = this.valor.subtract(valorDescontoExtra);
	}
	
	public void aprovar() {
		this.situacao.aprovar(this);
	}
	
	public void reprovar() {
		this.situacao.reprovar(this);
	}
	
	public void finalizar() {
		this.situacao.finalizar(this);
	}

	public BigDecimal getValor() {
		return valor;
	}

	public int getQuantidadeItens() {
		return itens.size();
	}

	public SituacaoOrcamento getSituacao() {
		return situacao;
	}
	
	public void setSituacao(SituacaoOrcamento situacao) {
		this.situacao = situacao;
	}

	public boolean isFinalizado() {
		return  situacao instanceof Finalizado;
	}

	public void  addItem(Orcavel item){
		this.valor = valor.add(item.getValor());
		this.itens.add(item);
	}
}
