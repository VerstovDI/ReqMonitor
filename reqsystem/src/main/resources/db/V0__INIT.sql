begin;
drop schema if exists system_control_requirements cascade;
create schema system_control_requirements;

drop table if exists user_role cascade;
drop table if exists usr cascade;

-- Начинаем последовательность с 2, т.к. под id = 1 уже захардкожен админ
drop sequence if exists system_control_requirements.hibernate_sequence;
create sequence system_control_requirements.hibernate_sequence start 2 increment 1;

CREATE TABLE system_control_requirements.user_role (
                                                       user_id int8 not null,
                                                       roles varchar(255)
);

CREATE TABLE system_control_requirements.usr (
                                                 id int8 not null,
                                                 active boolean not null,
                                                 password varchar(255) not null,
                                                 username varchar(255) not null,
                                                 primary key (id)
);

alter table if exists user_role add constraint user_role_user_fk foreign key (user_id) references usr;

CREATE TABLE system_control_requirements.tcl_status
(
    st_pk		serial,
    st_name		varchar(255),
    PRIMARY KEY (st_pk)
);
insert into system_control_requirements.tcl_status (st_pk, st_name)
values (default, 'begin');

CREATE TABLE system_control_requirements.tcl_priority
(
    pr_pk		serial,
    pr_name		varchar(255),
    PRIMARY KEY (pr_pk)
);
insert into system_control_requirements.tcl_priority (pr_pk, pr_name)
values (default, 'high');

CREATE TABLE system_control_requirements.tcl_link_type
(
    lt_pk		serial,
    lt_name		varchar(255),
    PRIMARY KEY (lt_pk)
);

CREATE TABLE system_control_requirements.tcl_object_type
(
    ot_pk		serial,
    ot_name		varchar(255),
    PRIMARY KEY (ot_pk)
);

CREATE TABLE system_control_requirements.tcl_verification_type
(
    vt_pk		serial,
    vt_name		varchar(255),
    PRIMARY KEY (vt_pk)
);
insert into system_control_requirements.tcl_verification_type ( vt_pk,  vt_name)
values (default, 'non verified');

CREATE TABLE system_control_requirements.t_projects
(
    prj_pk		serial,
    prj_name	varchar(255),
    prj_date	TIMESTAMP,
    prj_founder	varchar(255),
    PRIMARY KEY (prj_pk)
);
insert into system_control_requirements.t_projects (  prj_pk,  prj_name,prj_date,prj_founder	)
values (default, 'first project','2021-05-24 10:00:00-00','Aidar'),
       (default, 'second project','2021-05-24 11:00:00-00','Aidar');

CREATE TABLE system_control_requirements.t_specifications
(
    spc_pk			serial,
    spc_prj_fk 		BIGINT,
    spc_ver			integer,
    spc_desc		varchar(255),
    PRIMARY KEY (spc_pk),
    FOREIGN KEY (spc_prj_fk) REFERENCES system_control_requirements.t_projects (prj_pk)
);
insert into system_control_requirements.t_specifications (  spc_pk,  spc_prj_fk, spc_ver,spc_desc)
values (default, 1,1,'First specification'),
       (default, 2,1,'Second specification');

CREATE TABLE system_control_requirements.t_releases
(
    rel_pk			serial,
    rel_spc_fk		BIGINT,
    rel_ver			integer,
    rel_desc		varchar(255),
    PRIMARY KEY (rel_pk),
    FOREIGN KEY (rel_spc_fk) REFERENCES system_control_requirements.t_specifications (spc_pk)
);
insert into system_control_requirements.t_releases (  rel_pk,   rel_spc_fk, rel_ver,rel_desc)
values (default, 1,1,'First specification release'),
(default, 2,1,'Second specification release');



CREATE TABLE system_control_requirements.t_requirements
(
    req_pk			serial,
    req_rel_fk		BIGINT,
    req_pr_fk		BIGINT,
    req_st_fk		BIGINT,
    req_title		varchar(255),
    req_art_type	varchar(255),
    req_s_desc		varchar(255),
    req_lim_t		time,
    req_loc			varchar(255),
    req_origin		varchar(255),
    req_date		TIMESTAMP,
    PRIMARY KEY (req_pk),
    FOREIGN KEY (req_rel_fk) REFERENCES system_control_requirements.t_releases (rel_pk),
    FOREIGN KEY (req_pr_fk) REFERENCES system_control_requirements.tcl_priority (pr_pk),
    FOREIGN KEY (req_st_fk) REFERENCES system_control_requirements.tcl_status (st_pk)
);
CREATE TABLE system_control_requirements.t_verification
(
    vrf_pk			serial,
    vrf_vt_fk		BIGINT,
    req_fk		    BIGINT,
    vrf_date		TIMESTAMP,
    PRIMARY KEY (vrf_pk),
    FOREIGN KEY (vrf_vt_fk) REFERENCES system_control_requirements.tcl_verification_type (vt_pk),
    FOREIGN KEY (req_fk) REFERENCES system_control_requirements.t_requirements (req_pk)
);



CREATE TABLE system_control_requirements.t_requirement_links
(
    rl_pk			serial,
    rl_lt_fk		BIGINT,
    rl_req_root_fk		BIGINT,
    rl_req_child_fk		BIGINT,
    rl_desc			varchar(255),
    PRIMARY KEY (rl_pk),
    FOREIGN KEY (rl_lt_fk) REFERENCES system_control_requirements.tcl_link_type (lt_pk),
    FOREIGN KEY (rl_req_root_fk) REFERENCES system_control_requirements.t_requirements (req_pk),
    FOREIGN KEY (rl_req_child_fk) REFERENCES system_control_requirements.t_requirements (req_pk)
);

CREATE TABLE system_control_requirements.t_content_object
(
    co_pk			serial,
    co_ot_fk		BIGINT,
    co_req_fk		BIGINT,
    co_name			varchar(255),
    co_ref			varchar(255),
    PRIMARY KEY (co_pk),
    FOREIGN KEY (co_ot_fk) REFERENCES system_control_requirements.tcl_object_type (ot_pk),
    FOREIGN KEY (co_req_fk) REFERENCES system_control_requirements.t_requirements (req_pk)
);

end;