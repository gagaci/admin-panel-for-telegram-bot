package com.company.adminpaneltelegrambot.base;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Failure {

  @NotNull
  private final String message;

  private final String field;

  public Failure(String message) {
    this.message = message;
    this.field = null;
  }

  public Failure(String message, String field) {
    this.message = message;
    this.field = field;
  }
}
