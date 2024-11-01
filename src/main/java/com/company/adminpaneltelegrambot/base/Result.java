package com.company.adminpaneltelegrambot.base;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@JsonInclude(Include.NON_NULL)
@Getter
public class Result<T> {

  private final T data;
  private final Failure error;

  @NotNull
  private final boolean success;

  public Result(T body) {
    this.data = body;
    this.success = true;
    this.error = null;
  }

  public Result(Failure error) {
    this.error = error;
    this.success = false;
    this.data = null;
  }
}
