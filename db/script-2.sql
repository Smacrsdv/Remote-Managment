ALTER TABLE `company` DROP COLUMN `is_enabled`;
ALTER TABLE `company` ADD `active`  tinyint(1) DEFAULT 1;

DROP TABLE IF EXISTS `lut_project_status`;
 CREATE TABLE `lut_project_status` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`name` varchar(50) NOT NULL UNIQUE,
	PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `department`;
 CREATE TABLE `department` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`name` varchar(50) NOT NULL UNIQUE,
	`company_id` int(11) NOT NULL,
	`active` tinyint(1) NOT NULL default 1,
	PRIMARY KEY (`id`), 
	FOREIGN KEY (company_id) REFERENCES company(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `user`;
 CREATE TABLE `user` ( 
	`id` int(11) NOT NULL,
	`name` varchar(50) NOT NULL,
	`address` varchar(500) NOT NULL,
	`cv_link` varchar(500) NOT NULL,
	`department_id` int(11) NOT NULL, 
	PRIMARY KEY (`id`), 
	FOREIGN KEY (id) REFERENCES account(id),
	FOREIGN KEY (department_id) REFERENCES department(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `project`;
 CREATE TABLE `project` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`name` varchar(50) NOT NULL UNIQUE,
	`nickname` varchar(50) NOT NULL,
	`company_id` int(11) NOT NULL,
	`project_status_id` int(11) NOT NULL,
	`project_manager_id` int(11) NOT NULL,
	`active` tinyint(1) NOT NULL default 1,
	PRIMARY KEY (`id`),
	FOREIGN KEY (company_id) REFERENCES company(id),
	FOREIGN KEY (project_status_id) REFERENCES lut_project_status(id),
	FOREIGN KEY (project_manager_id) REFERENCES user(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `project_info`;
 CREATE TABLE `project_info` (
	`project_id` int(11) NOT NULL,
	`description` varchar(2000) NULL, 
	`create_date`  timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ,
	`start_date`  timestamp NOT NULL,
	`expected_delivery_dev_date` timestamp NOT NULL, 
	`actual_delivery_dev_date` timestamp NULL,
	`expected_delivery_qc_date` timestamp NOT NULL, 
	`actual_delivery_qc_date` timestamp NULL,
	`expected_delivery_c_date` timestamp NOT NULL, 
	`actual_delivery_c_date` timestamp NULL,
	`expected_budget` float NOT NULL,
	`actual_budget` float NULL,
	PRIMARY KEY (`project_id`), 
	FOREIGN KEY (project_id) REFERENCES project(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `project_department`;
 CREATE TABLE `project_department` ( 
	`project_id` int(11) NOT NULL,
	`department_id` int(11) NOT NULL, 
	PRIMARY KEY (`project_id`, `department_id`), 
	FOREIGN KEY (project_id) REFERENCES project(id),
	FOREIGN KEY (department_id) REFERENCES department(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `user_project`;
 CREATE TABLE `user_project` ( 
	`project_id` int(11) NOT NULL,
	`user_id` int(11) NOT NULL, 
	PRIMARY KEY (`project_id`, `user_id`), 
	FOREIGN KEY (project_id) REFERENCES project(id),
	FOREIGN KEY (user_id) REFERENCES user(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `sprint`;
 CREATE TABLE `sprint` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`name` varchar(50) NOT NULL,
	`project_id` int(11) NOT NULL,
	`start_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ,
	`end_date` timestamp NOT NULL,
	`active` tinyint(1) NOT NULL default 1,
	PRIMARY KEY (`id`), 
	FOREIGN KEY (project_id) REFERENCES project(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `lut_task_status`;
 CREATE TABLE `lut_task_status` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`name` varchar(50) NOT NULL UNIQUE,
	PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `task`;
 CREATE TABLE `task` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`lut_task_status_id` int(11) NOT NULL,
	`title` varchar(50) NOT NULL,
	`description` varchar(50) NULL,
	`sprint_id` int(11) NOT NULL,
	`expected_hours` float NOT NULL,
	`active` tinyint(1) NOT NULL default 1,
	PRIMARY KEY (`id`), 
	FOREIGN KEY (sprint_id) REFERENCES sprint(id),
	FOREIGN KEY (lut_task_status_id) REFERENCES lut_task_status(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `user_task`;
 CREATE TABLE `user_task` (
	`task_id` int(11) NOT NULL,
	`user_id` int(11) NOT NULL,
	`total_work_time` int(11) NOT NULL,
	PRIMARY KEY (`task_id`,`user_id`), 
	FOREIGN KEY (task_id) REFERENCES task(id),
	FOREIGN KEY (user_id) REFERENCES user(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `task_work_entry`;
 CREATE TABLE `task_work_entry` (
	`id` BIGINT NOT NULL AUTO_INCREMENT,
	`task_id` int(11) NOT NULL,
	`user_id` int(11) NOT NULL,
	`start_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ,
	`end_date` timestamp NULL,
	`duration` int(11) NULL,
	PRIMARY KEY (`id`), 
	FOREIGN KEY (task_id) REFERENCES task(id),
	FOREIGN KEY (user_id) REFERENCES user(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `team`;
 CREATE TABLE `team` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`company_id` int(11) NOT NULL,
	`name` varchar(50) NOT NULL,
	`description` varchar(50) NULL,
	`team_leader_id` int(11) NOT NULL,
	`create_date`  timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
	`active` tinyint(1) NOT NULL default 1,
	PRIMARY KEY (`id`), 
	FOREIGN KEY (team_leader_id) REFERENCES user(id),
	FOREIGN KEY (company_id) REFERENCES company(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `user_team`;
 CREATE TABLE `user_team` (
	`team_id` int(11) NOT NULL,
	`user_id` int(11) NOT NULL, 
	PRIMARY KEY (`team_id`,`user_id`), 
	FOREIGN KEY (team_id) REFERENCES team(id),
	FOREIGN KEY (user_id) REFERENCES user(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `documents`;
 CREATE TABLE `documents` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`company_id` int(11) NOT NULL,
	`project_id` int(11) NULL,
	`task_id` int(11) NULL,
	`sprint_id` int(11) NULL,
	`uploader_id` int(11) NOT NULL,
	`upload_date`  timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
	`link` varchar(500) NOT NULL,
	`discriminator` tinyint(3) NOT NULL default 1,
	PRIMARY KEY (`id`), 
	FOREIGN KEY (uploader_id) REFERENCES user(id),
	FOREIGN KEY (company_id) REFERENCES company(id),
	FOREIGN KEY (project_id) REFERENCES project(id),
	FOREIGN KEY (task_id) REFERENCES task(id),
	FOREIGN KEY (sprint_id) REFERENCES sprint(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


