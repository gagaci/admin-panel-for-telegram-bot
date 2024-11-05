package com.company.adminpaneltelegrambot.controller;


import com.company.adminpaneltelegrambot.base.Done;
import com.company.adminpaneltelegrambot.base.Result;
import com.company.adminpaneltelegrambot.common.Path;
import com.company.adminpaneltelegrambot.dto.club.CreateClubRequest;
import com.company.adminpaneltelegrambot.dto.club.GetClubResponse;
import com.company.adminpaneltelegrambot.dto.club.UpdateClubRequest;
import com.company.adminpaneltelegrambot.service.ClubService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Path.CLUB)
@RequiredArgsConstructor
@Tag(name = "Club")
public class ClubController {

    private final ClubService clubService;


    @PostMapping
    public Result<Done> createClub(@RequestBody CreateClubRequest request) {
        return new Result<>(clubService.addClub(request));
    }


    @GetMapping("/{clubId}")
    public Result<GetClubResponse> getOne(@PathVariable Integer clubId) {
        return new Result<>(clubService.getOne(clubId));
    }

    @PutMapping()
    public Result<Done> update(@RequestBody UpdateClubRequest request) {
        return new Result<>(clubService.updateClub(request));
    }

    @DeleteMapping("/{clubId}")
    public Result<Done> delete(@PathVariable Integer clubId) {
        return new Result<>(clubService.deleteClub(clubId));
    }

    @GetMapping()
    public Result<List<GetClubResponse>> getAll(){
        return new Result<>(clubService.getAll());
    }
}
