INSERT INTO `k-sm-rki_persondb`.`persons` (`name`) VALUES ('Ádam');
INSERT INTO `k-sm-rki_persondb`.`persons` (`name`) VALUES ('Éva');

INSERT INTO `k-sm-rki_persondb`.`addresses` (`address`, `person_id`) VALUES ('Budapest', '1');
INSERT INTO `k-sm-rki_persondb`.`addresses` (`address`, `person_id`) VALUES ('Pécs', '1');
INSERT INTO `k-sm-rki_persondb`.`addresses` (`address`, `person_id`) VALUES ('Szeged', '2');

INSERT INTO `k-sm-rki_persondb`.`contacts` (`contact`, `address_id`) VALUES ('telefon', '1');
INSERT INTO `k-sm-rki_persondb`.`contacts` (`contact`, `address_id`) VALUES ('posta', '1');
INSERT INTO `k-sm-rki_persondb`.`contacts` (`contact`, `address_id`) VALUES ('telefon', '2');
INSERT INTO `k-sm-rki_persondb`.`contacts` (`contact`, `address_id`) VALUES ('posta', '3');
INSERT INTO `k-sm-rki_persondb`.`contacts` (`contact`, `address_id`) VALUES ('e-mail', '3');