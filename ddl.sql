CREATE TABLE airport(
     id INT NOT NULL AUTO_INCREMENT,
     english_airport_name VARCHAR(100),
     korean_airport_name VARCHAR(100),
     IATA VARCHAR(10),
     ICAO VARCHAR(10),
     locale VARCHAR(10),
     english_country_name VARCHAR(100),
     korean_country_name VARCHAR(100),
     english_city_name VARCHAR(100),
    PRIMARY KEY(id)
     )AUTO_INCREMENT = 1;