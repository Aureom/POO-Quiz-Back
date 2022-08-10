package br.ufu.quiz.pooatividadefinalquiz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class PooAtividadeFinalQuizApplication {

	public static void main(String[] args) {
		SpringApplication.run(PooAtividadeFinalQuizApplication.class, args);
	}

}
