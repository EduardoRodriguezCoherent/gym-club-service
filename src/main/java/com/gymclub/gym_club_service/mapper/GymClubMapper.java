package com.gymclub.gym_club_service.mapper;

import com.gymclub.gym_club_service.dto.CreateGymClubDto;
import com.gymclub.gym_club_service.dto.FacilityDto;
import com.gymclub.gym_club_service.dto.GymClubDto;
import com.gymclub.gym_club_service.model.Facility;
import com.gymclub.gym_club_service.model.GymClub;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GymClubMapper {

    GymClubDto toGymClubDto(GymClub gymClub);

    FacilityDto toGymClubDto(Facility facility);

    List<FacilityDto> toFacilityDtoList(List<Facility> facilities);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "facilities", ignore = true)
    @Mapping(target = "annualRevenue", ignore = true)
    GymClub toGymClub(CreateGymClubDto dto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "facilities", ignore = true)
    @Mapping(target = "annualRevenue", ignore = true)
    GymClub toGymClub(GymClubDto dto);
}
