
package main;

import classes.Banco;
import java.util.Scanner;


public class Main {
    
    public static void main(String[] args) {  
        
        Scanner ler = new Scanner(System.in);
        Banco   banco = new Banco();
       
        int op = 0;
        while(op != 10){
            
           System.out.print("Informe a Opcao: ");
           op  = ler.nextInt(); ler.nextLine();
           
           switch(op){
           
               case 1: //Virada do Mês
                   
                   banco.viradaMes();
                   break;
               
               case 2://Cadastrar Agencia
                   
                   /*Dados Pré-Cadastrados*/
                   
                   String nomeAgencia          = "Banco do Brasil";
                   String numeroAgencia        = "2224";
                   String pais                 = "Brasil";
                   String cidade               = "Campo Grande(MS)";
                   String rua                  = "Rua Afonso Pena";
                   String bairro               = "Centro";
                   String cep                  = "000000";
                   int  numero                 = 222; 
                   banco.cadastrarAgencia(nomeAgencia, numeroAgencia, pais, cidade, rua, bairro, cep, numero);
                   
                   nomeAgencia                 = "Banco Bradesco";
                   numeroAgencia               = "2422";
                   pais                        = "Brasil";
                   cidade                      = "Campo Grande(MS)";
                   rua                         = "Rua Afonso Pena";
                   bairro                      = "Centro";
                   cep                         = "000000";
                   numero                      = 222; 
                   banco.cadastrarAgencia(nomeAgencia, numeroAgencia, pais, cidade, rua, bairro, cep, numero);
                   
                   nomeAgencia                 = "Banco Santander";
                   numeroAgencia               = "1129";
                   pais                        = "Brasil";
                   cidade                      = "Campo Grande";
                   rua                         = "Rua Afonso Pena";
                   bairro                      = "Centro";
                   cep                         = "000000";
                   numero                      = 224; 
                   banco.cadastrarAgencia(nomeAgencia, numeroAgencia, pais, cidade, rua, bairro, cep, numero);
                   
                  /* 
                   System.out.print("Nome da Agencia: ");
                   String nomeAgencia     = ler.nextLine();
                   System.out.print("Numero da  Agencia: ");
                   String numeroAgencia   = ler.nextLine();
                   System.out.print("País: ");
                   String pais            = ler.nextLine();
                   System.out.print("Cidade: ");
                   String cidade          = ler.nextLine();
                   System.out.print("Rua: ");
                   String rua = ler.nextLine();
                   System.out.print("Bairro: ");
                   String bairro          = ler.nextLine();
                   System.out.print("CEP: ");
                   String cep             = ler.nextLine();
                   System.out.print("Numero: ");
                   int  numero            = ler.nextInt(); 
                   banco.cadastrarAgencia(nomeAgencia, numeroAgencia, pais, cidade, rua, bairro, cep, numero);
                   */
                   break;
                   
               case 3://Abertura de Conta
                    
                   /*Dados Pré-Cadastrados*/
                   
                     String tipoConta         = "C";
                     String cpf               = "999999-9";
                     String nome              = "Juvenal Antunes Rodrigues";
                     pais                     = "Brasil";
                     cidade                   = "Campo Grande(MS)";
                     rua                      = "Rua dos Cocais";
                     bairro                   = "Santa Rita";
                     cep                      = "000000-0";
                     numero                   = 11;
                     String dataNasc          = "27/08/1986";
                     String tipoCliente       = "TRADICIONAL";
                     String agencia           = "2224";
                     double depositoInicial   = 1500;
                     banco.abrirConta(tipoConta, cpf, nome, pais, cidade, rua, bairro, cep, numero, dataNasc, tipoCliente, agencia, depositoInicial);
                     
                     tipoConta                = "P";
                     cpf                      = "888888-8";
                     nome                     = "Antonio da Costa Pereira";
                     pais                     = "Brasil";
                     cidade                   = "Campo Grande(MS)";
                     rua                      = "Rua Rocha Pires";
                     bairro                   = "Vila Olinda";
                     cep                      = "000000-0";
                     numero                   = 14;
                     dataNasc                 = "30/08/1986";
                     tipoCliente              = "PREMIUM";
                     agencia                  = "2224";
                     depositoInicial          = 1000;
                     banco.abrirConta(tipoConta, cpf, nome, pais, cidade, rua, bairro, cep, numero, dataNasc, tipoCliente, agencia, depositoInicial);
                     
                     tipoConta                = "F";
                     cpf                      = "222222-2";
                     nome                     = "Julia Santana de Souza";
                     pais                     = "Brasil";
                     cidade                   = "Campo Grande(MS)";
                     rua                      = "Rua Madeira";
                     bairro                   = "Vila Progresso";
                     cep                      = "000000-0";
                     numero                   = 14;
                     dataNasc                 = "30/09/2000";
                     tipoCliente              = "FACIL";
                     agencia                  = "2224";
                     depositoInicial          = 1100;
                     banco.abrirConta(tipoConta, cpf, nome, pais, cidade, rua, bairro, cep, numero, dataNasc, tipoCliente, agencia, depositoInicial);
                     
                     /*
                     System.out.print("Tipo da conta:  ");
                     String tipoConta =  ler.nextLine();
                     System.out.print("CPF:  ");
                     String cpf = ler.nextLine();
                     System.out.print("Nome:  ");
                     String nome =  ler.nextLine();
                     System.out.print("País:  ");
                     pais = ler.nextLine();
                     System.out.print("Cidade:  ");
                     cidade = ler.nextLine();
                     System.out.print("Rua:  ");
                     rua = ler.nextLine();
                     System.out.print("Bairro:  ");
                     bairro = ler.nextLine();
                     System.out.print("Cep:  ");
                     cep = ler.nextLine();
                     System.out.print("Numero:  ");
                     numero = ler.nextInt();  ler.nextLine();
                     System.out.print("Data de Nascimento:  ");
                     String dataNasc = ler.nextLine();
                     System.out.print("Tipo do Cliente:  ");
                     String tipoCliente = ler.nextLine();
                     System.out.print("Numero da Agencia:  ");
                     String agencia = ler.nextLine();
                     System.out.print("Valor Inicial a ser Depositado:  ");
                     double depositoInicial = ler.nextDouble();
                     banco.abrirConta(tipoConta, cpf, nome, pais, cidade, rua, bairro, cep, numero, dataNasc, tipoCliente, agencia, depositoInicial);
                     */
                   break;
                   
               case 4://Saque
                   
                   /*Dados Pré-Cadastrados*/
                   
                   agencia                = "2224";
                   String conta           = "00001";
                   double valor           = 100;
                   banco.saque(agencia, conta, valor);
                   
                   agencia                = "2224";
                   conta                  = "00002";
                   valor                  = 100;
                   banco.saque(agencia, conta, valor);
                   
                   agencia                = "2224";
                   conta                  = "00003";
                   valor                  = 100;
                   banco.saque(agencia, conta, valor);
                   
                   
                   /*
                   System.out.print("Agencia: ");
                   agencia = ler.nextLine();
                   System.out.print("Conta:  ");
                   String conta = ler.nextLine();
                   System.out.print("Valor:  ");
                   double valor =  ler.nextDouble();
                   banco.saque(agencia, conta, valor);
                   */
                   break;
                   
               case 5://Depósito em Conta
                   
                   /*Dados Pré-Cadastrados*/
                   
                   agencia           = "2224";
                   conta             = "00001";
                   valor             = 100;
                   banco.depositar(agencia, conta, valor);
                   
                   agencia           = "2224";
                   conta             = "22222";
                   valor             = 100;
                   banco.depositar(agencia, conta, valor);
                   
                   agencia           = "2224";
                   conta             = "00003";
                   valor             = 100;
                   banco.depositar(agencia, conta, valor);
                   
                   /*
                   System.out.print("Agencia: ");
                   agencia = ler.nextLine();
                   System.out.print("Conta:  ");
                   conta = ler.nextLine();
                   System.out.print("Valor:  ");
                   valor =  ler.nextDouble();
                   banco.depositar(agencia, conta, valor);
                   */
                   break;
                   
               case 6: //Transferência
                   
                   /*Dados Pre-Cadrastrados*/
                   
                   agencia                = "2224";
                   conta                  = "00001";
                   String agenciaDestino  = "2224";
                   String contaDestino    = "00002";
                   valor                  = 100;
                   banco.transferencia(agencia, conta, agenciaDestino, contaDestino,valor);
                    
                   /* 
                   System.out.print("Agencia Origem: ");
                   agencia = ler.nextLine();
                   System.out.print("Conta Origem: ");
                   conta = ler.nextLine();
                   System.out.print("Agencia Destino: ");
                   String agenciaDestino = ler.nextLine();
                   System.out.print("Conta Destino: ");
                   String contaDestino = ler.nextLine();
                   System.out.print("Valor: ");
                   valor = ler.nextDouble();
                   banco.transferencia(agencia, conta, agenciaDestino, contaDestino,valor);
                   */ 
                   break;
                   
               case 7: //Gerar Extratos
                   
                   /*Dados Pre-Cadastrados*/
                  
                   System.out.println("Extrato da Primeira Conta\n");
                   agencia  = "2224";
                   conta       = "00001";
                   System.out.println( banco.gerarExtratos(agencia, conta));
                   
                   System.out.println("\nExtrato da Segunda Conta\n");
                   agencia  = "2224";
                   conta       = "00002";
                   System.out.println( banco.gerarExtratos(agencia, conta));
                   
                   System.out.println("\nExtrato da Terceira  Conta\n");
                   agencia  = "2224";
                   conta       = "00003";
                   System.out.println( banco.gerarExtratos(agencia, conta));
                    
                   /* 
                   System.out.print("Agencia: ");
                   agencia = ler.nextLine();
                   System.out.print("Conta: ");
                   conta = ler.nextLine();
                   System.out.println( banco.gerarExtratos(agencia, conta));
                   */
                   break;
                   
               case 8: //Gerar Relatórios
                   
                   banco.gerarRelatorios( );
                   break;
                   
               default:
                   if(op != 0 && op != 10){
                        System.out.println("Entrada inválida");
                   }
                   break;    
           }
        }
    }
    
}
