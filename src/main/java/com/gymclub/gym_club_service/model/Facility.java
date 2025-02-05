package com.gymclub.gym_club_service.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "facilities")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Facility {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToMany(mappedBy = "facilities")
    private Set<GymClub> gymClubs;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Facility facility)) return false;
        return Objects.equals(id, facility.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}