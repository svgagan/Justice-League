CREATE DATABASE comicsdb;

-- Drop table

-- DROP TABLE public.comic_details;

CREATE TABLE public.comic_details (
      id varchar(255) NOT NULL,
      created_date timestamp NOT NULL,
      status bool NULL,
      comic_name varchar(255) NOT NULL,
      updated_date timestamp NOT NULL,
      CONSTRAINT comic_details_pkey PRIMARY KEY (id)
);


-- Drop table

-- DROP TABLE public.super_heroes;

CREATE TABLE public.super_heroes (
     id varchar(255) NOT NULL,
     created_date timestamp NOT NULL,
     status bool NULL,
     super_hero_name varchar(255) NOT NULL,
     updated_date timestamp NOT NULL,
     comic_details_id varchar(255) NOT NULL
);

ALTER TABLE public.super_heroes ADD CONSTRAINT super_heroes_comic_details_id_fkey FOREIGN KEY (comic_details_id) REFERENCES comic_details(id);


-- INSERT Queries

INSERT INTO public.comic_details (id, comic_name, created_date, status, updated_date) VALUES ('DC', 'Detective-Comics', now(), true, now());
INSERT INTO public.comic_details (id, comic_name, created_date, status, updated_date) VALUES ('MC', 'Marvel-Comics', now(), true, now());
