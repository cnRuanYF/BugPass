/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2018/6/11 10:45:41                           */
/*==============================================================*/


drop table if exists member;

drop table if exists model;

drop table if exists problem;

drop table if exists project;

drop table if exists user;

drop table if exists version;

/*==============================================================*/
/* Table: member                                                */
/*==============================================================*/
create table member
(
   projectId            integer not null,
   userId               integer not null,
   role                 varchar(1024) not null,
   primary key (projectId, userId)
);

/*==============================================================*/
/* Table: model                                                 */
/*==============================================================*/
create table model
(
   modelId              integer not null auto_increment,
   modelName            varchar(1024) not null,
   projectId            integer not null,
   primary key (modelId)
);

/*==============================================================*/
/* Table: problem                                               */
/*==============================================================*/
create table problem
(
   problemId            integer not null auto_increment,
   problemTitle         varchar(1024) not null,
   problemType          varchar(1024),
   problemDesc          varchar(1024),
   problemLevel         integer,
   problemStatus        integer,
   senderId             integer not null,
   receiverId           integer not null,
   modelId              integer not null,
   versionId            integer,
   picture              varchar(1024),
   createTime           date,
   updateTime           date,
   primary key (problemId)
);

/*==============================================================*/
/* Table: project                                               */
/*==============================================================*/
create table project
(
   projectId            integer not null auto_increment,
   projectName          varchar(1024) not null,
   projectDate          date not null,
   projectDesc          varchar(1024),
   primary key (projectId)
);

/*==============================================================*/
/* Table: user                                                  */
/*==============================================================*/
create table user
(
   id                   integer not null auto_increment,
   username             varchar(1024) not null,
   password             varchar(1024) not null,
   email                varchar(1024) not null,
   phone                integer not null,
   qq                   integer,
   realname             varchar(1024),
   registerTime         timestamp default 'current_timestamp',
   primary key (id)
);

/*==============================================================*/
/* Table: version                                               */
/*==============================================================*/
create table version
(
   versionId            integer not null auto_increment,
   projectId            integer not null,
   versionName          varchar(1024) not null,
   primary key (versionId)
);

alter table member add constraint FK_MEMBER foreign key (userId)
      references user (id) on delete restrict on update restrict;

alter table member add constraint FK_PROJECTINMEMBER foreign key (projectId)
      references project (projectId) on delete restrict on update restrict;

alter table model add constraint FK_PROJECTINMODEL foreign key (projectId)
      references project (projectId) on delete restrict on update restrict;

alter table problem add constraint FK_MODELINPROBLEM foreign key (modelId)
      references model (modelId) on delete restrict on update restrict;

alter table problem add constraint FK_USERFROM foreign key (senderId)
      references user (id) on delete restrict on update restrict;

alter table problem add constraint FK_USERTO foreign key (receiverId)
      references user (id) on delete restrict on update restrict;

alter table problem add constraint FK_VERSIONINPROBLEM foreign key (versionId)
      references version (versionId) on delete restrict on update restrict;

alter table version add constraint FK_PROJECTINVERSION foreign key (projectId)
      references project (projectId) on delete restrict on update restrict;

