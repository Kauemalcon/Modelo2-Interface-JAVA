package service;

import entities.Contract;
import entities.Installiment;

import java.time.LocalDate;


public class ContractService {

    public OnlinePaymentService onlinePaymentService;
    public ContractService(OnlinePaymentService onlinePaymentService) {
        this.onlinePaymentService = onlinePaymentService;
    }

    public void processContract(Contract contract, Integer months){
        //contract.getInstalliment().add(new Installiment(LocalDate.of(2018,7, 25), 206.04 ));
        //contract.getInstalliment().add(new Installiment(LocalDate.of(2018, 8, 25), 208.08));

        double basicQuota = contract.getTotalValue() / months;

        for(int i = 1; i <= months; i++){
            LocalDate dueDate = contract.getDate().plusMonths(i);

            double interest = onlinePaymentService.interest(basicQuota, i);
            double fee = onlinePaymentService.paymentFee(basicQuota + interest);
            double quota = basicQuota + interest + fee;

            contract.getInstalliment().add(new Installiment(dueDate, quota));
        }
    }
}
