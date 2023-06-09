USE master
GO
IF EXISTS (SELECT name FROM sys.databases WHERE name = 'EduSys') DROP DATABASE EduSys
GO
CREATE DATABASE [EduSys]
GO
USE [EduSys]
GO
/****** Object:  Table [dbo].[ChuyenDe]    Script Date: 6/6/2022 2:25:33 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChuyenDe](
	[MaCD] [nchar](5) NOT NULL,
	[TenCD] [nvarchar](50) NOT NULL,
	[HocPhi] [float] NOT NULL,
	[ThoiLuong] [int] NOT NULL,
	[Hinh] [nvarchar](50) NOT NULL,
	[MoTa] [nvarchar](255) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[MaCD] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HocVien]    Script Date: 6/6/2022 2:25:33 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HocVien](
	[MaHV] [int] IDENTITY(1,1) NOT NULL,
	[MaKH] [int] NOT NULL,
	[Diem] [float] NULL,
	[MaNH] [nchar](7) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[MaHV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KhoaHoc]    Script Date: 6/6/2022 2:25:33 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhoaHoc](
	[MaKH] [int] IDENTITY(1,1) NOT NULL,
	[MaCD] [nchar](5) NOT NULL,
	[HocPhi] [float] NOT NULL,
	[ThoiLuong] [int] NOT NULL,
	[NgayKG] [date] NOT NULL,
	[GhiChu] [nvarchar](255) NULL,
	[MaNV] [nvarchar](20) NOT NULL,
	[NgayTao] [date] NULL,
PRIMARY KEY CLUSTERED 
(
	[MaKH] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NguoiHoc]    Script Date: 6/6/2022 2:25:33 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NguoiHoc](
	[MaNH] [nchar](7) NOT NULL,
	[HoTen] [nvarchar](50) NOT NULL,
	[NgaySinh] [date] NOT NULL,
	[GioiTinh] [bit] NULL,
	[DienThoai] [nvarchar](24) NOT NULL,
	[Email] [nvarchar](50) NOT NULL,
	[GhiChu] [nvarchar](255) NULL,
	[MaNV] [nvarchar](20) NOT NULL,
	[NgayDK] [date] NULL,
PRIMARY KEY CLUSTERED 
(
	[MaNH] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhanVien]    Script Date: 6/6/2022 2:25:33 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhanVien](
	[MaNV] [nvarchar](20) NOT NULL,
	[MatKhau] [nvarchar](50) NOT NULL,
	[HoTen] [nvarchar](50) NOT NULL,
	[EmailNV] [nvarchar](50) NOT NULL,
	[VaiTro] [bit] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[MaNV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[HocVien] ADD  DEFAULT ((-1.0)) FOR [Diem]
GO
ALTER TABLE [dbo].[KhoaHoc] ADD  DEFAULT (getdate()) FOR [NgayTao]
GO
ALTER TABLE [dbo].[NguoiHoc] ADD  DEFAULT ((1)) FOR [GioiTinh]
GO
ALTER TABLE [dbo].[NguoiHoc] ADD  DEFAULT (getdate()) FOR [NgayDK]
GO
ALTER TABLE [dbo].[NhanVien] ADD  DEFAULT ((0)) FOR [VaiTro]
GO
ALTER TABLE [dbo].[HocVien]  WITH CHECK ADD FOREIGN KEY([MaKH])
REFERENCES [dbo].[KhoaHoc] ([MaKH])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[HocVien]  WITH CHECK ADD FOREIGN KEY([MaNH])
REFERENCES [dbo].[NguoiHoc] ([MaNH])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[KhoaHoc]  WITH CHECK ADD FOREIGN KEY([MaCD])
REFERENCES [dbo].[ChuyenDe] ([MaCD])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[KhoaHoc]  WITH CHECK ADD FOREIGN KEY([MaNV])
REFERENCES [dbo].[NhanVien] ([MaNV])
GO
ALTER TABLE [dbo].[KhoaHoc]  WITH CHECK ADD FOREIGN KEY([MaNV])
REFERENCES [dbo].[NhanVien] ([MaNV])
GO
ALTER TABLE [dbo].[NguoiHoc]  WITH CHECK ADD FOREIGN KEY([MaNV])
REFERENCES [dbo].[NhanVien] ([MaNV])
GO
ALTER TABLE [dbo].[NguoiHoc]  WITH CHECK ADD FOREIGN KEY([MaNV])
REFERENCES [dbo].[NhanVien] ([MaNV])
GO
/****** Object:  StoredProcedure [dbo].[sp_BangDiem]    Script Date: 6/6/2022 2:25:33 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO


-- TẠO CÁC PROCEDURE TRONG TRUY VẤN DỮ LIỆU
-- Thống kê bảng điểm
Create proc [dbo].[sp_BangDiem](@MaKH int) as begin
	select b.MaNH, b.HoTen, a.Diem
	from HocVien a join NguoiHoc b on b.MaNH = a.MaNH
	where a.MaKH = @MaKH
	order by a.Diem desc
end
GO
/****** Object:  StoredProcedure [dbo].[sp_DiemChuyenDe]    Script Date: 6/6/2022 2:25:33 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

-- Điểm chuyên đề
Create proc [dbo].[sp_DiemChuyenDe] as begin
	Select 
		a.TenCD chuyenDe,
		COUNT(a.TenCD) soHV, 
		Min(c.Diem) thapNhat, 
		Max(c.Diem) caoNhat, 
		ROUND(AVG(c.Diem),2) trungBinh
	from ChuyenDe a
		join KhoaHoc b on b.MaCD = a.MaCD
		join HocVien c on c.MaKH = b.MaKH
	group by a.TenCD
end
GO
/****** Object:  StoredProcedure [dbo].[sp_DoanhThu]    Script Date: 6/6/2022 2:25:33 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

-- Doanh thu chuyên đề theo năm
Create proc [dbo].[sp_DoanhThu](@year int) as begin
	Select 
		a.TenCD chuyenDe,
		COUNT(distinct b.MaKH) soKH,
		COUNT(a.TenCD) soHV,  
		SUM(b.HocPhi) doanhThu, 
		MIN(b.HocPhi) thapNhat,
		MAX(b.HocPhi) caoNhat,
		ROUND(AVG(b.HocPhi),2) trungBinh
	from ChuyenDe a
		join KhoaHoc b on b.MaCD = a.MaCD
		join HocVien c on c.MaKH = b.MaKH
	where YEAR(NgayKG) = @year group by a.TenCD
end
GO
/****** Object:  StoredProcedure [dbo].[sp_LuongNguoiHoc]    Script Date: 6/6/2022 2:25:33 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

-- Thống kê người học
Create proc [dbo].[sp_LuongNguoiHoc] as begin
	Select 
		YEAR(NgayDK) nam, 
		COUNT(NgayDK) soLuong, 
		MIN(NgayDK) dauTien, 
		MAX(NgayDK) cuoiCung
	from NguoiHoc
	group by YEAR(NgayDK)
end
GO
