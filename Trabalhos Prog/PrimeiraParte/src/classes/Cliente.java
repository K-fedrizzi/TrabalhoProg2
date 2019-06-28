
package classes;

public class Cliente {
    private String nome;
    private Endereco endereco;
    private String  dataNasc;
    private String cpf;
    private String tipoCliente;

    public Cliente(String cpf,  String nome,  String pais,  String cidade,  String rua,  String bairro, String cep, int numero, String dataNasc, String tipoCliente) {
        this.nome = nome;
        this.endereco = new Endereco(pais, cidade, rua, bairro, cep, numero);
        this.dataNasc = dataNasc;
        this.cpf = cpf;
        this.tipoCliente = tipoCliente;
    }

    @Override
    public String toString() {
        return "          Cliente{\n" + "               nome: " + nome + "\n               dataNasc: " + dataNasc + "\n               cpf: " + cpf + "\n               tipoCliente: " + tipoCliente + "\n" + endereco +"          ";
    }

    
    //encapsulamento
    public boolean consultarCPF(String cpf){
        if(this.cpf.equals(cpf)){
            return true;
        }else{
            return false;
        }
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
      
}
