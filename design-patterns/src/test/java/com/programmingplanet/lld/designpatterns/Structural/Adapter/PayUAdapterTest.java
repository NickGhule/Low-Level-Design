package com.programmingplanet.lld.designpatterns.Structural.Adapter;

import static org.junit.Assert.assertTrue;


import org.junit.Test;

import com.programmingplanet.lld.designpatterns.Structural.Adapter.External.PaymentGateways.CurrencyType;
import com.programmingplanet.lld.designpatterns.Structural.Adapter.External.PaymentGateways.PayUAPI;

public class PayUAdapterTest {
    @Test
    public void testGetPaymentStatus() {
        PaymentGatewayAdapter paymentGateway = new PayUAdapter(new PayUAPI());
        String transactionId = paymentGateway.initiatePayment("Order1", "101", 1000, CurrencyType.INR);
        assertTrue("If Payment Initiated, transactionId should be returned",
                transactionId != null && !transactionId.isEmpty());
        // create new thread to simulate async payment processing
        Thread t = new Thread(new Runnable() {
            public void run() {
                try {
                    long startTime = System.currentTimeMillis();
                    PaymentStatus status = paymentGateway.getPaymentStatus(transactionId);
        
                    while (status != PaymentStatus.SUCCESS && System.currentTimeMillis() - startTime < 150000) {
                        Thread.sleep(1000);
                        status = paymentGateway.getPaymentStatus(transactionId);
                        System.out.println("Payment Status: " + status);
                    }
                    assertTrue("If Payment Completed, payment status should be returned as SUCCESS",
                            status == PaymentStatus.SUCCESS);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    // Restore the interrupted status
                    Thread.currentThread().interrupt();
                }
            }
        });
        // start thread with timeout of 15 seconds
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            System.out.println("Payment Timed Out");
        }
    }

    @Test
    public void testInitiatePayment() {

    }
}
