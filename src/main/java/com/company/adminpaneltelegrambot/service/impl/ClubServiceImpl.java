package com.company.adminpaneltelegrambot.service.impl;


import com.company.adminpaneltelegrambot.base.Done;
import com.company.adminpaneltelegrambot.dto.club.CreateClubRequest;
import com.company.adminpaneltelegrambot.dto.club.GetClubResponse;
import com.company.adminpaneltelegrambot.dto.club.UpdateClubRequest;
import com.company.adminpaneltelegrambot.entity.Club;
import com.company.adminpaneltelegrambot.enums.ClubType;
import com.company.adminpaneltelegrambot.mapper.ClubMapper;
import com.company.adminpaneltelegrambot.repository.ClubRepository;
import com.company.adminpaneltelegrambot.service.ClubService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ClubServiceImpl implements ClubService {

    private final ClubRepository clubRepository;

    private final ClubMapper clubMapper;

    public ClubServiceImpl(ClubRepository clubRepository, ClubMapper clubMapper) {
        this.clubRepository = clubRepository;
        this.clubMapper = clubMapper;
    }


    @Override
    public Done addClub(CreateClubRequest request) {
        var club = clubMapper.toEntity(request);
        clubRepository.save(club);
        return new Done(club.getId());

    }

    @Override
    public Page<Club> findAll(int page, int pageSize) {
        return clubRepository.findAll(PageRequest.of(page, pageSize));
    }

    @Override
    public Page<Club> findAllByClubType(int page, int pageSize, ClubType clubType) {
        return clubRepository.findAllByClubType(PageRequest.of(page, pageSize), clubType);
    }

    @Override
    public GetClubResponse getOne(Integer clubId) {
        Club club = clubRepository.findById(clubId).orElseThrow();
        return clubMapper.toDTO(club);
    }

    @Override
    public Done updateClub(UpdateClubRequest request) {
        Club club = clubRepository.findById(request.getId()).orElseThrow();
        clubMapper.updateEntity(club, request);
        clubRepository.save(club);
        return new Done(club.getId());
    }

    @Override
    public Done deleteClub(Integer clubId) {
        clubRepository.deleteById(clubId);
        return new Done();
    }

    @Override
    public List<GetClubResponse> getAll() {
        return clubMapper.toList(clubRepository.findAll());
    }
}
