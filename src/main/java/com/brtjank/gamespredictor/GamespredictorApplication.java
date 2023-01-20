package com.brtjank.gamespredictor;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.brtjank.gamespredictor.services.Events;
import com.brtjank.gamespredictor.services.Competitors;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class GamespredictorApplication {

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		SpringApplication.run(GamespredictorApplication.class, args);

		try {
			// text file to write to
			FileWriter myWriter = new FileWriter("../results.txt");

			// mapping given json to java objects
			ObjectMapper objectMapper = new ObjectMapper();
			objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
			Events events =  objectMapper.readValue(new File("../BE_data.json"), Events.class);

			// user can choose which competition he wants to see the teams from if there is more than one
			System.out.println("Please type the name of the competition you want to print the teams from\n" +
								"You can choose from the following:\n" + 
								events.getCompetitionsNames() +
								"\nIf there is just one competition or you want to print all of the stored teams names press Enter");
			Scanner in = new Scanner(System.in);
			String line = in.nextLine();

			// storing information about teams competing in a given competition
			Competitors competitors = new Competitors();
			competitors.addCompetitors(events, line);
			competitors.printSorted(line, myWriter);

			// user can choose how many predictions he wants to see
			System.out.println("How many games predictions do you want to print?");
			in = new Scanner(System.in);
			int number = in.nextInt();
			
			// writing predictions to a file
			myWriter.write(events.getMultiplePredictions(number));
			myWriter.close();
			System.out.println("Successfully wrote to the file.");
		} 
		catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
}
