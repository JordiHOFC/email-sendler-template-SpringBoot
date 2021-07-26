package br.com.email.sendler.template;

import br.com.email.sendler.template.email.EmailEntity;
import br.com.email.sendler.template.email.EmailServer;
import br.com.email.sendler.template.email.EmailServerImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ModeloDeServidorDeEnvioDeEmailsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ModeloDeServidorDeEnvioDeEmailsApplication.class, args);
	}

}
