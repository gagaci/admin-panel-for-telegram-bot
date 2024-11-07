package com.company.adminpaneltelegrambot.service.impl;


import com.company.adminpaneltelegrambot.base.Done;
import com.company.adminpaneltelegrambot.dto.club.CreateClubRequest;
import com.company.adminpaneltelegrambot.dto.club.GetClubResponse;
import com.company.adminpaneltelegrambot.dto.club.UpdateClubRequest;
import com.company.adminpaneltelegrambot.entity.Club;
import com.company.adminpaneltelegrambot.enums.ClubType;
import com.company.adminpaneltelegrambot.exception.ExceptionService;
import com.company.adminpaneltelegrambot.mapper.ClubMapper;
import com.company.adminpaneltelegrambot.repository.ClubRepository;
import com.company.adminpaneltelegrambot.service.ClubService;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.company.adminpaneltelegrambot.common.Errors.CLUB_NOT_FOUND;

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
        Club club = clubRepository.findById(clubId).orElseThrow(() -> new ExceptionService(CLUB_NOT_FOUND, HttpStatus.NOT_FOUND));
        return clubMapper.toDTO(club);
    }

    @Override
    public Done updateClub(UpdateClubRequest request) {
        Club club = clubRepository.findById(request.getId()).orElseThrow(() -> new ExceptionService(CLUB_NOT_FOUND, HttpStatus.NOT_FOUND));
        clubMapper.updateEntity(club, request);
        clubRepository.save(club);
        return new Done(club.getId());
    }

    @Override
    @Transactional
    public Done deleteClub(Integer clubId) {
        int id = clubRepository.deleteByIdAndReturn(clubId);
        if (id == 0) {
            throw new ExceptionService(CLUB_NOT_FOUND, HttpStatus.NOT_FOUND);
        }
        return new Done(id);
    }

    @Override
    public List<GetClubResponse> getAll() {
        return clubMapper.toList(clubRepository.findAll());
    }
}
