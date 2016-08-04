DROP TABLE IF EXISTS `role_overtime_info`;
 CREATE TABLE `role_overtime_info` (
	`company_id` int(11) NOT NULL,
	`role_id` int(11) NOT NULL ,
	`is_overtime_per_day` tinyint(1) NOT NULL default 0,
	`default_overtime_price` float NULL default null,
	`default_overtime_fraction` float NULL default null,
	PRIMARY KEY (`company_id`,`role_id`),
	FOREIGN KEY (company_id) REFERENCES company(id),
	FOREIGN KEY (role_id) REFERENCES lut_authority(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
 