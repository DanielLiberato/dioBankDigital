package com.bankDigital.abstracts;

import com.bankDigital.interfaces.IAccount;

public abstract class Account implements IAccount {
    protected int agency;
    protected int number;
    protected double balance;

    private static int SEQUENTIAL = 0;
    private static final int AGENCY_DEFAULT = 1;

    public Account() {
        this.agency = AGENCY_DEFAULT;
        this.number = SEQUENTIAL++;
    }

    public int getAgency()
    {
        return agency;
    }

    public int getNumber()
    {
        return number;
    }

    @Override
    public void toWithdraw(double valueToWithdraw, boolean transfer) {
        if (this.balance < valueToWithdraw) {
            if(!transfer){
                System.out.println("\033[31m****************************************\n" +
                        "saldo insulficiente !" +
                        "\n****************************************\n");
            }
        } else {
            this.balance -= valueToWithdraw;
            if(!transfer){
                System.out.println("\033[32m****************************************\n" +
                        "saque realizado com sucesso!" +
                        "\n****************************************\n");
            }
        }
    }

    @Override
    public void deposit(double valueDeposit, boolean transfer) {
        this.balance += valueDeposit;
        if(!transfer){
            System.out.println("\033[32m****************************************\n" +
                    "Deposito realizado com sucesso!" +
                    "\n****************************************\n");
        }
    }

    @Override
    public void transfer(double valueTransfer, Account destinationAccount) {
        if (this.balance < valueTransfer) {
            System.out.println("\033[31m****************************************\n" +
                    "saldo insulficiente !" +
                    "\n****************************************\n");
        } else {
            this.toWithdraw(valueTransfer, true);
            destinationAccount.deposit(valueTransfer, true);
            System.out.println("\033[32m****************************************\n" +
                    "transferencia realizada com sucesso!" +
                    "\n****************************************");
        }
    }

    @Override
    public void printExtract()
    {
        if(this.balance > 0){
            System.out.println("\033[32m****************************************\n" +
                    "Seu saldo = " + this.balance +
                    "\n****************************************\n");
        } else {
            System.out.println("\033[31m****************************************\n" +
                    "Seu saldo = " + this.balance +
                    "\n****************************************\n");
        }
    }
}
