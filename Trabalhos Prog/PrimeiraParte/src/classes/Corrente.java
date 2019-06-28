
package classes;

public class Corrente extends Conta{

    public Corrente(String numeroConta, double saldo, Cliente cliente,String tipoConta) {
        super(numeroConta, saldo, cliente, tipoConta);
    }

   public float taxa(){
       return 0;
   } 
}
