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
