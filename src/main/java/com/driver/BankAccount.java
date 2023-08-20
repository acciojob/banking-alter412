package com.driver;

public class BankAccount {

    private String name;
    private double balance;
    private double minBalance;

    public BankAccount(String name, double balance, double minBalance) {
        this.name = name;
        this.balance = balance;
        this.minBalance = minBalance;
    }

    public String generateAccountNumber(int digits, int sum) throws Exception{
        //Each digit of an account number can lie between 0 and 9 (both inclusive)
        //Generate account number having given number of 'digits' such that the sum of digits is equal to 'sum'
        //If it is not possible, throw "Account Number can not be generated" exception

        if(digits*9<sum){
            throw new Exception("Account Number can not be generated");
        }

        String acc = helper(digits,sum,"");
        if(acc==null){
            throw new Exception("Account Number can not be generated");
        }
        return acc;
    }

    private String helper(int digits, int sum,String acc) {
        if(acc.length()==digits && sum==0){
            return acc;
        }
        if(sum==0){
            while(acc.length()<digits){
                acc+="0";
            }
            return acc;
        }
        if((acc.length()==digits) && (sum>0)){
            return null;
        }
        if(sum<0){
            return null;
        }
        if(acc.length()>digits){
            return null;
        }
        String temp = helper(digits,sum-0,acc+"0");
        if(temp!=null){
            return temp;
        }
        temp = helper(digits,sum-1,acc+"1");
        if(temp!=null){
            return temp;
        }

        temp = helper(digits,sum-2,acc+"2");
        if(temp!=null){
            return temp;
        }

        temp = helper(digits,sum-3,acc+"3");
        if(temp!=null){
            return temp;
        }

        temp = helper(digits,sum-4,acc+"4");
        if(temp!=null){
            return temp;
        }

        temp = helper(digits,sum-5,acc+"5");
        if(temp!=null){
            return temp;
        }

        temp = helper(digits,sum-6,acc+"6");
        if(temp!=null){
            return temp;
        }

        temp = helper(digits,sum-7,acc+"7");
        if(temp!=null){
            return temp;
        }

        temp = helper(digits,sum-8,acc+"8");
        if(temp!=null){
            return temp;
        }

        temp = helper(digits,sum-9,acc+"9");
        if(temp!=null){
            return temp;
        }

        return null;

    }

    public void deposit(double amount) {
        //add amount to balance

        if(amount>0){
            this.balance+=amount;
        }

    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public double getMinBalance() {
        return minBalance;
    }

    public void withdraw(double amount) throws Exception {
        // Remember to throw "Insufficient Balance" exception, if the remaining amount would be less than minimum balance
        if(this.balance-amount<this.minBalance){
            throw new Exception("Insufficient Balance");
        }
        this.balance-=amount;
    }

}