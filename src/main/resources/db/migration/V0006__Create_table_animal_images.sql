CREATE TABLE `animal_images` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `animal_id` BIGINT NOT NULL,
  `file_path` VARCHAR(256) NOT NULL,
  `type` ENUM('png', 'jpeg') DEFAULT NULL,
  `size` BIGINT NOT NULL,
  `created` TIMESTAMP NOT NULL,
  `updated` TIMESTAMP NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_animal_images_animal_id` (`animal_id`),
  CONSTRAINT `fk_animal_images_animal_id` FOREIGN KEY (`animal_id`) REFERENCES `animals` (`id`)
);