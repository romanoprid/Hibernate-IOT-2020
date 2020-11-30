-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema roman_oprysk
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `roman_oprysk` ;

-- -----------------------------------------------------
-- Schema roman_oprysk
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `roman_oprysk` DEFAULT CHARACTER SET utf8 ;
USE `roman_oprysk` ;

-- -----------------------------------------------------
-- Table `roman_oprysk`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `roman_oprysk`.`user` ;

CREATE TABLE IF NOT EXISTS `roman_oprysk`.`user` (
                                                     `id` INT NOT NULL,
                                                     `name` VARCHAR(45) NULL,
                                                     `birth_date` DATE NULL,
                                                     `followers` INT NULL,
                                                     `followings` INT NULL,
                                                     `posts` INT NULL,
                                                     PRIMARY KEY (`id`))
    ENGINE = InnoDB;

CREATE UNIQUE INDEX `id_UNIQUE` ON `roman_oprysk`.`user` (`id` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `roman_oprysk`.`story`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `roman_oprysk`.`story` ;

CREATE TABLE IF NOT EXISTS `roman_oprysk`.`story` (
                                                      `id` INT NOT NULL,
                                                      `bloger` VARCHAR(45) NULL,
                                                      `link` VARCHAR(45) NULL,
                                                      `add_time` INT NULL,
                                                      `length_time` INT NULL,
                                                      `content` VARCHAR(45) NULL,
                                                      `filters` VARCHAR(45) NULL,
                                                      `complaint_number` VARCHAR(45) NULL,
                                                      `like_number` INT NULL,
                                                      `share_number` INT NULL,
                                                      PRIMARY KEY (`id`))
    ENGINE = InnoDB;

CREATE UNIQUE INDEX `id_UNIQUE` ON `roman_oprysk`.`story` (`id` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `roman_oprysk`.`security`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `roman_oprysk`.`security` ;

CREATE TABLE IF NOT EXISTS `roman_oprysk`.`security` (
                                                         `id` INT NOT NULL,
                                                         `password` VARCHAR(30) NULL,
                                                         `user_id` INT NOT NULL,
                                                         PRIMARY KEY (`id`, `user_id`),
                                                         CONSTRAINT `fk_security_user1`
                                                             FOREIGN KEY (`user_id`)
                                                                 REFERENCES `roman_oprysk`.`user` (`id`)
                                                                 ON DELETE NO ACTION
                                                                 ON UPDATE NO ACTION)
    ENGINE = InnoDB;

CREATE INDEX `fk_security_user1_idx` ON `roman_oprysk`.`security` (`user_id` ASC) VISIBLE;

CREATE UNIQUE INDEX `user_id_UNIQUE` ON `roman_oprysk`.`security` (`user_id` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `roman_oprysk`.`save_on_top`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `roman_oprysk`.`save_on_top` ;

CREATE TABLE IF NOT EXISTS `roman_oprysk`.`save_on_top` (
                                                            `id` INT NOT NULL,
                                                            `position` INT NULL,
                                                            `status` VARCHAR(45) NULL,
                                                            `story_id` INT NOT NULL,
                                                            PRIMARY KEY (`id`, `story_id`),
                                                            CONSTRAINT `fk_save_on_top_story1`
                                                                FOREIGN KEY (`story_id`)
                                                                    REFERENCES `roman_oprysk`.`story` (`id`)
                                                                    ON DELETE NO ACTION
                                                                    ON UPDATE NO ACTION)
    ENGINE = InnoDB;

CREATE INDEX `fk_save_on_top_story1_idx` ON `roman_oprysk`.`save_on_top` (`story_id` ASC) VISIBLE;

CREATE UNIQUE INDEX `id_UNIQUE` ON `roman_oprysk`.`save_on_top` (`id` ASC) VISIBLE;

CREATE UNIQUE INDEX `story_id_UNIQUE` ON `roman_oprysk`.`save_on_top` (`story_id` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `roman_oprysk`.`user_has_story`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `roman_oprysk`.`user_has_story` ;

CREATE TABLE IF NOT EXISTS `roman_oprysk`.`user_has_story` (
                                                               `user_id` INT NOT NULL,
                                                               `story_id` INT NOT NULL,
                                                               PRIMARY KEY (`user_id`, `story_id`),
                                                               CONSTRAINT `fk_user_has_story_user`
                                                                   FOREIGN KEY (`user_id`)
                                                                       REFERENCES `roman_oprysk`.`user` (`id`)
                                                                       ON DELETE NO ACTION
                                                                       ON UPDATE NO ACTION,
                                                               CONSTRAINT `fk_user_has_story_story`
                                                                   FOREIGN KEY (`story_id`)
                                                                       REFERENCES `roman_oprysk`.`story` (`id`)
                                                                       ON DELETE NO ACTION
                                                                       ON UPDATE NO ACTION)
    ENGINE = InnoDB;

CREATE INDEX `fk_user_has_story_story1_idx` ON `roman_oprysk`.`user_has_story` (`story_id` ASC) VISIBLE;

CREATE INDEX `fk_user_has_story_user_idx` ON `roman_oprysk`.`user_has_story` (`user_id` ASC) VISIBLE;

CREATE UNIQUE INDEX `user_id_UNIQUE` ON `roman_oprysk`.`user_has_story` (`user_id` ASC) VISIBLE;

CREATE UNIQUE INDEX `story_id_UNIQUE` ON `roman_oprysk`.`user_has_story` (`story_id` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `roman_oprysk`.`initialization`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `roman_oprysk`.`initialization` ;

CREATE TABLE IF NOT EXISTS `roman_oprysk`.`initialization` (
                                                               `id` INT NOT NULL,
                                                               `login` VARCHAR(45) NULL,
                                                               `user_id` INT NOT NULL,
                                                               PRIMARY KEY (`id`, `user_id`),
                                                               CONSTRAINT `fk_initialization_user1`
                                                                   FOREIGN KEY (`user_id`)
                                                                       REFERENCES `roman_oprysk`.`user` (`id`)
                                                                       ON DELETE NO ACTION
                                                                       ON UPDATE NO ACTION)
    ENGINE = InnoDB;

CREATE INDEX `fk_initialization_user1_idx` ON `roman_oprysk`.`initialization` (`user_id` ASC) VISIBLE;


INSERT INTO `user` (id, name, birth_date, followers, followings, posts) VALUES
(1, 'Nazar',20,34, 34, 3),
(2, 'Luda',20, 45, 60, 10),
(3, 'Anna',20, 100, 56, 4),
(4, 'Danilo',20,37, 6,7),
(5, 'Roman', 20,1000, 54, 8),
(6, 'Vika', 20,34, 34, 3),
(7, 'Julia',20, 45, 60, 10),
(8, 'Max',20, 100, 56, 4),
(9, 'Yaryna',20,  37, 6,7),
(10, 'Andrii', 20,1000, 54, 8);


INSERT INTO `story` (id, bloger, link, add_time, content, like_number, share_number) VALUES
(1, 'Nazar', 'aarg',34,'video', 4, 2),
(2, 'Luda','agaejnjgn', 45,'photo', 12, 3),
(3, 'Anna','jadkada', 100,'photo', 23, 4),
(4, 'Danilo','fereger',  37, 'video', 25, 1),
(5, 'Roman', 'addadwd',1000,'video', 56, 23),
(6, 'Vika', 'wgee5tr',34,'video',35,65),
(7, 'Julia','hhtdns', 45,'video',11,13),
(8, 'Max','spkgskrmgsrl', 100,'video', 23, 3),
(9, 'Yaryna','srrgmgrks',  37,'video',13,42),
(10, 'Andrii', 'sdfkaeioenf',1000,'video', 56, 2);










INSERT INTO `security` (id, password, user_id) VALUES
(1, 'deadpool2001', 1),
(2, 'nazar2001', 2),
(3,  'giganter2000', 3),
(4,  'nimbus3000',  4),
(5, 'romanroman', 5),
(6,'enderman',  6),
(7, 'DeAdPoOl2001', 7),
(8, 'gigante3',  8),
(9, 'max4nik', 9),
(10, 'nazar4ik', 10);




INSERT INTO `initialization` (id, login, user_id) VALUES
(1, 'Nazar', 3),
(2,'Luda', 10),
(3, 'Anna', 4),
(4,  'Roman',7),
(5,  'Danilo', 8),
(6,'Vika', 3),
(7,  'Julia', 10),
(8, 'Max',  4),
(9,  'Yaryna', 7),
(10,  'Andrii', 8);






INSERT INTO `save_on_top` (id, position, status, story_id) VALUES
(1, 25,'seen', 1),
(2, 34, 'close friends', 2),
(3, 54, 'recomandation', 3),
(4, 34,  'close friends',  4),
(5, 33,'seen', 5),
(6,12,'seen',  6),
(7, 10,'recomandation', 7),
(8, 9,'seen',  8),
(9, 39,'recomandation', 9),
(10,  10,'recomandation', 10);



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;





















# CREATE DATABASE IF NOT EXISTS roman_oprysk4;
# USE roman_oprysk4;
#
#
# DROP TABLE IF EXISTS save_on_top;
# DROP TABLE IF EXISTS initialization;
# DROP TABLE IF EXISTS security;
# DROP TABLE IF EXISTS story;
# DROP TABLE IF EXISTS user;
#
#
#
#
# CREATE TABLE  user (
# id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
# name VARCHAR(45),
# birth_date INT,
# followers INT,
# followings INT,
# posts INT
# ) ENGINE = INNODB;
#
#
#
#
#
#
# CREATE TABLE  story (
# id INT NOT NULL AUTO_INCREMENT  PRIMARY KEY,
# bloger VARCHAR(45),
# link VARCHAR(45),
# add_time INT,
# content VARCHAR(45),
# like_number INT,
# share_number INT
# ) ENGINE = INNODB;
#
#
# CREATE TABLE  security (
# id INT NOT NULL AUTO_INCREMENT,
# password VARCHAR(30),
# user_id INT NOT NULL,
# PRIMARY KEY(id, user_id)
# ) ENGINE = INNODB;
#
#
#
#
#
# CREATE TABLE initialization (
# id INT NOT NULL AUTO_INCREMENT,
# login VARCHAR(45),
# user_id INT NOT NULL,
# PRIMARY KEY(id, user_id)
# ) ENGINE = INNODB;
#
# CREATE INDEX `initialization_user1_idx` ON `roman_oprysk4`.`initialization` (`user_id` ASC) VISIBLE;
#
#
#
#
# CREATE TABLE  save_on_top (
# id INT NOT NULL AUTO_INCREMENT,
# position INT,
# status VARCHAR(45),
# story_id INT NOT NULL,
# PRIMARY KEY(id, story_id)
# ) ENGINE = INNODB;
# CREATE INDEX `save_on_top_story` ON `roman_oprysk4`.`save_on_top` (`story_id` ASC) VISIBLE;
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
# ALTER TABLE security
#
# ADD CONSTRAINT security_user1
# FOREIGN KEY (user_id)
# REFERENCES user (id);
#
#
#
#
# ALTER TABLE initialization
#
# ADD CONSTRAINT initialization_user1
# FOREIGN KEY (user_id)
# REFERENCES user (id);
#
#
#
#
# ALTER TABLE save_on_top
#
# ADD CONSTRAINT save_on_top_story1
# FOREIGN KEY (story_id)
# REFERENCES story (id);
#
#
#
#
#
#
#
#
#
#

#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
