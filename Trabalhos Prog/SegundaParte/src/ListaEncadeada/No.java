
package ListaEncadeada;


public class No<T> {
            private T  elemento;
            private No prox;

    public No(T elemento) {
        this.elemento = elemento;
    }

    @Override
    public String toString() {
        return elemento + "->" + prox ;
    }

    public T getElemento() {
        return elemento;
    }

    public void setElemento(T elemento) {
        this.elemento = elemento;
    }

    public No getProx() {
        return prox;
    }

    public void setProx(No prox) {
        this.prox = prox;
    }
            
}
