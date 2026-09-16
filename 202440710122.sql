create database `202440710122`
default character set utf8mb4
collate utf8mb4_unicode_ci;

use `202440710122`;

create table student (
    id      varchar(20)  not null comment '学号'
        primary key,
    name    varchar(50)  not null comment '姓名',
    gender  varchar(10)  not null comment '性别',
    major   varchar(50)  not null comment '专业',
    grade   varchar(20)  not null comment '年级'
);

insert into student(id, name, gender, major, grade) values
('20244071001', '张三', '男', '计算机科学与技术', '2024级'),
('20244071002', '李四', '女', '软件工程', '2024级');

create table device
(
    did      varchar(30)    not null comment '设备编号'
        primary key,
    dname    varchar(50)    not null comment '设备名称',
    price    decimal(10, 2) not null comment '单价',
    buy_date date           not null comment '购买日期',
    use_user varchar(30)    null comment '使用人',
    state    varchar(10)    not null comment '设备状态：在用/已报废'
)
    comment '办公设备表';

insert into device(did, dname, price, buy_date, use_user, state) values
('D001', '笔记本电脑', 5999.00, '2025-09-01', '张老师', '在用'),
('D002', '打印机', 1200.00, '2024-05-12', '李老师', '在用'),
('D003', '投影仪', 3200.00, '2023-03-20', '王老师', '已报废');
