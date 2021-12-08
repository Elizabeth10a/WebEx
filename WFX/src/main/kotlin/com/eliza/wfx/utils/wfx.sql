create database WFX;
use WFX;
create table w_user
(
    u_id           LONG unique not null,
    u_name         varchar(20) not null,
    u_title        varchar(20),
    u_signature    varchar(20),
    u_signatureTxt varchar(20),
    u_tel          varchar(20),
    u_pwd          varchar(20)
);

create table w_meitie
(
    m_id         LONG unique not null,
    m_ownerId    Long        not null,
    m_nCollect   int,
    m_nFavorite  int,
    m_shortTitle varchar(20),
    m_content    varchar(20),
    m_coverPic   varchar(20),
    m_contentPic varchar(20)

);
insert into WFX.w_meitie VALUE (
                                12, 12, 0, 12, 'as', 'as', 'DS', 'as'
    );
# Mei Tie
DROP table w_user;
DROP table w_meitie;




#插入数据
INSERT INTO WFX.w_user
VALUES (12, 'as', 'as', 'DS', 'as', 'as', 'as');
INSERT INTO WFX.w_user
VALUES (12, 'csa', 'assd', 'DSsd', 'ass', 'ass', 'as');

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






