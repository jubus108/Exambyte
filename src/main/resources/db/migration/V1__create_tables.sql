create table nutzer_in (
   id serial primary key,
   github_id integer not null,
   username varchar(39) not null,
   constraint unique_github_id unique (github_id)
);
