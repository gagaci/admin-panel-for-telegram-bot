package com.company.adminpaneltelegrambot.repository;


import com.company.adminpaneltelegrambot.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {

  @Modifying
  @Query("DELETE FROM Event e WHERE e.id = ?1")
  int deleteByIdAndReturn(Integer id);
}
