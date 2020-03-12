create table resumes
(
	id bigserial not null
		constraint resumes_pk
			primary key,
	first_name varchar(30) not null,
	middle_name varchar(30) not null,
	last_name varchar(30) not null,
	phone varchar(30) not null,
	email varchar(30),
	github varchar(50),
	skype varchar(30),
	linkedin varchar(60),
	gender varchar(7) not null,
	birth_date date
);

alter table resumes owner to postgres;

create table technologies
(
	id bigserial not null
		constraint technologies_pk
			primary key,
	name varchar(50) not null
);

alter table technologies owner to postgres;

create table resumes_technologies
(
	resumes__fk bigint not null
		constraint resumes__fk
			references resumes
				on update cascade on delete cascade,
	technologies__fk bigint not null
		constraint technologies__fk
			references technologies
				on update cascade on delete cascade
);

alter table resumes_technologies owner to postgres;

