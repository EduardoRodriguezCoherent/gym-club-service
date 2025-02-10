package com.gymclub.gym_club_service.service;

import com.gymclub.gym_club_service.dto.CreateGymClubDto;
import com.gymclub.gym_club_service.dto.GymClubDto;

import java.util.List;

public interface GymClubService {

    List<GymClubDto> getAll();

    GymClubDto getById(Long id);

    GymClubDto save(CreateGymClubDto entity);

    GymClubDto update(GymClubDto entity);

    boolean validateGymClub(String location);

    boolean validateFacilityInClub(Long clubId, Long facilityId);
}
