
package classes;

public class Extrato {
    
 private String transacoes;

     public Extrato() {
        transacoes  = "";  
     }

     public void transacao(double Transacao, String tipo){
        
         if(tipo.equals("Deposito")){
            this.transacoes += "DEPOSITO "+ Transacao+"\n";
        }
        
        if(tipo.equals("Saque")){
            this.transacoes +=  "SAQUE "+Transacao+"\n";
         }
          
        if(tipo.equals("Transferencia")){
            this.transacoes += "TRANSFERENCIA "+ Transacao+"\n";
        }
        
       if(tipo.equals("AnuidadeTradicional")){
            this.transacoes += "ANUIDADE CONTA TRADICIONAL  "+ Transacao+"\n";
       }
       
       if(tipo.equals("AnuidadeContaFacil")){
            this.transacoes += "ANUIDADE CONTA FACIL  "+ Transacao+"\n";
       }
       
        if(tipo.equals("RendimentoPoupanca")){
            this.transacoes += "RENDIMENTO  "+ Transacao+"\n";
       }
        
    }
    
    public String getTransacoes() {
        return transacoes;
    }

    public void setTransacoes(String Transacoes) {
        this.transacoes = Transacoes;
    }
 
}
