
INSERT INTO granted_authority(id, role) VALUES (1, 'ROLE_USER');
INSERT INTO granted_authority(id, role) VALUES (2, 'ROLE_ADMIN');

INSERT INTO users(
	id, account_non_expired, account_non_locked, credentials_non_expired, enabled, password, username)
	VALUES (1, true, true, true, true, '$2a$10$SWHTtXDiQXWnqDyOm1JFq.lpMHq8JV2rhBv5J/OO0EzkaYgPtbNui', 'user@codenation.com');
INSERT INTO users(
	id, account_non_expired, account_non_locked, credentials_non_expired, enabled, password, username)
	VALUES (2, true, true, true, true, '$2a$10$/E5bYyCHYeQUFkZn.X7UZ.PopY9HGbP4nmx.4/JNgFCQMdDgfn2X6', 'admin@codenation.com');
	
INSERT INTO users_authorities(
	users_id, authorities_id)
	VALUES (1, 1);
INSERT INTO users_authorities(
	users_id, authorities_id)
	VALUES (2, 2);