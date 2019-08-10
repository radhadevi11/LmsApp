create table course_category
(
	course_category_id int auto_increment
		primary key,
	name varchar(100) null
);

create table course
(
	course_id int auto_increment
		primary key,
	name varchar(50) null,
	code varchar(20) null,
	syllabus varchar(100) null,
	course_category_id int null,
	workshop_eligibility bit null,
	research_training_eligibility bit null,
	inplant_training_eligibility bit null,
	corporate_training_eligibility bit null,
	constraint course_course_category_course_category_id_fk
		foreign key (course_category_id) references course_category (course_category_id)
);


create table research_training
(
    research_training_id int auto_increment
        primary key,
    duration varchar(45) null,
    cost double null,
    no_of_courses int(11) null,
    mode_of_training varchar(45) null
);


  CREATE TABLE `workshop_type`(
    `workshop_type_id` int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `mode_of_training` varchar(50) DEFAULT NULL,
    `no_of_workshops` int(5) DEFAULT NULL,
    `total_days` int(5) DEFAULT NULL,
    `total_hours` int(5) DEFAULT NULL,
    `hours_per_day` int(5) DEFAULT NULL,
    `package` varchar(10) DEFAULT NULL,
    `cost` double DEFAULT NULL
  );


CREATE TABLE workshop (
  workshop_id INT(50) NOT NULL,
  workshop_type_id INT NULL,
  PRIMARY KEY (workshop_id),
  CONSTRAINT workshop_type_fk
  FOREIGN KEY (workshop_type_id)
  REFERENCES workshop_type (workshop_type_id)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION);

create table student(
student_id int not null primary key AUTO_INCREMENT,
first_name varchar(50),
last_name varchar(50),
gender varchar(10),
mail_id varchar(50),
college_name varchar(50),
passwordd varchar(50));

CREATE TABLE `workshop_enrolment` (
  `workshop_enrolment_id` int(11) NOT NULL AUTO_INCREMENT,
  `student_id` int(11) DEFAULT NULL,
  `workshop_type_id` int(11) DEFAULT NULL,
  `course_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`workshop_enrolment_id`),
  CONSTRAINT `course_id_fk` FOREIGN KEY (`course_id`) REFERENCES `course` (`course_id`),
  CONSTRAINT `student_id_fk` FOREIGN KEY (`student_id`) REFERENCES `student` (`student_id`),
  CONSTRAINT `workshop_type_id_fk` FOREIGN KEY (`workshop_type_id`) REFERENCES `workshop_type` (`workshop_type_id`)
);

