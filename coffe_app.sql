-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th5 15, 2021 lúc 05:21 PM
-- Phiên bản máy phục vụ: 10.4.17-MariaDB
-- Phiên bản PHP: 7.3.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `coffe_app`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `datnuoc`
--

CREATE TABLE `datnuoc` (
  `idDatnuoc` int(11) NOT NULL,
  `idSoban` int(11) NOT NULL,
  `idNuoc` int(11) NOT NULL,
  `soluong` int(11) NOT NULL,
  `ngay` date NOT NULL,
  `thanhtoan` int(11) NOT NULL,
  `Xong_Don` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `datnuoc`
--

INSERT INTO `datnuoc` (`idDatnuoc`, `idSoban`, `idNuoc`, `soluong`, `ngay`, `thanhtoan`, `Xong_Don`) VALUES
(1, 5, 1, 2, '2021-05-11', 1, 2),
(2, 5, 4, 2, '2021-05-11', 1, 2),
(6, 1, 1, 2, '2021-05-11', 1, 0),
(9, 1, 1, 3, '2021-05-14', 1, 2),
(10, 5, 4, 1, '2021-05-14', 1, 0),
(11, 4, 2, 3, '2021-05-14', 0, 0),
(12, 2, 1, 2, '2021-05-15', 0, 0),
(14, 1, 2, 2, '2021-05-15', 0, 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `giathanh`
--

CREATE TABLE `giathanh` (
  `idGiaThanh` int(11) NOT NULL,
  `GiaNiemYet` double NOT NULL,
  `idKM` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `giathanh`
--

INSERT INTO `giathanh` (`idGiaThanh`, `GiaNiemYet`, `idKM`) VALUES
(1, 10000, 1),
(2, 15000, 1),
(3, 20000, 1),
(4, 200000, 1),
(5, 900000, 2);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `hoadon`
--

CREATE TABLE `hoadon` (
  `idHoaDon` int(11) NOT NULL,
  `Ngay` date NOT NULL,
  `Dongia` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `hoadon_chitiet`
--

CREATE TABLE `hoadon_chitiet` (
  `idHoadonchitiet` int(11) NOT NULL,
  `idHoaDon` int(11) NOT NULL,
  `idNuoc` int(11) NOT NULL,
  `soluong` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `khuyenmai`
--

CREATE TABLE `khuyenmai` (
  `idKM` int(11) NOT NULL,
  `LoaiKM` varchar(255) NOT NULL,
  `GiatriKM` double NOT NULL,
  `NgayBD` date NOT NULL,
  `NgayKT` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `khuyenmai`
--

INSERT INTO `khuyenmai` (`idKM`, `LoaiKM`, `GiatriKM`, `NgayBD`, `NgayKT`) VALUES
(1, 'Không Khuyến mãi', 0, '0000-00-00', '0000-00-00'),
(2, 'Khuyến mãi khai trương', 20, '0000-00-00', '0000-00-00'),
(3, 'Khuyến mãi cuối tháng', 20, '2021-04-07', '2021-04-16'),
(4, 'khuyễn mãi đầu tháng', 30, '2021-04-07', '2021-04-16');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `loainuoc`
--

CREATE TABLE `loainuoc` (
  `idLoaiNuoc` int(11) NOT NULL,
  `tenLN` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `loainuoc`
--

INSERT INTO `loainuoc` (`idLoaiNuoc`, `tenLN`) VALUES
(1, 'Nước Lon'),
(2, 'Nước đóng chai'),
(3, 'Nước pha chế');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nuoc`
--

CREATE TABLE `nuoc` (
  `idNuoc` int(11) NOT NULL,
  `idLoaiNuoc` int(11) NOT NULL,
  `tenNuoc` varchar(255) NOT NULL,
  `hinhanh` varchar(255) NOT NULL,
  `mota` varchar(255) NOT NULL,
  `idGiaThanh` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `nuoc`
--

INSERT INTO `nuoc` (`idNuoc`, `idLoaiNuoc`, `tenNuoc`, `hinhanh`, `mota`, `idGiaThanh`) VALUES
(1, 1, 'COCA', 'anh1\r\n', 'Nước uống giải khát cocacola', 1),
(2, 3, 'Chanh vắt', 'anh2', 'Nước chanh vắt thơm mát', 3),
(3, 2, 'Nước', 'anh3', 'Nước ép có mùi cam', 3),
(4, 2, 'Nước', 'th.jpg', 'Nước ép ổi có mùi ổi', 2),
(5, 2, 'Nước xoài ép', 'th.jpg', 'Nước ép ổi có mùi xoài', 2);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phanquyen`
--

CREATE TABLE `phanquyen` (
  `idQuyen` int(11) NOT NULL,
  `tenquyen` varchar(255) NOT NULL,
  `chitietquyen` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `phanquyen`
--

INSERT INTO `phanquyen` (`idQuyen`, `tenquyen`, `chitietquyen`) VALUES
(1, 'NV Quầy', 'Nhân viên làm việc trong quầy của quán, pha chế các loại nước'),
(2, 'NV Phục vụ', 'Nhân viên phục vụ có nhiệm vụ nhận đơn và giao tiếp với khách hàng'),
(3, 'NV Thu Ngân', 'Nhân viên thu ngân có nhiệm vụ tính tiền cho khách hàng và in hoá đơn');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `soban`
--

CREATE TABLE `soban` (
  `idSoban` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `soban`
--

INSERT INTO `soban` (`idSoban`) VALUES
(1),
(2),
(3),
(4),
(5),
(6);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `user`
--

CREATE TABLE `user` (
  `idUser` int(11) NOT NULL,
  `idQuyen` int(11) NOT NULL,
  `ho` varchar(50) NOT NULL,
  `ten` varchar(20) NOT NULL,
  `email` varchar(50) NOT NULL,
  `diachi` varchar(255) NOT NULL,
  `gioitinh` int(11) NOT NULL,
  `sodienthoai` varchar(20) NOT NULL,
  `tendangnhap` varchar(20) NOT NULL,
  `matkhau` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `user`
--

INSERT INTO `user` (`idUser`, `idQuyen`, `ho`, `ten`, `email`, `diachi`, `gioitinh`, `sodienthoai`, `tendangnhap`, `matkhau`) VALUES
(1, 2, 'Ngô ', 'Tin', 'ngophitin@gmail.com', 'Đà Nẵng', 0, '1212121212', 'phucvu', '123456'),
(2, 1, 'Mai', 'Nhut', 'maivannhut@gmail.com', 'quangnam', 0, '1212121212', 'quay', '123456'),
(3, 3, 'Van', 'Nguyen', 'daovannguyen@gmail.com', 'daklak', 0, '1212121212', 'thungan', '123456');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `datnuoc`
--
ALTER TABLE `datnuoc`
  ADD PRIMARY KEY (`idDatnuoc`);

--
-- Chỉ mục cho bảng `giathanh`
--
ALTER TABLE `giathanh`
  ADD PRIMARY KEY (`idGiaThanh`),
  ADD KEY `idKM` (`idKM`);

--
-- Chỉ mục cho bảng `hoadon`
--
ALTER TABLE `hoadon`
  ADD PRIMARY KEY (`idHoaDon`);

--
-- Chỉ mục cho bảng `hoadon_chitiet`
--
ALTER TABLE `hoadon_chitiet`
  ADD PRIMARY KEY (`idHoadonchitiet`),
  ADD KEY `idHoaDon` (`idHoaDon`),
  ADD KEY `idNuoc` (`idNuoc`);

--
-- Chỉ mục cho bảng `khuyenmai`
--
ALTER TABLE `khuyenmai`
  ADD PRIMARY KEY (`idKM`);

--
-- Chỉ mục cho bảng `loainuoc`
--
ALTER TABLE `loainuoc`
  ADD PRIMARY KEY (`idLoaiNuoc`);

--
-- Chỉ mục cho bảng `nuoc`
--
ALTER TABLE `nuoc`
  ADD PRIMARY KEY (`idNuoc`),
  ADD KEY `idGiaThanh` (`idGiaThanh`),
  ADD KEY `idLoaiNuoc` (`idLoaiNuoc`);

--
-- Chỉ mục cho bảng `phanquyen`
--
ALTER TABLE `phanquyen`
  ADD PRIMARY KEY (`idQuyen`);

--
-- Chỉ mục cho bảng `soban`
--
ALTER TABLE `soban`
  ADD PRIMARY KEY (`idSoban`);

--
-- Chỉ mục cho bảng `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`idUser`),
  ADD KEY `idQuyen` (`idQuyen`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `datnuoc`
--
ALTER TABLE `datnuoc`
  MODIFY `idDatnuoc` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT cho bảng `giathanh`
--
ALTER TABLE `giathanh`
  MODIFY `idGiaThanh` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT cho bảng `hoadon`
--
ALTER TABLE `hoadon`
  MODIFY `idHoaDon` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT cho bảng `hoadon_chitiet`
--
ALTER TABLE `hoadon_chitiet`
  MODIFY `idHoadonchitiet` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `khuyenmai`
--
ALTER TABLE `khuyenmai`
  MODIFY `idKM` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT cho bảng `loainuoc`
--
ALTER TABLE `loainuoc`
  MODIFY `idLoaiNuoc` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT cho bảng `nuoc`
--
ALTER TABLE `nuoc`
  MODIFY `idNuoc` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT cho bảng `phanquyen`
--
ALTER TABLE `phanquyen`
  MODIFY `idQuyen` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT cho bảng `soban`
--
ALTER TABLE `soban`
  MODIFY `idSoban` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT cho bảng `user`
--
ALTER TABLE `user`
  MODIFY `idUser` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `giathanh`
--
ALTER TABLE `giathanh`
  ADD CONSTRAINT `giathanh_ibfk_1` FOREIGN KEY (`idKM`) REFERENCES `khuyenmai` (`idKM`);

--
-- Các ràng buộc cho bảng `hoadon_chitiet`
--
ALTER TABLE `hoadon_chitiet`
  ADD CONSTRAINT `hoadon_chitiet_ibfk_1` FOREIGN KEY (`idHoaDon`) REFERENCES `hoadon` (`idHoaDon`),
  ADD CONSTRAINT `hoadon_chitiet_ibfk_2` FOREIGN KEY (`idNuoc`) REFERENCES `nuoc` (`idNuoc`);

--
-- Các ràng buộc cho bảng `nuoc`
--
ALTER TABLE `nuoc`
  ADD CONSTRAINT `nuoc_ibfk_1` FOREIGN KEY (`idGiaThanh`) REFERENCES `giathanh` (`idGiaThanh`),
  ADD CONSTRAINT `nuoc_ibfk_2` FOREIGN KEY (`idLoaiNuoc`) REFERENCES `loainuoc` (`idLoaiNuoc`);

--
-- Các ràng buộc cho bảng `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `user_ibfk_1` FOREIGN KEY (`idQuyen`) REFERENCES `phanquyen` (`idQuyen`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
