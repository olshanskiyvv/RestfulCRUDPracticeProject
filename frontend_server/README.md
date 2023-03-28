# Frontend server part

Here is the code of frontend server part of my project.

## Structure

This is simple React JS application. 
- *public* directory keeps simple *index.html*. 
- *src* directory keeps JS files with components.

## Docker
You can install and run image of backend server.
Just run `docker build -t frontend_image ./frontend_server && docker run -p 3000:3000 --name frontend_container frontend_image` in repo root.

## Setup tip
In this state frontend can run only on local machine, because `baseUrl` variable in `App.js` file contains value `http://localhost:8080/`.

For correct work you need to replace this value with address of machine, where you run backend.
