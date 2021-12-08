create database WFX;
use WFX;
create table W_user
(
    u_id   long,
    u_name varchar(20)

);

#插入数据
INSERT INTO WFX.W_user (u_id, u_name)
VALUES ('56', 'DS');


select *
from W_user;
