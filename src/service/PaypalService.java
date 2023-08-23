package service;

public class PaypalService implements OnlinePaymentService {

    public Double paymentFee(Double amount){
        return amount * 0.2;
    }
    public Double interest(Double amount, Integer months){
        return amount * 0.01 * months;
    }
}
