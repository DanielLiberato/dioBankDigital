package com.bankDigital;

import com.bankDigital.abstracts.Account;
import com.bankDigital.entities.Bank;
import com.bankDigital.entities.CurrentAccount;
import com.bankDigital.entities.SavingsAccount;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int option = 0;
        Bank bank = new Bank();
        CurrentAccount currentAccount = new CurrentAccount();
        SavingsAccount savingsAccount = new SavingsAccount();

        do {
            System.out.println("\n\033[34m###############################################################\n" +
                    "Bem vindo ao banco" + bank.getName() + "\n" +
                    "Digite o numero da opção desejada: \n" +
                    "1 - Conta corrente \n" +
                    "2 - Conta Poupança \n" +
                    "0 - Para sair a qualquer momento \n" +
                    "###############################################################\n");
            option = Integer.parseInt(input.nextLine());

            switch (option){
                case 1:
                    System.out.println("\n\033[34mDigite o numero da opção desejada: \n" +
                            "1 - Consultar saldo \n" +
                            "2 - Sacar \n" +
                            "3 - Depositar \n" +
                            "4 - Transferir para conta poupança\n");
                    option = Integer.parseInt(input.nextLine());
                    if(option == 1){
                        currentAccount.printExtract();
                    }else if(option == 2){
                        System.out.println("\033[34mDigite o valor para sacar");
                        double valueSaque = Double.parseDouble(input.nextLine());

                        currentAccount.toWithdraw(valueSaque, false);
                    }else if (option == 3){
                        System.out.println("\033[34mDigite o valor para depositar");
                        double valueDeposit = Double.parseDouble(input.nextLine());

                        currentAccount.deposit(valueDeposit, false);
                    }else if (option == 4){
                        System.out.println("\033[34mDigite o valor para transferir");
                        double valueTransfer = Double.parseDouble(input.nextLine());

                        currentAccount.transfer(valueTransfer, savingsAccount);
                    }
                    break;
                case 2:
                    System.out.println("\033[34mDigite o numero da opção desejada: \n" +
                            "1 - Consultar saldo \n" +
                            "2 - Sacar \n" +
                            "3 - Depositar \n" +
                            "4 - Transferir para conta corrente\n");
                    option = Integer.parseInt(input.nextLine());
                    if(option == 1){
                        savingsAccount.printExtract();
                    }else if(option == 2){
                        System.out.println("\033[34mDigite o valor para sacar");
                        double valueSaque = Double.parseDouble(input.nextLine());

                        savingsAccount.toWithdraw(valueSaque, false);
                    }else if (option == 3){
                        System.out.println("\033[34mDigite o valor para depositar");
                        double valueDeposit = Double.parseDouble(input.nextLine());

                        savingsAccount.deposit(valueDeposit, false);
                    }else if (option == 4) {
                        System.out.println("\033[34mDigite o valor para transferir");
                        double valueTransfer = Double.parseDouble(input.nextLine());

                        savingsAccount.transfer(valueTransfer, currentAccount);
                    }
                    break;
            }
        } while (option != 0);

        System.out.println("\n\033[34mObrigado por utilizar nossos serviços, volte sempre !!!");
    }
}
