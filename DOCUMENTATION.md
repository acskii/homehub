## Documentation

> Documents all relevant configurations, considerations and information that are 
> essential within this system.
> 
> -Andrew Sameh (acskii)

### Table of Contents

- Configurations
  - [Environment Variables](#environment-variables)
  - [Docker Secrets](#docker-secrets)

- Considerations
  - [Database Backup](#database-backup)


### Environment Variables

> [**P**] stands for **_Production_**
>
> [**D**] stands for **_Development_**

You are required to set these environment variables in your run configurations before you
run the main application, to prevent any errors thrown.

|        Variable         |                           Value                            | Used in                 | Stage(s) |
|:-----------------------:|:----------------------------------------------------------:|-------------------------|:--------:|
|`SPRING_PROFILES_ACTIVE` | Active profile for Spring [use **prod**/**dev** for stage] | _application.yaml_      |   Any    |
|   `PROD_DATABASE_URL`   |            JDBC URL for the production database            | _application-prod.yaml_ |    P     |
|   `TEST_DATABASE_URL`   |     JDBC URL for the testing and development database      | _application-dev.yaml_  |    D     |
|   `DATABASE_USERNAME`   |           Username registered in both databases            | _application.yaml_      | P and D  |
|   `DATABASE_PASSWORD`   |       Password for authentication in both databases        | _application.yaml_      | P and D  |

---

### Docker Secrets

You are required to ensure that a /secrets folder exists within this repository.

Create a `.txt` file for each secret mentioned, according to the `docker-compose.yaml` **secrets** section. Here is a table 
of all secrets that you should be aware of before you start up the containers:


|       Secret        |                            Value                             | Filename                       |
|:-------------------:|:------------------------------------------------------------:|--------------------------------|
| `database_username` | Username for both PostgreSQL production and testing database | /secrets/DATABASE_USERNAME.txt |
| `database_password` | Password for both PostgreSQL production and testing database | /secrets/DATABASE_PASSWORD.txt |


Use the command below to start the Docker containers that are listed in the 
**services** section of the `docker-compose.yaml`:

```bash
homehub> docker-compose up -d
```

You can also use this command below to peek at the logs of a specific service to 
ensure it is running correctly:

```bash
homehub> docker-compose logs [service-name]
```

---

### Database Backup

Use `pg_dump` and `pg_restore`