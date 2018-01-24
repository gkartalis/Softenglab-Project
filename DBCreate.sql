-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Φιλοξενητής: localhost
-- Χρόνος δημιουργίας: 24 Ιαν 2018 στις 18:47:14
-- Έκδοση διακομιστή: 10.1.21-MariaDB
-- Έκδοση PHP: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Βάση δεδομένων: `airtickets`
--

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `announcements`
--

CREATE TABLE `announcements` (
  `ID` int(5) NOT NULL,
  `title` varchar(50) NOT NULL,
  `announcement` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Άδειασμα δεδομένων του πίνακα `announcements`
--

INSERT INTO `announcements` (`ID`, `title`, `announcement`) VALUES
(8, 'Cancelled all USA flights', 'Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum ');

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `flights`
--

CREATE TABLE `flights` (
  `flightID` int(4) NOT NULL,
  `departure` varchar(30) NOT NULL,
  `destination` varchar(30) NOT NULL,
  `seatsAvailable` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Άδειασμα δεδομένων του πίνακα `flights`
--

INSERT INTO `flights` (`flightID`, `departure`, `destination`, `seatsAvailable`) VALUES
(1, 'Greece-Athens', 'Germany-Berlin', 15),
(234, 'Greece-Athens', 'USA-New York', 20),
(235, 'Germany-Berlin', 'Greece-Athens', 40),
(236, 'Germany-Frankfurt', 'Greece-Chania', 24),
(237, 'Greece-Athens', 'Belgium-Brussels', 5),
(238, 'Greece-Athens', 'UK-London', 90),
(239, 'UK-London', 'Greece-Athens', 42),
(240, 'Belgium-Brussels', 'Denmark-Oslo', 22),
(241, 'Netherlands-Amsterdam', 'Sweden-Stockholm', 20),
(242, 'Sweden-Stockholm', 'Netherlands-Amsterdam', 32),
(243, 'Denmark-Oslo', 'Belgium-Brussels', 64),
(244, 'Spain-Barcelona', 'Greece-Athens', 33),
(245, 'Greece-Athens', 'Spain-Barcelona', 34),
(246, 'Italy-Rome', 'Belgium-Charlerois', 28),
(247, 'Belgium-Charlerois', 'Italy-Rome', 0),
(248, 'Italy-Rome', 'Spain-Madrid', 43),
(249, 'Spain-Madrid', 'USA-Los Angeles', 53),
(250, 'USA-California', 'Portugal-Lisbon', 200),
(251, 'Portugal-Lisbon', 'USA-California', 123),
(252, 'USA-Las Vegas', 'Greece-Athens', 2);

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `Statistics`
--

CREATE TABLE `Statistics` (
  `date` date NOT NULL,
  `bookings` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `Users`
--

CREATE TABLE `Users` (
  `ID` int(5) NOT NULL,
  `name` varchar(25) NOT NULL,
  `surname` varchar(25) NOT NULL,
  `username` varchar(10) NOT NULL,
  `password` varchar(20) NOT NULL,
  `admin` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Άδειασμα δεδομένων του πίνακα `Users`
--

INSERT INTO `Users` (`ID`, `name`, `surname`, `username`, `password`, `admin`) VALUES
(1, 'Administrator', 'Administrator', 'Admin', 'password', 1);

--
-- Ευρετήρια για άχρηστους πίνακες
--

--
-- Ευρετήρια για πίνακα `announcements`
--
ALTER TABLE `announcements`
  ADD PRIMARY KEY (`ID`);

--
-- Ευρετήρια για πίνακα `flights`
--
ALTER TABLE `flights`
  ADD PRIMARY KEY (`flightID`);

--
-- Ευρετήρια για πίνακα `Users`
--
ALTER TABLE `Users`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT για άχρηστους πίνακες
--

--
-- AUTO_INCREMENT για πίνακα `announcements`
--
ALTER TABLE `announcements`
  MODIFY `ID` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
--
-- AUTO_INCREMENT για πίνακα `flights`
--
ALTER TABLE `flights`
  MODIFY `flightID` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=253;
--
-- AUTO_INCREMENT για πίνακα `Users`
--
ALTER TABLE `Users`
  MODIFY `ID` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
