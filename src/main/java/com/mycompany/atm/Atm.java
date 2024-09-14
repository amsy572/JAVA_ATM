/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.atm;

import java.util.Date;
import com.mycompany.atm.Admin;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author AMSY
 */
//    ATM SECTION
public class Atm {
    
   public static void main(String[] args) {
        Admin admin = new Admin();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the ATM System");

        while (true) {
            System.out.println("\nLOGIN");
            System.out.println("1. Admin");
            System.out.println("2. User");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    adminLogin(admin);
                    break;
                case 2:
                    userLogin(admin);
                    break;
                case 3:
                    System.out.println("Exiting the ATM System");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
//    adminLogin Method
    public static void adminLogin(Admin admin) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter Admin password: ");
        String adminPassword = scanner.nextLine();
        if (adminPassword.equals("admin123")) {
            while (true) {
                System.out.println("\nADMIN MENU");
                System.out.println("1. Create User Account");
                System.out.println("2. Get User Details");
                System.out.println("3. Get User Deposit Report");
                System.out.println("4. Get User Withruwal Report");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        createUserAccount(admin);
                        break;
                    case 2:
                        displayAccountReport(admin);
                        break;
                    case 3:
                        getWithdrawalReport( admin);
                        break;
                        
                    case 4:
                        getWithdrawalReport(admin);
                        break;
                        
                    case 5:
                        return;    
                    default:
                        System.out.println("Invalid choice");
                }
            }
        } else {
            System.out.println("Invalid password");
        }
    }
//    createUserAccount Method
    public static void createUserAccount(Admin admin) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter Unique ID: ");
        String uniqueId = scanner.nextLine();
        System.out.print("Enter PIN: ");
        String pin = scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Contact Number: ");
        String contactNumber = scanner.nextLine();
        System.out.print("Enter Gender: ");
        String gender = scanner.nextLine();
        System.out.print("Enter Address: ");
        String address = scanner.nextLine();

        admin.createUser(uniqueId, pin, name, contactNumber, gender, address);
    }
//     userLogin Method
    public static void userLogin(Admin admin) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter Unique ID: ");
        String uniqueId = scanner.nextLine();
        System.out.print("Enter PIN: ");
        String pin = scanner.nextLine();

        User user = admin.getUser(uniqueId);
        if (user != null && user.getPin().equals(pin)) {
            while (true) {
                System.out.println("\nUSER MENU");
                System.out.println("1. Deposit");
                System.out.println("2. Withdraw");
                System.out.println("3. Balance Enquiry");
                System.out.println("4. Change Password");
                System.out.println("5. Logout");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        performDeposit(user);
                        break;
                    case 2:
                        performWithdrawal(user);
                        break;
                    case 3:
                        checkBalance(user);
                        break;
                    case 4:
                        changePassword(user);
                        return;
                    case 5:
                        return;
                    default:
                        System.out.println("Invalid choice");
                }
            }
        } else {
            System.out.println("Invalid unique ID or PIN");
        }
    }
//   performDeposit Method
    public static void performDeposit(User user) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter amount to deposit: ");
        double amount = scanner.nextDouble();
        user.deposit(amount);
        System.out.println("Amount deposited successfully");
    }
    //    getDepositReport Method
    public static void getDepositReport(Admin admin) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter Unique ID: ");
        String uniqueId = scanner.nextLine();
        
        User user = admin.getUser(uniqueId);
         if (user != null && user.getUniqueId().equals(uniqueId)){
             System.out.print("\nEnter the date: ");
             String date = scanner.nextLine();
             user.generateDepositReport(date);
             
         }else{
             System.out.println("Invalid ID");
         }
        
        
        
    }
    //   getWithdrawalReport Method
    public static void getWithdrawalReport(Admin admin) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter Unique ID: ");
        String uniqueId = scanner.nextLine();
        
        User user = admin.getUser(uniqueId);
         if (user != null && user.getUniqueId().equals(uniqueId)){
             System.out.print("\nEnter the date: ");
            String date = scanner.nextLine();
            user.generateWithdrawalReport(date);
             
         }else{
             System.out.println("Invalid ID");
         }
      
    }
//    performWithdrawal Method
    public static void performWithdrawal(User user) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter amount to withdraw: ");
        double amount = scanner.nextDouble();
        boolean success = user.withdraw(amount);
        if (success) {
            System.out.println("Amount withdrawn successfully");
        } else {
            System.out.println("Unable to withdraw amount");
        }
    }
//    checkBalance Method
    public static void checkBalance(User user) {
        System.out.println("\nBalance: " + user.getBalance());
        user.printTransactionHistory();
    }
    

    //    displayAccountReport Method
     public static void displayAccountReport(Admin admin) {
         Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter Unique ID: ");
        String uniqueId = scanner.nextLine();
         User user = admin.getUser(uniqueId);
          if (user != null && user.getUniqueId().equals(uniqueId)){
             System.out.println("Account Report");
             System.out.println("Name: " + user.getName());
             System.out.println("Unique ID: " + user.getUniqueId());
             System.out.println("Contact Number: " + user.getContactNumber());
             System.out.println("Gender: " + user.getGender());
             System.out.println("Address: " + user.getAddress());
             System.out.println();
             
         }else{
             System.out.println("Invalid ID");
         }
        
        
    }
//    changePassword Method
    public static void changePassword(User user) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter old password: ");
        String oldPassword = scanner.nextLine();
        if (user.getPin().equals(oldPassword)) {
            System.out.print("Enter new password: ");
            String newPassword = scanner.nextLine();
            System.out.print("Confirm new password: ");
            String confirmPassword = scanner.nextLine();
            if (newPassword.equals(confirmPassword)) {
                user.setPin(newPassword);
                System.out.println("Password changed successfully");
            } else {
                System.out.println("Password confirmation does not match");
            }
        } else {
            System.out.println("Invalid old password");
        }
    }
}