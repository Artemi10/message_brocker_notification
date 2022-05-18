# Devanmejia Message-broker application
>Simple message broker project

![Logo](images/logo.png "Project Logo")

## Table of Contents
* [General Info](#general-info)
* [Technologies Used](#technologies-used)
* [Features](#features)
* [Deployment](#deployment)
* [Contact](#contact)

## General Info
- Application with microservice architecture which allows user to send them log in or sign up notifications. 

## Technologies Used
- Java 17
- Spring Boot:
    * Spring CLoud
    * Spring Web
    * RabbitMQ
- Lombok
- MongoDB
- Docker
- Docker compose

## Features
- Application allows user to log in and sign up into system.
- Application will send notification email when user sign up or log in.
- Users can easily generate stats which consist of amount of notification amount by email.

![Main page](images/architecture.png "Architecture")

## Deployment
- Download git project
> git clone https://github.com/Artemi10/simbirsoft.git
- Enter to project directory
> cd ./simbirsoft
- Chose volga-it branch
> git checkout volga-it
- Create Google OAuth client ID credentials (Set http://localhost:8080/login/oauth2/code/google as Authorized redirect URIs)
> https://console.cloud.google.com/apis/credentials
- Add to docker-compose.yml file generated Client ID
> sed -i 's|- GOOGLE_CLIENT_ID=${client_id}|- GOOGLE_CLIENT_ID=YOUR_CLIENT_ID|' docker-compose.yml
- Add to docker-compose.yml file generated Client Secret
> sed -i 's|- GOOGLE_CLIENT_SECRET=${client_secret}|- GOOGLE_CLIENT_SECRET=YOUR_CLIENT_SECRET|' docker-compose.yml
- Start docker engine
- Run docker-compose command
> docker-compose up
- Open project in browser
> http://localhost:8080/

![Deployment commands](screenshots/commands.png "Deployment commands")

## Execution
- http://localhost:8080/api/v1/auth/sign-up - Sign Up User
- http://localhost:8080/api/v1/auth/log-in - Log in User
- http://localhost:8080/api/v1/stats - Get all stats
- http://localhost:8080/api/v1/stats/email/${email} - Get stats by email

## Contact
- Vk: https://vk.com/devanmejia
- Email: lyah.artem10@mail.ru
