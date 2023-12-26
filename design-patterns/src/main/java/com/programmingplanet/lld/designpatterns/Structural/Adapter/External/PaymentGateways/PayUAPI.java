package com.programmingplanet.lld.designpatterns.Structural.Adapter.External.PaymentGateways;

import java.util.ArrayList;
import java.util.List;

public class PayUAPI {

    static List<Payment> payments;
    
    public PayUAPI() {
        payments = new ArrayList<Payment>();
    }

    private class Payment {
        int userId;
        int amount;
        String orderId;
        CurrencyType currency;
        PayUPaymentStatus status;
        String transactionID;

        public Payment(int userId, String orderId, int amount, CurrencyType currency, PayUPaymentStatus status) {
            this.transactionID = "payPU" + userId + System.currentTimeMillis();
            this.userId = userId;
            this.orderId = orderId;
            this.amount = amount;
            this.currency = currency;
            this.status = status;
        }
    }
    
    public String createPayment(int userId, String orderId, int amount, CurrencyType currency) {
        Payment payment = new Payment(userId, orderId, amount, currency, PayUPaymentStatus.STARTED);
        payments.add(payment);
        System.out.println("PayU Payment started for id: " + payment.userId 
                                    + " orderId: " + payment.orderId
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
            payment.status = PayUPaymentStatus.OK;
            System.out.println("PayU Payment success for id: " + payment.userId
                                    + " orderId: " + payment.orderId
                                    + " amount: " + payment.amount 
                                    + " currency: " + payment.currency 
                                    + " transactionID: " + payment.transactionID);
        }).start();
        return payment.transactionID;

    }

    public PayUPaymentStatus getPaymentStatus(String transactionID) {
        for(Payment payment : payments) {
            if(payment.transactionID.equals(transactionID)) {
                return payment.status;
            }
        }
        throw new RuntimeException("Payment not found");
    }
}
