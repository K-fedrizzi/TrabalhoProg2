package lista_encadeada;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Lista<T>  implements List<T>,Iterable<T>{
    
    No<T> inicio;
    No<T> fim;
    int quantidade;

    public Lista() {
        this.inicio = null;
        this.fim    = inicio;
        this.quantidade = 0;
    }
    
    @Override
    public int size() {
        return this.quantidade;
    }
    
    @Override
    public boolean add(T e) {
        
       No<T> novo = new No<T>(e);
       if(inicio == null){
          inicio = novo;
          fim = inicio;
       }else{
             fim.setProx(novo);
             fim = novo;
       } 
       this.quantidade++;
       return true;
    }
    
    @Override
    public Object[] toArray() {
        Object array[] = new Object[quantidade];
        
        No<T> p = inicio;
        int cont=0;
        while(p!=null){
            array[cont] = p.getElemento();
            cont++;
            p=p.getProx();
        }
        return array;
    }

    @Override
    public boolean isEmpty() {
        if(quantidade == 0){
           return true;
        }
        return false;
    }
    
    @Override
    public T get(int index) {
        int cont=0;
        No<T>p = inicio;
        while(cont != index){
           cont++;
           p=p.getProx();
        }
        return p.getElemento();
    }

    @Override
    public boolean contains(Object o) {
      T elemento = (T) o;
      if(this.inicio == null){
        return false;          
      }else{
            No<T> p = this.inicio;
            while(p != null){
                  if(p.getElemento().equals(elemento)){
                     return true; 
                  }
                  p=p.getProx();
            }
      }
      return false;
    }
    
    @Override
    public ListIterator<T> listIterator() {
        return new ListaIterator<>(this.inicio, this.quantidade); 
    }
    
    @Override
    public String toString() {
        String str = "[";
        for(No<T>p = inicio; p !=null ; p=p.getProx()){
           str += p.getElemento()+" ";
        }
        return str+"]";
    }
    
    //Métodos não implementados...
    @Override
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   

    @Override
    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T set(int index, T element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void add(int index, T element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T remove(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int indexOf(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    @Override
    public ListIterator<T> listIterator(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    
    
}
