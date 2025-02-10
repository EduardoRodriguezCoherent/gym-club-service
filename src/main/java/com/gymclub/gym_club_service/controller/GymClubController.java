package com.gymclub.gym_club_service.controller;

import com.gymclub.gym_club_service.dto.CreateGymClubDto;
import com.gymclub.gym_club_service.dto.GymClubDto;
import com.gymclub.gym_club_service.service.GymClubService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/gym-clubs")
public class GymClubController {

    private final GymClubService gymClubService;

    public GymClubController(GymClubService gymClubService) {
        this.gymClubService = gymClubService;
    }

    @GetMapping
    public ResponseEntity<List<GymClubDto>> getAllGymClubs() {
        return ResponseEntity.ok(gymClubService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GymClubDto> getGymClubById(@PathVariable Long id) {
        return ResponseEntity.ok(gymClubService.getById(id));
    }

    @PostMapping
    public ResponseEntity<GymClubDto> createGymClub(@RequestBody CreateGymClubDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(gymClubService.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<GymClubDto> updateGymClub(@RequestBody GymClubDto dto) {
        return ResponseEntity.ok(gymClubService.update(dto));
    }

    @GetMapping("/validateClubByLocation")
    public ResponseEntity<Boolean> validateClubByLocation(@RequestParam String location) {
        return ResponseEntity.ok(gymClubService.validateGymClub(location));
    }

    @GetMapping("/validateClubFacility")
    public ResponseEntity<Boolean> validateClubFacility(@RequestParam Long clubId,
                                                        @RequestParam Long facilityId){
        return ResponseEntity.ok(gymClubService.validateFacilityInClub(clubId, facilityId));
    }
}
