use FJD;


insert into `f_commodity`
values (1, 'Redmi Note 9 Pro 5G ', 1299, NULL, NULL, NULL),
       (2, 'Redmi K40 骁龙870 三星AMOLED', 2299, NULL, NULL, NULL),
       (3, 'OPPO Reno7 5G', 2699, NULL, NULL, NULL),
       (4, '戴尔DELL成就3400 ', 3899, NULL, NULL, NULL),
       (5, '惠普(HP)战66四代 锐龙版 ', 4299, NULL, NULL, NULL),
       (6, '联想小新Air14锐龙版轻薄本', 4699, NULL, NULL, NULL),
       (7, 'JEEP吉普卫衣男连帽套装', 329, NULL, NULL, NULL),
       (8, 'AFILMBY 金丝绒卫衣套装男秋季衣服外套', 198, NULL, NULL, NULL),
       (9, '宾克莱 秋季套装连帽衣服男装外套', 168, NULL, NULL, NULL),
       (10, '胤笙记 风衣男秋冬季加棉加厚长款外套oversize', 166, NULL, NULL, NULL),
       (11, '杰本棠风衣男外套', 89, NULL, NULL, NULL),
       (12, '古爵乔治呢', 498, NULL, NULL, NULL),
       (13, '南极人外套男春秋季飞行员夹克', 138, NULL, NULL, NULL),
       (14, '南极人夹克男复古青年软皮衣', 168, NULL, NULL, NULL),
       (15, ' Apple iPhone 13 Pro', 7999, NULL, NULL, NULL),
       (16, '荣耀60 Pro', 3699, NULL, NULL, NULL),
       (17, 'OPPO K9s', 1599, NULL, NULL, NULL),
       (18, '联想拯救者R9000P', 8999, NULL, NULL, NULL),
       (19, '宏碁 暗影骑士·擎 ', 6199, NULL, NULL, NULL),
       (20, '机械革命(MECHREVO)钛钽PLUS', 7999, NULL, NULL, NULL);

insert into f_shopCart (s_u_id, s_c_id)
values (12, 32);
SELECT 1
FROM f_shopCart
where s_u_id = '12'
limit 1;

insert into `f_user` (u_id, u_name, u_tel, u_pwd)
    value (2, 'sa', 12, 'asd');



insert into `f_commodity_type`
values (1, '手机'),
       (2, '手机'),
       (3, '手机'),
       (4, '电脑'),
       (5, '电脑'),
       (6, '电脑'),
       (7, '衣服'),
       (8, '衣服'),
       (9, '衣服'),
       (10, '衣服'),
       (11, '衣服'),
       (12, '衣服'),
       (13, '衣服'),
       (14, '衣服'),
       (15, '手机'),
       (16, '手机'),
       (17, '手机'),
       (18, '电脑'),
       (19, '电脑'),
       (20, '电脑');

