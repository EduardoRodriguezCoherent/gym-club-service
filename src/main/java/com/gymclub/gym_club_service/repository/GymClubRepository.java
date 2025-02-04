package com.gymclub.gym_club_service.repository;

import com.gymclub.gym_club_service.model.GymClub;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GymClubRepository extends JpaRepository<GymClub, Long> {
    List<GymClub> findByLocation(String location);
}