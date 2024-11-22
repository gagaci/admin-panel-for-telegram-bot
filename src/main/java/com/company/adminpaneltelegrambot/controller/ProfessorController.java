package com.company.adminpaneltelegrambot.controller;

import com.company.adminpaneltelegrambot.base.Done;
import com.company.adminpaneltelegrambot.base.Result;
import com.company.adminpaneltelegrambot.common.Path;
import com.company.adminpaneltelegrambot.dto.professor.CreateProfessorRequest;
import com.company.adminpaneltelegrambot.dto.professor.GetProfessorResponse;
import com.company.adminpaneltelegrambot.dto.professor.UpdateProfessorRequest;
import com.company.adminpaneltelegrambot.service.ProfessorService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Path.PROFESSOR)
@RequiredArgsConstructor
@Tag(name = "professor")
public class ProfessorController {

  private final ProfessorService professorService;

  @PostMapping()
  public Result<Done> addProfessor(@RequestBody CreateProfessorRequest request) {
    return new Result<>(professorService.addProfessor(request));
  }

  @GetMapping("/{professorId}")
  public Result<GetProfessorResponse> getOne(@PathVariable Integer professorId) {
    return new Result<>(professorService.getOne(professorId));
  }

  @PutMapping()
  public Result<Done> updateProfessor(@RequestBody UpdateProfessorRequest request){
   return new Result<>(professorService.updateProfessor(request));
  }
}
