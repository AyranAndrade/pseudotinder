CREATE TABLE sexual_orientations (
	PRIMARY KEY (sexual_orientation_id),
	sexual_orientation_id 	INTEGER 	NOT NULL 	AUTO_INCREMENT,
    name 					VARCHAR(30) NOT NULL 	UNIQUE,
    created_at				TIMESTAMP	NOT NULL	DEFAULT NOW()
);

CREATE TABLE genders (
	PRIMARY KEY (gender_id),
	gender_id 	INTEGER 	NOT NULL 	AUTO_INCREMENT,
    name 		VARCHAR(20) NOT NULL 	UNIQUE,
    created_at	TIMESTAMP	NOT NULL	DEFAULT NOW()
);

CREATE TABLE professions (
	PRIMARY KEY (profession_id),
	profession_id 	INTEGER 	NOT NULL 	AUTO_INCREMENT,
    name 			VARCHAR(100) NOT NULL 	UNIQUE,
    created_at		TIMESTAMP	NOT NULL	DEFAULT NOW()
);

CREATE TABLE states (
	PRIMARY KEY (state_id),
	state_id 	INTEGER 	NOT NULL 	AUTO_INCREMENT,
    name 		VARCHAR(30) NOT NULL 	UNIQUE,
    created_at	TIMESTAMP	NOT NULL	DEFAULT NOW()
);

CREATE TABLE cities (
	PRIMARY KEY (city_id),
	city_id 	INTEGER 	NOT NULL 	AUTO_INCREMENT,
    name 		VARCHAR(40) NOT NULL,
    created_at	TIMESTAMP	NOT NULL	DEFAULT NOW(),
    state_id 	INTEGER 	NOT NULL,
		FOREIGN KEY (state_id) REFERENCES states (state_id)
);

CREATE TABLE regions (
	PRIMARY KEY (region_id),
    region_id	INTEGER		NOT NULL 	AUTO_INCREMENT,
    name 		VARCHAR(40)	NOT NULL,
    created_at	TIMESTAMP	NOT NULL	DEFAULT NOW(),
    city_id 	INTEGER		NOT NULL,
		FOREIGN KEY (city_id) REFERENCES cities (city_id)
);

CREATE TABLE streets (
	PRIMARY KEY (street_id),
	street_id 	INTEGER 	NOT NULL 	AUTO_INCREMENT,
    name 		VARCHAR(60) NOT NULL,
    number 		INTEGER,
    created_at	TIMESTAMP	NOT NULL	DEFAULT NOW(),
    region_id 	INTEGER 	NOT NULL,
		FOREIGN KEY (region_id) REFERENCES regions (region_id)
);

CREATE TABLE people (
	PRIMARY KEY (people_id),
    people_id 				INTEGER 		NOT NULL 	AUTO_INCREMENT,
    name 					VARCHAR(60) 	NOT NULL,
    birth_date				DATE			NOT NULL,
    about_me				VARCHAR(1000)	NOT NULL,
    elo_score_rating		INTEGER			NOT NULL,
    max_distance_kilometer	DECIMAL(7,3)	NOT NULL,
    created_at				TIMESTAMP		NOT NULL	DEFAULT NOW(),
    active					BOOLEAN			NOT NULL	DEFAULT TRUE,
    age_range_start			INTEGER			NOT NULL,
		CONSTRAINT minimum_age CHECK (age_range_start >= 18),
    age_range_end			INTEGER			NOT NULL,
		CONSTRAINT maximum_age_must_be_greater_than_the_minimum_age CHECK (age_range_end >= age_range_start),
    sexual_orientation_id	INTEGER			NOT NULL,
		FOREIGN KEY (sexual_orientation_id) REFERENCES sexual_orientations (sexual_orientation_id),
	gender_id 				INTEGER			NOT NULL,
		FOREIGN KEY (gender_id) 			REFERENCES genders (gender_id),
	profession_id			INTEGER			NOT NULL,
		FOREIGN KEY (profession_id)			REFERENCES professions (profession_id),
	street_id				INTEGER			NOT NULL,
		FOREIGN KEY (street_id)				REFERENCES streets (street_id)
);

CREATE TABLE photos (
	PRIMARY KEY (photo_id),
    photo_id 	INTEGER 		NOT NULL 	AUTO_INCREMENT,
    url_or_path	VARCHAR(1024)	NOT NULL,
    upload_at	TIMESTAMP		NOT NULL	DEFAULT NOW(),
    active		BOOLEAN			NOT NULL	DEFAULT TRUE,
    people_id 	INTEGER			NOT NULL,
		FOREIGN KEY (people_id)	REFERENCES people (people_id)
);

CREATE TABLE messages (
	PRIMARY KEY (message_id),
    message_id INTEGER 			NOT NULL 	AUTO_INCREMENT,
    message	   VARCHAR(1000)	NOT NULL,
    sent_at	   TIMESTAMP		NOT NULL	DEFAULT NOW(),
    sent_from  INTEGER			NOT NULL,
		FOREIGN KEY (sent_from) REFERENCES people (people_id),
	sent_to	   INTEGER			NOT NULL,
		FOREIGN KEY (sent_to)	REFERENCES people (people_id),
	active	   BOOLEAN			NOT NULL	DEFAULT TRUE    
);

CREATE TABLE matches (
	PRIMARY KEY (people_id, people_judged_id),
    people_id 		 INTEGER 			NOT NULL,
	people_judged_id INTEGER 			NOT NULL,
		FOREIGN KEY (people_id) 		REFERENCES people (people_id),
        FOREIGN KEY (people_judged_id) 	REFERENCES people (people_id),
	liked 			 BOOLEAN			NOT NULL,
    created_at		 TIMESTAMP			NOT NULL 	DEFAULT NOW()
);