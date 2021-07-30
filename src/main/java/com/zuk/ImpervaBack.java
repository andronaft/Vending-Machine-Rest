package com.zuk;

import org.json.JSONException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.io.IOException;

@SpringBootApplication
@EnableJpaAuditing
public class ImpervaBack {

	public static void main(String[] args) {

		SpringApplication.run(ImpervaBack.class, args);


	}

}
