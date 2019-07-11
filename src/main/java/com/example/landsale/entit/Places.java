package com.example.landsale.entit;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

@Entity
public class Places {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String landname;
    private String facilities;
    private String description;
    private String type;
    private Double perchPrice;
    private Integer perches;
    @ElementCollection
    private List<String> images;
    private String status;
//    @Temporal(value = TemporalType.DATE)
    private Date addDate;
    private Time addTime;
//    @Temporal(value = TemporalType.DATE)
    private Date soldDate;
    private Time soldTime;
    private String latTude;
    private String loungTude;
    @ElementCollection
    private List<String> documrnts;

    @ManyToOne(cascade = CascadeType.ALL)
    private District district;

    @ManyToOne(cascade = CascadeType.ALL)
    private Owner owner;

    @ManyToOne(cascade = CascadeType.ALL)
    private Broker broker;

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

    public Date getAddDate() {
        return addDate;
    }

    public void setAddDate(Date addDate) {
        this.addDate = addDate;
    }

    public Time getAddTime() {
        return addTime;
    }

    public void setAddTime(Time addTime) {
        this.addTime = addTime;
    }

    public Date getSoldDate() {
        return soldDate;
    }

    public void setSoldDate(Date soldDate) {
        this.soldDate = soldDate;
    }

    public Time getSoldTime() {
        return soldTime;
    }

    public void setSoldTime(Time soldTime) {
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

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Broker getBroker() {
        return broker;
    }

    public void setBroker(Broker broker) {
        this.broker = broker;
    }
}
