
package classes;


public class Cliente {
   private String nome;
   private Enderenco enderenco;
   private String dataDeNacismento;
   private String cpf;
   private String tipoCliente;

    public Cliente(String nome, Enderenco enderenco, String dataDeNacismento, String cpf, String tipoCliente) {
        this.nome = nome;
        this.enderenco = enderenco;
        this.dataDeNacismento = dataDeNacismento;
        this.cpf = cpf;
        this.tipoCliente = tipoCliente;
    }

    public String getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Enderenco getEnderenco() {
        return enderenco;
    }

    public void setEnderenco(Enderenco enderenco) {
        this.enderenco = enderenco;
    }

    public String getDataDeNacismento() {
        return dataDeNacismento;
    }

    public void setDataDeNacismento(String dataDeNacismento) {
        this.dataDeNacismento = dataDeNacismento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "Cliente{" + "nome=" + nome + ", enderenco=" + enderenco + ", dataDeNacismento=" + dataDeNacismento + ", cpf=" + cpf + ", tipoCliente=" + tipoCliente + '}';
    }
    
   
}
