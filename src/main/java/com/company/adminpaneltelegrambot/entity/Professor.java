package com.company.adminpaneltelegrambot.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "professors")
@NoArgsConstructor
public class Professor {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Integer id;

  @Column(name = "full_name",nullable = false)
  private String fullName;

  @Column(name = "photo_id",nullable = false)
  private String photoId;

  @Column(name = "background",nullable = false)
  private String background;

  @Column(name = "linkedin_account",nullable = false)
  private String linkedInAccount;

  @Column(name = "email",nullable = false)
  private String email;


  public Professor(String fullName, String photoId, String background, String linkedInAccount, String email) {
    this.fullName = fullName;
    this.photoId = photoId;
    this.background = background;
    this.linkedInAccount = linkedInAccount;
    this.email = email;
  }
}