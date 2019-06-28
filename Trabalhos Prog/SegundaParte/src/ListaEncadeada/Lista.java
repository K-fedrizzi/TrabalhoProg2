
package ListaEncadeada;

public class Lista<T>{
    
    No<T>inicio;
    No<T>fim;
    int quantidadeNo;

    public Lista(   ) {
         fim = inicio  = null;
         quantidadeNo = 0;
    }

    public String toString() {
        return  inicio +"";
    }
    
    public int size() {
       return quantidadeNo;
    }

    public boolean isEmpty() {
        if(quantidadeNo == 0){
            return false;
        }
        return true;
    }

    public boolean add(T e) {
        No<T> novo = new No<T>(e);
        if(inicio == null){
            novo.setProx(inicio);
            inicio = novo;
            fim = inicio;
        }else{
            fim.setProx(novo);
            fim = novo;
        }
        quantidadeNo++;
        return  true;
    }

    public T get(int index) {
        No<T> p = inicio;
       int cont=0;
       while(cont < index){
           p=p.getProx();
           cont++;
       }
       return p.getElemento();
    }
    
    public void removeAll( ) {
       No<T> p = inicio;
       
       No<T> q = null;
       int cont=0;
       while(cont < size()){
          q=p;
          p=p.getProx();
          q.setProx(p);
          cont++;
       }
    } 
    
    /*public void ordenarAgencias(Lista<Agencia>a)
    {
        ComparadorAgencia comparaAgencia = new ComparadorAgencia();
        
        for(No<Agencia> p = a.inicio; p!= null; p = p.getProx()){
            for(No<Agencia> q = p.getProx(); q != null; q = q.getProx()){
                      
                if(comparaAgencia.compare(p.getElemento().getNumeroAgencia(),q.getElemento().getNumeroAgencia())== 1){            
                   Agencia aux =  p.getElemento();                
                   p.setElemento(q.getElemento());            
                   q.setElemento(aux);
                }
            }
        }
    }*/
}
