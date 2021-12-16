package com.parkinggo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EvalbdpApplication implements CommandLineRunner {

	private static Logger LOG = LoggerFactory.getLogger(EvalbdpApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(EvalbdpApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		LOG.info("############# Servicio Iniciado #############");

	}
}
