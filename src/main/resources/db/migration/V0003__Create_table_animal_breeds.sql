CREATE TABLE `animal_breeds` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `type_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_animal_breeds_name` (`name`),
  KEY `fk_animal_breeds_type_id` (`type_id`)
  );