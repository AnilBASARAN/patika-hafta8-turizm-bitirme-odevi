-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Feb 04, 2024 at 05:05 PM
-- Server version: 8.0.31
-- PHP Version: 7.4.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `turizm`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbl_featuretype`
--

CREATE TABLE `tbl_featuretype` (
  `id` int NOT NULL,
  `feature_name` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Dumping data for table `tbl_featuretype`
--

INSERT INTO `tbl_featuretype` (`id`, `feature_name`) VALUES
(1, 'Ücretsiz Otopark'),
(2, 'SPA'),
(3, '7/24 Oda Servisi'),
(4, 'Ücretsiz WiFi'),
(5, 'Yüzme Havuzu'),
(6, 'Fitness Center'),
(7, 'Hotel Concierge');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_hotel`
--

CREATE TABLE `tbl_hotel` (
  `hotel_id` int NOT NULL,
  `name` varchar(255) NOT NULL,
  `city` varchar(150) NOT NULL,
  `region` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `phoneNumber` varchar(15) NOT NULL,
  `stars` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Dumping data for table `tbl_hotel`
--

INSERT INTO `tbl_hotel` (`hotel_id`, `name`, `city`, `region`, `address`, `email`, `phoneNumber`, `stars`) VALUES
(1, 'RESORT OTEL', 'KASTAMONU', 'ABANA', 'adress1', 'mail@com', '012312333, 5),
(2, 'Diamond the resort sapanca', 'istanbul', 'Sapanca', 'adress2', 'blkotel@gmail.com', '05564123259', 3),
(6, 'ABANT ADENBOUTIQUE HOTEL&SPA', 'ISTANBUL ', 'DALAMAN', 'Sokal1. 89/A, 16190', 'aotel@gmail.com', '777', 3),
(21, 'ABANT ADENBOUTIQUE HOTEL&SPA', 'ISTANBUL ', 'DALAMAN', 'Soğanlı, Nilüfer Cd. 89/A, 16190', 'bursaotel@gmail.com', '888', 3),
(23, 'ABANT ADENBOUTIQUE HOTEL&SPA', 'ISTANBUL ', 'DALAMAN', 'Soğanlı, Nilüfer Cd. 89/A, 16190', 'bursaotel@gmail.com', '777', 3),
(31, 'ABANT ADENBOUTIQUE HOTEL&SPA', 'ISTANBUL ', 'DALAMAN', 'Soğanlı, Nilüfer Cd. 89/A, 16190', 'bursaotel@gmail.com', '777', 20),
(33, 'ABANT ADENBOUTIQUE HOTEL&SPA', 'ISTANBUL ', 'DALAMAN', 'Soğanlı, Nilüfer Cd. 89/A, 16190', 'bursaotel@gmail.com', '111111111', 5),
(34, 'ABANT ADENBOUTIQUE HOTEL&SPA', 'ISTANBUL ', 'DALAMAN', 'Soğanlı, Nilüfer Cd. 89/A, 16190', 'bursaotel@gmail.com', '111111111', 5),
(35, 'ABANT ADENBOUTIQUE HOTEL&SPA', 'ISTANBUL ', 'DALAMAN', 'Soğanlı, Nilüfer Cd. 89/A, 16190', 'bursaotel@gmail.com', '777', 20),
(36, 'ABANT ADENBOUTIQUE HOTEL&SPA', 'ISTANBUL ', 'DALAMAN', 'Soğanlı, Nilüfer Cd. 89/A, 16190', 'bursaotel@gmail.com', '777', 20),
(38, 'ABANT ADENBOUTIQUE HOTEL&SPA', 'ISTANBUL ', 'DALAMAN', 'Soğanlı, Nilüfer Cd. 89/A, 16190', 'bursaotel@gmail.com', '111111111', 5),
(39, 'ABANT OTEL', 'ISTANBUL ', 'DALAMAN', 'Soğanlı, Nilüfer Cd. 89/A, 16190', 'bursaotel@gmail.com', '111111111', 5);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_hotel_feature`
--

CREATE TABLE `tbl_hotel_feature` (
  `hotel_id` int NOT NULL,
  `feature_id` int NOT NULL,
  `feature_name` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Dumping data for table `tbl_hotel_feature`
--

INSERT INTO `tbl_hotel_feature` (`hotel_id`, `feature_id`, `feature_name`) VALUES
(3, 1, 'Ücretsiz Otopark'),
(3, 3, '7/24 Oda Servisi'),
(3, 4, 'Ücretsiz WiFi'),
(2, 1, 'Ücretsiz Otopark'),
(4, 6, 'Fitness Center'),
(1, 3, '7/24 Oda Servisi'),
(1, 5, 'Yüzme Havuzu'),
(5, 1, 'Ücretsiz Otopark'),
(5, 4, 'Ücretsiz WiFi'),
(5, 6, 'Fitness Center'),
(6, 1, 'Ücretsiz Otopark'),
(6, 5, 'Yüzme Havuzu'),
(17, 4, 'Ücretsiz WiFi'),
(6, 1, 'Ücretsiz Otopark');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_hotel_pension`
--

CREATE TABLE `tbl_hotel_pension` (
  `id` int NOT NULL,
  `hotel_id` int NOT NULL,
  `pension_id` int NOT NULL,
  `pension_name` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Dumping data for table `tbl_hotel_pension`
--

INSERT INTO `tbl_hotel_pension` (`id`, `hotel_id`, `pension_id`, `pension_name`) VALUES
(1, 1, 1, 'Ultra Herşey Dahil'),
(2, 1, 4, 'Tam Pansiyon'),
(3, 3, 1, 'Ultra Herşey Dahil'),
(4, 3, 5, 'Yarım Pansiyon'),
(5, 2, 4, 'Tam Pansiyon'),
(6, 4, 7, 'Alkol Hariç Full credit'),
(7, 5, 1, 'Ultra Herşey Dahil'),
(8, 5, 4, 'Tam Pansiyon'),
(9, 6, 2, 'Herşey Dahil'),
(10, 6, 4, 'Tam Pansiyon'),
(11, 16, 2, 'Herşey Dahil'),
(12, 16, 4, 'Tam Pansiyon'),
(13, 17, 4, 'Tam Pansiyon'),
(14, 17, 2, 'Herşey Dahil');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_hotel_room`
--

CREATE TABLE `tbl_hotel_room` (
  `room_id` int NOT NULL,
  `hotel_id` int NOT NULL,
  `season_id` int NOT NULL,
  `pension_id` int NOT NULL,
  `room_type` varchar(150) NOT NULL,
  `bed_number` int NOT NULL,
  `stock` int NOT NULL,
  `price_child` int NOT NULL,
  `price_adult` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Dumping data for table `tbl_hotel_room`
--

INSERT INTO `tbl_hotel_room` (`room_id`, `hotel_id`, `season_id`, `pension_id`, `room_type`, `bed_number`, `stock`, `price_child`, `price_adult`) VALUES
(4, 1, 1, 1, 'Single', 70, 999999, 200, 500),
(5, 2, 6, 5, 'Double', 70, 999999, 200, 500),
(13, 2, 6, 5, 'sdf', 5, 9, 10, 10),
(15, 6, 9, 2, 'Single', 2, 4, 150, 200),
(16, 6, 9, 2, 'a', 2, 5, 1111, 222);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_pensiontype`
--

CREATE TABLE `tbl_pensiontype` (
  `id` int NOT NULL,
  `pension_name` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Dumping data for table `tbl_pensiontype`
--

INSERT INTO `tbl_pensiontype` (`id`, `pension_name`) VALUES
(1, 'Ultra Herşey Dahil'),
(2, 'Herşey Dahil'),
(3, 'Oda Kahvaltı'),
(4, 'Tam Pansiyon'),
(5, 'Yarım Pansiyon'),
(6, 'Sadece Yatak'),
(7, 'Alkol Hariç Full credit');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_reservation`
--

CREATE TABLE `tbl_reservation` (
  `reservation_id` int NOT NULL,
  `hotel_id` int NOT NULL,
  `room_id` int NOT NULL,
  `customer_name` varchar(150) NOT NULL,
  `customer_tc` varchar(150) NOT NULL,
  `customer_phone` varchar(150) NOT NULL,
  `customer_email` varchar(150) NOT NULL,
  `child_number` int NOT NULL,
  `adult_number` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Dumping data for table `tbl_reservation`
--

INSERT INTO `tbl_reservation` (`reservation_id`, `hotel_id`, `room_id`, `customer_name`, `customer_tc`, `customer_phone`, `customer_email`, `child_number`, `adult_number`) VALUES
(9, 6, 15, 'Rıza', '467894163', '456491', 'sdfjhgsdf', 0, 1),
(14, 2, 13, 'Mehmet', 'aadd', 'asda', 'asd', 5, 1);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_room_property`
--

CREATE TABLE `tbl_room_property` (
  `room_id` int NOT NULL,
  `property_name` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Dumping data for table `tbl_room_property`
--

INSERT INTO `tbl_room_property` (`room_id`, `property_name`) VALUES
(1, 'Televizyon'),
(1, 'Minibar'),
(1, 'Kasa'),
(5, 'Ücretsiz Wifi'),
(3, 'Aynalı'),
(4, 'Wifi');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_season`
--

CREATE TABLE `tbl_season` (
  `season_id` int NOT NULL,
  `hotel_id` int NOT NULL,
  `season_name` varchar(150) NOT NULL,
  `start_date` date NOT NULL,
  `end_date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Dumping data for table `tbl_season`
--

INSERT INTO `tbl_season` (`season_id`, `hotel_id`, `season_name`, `start_date`, `end_date`) VALUES
(1, 1, 'Kış Sezonu', '2023-01-01', '2023-05-31'),
(2, 1, 'Yaz Sezonu', '2023-06-01', '2023-12-01'),
(6, 2, 'Kış Sezonu', '2023-03-01', '2023-06-01'),
(9, 6, 'Yaz Sezonu', '2023-06-01', '2023-09-30');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_user`
--

CREATE TABLE `tbl_user` (
  `id` int NOT NULL,
  `tcNo` varchar(11) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(50) NOT NULL,
  `name` varchar(255) NOT NULL,
  `surname` varchar(255) NOT NULL,
  `usertype` enum('admin','employee','','') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Dumping data for table `tbl_user`
--

INSERT INTO `tbl_user` (`id`, `tcNo`, `username`, `password`, `name`, `surname`, `usertype`) VALUES
(1, '45678912345', 'user1', '4444', 'anil', 'basaran', 'admin'),
(2, '45698715924', 'user2', 'kitty', 'katy', 'Perry', 'employee'),
(3, '1123123', 'maaslı', '5555', 'ahmet', 'uymaz', 'employee');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbl_featuretype`
--
ALTER TABLE `tbl_featuretype`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_hotel`
--
ALTER TABLE `tbl_hotel`
  ADD PRIMARY KEY (`hotel_id`);

--
-- Indexes for table `tbl_hotel_pension`
--
ALTER TABLE `tbl_hotel_pension`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_hotel_room`
--
ALTER TABLE `tbl_hotel_room`
  ADD PRIMARY KEY (`room_id`);

--
-- Indexes for table `tbl_pensiontype`
--
ALTER TABLE `tbl_pensiontype`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_reservation`
--
ALTER TABLE `tbl_reservation`
  ADD PRIMARY KEY (`reservation_id`);

--
-- Indexes for table `tbl_season`
--
ALTER TABLE `tbl_season`
  ADD PRIMARY KEY (`season_id`);

--
-- Indexes for table `tbl_user`
--
ALTER TABLE `tbl_user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbl_featuretype`
--
ALTER TABLE `tbl_featuretype`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `tbl_hotel`
--
ALTER TABLE `tbl_hotel`
  MODIFY `hotel_id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=40;

--
-- AUTO_INCREMENT for table `tbl_hotel_pension`
--
ALTER TABLE `tbl_hotel_pension`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `tbl_hotel_room`
--
ALTER TABLE `tbl_hotel_room`
  MODIFY `room_id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT for table `tbl_pensiontype`
--
ALTER TABLE `tbl_pensiontype`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `tbl_reservation`
--
ALTER TABLE `tbl_reservation`
  MODIFY `reservation_id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `tbl_season`
--
ALTER TABLE `tbl_season`
  MODIFY `season_id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `tbl_user`
--
ALTER TABLE `tbl_user`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
