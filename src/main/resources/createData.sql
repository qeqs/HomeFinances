
CREATE TABLE public."Finance" 
( 
id integer NOT NULL DEFAULT nextval('"Finance_id_seq"'::regclass), 
value real NOT NULL, 
date date NOT NULL, 
description text COLLATE pg_catalog."default", 
type integer NOT NULL, 
CONSTRAINT "Finance_pkey" PRIMARY KEY (id), 
CONSTRAINT fk_type FOREIGN KEY (type) 
REFERENCES public."Type" (id) MATCH SIMPLE 
ON UPDATE NO ACTION 
ON DELETE NO ACTION 
) 
WITH ( 
OIDS = FALSE 
) 
TABLESPACE pg_default; 

ALTER TABLE public."Finance" 
OWNER to postgres;

CREATE TABLE public."Type" 
( 
id integer NOT NULL DEFAULT nextval('"Type_id_seq"'::regclass), 
name text COLLATE pg_catalog."default" NOT NULL, 
CONSTRAINT "Type_pkey" PRIMARY KEY (id) 
) 
WITH ( 
OIDS = FALSE 
) 
TABLESPACE pg_default; 

ALTER TABLE public."Type" 
OWNER to postgres;