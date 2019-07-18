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

create table training_program_type
(
    training_program_type_id int auto_increment
         primary key,
    name varchar(70) null
);

create table research_training
(
    research_training_id int auto_increment
        primary key,
    duration varchar(45) null,
    cost double null,
    no_of_courses int(11) null,
    mode_of_training varchar(45) null,
    training_program_type_id int(11),
    constraint training_program_type_research_training_id_fk
    foreign key (training_program_type_id) references training_program_type (training_program_type_id)

);