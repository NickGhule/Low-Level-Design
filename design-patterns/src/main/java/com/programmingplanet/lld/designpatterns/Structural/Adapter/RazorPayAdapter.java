package com.programmingplanet.lld.designpatterns.Structural.Adapter;

import com.programmingplanet.lld.designpatterns.Structural.Adapter.External.PaymentGateways.CurrencyType;
import com.programmingplanet.lld.designpatterns.Structural.Adapter.External.PaymentGateways.RazorPayAPI;
import com.programmingplanet.lld.designpatterns.Structural.Adapter.External.PaymentGateways.RazorPayPaymentStatus;

public class RazorPayAdapter implements PaymentGatewayAdapter{
    
        private RazorPayAPI razorPayAPI;
    
        public RazorPayAdapter(RazorPayAPI razorPayAPI) {
            this.razorPayAPI = razorPayAPI;
        }
    
        @Override
        public String initiatePayment(String orderId, String customerId, double amount, CurrencyType currencyType) {
            String transactionId = razorPayAPI.startPayment(Integer.parseInt(customerId), (int)amount, currencyType);
            return transactionId;
        }
    
        @Override
        public PaymentStatus getPaymentStatus(String transactionID) {
            RazorPayPaymentStatus razorPayPaymentStatus = razorPayAPI.getStatus(transactionID);
            switch (razorPayPaymentStatus) {
                case CREATED:
                    return PaymentStatus.PENDING;
                case SUCCESS:
                    return PaymentStatus.SUCCESS;
                default:
                    return PaymentStatus.FAILED;
            }
        }
}
