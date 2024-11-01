package com.company.adminpaneltelegrambot.dto.club;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateClubRequest {

    private String name;

    private String description;

    private String photoId;

    private String founder;

    private String founderContact;

    private String clubType;

    private String contact;


}
