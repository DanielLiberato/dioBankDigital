package com.bankDigital.interfaces;

import com.bankDigital.abstracts.Account;

public interface IAccount
{
    void toWithdraw(double valueToWithdraw, boolean transfer);

    void deposit(double valueDeposit, boolean transfer);

    void transfer(double valueTransfer, Account destinationAccount);

    void printExtract();
}