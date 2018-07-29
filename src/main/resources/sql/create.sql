create schema if not exists cms;

drop table if exists cms.appUser;

create table if not exists cms.appUser (
   userId bignt (100000000),
   userName text (100000),
   userBirthday date (10000),
   userActive bit
);

insert into cms.appUser (userId, userName, userBirthday, userActive)
values (34, 'Достоевский', 1821-11-11, 0);

insert into cms.appUser (userId, userName, userBirthday, userActive)
values (61, 'Есенин', 1895-10-03, 1);

insert into cms.appUser (userId, userName, userBirthday, userActive)
values (26, 'Чехов', 1860-01-29, 0);

insert into cms.appUser (userId, userName, userBirthday, userActive)
values (17, 'Ремарк', 1898-06-22, 1);

insert into cms.appUser (userId, userName, userBirthday, userActive)
values (8, 'Оруэлл', 1903-06-25, 1);

insert into cms.appUser (userId, userName, userBirthday, userActive)
values (47, 'Хаксли', 1894-07-26, 1);




