# Backend server part

Here is the code of backend server part of my project.

## Structure
This the simple Java application.

All work is realized in 3 classes: **Controller**, **Service**, **Repository**

**Controller** class map requests to server, call service methods to process received data and get answer, than send response.

**Service** class realize business logic of project. In my case business logic is just serial number generating for new data.

**Repository** class realize working with storage. I store data in xml file. For hight usability I keep data in HashMap too.

## API

Backend maps requests to few URLs:

- `/`: This URL maps requests related with list of weapons: getting full list of weapons and appending new weapons.

- `/weapons/{id}`: This URL map requests related with certain weapon: getting, updating and deleting data of certain weapon.

- `/download`: This URL map request for export data to XML file.

- `/upload`: This URL map request for import data from XML file.

## Docker
You can install and run image of backend server.
Just run `docker build -t backend_image ./backend_server && docker run -p 8080:8080 --name backend_container backend_image` in repo root.