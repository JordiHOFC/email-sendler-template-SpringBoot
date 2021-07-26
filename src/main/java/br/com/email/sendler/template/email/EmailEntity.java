package br.com.email.sendler.template.email;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "Email")
public class EmailEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String propietario;
    private String emailDe;
    private String emailPara;
    private String titulo;
    @Column(columnDefinition = "TEXT")
    private String body;
    private LocalDateTime dataHoraEnvio=LocalDateTime.now();
    @Enumerated(EnumType.STRING)
    private StatusEnvio statusEmail;

    public EmailEntity(String propietario, String emailDe, String emailPara, String titulo, String body) {
        this.propietario = propietario;
        this.emailDe = emailDe;
        this.emailPara = emailPara;
        this.titulo = titulo;
        this.body = body;

    }

    @Deprecated
    public EmailEntity(){}

    public Long getId() {
        return id;
    }

    public String getPropietario() {
        return propietario;
    }

    public String getEmailDe() {
        return emailDe;
    }

    public String getEmailPara() {
        return emailPara;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getBody() {
        return body;
    }

    public LocalDateTime getDataHoraEnvio() {
        return dataHoraEnvio;
    }

    public StatusEnvio getStatusEmail() {
        return statusEmail;
    }

    public void vincularEstado(StatusEnvio status) {
        this.statusEmail=status;
    }
}
