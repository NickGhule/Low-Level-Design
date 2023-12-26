package com.programmingplanet.lld.designpatterns.Structural.Adapter;

import com.programmingplanet.lld.designpatterns.Structural.Adapter.External.PaymentGateways.*;
public interface PaymentGatewayAdapter {

    String initiatePayment(String orderId, String customerId, double amount, CurrencyType currencyType);
    PaymentStatus getPaymentStatus(String transactionID);
    
}