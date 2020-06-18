

CREATE TABLE event_logger (
    id bigserial NOT NULL,
	created_at timestamp,
    level varchar(10) NOT NULL,
	event_description varchar(255) NOT NULL,
	event_logger text NOT NULL,
	source varchar(150) NOT NULL,
	date timestamp NOT NULL,
	quantity int
);


ALTER TABLE ONLY event_logger
    ADD CONSTRAINT event_logger_pkey PRIMARY KEY (id);

