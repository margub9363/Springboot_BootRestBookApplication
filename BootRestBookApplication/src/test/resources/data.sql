use integrationtest;
create table author (author_id integer not null, first_name varchar(255), last_name varchar(255), primary key (author_id)) engine=InnoDB;
create table author_seq (next_val bigint) engine=InnoDB;
insert into author_seq values ( 1 );
create table book (book_id integer not null, title varchar(255), author_author_id integer, primary key (book_id)) engine=InnoDB;
create table book_seq (next_val bigint) engine=InnoDB;
insert into book_seq values ( 1 );
alter table book add constraint FKef9c1v09t9gdkor9ul80hsj4n foreign key (author_author_id) references author (author_id);



INSERT INTO `integrationtest`.`author` (`author_id`, `first_name`, `last_name`) VALUES ('1', 'Margub990', 'Rahman');

INSERT INTO `integrationtest`.`book` (`book_id`, `title`, `author_author_id`) VALUES ('1', 'Testing Transient Annotation990', '1');
