-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 24, 2021 at 05:21 PM
-- Server version: 10.4.6-MariaDB
-- PHP Version: 7.3.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `buyers`
--

-- --------------------------------------------------------

--
-- Table structure for table `buyerreg`
--

CREATE TABLE `buyerreg` (
  `Bid` int(20) NOT NULL,
  `FristName` varchar(50) NOT NULL,
  `LastName` varchar(50) NOT NULL,
  `Username` varchar(20) NOT NULL,
  `MobileNu` varchar(20) NOT NULL,
  `Email` varchar(30) NOT NULL,
  `Address` varchar(200) NOT NULL,
  `Password` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `buyerreg`
--

INSERT INTO `buyerreg` (`Bid`, `FristName`, `LastName`, `Username`, `MobileNu`, `Email`, `Address`, `Password`) VALUES
(1, 'Tharushaa', 'Dhananjani', 'Tharuu17', '710841465', 'Tharushaa.td17@gmail.com', 'Narammala', 'Tharuu8217');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `buyerreg`
--
ALTER TABLE `buyerreg`
  ADD PRIMARY KEY (`Bid`),
  ADD UNIQUE KEY `Username` (`Username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `buyerreg`
--
ALTER TABLE `buyerreg`
  MODIFY `Bid` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
