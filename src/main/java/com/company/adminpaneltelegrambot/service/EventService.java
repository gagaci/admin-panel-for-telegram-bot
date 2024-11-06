package com.company.adminpaneltelegrambot.service;

import com.company.adminpaneltelegrambot.base.Done;
import com.company.adminpaneltelegrambot.dto.event.CreateEventRequest;
import com.company.adminpaneltelegrambot.dto.event.GetEventResponse;
import com.company.adminpaneltelegrambot.dto.event.UpdateEventRequest;

import java.util.List;

public interface EventService {

    Done addEvent(CreateEventRequest request);

    Done updateEvent(UpdateEventRequest request);

    GetEventResponse getOne(Integer eventId);

    List<GetEventResponse> getAll();

    Done deleteEvent(Integer eventId);
}
