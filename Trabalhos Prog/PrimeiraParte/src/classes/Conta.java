
package classes;

public class Conta {
    private String   tipoConta;
    private Cliente cliente ;
    private String numeroConta;
    private double saldo;
    private  Extrato extrato; //Capaz de guardar os extratos da conta
  
    public Conta(String numeroConta, double saldo, Cliente cliente, String tipoConta) {
        this.tipoConta = tipoConta;
        this.cliente = cliente;
        this.numeroConta = numeroConta;
        this.saldo = saldo;
        extrato = new Extrato( );
        extrato.transacao(saldo, "Deposito");
    }
    
    public void rendimentoPoupanca(){
        double rendimento = (1/100) * this.saldo;
        this.saldo += rendimento; 
    }
     
     public void descontoTaxaTradicional(){
         this.saldo -= 15;
     }
    
     public void descontoAnuidadeContaFácil(){
        this.saldo -= 10;    
     }
    
    public void depositarDinheiro(double valor){
         saldo += valor;
    }
    
    public double sacarDinheiro(double valor){
        if(valor >= saldo){
            saldo -= valor;
            return valor;
        }else{
            return 0;
        }
    }
   
    //encapsulamento
    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setnumeroConta(String conta) {
        this.numeroConta = conta;
    }

    @Override
    public String toString() {
        return "\n"+cliente + "\n          numeroConta: " + numeroConta + "\n          saldo: " + saldo + '}'+"\n";
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Extrato getExtrato() {
        return extrato;
    }

    public void setExtrato(Extrato extrato) {
        this.extrato = extrato;
    }

    public String getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(String tipoConta) {
        this.tipoConta = tipoConta;
    }

    
    
}
