package com.company.adminpaneltelegrambot.service.impl;

import com.company.adminpaneltelegrambot.base.Done;
import com.company.adminpaneltelegrambot.dto.event.CreateEventRequest;
import com.company.adminpaneltelegrambot.dto.event.GetEventResponse;
import com.company.adminpaneltelegrambot.dto.event.UpdateEventRequest;
import com.company.adminpaneltelegrambot.entity.Event;
import com.company.adminpaneltelegrambot.exception.ExceptionService;
import com.company.adminpaneltelegrambot.mapper.EventMapper;
import com.company.adminpaneltelegrambot.repository.EventRepository;
import com.company.adminpaneltelegrambot.service.EventService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.company.adminpaneltelegrambot.common.Errors.EVENT_NOT_FOUND;


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
        var entity = eventRepository.findById(request.getId()).orElseThrow(() -> new ExceptionService(EVENT_NOT_FOUND, HttpStatus.NOT_FOUND));
        eventMapper.updateEntity(entity, request);
        eventRepository.save(entity);
        return new Done(entity.getId());
    }

    @Override
    public GetEventResponse getOne(Integer eventId) {
        return eventMapper.toDto(eventRepository.findById(eventId).orElseThrow(() -> new ExceptionService(EVENT_NOT_FOUND, HttpStatus.NOT_FOUND)));
    }

    @Override
    public List<GetEventResponse> getAll() {
        return eventMapper.toList(eventRepository.findAll());
    }

    @Override
    @Transactional
    public Done deleteEvent(Integer eventId) {
        int id = eventRepository.deleteByIdAndReturn(eventId);
        if (id == 0) {
            throw new ExceptionService(EVENT_NOT_FOUND, HttpStatus.NOT_FOUND);
        }
        return new Done(id);
    }
}
