CREATE SCHEMA `k-sm-rki_persondb` ;

CREATE TABLE `k-sm-rki_persondb`.`persons` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));
  
CREATE TABLE `k-sm-rki_persondb`.`addresses` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `address` VARCHAR(45) NOT NULL,
  `person_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `address_person_fk_idx` (`person_id` ASC) VISIBLE,
  CONSTRAINT `address_person_fk`
    FOREIGN KEY (`person_id`)
    REFERENCES `k-sm-rki_persondb`.`persons` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE `k-sm-rki_persondb`.`contacts` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `contact` VARCHAR(45) NOT NULL,
  `address_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `contact_address_fk_idx` (`address_id` ASC) VISIBLE,
  CONSTRAINT `contact_address_fk`
    FOREIGN KEY (`address_id`)
    REFERENCES `k-sm-rki_persondb`.`addresses` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
    
    