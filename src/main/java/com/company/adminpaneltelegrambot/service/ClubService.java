package com.company.adminpaneltelegrambot.service;


import com.company.adminpaneltelegrambot.base.Done;
import com.company.adminpaneltelegrambot.dto.club.CreateClubRequest;
import com.company.adminpaneltelegrambot.dto.club.GetClubResponse;
import com.company.adminpaneltelegrambot.dto.club.UpdateClubRequest;
import com.company.adminpaneltelegrambot.entity.Club;
import com.company.adminpaneltelegrambot.enums.ClubType;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ClubService {


    Done addClub(CreateClubRequest request);

    Page<Club> findAll(int page,int pageSize);

    Page<Club> findAllByClubType(int page, int pageSize, ClubType clubType);

    GetClubResponse getOne(Integer clubId);

    Done updateClub(UpdateClubRequest clubId);

    Done deleteClub(Integer clubId);

    List<GetClubResponse> getAll();
}
