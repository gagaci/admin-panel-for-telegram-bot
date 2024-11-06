package com.company.adminpaneltelegrambot.dto.event;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class UpdateEventRequest extends CreateEventRequest {

    private final Integer id;

    public UpdateEventRequest(String title, String description, String photoId, String eventType, String venue, LocalDate date, String eventOrganizedBy, Integer id) {
        super(title, description, photoId, eventType, venue, date, eventOrganizedBy);
        this.id = id;
    }

}
