package com.company.adminpaneltelegrambot.dto.club;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateClubRequest extends CreateClubRequest {

    private final Integer id;


    public UpdateClubRequest(String name, String description, String photoId, String founder, String founderContact, String clubType, String contact, Integer id) {
        super(name, description, photoId, founder, founderContact, clubType, contact);
        this.id = id;
    }
}
