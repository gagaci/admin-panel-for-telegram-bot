package com.company.adminpaneltelegrambot.mapper;

import com.company.adminpaneltelegrambot.dto.event.CreateEventRequest;
import com.company.adminpaneltelegrambot.dto.event.GetEventResponse;
import com.company.adminpaneltelegrambot.dto.event.UpdateEventRequest;
import com.company.adminpaneltelegrambot.entity.Event;
import org.mapstruct.*;

import java.util.List;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING, unmappedSourcePolicy = ReportingPolicy.IGNORE, uses = {ClubMapper.class})
public interface EventMapper {

    Event toEntity(CreateEventRequest request);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntity(@MappingTarget Event entity, UpdateEventRequest dto);

    GetEventResponse toDto(Event entity);

    List<GetEventResponse> toList(List<Event> events);
}
