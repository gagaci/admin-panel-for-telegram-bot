package com.company.adminpaneltelegrambot.controller;

import com.company.adminpaneltelegrambot.base.Done;
import com.company.adminpaneltelegrambot.base.Result;
import com.company.adminpaneltelegrambot.common.Path;
import com.company.adminpaneltelegrambot.dto.event.GetEventResponse;
import com.company.adminpaneltelegrambot.dto.event.UpdateEventRequest;
import com.company.adminpaneltelegrambot.dto.event.CreateEventRequest;
import com.company.adminpaneltelegrambot.service.EventService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Path.EVENT)
@RequiredArgsConstructor
@Tag(name = "Event")
public class EventController {


    private final EventService eventService;

    @PostMapping()
    public Result<Done> createEvent(@RequestBody CreateEventRequest request) {
        return new Result<>(eventService.addEvent(request));
    }

    @PutMapping()
    public Result<Done> update(@RequestBody UpdateEventRequest request) {
        return new Result<>(eventService.updateEvent(request));
    }

    @GetMapping("/{eventId}")
    public Result<GetEventResponse> getOne(@PathVariable Integer eventId) {
        return new Result<>(eventService.getOne(eventId));
    }

    @GetMapping()
    public Result<List<GetEventResponse>> getAll() {
        return new Result<>(eventService.getAll());
    }

    @DeleteMapping("/{eventId}")
    public Result<Done> deleteEvent(@PathVariable Integer eventId){
        return new Result<>(eventService.deleteEvent(eventId));
    }
}
