package com.company.adminpaneltelegrambot.mapper;


import com.company.adminpaneltelegrambot.dto.club.CreateClubRequest;
import com.company.adminpaneltelegrambot.dto.club.GetClubResponse;
import com.company.adminpaneltelegrambot.dto.club.UpdateClubRequest;
import com.company.adminpaneltelegrambot.entity.Club;
import org.mapstruct.*;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;


@Mapper(componentModel = SPRING, unmappedSourcePolicy = ReportingPolicy.IGNORE, uses = {ClubMapper.class})
public interface ClubMapper {

    Club toEntity(final CreateClubRequest request);

    GetClubResponse toDTO(Club club);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntity(@MappingTarget Club entity, UpdateClubRequest dto);


}
