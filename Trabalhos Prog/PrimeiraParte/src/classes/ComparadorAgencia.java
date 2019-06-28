
package classes;

import java.util.Comparator;


public class ComparadorAgencia implements  Comparator<Agencia>{
    
    @Override
    public int compare(Agencia o1, Agencia o2) {
      
           return o1.getNumeroAgencia().compareTo(o2.getNumeroAgencia());
       
    }
     
    
}
