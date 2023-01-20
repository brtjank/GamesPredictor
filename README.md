# GamesPredictor

## General info

The *GamesPredictor* is a simple java application for processing data about sport events passed in a JSON file. It includes providing information about teams taking part in given competition and about most probable results for given games. The information can be found in the *results.txt* file in the main application directory after running the application.

Passed JSON file should look like this:

<img width="341" alt="Zrzut ekranu 2023-01-20 o 13 46 06" src="https://user-images.githubusercontent.com/57538254/213698357-ee2c7ce4-42e3-44cf-9416-f68a958e0dd6.png">


Sample file *BE_data.json* is provided in the main application folder and it is used in the application. If user wants to pass custom file, it should be named and stored the same way as sample file.

The end goal is providing an application that stores information about sports events and its participants in a database, and provides services that use those information. It is being developed on the *service* branch. In order to build and run the application, user should follow the same instructions as given below.

## Technologies

Project was created with:
* Spring Boot 3.0.1.

## Requirements

The list of tools required to build and run the project:
* Open JDK 19.x+
* Apache Maven 3.8.x+

## Building

In order to build the application use the following command:

```
$ mvn install
```

## Running

In order to run the application go to *target* directory and execute the .jar file created during the building process with:

```
$ java -jar file_name
```

## License

Project is licensed under the [MIT](../master/LICENSE) license.
