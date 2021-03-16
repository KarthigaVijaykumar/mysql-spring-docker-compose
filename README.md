# mysql-spring-docker-compose
Created two containers [Mysql &amp; Spring] through docker compose
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Creating Mysql image:
-------------------------
Pull mysql:5.7 image from dockerhub

->docker pull mysql:5.7

Run the mysql image and create the container

->docker run -d -p 6033:3306 --name=mysql-docker --env="MYSQL_ROOT_PASSWORD=root123" --env="MYSQL_PASSWORD=root123" --env="MYSQL_DATABASE=demo" mysql:5.7

Now the container and the image for the mysql is manually created.

----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Creating image for our spring boot application
----------------------------------------------
Create the dockerfile and docker-compose.yml file as mentioned

Create the .jar by executing mvn install.

[In this case it throws unknown host error as application.properties has the mysql container as database. So use mvn package -DskipTests to create the jar]

Now create the spring boot image by building the dockerfile

->docker build -f Dockerfile -t spring-mysql-docker .

[Here Dockerfile is the name of the dockerfile that yu have created].

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Create the containers through dockercompose
--------------------------------------------
->docker-compose -f docker-compose.yml up/docker compose up

Now both the containers will be running inside the docker.

Examine the ports on which the containers are running.Yu can use these ports to give the access the data.

In my case, my springboot container runs on 8082 port.

We can use postman to give inputs and can also see it in the chrome[http://localhost:8082/getPassengers].

And mysql container runs on 3307 port.

Open workbench and add new by giving localhost and 3307 as name and port.

Give the password of the mysql container yu have created.

The data that we are giving as input in the postman will be stored in this database.
