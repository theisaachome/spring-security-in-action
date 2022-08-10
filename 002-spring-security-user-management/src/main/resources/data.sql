INSERT INTO users (id,username,password) values (1,"bill","12345");

INSERT INTO authorities (id,name) values (1,"read");

INSERT INTO users_authorities (user_id,authority_id) value (1,1);