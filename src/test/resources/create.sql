create table course_category
(
	course_category_id int auto_increment
		primary key,
	name varchar(100) null
);
CREATE TABLE `research_training_type` (
  `research_training_type_id` int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `duration` varchar(45) DEFAULT NULL,
  `cost` double DEFAULT NULL,
  `no_of_courses` int(11) DEFAULT NULL,
  `mode_of_training` varchar(45) DEFAULT NULL

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

CREATE TABLE `payment` (
  `payment_id` int(11) NOT NULL AUTO_INCREMENT,
  `card_holder_name` varchar(45) DEFAULT NULL,
  `card_type` varchar(45) DEFAULT NULL,
  `card_number` varchar(45) DEFAULT NULL,
  `cvv` varchar(45) DEFAULT NULL,
  `exp_date` date DEFAULT NULL,
  PRIMARY KEY (`payment_id`)
);


CREATE TABLE `trainer` (
  `trainer_id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `gender` varchar(45) DEFAULT NULL,
  `known_courses` varchar(100) DEFAULT NULL,
  `user_name` varchar(45) DEFAULT NULL,
  `passwordd` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`trainer_id`),
  UNIQUE KEY `user_name_UNIQUE` (`user_name`)
) ;




CREATE TABLE `workshop` (
  `workshop_id` int(50) NOT NULL AUTO_INCREMENT,
  `workshop_type_id` int(11) DEFAULT NULL,
  `course_id` int(11) DEFAULT NULL,
  `workshop_date` date DEFAULT NULL,
  `trainer_id` int(11) DEFAULT NULL,
  `material_path` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`workshop_id`),
  CONSTRAINT `course_id_fk`
  FOREIGN KEY (`course_id`) REFERENCES `course` (`course_id`),
  CONSTRAINT `trainer_id_fk`
  FOREIGN KEY (`trainer_id`) REFERENCES `trainer` (`trainer_id`)
);



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
  `workshop_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`workshop_enrolment_id`),
  CONSTRAINT `student_id_fk`
  FOREIGN KEY (`student_id`) REFERENCES `student` (`student_id`),
  CONSTRAINT `workshop_id_fk`
  FOREIGN KEY (`workshop_id`) REFERENCES `workshop` (`workshop_id`)
);

CREATE TABLE `inplant_training_type` (
  `inplant_training_type_id` int(11) NOT NULL AUTO_INCREMENT,
  `mode_of_training` varchar(45) DEFAULT NULL,
  `no_of_programs` int(11) DEFAULT NULL,
  `total_days` int(11) DEFAULT NULL,
  `total_hours` int(11) DEFAULT NULL,
  `hours_per_day` int(11) DEFAULT NULL,
  `package` varchar(50) DEFAULT NULL,
  `cost` double DEFAULT NULL,
  PRIMARY KEY (`inplant_training_type_id`)
);


CREATE TABLE `inplant_training` (
  `inplant_training_id` int(11) NOT NULL AUTO_INCREMENT,
  `inplant_training_type_id` int(11) DEFAULT NULL,
  `course_id` int(11) DEFAULT NULL,
  `inplant_date` date DEFAULT NULL,
  `trainer_id` int(11) DEFAULT NULL,
  `material_path` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`inplant_training_id`),
  CONSTRAINT `course_id_inplan_fk`
  FOREIGN KEY (`course_id`) REFERENCES `course` (`course_id`),
  CONSTRAINT `inplant_training_type_id_fk`
  FOREIGN KEY (`inplant_training_type_id`) REFERENCES `inplant_training_type` (`inplant_training_type_id`),
  CONSTRAINT `trainer_id_inplan_fk`
  FOREIGN KEY (`trainer_id`) REFERENCES `trainer` (`trainer_id`)
);


CREATE TABLE `certificate` (
  `certificate_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `course_id` int(11) DEFAULT NULL,
  `total_month` int(11) DEFAULT NULL,
  `certificate_date` date DEFAULT NULL,
  `trainer_id` int(11) DEFAULT NULL,
  `cost` double DEFAULT NULL,
  `material_path` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`certificate_id`),
  CONSTRAINT `course_id_certificate_fk` FOREIGN KEY (`course_id`) REFERENCES `course` (`course_id`),
  CONSTRAINT `trainer_id_certificate_fk` FOREIGN KEY (`trainer_id`) REFERENCES `trainer` (`trainer_id`)
);

CREATE TABLE `certificate_enrolment` (
  `certificate_enrolment_id` int(11) NOT NULL AUTO_INCREMENT,
  `certificate_id` int(11) DEFAULT NULL,
  `student_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`certificate_enrolment_id`),
  CONSTRAINT `certificate_id_certificate_enrollment_fk` FOREIGN KEY (`certificate_id`) REFERENCES `certificate` (`certificate_id`),
  CONSTRAINT `student_id_certificate_enrollment_fk` FOREIGN KEY (`student_id`) REFERENCES `student` (`student_id`)
);

CREATE TABLE `inplant_training_enrolment` (
  `inplant_training_enrolment_id` int(11) NOT NULL AUTO_INCREMENT,
  `student_id` int(11) DEFAULT NULL,
  `inplant_training_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`inplant_training_enrolment_id`),
  CONSTRAINT `inplant_training_id_inplant_training_enrolment_fk` FOREIGN KEY (`inplant_training_id`) REFERENCES `inplant_training` (`inplant_training_id`),
  CONSTRAINT `student_id_inplant_training_enrolment_fk` FOREIGN KEY (`student_id`) REFERENCES `student` (`student_id`)
);

CREATE TABLE `research_training` (
  `research_training_id` int(11) NOT NULL AUTO_INCREMENT,
  `research_training_type_id` int(11) DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `trainer_id` int(11) DEFAULT NULL,
  `material_path` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`research_training_id`),
  CONSTRAINT `research_training_type_id_fk` FOREIGN KEY (`research_training_type_id`) REFERENCES `research_training_type` (`research_training_type_id`),
  CONSTRAINT `trainer_id_reasearch_training_fk` FOREIGN KEY (`trainer_id`) REFERENCES `trainer` (`trainer_id`)
);
CREATE TABLE `research_training_enrolment` (
  `research_training_enrolment_id` int(11) NOT NULL AUTO_INCREMENT,
  `student_id` int(11) DEFAULT NULL,
  `research_training_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`research_training_enrolment_id`),
  CONSTRAINT `research_training_enrolment_research_training_fk` FOREIGN KEY (`research_training_id`) REFERENCES `research_training` (`research_training_id`),
  CONSTRAINT `research_training_enrolment_student_id_fk` FOREIGN KEY (`student_id`) REFERENCES `student` (`student_id`)
);
CREATE TABLE `research_training_course_enrolment` (
  `research_training_course_enrolment` int(11) NOT NULL AUTO_INCREMENT,
  `research_training_enrolment_id` int(11) DEFAULT NULL,
  `course_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`research_training_course_enrolment`),
  CONSTRAINT `rt_course_enrolment_course_id_fk` FOREIGN KEY (`course_id`) REFERENCES `course` (`course_id`),
  CONSTRAINT `rt_course_enrolment_rt_enrolment_id_fk` FOREIGN KEY (`research_training_enrolment_id`) REFERENCES `research_training_enrolment` (`research_training_enrolment_id`)
);





