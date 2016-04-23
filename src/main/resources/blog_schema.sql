DROP DATABASE IF EXISTS blog;
CREATE SCHEMA blog;
USE blog;

CREATE TABLE users (
  userName varchar(100) NOT NULL,
  emailId varchar(100) NOT NULL,
  password varchar(100) NOT NULL,
  PRIMARY KEY (userName)
) ENGINE=InnoDB;

CREATE TABLE posts(
	postId integer  NOT NULL AUTO_INCREMENT,
	title varchar(100) NOT NULL,
	body text not null,
	date datetime DEFAULT CURRENT_TIMESTAMP,
	author varchar(100) not null,
	PRIMARY KEY (postId),
	FOREIGN KEY (author) REFERENCES blog.users(userName) ON DELETE RESTRICT ON UPDATE RESTRICT
)ENGINE=InnoDB;