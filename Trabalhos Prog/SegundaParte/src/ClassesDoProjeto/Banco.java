
package ClassesDoProjeto;

import ListaEncadeada.Lista;

import java.util.List;

public class Banco{
    
    private Lista<Agencia> agencias;

    public Banco() {
        
        this.agencias  = new  Lista<Agencia>();
        
    }
    
    /*1 - Virada do Mês*/
    public void viradaMes(){ //Método para o desconto das taxas
        
         for(int i = 0 ; i < agencias.size() ; i++){ //vai procurar os clientes e fazer todos os descontos e rendimentos possíveis dependendo do tipo da conta
             
             int j=0;
             while(j < agencias.get(i).getContas().size()){
                 
                    if(agencias.get(i).getContas().get(j).getCliente().getTipoCliente().equals("TRADICIONAL")){ //Se for cliente Tradicional a taxa anual de 15 $ é descontada
                       agencias.get(i).getContas().get(j).descontoTaxaTradicional();
                       agencias.get(i).getContas().get(j).getExtrato().transacao(-15,"AnuidadeTradicional");
                    }
                          
                    if( agencias.get(i).getContas().get(j).getTipoConta().equals("F")){ //Se for conta fácil, será descontada uma taxa de anuidade de 10 $
                        agencias.get(i).getContas().get(j).descontoAnuidadeContaFácil();
                        agencias.get(i).getContas().get(j).getExtrato().transacao(-10,"AnuidadeContaFacil");
                    }
                          
                    if( agencias.get(i).getContas().get(j).getTipoConta().equals("P")){ //Se for conta Poupança, terá um rendimento de 1.4% do valor $ depositado.
                        agencias.get(i).getContas().get(j).descontoAnuidadeContaFácil();
                        agencias.get(i).getContas().get(j).getExtrato().transacao((1.4/ 100) *  agencias.get(i).getContas().get(i).getSaldo(),"RendimentoPoupanca"); //Calculo do Rendimento (1.4 / 100) * saldo
                    }     
                    j++;
             }
         }
    }
    
    /*2 - Cadastrar Agência*/
    public boolean cadastrarAgencia(String nomeAgencia, String numeroAgencia, String pais, String cidade, String rua, String bairro,String cep,int numero){
        
        Agencia agencia = new Agencia(nomeAgencia,numeroAgencia,pais,cidade, rua,bairro,cep,numero);
        agencias.add(agencia);
        return true;
        
    }
    
    /*3 - Abertura de Conta*/
    public boolean abrirConta(String tipoConta, String cpf, String nome, String pais,  String cidade, String rua, String bairro, String cep, int numero, String dataNasc,  String tipoCliente, String numeroAgencia, double valorInicial ){
        
        for(int i = 0 ; i < agencias.size() ; i++){ //procura a numeroAgencia que vai abrir a conta
             if(agencias.get(i).getNumeroAgencia().equals(numeroAgencia)){ //verifica  o numero da agencia que vai abrir a conta
                agencias.get(i).abrirConta(tipoConta, cpf, nome, pais, cidade, rua, bairro, cep, numero, dataNasc, tipoCliente, valorInicial); 
                return true;
             }
        }
        return false;
        
    }
    
    /*4 - Saque*/
    public float saque(String agencia, String numeroConta,  double  valor){
        
      for(int i = 0 ; i < agencias.size() ; i++){ //procura a agencia que vai sacare o valor  da conta
             if(agencias.get(i).getNumeroAgencia().equals(agencia)){
                  int j = 0;
                  while(j < agencias.get(i).getContas().size()){
                           if(agencias.get(i).getContas().get(j).getNumeroConta().equals(numeroConta)){
                               agencias.get(i).getContas().get(j).sacarDinheiro(valor);
                               agencias.get(i).getContas().get(j).getExtrato().transacao(valor, "Saque");
                               break;
                           }
                           j++;
                  }
             }
        }
     
        return 0;
    }
    
    /*5 - Depósito em Conta*/
    public boolean depositar(String agencia, String numeroConta,  double valor){
        
         for(int i = 0 ; i < agencias.size() ; i++){ //procura a agencia que vai sacare o valor  da conta
             if(agencias.get(i).getNumeroAgencia().equals(agencia)){
                int j = 0;
                while(j < agencias.get(i).getContas().size()){
                      if(agencias.get(i).getContas().get(j).getNumeroConta().equals(numeroConta)){
                               
                         if(agencias.get(i).getContas().get(i).getTipoConta().equals("F")){
                                   
                            if(valor > 500000){ //Analiza se o valor depositado é maior que 5000.00
                               System.out.println("O máximo de Depósito permitido para esta conta é 5.000.00");
                               break;
                            }
                                      
                            if(agencias.get(i).getContas().get(j).getSaldo() < 500000){ //Analiza se o limite de depósito  de  500000 não foi atingido
                               agencias.get(i).getContas().get(j).depositarDinheiro(valor);
                            }else{
                               System.out.println("Limite de depósito atingido, não foi possível realizar o depósito");
                            }     
                         }                              
                         agencias.get(i).getContas().get(j).getExtrato().transacao(valor, "Deposito");
                         break;
                      }
                      j++;
                }
             }
        }
        return true;
        
    }
    
    /*6 - Transferência*/
    public boolean transferencia(String agenciaOrigem, String contaOrigem, String agenciaDestino, String contaDestino, double valor){
        
            for(int i = 0 ; i < agencias.size() ; i++){ //procura a agencia  e a conta de Origem que vai transferir o valor
                if(agencias.get(i).getNumeroAgencia().equals(agenciaOrigem)){
                   int j = 0;
                   while(j < agencias.get(i).getContas().size()){
                         if(agencias.get(i).getContas().get(j).getNumeroConta().equals(contaOrigem)){
                            agencias.get(i).getContas().get(j).sacarDinheiro(valor);
                            agencias.get(i).getContas().get(j).getExtrato().transacao(valor,"Transferencia");
                         }
                         j++;
                   }
                }
            } 
           
            for(int i = 0 ; i < agencias.size() ; i++){ //procura a agencia  e a conta Destino que vai Receber o valor Transferido
                if(agencias.get(i).getNumeroAgencia().equals(agenciaOrigem)){
                   int j = 0;
                   while(j < agencias.get(i).getContas().size()){
                         if(agencias.get(i).getContas().get(j).getNumeroConta().equals(contaOrigem)){
                            agencias.get(i).getContas().get(j).depositarDinheiro(valor);
                         }
                         j++;
                    }
                }
           } 
           return true;   
    }
    
    /*7 - Gerar Extratos*/
    public String gerarExtratos(String numeroAgencia, String conta){
         for(int i = 0 ; i < agencias.size() ; i++){ //procura a agencia  e a conta Destino que vai gerar o extrato
               if(agencias.get(i).getNumeroAgencia().equals(numeroAgencia)){
                    int j = 0;
                    while(j < agencias.get(i).getContas().size()){
                             if(agencias.get(i).getContas().get(j).getNumeroConta().equals(conta)){
                                 return  agencias.get(i).getContas().get(j).getExtrato().getTransacoes();
                             }
                             j++;
                    }
               }
         } 
         return "Não há transacoes";
    }
    
    /*8 - Gerar Relatórios*/
    public void gerarRelatorios(  ){
        
        System.out.println("\n\n          RELATÓRIO DE TODAS AS AGÊNCIAS, CLIENTES E CONTAS\n\n");   
        System.out.println("\n\n1: LISTA TODAS AS AGENCIAS ORDENADAS PELO NUMERO E PELO NUMERO DA CONTA\n\n\n");
        
        //////////////////////
        
        
        System.out.println(agencias);
        
        
        /////////////////////
        
      
        for(int i = 0 ; i <  agencias.size() ; i++){
          
        }
        
        System.out.println(agencias);
       
        System.out.println("\n\n2: LISTA TODAS AS CONTAS ORDENADAS PELO NOME DO CLIENTE\n\n\n");
        
       
        for(int  i = 0 ; i <  agencias.size() ; i++){
            if(agencias.get(i).getContas().size() != 0){
              
            }
        }
        
        for(int i = 0 ; i < agencias.size() ; i++){
            System.out.println(agencias.get(i).getContas());  
        }    
    }

    /*Encapsulamentos*/
    public Lista<Agencia> getAgencias() {
        return agencias;
    }

    public void setAgencias(Lista<Agencia> agencias) {
        this.agencias = agencias;
    }


   }
   