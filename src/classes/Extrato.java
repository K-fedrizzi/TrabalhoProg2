
package classes;

public class Extrato {

    private String trasacao;
    
    public Extrato() {
       trasacao = "";
    }
    /*Fazer Registros das transacoes de Contas*/
    
    public void trasacoes(double valor, String tipo, double saldo){
        
        if(tipo.equals("DEPOSITO")){ // Trasacao de deposito
            this.trasacao += "DEPOSITO "+ valor+"\n"+"SALDO "+saldo+"\n";
        }
       
        if(tipo.equals("SAQUE")){//Trasacao de Saque do valor da conta
            this.trasacao += "SAQUE -"+valor+"\n"+"SALDO "+saldo+"\n";
        }
        
        if(tipo.equals("TRANSFERENCIA")){ // Trasacao de transferencia
            this.trasacao += "TRANSFERENCIA "+ valor+"\n"+"SALDO "+saldo+"\n";
        }
        
        if(tipo.equals("ANUIDADETRADICIONAL")){
            this.trasacao += "ANUIDADE DA CONTA TRADICIONAL -"+ valor+"\n"+"SALDO "+saldo+"\n";
        }
        
        if(tipo.equals("ANUIDADECONTAFACIL")){
            this.trasacao += "ANUIDADE DA CONTA FACIL -"+ valor+"\n"+"SALDO "+saldo+"\n";
        }
        
        if(tipo.equals("RENDIMENTOPOUPANCA")){
            this.trasacao += "RENDIMENTO DA CONTA POUPANCA "+ valor+"\n"+"SALDO "+saldo+"\n";
        }
        
        if(tipo.equals("DESCONTOTAXACONTACORRENTE")){
            this.trasacao += "TAXA DA CONTA CORRENTE "+ valor+"\n"+"SALDO "+saldo+"\n";
        }
         
    }
    
    public String getTrasacao() {
        return trasacao;
    }

    public void setTrasacao(String trasacao) {
        this.trasacao = trasacao;
    }

    @Override
    public String toString() {
        return "Extrato{\n" + "trasacao=\n" + trasacao;
    }
    
    
}
