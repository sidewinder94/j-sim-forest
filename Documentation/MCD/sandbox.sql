CREATE TABLE `PARAMETRES` (
  `id_configuration`,
  `nb_pas`,
  `vitesse`,
  `taille_grille`,
  `cellule`,
  PRIMARY KEY(`id_configuration`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;

CREATE TABLE `CONFIGURATION` (
  `cellule`,
  `pos_x`,
  `pos_y`,
  `etat`,
  PRIMARY KEY(`cellule`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;

ALTER TABLE `PARAMETRES` ADD FOREIGN KEY (`cellule`) REFERENCES `CONFIGURATION` (`cellule`);