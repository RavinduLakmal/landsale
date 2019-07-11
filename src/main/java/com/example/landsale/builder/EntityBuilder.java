package com.example.landsale.builder;

import com.example.landsale.dto.*;
import com.example.landsale.entit.*;
import com.example.landsale.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;


@Component
public class EntityBuilder {

    @Autowired
    private DistrictRepository districtRepository;

    @Autowired
    private OwnerRepository ownerRepository;

    @Autowired
    private BrokerRepository brokerRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private PlacesRepository placesRepository;

    public District buildDistrict(District district, DistrictDTO districtDTO) {
        if (districtDTO == null) {
            return null;
        }

        district.setName(districtDTO.getName());
        district.setProvince(districtDTO.getProvince());

        return district;
    }

    public Broker builBroker(Broker broker, BrokerDTO brokerDTO) {
        if (brokerDTO == null) {
            return null;
        }

        broker.setfName(brokerDTO.getfName());
        broker.setAddress(brokerDTO.getAddress());
        broker.setImage(brokerDTO.getImage());
        broker.setlName(brokerDTO.getlName());
        broker.setMobile(brokerDTO.getMobile());
        broker.setNic(brokerDTO.getNic());

        return broker;
    }

    public Places buildPlaces(Places places, PlacesDTO placesDTO) {
        if (placesDTO == null) {
            return null;
        }

        places.setAddDate(Date.valueOf(placesDTO.getAddDate()));
        places.setAddTime(Time.valueOf(placesDTO.getAddTime()));
        places.setDescription(placesDTO.getDescription());
        places.setDistrict(districtRepository.findOne(placesDTO.getDisID()));
        places.setType(placesDTO.getType());
        places.setLandname(placesDTO.getLandname());
        places.setSoldDate(Date.valueOf(placesDTO.getSoldDate()));
        places.setSoldTime(Time.valueOf(placesDTO.getSoldTime()));
        places.setStatus(placesDTO.getStatus());
        places.setPerchPrice(placesDTO.getPerchPrice());
        places.setPerches(placesDTO.getPerches());
        places.setOwner(ownerRepository.findOne(placesDTO.getOwnerID()));
        places.setLoungTude(placesDTO.getLoungTude());
        places.setLatTude(placesDTO.getLatTude());

        List<String> images = new ArrayList<>();

        for (String im : placesDTO.getImages()) {
            images.add(im);
        }
        places.setImages(images);

        places.setBroker(brokerRepository.getOne(placesDTO.getBrokID()));

        return places;
    }

    public Customer buildCustomer(Customer customer, CustomerDTO customerDTO) {
        if (customerDTO == null) {
            return null;
        }

        customer.setAddress(customerDTO.getAddress());
        customer.setImage(customerDTO.getImage());
        customer.setMobile(customerDTO.getMobile());
        customer.setName(customerDTO.getName());
        customer.setNic(customerDTO.getNic());
        return customer;

    }

    public Iterest buildInterest(Iterest iterest, InterestDTO interestDTO) {
        if (interestDTO == null) {
            return null;
        }

        List<Customer> customers = new ArrayList<>();
        List<Places> places = new ArrayList<>();

        for (Long custID : interestDTO.getCustomerID()) {
            customers.add(customerRepository.getOne(custID));
        }
        for (Long placesID : interestDTO.getPlacesID()) {
            places.add(placesRepository.getOne(placesID));
        }
        iterest.setCustomers(customers);
        iterest.setPlaces(places);
        return iterest;

    }

    public Owner buildOwner(Owner owner, OwnerDTO ownerDTO) {
        if (ownerDTO == null) {
            return null;
        }
        owner.setAddress(ownerDTO.getAddress());
        owner.setImage(ownerDTO.getImage());
        owner.setMobile(ownerDTO.getMobile());
        owner.setName(ownerDTO.getName());
        owner.setNic(ownerDTO.getNic());

        return owner;
    }
}
