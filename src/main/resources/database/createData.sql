CREATE SEQUENCE Finance_id_seq START 0 INCREMENT 1;
CREATE SEQUENCE Type_id_seq START 0 INCREMENT 1;
CREATE TABLE Type
( 
id integer NOT NULL DEFAULT nextval('"Type_id_seq"'::regclass), 
name varchar(100) UNIQUE, 
CONSTRAINT "Type_pkey" PRIMARY KEY (id) 
);
CREATE TABLE Finance
( 
id integer NOT NULL DEFAULT nextval('"Finance_id_seq"'::regclass), 
value real NOT NULL, 
date date NOT NULL, 
description varchar(200), 
type integer, 
CONSTRAINT "Finance_pkey" PRIMARY KEY (id), 
CONSTRAINT fk_type FOREIGN KEY (type) 
REFERENCES public."Type" (id) MATCH SIMPLE 
ON UPDATE NO ACTION 
ON DELETE NO ACTION 
);
 
