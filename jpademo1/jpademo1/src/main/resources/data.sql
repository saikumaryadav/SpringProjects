insert into Course(id, name, created_date, last_updated_date) values(1001,'DS', CURRENT_TIMESTAMP ,CURRENT_TIMESTAMP );
insert into Course(id, name, created_date, last_updated_date) values(1002,'JAVA', CURRENT_TIMESTAMP ,CURRENT_TIMESTAMP);
insert into Course(id, name, created_date, last_updated_date) values(1003,'OS',  CURRENT_TIMESTAMP ,CURRENT_TIMESTAMP);
insert into Course(id, name, created_date, last_updated_date) values(1004,'ALGO',  CURRENT_TIMESTAMP ,CURRENT_TIMESTAMP);
insert into Course(id, name, created_date, last_updated_date) values(1005,'SPRINGBOOT',  CURRENT_TIMESTAMP ,CURRENT_TIMESTAMP);
insert into Course(id, name, created_date, last_updated_date) values(1006,'dummy1',  CURRENT_TIMESTAMP ,CURRENT_TIMESTAMP);
insert into Course(id, name, created_date, last_updated_date) values(1007,'dummy2',  CURRENT_TIMESTAMP ,CURRENT_TIMESTAMP);
insert into Course(id, name, created_date, last_updated_date) values(1008,'dummy3',  CURRENT_TIMESTAMP ,CURRENT_TIMESTAMP);
insert into Course(id, name, created_date, last_updated_date) values(1009,'dummy4',  CURRENT_TIMESTAMP ,CURRENT_TIMESTAMP);

insert into passport(id, number) values(4001,'A123432');
insert into passport(id, number) values(4002,'B123456');
insert into passport(id, number) values(4003,'E213567');

insert into student(id, name, passport_id) values(2001,'Ranga',4001);
insert into student(id, name, passport_id) values(2002,'Adam',4002);
insert into student(id, name, passport_id) values(2003,'Jane',4003);



insert into review(id, rating, description, course_id) values(5001,'5','Good', 1001);
insert into review(id, rating, description, course_id) values(5002,'4','Awesome',1001);
insert into review(id, rating, description, course_id) values(5003,'5','Normal',1003);

insert into student_course(student_id, course_id) values(2001, 1001);
insert into student_course(student_id, course_id) values(2002,1001);
insert into student_course(student_id, course_id) values(2003,1001);
insert into student_course(student_id, course_id) values(2001, 1003);