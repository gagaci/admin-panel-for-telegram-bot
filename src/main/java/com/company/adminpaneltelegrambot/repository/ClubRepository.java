package com.company.adminpaneltelegrambot.repository;


import com.company.adminpaneltelegrambot.entity.Club;
import com.company.adminpaneltelegrambot.enums.ClubType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ClubRepository extends JpaRepository<Club,Integer> {

    @Override
    Page<Club> findAll(Pageable pageable);

    Page<Club> findAllByClubType(Pageable pageable, ClubType clubType);

    @Modifying
    @Query("DELETE FROM Club c WHERE c.id = ?1")
    int deleteByIdAndReturn(Integer id);
}
