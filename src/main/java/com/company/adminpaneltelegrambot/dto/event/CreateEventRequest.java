package com.company.adminpaneltelegrambot.dto.event;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateEventRequest {

    public String title;

    public String description;

    public String photoId;

    public String eventType;

    public String venue;

    public LocalDate date;

    public String eventOrganizedBy;
}
