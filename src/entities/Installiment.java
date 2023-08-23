package entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Installiment {

    private LocalDate dueData;
    private Double amount;

    private static DateTimeFormatter fmt =DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Installiment() {
    }
    public Installiment(LocalDate dueData, Double amount) {
        this.dueData = dueData;
        this.amount = amount;
    }

    public LocalDate getDueData() {
        return dueData;
    }

    public void setDueData(LocalDate dueData) {
        this.dueData = dueData;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Override
    public String toString(){
        return dueData.format(fmt) + "-" + String.format("%.2f",amount);
    }
}
