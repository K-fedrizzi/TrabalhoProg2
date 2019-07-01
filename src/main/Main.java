
package main;

import classes.Banco;


public class Main {

    
    public static void main(String[] args) {
        Banco banco = new Banco();
        banco.cadastrarAgencia("Banco do Brasil", "2224","Brasil", "Campo Grande-MS","Rua Afonso Pena","Centro" , "79050-060",10);
        banco.cadastrarAgencia("Banco Santander", "1124","Brasil", "Campo Grande-MS","Rua Afonso Pena","Centro" , "79050-060",20);
        banco.abrirConta("C","2224",100,"Juvenal Botelho Pinto","01/09/1940","000","TRADICIONAL","Brasil","Ponta Porà","Glauce Rocha","Julia Cardinal","78090-234",24);
        banco.abrirConta("F","1124",100,"Juvenal Botelho Pinto","01/09/1940","000","TRADICIONAL","","","","","",0);
        banco.abrirConta("C","1124",200,"Jacinto Cabeção","01/09/1940","000.000.051-70","TRADICIONAL","Brasil","Ponta Porà","Glauce Rocha","Julia Cardinal","78090-234",24);
        banco.depositar("2224", "00001", 50);
        banco.transferencia("2224","00001","1124","00001", 50);
        
        banco.gerarRelatorio();
    }
    
}
