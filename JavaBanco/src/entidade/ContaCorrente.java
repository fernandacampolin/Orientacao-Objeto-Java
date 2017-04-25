package entidade;

import java.util.ArrayList;
import java.util.Date;

public class ContaCorrente {
	private String titular;
	private int numero;
	private float saldo;
	private ArrayList<Operacao> operacoes = new ArrayList<Operacao>();
	private float valor;
	
	public float getSaldo() {
		return saldo;
	}
	
	public float debito (float valor) {
		saldo -= valor;
		Operacao Operacao = new Operacao(valor, "DEBITO", new Date());
		operacoes.add(Operacao);
		return saldo;
	}
	
	public float credito(float valor) {
		saldo += valor;
		Operacao o = new Operacao(valor, "CREDITO", new Date());
		operacoes.add(o);
		return saldo;
	}
	
	public ArrayList<Operacao> extrato() {
		return operacoes;
	}
	
	public float transferencia (float i , ContaCorrente ccDestino){
		this.debito(valor);
		ccDestino.credito(valor);
		return saldo; 
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public ArrayList<Operacao> getOperacoes() {
		return operacoes;
	}

	public ContaCorrente(int numero, String titular) {
		super();
		this.numero = numero;
		this.titular = titular;
	}
	

	
}