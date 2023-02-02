package model;

import java.time.LocalDate;

public class CrispyFlour extends Material {
    public int quantity;

    @Override
    public double getRealMoney() {
        LocalDate expiryDate = this.getExpiryDate();
        LocalDate now = LocalDate.now();
        if(expiryDate.minusMonths(10).isBefore(now)){
            return this.getCost()*0.6;
        }else if(expiryDate.minusMonths(8).isBefore(now)){
            return this.getCost()*  0.8;
        }else {
            return this.getCost()*0.95;
        }
    }

    @Override
    public double getAmount() {
        return quantity * cost;
    }

    @Override
    public LocalDate getExpiryDate() {
        return manufacturingDate.plusMonths(12) ;
    }

    public CrispyFlour(String id, String name, LocalDate manufacturingDate, int cost, int quantity) {
        super(id, name, manufacturingDate, cost);
        this.quantity = quantity;
    }

    public CrispyFlour(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "CrispyFlour{" +
                "quantity=" + quantity +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", manufacturingDate=" + manufacturingDate +
                ", cost=" + cost +
                '}';
    }
}
