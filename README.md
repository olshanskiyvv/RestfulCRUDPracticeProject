# RestfulCRUDPracticeProject

This is my study project. It is the CRUD application which consists of RESTful backend server implemented on Java with Spring Framework and frontend server implemented on React JS.

## Task
I need to create CRUD application based on MVC architecture. There some requirements to my project.
1. I need to keep some data about firearms: 
    - Serial number 
    - Type of weapon 
    - Name
    - Aiming range
    - Magazine capacity
    - Weight
    - Combat rate of fire
2. I have to use XML file type for storing data.
3. I have to use Java Spring Framework.

## Repository structure
Codes of two servers divided into two directories: *backend_server* and *frontend_server*

## Docker
My project has Docker support. You can use it for simple setup and start of the app.

## Installation guide
To install and start project you only need to clone repository and run `docker-compose up -d` in root. 

Flag `-d` uses just for background running. If necessary, you can not write it.

## Some tips
In simple setup app will be able to run only on local machine. To fix it, you need to update the address of backend server in frontend server code. For more details, read README.md in `frontend_server` directory.
