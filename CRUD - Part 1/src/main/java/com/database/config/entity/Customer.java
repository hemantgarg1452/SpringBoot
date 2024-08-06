package com.database.config.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Customer {

    @Id
    private int id;
    private String name;
    private String idType;
    private String city;
    private Long amount;
    private String paymentType;

    public Customer() {
        super();
    }

    public Customer(int id, String name, String idType, String city, Long amount, String paymentType) {
        this.id = id;
        this.name = name;
        this.idType = idType;
        this.city = city;
        this.amount = amount;
        this.paymentType = paymentType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }


    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", idType='" + idType + '\'' +
                ", city='" + city + '\'' +
                ", amount=" + amount +
                ", paymentType='" + paymentType + '\'' +
                '}';
    }
}
