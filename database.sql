-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 13, 2024 at 04:39 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `java_amadeus`
--

-- --------------------------------------------------------

--
-- Table structure for table `airport`
--

CREATE TABLE `airport` (
  `aid` bigint(20) NOT NULL,
  `airport_city` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `airport`
--

INSERT INTO `airport` (`aid`, `airport_city`) VALUES
(1, 'Istanbul'),
(2, 'Mardin'),
(4, 'Ankara'),
(5, 'Lublin');

-- --------------------------------------------------------

--
-- Table structure for table `flight`
--

CREATE TABLE `flight` (
  `fid` bigint(20) NOT NULL,
  `arrival_time` datetime(6) DEFAULT NULL,
  `departure_time` datetime(6) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `arrival_airport_id` bigint(20) DEFAULT NULL,
  `departure_airport_id` bigint(20) DEFAULT NULL,
  `return_time` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `flight`
--

INSERT INTO `flight` (`fid`, `arrival_time`, `departure_time`, `price`, `arrival_airport_id`, `departure_airport_id`, `return_time`) VALUES
(8, '2024-01-11 18:00:00.000000', '2025-01-11 15:30:00.000000', 500, 1, 2, NULL),
(9, NULL, '2024-01-11 15:30:00.000000', 500, 2, 1, '2024-01-11 18:00:00'),
(10, NULL, '2024-01-11 15:30:00.000000', 500, 5, 4, '2024-01-11 18:00:00'),
(14, NULL, '2025-01-11 15:30:00.000000', 500, 1, 2, '2025-01-11 18:00:00'),
(15, NULL, '2025-01-11 15:30:00.000000', 500, 4, 5, '2025-01-11 18:00:00'),
(16, NULL, '2025-01-11 15:30:00.000000', 500, 1, 5, '2025-01-11 18:00:00'),
(17, NULL, '2025-01-11 15:30:00.000000', 500, 1, 4, '2025-01-11 18:00:00'),
(18, NULL, '2025-01-11 15:30:00.000000', 1000, 1, 4, '2025-01-11 18:00:00'),
(19, NULL, '2025-01-11 15:30:00.000000', 1800, 5, 2, '2025-01-11 18:00:00'),
(20, NULL, '2025-01-11 15:30:00.000000', 1800, 5, 2, NULL),
(21, NULL, '2025-01-11 15:30:00.000000', 1800, 2, 4, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE `role` (
  `rid` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`rid`, `name`) VALUES
(1, 'ROLE_Admin'),
(2, 'ROLE_User');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `uid` bigint(20) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `status` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`uid`, `email`, `password`, `status`) VALUES
(2, 'ertancank@mail.com', '123456', b'0'),
(4, 'ertancank1@mail.com', '$2a$10$meVEkUb.k/XEkSerNwSwuuC85vk4bGiqsC2E1FW5gUc5psWk.FxBm', b'0'),
(5, 'admin@admin.com', '$2a$10$95U9dVgNAePY72MVKM5UVuLI4r90VzqIMoN6.vK3oKgWvbMDe4/Wa', b'0'),
(6, 'normal@normal.com', '$2a$10$hIE2N57xFz9zN2VykzjjFexT70Y8d0jXjYLXZH4TXZ1g6MR8wuRXe', b'0');

-- --------------------------------------------------------

--
-- Table structure for table `user_roles`
--

CREATE TABLE `user_roles` (
  `user_uid` bigint(20) NOT NULL,
  `roles_rid` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user_roles`
--

INSERT INTO `user_roles` (`user_uid`, `roles_rid`) VALUES
(2, 1),
(4, 1),
(5, 1),
(6, 2);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `airport`
--
ALTER TABLE `airport`
  ADD PRIMARY KEY (`aid`);

--
-- Indexes for table `flight`
--
ALTER TABLE `flight`
  ADD PRIMARY KEY (`fid`),
  ADD KEY `FKor550l1m73innd911e6nm8lj0` (`arrival_airport_id`),
  ADD KEY `FKillsy04237nltbk2yryrbderb` (`departure_airport_id`);

--
-- Indexes for table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`rid`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`uid`);

--
-- Indexes for table `user_roles`
--
ALTER TABLE `user_roles`
  ADD KEY `FKp6taepjm8nbj4doesmj3uj5jy` (`roles_rid`),
  ADD KEY `FKsk35kye23trjmxl5owaoly5y8` (`user_uid`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `airport`
--
ALTER TABLE `airport`
  MODIFY `aid` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `flight`
--
ALTER TABLE `flight`
  MODIFY `fid` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT for table `role`
--
ALTER TABLE `role`
  MODIFY `rid` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `uid` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `flight`
--
ALTER TABLE `flight`
  ADD CONSTRAINT `FKillsy04237nltbk2yryrbderb` FOREIGN KEY (`departure_airport_id`) REFERENCES `airport` (`aid`),
  ADD CONSTRAINT `FKor550l1m73innd911e6nm8lj0` FOREIGN KEY (`arrival_airport_id`) REFERENCES `airport` (`aid`);

--
-- Constraints for table `user_roles`
--
ALTER TABLE `user_roles`
  ADD CONSTRAINT `FKp6taepjm8nbj4doesmj3uj5jy` FOREIGN KEY (`roles_rid`) REFERENCES `role` (`rid`),
  ADD CONSTRAINT `FKsk35kye23trjmxl5owaoly5y8` FOREIGN KEY (`user_uid`) REFERENCES `user` (`uid`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
