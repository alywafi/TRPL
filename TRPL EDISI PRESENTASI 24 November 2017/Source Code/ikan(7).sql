-- phpMyAdmin SQL Dump
-- version 4.5.4.1deb2ubuntu2
-- http://www.phpmyadmin.net
--
-- Host: localhost:3306
-- Generation Time: Nov 23, 2017 at 12:01 AM
-- Server version: 10.0.31-MariaDB-0ubuntu0.16.04.2
-- PHP Version: 7.0.22-0ubuntu0.16.04.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ikan`
--

-- --------------------------------------------------------

--
-- Table structure for table `forum`
--

CREATE TABLE `forum` (
  `id_masalah` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `judul` varchar(100) NOT NULL,
  `isi` text NOT NULL,
  `tgl_masalah` date NOT NULL,
  `selesai` tinyint(1) NOT NULL,
  `hasil` varchar(255) NOT NULL DEFAULT 'belum di bahas'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `forum`
--

INSERT INTO `forum` (`id_masalah`, `id_user`, `judul`, `isi`, `tgl_masalah`, `selesai`, `hasil`) VALUES
(1, 1, 'test1', 'loremipsum dolor asdhfjclwhO; HW;EOPHFOP[WESDOU', '2017-11-16', 0, 'haloegovdh'),
(2, 4, 'TEST2', 'DSVXEDDSVCXaa', '2017-11-09', 1, 'haloegovdh'),
(3, 2, 'asd', 'asd', '2017-11-07', 1, 'haloegovdh'),
(4, 2, 'asd', 'asd', '2017-11-07', 1, 'haloegovdh'),
(5, 2, 'aaa', 'ini isinta', '2017-11-16', 0, 'haloegovdh'),
(8, 4, 'jdul', 'asfasfcw es', '2017-11-16', 1, 'ini hasilnya'),
(9, 4, 'asdgcxv', 'aesdgvcx', '2017-11-16', 0, 'haloegovdh'),
(10, 4, 'ini judul', 'ini isi', '2017-11-16', 0, 'haloegovdhasfc'),
(11, 4, '123', '123123sa', '2017-11-19', 0, 'haloegovdhasafsafswzc'),
(12, 4, 'ini judul', 'ini isi', '2017-11-19', 1, 'haloegovdh'),
(13, 1, 'halo', 'afasf', '2017-11-21', 0, 'haloegovdh'),
(14, 3, 'saf', 'asfqa', '2017-11-22', 0, 'haloegovdh'),
(15, 4, 'aa', 'ubah', '2017-11-22', 0, 'hasilasf');

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
(1, 'ember plastik', 70, -50),
(2, 'aaa', 100, 70),
(3, 'garpu', 1000, 100);

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
(11, 4, 1, 10, '2017-11-22', '2020-08-18', 4),
(12, 4, 2, 10, '2017-11-22', '2017-12-22', 1);

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
(4, 'user', 'a', 4);

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
(2, 'Belum Mengembalikan'),
(3, 'peminjaman selesai'),
(4, 'gagal diverifikasi');

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
(9, 1, 1, '2017-10-26', 1),
(10, 4, 10, '2017-11-21', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `forum`
--
ALTER TABLE `forum`
  ADD PRIMARY KEY (`id_masalah`),
  ADD KEY `id_user` (`id_user`);

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
-- AUTO_INCREMENT for table `forum`
--
ALTER TABLE `forum`
  MODIFY `id_masalah` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
--
-- AUTO_INCREMENT for table `inventaris`
--
ALTER TABLE `inventaris`
  MODIFY `id_inventaris` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `jabatan`
--
ALTER TABLE `jabatan`
  MODIFY `id_jabatan` int(2) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `peminjaman_inventaris`
--
ALTER TABLE `peminjaman_inventaris`
  MODIFY `id_peminjaman` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
--
-- AUTO_INCREMENT for table `pengguna`
--
ALTER TABLE `pengguna`
  MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `status_peminjaman`
--
ALTER TABLE `status_peminjaman`
  MODIFY `id_status` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `tebar_bibit`
--
ALTER TABLE `tebar_bibit`
  MODIFY `id_tebar` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `forum`
--
ALTER TABLE `forum`
  ADD CONSTRAINT `forum_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `pengguna` (`id_user`) ON DELETE CASCADE ON UPDATE CASCADE;

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
