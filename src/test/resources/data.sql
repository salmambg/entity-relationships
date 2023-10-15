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
insert into courses(id, name)
values(10001,'JPA in 50 Steps');
insert into courses(id, name)
values(10002,'Spring in 50 Steps');
insert into courses(id, name)
values(10003,'Spring Boot in 100 Steps');
insert into Review(id,rating,description,course_id)
values(50001,'FIVE', 'Great Course',10001);
insert into Review(id,rating,description,course_id)
values(50002,'FOUR', 'Wonderful Course',10001);
insert into Review(id,rating,description,course_id)
values(50003,'FIVE', 'Awesome Course',10003);

