insert into Passport(id,number)
values(40001,'N123456');
insert into Passport(id,number)
values(40002,'E123456');
insert into Passport(id,number)
values(40003,'K123456');
insert into Student(id,name,passport_id)
values(20001,'Salma',40001);
insert into Student(id,name,passport_id)
values(20002,'Samiha',40002);
insert into Student(id,name,passport_id)
values(20003,'Sabiha', 40003);
insert into courses(id, name, is_deleted)
values(10001,'JPA in 50 Steps',false);
insert into courses(id, name, is_deleted)
values(10002,'Spring in 50 Steps',false);
insert into courses(id, name, is_deleted)
values(10003,'Spring Boot in 100 Steps',false);
insert into courses(id, name, is_deleted)
values(10004,'JPA in steps by Steps', false);
insert into courses(id, name, is_deleted)
values(10005,'Spring in step by Steps',false);
insert into courses(id, name, is_deleted)
values(10006,'Spring Boot in step by steps',false);
insert into Review(id,rating,description,course_id)
values(50001,'FIVE', 'Great Course',10001);
insert into Review(id,rating,description,course_id)
values(50002,'FOUR', 'Wonderful Course',10001);
insert into Review(id,rating,description,course_id)
values(50003,'FIVE', 'Awesome Course',10003);
insert into student_course(student_id,course_id)
values(20001,10001);
insert into student_course(student_id,course_id)
values(20002,10001);
insert into student_course(student_id,course_id)
values(20003,10001);
insert into student_course(student_id,course_id)
values(20001,10003);
