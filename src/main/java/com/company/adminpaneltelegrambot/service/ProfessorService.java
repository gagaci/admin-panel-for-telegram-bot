package com.company.adminpaneltelegrambot.service;

import com.company.adminpaneltelegrambot.base.Done;
import com.company.adminpaneltelegrambot.dto.professor.CreateProfessorRequest;
import com.company.adminpaneltelegrambot.dto.professor.GetProfessorResponse;
import com.company.adminpaneltelegrambot.dto.professor.UpdateProfessorRequest;

public interface ProfessorService {

  Done addProfessor(CreateProfessorRequest request);

  GetProfessorResponse getOne(Integer professorId);

  Done updateProfessor(UpdateProfessorRequest request);
}
