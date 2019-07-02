
package classes;

import java.util.LinkedList;
import java.util.List;


public class Agencia {
    private String nomeAgencia;
    private String numeroAgencia;
    private Enderenco enderenco;
    private int numero;
    
    private List<Conta> contas;

    public Agencia(String nomeAgencia, String numeroAgencia, Enderenco enderenco) {
        this.nomeAgencia = nomeAgencia;
        this.numeroAgencia = numeroAgencia;
        this.enderenco = enderenco;
        this.contas = new LinkedList<Conta>();
        this.numero = 0;
    }
    
    public String gerarNumeroConta(){
        
        numero++;//Gerar numero da conta
        
        int dividendo = numero;
        int quantidadedeDigito=0;
        while(dividendo != 0){//Conta quantos digitos tem o numero que foi gerado
            quantidadedeDigito++;
            dividendo = dividendo/10; 
        }
        
        String str;
        if(quantidadedeDigito == 1){//concatena 4 zero a esquerda se o numero 1 digito
            return str ="0000"+numero; 
        }
        
        if(quantidadedeDigito == 2){//concatena 3 zero a esquerda se o numero 2 digito
            return str ="000"+numero; 
        }
        
         
        if(quantidadedeDigito == 3){//concatena 2 zero a esquerda se o numero 3 digito
            return str ="00"+numero; 
        }
        
        if(quantidadedeDigito == 4){//concatena 1 zero a esquerda se o numero 4 digito
            return str ="0"+numero; 
        }
        return str = ""+numero; 
    }

    public List<Conta> getContas() {
        return contas;
    }

    public void setContas(List<Conta> contas) {
        this.contas = contas;
    }

    public String getNomeAgencia() {
        return nomeAgencia;
    }

    public void setNomeAgencia(String nomeAgencia) {
        this.nomeAgencia = nomeAgencia;
    }

    public String getNumeroAgencia() {
        return numeroAgencia;
    }

    public void setNumeroAgencia(String numeroAgencia) {
        this.numeroAgencia = numeroAgencia;
    }

    public Enderenco getEnderenco() {
        return enderenco;
    }

    public void setEnderenco(Enderenco enderenco) {
        this.enderenco = enderenco;
    }

    @Override
    public String toString() {
        return "\n   Agencia{\n"+"            nomeAgencia=" + nomeAgencia + ",\n            numeroAgencia=" + numeroAgencia + ",\n            " + enderenco + ",\n            contas=" + contas + "\n   }";
    }
   
    
}
