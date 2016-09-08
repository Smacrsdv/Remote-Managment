ALTER TABLE `user` DROP FOREIGN KEY `user_ibfk_2` ; 
ALTER TABLE `user` DROP COLUMN `department_id`;

ALTER TABLE `user` MODIFY  COLUMN `cv_link` varchar(500) NULL ;