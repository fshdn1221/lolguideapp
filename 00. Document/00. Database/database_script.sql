/*======================================================
	DATABASE CREATE SCRIPT OF LOL WIKIA APP
	AUTHOR: FSHDN
	SINCE: 2015-SEP-24 10:45 AM
	VERSION : 0.0.0.1
	DATABASE NAME: lol_wikia
=======================================================*/

/*CREATE DATABASE SCRIPT START*/
CREATE DATABASE lol_wikia
  DEFAULT CHARACTER SET utf8
  DEFAULT COLLATE utf8_general_ci;
/*CREATE DATABASE SCRIPT END*/

/*T01 Champion role create script start here*/
CREATE TABLE `lol_wikia`.`t01champrole` (
	`tid` VARCHAR(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT 'table primary key id', 
	`rolename` VARCHAR(50) NOT NULL COMMENT 'role name', 
	`updatetime` BIGINT(50) NOT NULL COMMENT 'last update time', 
	PRIMARY KEY (`tid`)
) ENGINE = InnoDB;
/*T01 Champion role information create script end here*/

/*T02 Champion basic information create script start here*/
CREATE TABLE `lol_wikia`.`t02champinfo` (
	`tid` VARCHAR(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL, 
	`ref_champ_ava` TEXT NULL, 
	`ref_champ_art` TEXT NULL, 
	`champ_name` VARCHAR(50) NOT NULL, 
	`champ_alias` VARCHAR(100) NOT NULL, 
	`join_date` BIGINT NOT NULL, 
	`fk_secondary_bar_type` VARCHAR(10) NOT NULL, 
	`fk_role_id_main` VARCHAR(10) NOT NULL, 
	`fk_role_id_sub` VARCHAR(10) NOT NULL, 
	`atk_stat` TINYINT UNSIGNED NOT NULL DEFAULT '0', 
	`def_stat` TINYINT UNSIGNED NOT NULL DEFAULT '0', 
	`abt_stat` TINYINT UNSIGNED NOT NULL DEFAULT '0', 
	`dif_stat` TINYINT UNSIGNED NOT NULL DEFAULT '0', 
	`ip_cost` SMALLINT UNSIGNED NOT NULL, 
	`rp_cost` SMALLINT UNSIGNED NOT NULL, 
	`ref_lore` INT NOT NULL, 
	`updatetime` BIGINT NOT NULL, 
	PRIMARY KEY (`tid`)
) ENGINE = InnoDB;
/*T02 Champion basic information create script end here*/

/*T03 Champion base stat create script start here*/
CREATE TABLE `lol_wikia`.`t03champbasestat` (
	`tid` VARCHAR(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL, 
	`fk_champid` VARCHAR(10) NOT NULL, 
	`health` DECIMAL(10, 3), 
	`health_incr` DECIMAL(10, 3), 
	`health_regen` DECIMAL(10, 3), 
	`health_regen_incr` DECIMAL(10, 3), 
	`secbar` DECIMAL(10, 3), 
	`secbar_incr` DECIMAL(10, 3), 
	`secbar_regen` DECIMAL(10, 3), 
	`secbar_regen_incr` DECIMAL(10, 3), 
	`atk_range` DECIMAL(10, 3), 
	`atk_range_incr` DECIMAL(10, 3), 
	`atk` DECIMAL(10, 3), 
	`atk_incr` DECIMAL(10, 3), 
	`armor` DECIMAL(10, 3), 
	`armor_incr` DECIMAL(10, 3), 
	`atk_spd` DECIMAL(10, 3), 
	`atk_spd_incr` DECIMAL(10, 3), 
	`mgr` DECIMAL(10, 3), 
	`mgr_incr` DECIMAL(10, 3), 
	`mov_spd` DECIMAL(10, 3), 
	`mov_spd_incr` DECIMAL(10, 3), 
	`updatetime` BIGINT NOT NULL, 
	PRIMARY KEY (`tid`)
) ENGINE = InnoDB;
/*T03 Champion base stat create script end here*/

/*T04 Champion skill create script start here*/
CREATE TABLE `lol_wikia`.`t04champskill` (
	`tid` VARCHAR(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL, 
	`fk_champ_id` VARCHAR(10) NOT NULL, 
	`ref_content` TEXT NOT NULL, 
	`updatetime` BIGINT NOT NULL, 
	PRIMARY KEY (`tid`)
) ENGINE = InnoDB;
/*T04 Champion skill create script end here*/

/*T05 Champion secondbar type  create script start here*/
CREATE TABLE `lol_wikia`.`t05secbartype` (
	`tid` VARCHAR(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL, 
	`secondbar_type` VARCHAR(50) NOT NULL, 
	`updatetime` BIGINT(50) NOT NULL, 
	PRIMARY KEY (`tid`)
) ENGINE = InnoDB;
/*T05 Champion secondbar type create script end here*/