DROP TABLE IF EXISTS public.student;
-- public.student definition

-- Drop table

-- DROP TABLE public.student;

CREATE TABLE public.student (
	id varchar NOT NULL,
	name varchar NOT NULL,
	address varchar NOT NULL,
	CONSTRAINT student_pk PRIMARY KEY (id)
);

INSERT INTO public.student (id, name, address) VALUES ('4de8526a-8bce-4586-bdb0-25eaf06d2a6d', 'Bambang', 'Jakarta');
