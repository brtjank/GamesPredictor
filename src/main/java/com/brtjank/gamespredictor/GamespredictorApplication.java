package com.brtjank.gamespredictor;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.brtjank.gamespredictor.models.Event;
import com.brtjank.gamespredictor.models.Events;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class GamespredictorApplication {

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		SpringApplication.run(GamespredictorApplication.class, args);

        ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
		Events events =  objectMapper.readValue(new File("../BE_data.json"), Events.class);

		System.out.print("How many games predictions do you want to print?\n");
		Scanner in = new Scanner(System.in);
		int number = in.nextInt();
		System.out.print(events.getMultiplePredictions(number));
	}
}