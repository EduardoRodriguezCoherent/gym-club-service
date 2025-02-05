package com.gymclub.gym_club_service.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Objects;
import java.util.Set;

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

    @ManyToMany
    @JoinTable(
            name = "gym_club_facilities", // name of join table
            joinColumns = @JoinColumn(name = "gym_club_id"), // GymClub foreign key
            inverseJoinColumns = @JoinColumn(name = "facility_id") // Facility foreign key
    )
    private Set<Facility> facilities;

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

    public Set<Facility> getFacilities() {
        return facilities;
    }

    public void setFacilities(Set<Facility> facilities) {
        this.facilities = facilities;
    }

    public long getAnnualRevenue() {
        return annualRevenue;
    }

    public void setAnnualRevenue(long annualRevenue) {
        this.annualRevenue = annualRevenue;
    }
}