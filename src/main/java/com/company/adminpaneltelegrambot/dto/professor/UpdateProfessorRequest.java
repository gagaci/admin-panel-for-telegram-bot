package com.company.adminpaneltelegrambot.dto.professor;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateProfessorRequest extends CreateProfessorRequest {

  private final Integer id;

  public UpdateProfessorRequest(String fullName, String photoId, String background,
      String linkedInAccount, String email, Integer id) {
    super(fullName, photoId, background, linkedInAccount, email);
    this.id = id;
  }

}
