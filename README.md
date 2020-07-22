## Run project with data from CSV

1. In order to start the API with the data from the CSV please open up `./src/main/java/de/assecor/backend/datascource/CsvDatasource.java`.

2. Copy the absolute path of `./src/main/java/de/assecor/backend/assets/sample-input.csv` and assign it to the variable `path` in `./src/main/java/de/assecor/backend/datascource/CsvDatasource.java`.

## Run project with data from PostgreSQL

In order to start the API with a persistent PostgreSQL DB make sure you have docker installed and execute the following command:

    ```terminal
    docker run --name postgres-spring -e POSTGRES_PASSWORD=assecor -d -p 5432:5432 postgres:alpine
    ```
    
Check if the container is running: 

    ```terminal
    docker ps
    ```

    You should see something like:

        ```terminal
        CONTAINER ID        IMAGE               COMMAND                  CREATED             STATUS              PORTS                    NAMES
        f49eb9c68dd0        postgres:alpine     "docker-entrypoint.s…"   49 minutes ago      Up 49 minutes       0.0.0.0:5432->5432/tcp   postgres-spring
        ```
    
Bash into the container:
(Replace [CONTAINER ID] with the actual container id of your container)

    ```terminal
    docker exec -it [CONTAINER ID] bin/bash
    ```
    
Inside the container:

    ```terminal
    psql -U postgres
    ```
    
Create a database:

    ```terminal
    CREATE DATABASE assecorDb;
    ```
    
Verify that the database got created:

    ```terminal
    \l
    ```
    
    You should see something like:

        ```terminal
           Name    |  Owner   | Encoding |  Collate   |   Ctype    |   Access privileges   
        -----------+----------+----------+------------+------------+-----------------------
         assecordb | postgres | UTF8     | en_US.utf8 | en_US.utf8 | 
         postgres  | postgres | UTF8     | en_US.utf8 | en_US.utf8 | 
         template0 | postgres | UTF8     | en_US.utf8 | en_US.utf8 | =c/postgres          +
                   |          |          |            |            | postgres=CTc/postgres
         template1 | postgres | UTF8     | en_US.utf8 | en_US.utf8 | =c/postgres          +
                   |          |          |            |            | postgres=CTc/postgres
        (4 rows)
        ```
