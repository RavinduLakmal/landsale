package com.example.landsale.dto;


import java.util.List;

public class PlacesDTO {

    private Long id;
    private String landname;
    private String facilities;
    private String description;
    private String type;
    private Double perchPrice;
    private Integer perches;
    private List<String> images;
    private String status;
    private String addDate;
    private String addTime;
    private String soldDate;
    private String soldTime;
    private String latTude;
    private String loungTude;
    private List<String> documrnts;
    private Long disID;
    private DistrictDTO districtDTO;
    private Long ownerID;
    private OwnerDTO ownerDTO;
    private Long brokID;
    private BrokerDTO brokerDTO;

    public Long getBrokID() {
        return brokID;
    }

    public void setBrokID(Long brokID) {
        this.brokID = brokID;
    }

    public BrokerDTO getBrokerDTO() {
        return brokerDTO;
    }

    public void setBrokerDTO(BrokerDTO brokerDTO) {
        this.brokerDTO = brokerDTO;
    }

    public Long getDisID() {
        return disID;
    }

    public void setDisID(Long disID) {
        this.disID = disID;
    }

    public Long getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(Long ownerID) {
        this.ownerID = ownerID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLandname() {
        return landname;
    }

    public void setLandname(String landname) {
        this.landname = landname;
    }

    public String getFacilities() {
        return facilities;
    }

    public void setFacilities(String facilities) {
        this.facilities = facilities;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getPerchPrice() {
        return perchPrice;
    }

    public void setPerchPrice(Double perchPrice) {
        this.perchPrice = perchPrice;
    }

    public Integer getPerches() {
        return perches;
    }

    public void setPerches(Integer perches) {
        this.perches = perches;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAddDate() {
        return addDate;
    }

    public void setAddDate(String addDate) {
        this.addDate = addDate;
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    public String getSoldDate() {
        return soldDate;
    }

    public void setSoldDate(String soldDate) {
        this.soldDate = soldDate;
    }

    public String getSoldTime() {
        return soldTime;
    }

    public void setSoldTime(String soldTime) {
        this.soldTime = soldTime;
    }

    public String getLatTude() {
        return latTude;
    }

    public void setLatTude(String latTude) {
        this.latTude = latTude;
    }

    public String getLoungTude() {
        return loungTude;
    }

    public void setLoungTude(String loungTude) {
        this.loungTude = loungTude;
    }

    public List<String> getDocumrnts() {
        return documrnts;
    }

    public void setDocumrnts(List<String> documrnts) {
        this.documrnts = documrnts;
    }

    public DistrictDTO getDistrictDTO() {
        return districtDTO;
    }

    public void setDistrictDTO(DistrictDTO districtDTO) {
        this.districtDTO = districtDTO;
    }

    public OwnerDTO getOwnerDTO() {
        return ownerDTO;
    }

    public void setOwnerDTO(OwnerDTO ownerDTO) {
        this.ownerDTO = ownerDTO;
    }
}
