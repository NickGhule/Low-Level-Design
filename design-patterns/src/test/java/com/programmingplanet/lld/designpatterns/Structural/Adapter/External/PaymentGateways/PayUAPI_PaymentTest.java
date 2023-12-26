package com.programmingplanet.lld.designpatterns.Structural.Adapter.External.PaymentGateways;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class PayUAPI_PaymentTest {

    @Test
    public void testCreatePayment() {
        PayUAPI payUAPI = new PayUAPI();
        String transactionId = payUAPI.createPayment(101, "Order1", 1000, CurrencyType.INR);
        assertTrue("If payment started, transactionId should be returned", transactionId != null);
    }

    @Test
    public void testGetPaymentStatus() {
        PayUAPI payUAPI = new PayUAPI();

        String transactionId = payUAPI.createPayment(101, "Order1", 1000, CurrencyType.INR);
        PayUPaymentStatus status = payUAPI.getPaymentStatus(transactionId);
        assert (status == PayUPaymentStatus.STARTED);
        
        int retryCount = 0;
        while (retryCount < 15 && status != PayUPaymentStatus.OK) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            status = payUAPI.getPaymentStatus(transactionId);
    
            System.out.println("Try : " + retryCount + " Payment Status: " + status);
            retryCount++;
            }
        assertTrue("If Payment is success, Status should be OK", status == PayUPaymentStatus.OK);
    }
}
