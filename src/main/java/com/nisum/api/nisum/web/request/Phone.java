package com.nisum.api.nisum.web.request;

import javax.validation.constraints.NotBlank;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Phone {

  @NotBlank
  public String number;

  @NotBlank
  @JsonProperty("citycode")
  public String cityCode;

  @NotBlank
  @JsonProperty("contrycode")
  public String contryCode;

}
