package com.company.adminpaneltelegrambot.service.impl;

import com.company.adminpaneltelegrambot.base.Done;
import com.company.adminpaneltelegrambot.dto.event.CreateEventRequest;
import com.company.adminpaneltelegrambot.dto.event.GetEventResponse;
import com.company.adminpaneltelegrambot.dto.event.UpdateEventRequest;
import com.company.adminpaneltelegrambot.entity.Event;
import com.company.adminpaneltelegrambot.mapper.EventMapper;
import com.company.adminpaneltelegrambot.repository.EventRepository;
import com.company.adminpaneltelegrambot.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;

    private final EventMapper eventMapper;

    @Override
    public Done addEvent(CreateEventRequest request) {
        Event entity = eventRepository.save(eventMapper.toEntity(request));
        return new Done(entity.getId());
    }

    @Override
    public Done updateEvent(UpdateEventRequest request) {
        var entity = eventRepository.findById(request.getId()).orElseThrow();
        eventMapper.updateEntity(entity, request);
        eventRepository.save(entity);
        return new Done(entity.getId());
    }

    @Override
    public GetEventResponse getOne(Integer eventId) {
        return eventMapper.toDto(eventRepository.findById(eventId).orElseThrow());
    }

    @Override
    public List<GetEventResponse> getAll() {
        return eventMapper.toList(eventRepository.findAll());
    }

    @Override
    public Done deleteEvent(Integer eventId) {
        eventRepository.deleteById(eventId);
        return new Done();
    }
}
