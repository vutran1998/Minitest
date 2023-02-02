package model;

import java.time.LocalDate;

public class Meat extends Material {
    public double weight;
    @Override
    public double getRealMoney() {
        LocalDate expiryDate = this.getExpiryDate();
        LocalDate now = LocalDate.now();
        if (expiryDate.minusDays(2).isBefore(now)){
            return this.getCost() * 0.7;
        }else {
            return this.getCost() *  0.9;
        }
    }

    @Override
    public double getAmount() {
        return cost*weight;
    }

    @Override
    public LocalDate getExpiryDate() {
        return manufacturingDate.plusDays(7);
    }

    public Meat(String id, String name, LocalDate manufacturingDate, int cost, double weight) {
        super(id, name, manufacturingDate, cost);
        this.weight = weight;
    }

    public Meat(double weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Meat{" +
                "weight=" + weight +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", manufacturingDate=" + manufacturingDate +
                ", cost=" + cost +
                '}';
    }
}
