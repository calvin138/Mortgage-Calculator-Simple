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
        
        System.out.print("Principal : ");
        principal = sc.nextInt();
        
        System.out.print("Annual Interest Rate : ");
        annualInterestRate = sc.nextFloat();
        monthlyInterestRate = annualInterestRate / PERCENT / MONTH_IN_YEAR;
        
        System.out.print("Period (Years) : ");
        period = sc.nextByte();
        numberOfPayment = period * MONTH_IN_YEAR;
        
        
        
        mortgage = principal * 
                                  (monthlyInterestRate * (Math.pow((1 + monthlyInterestRate), numberOfPayment)))
                                / ((Math.pow((1 + monthlyInterestRate), numberOfPayment)) - 1);
        
        Locale locale = new Locale("en", "US");
        String mortgageFormatted = NumberFormat.getCurrencyInstance(locale).format(mortgage);
        
        
        System.out.println("Mortgage : " + mortgageFormatted);
    }
    
}
