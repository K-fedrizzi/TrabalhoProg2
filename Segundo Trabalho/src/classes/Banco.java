
package classes;

import java.util.Collections;
import java.util.Scanner;
import lista_encadeada.Lista;

public class Banco {
    
    private Lista<Agencia> agencias;

    public Banco() {
        this.agencias = new Lista<Agencia>();
    }

    public Lista<Agencia> getAgencias() {
        return agencias;
    }

    public void setAgencias(Lista<Agencia> agencias) {
        this.agencias = agencias;
    }
    
    /*1-Virada do Mes*/
    public void viradaMes(){
        for(int i=0; i < agencias.size() ; i++){
            for(int j=0; j < agencias.get(i).getContas().size();j++){
                
                if(agencias.get(i).getContas().get(j).getCliente().getTipoCliente().equals("TRADICIONAL")){//Taxa de anuidade da conta tradicional é descontada
                   agencias.get(i).getContas().get(j).descontoTaxaTradicional();
                }
                
                if(agencias.get(i).getContas().get(j).getTipoDaConta().equals("F")){//Taxa de anuidade da Conta Fácil é descontada
                   agencias.get(i).getContas().get(j).descontarAnuidadeContaFacil();
                }
                
                if(agencias.get(i).getContas().get(j).getTipoDaConta().equals("P")){
                   agencias.get(i).getContas().get(j).rendimentoPoupanca();
                }
            }
        }
    }
    
    /*2-Cadastrar Agencia*/
    public boolean cadastrarAgencia(String nomeAgencia, String numeroAgencia,String pais, String cidade, String rua, String bairro, String cep, int numero){
        Enderenco endereco = new Enderenco(pais, cidade, rua, bairro, cep, numero);
        Agencia agencia = new Agencia(nomeAgencia, numeroAgencia, endereco);
        this.agencias.add(agencia);
        return true;
    }
    
    /*3-Abertura de Conta*/
    public boolean abrirConta(String tipoDaConta, String numeroAgencia, double saldo,String nome, String dataDeNacismento, String cpf, String tipoCliente, String pais, String cidade, String rua, String bairro, String cep, int numero){
        
        /*Conceito de Polimorfismo*/
        for(int i = 0; i < agencias.size();i++){//Buscando pelo numero da agencia para fazer o cadastro da conta
            if(numeroAgencia.equals(agencias.get(i).getNumeroAgencia())){
                 
               Conta  conta = null;
               if(tipoDaConta.equals("C")){ 
                  Enderenco endereco = new Enderenco(pais, cidade, rua, bairro, cep, numero);
                  Cliente cliente = new Cliente(nome, endereco, dataDeNacismento, cpf, tipoCliente);
                  conta = new Corrente(tipoDaConta, cliente, agencias.get(i).gerarNumeroConta(), saldo);
               }
               
               if(tipoDaConta.equals("P")){
                  Enderenco endereco = new Enderenco(pais, cidade, rua, bairro, cep, numero);
                  Cliente cliente = new Cliente(nome, endereco, dataDeNacismento, cpf, tipoCliente);
                  conta = new Poupanca(tipoDaConta, cliente, agencias.get(i).gerarNumeroConta(), saldo); 
               }
               
               if(tipoDaConta.equals("F")){
                  Cliente cliente = new Cliente(nome,null, dataDeNacismento, cpf, tipoCliente);
                  conta = new Facil(tipoDaConta, cliente,"22222", saldo);
               }
               conta.getExtrato().trasacoes(saldo,"DEPOSITO",saldo);//gerando extrato quando a conta for criada
               agencias.get(i).getContas().add(conta);
               return true;
            }
        }
        return false;
    }
    
    /*4-Saque*/
    public boolean saque(String numeroAgencia, String numeroConta, double valor ){
        for(int i = 0; i < agencias.size();i++)
        {
            if(numeroAgencia.equals(agencias.get(i).getNumeroAgencia())){
                for(int j = 0;j < agencias.get(i).getContas().size();j++){
                    if(numeroConta.equals(agencias.get(i).getContas().get(j).getNumeroConta())){
                        agencias.get(i).getContas().get(j).sacaDinheiro(valor);
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    /*5-Deposito em Conta*/
    public boolean depositar(String numeroAgencia, String numeroConta, double valor ){
        for(int i = 0; i < agencias.size();i++)
        {
            if(numeroAgencia.equals(agencias.get(i).getNumeroAgencia())){
                for(int j = 0;j < agencias.get(i).getContas().size();j++){
                    if(numeroConta.equals(agencias.get(i).getContas().get(j).getNumeroConta())){
                        agencias.get(i).getContas().get(j).depositarDinheiro(valor);
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    /*6-Transferencia*/
    public boolean transferencia(String agenciaOrigem, String contaOrigem, String agenciaDestino, String contaDestino,double valor ){
       
        int i=0;  int j=0; int k=0; int l=0;
        boolean achou = false;//verifica se achou o indice da busca
        for(i = 0; i < agencias.size();i++){//Busca a Agencia e Conta Origem
            if(agenciaOrigem.equals(agencias.get(i).getNumeroAgencia())){
               for(j = 0 ;j < agencias.get(i).getContas().size();j++){
                   if(contaOrigem.equals(agencias.get(i).getContas().get(j).getNumeroConta())){  
                      achou = true;
                      break;
                   }
               }
               if(achou){ achou = false; break;}
            }
        }
        achou = false; 
        for(k = 0; k < agencias.size();k++){//Busca a Agencia e Conta Destino
            if(agenciaDestino.equals(agencias.get(k).getNumeroAgencia())){
               for(l = 0;l < agencias.get(k).getContas().size();l++){
                   if(contaDestino.equals(agencias.get(k).getContas().get(l).getNumeroConta())){
                      achou = true;
                      break;
                   }
               }
               if(achou){ achou = false; break;}
            }
        }
        agencias.get(i).getContas().get(j).transferirDinheiro(agencias.get(i).getContas().get(j),agencias.get(k).getContas().get(l), valor);//Com indices i j k e l atualizados, é realizada a transferência.
        return true;
    }
    
    /*7-Gerar Extratos*/
    public String gerandoExtrato(String numeroAgencia,String numeroConta){
        
          for(int i = 0; i < agencias.size();i++)
          {
            if(numeroAgencia.equals(agencias.get(i).getNumeroAgencia())){
                for(int j = 0;j < agencias.get(i).getContas().size();j++){
                    if(numeroConta.equals(agencias.get(i).getContas().get(j).getNumeroConta())){
                        return agencias.get(i).getContas().get(j).getExtrato().getTrasacao();    
                    }
                }
            }
        }
        return "";
    }
    
    /*8-Gerar Relatorios*/
    public void gerarRelatorio(){
        
        System.out.println("\n\n                    RELATÓRIO DE TODAS AS AGENCIAS, CLIENTES E CONTAS\n\n");
        System.out.println("\n1: LISTA DE TODAS AS AGENCIAS ORDENADAS PELO NUMERO E PELO NUMERO DA CONTA\n\n");
        
        ComparadorAgencia comparaAgencia = new ComparadorAgencia();
        Collections.sort(agencias,comparaAgencia);//Ordena todas as agencias
        
        ComparadorConta comparaConta = new ComparadorConta("NUMERO");
        for(int i=0; i < agencias.size(); i++ ){
            for(int j=0; j < agencias.get(i).getContas().size(); j++){
                Collections.sort(agencias.get(i).getContas(),comparaConta);//Ordena pelo numero da Conta
            }
        }
        System.out.println(agencias);
        
        System.out.println("\n2: LISTA TODAS AS CONTAS ORENADAS PELO NOME DO CLIENTE\n\n");
        
        ComparadorConta comparaConta2 = new ComparadorConta("NOME");
        for(int i=0; i < agencias.size(); i++ ){
            for(int j=0; j < agencias.get(i).getContas().size(); j++){
                Collections.sort(agencias.get(i).getContas(),comparaConta2);//Ordena pelo numero da Conta
            }
        }
        
        for(int i = 0; i < agencias.get(i).getContas().size(); i++){//Mostra todas as contas ordenadas pelo nome
            System.out.println(agencias.get(i).getContas());
        }
        
                
        System.out.println("\n2: LISTA TODOS OS CLIENTES QUE POSSUEM MAIS DE UMA CONTA\n\n");
        Scanner ler = new Scanner(System.in);
        System.out.print("Informe o CPF do Cliente: ");
        String cpf = ler.nextLine();//Informa o CPF do Cliente
        int cont=0;
        for(int i=0; i < agencias.size(); i++ ){//Verifica pelo numero do CPF se este cliente possui mais de uma conta
            for(int j=0; j < agencias.get(i).getContas().size(); j++){
               if(cpf.equals(agencias.get(i).getContas().get(j).getCliente().getCpf())){
                   System.out.println(agencias.get(i).getContas().get(j)); 
                   cont++;
               }
            }
        }
        System.out.println("\n\nO Cliente possui "+cont+" contas\n\n");
    }
    
    /*9-Fechar Conta*/
    public boolean fecharConta(String numeroAgencia, String numeroConta){
         for(int i = 0; i < agencias.size();i++)
         {
            if(numeroAgencia.equals(agencias.get(i).getNumeroAgencia())){
                for(int j = 0;j < agencias.get(i).getContas().size();j++){
                    if(numeroConta.equals(agencias.get(i).getContas().get(j).getNumeroConta())){
                        agencias.get(i).getContas().remove(j);
                        return true;
                    }
                }
            }
         }
         return false;
    }
    
}
