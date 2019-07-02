
package lista_encadeada;

import java.util.Iterator;
import java.util.ListIterator;

public class ListaIterator<T> implements Iterator<T>,ListIterator<T>{

    No<T> no;
    No<T> ant;
    No<T> inicio;
    int indice;
    Integer quantidade;

    public ListaIterator(No<T> no) {
        this.no = no;
        this.ant = null;
        this.inicio = no;
        this.indice = 0;
        this.quantidade = 0;
    }

    public ListaIterator(No<T> no, Integer quantidade) {
        this.no = no;
        this.ant = null;
        this.inicio = no;
        this.indice = 0;
        this.quantidade = quantidade;
    }
    
    @Override
    public boolean hasNext() {
       if(no != null){
          return true; 
       }
       return false;
    }

    @Override
    public T next() {
        T elemento = no.getElemento();
        ant = no;
        no = no.getProx();
        indice++;
        return elemento;
    }
    
     @Override
    public void set(T e) {
        if(this.ant == null){
            return;
        }
        this.ant.setElemento(e);
    }
 
    //Não implementados
    @Override
    public boolean hasPrevious() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T previous() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int nextIndex() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int previousIndex() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void add(T e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }  
}
