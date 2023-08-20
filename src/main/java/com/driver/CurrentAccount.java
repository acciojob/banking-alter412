package com.driver;

import java.util.PriorityQueue;

public class CurrentAccount extends BankAccount{
    String tradeLicenseId; //consists of Uppercase English characters only

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception
        super(name,balance,5000);
        if(balance<5000){
            throw new Exception("Insufficient Balance");
        }
        this.tradeLicenseId= tradeLicenseId.toUpperCase();
    }

    public void validateLicenseId() throws Exception {
        // A trade license Id is said to be valid if no two consecutive characters are same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception
        boolean isV = isV(this.tradeLicenseId);
        if(isV){
            return;
        }
        makeValid(this.tradeLicenseId);
    }
    static class Pair{
        char ch;
        int f;
        Pair(char ch,int f){
            this.ch=ch;
            this.f = f;
        }

    }
    private void makeValid(String tradeLicenseId) throws Exception {

        int[] freq = new int[26];

        int n = tradeLicenseId.length();

        for(int i=0;i<n;i++){
            char ch = tradeLicenseId.charAt(i);
            freq[ch-'A']++;
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->{
            if(a.f<b.f){
                return 1;
            }
            return -1;
        });

        for(int i=0;i<26;i++){
            if(freq[i]>0){
                pq.add(new Pair((char)('A'+i),freq[i]));
            }
        }

        Pair prev = new Pair('#',-1);
        String res = "";

        while(pq.size()>0){
            Pair temp = pq.remove();

            res+=temp.ch;

            if(prev.f>0){
                pq.add(prev);
            }

            temp.f--;
            prev = temp;
        }

        if(res.length()!=this.tradeLicenseId.length()){
            throw new Exception("Valid License can not be generated");
        }

        if(!isV(res)){
            throw new Exception("Valid License can not be generated");
        }

        this.tradeLicenseId=res;
       // System.out.println(this.tradeLicenseId);
    }

    private boolean isV(String tradeLicenseId) {
        int n = tradeLicenseId.length();
        for(int i=0;i<n-1;i++){
            if(tradeLicenseId.charAt(i)==tradeLicenseId.charAt(i+1)){
                return false;
            }
        }
        return true;
    }

}
