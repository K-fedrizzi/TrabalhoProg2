
package main;

import classes.Banco;
import java.util.Scanner;



public class Main2 {

    
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
                     banco.cadastrarAgencia("Banco do Brasil", "2224","Brasil", "Campo Grande-MS","Rua Afonso Pena","Centro" , "79050-060",10);
                     banco.cadastrarAgencia("Banco Santander", "1124","Brasil", "Campo Grande-MS","Rua Afonso Pena","Centro" , "79050-060",20);
                
                   break;
                   
               case 3://Abertura de Conta
                   
                     /*Dados Pre Cadastrados*/
                     banco.abrirConta("C","2224",100,"Juvenal Botelho ","01/09/1940","000","TRADICIONAL","Brasil","Ponta Porà","Glauce Rocha","Julia Cardinal","78090-234",24);
                     banco.abrirConta("F","1124",100,"Juvenal Botelho ","01/09/1940","000","TRADICIONAL","","","","","",0);
                     banco.abrirConta("C","1124",200,"Jacinto Chagas","01/09/1940","111","TRADICIONAL","Brasil","Ponta Porà","Glauce Rocha","Julia Cardinal","78090-234",24);
                     banco.abrirConta("C","1124",200,"Aracelia Arara","01/09/1940","111","PREMIUM","Brasil","Ponta Porà","Glauce Rocha","Julia Cardinal","78090-234",24);

                   break;
                   
               case 4://Saque
                   
                   /*Dados Pré-Cadastrados*/
                   banco.saque("2224", "00001", 20);
              
                   break;
                   
               case 5://Depósito em Conta
                   
                   /*Dados Pré-Cadastrados*/
                   banco.depositar("2224", "00001", 50);
              
                   break;
                   
               case 6: //Transferência
                   
                   /*Dados Pre-Cadrastrados*/
                   banco.transferencia("2224","00001","1124","00001", 50);
               
                   break;
                   
               case 7: //Gerar Extratos
                   
                   /*Dados Pre-Cadastrados*/
                   System.out.println(banco.gerandoExtrato("2224","00001"));
                   
                   break;
                   
               case 8: //Gerar Relatórios
                   
                   banco.gerarRelatorio();
                
                   break;
                   
               case 9:
                   
                   banco.fecharConta("2224","00001");
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
