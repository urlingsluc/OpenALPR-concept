# OpenALPR rest API
Before we start there is also a frontend
- [Frontend](https://https://github.com/FlorisFeddema/xti-parking-frontend)

## About
This project is made by students of the [Fontys University of applied sciences](https://fontys.nl/) in Eindhoven for the partner in education [XTi](https://www.xt-i.com). It's an application that is used for reserving a parking spot at a parking garage with the help of the REST and ORM.
We used part of the library [Spring](http://spring.io/). 


The project is meant to help people get a parking spot during busy hours so they can get to their appointment in time.
**Please notice** that this project is a proof-of-concept, not the actual finished product.

## How to use
The project has a main class which will set everything up.

### Parts

####Controllers
These are all the used controllers with their API calls.
- api/license/getPlate, takes an image and returns the found license plate in it. If there is no license plate it will return a 418 HTTP status.

####Exceptions
Here are the custom exceptions the API uses, these are supported with advices for the API controllers.

####Model
Here are all used classes in the model. There is only one class at this moment, this is the license class.

####Services
Here are all services that the controllers use, here is all logic.

####Appconfiguration
This is used to create a bean for the modelmapper and settings up the configuration for the application, such as the consmappings.

### CI/CD
Continuous integration and continuous development is done with [jenkins](https://jenkins.io/) and [docker](https://www.docker.com/).
The JenkinsFile in the root is used to create the pipeline in Jenkins, this can be altered if the pipeline has to change.
The DockerFile is used to create the docker container with the application in it. 

## Built with
- [Java 8](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Spring REST](https://spring.io/projects/spring-boot) 
- [Maven](https://maven.apache.org/)

## Dependencies
This application uses the [openALPR] (https://www.openalpr.com) API to check the images on license plates. To use this application in a production environment a license will be needed.

## Prerequisites
Maven [reimport](https://stackoverflow.com/questions/44243917/maven-dependencies-can-only-be-resolved-one-by-one-in-intellij?noredirect=1&lq=1) for dependecies.

## Authors
See the list of [contributors](https://github.com/FlorisFeddema/xti-parking-backend/graphs/contributors) who participated in this project.
<!---
## License
This project is licensed under the MIT License - see the [LICENSE.md](https://github.com/FlorisFeddema/xti-parking-backend/LICENSE.md) file for details
-->
