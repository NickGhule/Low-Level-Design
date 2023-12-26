package com.programmingplanet.lld.designpatterns.Structural.Adapter;

import com.programmingplanet.lld.designpatterns.Structural.Adapter.External.PaymentGateways.CurrencyType;
import com.programmingplanet.lld.designpatterns.Structural.Adapter.External.PaymentGateways.PayUAPI;
import com.programmingplanet.lld.designpatterns.Structural.Adapter.External.PaymentGateways.PayUPaymentStatus;


public class PayUAdapter implements PaymentGatewayAdapter{
        
        private PayUAPI payUAPI;
        
        public PayUAdapter(PayUAPI payUAPI) {
            this.payUAPI = payUAPI;
        }

        @Override
        public String initiatePayment(String orderId, String customerId, double amount, CurrencyType currencyType) {
            String transactionID = payUAPI.createPayment(Integer.parseInt(customerId), orderId, (int)amount, currencyType);
            return transactionID;
        }
    
        public PaymentStatus getPaymentStatus(String transactionID) {
            PayUPaymentStatus payUPaymentStatus = payUAPI.getPaymentStatus(transactionID);
            switch (payUPaymentStatus) {
                case STARTED:
                    return PaymentStatus.PENDING;
                case OK:
                    return PaymentStatus.SUCCESS;
                default:
                    return PaymentStatus.FAILED;
            }
        }
}
