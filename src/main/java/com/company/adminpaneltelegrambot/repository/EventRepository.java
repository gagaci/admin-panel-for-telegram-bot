package com.company.adminpaneltelegrambot.repository;

import com.company.adminpaneltelegrambot.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event,Integer> {
}
