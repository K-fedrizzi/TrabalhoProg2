
package classes;

import java.util.Comparator;

public class ComparadorConta implements Comparator<Conta>{
    String compara;
     
    public ComparadorConta(String compara) {
        this.compara = compara;
    }
    
    @Override
    public int compare(Conta o1, Conta o2) {
       if(compara.equals("NUMERO")){
          return o1.getNumeroConta().compareTo(o2.getNumeroConta());
       }
       return o1.getCliente().getNome().compareTo(o2.getCliente().getNome());
    }
    
}
