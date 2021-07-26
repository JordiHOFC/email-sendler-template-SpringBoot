package br.com.email.sendler.template.email;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class EmailRequest {
    @NotBlank
    @JsonProperty
    private String propietario;
    @NotBlank
    @Email
    @JsonProperty
    private String emailDe;
    @NotBlank
    @Email
    @JsonProperty
    private String emailPara;
    @NotBlank
    @JsonProperty
    private String titulo;
    @NotBlank
    @JsonProperty
    private String body;

    public EmailEntity paraEmail() {
        return  new EmailEntity(propietario,emailDe,emailPara,titulo,body);
    }
}
