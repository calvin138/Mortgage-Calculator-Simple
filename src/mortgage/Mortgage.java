/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mortgage;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author calvinloh
 */
public class Mortgage {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        final byte MONTH_IN_YEAR = 12;
        final byte PERCENT = 100;
        
        Scanner sc = new Scanner(System.in);
        
        int principal;
        float annualInterestRate;
        float monthlyInterestRate;
        byte period;
        int numberOfPayment;
        double mortgage;
        
        while(true){
            System.out.print("Principal : $ ");
            principal = sc.nextInt();
            if(principal >= 10000 && principal <= 1000000){
                break;
            }
            System.out.println("Enter a value between $10.000 and $1.000.000");
        }
        
        while(true){
            System.out.print("Annual Interest Rate : ");
            annualInterestRate = sc.nextFloat();
            if(annualInterestRate >= 1 && annualInterestRate <= 30){
                break;
            }
            System.out.println("Please enter a value between 1 and 30");
        }
        monthlyInterestRate = annualInterestRate / PERCENT / MONTH_IN_YEAR;
        
        
        while(true){
            System.out.print("Period (Years) : ");
            period = sc.nextByte();
            if(period >= 1 && period <= 30){
                break;
            }
            System.out.println("Please enter a value more than 0 and less than or equals to 30");
        }
        numberOfPayment = period * MONTH_IN_YEAR;
        
        
        
        mortgage = principal * 
                                  (monthlyInterestRate * (Math.pow((1 + monthlyInterestRate), numberOfPayment)))
                                / ((Math.pow((1 + monthlyInterestRate), numberOfPayment)) - 1);
        
        Locale locale = new Locale("en", "US");
        String mortgageFormatted = NumberFormat.getCurrencyInstance(locale).format(mortgage);
        
        
        System.out.println("Mortgage : " + mortgageFormatted);
    }
}
