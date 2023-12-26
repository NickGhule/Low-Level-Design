package com.programmingplanet.lld.designpatterns.Structural.Adapter.External.PaymentGateways;

import java.util.ArrayList;
import java.util.List;

public class RazorPayAPI {
    
    private class Payment {
        int userId;
        int amount;
        CurrencyType currency;
        RazorPayPaymentStatus status;
        String transactionID;

        public Payment(int userId, int amount, CurrencyType currency, RazorPayPaymentStatus status) {
            this.transactionID = "payRP" + userId + System.currentTimeMillis();
            this.userId = userId;
            this.amount = amount;
            this.currency = currency;
            this.status = status;
        }
    }
    
    static List<Payment> payments = new ArrayList<>();
    
    public String startPayment(int id, int amount, CurrencyType currency) {
        Payment payment = new Payment(id, amount, currency, RazorPayPaymentStatus.CREATED);
        payments.add(payment);
        System.out.println("RazorPay Payment started for User: " + payment.userId
                                    + " amount: " + payment.amount 
                                    + " currency: " + payment.currency 
                                    + " transactionID: " + payment.transactionID);
        
        
        // Simulate payment processing: Mark payment as success after 10 seconds
        new Thread(() -> {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            payment.status = RazorPayPaymentStatus.SUCCESS;
            System.out.println("RazorPay Payment success for id: " + payment.userId
                                    + " amount: " + payment.amount 
                                    + " currency: " + payment.currency 
                                    + " transactionID: " + payment.transactionID);
        }).start();
        return payment.transactionID;
    }

    public RazorPayPaymentStatus getStatus(String transactionID) {
        System.out.println("RazorPay Payment status for id: " + transactionID);
        for (Payment payment : payments) {
            if (payment.transactionID.equals(transactionID)) {
                return payment.status;
            }
        }
        throw new RuntimeException("Payment not found");
    }
}
