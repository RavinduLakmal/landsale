package com.example.landsale.dto;

import java.util.List;

public class InterestDTO {
    private Long id;
    private List<Long> customerID;
    private List<CustomerDTO> customerDTOS;
    private List<Long> placesID;
    private List<PlacesDTO> placesDTo;
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Long> getCustomerID() {
        return customerID;
    }

    public void setCustomerID(List<Long> customerID) {
        this.customerID = customerID;
    }

    public List<CustomerDTO> getCustomerDTOS() {
        return customerDTOS;
    }

    public void setCustomerDTOS(List<CustomerDTO> customerDTOS) {
        this.customerDTOS = customerDTOS;
    }

    public List<Long> getPlacesID() {
        return placesID;
    }

    public void setPlacesID(List<Long> placesID) {
        this.placesID = placesID;
    }

    public List<PlacesDTO> getPlacesDTo() {
        return placesDTo;
    }

    public void setPlacesDTo(List<PlacesDTO> placesDTo) {
        this.placesDTo = placesDTo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
