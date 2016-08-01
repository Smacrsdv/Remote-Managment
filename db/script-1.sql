
DROP TABLE IF EXISTS `persistent_logins`;
 CREATE TABLE `persistent_logins` (
	`username` varchar(64) NOT NULL,
	`series` varchar(64) NOT NULL,
	`token` varchar(64) NOT NULL,
	`last_used` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`series`)
) ENGINE=MEMORY DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `account`;
 CREATE TABLE `account` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`username` varchar(50) NOT NULL UNIQUE,
	`email` varchar(150) NOT NULL UNIQUE,
	`password` varchar(100) NOT NULL,
	`is_account_non_expired` tinyint(1) NOT NULL default 1,
	`is_account_non_locked` tinyint(1) NOT NULL default 1,
	`is_credentials_non_expired` tinyint(1) NOT NULL default 1,
	`is_enabled` tinyint(1) NOT NULL default 1,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `authority`;
 CREATE TABLE `authority` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`role` varchar(50) NOT NULL UNIQUE,
	PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `company`;
 CREATE TABLE `company` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`name` varchar(50) NOT NULL UNIQUE,
	`email` varchar(150) NULL UNIQUE,
	`nickname` varchar(50) NOT NULL UNIQUE,
	`address` varchar(500) NULL,
	`is_company_non_expired` tinyint(1) NOT NULL default 1,
	`is_company_non_locked` tinyint(1) NOT NULL default 1,
	`is_enabled` tinyint(1) NOT NULL default 1,
	PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `account_authority`;
 CREATE TABLE `account_authority` ( 
	`account_id` int(11) NOT NULL,
	`authority_id` int(11) NOT NULL,
	`company_id` int(11) NOT NULL,
    `is_granted` tinyint NOT NULL DEFAULT 1,
    `grant_by` int(11) NOT NULL,
    `grant_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
	`denied_by` int(11) NULL,
    `denied_at` timestamp NULL ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`account_id`,`authority_id`,`company_id`),
	FOREIGN KEY (account_id) REFERENCES account(id),
    FOREIGN KEY (grant_by) REFERENCES account(id),
	FOREIGN KEY (denied_by) REFERENCES account(id),
	FOREIGN KEY (authority_id) REFERENCES authority(id),
	FOREIGN KEY (company_id) REFERENCES company(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;