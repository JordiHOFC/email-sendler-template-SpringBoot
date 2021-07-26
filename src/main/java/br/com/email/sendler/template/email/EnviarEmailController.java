package br.com.email.sendler.template.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/api/v1/send-email")
public class EnviarEmailController {

    @Autowired
    private  EmailServer server;

    @PostMapping
    public ResponseEntity<?> sendEmail(@RequestBody @Valid EmailRequest request) {
        EmailEntity email = request.paraEmail();
        server.sendEmail(email);
        URI location = UriComponentsBuilder.fromUriString("/api/v1/email/{id}").buildAndExpand(email.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
}
