create database WFX;
use WFX;
create table w_user
(
    u_id           LONG unique unique     not null,
    u_name         varchar(20)            not null,
    u_title        varchar(20) default '' not null,
    u_signature    varchar(20) default '' not null,
    u_signatureTxt varchar(20) default '' not null,
    u_tel          varchar(20) default '' not null,
    u_pwd          varchar(20) default '' not null
);

create table w_meitie
(
    m_id         Long unique            not null,
    m_ownerId    Long                   not null,
    m_nCollect   int         default 0  not null,
    m_nFavorite  int         default 0  not null,
    m_shortTitle varchar(20) default '' not null,
    m_content    varchar(20) default '' not null,
    m_coverPic   varchar(20) default '' not null,
    m_contentPic varchar(20) default '' not null

);
insert into WFX.w_meitie VALUE (
                                12, 12, 0, 12, 'as', 'as', 'DS', 'as'
    );
insert into WFX.w_meitie VALUE (
                                13, 14, 0, 12, 'as', 'as', 'DS', 'as'
    );


update w_meitie
set m_id='14'
where m_id = '12';

update w_meitie
set m_id=12



where m_id = 12;



# Mei Tie
DROP table w_user;
DROP table w_meitie;


#插入数据
INSERT INTO WFX.w_user
VALUES (10, 'as', 'as', 'DS', 'as', 'as', 'as');
INSERT INTO WFX.w_user
VALUES (13, 'csa', 'asssd', 'DSsd', 'ass', 'ass', 'as');

SELECT 1
FROM w_user
where u_id = '12'
limit 1;

select *
from w_user
where u_id = '12';

select *
from w_user;

select *
from w_user
where u_name = 'se'
  and u_id = '12';




SELECT 1 FROM w_user where u_id=14 limit 1;

