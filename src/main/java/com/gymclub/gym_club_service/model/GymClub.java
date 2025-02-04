package com.gymclub.gym_club_service.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "gym_clubs")
@NoArgsConstructor
@AllArgsConstructor
public class GymClub {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private long discount;

    @Column(name = "annual_revenue")
    private long annualRevenue;

    @OneToMany(mappedBy = "gymClub",
            cascade = CascadeType.ALL)
    private List<Facility> facilities;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GymClub gymClub)) return false;
        return Objects.equals(id, gymClub.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public long getDiscount() {
        return discount;
    }

    public void setDiscount(long discount) {
        this.discount = discount;
    }

    public List<Facility> getFacilities() {
        return facilities;
    }

    public void setFacilities(List<Facility> facilities) {
        this.facilities = facilities;
    }

    public long getAnnualRevenue() {
        return annualRevenue;
    }

    public void setAnnualRevenue(long annualRevenue) {
        this.annualRevenue = annualRevenue;
    }
}