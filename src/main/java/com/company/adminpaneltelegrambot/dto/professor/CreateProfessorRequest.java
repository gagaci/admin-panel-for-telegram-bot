package com.company.adminpaneltelegrambot.dto.professor;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateProfessorRequest {

  private String fullName;

  private String photoId;

  private String background;

  private String linkedInAccount;

  private String email;



}
