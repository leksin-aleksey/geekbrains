-- _countries ------------------------------------------------
ALTER TABLE `_countries` 
CHANGE COLUMN `country_id` `id` INT NOT NULL,
CHANGE COLUMN `title_ru` `title` VARCHAR(150) NOT NULL ,
ADD PRIMARY KEY (`id`);

ALTER TABLE `_countries` 
MODIFY COLUMN `id` INT NOT NULL AUTO_INCREMENT;

ALTER TABLE `_countries` 
ADD INDEX `_countries_title_idx` (`title` ASC) VISIBLE;

ALTER TABLE `_countries` 
DROP COLUMN `title_cz`,
DROP COLUMN `title_lv`,
DROP COLUMN `title_lt`,
DROP COLUMN `title_ja`,
DROP COLUMN `title_pl`,
DROP COLUMN `title_it`,
DROP COLUMN `title_fr`,
DROP COLUMN `title_de`,
DROP COLUMN `title_pt`,
DROP COLUMN `title_es`,
DROP COLUMN `title_en`,
DROP COLUMN `title_be`,
DROP COLUMN `title_ua`;

INSERT INTO `_countries` 
VALUES (0, 'N/A');

-- _regions ----------------------------------------------------
ALTER TABLE `_regions` 
DROP COLUMN `title_cz`,
DROP COLUMN `title_lv`,
DROP COLUMN `title_lt`,
DROP COLUMN `title_ja`,
DROP COLUMN `title_pl`,
DROP COLUMN `title_it`,
DROP COLUMN `title_fr`,
DROP COLUMN `title_de`,
DROP COLUMN `title_pt`,
DROP COLUMN `title_es`,
DROP COLUMN `title_en`,
DROP COLUMN `title_be`,
DROP COLUMN `title_ua`,
CHANGE COLUMN `region_id` `id` INT NOT NULL ,
CHANGE COLUMN `title_ru` `title` VARCHAR(150) NOT NULL ;

ALTER TABLE `_regions` 
ADD PRIMARY KEY (`id`),
ADD INDEX `fk_regions_country_id_idx` (`country_id` ASC) VISIBLE,
ADD INDEX `_regions_title_idx` (`title` ASC) INVISIBLE;
;

ALTER TABLE `_regions` 
MODIFY COLUMN `id` INT NOT NULL AUTO_INCREMENT;

ALTER TABLE `_regions` 
ADD CONSTRAINT `fk_regions_country_id`
  FOREIGN KEY (`country_id`)
  REFERENCES `_countries` (`id`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;

INSERT INTO `_regions`
SELECT 0, c.id, 'N/A'
FROM _countries c
WHERE c.title = 'N/A';

-- _cities ----------------------------------------------------
ALTER TABLE `_cities` 
DROP COLUMN `region_cz`,
DROP COLUMN `area_cz`,
DROP COLUMN `title_cz`,
DROP COLUMN `region_lv`,
DROP COLUMN `area_lv`,
DROP COLUMN `title_lv`,
DROP COLUMN `region_lt`,
DROP COLUMN `area_lt`,
DROP COLUMN `title_lt`,
DROP COLUMN `region_ja`,
DROP COLUMN `area_ja`,
DROP COLUMN `title_ja`,
DROP COLUMN `region_pl`,
DROP COLUMN `area_pl`,
DROP COLUMN `title_pl`,
DROP COLUMN `region_it`,
DROP COLUMN `area_it`,
DROP COLUMN `title_it`,
DROP COLUMN `region_fr`,
DROP COLUMN `area_fr`,
DROP COLUMN `title_fr`,
DROP COLUMN `region_de`,
DROP COLUMN `area_de`,
DROP COLUMN `title_de`,
DROP COLUMN `region_pt`,
DROP COLUMN `area_pt`,
DROP COLUMN `title_pt`,
DROP COLUMN `region_es`,
DROP COLUMN `area_es`,
DROP COLUMN `title_es`,
DROP COLUMN `region_en`,
DROP COLUMN `area_en`,
DROP COLUMN `title_en`,
DROP COLUMN `region_be`,
DROP COLUMN `area_be`,
DROP COLUMN `title_be`,
DROP COLUMN `region_ua`,
DROP COLUMN `area_ua`,
DROP COLUMN `title_ua`,
DROP COLUMN `region_ru`,
DROP COLUMN `area_ru`;

UPDATE `_cities` 
SET region_id = (SELECT id FROM _regions WHERE title = 'N/A')
WHERE region_id IS NULL;

ALTER TABLE `_cities` 
CHANGE COLUMN `city_id` `id` INT NOT NULL ,
CHANGE COLUMN `region_id` `region_id` INT NOT NULL ,
CHANGE COLUMN `title_ru` `title` VARCHAR(150) NOT NULL ;

ALTER TABLE `_cities` 
ADD PRIMARY KEY (`id`),
ADD INDEX `fk_cities_country_id_idx` (`country_id` ASC) VISIBLE,
ADD INDEX `fk_cities_region_id_idx` (`region_id` ASC) VISIBLE;
;

ALTER TABLE `_cities` 
MODIFY COLUMN `id` INT NOT NULL AUTO_INCREMENT;

ALTER TABLE `_cities` 
ADD CONSTRAINT `fk_cities_country_id`
  FOREIGN KEY (`country_id`)
  REFERENCES `_countries` (`id`)
  ON DELETE CASCADE
  ON UPDATE CASCADE,
ADD CONSTRAINT `fk_cities_region_id`
  FOREIGN KEY (`region_id`)
  REFERENCES `_regions` (`id`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;

