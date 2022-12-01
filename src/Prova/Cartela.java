package Prova;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import Prova.ListaNumerosDaCartela.Numero;


public class Cartela {
	boolean emUso;
	boolean premiada;
	int numeroIdentificacao;
	String dataGeracao;
	
	private String getDateTime() {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		return dateFormat.format(date);
	}
	
	//ListaNumerosDaCartela listaNumeros;
	//ListaNumerosDaCartela listaNumerosAcertados;
	
	public List<Integer> listaNumerosDaCartela = new LinkedList<Integer>();
	public List<Integer> listaNumerosAcertados = new LinkedList<Integer>();
	
	void removerCartela(){
		setEmUso(false);
	}


	public Cartela (int idCartela){ 
		setEmUso(true);
		setPremiada(false);
		setNumeroIdentificacao(idCartela);
		setDataGeracao(getDateTime());
	}


	public boolean isEmUso() {
		return emUso;
	}


	public void setEmUso(boolean emUso) {
		this.emUso = emUso;
	}


	public int getNumeroIdentificacao() {
		return numeroIdentificacao;
	}


	public void setNumeroIdentificacao(int numeroIdentificacao) {
		this.numeroIdentificacao = numeroIdentificacao;
	}

	public boolean isPremiada() {
		return premiada;
	}


	public void setPremiada(boolean premiada) {
		this.premiada = premiada;
	}


	public String getDataGeracao() {
		return dataGeracao;
	}


	public void setDataGeracao(String dataGeracao) {
		this.dataGeracao = getDateTime();
	}


	public List<Integer> getListaNumerosDaCartela() {
		return listaNumerosDaCartela;
	}


	public void setListaNumerosDaCartela(List<Integer> listaNumerosDaCartela) {
		this.listaNumerosDaCartela = listaNumerosDaCartela;
	}


	public List<Integer> getListaNumerosAcertados() {
		return listaNumerosAcertados;
	}


	public void setListaNumerosAcertados(List<Integer> listaNumerosAcertados) {
		this.listaNumerosAcertados = listaNumerosAcertados;
	}
	
	public void adicionarNumeroAcertado(){
		
	}
	
	public String exibirNumerosDaCartela(Cartela cartela){
		   if(cartela.listaNumerosDaCartela.size() == 0){
			   return "Lista vazia\n";
		   } 
		   		   
	        String str = "";
	        for (int i=0; i<cartela.listaNumerosDaCartela.size();i++){
	        	int numero = cartela.listaNumerosDaCartela.get(i);
	        	str+= numero+"-";
	        }
	            
	        return str;
	}
	
	public String exibirNumerosAcertadosDaCartela(Cartela cartela){
		   if(cartela.listaNumerosAcertados.size() == 0){
			   return " VAZIO =[ \n";
		   } 
		   		   
	        String str = "";
	        for (int i=0; i<cartela.listaNumerosAcertados.size();i++){
	        	int numero = cartela.listaNumerosAcertados.get(i);
	        	str+= numero+"-";
	        }
	            
	        return str + "\n";
	}
	
}


