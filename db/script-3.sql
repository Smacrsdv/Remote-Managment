DROP TABLE IF EXISTS `company_info`;
 CREATE TABLE `company_info` (
	`company_id` int(11) NOT NULL,
	`salary_day` timestamp NOT NULL,
	`saturday` tinyint(1) DEFAULT 1,
	`sunday` tinyint(1) DEFAULT 1,
	`monday` tinyint(1) DEFAULT 1,
	`tuesday` tinyint(1) DEFAULT 1,
	`wednesday` tinyint(1) DEFAULT 1,
	`thursday` tinyint(1) DEFAULT 1,
	`friday` tinyint(1) DEFAULT 1,
	`s_time` timestamp NOT NULL,
	`e_time` timestamp NOT NULL,
	`work_time` int(11) NOT NULL,
	`break_time` int(11) NOT NULL,
	`is_break_time_work_time` tinyint(1) NOT NULL DEFAULT 1,
	`is_weekend_included` tinyint(1) NOT NULL default 0,
	`is_vacancy_included` tinyint(1) NOT NULL default 0,
	`is_overlab_happen` tinyint(1) NOT NULL default 0,
	`is_overtime_included` tinyint(1) NOT NULL default 0,
	`is_overtime_per_day` tinyint(1) NOT NULL default 0,
	`is_cpm` tinyint(1) NOT NULL DEFAULT 1,
	`expected_hours` int(11) NOT NULL DEFAULT 1,
	`default_overtime_price` float NULL default null,
	`default_overtime_fraction` float NULL default null,
	PRIMARY KEY (`company_id`),
	FOREIGN KEY (company_id) REFERENCES company(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

RENAME TABLE `authority` TO `lut_authority`;

DROP TABLE IF EXISTS `role_overtime_info`;
 CREATE TABLE `role_overtime_info` (
	`company_id` int(11) NOT NULL,
	`role_id` int(11) NOT NULL ,
	`is_overtime_per_day` tinyint(1) NOT NULL default 0,
	`default_overtime_price` float NULL default null,
	`default_overtime_fraction` float NULL default null,
	PRIMARY KEY (`company_id`),
	FOREIGN KEY (company_id) REFERENCES company(id),
	FOREIGN KEY (role_id) REFERENCES lut_authority(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `user_company`;
 CREATE TABLE `user_company` (
	`company_id` int(11) NOT NULL,
	`user_id` int(11) NOT NULL,
	`is_overtime_per_day` tinyint(1) NOT NULL default 0,
	`default_overtime_price` float NULL default null,
	`default_overtime_fraction` float NULL default null,
	`is_full_time` tinyint(1) NOT NULL,
	`join_date`  timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
	`salary` float NOT NULL DEFAULT 0,
	`expected_hours` float NOT NULL DEFAULT 0,
	`hour_price` float NOT NULL DEFAULT 0,
	PRIMARY KEY (`company_id`,`user_id`),
	FOREIGN KEY (company_id) REFERENCES company(id),
	FOREIGN KEY (user_id) REFERENCES user(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `company_month_hours`;
 CREATE TABLE `company_month_hours` (
	`company_id` int(11) NOT NULL,
	`month` timestamp NOT NULL,
	`hours_num` float NOT NULL,
	PRIMARY KEY (`company_id`,`month`),
	FOREIGN KEY (company_id) REFERENCES company(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `calender`;
 CREATE TABLE `calender` (
	`company_id` int(11) NOT NULL,
	`date` timestamp NOT NULL,
	`hours_num` float NOT NULL DEFAULT 0,
	`is_holiday` tinyint(1) NULL DEFAULT 0,
	`json` varchar(2000) NULL,
	PRIMARY KEY (`company_id`,`date`),
	FOREIGN KEY (company_id) REFERENCES company(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `salary_details_history`;
 CREATE TABLE `salary_details_history` (
	`company_id` int(11) NOT NULL,
	`user_id` int(11) NOT NULL,
	`date` timestamp NOT NULL,
	`is_full_time` tinyint(1) NOT NULL,
	`expected_hours` float NULL DEFAULT 0,
	`achived_hours_num` float NOT NULL DEFAULT 0,
	`salary` float NOT NULL DEFAULT 0,
	`hour_price` float NOT NULL DEFAULT 0,
	`is_overtime_per_day` tinyint(1) NOT NULL default 0,
	`overtime_price` float NULL default null,
	`overtime_fraction` float NULL default null,
	PRIMARY KEY (`company_id`,`date`,`user_id`),
	FOREIGN KEY (company_id) REFERENCES company(id),
	FOREIGN KEY (user_id) REFERENCES user(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `user_time_track`;
 CREATE TABLE `user_time_track` (
	`id` BIGINT NOT NULL AUTO_INCREMENT,
	`company_id` int(11) NOT NULL,
	`user_id` int(11) NOT NULL,
	`date` timestamp NOT NULL,
	`start_time` timestamp NOT NULL,
	`end_time` timestamp NULL,
	`total_minutes` int(11) NOT NULL, 
	PRIMARY KEY (`id`),
	FOREIGN KEY (company_id) REFERENCES company(id),
	FOREIGN KEY (user_id) REFERENCES user(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO `tm-development`.`lut_authority`(`role`) VALUES ('ROLE_SADMIN');
INSERT INTO `tm-development`.`lut_authority`(`role`) VALUES ('ROLE_ADMIN');
INSERT INTO `tm-development`.`lut_authority`(`role`) VALUES ('ROLE_USER');
INSERT INTO `tm-development`.`lut_authority`(`role`) VALUES ('ROLE_OWNER_');
INSERT INTO `tm-development`.`lut_authority`(`role`) VALUES ('ROLE_TOPMANAGER_');
INSERT INTO `tm-development`.`lut_authority`(`role`) VALUES ('ROLE_PROJECTMANAGER_');
INSERT INTO `tm-development`.`lut_authority`(`role`) VALUES ('ROLE_TEAMLEADER_');
INSERT INTO `tm-development`.`lut_authority`(`role`) VALUES ('ROLE_FEGLA_');
INSERT INTO `tm-development`.`lut_authority`(`role`) VALUES ('ROLE_OTHER_');



