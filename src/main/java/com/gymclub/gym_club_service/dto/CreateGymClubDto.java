package com.gymclub.gym_club_service.dto;

public record CreateGymClubDto(
        String name,
        String location,
        long discount
) {}