

CREATE TABLE event (
    id bigserial NOT NULL,
    level varchar(10) NOT NULL,
	description varchar(255) NOT NULL,
	source varchar(150) NOT NULL,
	date timestamp NOT NULL,
	number int
);


CREATE TABLE logger (
    id bigserial NOT NULL,
    description varchar(255) NOT NULL,
	event_id bigint NOT NULL
);



ALTER TABLE ONLY event
    ADD CONSTRAINT event_pkey PRIMARY KEY (id);
	
ALTER TABLE ONLY logger
    ADD CONSTRAINT logger_pkey PRIMARY KEY (id);

ALTER TABLE ONLY logger
    ADD CONSTRAINT fk_event_logger FOREIGN KEY (event_id) REFERENCES event(id);

