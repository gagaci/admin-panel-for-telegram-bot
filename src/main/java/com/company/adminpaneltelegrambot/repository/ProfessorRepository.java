package com.company.adminpaneltelegrambot.repository;

import com.company.adminpaneltelegrambot.entity.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Integer> {

}
