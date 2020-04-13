# SmartWeatherDemo

Приложение для прогноза погоды и умных советов
==================



Requirements for this project
==================

### Packaging and deploying

#### Main steps:
- Command to create an executable jar:

    $ mvn package

- Command to run the executable jar created on the previous step(with embedded Tomcat):

  java -jar  demo-0.0.1-SNAPSHOT.jar –spring.config.location=file://{PathForProperties.yml}

- After step 2 the application should be accessable by 'http://localhost:8080/weather-api' and will have two controller
 methods:
 * GET /configs/refresh to refresh app configuration with advices mapping in runtime
 * POST /info to get info about current weather in the city

- Command to install yarn packages:

  yarn install

- Command run frontend with vuejs:

  yarn serve

- After previos step the application should be accessable by 'http://localhost:8081/'
