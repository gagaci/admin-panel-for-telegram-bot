package com.company.adminpaneltelegrambot.mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

import com.company.adminpaneltelegrambot.dto.professor.CreateProfessorRequest;
import com.company.adminpaneltelegrambot.dto.professor.GetProfessorResponse;
import com.company.adminpaneltelegrambot.entity.Professor;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = SPRING, unmappedSourcePolicy = ReportingPolicy.IGNORE, uses = {
    ProfessorMapper.class})
public interface ProfessorMapper {

  Professor toEntity(CreateProfessorRequest request);

  GetProfessorResponse toDto(Professor professor);

}
