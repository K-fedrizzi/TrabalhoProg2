
package classes;


public class Enderenco {
    private String pais;
    private String cidade;
    private String rua;
    private String bairro;
    private String cep;
    private int numero;
    
    public Enderenco(String pais, String cidade, String rua, String bairro, String cep, int numero) {
        this.pais = pais;
        this.cidade = cidade;
        this.rua = rua;
        this.bairro = bairro;
        this.cep = cep;
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    @Override
    public String toString() {
        return "                            Enderenco{" + "pais=" + pais + ", cidade=" + cidade + ", rua=" + rua + ", bairro=" + bairro + ", cep=" + cep + ", numero=" + numero + '}';
    }
   
    
    
}
