/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.atm;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author AMSY
 */


// User Section

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class User {
    private String uniqueId;
    private String pin;
    private String name;
    private double balance;
    private String contactNumber;
    private String gender;
    private String address;
    private Map<String, Double> transactionHistory;
    private List<String> transactions;

//    User constractor
    public User(String uniqueId, String pin, String name, String contactNumber, String gender, String address) {
        this.uniqueId = uniqueId;
        this.pin = pin;
        this.name = name;
        this.balance = 0.0;
        this.contactNumber = contactNumber;
        this.gender = gender;
        this.address = address;
        this.transactions = new ArrayList<>();
        this.transactionHistory = new HashMap<>();
    }

    
//    Unique Id Method
    public String getUniqueId() {
        return uniqueId;
    }
//    GetPin Method
    
    public String getPin() {
        return pin;
    }
//    SetPin Method
    public void setPin(String pin) {
        this.pin = pin;
    }
//    GetName Method
    public String getName() {
        return name;
    }
//    GetBalance Method
    public double getBalance() {
        return balance;
    }
//   getContactNumber Method
    public String getContactNumber() {
        return contactNumber;
    }
//    getGender Method
    public String getGender() {
        return gender;
    }
//    getAddress Method
    public String getAddress() {
        return address;
    }
//    deposit Method
    public void deposit(double amount) {
        Date currentDate = new Date();
        if (amount > 0) {
            balance += amount;
            String deposit = "Deposited :" + amount +"$ from : " + name +"'s account," +"date: "+ currentDate ;
            transactionHistory.put(deposit, amount);
            transactions.add(deposit);
        } else {
            System.out.println("Invalid deposit amount");
        }
    }
//    withdrawal Method
    public boolean withdraw(double amount) {
         Date currentDate = new Date();
        if (amount > 0) {
            if (balance >= amount) {
                balance -= amount;
               
                String with = "Withdrawal :" + -amount +"$ from : " + name +"'s account," +"date: "+ currentDate ;
                transactionHistory.put(with,-amount );
                transactions.add(with);
                return true;
            } else {
                System.out.println("Insufficient balance");
            }
        } else {
            System.out.println("Invalid withdrawal amount");
        }
        return false;
    }
    
    //    generateWithdrawalReport Method
    public void generateWithdrawalReport(String date) {
        System.out.println("Withdrawal Report for " + date);
        for (String transaction : transactions) {
            if (transaction.contains("Withdrawal") && transaction.contains(date)) {
                System.out.println(transaction);
            }
        }
    }
//    generateDepositReport Method
    public void generateDepositReport(String date) {
        System.out.println("Deposit Report for " + date);
        for (String transaction : transactions) {
            if (transaction.contains("Deposited") && transaction.contains(date)) {
                System.out.println(transaction);
            }
        }
    }
    
    
//    printTransactionHistor Method
    public void printTransactionHistory() {
        System.out.println("\nTransaction History:");
        if (transactionHistory.isEmpty()) {
            System.out.println("No transactions yet");
        } else {
            for (Map.Entry<String, Double> entry : transactionHistory.entrySet()) {
                String transactionType = entry.getKey();
                double amount = entry.getValue();
                String transactionDescription = amount >= 0 ? "+" + amount : "-" + Math.abs(amount);
                System.out.println(transactionType + ": " + transactionDescription);
                System.out.println("Remain Balance: " + balance);
            }
        }
    }
}