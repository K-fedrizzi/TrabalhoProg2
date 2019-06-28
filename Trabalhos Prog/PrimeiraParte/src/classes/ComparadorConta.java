
package classes;

import java.util.Comparator;

public class ComparadorConta implements Comparator<Conta> {
      String comparador;
      final String cliente     = "CLIENTE";
      final String numero  = "NUMERO";

    public ComparadorConta(String comparador) {
        this.comparador = comparador;
    }

    public String getComparador() {
        return comparador;
    }

    public void setComparador(String comparador) {
        this.comparador = comparador;
    }
      
    @Override
    public int compare(Conta o1, Conta o2) {
        
          if(this.comparador.equals(cliente)){
              return o1.getCliente().getNome().compareToIgnoreCase(o2.getCliente().getNome());
          }
 
          return o1.getNumeroConta().compareToIgnoreCase(o2.getNumeroConta());
    }
    
}
