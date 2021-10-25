DROP TABLE IF EXISTS classes;
DROP TABLE IF EXISTS teachers;
DROP TABLE IF EXISTS parents;
DROP TABLE IF EXISTS assignments;
DROP TABLE IF EXISTS students;

create table students(
	student_id int not null auto_increment,
    full_name varchar(45) NOT NULL, 
    primary key (student_id)
);
create table parents(
	parent_id int not null auto_increment,
    full_name varchar(45) NOT NULL, 
    student_id int not null,
     primary key (parent_id),
    foreign key (student_id) references students (student_id)
);
create table teachers(
	teacher_id int not null auto_increment,
    full_name varchar(45) NOT NULL,
    class_name enum('Anatomy', 'History'),
    PRIMARY KEY (teacher_id)
);

create table classes(
	class_id int not null auto_increment,
    class_name enum('Anatomy', 'History'),
	student_id int not null,
    teacher_id int not null,
    primary key (class_id),
    foreign key (student_id) references students (student_id),
    foreign key (teacher_id) references teachers (teacher_id)
);


create table assignments(
	assignment_id int NOT NULL auto_increment,
	student_id int default NULL,
	assignment_name varchar(25) default NULL,
    class_name enum('Anatomy', 'History'),
	points_possible int default NULL,
	points_earned int default NULL,
	PRIMARY KEY  (assignment_id),
    foreign key (student_id) references students (student_id)
    
);

insert into teachers(full_name, class_name) values ('James Moriarty', 'History');
insert into teachers(full_name, class_name) values ('Valerie Frizzle', 'Anatomy');


insert into students(full_name) values ('Doogie Howser');
insert into students(full_name) values ('Sheldon Cooper');


insert into classes(class_name, student_id, teacher_id) values ('Anatomy', 1, 2);
insert into classes(class_name, student_id, teacher_id) values ('Anatomy', 2, 2);
insert into classes(class_name, student_id, teacher_id) values ('History', 1, 1);
insert into classes(class_name, student_id, teacher_id) values ('History', 2, 1);

insert into assignments(student_id, assignment_name, class_name, points_possible, points_earned) values (1, 'Homework 1', 'Anatomy', 100, 100);
insert into assignments(student_id, assignment_name, class_name, points_possible, points_earned) values (2, 'Homework 1', 'History', 100, 100);
insert into assignments(student_id, assignment_name, class_name, points_possible, points_earned) values (1, 'Homework 1', 'History', 100, 100);
insert into assignments(student_id, assignment_name, class_name, points_possible, points_earned) values (2, 'Homework 1', 'Anatomy', 100, 100);


insert into parents(full_name, student_id) values ('David Howser', 1);
insert into parents(full_name, student_id) values ('Arnold Frizzle', 2);


select student_id from classes where class_name = 'Anatomy';
select student_id, class_name from classes where student_id > 0;


