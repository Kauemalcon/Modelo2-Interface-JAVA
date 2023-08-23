import entities.Contract;
import entities.Installiment;
import service.ContractService;
import service.PaypalService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner((System.in));

        DateTimeFormatter fmt =DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Entre com os dados do contrato");
        System.out.print("numero: ");
        int number = sc.nextInt();
        System.out.print("Data (dd/MM/yyyy): ");
        LocalDate data = LocalDate.parse(sc.nextLine(),fmt);
        System.out.print("Valordo contrato: ");
        Double totalValue = sc.nextDouble();

        Contract contract = new Contract(number, data, totalValue);

        System.out.print("Entre com o numero de parcelas: ");
        int parcelas = sc.nextInt();

        ContractService contractService = new ContractService(new PaypalService());
        contractService.processContract(contract,parcelas);

        System.out.println("Parcelas: ");
        for(Installiment installiment : contract.getInstalliment()){
            System.out.print(installiment);
        }



        sc.close();
    }
}