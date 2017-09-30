-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Sep 30, 2017 at 06:19 AM
-- Server version: 10.1.16-MariaDB
-- PHP Version: 7.0.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pelelangan`
--

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `customer_id` varchar(6) NOT NULL,
  `Nama` varchar(20) NOT NULL,
  `Alamat` varchar(20) NOT NULL,
  `NoHP` varchar(13) NOT NULL,
  `Password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`customer_id`, `Nama`, `Alamat`, `NoHP`, `Password`) VALUES
('CUS1', 'customer', 'Situbondo', '0812372632', 'customer'),
('CUS2', 'Luky', 'Jember', '0823427346', 'customer'),
('CUS3', 'iqbal', 'awar awar', '0872634', 'apinx'),
('CUS4', 'iqbal', 'awar awar', '0872634', 'apinx');

-- --------------------------------------------------------

--
-- Table structure for table `datailstok`
--

CREATE TABLE `datailstok` (
  `Stok_id` varchar(6) NOT NULL,
  `jenisikan_ID` varchar(6) NOT NULL,
  `Quantity` int(15) NOT NULL,
  `HargaBeli` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `datailstok`
--

INSERT INTO `datailstok` (`Stok_id`, `jenisikan_ID`, `Quantity`, `HargaBeli`) VALUES
('STK2', 'JIK2', 1, 50000),
('STK2', 'JIK3', 2, 5000),
('STK2', 'JIK4', 3, 15000),
('STK3', 'JIK3', 4, 5000);

-- --------------------------------------------------------

--
-- Table structure for table `detailtransaksi`
--

CREATE TABLE `detailtransaksi` (
  `transaksi_ID` varchar(6) NOT NULL,
  `jenisikan_id` varchar(6) NOT NULL,
  `HargaBeli` int(15) NOT NULL,
  `Quantity` int(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `detailtransaksi`
--

INSERT INTO `detailtransaksi` (`transaksi_ID`, `jenisikan_id`, `HargaBeli`, `Quantity`) VALUES
('TRA1', 'JIK3', 7000, 4),
('TRA2', 'JIK4', 17000, 4),
('TRA1', 'JIK3', 7000, 4),
('TRA3', 'JIK4', 17000, 5),
('TRA3', 'JIK2', 52000, 3),
('TRA3', 'JIK3', 7000, 3),
('TRA4', 'JIK6', 32000, 4),
('TRA4', 'JIK2', 52000, 1);

-- --------------------------------------------------------

--
-- Table structure for table `jenisikan`
--

CREATE TABLE `jenisikan` (
  `jenisikan_id` varchar(6) NOT NULL,
  `Nama` varchar(15) NOT NULL,
  `MaksHargaBeli` float NOT NULL,
  `Stok` int(12) DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `jenisikan`
--

INSERT INTO `jenisikan` (`jenisikan_id`, `Nama`, `MaksHargaBeli`, `Stok`) VALUES
('JIK2', 'kerapu macan', 50000, 30),
('JIK3', 'Klemar', 5000, 144),
('JIK4', 'Tempe', 15000, 48),
('JIK5', 'Kecomang', 15000, 51),
('JIK6', 'Barracuda', 30000, 56);

-- --------------------------------------------------------

--
-- Table structure for table `karyawan`
--

CREATE TABLE `karyawan` (
  `Karyawan_ID` varchar(6) NOT NULL,
  `Nama` varchar(20) NOT NULL,
  `Alamat` varchar(20) NOT NULL,
  `Jabatan` varchar(13) NOT NULL,
  `NoHP` varchar(13) NOT NULL,
  `Password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `karyawan`
--

INSERT INTO `karyawan` (`Karyawan_ID`, `Nama`, `Alamat`, `Jabatan`, `NoHP`, `Password`) VALUES
('GDG1', 'gudang', 'gudangjuga', 'PGudang', '08123122', 'gudang'),
('KSR1', 'pengg', 'Jengkar', 'Kasir', '087654321234', 'kasir'),
('KSR2', 'bahri', 'BWS', 'Kasir', '087876', 'kasir'),
('KSR3', 'Firman', 'JBR', 'Kasir', '085', 'kasir'),
('KSR4', 'kasir', 'jember', 'Kasir', '08', 'kasir'),
('KSR5', 'maulita', 'hatimu', 'Kasir', '3948534', 'wkwkwk'),
('MNG1', 'wafi', 'Situbondo', 'Manager', '082237172630', 'manager');

-- --------------------------------------------------------

--
-- Table structure for table `stok`
--

CREATE TABLE `stok` (
  `Karyawan_ID` varchar(6) NOT NULL,
  `supplier_ID` varchar(6) NOT NULL,
  `Stok_ID` varchar(6) NOT NULL,
  `Date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `stok`
--

INSERT INTO `stok` (`Karyawan_ID`, `supplier_ID`, `Stok_ID`, `Date`) VALUES
('GDG1', 'SPL1', 'STK1', '2017-06-29'),
('GDG1', 'SPL1', 'STK2', '2017-02-06'),
('GDG1', 'SPL1', 'STK3', '2017-02-06');

-- --------------------------------------------------------

--
-- Table structure for table `supplier`
--

CREATE TABLE `supplier` (
  `Supplier_id` varchar(6) NOT NULL,
  `Nama` varchar(20) NOT NULL,
  `Alamat` varchar(20) NOT NULL,
  `NoHP` varchar(13) NOT NULL,
  `QualityAverage` int(12) DEFAULT '50'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `supplier`
--

INSERT INTO `supplier` (`Supplier_id`, `Nama`, `Alamat`, `NoHP`, `QualityAverage`) VALUES
('SPL1', 'Fahmi', 'Arjasa', '08654823647', 0),
('SPL2', 'feri', 'jengkar', '082131231', 52),
('SPL3', 'Faisal', 'BWS', '9372234234', 66),
('SPL4', 'amir', 'Bondowoso', '083746328', 50),
('SPL5', 'sup', 'situbondo', '239874823749', 50);

-- --------------------------------------------------------

--
-- Table structure for table `transaksi`
--

CREATE TABLE `transaksi` (
  `transaksi_ID` varchar(6) NOT NULL,
  `customer_ID` varchar(6) NOT NULL,
  `karyawan_ID` varchar(6) NOT NULL,
  `Date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `transaksi`
--

INSERT INTO `transaksi` (`transaksi_ID`, `customer_ID`, `karyawan_ID`, `Date`) VALUES
('TRA1', 'CUS1', 'KSR1', '2017-01-06'),
('TRA2', 'CUS2', 'KSR3', '2017-03-06'),
('TRA3', 'CUS2', 'KSR3', '2017-03-06'),
('TRA4', 'CUS2', 'KSR4', NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`customer_id`);

--
-- Indexes for table `datailstok`
--
ALTER TABLE `datailstok`
  ADD UNIQUE KEY `Stok_id_2` (`Stok_id`,`jenisikan_ID`),
  ADD KEY `jenisikan_ID` (`jenisikan_ID`),
  ADD KEY `Stok_id` (`Stok_id`);

--
-- Indexes for table `detailtransaksi`
--
ALTER TABLE `detailtransaksi`
  ADD KEY `transaksi_ID` (`transaksi_ID`),
  ADD KEY `stok_ID` (`jenisikan_id`),
  ADD KEY `transaksi_ID_3` (`transaksi_ID`),
  ADD KEY `transaksi_ID_6` (`transaksi_ID`,`jenisikan_id`),
  ADD KEY `transaksi_ID_7` (`transaksi_ID`);

--
-- Indexes for table `jenisikan`
--
ALTER TABLE `jenisikan`
  ADD PRIMARY KEY (`jenisikan_id`);

--
-- Indexes for table `karyawan`
--
ALTER TABLE `karyawan`
  ADD PRIMARY KEY (`Karyawan_ID`);

--
-- Indexes for table `stok`
--
ALTER TABLE `stok`
  ADD PRIMARY KEY (`Stok_ID`),
  ADD KEY `Karyawan_ID` (`Karyawan_ID`),
  ADD KEY `supplier_ID` (`supplier_ID`);

--
-- Indexes for table `supplier`
--
ALTER TABLE `supplier`
  ADD PRIMARY KEY (`Supplier_id`);

--
-- Indexes for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD PRIMARY KEY (`transaksi_ID`),
  ADD KEY `customer_ID` (`customer_ID`),
  ADD KEY `karyawan_ID` (`karyawan_ID`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `datailstok`
--
ALTER TABLE `datailstok`
  ADD CONSTRAINT `datailstok_ibfk_1` FOREIGN KEY (`jenisikan_ID`) REFERENCES `jenisikan` (`jenisikan_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `datailstok_ibfk_2` FOREIGN KEY (`Stok_id`) REFERENCES `stok` (`Stok_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `detailtransaksi`
--
ALTER TABLE `detailtransaksi`
  ADD CONSTRAINT `detailtransaksi_ibfk_2` FOREIGN KEY (`transaksi_ID`) REFERENCES `transaksi` (`transaksi_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `detailtransaksi_ibfk_3` FOREIGN KEY (`jenisikan_id`) REFERENCES `jenisikan` (`jenisikan_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD CONSTRAINT `transaksi_ibfk_3` FOREIGN KEY (`karyawan_ID`) REFERENCES `karyawan` (`Karyawan_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `transaksi_ibfk_4` FOREIGN KEY (`customer_ID`) REFERENCES `customer` (`customer_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
