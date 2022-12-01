package Prova;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

class Bingo {
	
	int cartelaID = 0;
	public LinkedList<Cartela> cartelasGeradas = new LinkedList<Cartela>();
	public List<Integer> numerosNaoSorteados = new LinkedList<Integer>();
	public List<Integer> numerosSorteados = new LinkedList<Integer>();
	
	void gerarCartelas(int qtdCartelas){//GERA lista de cartelas de acordo com a quantidade passada 
		for(int i =0; i < qtdCartelas; i++){
			this.cartelaID++;
			Cartela	cartela = new Cartela(this.cartelaID);
			for(int j=0; j < 15; j++){
				cartela.listaNumerosDaCartela.add(sortearNumeroDaCartela());
			}
			cartelasGeradas.add(cartela);
		}		
	}
	
	public void exibirCartelasGeradas(){//Exibe as cartelas e seus numeros assim como os acertados
		for(int i=0; i < cartelasGeradas.size() ; i++){
			Cartela cartela = cartelasGeradas.get(i);
			System.out.println("");
			System.out.println("CartelaID: "+ cartela.numeroIdentificacao);
			System.out.println("Data de Geração: "+ cartela.dataGeracao);
			System.out.println("Numeros da Cartela:" + cartela.exibirNumerosDaCartela(cartela));//Exibe os numeros das cartelas
			System.out.println("Numeros Acertados na Cartela: "+ cartela.exibirNumerosAcertadosDaCartela(cartela));//Exibe os numeros das cartelas ACERTADOS
			
		}
	}
	
	
	public static int sortearNumeroDaCartela(){//sorteia e retorna um numero aleatorio entre 1 e 60
		Random random = new Random();
		int numeroSorteado =  random.nextInt(60)+1;
		
		return numeroSorteado;
	}
	
	public void sortearNumeroDoBingo(){//sorteia e exibe um numero aleatorio entre 1 e 60, remove da lista de NAO SORTEADOS e adiciona na lista de SORTEADOS, E Adiciona na lista de acertados de cada cartela caso exista na lista
		Random random = new Random();
		int numeroSorteado =  random.nextInt(60)+1;
		System.out.println("NUMERO DO BINGO Sorteado "+ numeroSorteado);
		numerosSorteados.add(numeroSorteado);
		removerNumeroSorteado(numeroSorteado);
		adicionarNumeroSorteadoNasCartelas(numeroSorteado);
		System.out.println("");
	}
	
	public void adicionarNumeroSorteadoNasCartelas(int numeroSorteado){//adiciona o numero sorteado na lista de acertos da cartela
		for(int i = 0; i < cartelasGeradas.size(); i++){
			if(cartelasGeradas.get(i).listaNumerosDaCartela.get(i) == numeroSorteado){//Existe o numero sorteado na cartela
				cartelasGeradas.get(i).listaNumerosAcertados.add(numeroSorteado);
			}
	    }
	}
	
	public void removerNumeroSorteado(int numeroSorteado){//remove o numero sorteado da lista de numeros nao sorteados
		for(int i = 0; i < numerosNaoSorteados.size(); i++){
	        if (numerosNaoSorteados.get(i) == numeroSorteado){
	        	numerosNaoSorteados.remove(numerosNaoSorteados.get(i));
	        	break;
	        }
	    }
	}
	
	public void exibirNumerosNaoSorteados(){//exibe restantes dos numeros NAO sorteados
		System.out.println("Numeros Nao Sorteados ");
		for(int i=0; i < numerosNaoSorteados.size() ; i++){
			System.out.print(numerosNaoSorteados.get(i) + " ");
		}
		System.out.println(" ");
	}
	
	public void exibirNumerosSorteados(){//exibe os numeros sorteados ate o momento
		System.out.println("Numeros Sorteados ");
		for(int i=0; i < numerosSorteados.size() ; i++){
			System.out.print(numerosSorteados.get(i) + " ");
		}
		System.out.println("");
	}
	
	
	public void preencherNumerosNaoSorteados(){//Iniciando o bingo com o total de numeros previstos 1 a 60
		for(int i=1; i <= 60 ; i++){
			numerosNaoSorteados.add(i);
		}
		System.out.println("Bingo Iniciado e 60 Numeros Nao sorteados adicionado ");
		System.out.println("");
	}
	
	public void desmarcarNumerosSorteados(){//desmarcar numeros sorteados e desmarcar os acertados pelas cartelas 
		numerosSorteados = new LinkedList<Integer>();
		for(int i=0; i < cartelasGeradas.size() ; i++){
			Cartela cartela = cartelasGeradas.get(i);
			System.out.println("");
			cartela.listaNumerosAcertados = new LinkedList<Integer>();
		}
	}
	
	public void exibirCartelasVencedoras(){//exibir as cartelas vencedoras
		for(int i=0; i < cartelasGeradas.size() ; i++){
			Cartela cartela = cartelasGeradas.get(i);
			System.out.println("");
			if(cartela.premiada == true){
				System.out.println("CartelaID: "+ cartela.numeroIdentificacao);
				System.out.println("Data de Geração: "+ cartela.dataGeracao);
				System.out.println("Numeros da Cartela:" + cartela.exibirNumerosDaCartela(cartela));
				System.out.println("Numeros Acertados na Cartela: "+ cartela.exibirNumerosAcertadosDaCartela(cartela));
			}
		}
	}
	
	public void verificarCartelasPremiadas(){//verificar se existe alguma cartela vencedora e colocar como premiada e sem uso 
		for(int i=0; i < cartelasGeradas.size() ; i++){
			Cartela cartela = cartelasGeradas.get(i);
			System.out.println("");
			if(cartela.listaNumerosAcertados == cartela.listaNumerosDaCartela){
				System.out.println("CARTELA: "+cartela.numeroIdentificacao + " PREMIADA");
				if(cartela.emUso == true){//Somente cartelas em uso podem ser premiadas
					cartela.setPremiada(true);
					cartela.setEmUso(false);
				}
			}else{
				System.out.println("CARTELA: "+cartela.numeroIdentificacao + " NAO PREMIADA ATE O MOMENTO");
			}
			
		}
	}
	
	public boolean compararCartelas(){
		for(int i=0; i < cartelasGeradas.size() ; i++){
			Cartela cartela = cartelasGeradas.get(i);
			System.out.println("CARTELA: "+cartela.numeroIdentificacao);
			for(int j=i+1; j < cartelasGeradas.size() ; j++){
				Cartela cartelaComparada = cartelasGeradas.get(j);
				System.out.println("CARTELA COMPARADA: "+cartelaComparada.numeroIdentificacao);
				if(cartela.listaNumerosDaCartela == cartelaComparada.listaNumerosDaCartela ){
					System.out.println("CARTELA:"+cartela.numeroIdentificacao + " identica a CARTELA:" + cartelaComparada.numeroIdentificacao);
					return true;
				}
			}
		}
		System.out.println("");
		System.out.println("NENHUMA CARTELA IGUAL");
		return false;
	}
	
	
	
	public Bingo(){
		preencherNumerosNaoSorteados();
	}
}




