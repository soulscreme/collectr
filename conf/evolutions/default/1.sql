# --- !Ups

CREATE SEQUENCE user_id_seq;
CREATE TABLE users (
    id integer NOT NULL DEFAULT nextval('user_id_seq'),
    username varchar(255),
    fname varchar(100),
    lname varchar(100),
    email varchar(255)
);

CREATE SEQUENCE user_lib_id_seq;
CREATE TABLE user_libraries (
    id integer NOT NULL DEFAULT nextval('user_lib_id_seq'),
    name varchar(255),
    user_id integer NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users (id)
);

CREATE SEQUENCE media_id_seq;

CREATE TABLE media_item (
    id integer NOT NULL  DEFAULT nextval('media_id_seq'),
    year integer NOT NULL,
    title varchar(255) NOT NULL,
    description CLOB,
    image varchar(255)
);

CREATE TABLE library_media (
    library_id integer NOT NULL,
    media_id integer NOT NULL,
    FOREIGN KEY (library_id) REFERENCES user_libraries (id),
    FOREIGN KEY (media_id) REFERENCES media_item (id)
);

# --- !Downs

drop table library_media;

drop table media_item;

drop sequence media_id_seq;

DROP TABLE user_libraries;
DROP SEQUENCE user_lib_id_seq;

DROP TABLE users;
DROP SEQUENCE user_id_seq;