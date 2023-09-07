CREATE DATABASE  IF NOT EXISTS `task_tracker`;
USE `task_tracker`;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `task`;

CREATE TABLE `task` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `title`varchar(45) DEFAULT NULL,
  `description` varchar(45) DEFAULT NULL,
  `completed` boolean DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

