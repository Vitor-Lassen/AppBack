
package appback;


import java.sql.SQLException;

import DB.TBCustumerAccount;

import java.util.Scanner;


public class AppBack {

public static void main(String[] args)  throws ClassNotFoundException,IllegalAccessException,InstantiationException,SQLException {
        TBCustumerAccount tbca = new TBCustumerAccount();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bem Vindo!\n");
        int opcao;
        do {
            System.out.print("\nDigite:\n1 - para adicionar um registro.\n2 - para realizar a consulta.\n3 - para finalizar\n");
            opcao = scanner.nextInt();
        }while(opcao < 1 || opcao >3);
     
        if(opcao ==1){
            do {
                int id_customer;         
                String nm_customer,cpf_cnpj;
                boolean is_active;
                double vl_total;
                System.out.println("Novo cadastro, Digite:\n");
                System.out.println("ID: ");
                id_customer = scanner.nextInt();
                System.out.println("CPF / CNPJ (Somente Números) : ");
                cpf_cnpj = scanner.next();
                System.out.println("Nome: ");
                scanner.nextLine();
                nm_customer = scanner.nextLine();
                System.out.println("Ativo? Digite: (true/false) ");
                is_active = scanner.nextBoolean();
                System.out.println("Valor: ");
                vl_total = scanner.nextDouble();
                tbca.insert(id_customer, cpf_cnpj, nm_customer, is_active, vl_total);
                System.out.println("\nDeseja adicionar outro cadastro? \n (digite 1 para sim e qualquer outro valor para não)\n ");
                opcao = scanner.nextInt();
                System.out.println("\n\n");
            }while(opcao == 1);
            tbca.select();
        }
        else if(opcao == 2){
            tbca.select();
        }
    }
}


    

