
INSERT INTO role(authority) VALUES ('ROLE_USER');
INSERT INTO role(authority) VALUES ('ROLE_ADMIN');

INSERT INTO users(
	account_non_expired, account_non_locked, credentials_non_expired, enabled, password, username)
	VALUES (true, true, true, true, '$2a$10$SWHTtXDiQXWnqDyOm1JFq.lpMHq8JV2rhBv5J/OO0EzkaYgPtbNui', 'user@codenation.com');
INSERT INTO users(
	account_non_expired, account_non_locked, credentials_non_expired, enabled, password, username)
	VALUES (true, true, true, true, '$2a$10$/E5bYyCHYeQUFkZn.X7UZ.PopY9HGbP4nmx.4/JNgFCQMdDgfn2X6', 'admin@codenation.com');
	
INSERT INTO users_authorities(
	users_id, authorities_id)
	VALUES (1, 1);
INSERT INTO users_authorities(
	users_id, authorities_id)
	VALUES (2, 2);