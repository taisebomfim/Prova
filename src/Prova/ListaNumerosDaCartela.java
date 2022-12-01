package Prova;

public class ListaNumerosDaCartela {

    static class Numero{
        public Numero prox; 
        public int valor;
        
        public Numero (int val){ 
            valor = val; 
            prox = null;
        }

    }
    
    private Numero inicio; 
    
    public ListaNumerosDaCartela(){  
        inicio = null;
    }

  public boolean isEmpty(){
    return inicio == null;
  }
    
public Numero buscarNumero( int elem){
    for(Numero num = inicio; num != null; num = num.prox){
    	 if (elem == num.valor) {
    	   return num;  
         }
    }     
    	  
    return null;                     
            
  }

  	public void inserirNovoNumero(int elem){
        Numero novoNumero = new Numero(elem);
        novoNumero.prox = inicio; 
        inicio = novoNumero;     
    }
    
    public void removeInicio(){ 
        inicio = inicio.prox; 
    }
    
    public String exibirNumerosDaCartela(){
        if(isEmpty()) return "Lista vazia\n";
        String str = "";
        for (Numero numero = inicio; numero != null; numero = numero.prox)
            str+= numero.valor+"-";
        return str + "\n";
    }

}
