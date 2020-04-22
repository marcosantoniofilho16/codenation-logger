

CREATE TABLE granted_authority (
    id bigserial NOT NULL,
    role varchar(255)
);


CREATE TABLE users (
    id bigserial NOT NULL,
    account_non_expired boolean,
    account_non_locked boolean,
    credentials_non_expired boolean,
    enabled boolean,
    password varchar(255),
    username varchar(255)
);


CREATE TABLE users_authorities (
    users_id bigint NOT NULL,
    authorities_id bigint NOT NULL
);


ALTER TABLE ONLY granted_authority
    ADD CONSTRAINT granted_authority_pkey PRIMARY KEY (id);


ALTER TABLE ONLY users_authorities
    ADD CONSTRAINT users_authorities_pkey PRIMARY KEY (users_id, authorities_id);


ALTER TABLE ONLY users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


ALTER TABLE ONLY users_authorities
    ADD CONSTRAINT fk_users_authorities_users FOREIGN KEY (users_id) REFERENCES users(id);


ALTER TABLE ONLY users_authorities
    ADD CONSTRAINT fk_users_authorities_authorities FOREIGN KEY (authorities_id) REFERENCES granted_authority(id);

