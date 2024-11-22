package com.company.adminpaneltelegrambot.service.impl;

import static com.company.adminpaneltelegrambot.common.Errors.PROFESSOR_NOT_FOUND;

import com.company.adminpaneltelegrambot.base.Done;
import com.company.adminpaneltelegrambot.dto.professor.CreateProfessorRequest;
import com.company.adminpaneltelegrambot.dto.professor.GetProfessorResponse;
import com.company.adminpaneltelegrambot.dto.professor.UpdateProfessorRequest;
import com.company.adminpaneltelegrambot.entity.Professor;
import com.company.adminpaneltelegrambot.exception.ExceptionService;
import com.company.adminpaneltelegrambot.mapper.ProfessorMapper;
import com.company.adminpaneltelegrambot.repository.ProfessorRepository;
import com.company.adminpaneltelegrambot.service.ProfessorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProfessorServiceImpl implements ProfessorService {

  private final ProfessorRepository professorRepository;

  private final ProfessorMapper professorMapper;


  @Override
  public Done addProfessor(CreateProfessorRequest request) {
    Professor entity = professorMapper.toEntity(request);
    professorRepository.save(entity);
    return new Done(entity.getId());
  }

  @Override
  public GetProfessorResponse getOne(Integer professorId) {
    return professorMapper.toDto(professorRepository.findById(professorId)
        .orElseThrow(() -> new ExceptionService(PROFESSOR_NOT_FOUND,
            HttpStatus.NOT_FOUND)));
  }

  @Override
  public Done updateProfessor(UpdateProfessorRequest request) {
    return null;
  }
}
