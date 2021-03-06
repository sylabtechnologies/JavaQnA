-- MySQL Script generated by MySQL Workbench
-- Sun Dec 20 14:01:29 2020
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema utopia
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema utopia
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `utopia` DEFAULT CHARACTER SET utf8 ;
USE `utopia` ;

-- -----------------------------------------------------
-- Table `utopia`.`tbl_airport`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `utopia`.`tbl_airport` (
  `airportId` INT NOT NULL,
  `city` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`airportId`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `utopia`.`tbl_booking`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `utopia`.`tbl_booking` (
  `bookingId` INT NOT NULL,
  `flightId` INT NOT NULL,
  `isActive` TINYINT NOT NULL,
  `stripeId` VARCHAR(45) NOT NULL,
  `bookerId` INT NOT NULL,
  PRIMARY KEY (`bookingId`, `flightId`, `bookerId`),
  INDEX `fk_tbl_booking_tbl_users1_idx` (`bookerId` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `utopia`.`tbl_bookings_has_travelers`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `utopia`.`tbl_bookings_has_travelers` (
  `bookings_bookingId` INT NOT NULL,
  `bookings_flightId` INT NOT NULL,
  `traveler_travelerId` INT NOT NULL,
  PRIMARY KEY (`bookings_bookingId`, `bookings_flightId`, `traveler_travelerId`),
  INDEX `fk_tbl_bookings_has_tbl_traveler_tbl_traveler1_idx` (`traveler_travelerId` ASC) VISIBLE,
  INDEX `fk_tbl_bookings_has_tbl_traveler_tbl_bookings1_idx` (`bookings_bookingId` ASC, `bookings_flightId` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `utopia`.`tbl_flight`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `utopia`.`tbl_flight` (
  `flightId` INT NOT NULL AUTO_INCREMENT,
  `departTime` DATETIME NOT NULL,
  `seatsAvailable` INT NOT NULL,
  `price` FLOAT NOT NULL,
  `departCityId` INT NOT NULL,
  `arriveCityId` INT NOT NULL,
  PRIMARY KEY (`flightId`, `departTime`, `departCityId`, `arriveCityId`),
  INDEX `fk_tbl_flights_tbl_airport1_idx` (`departCityId` ASC) VISIBLE,
  INDEX `fk_tbl_flights_tbl_airport2_idx` (`arriveCityId` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `utopia`.`tbl_flight_has_bookings`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `utopia`.`tbl_flight_has_bookings` (
  `flights_flightId` INT NOT NULL,
  `flights_departTime` DATETIME NOT NULL,
  `flights_departCityId` INT NOT NULL,
  `flights_arriveCityId` INT NOT NULL,
  `bookings_bookingId` INT NOT NULL,
  `bookings_flightId` INT NOT NULL,
  PRIMARY KEY (`flights_flightId`, `flights_departTime`, `flights_departCityId`, `flights_arriveCityId`, `bookings_bookingId`, `bookings_flightId`),
  INDEX `fk_tbl_flights_has_tbl_bookings_tbl_bookings1_idx` (`bookings_bookingId` ASC, `bookings_flightId` ASC) VISIBLE,
  INDEX `fk_tbl_flights_has_tbl_bookings_tbl_flights1_idx` (`flights_flightId` ASC, `flights_departTime` ASC, `flights_departCityId` ASC, `flights_arriveCityId` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `utopia`.`tbl_flight_upload`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `utopia`.`tbl_flight_upload` (
  `flightUploadId` INT NOT NULL,
  `uploadedDate` DATETIME NOT NULL,
  `numberOfRecords` INT NOT NULL,
  PRIMARY KEY (`flightUploadId`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `utopia`.`tbl_flight_upload_details`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `utopia`.`tbl_flight_upload_details` (
  `flightUploadDetailsId` INT NOT NULL,
  `flightUploadId` INT NOT NULL,
  `departTime` DATETIME NOT NULL,
  `departCityId` INT NOT NULL,
  `arriveCityId` INT NOT NULL,
  PRIMARY KEY (`flightUploadDetailsId`, `flightUploadId`, `departCityId`, `arriveCityId`),
  INDEX `fk_tbl_flight_upload_details_tbl_flight_upload1_idx` (`flightUploadId` ASC) VISIBLE,
  INDEX `fk_tbl_flight_upload_details_tbl_airport1_idx` (`departCityId` ASC) VISIBLE,
  INDEX `fk_tbl_flight_upload_details_tbl_airport2_idx` (`arriveCityId` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `utopia`.`tbl_traveler`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `utopia`.`tbl_traveler` (
  `travelerId` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `address` VARCHAR(45) NOT NULL,
  `phone` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `dob` DATETIME NOT NULL,
  PRIMARY KEY (`travelerId`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `utopia`.`tbl_users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `utopia`.`tbl_users` (
  `userId` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `role` INT NOT NULL,
  PRIMARY KEY (`userId`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `utopia`.`tbl_payments` (
  `paymentId` INT NOT NULL,
  `bookingId` INT NOT NULL,
  `flightId` INT NOT NULL,
  PRIMARY KEY (`paymentId`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
