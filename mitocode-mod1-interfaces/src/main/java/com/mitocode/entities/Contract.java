package com.mitocode.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class Contract {
    private Integer number;
    private Date  date;
    private Double totalValue;

    List<Installment> installments = new ArrayList<>();

    public Contract() {
    }

    public Contract(Integer number, Date  date, Double totalValue) {
        super();
        this.number = number;
        this.date = date;
        this.totalValue = totalValue;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
    }

    public List<Installment> getInstallments() {
        return installments;
    }
}
