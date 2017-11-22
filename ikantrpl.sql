-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Nov 02, 2017 at 07:54 AM
-- Server version: 10.1.16-MariaDB
-- PHP Version: 7.0.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ikantrpl`
--

-- --------------------------------------------------------

--
-- Table structure for table `inventaris`
--

CREATE TABLE `inventaris` (
  `id_inventaris` int(11) NOT NULL,
  `nama_barang` varchar(20) NOT NULL,
  `Stok` int(11) NOT NULL,
  `Stok_Ready` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `inventaris`
--

INSERT INTO `inventaris` (`id_inventaris`, `nama_barang`, `Stok`, `Stok_Ready`) VALUES
(1, 'ember plastik', 70, 70);

-- --------------------------------------------------------

--
-- Table structure for table `jabatan`
--

CREATE TABLE `jabatan` (
  `id_jabatan` int(2) NOT NULL,
  `jabatan` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `jabatan`
--

INSERT INTO `jabatan` (`id_jabatan`, `jabatan`) VALUES
(1, 'admin'),
(2, 'ketuaumum'),
(3, 'ketuasub'),
(4, 'anggota');

-- --------------------------------------------------------

--
-- Table structure for table `peminjaman_inventaris`
--

CREATE TABLE `peminjaman_inventaris` (
  `id_peminjaman` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `id_inventaris` int(11) NOT NULL,
  `jumlah` int(11) NOT NULL,
  `tanggal_pinjam` date NOT NULL,
  `tanggal_kembali` date NOT NULL,
  `id_status` int(5) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `peminjaman_inventaris`
--

INSERT INTO `peminjaman_inventaris` (`id_peminjaman`, `id_user`, `id_inventaris`, `jumlah`, `tanggal_pinjam`, `tanggal_kembali`, `id_status`) VALUES
(9, 4, 1, 100, '2017-11-02', '2017-11-24', 4),
(10, 4, 1, 999, '2017-11-02', '2017-11-24', 3);

-- --------------------------------------------------------

--
-- Table structure for table `pengguna`
--

CREATE TABLE `pengguna` (
  `id_user` int(11) NOT NULL,
  `user` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `id_jabatan` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pengguna`
--

INSERT INTO `pengguna` (`id_user`, `user`, `password`, `id_jabatan`) VALUES
(1, 'admin', 'a', 1),
(2, 'ketuaumum', 'a', 2),
(3, 'ketuasub', 'a', 3),
(4, 'user', 'da', 4);

-- --------------------------------------------------------

--
-- Table structure for table `status_peminjaman`
--

CREATE TABLE `status_peminjaman` (
  `id_status` int(11) NOT NULL,
  `status` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `status_peminjaman`
--

INSERT INTO `status_peminjaman` (`id_status`, `status`) VALUES
(1, 'Belum terverifikasi'),
(2, 'Belum Mengembalikan dan membay'),
(3, 'Belum Membayar Inventaris'),
(4, 'Belum Mengembalikan Inventaris'),
(5, 'Lunas dan Telah mengembalikan ');

-- --------------------------------------------------------

--
-- Table structure for table `tebar_bibit`
--

CREATE TABLE `tebar_bibit` (
  `id_tebar` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `jumlah` int(11) NOT NULL,
  `tanggal` date NOT NULL,
  `kolam` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tebar_bibit`
--

INSERT INTO `tebar_bibit` (`id_tebar`, `id_user`, `jumlah`, `tanggal`, `kolam`) VALUES
(1, 4, 1, '2017-10-03', 10),
(4, 2, 1, '2017-10-25', 10),
(5, 1, 1, '2017-10-25', 10),
(6, 1, 10000, '2017-10-25', 10),
(7, 1, 1, '2017-10-25', 10),
(8, 1, 123000, '2017-10-25', 10),
(9, 1, 1, '2017-10-26', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `inventaris`
--
ALTER TABLE `inventaris`
  ADD PRIMARY KEY (`id_inventaris`);

--
-- Indexes for table `jabatan`
--
ALTER TABLE `jabatan`
  ADD PRIMARY KEY (`id_jabatan`);

--
-- Indexes for table `peminjaman_inventaris`
--
ALTER TABLE `peminjaman_inventaris`
  ADD PRIMARY KEY (`id_peminjaman`),
  ADD KEY `id_user` (`id_user`),
  ADD KEY `id_inventaris` (`id_inventaris`),
  ADD KEY `id_status_2` (`id_status`) USING BTREE;

--
-- Indexes for table `pengguna`
--
ALTER TABLE `pengguna`
  ADD PRIMARY KEY (`id_user`),
  ADD KEY `jabatan` (`id_jabatan`),
  ADD KEY `id_jabatan` (`id_jabatan`);

--
-- Indexes for table `status_peminjaman`
--
ALTER TABLE `status_peminjaman`
  ADD PRIMARY KEY (`id_status`);

--
-- Indexes for table `tebar_bibit`
--
ALTER TABLE `tebar_bibit`
  ADD PRIMARY KEY (`id_tebar`),
  ADD KEY `id_user` (`id_user`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `inventaris`
--
ALTER TABLE `inventaris`
  MODIFY `id_inventaris` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `jabatan`
--
ALTER TABLE `jabatan`
  MODIFY `id_jabatan` int(2) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `peminjaman_inventaris`
--
ALTER TABLE `peminjaman_inventaris`
  MODIFY `id_peminjaman` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT for table `pengguna`
--
ALTER TABLE `pengguna`
  MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `status_peminjaman`
--
ALTER TABLE `status_peminjaman`
  MODIFY `id_status` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `tebar_bibit`
--
ALTER TABLE `tebar_bibit`
  MODIFY `id_tebar` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `peminjaman_inventaris`
--
ALTER TABLE `peminjaman_inventaris`
  ADD CONSTRAINT `peminjaman_inventaris_ibfk_1` FOREIGN KEY (`id_inventaris`) REFERENCES `inventaris` (`id_inventaris`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `peminjaman_inventaris_ibfk_2` FOREIGN KEY (`id_user`) REFERENCES `pengguna` (`id_user`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `peminjaman_inventaris_ibfk_3` FOREIGN KEY (`id_status`) REFERENCES `status_peminjaman` (`id_status`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
