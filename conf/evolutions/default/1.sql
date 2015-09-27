# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table question (
  id                        bigint auto_increment not null,
  question                  varchar(255),
  user_id                   bigint,
  created_at                datetime not null,
  updated_at                datetime not null,
  constraint pk_question primary key (id))
;

create table user (
  id                        bigint auto_increment not null,
  username                  varchar(255),
  password                  varchar(255),
  created_at                datetime not null,
  updated_at                datetime not null,
  constraint uq_user_username unique (username),
  constraint pk_user primary key (id))
;

alter table question add constraint fk_question_user_1 foreign key (user_id) references user (id) on delete restrict on update restrict;
create index ix_question_user_1 on question (user_id);



# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table question;

drop table user;

SET FOREIGN_KEY_CHECKS=1;

