DROP TABLE IF EXISTS `user`;
 CREATE TABLE `user` ( 
	`id` int(11) NOT NULL,
	`name` varchar(50) NOT NULL,
	`address` varchar(500) NOT NULL,
	`cv_link` varchar(500) NULL,
	PRIMARY KEY (`id`), 
	FOREIGN KEY (id) REFERENCES account(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;