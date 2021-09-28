insert into course (id, name, created_date, last_updated_date, is_deleted)
values (10001L, 'JPA in 50 Steps', sysdate(), sysdate(), false);
insert into course (id, name, created_date, last_updated_date, is_deleted)
values (10002L, 'Spring in 50 Steps', sysdate(), sysdate(), false);
insert into course (id, name, created_date, last_updated_date, is_deleted)
values (10003L, 'Spring boot in 50 Steps', sysdate(), sysdate(), false);
insert into course (id, name, created_date, last_updated_date, is_deleted)
values (10004L, 'Dummy1', sysdate(), sysdate(), false);
insert into course (id, name, created_date, last_updated_date, is_deleted)
values (10005L, 'Dummy2', sysdate(), sysdate(), false);
insert into course (id, name, created_date, last_updated_date, is_deleted)
values (10006L, 'Dummy3', sysdate(), sysdate(), false);


insert into passport (id, number)
values (40001,'S12345');
insert into passport (id, number)
values (40002,'C54321');
insert into passport (id, number)
values (40003,'E09876');

--insert into student (id, name, passport_id)
--values (20001,'Shahid',40001);
--insert into student (id, name, passport_id)
--values (20002,'Ciel',40002);
--insert into student (id, name, passport_id)
--values (20003,'el',40003);
insert into student (id, name, passport_id, line1, line2, city)
values (20001,'Shahid',40001, '123', 'main street', 'denver');
insert into student (id, name, passport_id, line1, line2, city)
values (20002,'Ciel',40002, '345', 'rest street', 'aurora');
insert into student (id, name, passport_id, line1, line2, city)
values (20003,'el',40003, '6575', 'some street', 'denver');


insert into review (id, rating, description, course_id)
values (50001, 'FOUR', 'it was a good class', 10001);
insert into review (id, rating, description, course_id)
values (50002, 'FIVE', 'it was a great class', 10001);
insert into review (id, rating, description, course_id)
values (50003, 'THREE', 'it was a normal class', 10003);

insert into student_course(student_id, course_id)
values (20001, 10001);
insert into student_course(student_id, course_id)
values (20002, 10001);
insert into student_course(student_id, course_id)
values (20003, 10001);
insert into student_course(student_id, course_id)
values (20001, 10003);
