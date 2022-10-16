CREATE DATABASE  IF NOT EXISTS `student_management_system`;
USE `student_management_system`;

DROP TABLE IF EXISTS `admin`;
DROP TABLE IF EXISTS `teacher`;
DROP TABLE IF EXISTS `student`;
DROP TABLE IF EXISTS `course`;
DROP TABLE IF EXISTS `assignment`;
DROP TABLE IF EXISTS `assignment_submission`;
DROP TABLE IF EXISTS `course_attendence`;

CREATE TABLE `admin` (
  `id` integer NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `mobile_number` varchar(14) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


CREATE TABLE `teacher` (
  `id` integer NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `mobile_number` varchar(14) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE `student` (
  `id` integer NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `mobile_number` varchar(14) DEFAULT NULL,
  `age` integer DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `gender` varchar(45) DEFAULT NULL,
  
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


CREATE TABLE `course` (
  `id` integer NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `teacher_id` integer DEFAULT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE `course_student` (
  `course_id` integer DEFAULT NULL,
  `student_id` integer DEFAULT NULL,
  
  FOREIGN KEY (`student_id`) REFERENCES `student` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  FOREIGN KEY (`course_id`) REFERENCES `course` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;



CREATE TABLE `assignment` (
  `id` integer NOT NULL AUTO_INCREMENT,
  `description` varchar(200) DEFAULT NULL,
  `course_id` integer DEFAULT NULL,
  `due_date` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `course_assignments` 
   FOREIGN KEY (`course_id`) REFERENCES `course` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


CREATE TABLE `assignment_submission` (
  `id` integer NOT NULL AUTO_INCREMENT,
  `assignment_id` integer DEFAULT NULL,
  `student_id` integer DEFAULT NULL,
  `course_id` integer DEFAULT NULL,
  `date` date DEFAULT NULL,
  `content` varchar(400) DEFAULT NULL,
  `marks` integer DEFAULT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`student_id`) REFERENCES `student` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  FOREIGN KEY (`assignment_id`) REFERENCES `assignment` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  FOREIGN KEY (`course_id`) REFERENCES `course` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
  
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


CREATE TABLE `course_attendence` (
  `id` integer NOT NULL AUTO_INCREMENT,
  `course_id` integer DEFAULT NULL,
  `student_id` integer DEFAULT NULL,
  `attendance_date` date DEFAULT NULL,
  `status` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`course_id`) REFERENCES `course` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  FOREIGN KEY (`student_id`) REFERENCES `student` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;



INSERT INTO `student` VALUES 
	(1,'Nesma','nesma@asu.com','01085264230','22','Nasr city','female'),
	(2,'Dalia','dalia@asu.com','01085454230','23','Zamalek','female'),
	(3,'Ahmed','ahmed@asu.com','01085264541','22','Nasr city','male');


INSERT INTO `admin` VALUES 
	(1,'Mohamed','mohamed@asu.com','01124569752'),
	(2,'Sara','laila@asu.com','0124568451');
    

INSERT INTO `teacher` VALUES 
	(1,'Mostafa','teacher@asu.com','01124569752'),
	(2,'Fatma','fatma@asu.com','01024051451');
    

INSERT INTO `course` VALUES 
	(1,'cs',1),
	(2,'math',2),
    (3,'physics',2);
    

INSERT INTO `assignment` VALUES 
	(1,'first assignment',1,'2022-05-08'),
	(2,'second assignment',1,'2022-10-08');    


INSERT INTO `assignment_submission` VALUES 
	(1,1,1,2,'2022-05-15','assignment submission 1',70),
	(2,1,2,1,'2022-05-16','assignment submission 2',100);


INSERT INTO `course_attendence` VALUES 
	(1,1,1,'2022-05-15','attended'),
	(2,2,2,'2022-05-18','absent');

