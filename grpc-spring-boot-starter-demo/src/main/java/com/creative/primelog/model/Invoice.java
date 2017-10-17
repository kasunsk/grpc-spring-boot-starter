package com.creative.primelog.model;

import com.creative.primelog.common.TenantParam;

public class Invoice extends TenantParam {

    private String origin;
    private String destination;
    private String transportServiceProvider;
    private String weight;
    private String price;

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getTransportServiceProvider() {
        return transportServiceProvider;
    }

    public void setTransportServiceProvider(String transportServiceProvider) {
        this.transportServiceProvider = transportServiceProvider;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
