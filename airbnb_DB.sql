create database airbnb_DB;

use airbnb_db;

CREATE TABLE `Member` (
	`user_id`	INT(11)	NOT NULL auto_increment,
	`phone`	VARCHAR(13)	NOT NULL	COMMENT 'UNIQUE (중복 미허용)',
	`nickname`	VARCHAR(8)	NOT NULL	COMMENT 'UNIQUE (중복 미허용)',
	`name`	VARCHAR(8)	NOT NULL,
	`birthday`	DATETIME	NOT NULL,
	`email`	VARCHAR(100)	NOT NULL	COMMENT 'UNIQUE (중복 미허용)',
	`profile_image_path`	VARCHAR(255)	NULL,
	`join_date`	DATETIME	NOT NULL,
	`location`	VARCHAR(100)	NOT NULL,
    PRIMARY KEY (`user_id`)
);

CREATE TABLE `Host` (
	`user_id`	INT(11)	NOT NULL,
	`host_join_date`	DATETIME	NOT NULL,
	`review_count`	INT(8)	NOT NULL	DEFAULT 0,
	`rating` DECIMAL(3,2) NOT NULL	DEFAULT 1.00,
	`is_superhost`	BOOLEAN	NOT NULL
);

CREATE TABLE `Accommodation` (
	`accommodation_id`	INT(11)	NOT NULL auto_increment,
	`accommodation_name`	VARCHAR(100)	NOT NULL,
	`location_name`	VARCHAR(100)	NOT NULL,
	`location_alias`	VARCHAR(50)	NOT NULL,
	`guest_favorite`	BOOLEAN	NOT NULL,
	`accommodation_rating`	DECIMAL(3,2) NOT NULL	DEFAULT 1.00,
	`review_count`	INT(8)	NOT NULL	DEFAULT 0,
	`accommodation_price`	INT(11)	NULL,
    PRIMARY KEY (`accommodation_id`)
);

CREATE TABLE `Accommodation_Registration` (
	`user_id`	INT(11)	NOT NULL,
	`accommodation_id`	INT(11)	NOT NULL
);

CREATE TABLE `Review` (
	`review_id`	INT(11)	NOT NULL auto_increment,
	`accommodation_id`	INT(11)	NOT NULL,
	`user_id`	INT(11)	NOT NULL,
	`review_desc`	VARCHAR(300)	NOT NULL,
	`review_rating`	DECIMAL(3,2)	NOT NULL	DEFAULT 1.00,
	`date`	DATETIME	NOT NULL,
    PRIMARY KEY (`review_id`)
);

CREATE TABLE `Accommodation_Image` (
	`image_id`	INT(11)	NOT NULL auto_increment,
	`accommodation_id`	INT(11)	NOT NULL,
	`accommodation_image`	VARCHAR(100)	NOT NULL,
    PRIMARY KEY (`image_id`)
);

CREATE TABLE `Amenity` (
	`amenity_id`	INT(11)	NOT NULL auto_increment,
	`amenity_icon`	VARCHAR(100)	NULL,
    PRIMARY KEY (`amenity_id`)
);

CREATE TABLE `Accommodation_to_Amenity` (
	`accommodation_id`	INT(11)	NOT NULL,
	`amenity_id`	INT(11)	NOT NULL
);


ALTER TABLE `Accommodation_to_Amenity` ADD CONSTRAINT `FK_ACCOMMODATION_TO_AMENITY` PRIMARY KEY (
	`accommodation_id`,
	`amenity_id`
);

ALTER TABLE `Host` ADD CONSTRAINT `FK_Member_TO_Host_1` FOREIGN KEY (
	`user_id`
)
REFERENCES `Member` (
	`user_id`
);

ALTER TABLE `Accommodation_Registration` ADD CONSTRAINT `FK_Host_TO_Accommodation_Registration_1` FOREIGN KEY (
	`user_id`
)
REFERENCES `Host` (
	`user_id`
);

ALTER TABLE `Accommodation_Registration` ADD CONSTRAINT `FK_Accommodation_TO_Accommodation_Registration_1` FOREIGN KEY (
	`accommodation_id`
)
REFERENCES `Accommodation` (
	`accommodation_id`
);

ALTER TABLE `Accommodation_Image` ADD CONSTRAINT `FK_Accommodation_TO_Accommodation_Image_1` FOREIGN KEY (
	`accommodation_id`
)
REFERENCES `Accommodation` (
	`accommodation_id`
);

ALTER TABLE `Accommodation_to_Amenity` ADD CONSTRAINT `FK_Accommodation_TO_Accommodation_to_Amenity_1` FOREIGN KEY (
	`accommodation_id`
)
REFERENCES `Accommodation` (
	`accommodation_id`
);

ALTER TABLE `Accommodation_to_Amenity` ADD CONSTRAINT `FK_Amenity_TO_Accommodation_to_Amenity_1` FOREIGN KEY (
	`amenity_id`
)
REFERENCES `Amenity` (
	`amenity_id`
);

