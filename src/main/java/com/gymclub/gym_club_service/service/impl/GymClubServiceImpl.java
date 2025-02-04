package com.gymclub.gym_club_service.service.impl;

import com.gymclub.gym_club_service.dto.CreateGymClubDto;
import com.gymclub.gym_club_service.dto.GymClubDto;
import com.gymclub.gym_club_service.mapper.GymClubMapper;
import com.gymclub.gym_club_service.model.GymClub;
import com.gymclub.gym_club_service.repository.GymClubRepository;
import com.gymclub.gym_club_service.service.GymClubService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class GymClubServiceImpl implements GymClubService {

    private final GymClubRepository gymClubRepository;
    private final GymClubMapper gymClubMapper;

    public GymClubServiceImpl(GymClubRepository gymClubRepository, GymClubMapper gymClubMapper) {
        this.gymClubRepository = gymClubRepository;
        this.gymClubMapper = gymClubMapper;
    }

    @Override
    public List<GymClubDto> getAll() {
        return gymClubRepository.findAll().stream()
                .map(gymClubMapper::toGymClubDto)
                .toList();
    }

    @Override
    public GymClubDto getById(Long id) {
        return gymClubRepository.findById(id)
                .map(gymClubMapper::toGymClubDto)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "GymClub not found with id: " + id));
    }

    @Override
    public GymClubDto save(CreateGymClubDto dto) {
        GymClub gymClub = gymClubMapper.toGymClub(dto);
        if (gymClub.getName() == null || gymClub.getName().isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "GymClub name cannot be empty");
        }
        if (gymClub.getLocation() == null || gymClub.getLocation().isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "GymClub location cannot be empty");
        }
        if (gymClub.getId() != null && gymClubRepository.existsById(gymClub.getId())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "GymClub with id already exists");
        }
        gymClub.setAnnualRevenue(0);

        return gymClubMapper.toGymClubDto(gymClubRepository.save(gymClub));
    }

    @Override
    public GymClubDto update(GymClubDto dto) {
        GymClub gymClub = gymClubMapper.toGymClub(dto);

        if (!gymClubRepository.existsById(gymClub.getId())) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "GymClub not found with id: " + gymClub.getId());
        }
        if (gymClub.getName() != null && !gymClub.getName().isBlank()) {
            gymClub.setName(gymClub.getName());
        }
        if (gymClub.getLocation() != null && !gymClub.getLocation().isBlank()) {
            gymClub.setLocation(gymClub.getLocation());
        }
        gymClub.setDiscount(gymClub.getDiscount());

        return gymClubMapper.toGymClubDto(gymClubRepository.save(gymClub));
    }

    @Override
    public boolean validateGymClub(String location) {
        if (!gymClubRepository.findByLocation(location).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No Gym clubs found in: " + location);
        }
        return true;
    }
}
