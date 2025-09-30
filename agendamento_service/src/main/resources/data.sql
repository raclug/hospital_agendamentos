INSERT INTO users (id, username, name, password) VALUES (1, 'medico1', 'Dr Pedro', '$2a$10$OzJ1PBheSE5IJ/3XdoNV8u2MUR/twpbpQ6v0ygMKr5j6XgtSaOuj.');
INSERT INTO users (id, username, name, password) VALUES (2, 'enfermeiro1', 'João', '$2a$10$yPOq3q8mUVUCZgjG.cxwEOxziLlr4HUf5qCqwAWN1f9h2j1gcjwEq');
INSERT INTO users (id, username, name, password) VALUES (3, 'paciente1', 'Paulo', '$2a$10$Q3OxUtd6UnFWAm3KXdZFn.9xhpxTag2UxPlL8K9nqxvhGyaQVqJcS');
INSERT INTO users (id, username, name, password) VALUES (4, 'paciente2', 'Maria', '$2a$10$cOjErOQ3qTyftW.chmCvpu.gjL9ziUNWXm0s4LUnOjX9qLvdrESNu');

INSERT INTO user_entity_roles (user_entity_id, roles) VALUES (1, 'MEDICO');
INSERT INTO user_entity_roles (user_entity_id, roles) VALUES (2, 'ENFERMEIRO');
INSERT INTO user_entity_roles (user_entity_id, roles) VALUES (3, 'PACIENTE');
INSERT INTO user_entity_roles (user_entity_id, roles) VALUES (4, 'PACIENTE');
COMMIT;