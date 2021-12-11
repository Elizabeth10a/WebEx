DROP DATABASE FJD;

drop database if exists FJD;


create database if not exists FJD;

use FJD;

DROP TABLE IF EXISTS `f_commodity`;
CREATE TABLE `f_commodity`
(
    `c_id`    int(10) primary key NOT NULL AUTO_INCREMENT COMMENT 'id',
    `c_title` varchar(500)        NOT NULL COMMENT '主题',
    `c_price` int DEFAULT '0' COMMENT '价格',
    `c_img1`  varchar(50)   DEFAULT '' COMMENT '图片1',
    `c_img2`  varchar(50)   DEFAULT '' COMMENT '图片2',
    `c_img3`  varchar(50)   DEFAULT '' COMMENT '图片3'
);

DROP TABLE IF EXISTS `f_user`;
CREATE TABLE `f_user`
(
    `u_id`       int(10) primary key        NOT NULL AUTO_INCREMENT COMMENT 'id',
    `u_name`     varchar(50) unique         NOT NULL COMMENT '用户名',
    `u_tel`      int(11)        DEFAULT '0' NOT NULL COMMENT '手机号',
    `u_pwd`      varchar(50)                NOT NULL COMMENT '密码',
    `u_head_img` varchar(100)   DEFAULT '' COMMENT '头像',
    `u_balance`  decimal(10, 0) DEFAULT '0' COMMENT '余额',
    `u_addr`     varchar(100)   DEFAULT '' COMMENT '地址'
);


DROP TABLE IF EXISTS `f_shopCart`;

CREATE TABLE `f_shopCart`
(
    `s_u_id` int(10) NOT NULL,
    `s_c_id` int(10) NOT NULL
);

DROP TABLE IF EXISTS `f_commodity_type`;

CREATE TABLE `f_commodity_type`
(
    `c_id` int(10) NOT NULL,
    `c_type` varchar(20) DEFAULT '' COMMENT '类别'
)
