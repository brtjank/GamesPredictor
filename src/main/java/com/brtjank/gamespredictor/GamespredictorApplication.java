package com.brtjank.gamespredictor;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.brtjank.gamespredictor.models.Event;
import com.brtjank.gamespredictor.models.Events;
import com.brtjank.gamespredictor.services.CompetitorService;
import com.brtjank.gamespredictor.services.EventService;
import com.brtjank.gamespredictor.services.VenueService;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class GamespredictorApplication {

	public static void main(String[] args) throws StreamReadException, DatabindException, IOException{
		SpringApplication.run(GamespredictorApplication.class, args);

/*		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
		File file = new File("../BE_data.json");
		System.out.print(file.getPath());
		Events events =  objectMapper.readValue(file, Events.class);

		System.out.print("\nHow many games predictions do you want to print?\n");
		Scanner in = new Scanner(System.in);
		int number = in.nextInt();
		System.out.print(events.getMultiplePredictions(number));

		System.exit(0);
	*/
	}

	@Bean
	CommandLineRunner runner (EventService eventService, VenueService venueService, CompetitorService competitorService){
		return args -> {
			ObjectMapper objectMapper = new ObjectMapper();
			objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
			File file = new File("BE_data.json");
			System.out.print(file.getPath());
			Events events =  objectMapper.readValue(file, Events.class);

			for (Event e : events.getAll()){
				System.out.print(e.getCompetitors().get(0));
				venueService.save(e.getVenue());
				competitorService.save(e.getCompetitors().get(0));
				competitorService.save(e.getCompetitors().get(1));
				eventService.save(e);
			}
	
			System.out.print("How many games predictions do you want to print?\n");
			Scanner in = new Scanner(System.in);
			int number = in.nextInt();
			System.out.print(events.getMultiplePredictions(number));
		};
	}
	
}