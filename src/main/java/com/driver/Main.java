package com.driver;

public class Main {
    public static void main(String[] args) {
        BankAccount ba = new BankAccount("Test",30000,5000);
        try {
            String ac =ba.generateAccountNumber(9,9);
            System.out.println(ac);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        CurrentAccount ca = null;
        try {
            ca = new CurrentAccount("Test2",200000,"AAABB");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        try {
            ca.validateLicenseId();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}