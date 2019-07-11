package com.example.landsale.builder;

import com.example.landsale.dto.*;
import com.example.landsale.entit.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class DtoBuilders {

    public DistrictDTO buildDistrictDTO(District district) {

        if (district == null) {
            return null;
        }
        DistrictDTO districtDTO = new DistrictDTO();
        districtDTO.setId(district.getId());
        districtDTO.setName(district.getName());
        districtDTO.setProvince(district.getProvince());

        return districtDTO;
    }

    public OwnerDTO buildOwnerDTO(Owner owner) {
        if (owner == null) {
            return null;
        }

        OwnerDTO ownerDTO = new OwnerDTO();

        ownerDTO.setAddress(owner.getAddress());
        ownerDTO.setImage(owner.getImage());
        ownerDTO.setMobile(owner.getMobile());
        ownerDTO.setName(owner.getName());
        ownerDTO.setNic(owner.getNic());
        ownerDTO.setId(owner.getId());

        return ownerDTO;
    }


    public BrokerDTO buildBrokerDTO(Broker broker) {
        if (broker == null) {
            return null;
        }

        BrokerDTO brokerDTO = new BrokerDTO();

        brokerDTO.setAddress(broker.getAddress());
        brokerDTO.setfName(broker.getfName());
        brokerDTO.setlName(broker.getlName());
        brokerDTO.setImage(broker.getImage());
        brokerDTO.setId(broker.getId());
        brokerDTO.setMobile(broker.getMobile());
        brokerDTO.setNic(broker.getNic());
        return brokerDTO;

    }

    public CustomerDTO buildCustomerDTO(Customer customer) {

        if (customer == null) {
            return null;
        }

        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setAddress(customer.getAddress());
        customerDTO.setId(customer.getId());
        customerDTO.setImage(customer.getImage());
        customerDTO.setMobile(customer.getMobile());
        customerDTO.setName(customer.getName());
        customerDTO.setNic(customer.getNic());
        return customerDTO;

    }

    public InterestDTO buildInterestDTO(Iterest iterest) {
        if (iterest == null) {
            return null;
        }

        InterestDTO interestDTO = new InterestDTO();
        List<CustomerDTO> customerDTOS = new ArrayList<>();
        List<PlacesDTO> placesDTOS = new ArrayList<>();

        for (Customer customer : iterest.getCustomers()) {
            customerDTOS.add(buildCustomerDTO(customer));
        }

        for (Places places : iterest.getPlaces()) {
            placesDTOS.add(buildPlaceDTO(places));
        }

        interestDTO.setCustomerDTOS(customerDTOS);
        interestDTO.setStatus(iterest.getStatus());
        interestDTO.setPlacesDTo(placesDTOS);
        return interestDTO;
    }

    public PlacesDTO buildPlaceDTO(Places places) {
        if (places == null) {
            return null;
        }

        PlacesDTO placesDTO = new PlacesDTO();

        placesDTO.setAddDate(places.getAddDate() + "");
        placesDTO.setAddTime(places.getAddTime() + "");
        placesDTO.setBrokerDTO(buildBrokerDTO(places.getBroker()));
        placesDTO.setBrokID(places.getBroker().getId());
        placesDTO.setDescription(places.getDescription());
        placesDTO.setDistrictDTO(buildDistrictDTO(places.getDistrict()));
        placesDTO.setDisID(places.getDistrict().getId());
        placesDTO.setDocumrnts(places.getDocumrnts());
        placesDTO.setFacilities(placesDTO.getFacilities());
        placesDTO.setId(places.getId());
        placesDTO.setImages(places.getImages());
        placesDTO.setLandname(places.getLandname());
        placesDTO.setLatTude(places.getLatTude());
        placesDTO.setLoungTude(places.getLoungTude());
        placesDTO.setOwnerDTO(buildOwnerDTO(places.getOwner()));
        placesDTO.setOwnerID(places.getOwner().getId());
        placesDTO.setPerches(places.getPerches());
        placesDTO.setPerchPrice(places.getPerchPrice());
        placesDTO.setSoldDate(places.getSoldDate() + "");
        placesDTO.setSoldTime(places.getSoldTime() + "");
        placesDTO.setStatus(places.getStatus());
        placesDTO.setType(places.getType());

        return placesDTO;
    }


}
