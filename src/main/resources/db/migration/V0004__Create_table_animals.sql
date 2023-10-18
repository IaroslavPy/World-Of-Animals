CREATE TABLE `animals` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(256) NOT NULL,
  `description` TEXT NOT NULL,
  `breed_id` INT NOT NULL,
  `created` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `updated` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `fk_animals_breed_id` (`breed_id`),
  CONSTRAINT `fk_animals_breed_id` FOREIGN KEY (`breed_id`) REFERENCES `animal_breeds` (`id`)
);