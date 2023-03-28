# RestJavaProject

This is my study project. It is the CRUD application which consists of RESTful backend server implemented on Java with Spring Framework and frontend server implemanted on React JS.

## Repository structure
Codes of two servers divided into two directories: *backend_server* and *frontend_server*

## Docker
My project has Docker support. You can use it for simple setup and start of the app.

## Installation guide
To install and start project you only need to clone repository and run `docker-compose up -d` in root. 

Flag `-d` uses just for backgound running. If necessary, you can not write it.

## Some tips
In simple setup app will be able to run only on local machine. To fix it, you need to update the addres of backend server in frontend server code. For more details, read README.md in `frontend_server` directory.
