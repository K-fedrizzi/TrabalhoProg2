
package classes;


public class Conta {
    
    private String tipoDaConta;
    private Cliente cliente;
    private String numeroConta;
    private double   saldo;
    private Extrato extrato;
    
    public Conta(String tipoDaConta, Cliente cliente, String numeroConta, double saldo) {
        this.tipoDaConta = tipoDaConta;
        this.cliente = cliente;
        this.saldo = saldo;
        this.extrato = new Extrato();
        this.numeroConta = numeroConta;
    }
    
    public boolean clinteTemConta( String cpf){
        if(cliente.getCpf().equals(cpf)){
            return true;
        }
        return false;
    } 

    public boolean depositarDinheiro(double dinheiro){
        
       if(this.tipoDaConta.equals("F") && this.saldo < 5000 && dinheiro < 5000 && dinheiro + saldo < 5000){ //A conta fácil tem limite de depósito R$ 5.000.000
          saldo += dinheiro;
          extrato.trasacoes(dinheiro,"DEPOSITO",this.saldo);
          return true;
       }
       
       if(this.tipoDaConta.equals("P") || this.tipoDaConta.equals("C")){
          saldo += dinheiro;
          extrato.trasacoes(dinheiro,"DEPOSITO",this.saldo);
          return true;
       }
       return false; 
    }
   
    public boolean sacaDinheiro(double dinheiro){ //Foi tratada a execessão de saque maior que o limite do valor da conta
        try {
             if(dinheiro < this.saldo){
                this.saldo -= dinheiro;
                extrato.trasacoes(dinheiro,"SAQUE",this.saldo);
                return true;  
             } 
        } catch (Exception e) {
                 System.err.println("O valor insuficiente na conta");
        }
        return false;
    }
    
    public void descontoTaxaTradicional(){
        if(this.cliente.getTipoCliente().equals("TRADICIONAL")){ //Desconto realizado sópara clientes do tipo TRADICIONAL
          this.saldo -= 15;
          extrato.trasacoes(15,"ANUIDADETRADICIONAL",this.saldo); 
        }  
    }
    
    public void transferirDinheiro( Conta a , Conta b, double valor){
          a.saldo -= valor;
          b.saldo += valor;
          a.extrato.trasacoes(valor,"TRANSFERENCIA",a.saldo);
          b.extrato.trasacoes(valor,"TRANSFERENCIA",b.saldo); 
    }
    
    public void descontarAnuidadeContaFacil(){
        this.saldo -= 10;
        extrato.trasacoes(15,"ANUIDADECONTAFACIL",this.saldo);
    }
    
    public void rendimentoPoupanca(){
        this.saldo +=   ((1.4/100) * this.saldo) + this.saldo;
        extrato.trasacoes(((1.4/100) * this.saldo),"RENDIMENTOPOUPANCA",this.saldo);
    }
    
    //Getters e Setters

    @Override
    public String toString() {
        return "\n                     Conta{" + "\n                            tipoDaConta=" + tipoDaConta + ",\n                            " + cliente + ",\n                            numeroConta=" + numeroConta + ",\n                            saldo=" + saldo +"\n                     }";
    }
    
   

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public String getTipoDaConta() {
        return tipoDaConta;
    }

    public void setTipoDaConta(String tipoDaConta) {
        this.tipoDaConta = tipoDaConta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Extrato getExtrato() {
        return extrato;
    }

    public void setExtrato(Extrato extrato) {
        this.extrato = extrato;
    }
      
}
