package com.bankDigital.entities;

public class Bank {
    private String name;

    private static final String NAME_BANK_DEFAULT = "Brasil plus";

    public Bank() {
        this.name = NAME_BANK_DEFAULT;
    }

    public String getName() {
        return name;
    }
}
