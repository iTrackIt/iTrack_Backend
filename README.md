# I-Track Backend Application

---------------------------

Simple Student marks management system in springboot. Fork it, star it and contribute!!!

## Authors

-[Mugisha Precieux](https://github.com/mugishap)
-[Jazzy Bruno](https://github.com/jazzybruno)

How to test this application before it is hosted 

1. Clone the repository

```bash
git clone https://github.com/iTrackIt/iTrack_Backend.git
```


Run the program to install maven
```bash
 mvn install 
```

Add your database in the application.properties
```bash
spring.datasource.url=jdbc:mysql://localhost:3306/{your_database_name}
spring.datasource.username={your_username}
spring.datasource.password={your_password}
```

Then after installation of packages and adding your data
run the application and go to :
```bash
http://localhost:8000/swagger-ui.html
```

you can edit the port if you wish :
go to applcation.properties and add the port configuration
```bash
server.port = {the_port_you_choose}
```
