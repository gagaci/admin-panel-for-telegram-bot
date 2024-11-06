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
public class GetEventResponse {


    private Integer id;


    private String title;

    private String description;

    private String photoId;

    private String eventType;

    private String venue;

    private LocalDate date;

    private String eventOrganizedBy;
}
