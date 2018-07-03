/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2018/7/3 11:17:27                            */
/*==============================================================*/


drop table if exists discuss;

drop table if exists member;

drop table if exists module;

drop table if exists problem;

drop table if exists problem_attachment;

drop table if exists problem_operation_log;

drop table if exists project;

drop table if exists user;

drop table if exists version;

/*==============================================================*/
/* Table: discuss                                               */
/*==============================================================*/
create table discuss
(
   discuss_id           int not null auto_increment comment '讨论ID',
   problem_id           int not null comment '问题ID',
   publisher            int not null comment '发布者',
   publish_time         timestamp not null default current_timestamp comment '发布时间',
   discuss_content      varchar(512) not null comment '讨论内容',
   primary key (discuss_id)
);

alter table discuss comment '讨论';

/*==============================================================*/
/* Table: member                                                */
/*==============================================================*/
create table member
(
   project_id           int not null comment '项目ID',
   user_id              int not null comment '用户ID',
   member_role          int not null comment '角色',
   primary key (project_id, user_id)
);

alter table member comment '成员';

/*==============================================================*/
/* Table: module                                                */
/*==============================================================*/
create table module
(
   module_id            int not null auto_increment comment '模块ID',
   module_name          varchar(64) not null comment '模块名',
   project_id           int not null comment '项目ID',
   primary key (module_id)
);

alter table module comment '项目模块';

/*==============================================================*/
/* Table: problem                                               */
/*==============================================================*/
create table problem
(
   problem_id           int not null auto_increment comment '问题ID',
   problem_title        varchar(1024) not null comment '问题标题',
   problem_type         varchar(1024) comment '问题类型',
   problem_desc         varchar(1024) comment '问题描述',
   problem_level        int comment '问题级别',
   problem_status       int comment '问题状态',
   publisher            int not null comment '发布者',
   assigned_to          int not null comment '指派给',
   module_id            int not null comment '模块ID',
   version_id           int comment '版本ID',
   create_time          timestamp default current_timestamp comment '发布时间',
   update_time          timestamp default current_timestamp on update current_timestamp comment '更新时间',
   primary key (problem_id)
);

alter table problem comment '问题';

/*==============================================================*/
/* Table: problem_attachment                                    */
/*==============================================================*/
create table problem_attachment
(
   problem_id           int not null comment '问题ID',
   attach_index         int not null comment '附件索引',
   attach_type          int not null comment '附件类型',
   attach_path          varchar(1024) not null comment '文件路径',
   primary key (problem_id, attach_index)
);

alter table problem_attachment comment '问题附件';

/*==============================================================*/
/* Table: problem_operation_log                                 */
/*==============================================================*/
create table problem_operation_log
(
   log_id               int not null auto_increment comment '记录ID',
   problem_id           int not null comment '问题ID',
   operator             int not null comment '操作人',
   op_type              int not null comment '操作类型',
   op_desc              varchar(256) comment '操作详情',
   op_time              timestamp not null default current_timestamp comment '操作时间',
   target_user          int comment '操作对象',
   attribute_before     varchar(1024) comment '操作前的值',
   attribute_after      varchar(1024) comment '操作后的值',
   primary key (log_id)
);

alter table problem_operation_log comment '问题操作记录';

/*==============================================================*/
/* Table: project                                               */
/*==============================================================*/
create table project
(
   project_id           int not null auto_increment comment '项目ID',
   project_name         varchar(128) not null comment '项目名',
   project_desc         varchar(1024) comment '项目描述',
   create_time          timestamp not null default current_timestamp comment '项目日期',
   primary key (project_id)
);

alter table project comment '项目';

/*==============================================================*/
/* Table: user                                                  */
/*==============================================================*/
create table user
(
   user_id              int not null auto_increment comment '用户ID',
   username             varchar(32) not null comment '用户名',
   passwd_hash          varchar(128) not null comment '密码Hash',
   passwd_salt          varchar(1024) not null comment '密码盐',
   email                varchar(128) comment '邮箱',
   phone                varchar(16) comment '手机',
   qq                   varchar(16) comment 'QQ号',
   realname             varchar(16) comment '真实姓名',
   picture              varchar(1024) comment '图片',
   register_time        timestamp not null default current_timestamp comment '注册时间',
   primary key (user_id)
);

alter table user comment '用户';

/*==============================================================*/
/* Table: version                                               */
/*==============================================================*/
create table version
(
   version_id           int not null auto_increment comment '版本ID',
   version_name         varchar(64) not null comment '版本名',
   project_id           int not null comment '项目ID',
   primary key (version_id)
);

alter table version comment '项目版本';

alter table discuss add constraint fk_problem_id_in_discuss foreign key (problem_id)
      references problem (problem_id) on delete restrict on update restrict;

alter table discuss add constraint fk_publisher_in_discuss foreign key (publisher)
      references user (user_id) on delete restrict on update restrict;

alter table member add constraint fk_project_id_in_member foreign key (project_id)
      references project (project_id) on delete restrict on update restrict;

alter table member add constraint fk_user_id_in_member foreign key (user_id)
      references user (user_id) on delete restrict on update restrict;

alter table module add constraint fk_project_id_in_module foreign key (project_id)
      references project (project_id) on delete restrict on update restrict;

alter table problem add constraint fk_assigned_to_in_problem foreign key (assigned_to)
      references user (user_id) on delete restrict on update restrict;

alter table problem add constraint fk_module_in_problem foreign key (module_id)
      references module (module_id) on delete restrict on update restrict;

alter table problem add constraint fk_publisher_in_problem foreign key (publisher)
      references user (user_id) on delete restrict on update restrict;

alter table problem add constraint fk_version_in_problem foreign key (version_id)
      references version (version_id) on delete restrict on update restrict;

alter table problem_attachment add constraint fk_problem_in_attachment foreign key (problem_id)
      references problem (problem_id) on delete restrict on update restrict;

alter table problem_operation_log add constraint fk_operator_in_operation_log foreign key (operator)
      references user (user_id) on delete restrict on update restrict;

alter table problem_operation_log add constraint fk_problem_id_in_operation_log foreign key (problem_id)
      references problem (problem_id) on delete restrict on update restrict;

alter table problem_operation_log add constraint fk_target_user_in_operation_log foreign key (target_user)
      references user (user_id) on delete restrict on update restrict;

alter table version add constraint fk_project_id_in_version foreign key (project_id)
      references project (project_id) on delete restrict on update restrict;

