USE `task_tracker`;

DROP TABLE IF EXISTS `authorities`;
DROP TABLE IF EXISTS `users`;

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `username` varchar(50) NOT NULL,
  `password` char(68) NOT NULL,
  `enabled` tinyint NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Inserting data for table `users`
--
-- NOTE: The passwords are encrypted using BCrypt
--
-- A generation tool is avail at: https://www.luv2code.com/generate-bcrypt-password
--
-- Default passwords here are: fun123
--

INSERT INTO `users` 
VALUES 
('shawn','{bcrypt}$2a$12$dDQDc7XT5N8l/3EO9RCAB.NoXAt8iw3er54bfLBGKlURRBkKlKNlu',1),
('John','{bcrypt}$2a$12$dDQDc7XT5N8l/3EO9RCAB.NoXAt8iw3er54bfLBGKlURRBkKlKNlu',1),
('susan','{bcrypt}$2a$12$dDQDc7XT5N8l/3EO9RCAB.NoXAt8iw3er54bfLBGKlURRBkKlKNlu',1);


--
-- Table structure for table `authorities`
--

CREATE TABLE `authorities` (
  `username` varchar(50) NOT NULL,
  `authority` varchar(50) NOT NULL,
  UNIQUE KEY `authorities4_idx_1` (`username`,`authority`),
  CONSTRAINT `authorities4_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Inserting data for table `authorities`
--

INSERT INTO `authorities` 
VALUES 
('john','ROLE_EMPLOYEE'),
('susan','ROLE_EMPLOYEE'),
('susan','ROLE_MANAGER'),
('shawn','ROLE_EMPLOYEE'),
('shawn','ROLE_MANAGER'),
('shawn','ROLE_ADMIN');