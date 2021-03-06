USE [master]
GO
/****** Object:  Database [SIM_TR]    Script Date: 03/12/2018 02:04:23 ******/
CREATE DATABASE [SIM_TR] ON  PRIMARY 
( NAME = N'SIM_TR', FILENAME = N'C:\Program Files (x86)\Microsoft SQL Server\MSSQL10_50.X230B_SRV\MSSQL\DATA\SIM_TR.mdf' , SIZE = 4096KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'SIM_TR_log', FILENAME = N'C:\Program Files (x86)\Microsoft SQL Server\MSSQL10_50.X230B_SRV\MSSQL\DATA\SIM_TR_log.ldf' , SIZE = 20096KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [SIM_TR] SET COMPATIBILITY_LEVEL = 100
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [SIM_TR].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [SIM_TR] SET ANSI_NULL_DEFAULT OFF
GO
ALTER DATABASE [SIM_TR] SET ANSI_NULLS OFF
GO
ALTER DATABASE [SIM_TR] SET ANSI_PADDING OFF
GO
ALTER DATABASE [SIM_TR] SET ANSI_WARNINGS OFF
GO
ALTER DATABASE [SIM_TR] SET ARITHABORT OFF
GO
ALTER DATABASE [SIM_TR] SET AUTO_CLOSE OFF
GO
ALTER DATABASE [SIM_TR] SET AUTO_CREATE_STATISTICS ON
GO
ALTER DATABASE [SIM_TR] SET AUTO_SHRINK OFF
GO
ALTER DATABASE [SIM_TR] SET AUTO_UPDATE_STATISTICS ON
GO
ALTER DATABASE [SIM_TR] SET CURSOR_CLOSE_ON_COMMIT OFF
GO
ALTER DATABASE [SIM_TR] SET CURSOR_DEFAULT  GLOBAL
GO
ALTER DATABASE [SIM_TR] SET CONCAT_NULL_YIELDS_NULL OFF
GO
ALTER DATABASE [SIM_TR] SET NUMERIC_ROUNDABORT OFF
GO
ALTER DATABASE [SIM_TR] SET QUOTED_IDENTIFIER OFF
GO
ALTER DATABASE [SIM_TR] SET RECURSIVE_TRIGGERS OFF
GO
ALTER DATABASE [SIM_TR] SET  DISABLE_BROKER
GO
ALTER DATABASE [SIM_TR] SET AUTO_UPDATE_STATISTICS_ASYNC OFF
GO
ALTER DATABASE [SIM_TR] SET DATE_CORRELATION_OPTIMIZATION OFF
GO
ALTER DATABASE [SIM_TR] SET TRUSTWORTHY OFF
GO
ALTER DATABASE [SIM_TR] SET ALLOW_SNAPSHOT_ISOLATION OFF
GO
ALTER DATABASE [SIM_TR] SET PARAMETERIZATION SIMPLE
GO
ALTER DATABASE [SIM_TR] SET READ_COMMITTED_SNAPSHOT OFF
GO
ALTER DATABASE [SIM_TR] SET HONOR_BROKER_PRIORITY OFF
GO
ALTER DATABASE [SIM_TR] SET  READ_WRITE
GO
ALTER DATABASE [SIM_TR] SET RECOVERY SIMPLE
GO
ALTER DATABASE [SIM_TR] SET  MULTI_USER
GO
ALTER DATABASE [SIM_TR] SET PAGE_VERIFY CHECKSUM
GO
ALTER DATABASE [SIM_TR] SET DB_CHAINING OFF
GO
USE [SIM_TR]
GO
/****** Object:  Table [dbo].[Afdeling]    Script Date: 03/12/2018 02:04:24 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Afdeling](
	[IdAfd] [char](2) NOT NULL,
	[IdRayon] [char](2) NOT NULL,
	[Afdeling] [nvarchar](3) NULL,
	[BatasRit] [int] NOT NULL,
	[NamaAsisten] [varchar](40) NULL
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[TBL_VARIETAS]    Script Date: 03/12/2018 02:04:24 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[TBL_VARIETAS](
	[ID_VARIETAS] [int] IDENTITY(1,1) NOT NULL,
	[NAMA_LAB] [varchar](50) NULL,
	[NAMA_RILIS] [varchar](50) NULL,
	[DASAR_HUKUM] [varchar](250) NULL,
	[SIFAT_KEMASAKAN] [varchar](50) NULL,
 CONSTRAINT [PK_TBL_VARIETAS] PRIMARY KEY CLUSTERED 
(
	[ID_VARIETAS] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[TBL_SISTEM]    Script Date: 03/12/2018 02:04:24 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TBL_SISTEM](
	[TAHUN_GILING] [int] NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TBL_RDKK]    Script Date: 03/12/2018 02:04:24 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[TBL_RDKK](
	[ID_RDKK] [int] IDENTITY(1,1) NOT NULL,
	[NO_RDKK] [varchar](40) NOT NULL,
	[TGL_RDKK] [date] NULL,
	[ID_KELOMPOK] [varchar](10) NOT NULL,
 CONSTRAINT [PK_TBL_RDKK] PRIMARY KEY CLUSTERED 
(
	[ID_RDKK] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[TBL_KECAMATAN]    Script Date: 03/12/2018 02:04:24 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[TBL_KECAMATAN](
	[ID_KECAMATAN] [int] IDENTITY(1,1) NOT NULL,
	[NAMA_KECAMATAN] [varchar](100) NULL,
 CONSTRAINT [PK_TBL_KECAMATAN] PRIMARY KEY CLUSTERED 
(
	[ID_KECAMATAN] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[TBL_DESA]    Script Date: 03/12/2018 02:04:24 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[TBL_DESA](
	[ID_DESA] [int] IDENTITY(1,1) NOT NULL,
	[ID_KECAMATAN] [int] NULL,
	[NAMA_DESA] [varchar](100) NULL,
 CONSTRAINT [PK_TBL_DESA] PRIMARY KEY CLUSTERED 
(
	[ID_DESA] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[TBL_COUNTER]    Script Date: 03/12/2018 02:04:24 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[TBL_COUNTER](
	[IDAFD] [varchar](2) NULL,
	[COUNTER_KELOMPOK] [int] NULL,
	[COUNTER_PETANI] [int] NULL
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Rayon]    Script Date: 03/12/2018 02:04:24 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Rayon](
	[IdRayon] [char](2) NOT NULL,
	[RAYON] [nvarchar](3) NULL,
	[TSTR] [varchar](1) NULL
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[KelompokTaniH]    Script Date: 03/12/2018 02:04:24 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[KelompokTaniH](
	[IdKelompok] [char](5) NOT NULL,
	[Tahun] [int] NULL,
	[NamaKelompok] [varchar](40) NULL,
	[NoKontrak] [varchar](20) NULL,
	[JumlahPetani] [int] NULL,
	[IdAfd] [char](2) NULL,
	[ID_DESA] [int] NULL,
	[Verifikasi] [varchar](1) NULL,
	[NoKtp] [varchar](16) NULL,
	[NoRdkk] [varchar](40) NULL,
	[TglRdkk] [date] NULL
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[KelompokTaniD]    Script Date: 03/12/2018 02:04:24 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[KelompokTaniD](
	[IdPetani] [char](9) NOT NULL,
	[Tahun] [int] NULL,
	[IdKelompok] [char](5) NOT NULL,
	[NamaPetani] [varchar](40) NULL,
	[MasaTanam] [varchar](15) NULL,
	[Luas] [float] NULL,
	[JenisTebu] [varchar](15) NULL
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  StoredProcedure [dbo].[INSERT_NEW_RDKK]    Script Date: 03/12/2018 02:04:25 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		Bayu Anandavi Muhardika
-- Create date: 04-03-2018
-- Description:	Insert data RDKK baru
-- =============================================
CREATE PROCEDURE [dbo].[INSERT_NEW_RDKK] 
	-- Add the parameters for the stored procedure here
	@ID_KELOMPOK VARCHAR(10),
	@NO_RDKK VARCHAR(40),
	@TGL_RDKK DATE
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    -- Insert statements for procedure here
	INSERT INTO TBL_RDKK(NO_RDKK,TGL_RDKK,ID_KELOMPOK)
	VALUES(@NO_RDKK,@TGL_RDKK,@ID_KELOMPOK)
END
GO
/****** Object:  StoredProcedure [dbo].[INSERT_KELOMPOKTANIH]    Script Date: 03/12/2018 02:04:25 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		BAYU ANANDAVI MUHARDIKA
-- Create date: 09-01-2018
-- Description:	INSERT DATA ON KELOMPOKTANIH TABLE
-- =============================================
CREATE PROCEDURE [dbo].[INSERT_KELOMPOKTANIH] 
	-- Add the parameters for the stored procedure here
	@IDKELOMPOK AS VARCHAR(5),
	@NAMA_KELOMPOK AS VARCHAR(40),
	@NOKONTRAK AS VARCHAR(15),
	@IDAFD AS VARCHAR(2),
	@TAHUN AS INT,
	@ID_DESA AS INT,
	@NOKTP AS VARCHAR(16),
	@NORDKK AS VARCHAR(40),
	@TGLRDKK AS DATE
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    -- Insert statements for procedure here
	INSERT INTO KelompokTaniH(IdKelompok,Tahun,NamaKelompok,NOKONTRAK,IdAfd,ID_DESA,Verifikasi,NOKTP,NORDKK,TGLRDKK)
	VALUES (@IDKELOMPOK,@TAHUN,@NAMA_KELOMPOK,@NOKONTRAK,@IDAFD,@ID_DESA,'N',@NOKTP,@NORDKK,@TGLRDKK)
	
END
GO
/****** Object:  StoredProcedure [dbo].[INSERT_KELOMPOKTANID]    Script Date: 03/12/2018 02:04:25 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		Bayu Anandavi Muhardika
-- Create date: 02-03-2018
-- Description:	Tambah data petani baru
-- =============================================
CREATE PROCEDURE [dbo].[INSERT_KELOMPOKTANID]
	-- Add the parameters for the stored procedure here
	@IDPETANI VARCHAR(9),
	@TAHUN INT,
	@IDKELOMPOK VARCHAR(5),
	@NAMAPETANI VARCHAR(40),
	@MASATANAM VARCHAR(3),
	@LUAS FLOAT,
	@JENISTEBU VARCHAR(3)
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    -- Insert statements for procedure here
	INSERT INTO KelompokTaniD(IdPetani,Tahun,IdKelompok,NamaPetani,MasaTanam,Luas,JenisTebu)
	VALUES (@IDPETANI,@TAHUN,@IDKELOMPOK,@NAMAPETANI,@MASATANAM,@LUAS,@JENISTEBU)
END
GO
/****** Object:  StoredProcedure [dbo].[INSERT_AFDELING]    Script Date: 03/12/2018 02:04:25 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		BAYU ANANDAVI MUHARDIKA
-- Create date: 11-01-2018
-- Description:	INSERT DATA ON AFDELING TABLE
-- =============================================
CREATE PROCEDURE [dbo].[INSERT_AFDELING] 
	@IDAFD VARCHAR(2),
	@IDRAYON VARCHAR(2),
	@AFDELING VARCHAR(3),
	@BATASRIT INT,
	@NAMAASISTEN VARCHAR(40)
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    -- Insert statements for procedure here
	INSERT INTO Afdeling (IdAfd,IdRayon,Afdeling,BatasRit,NamaAsisten)
	VALUES (@IDAFD,@IDRAYON,@AFDELING,@BATASRIT,@NAMAASISTEN)
END
GO
/****** Object:  StoredProcedure [dbo].[GET_VARIETAS_BY_IDVARIETAS]    Script Date: 03/12/2018 02:04:25 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		Bayu Anandavi Muhardika
-- Create date: 27-02-2018
-- Description:	Get List of Varietas by ID Varietas
-- =============================================
CREATE PROCEDURE [dbo].[GET_VARIETAS_BY_IDVARIETAS]
	-- Add the parameters for the stored procedure here
	@IDVARIETAS int
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    -- Insert statements for procedure here
	SELECT VT.ID_VARIETAS AS ID_VARIETAS, VT.NAMA_LAB AS NAMA_LAB, VT.NAMA_RILIS AS NAMA_RILIS, 
		VT.DASAR_HUKUM AS DASAR_HUKUM, VT.SIFAT_KEMASAKAN AS SIFAT_KEMASAKAN
	FROM TBL_VARIETAS VT
	WHERE VT.ID_VARIETAS = @IDVARIETAS
	ORDER BY VT.NAMA_LAB
END
GO
/****** Object:  StoredProcedure [dbo].[GET_TAHUN_GILING]    Script Date: 03/12/2018 02:04:25 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		Bayu Anandavi Muhardika
-- Create date: 01-03-2018
-- Description:	Get Tahun Giling on System Properties
-- =============================================
CREATE PROCEDURE [dbo].[GET_TAHUN_GILING]
	-- Add the parameters for the stored procedure here

AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    -- Insert statements for procedure here
	SELECT TAHUN_GILING FROM TBL_SISTEM
END
GO
/****** Object:  StoredProcedure [dbo].[GET_NEW_IDPETANI]    Script Date: 03/12/2018 02:04:25 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		Bayu Anandavi Muhardika
-- Create date: 02-03-2018
-- Description:	Auto Generate ID Petani
-- =============================================
CREATE PROCEDURE [dbo].[GET_NEW_IDPETANI] 
	-- Add the parameters for the stored procedure here
	@IDKELOMPOK VARCHAR(5), @IDPETANI VARCHAR(9) OUTPUT
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;
	
	DECLARE
	@IDAFD INT,
	@IDPETANI_INT INT

    -- Insert statements for procedure here
	SELECT @IDAFD = LEFT(@IDKELOMPOK,2)
	SELECT @IDPETANI_INT = CN.COUNTER_PETANI
	FROM TBL_COUNTER CN
	WHERE CN.IDAFD = CAST(@IDAFD AS INT)
	UPDATE TBL_COUNTER SET COUNTER_PETANI = COUNTER_PETANI + 1 WHERE IDAFD = @IDAFD
	IF (@IDPETANI_INT < 10)
		SELECT @IDPETANI = @IDKELOMPOK + '000' + CAST(@IDPETANI_INT AS VARCHAR(4))
	IF (@IDPETANI_INT >= 10 AND @IDPETANI_INT < 100)
		SELECT @IDPETANI = @IDKELOMPOK + '00' + CAST(@IDPETANI_INT AS VARCHAR(4))
	IF (@IDPETANI_INT >= 100 AND @IDPETANI_INT < 1000)
		SELECT @IDPETANI = @IDKELOMPOK + '0' + CAST(@IDPETANI_INT AS VARCHAR(4))
	IF (@IDPETANI_INT > 1000)
		SELECT @IDPETANI = @IDKELOMPOK + CAST(@IDPETANI_INT AS VARCHAR(4))
END
GO
/****** Object:  StoredProcedure [dbo].[GET_NEW_IDKELOMPOK]    Script Date: 03/12/2018 02:04:25 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		Bayu Anandavi Muhardika
-- Create date: 01-03-2018
-- Description:	Auto generate number for ID KELOMPOK
-- =============================================
CREATE PROCEDURE [dbo].[GET_NEW_IDKELOMPOK]
	-- Add the parameters for the stored procedure here
	@IDAFD INT ,
	@KATG INT,
	@IDSTR VARCHAR(10) OUTPUT,
	@NO_KONTRAK VARCHAR(15) OUTPUT
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;
	
	DECLARE
	@IDRESULT INT,
	@IDAFDSTR VARCHAR(2),
	@KATG_STR VARCHAR(2),
	@TAHUN_GILING INT,
	@KODE_THN_GILING VARCHAR(2)

    -- Insert statements for procedure here
    SELECT @TAHUN_GILING = SIST.TAHUN_GILING
    FROM TBL_SISTEM SIST;
	SELECT @IDRESULT = CN.COUNTER_KELOMPOK
	FROM TBL_COUNTER CN
	WHERE CN.IDAFD = @IDAFD;
	UPDATE TBL_COUNTER SET COUNTER_KELOMPOK = COUNTER_KELOMPOK + 1 WHERE IDAFD = @IDAFD;
	SELECT @IDAFDSTR = CAST(@IDAFD AS VARCHAR(2));
	SELECT @KATG_STR = CAST(@KATG AS VARCHAR(2));
	SELECT @KODE_THN_GILING = RIGHT(CAST(@TAHUN_GILING AS VARCHAR(4)),2);
	IF (@IDRESULT < 10)
	BEGIN
		SELECT @IDSTR = @IDAFDSTR + '00' + CAST(@IDRESULT AS VARCHAR(2));
		SELECT @NO_KONTRAK = @IDAFDSTR + '.' + @KATG_STR + @KODE_THN_GILING + '.000' + CAST(@IDRESULT AS VARCHAR(2));
	END
	ELSE IF (@IDRESULT >= 10 AND @IDRESULT < 100)
	BEGIN
		SELECT @IDSTR = @IDAFDSTR + '0' + CAST(@IDRESULT AS VARCHAR(2));
		SELECT @NO_KONTRAK = @IDAFDSTR + '.' + @KATG_STR + @KODE_THN_GILING + '.00' + CAST(@IDRESULT AS VARCHAR(2));
	END
	ELSE IF (@IDRESULT >= 100)
	BEGIN
		SELECT @IDSTR = @IDAFDSTR + CAST(@IDRESULT AS VARCHAR(3));
		SELECT @NO_KONTRAK = @IDAFDSTR + '.' + @KATG_STR + @KODE_THN_GILING + '.0' + CAST(@IDRESULT AS VARCHAR(2));
	END
END
GO
/****** Object:  StoredProcedure [dbo].[GET_KELOMPOKTANIH_BY_TAHUN]    Script Date: 03/12/2018 02:04:25 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		BAYU ANANDAVI MUHARDIKA
-- Create date: 10-01-2018
-- Description:	GET LIST OF KELOMPOKTANIH
-- =============================================
CREATE PROCEDURE [dbo].[GET_KELOMPOKTANIH_BY_TAHUN]
	@TAHUN INT
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    -- Insert statements for procedure here
	SELECT	KH.IdKelompok AS IDKELOMPOK, KH.IdAfd AS IDAFD, KH.Tahun AS TAHUN, 
			KH.NamaKelompok AS NAMAKELOMPOK, KH.NoKontrak AS NOKONTRAK, 
			KH.ID_DESA,KH.VERIFIKASI AS VERIFIKASI, KH.NOKTP AS NOKTP, 
			KH.NORDKK AS NORDKK, KH.TGLRDKK AS TGLRDKK
	FROM KelompokTaniH KH
	WHERE KH.Tahun = @TAHUN
	ORDER BY KH.IdAfd, KH.NoKontrak
END
GO
/****** Object:  StoredProcedure [dbo].[GET_KELOMPOKTANIH_BY_MULTIFIELD_1]    Script Date: 03/12/2018 02:04:25 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		BAYU ANANDAVI MUHARDIKA
-- Create date: 14-01-2018
-- Description:	GET LIST ON KELOMPOKTANIH BASED ON MULTIPLE FIELD QUERY
-- =============================================
CREATE PROCEDURE [dbo].[GET_KELOMPOKTANIH_BY_MULTIFIELD_1] 
	-- Add the parameters for the stored procedure here
	@KEYWORD VARCHAR(50),
	@TAHUN INT
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    -- Insert statements for procedure here
	SELECT	KH.IdKelompok AS IDKELOMPOK, KH.IdAfd AS IDAFD, KH.Tahun AS TAHUN, 
			KH.NamaKelompok AS NAMAKELOMPOK, KH.NoKontrak AS NOKONTRAK, 
			KH.ID_DESA AS ID_DESA, KH.VERIFIKASI AS VERIFIKASI, KH.NOKTP AS NOKTP,
			KH.NORDKK AS NORDKK, KH.TGLRDKK AS TGLRDKK
	FROM KelompokTaniH KH
	WHERE KH.Tahun = @TAHUN AND 
	(KH.IdKelompok LIKE '%' + @KEYWORD + '%' OR KH.NamaKelompok LIKE '%' + @KEYWORD + '%' 
	OR KH.NoKontrak LIKE '%' + @KEYWORD + '%') 
	ORDER BY KH.IdAfd, KH.NoKontrak
END
GO
/****** Object:  StoredProcedure [dbo].[GET_KELOMPOKTANID_BY_TAHUN]    Script Date: 03/12/2018 02:04:25 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		BAYU ANANDAVI MUHARDIKA
-- Create date: 27-02-2018
-- Description:	GET ALL PETANI BY TAHUN
-- =============================================
CREATE PROCEDURE [dbo].[GET_KELOMPOKTANID_BY_TAHUN]
	-- Add the parameters for the stored procedure here
	@TAHUN INT
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    -- Insert statements for procedure here
	SELECT KD.IdKelompok AS ID_KELOMPOK, KD.IdPetani AS ID_PETANI, KD.JenisTebu AS JENIS_TEBU, KD.Luas AS LUAS,
		KD.MasaTanam AS MASA_TANAM, KD.NamaPetani AS NAMA_PETANI, KD.Tahun AS TAHUN
	FROM KelompokTaniD KD
	WHERE KD.Tahun = @TAHUN
	ORDER BY KD.IdPetani
END
GO
/****** Object:  StoredProcedure [dbo].[GET_KELOMPOKTANID_BY_IDKELOMPOK]    Script Date: 03/12/2018 02:04:25 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		BAYU ANANDAVI MUHARDIKA
-- Create date: 15-01-2018
-- Description:	GET LIST OF KELOMPOKTANID BASED ON KELOMPOKTANIH IDKELOMPOK
-- =============================================
CREATE PROCEDURE [dbo].[GET_KELOMPOKTANID_BY_IDKELOMPOK] 
	-- Add the parameters for the stored procedure here
	@IDKELOMPOK VARCHAR(10)
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    -- Insert statements for procedure here
	SELECT KD.IdKelompok AS IDKELOMPOK, KD.IdPetani AS IDPETANI, KD.JenisTebu AS JENISTEBU,
		   KD.Luas AS LUAS, KD.MasaTanam AS MASATANAM, KD.NamaPetani AS NAMAPETANI, KD.Tahun AS TAHUN
	FROM KelompokTaniD KD
	WHERE KD.IdKelompok = @IDKELOMPOK
	ORDER BY KD.IdPetani
	
END
GO
/****** Object:  StoredProcedure [dbo].[GET_KECAMATAN_BY_IDKECAMATAN]    Script Date: 03/12/2018 02:04:25 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		BAYU ANANDAVI MUHARDIKA
-- Create date: 05-02-2018
-- Description:	GET LIST OF KECAMATAN FROM KECAMATAN ID
-- =============================================
CREATE PROCEDURE [dbo].[GET_KECAMATAN_BY_IDKECAMATAN] 
	-- Add the parameters for the stored procedure here
	@IDKECAMATAN INT
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    -- Insert statements for procedure here
	SELECT KC.ID_KECAMATAN AS ID_KECAMATAN, KC.NAMA_KECAMATAN AS NAMA_KECAMATAN 
	FROM TBL_KECAMATAN KC 
	WHERE KC.ID_KECAMATAN = @IDKECAMATAN
	ORDER BY KC.NAMA_KECAMATAN
END
GO
/****** Object:  StoredProcedure [dbo].[GET_COUNTER_PETANI]    Script Date: 03/12/2018 02:04:25 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		Bayu Anandavi Muhardika
-- Create date: 01-03-2018
-- Description:	Auto generate number for ID Petani
-- =============================================
CREATE PROCEDURE [dbo].[GET_COUNTER_PETANI] 
	@IDAFD int
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    -- Insert statements for procedure here
	SELECT CN.COUNTER_PETANI AS COUNTER_PETANI
	FROM TBL_COUNTER CN
	WHERE CN.IDAFD = @IDAFD
	UPDATE TBL_COUNTER SET COUNTER_PETANI = COUNTER_PETANI + 1 WHERE IDAFD = @IDAFD
END
GO
/****** Object:  StoredProcedure [dbo].[GET_ALL_VARIETAS]    Script Date: 03/12/2018 02:04:25 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		Bayu Anandavi Muhardika
-- Create date: 27-02-2018
-- Description:	Get All List Varietas Tebu
-- =============================================
CREATE PROCEDURE [dbo].[GET_ALL_VARIETAS]
	-- Add the parameters for the stored procedure here
	
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    -- Insert statements for procedure here
	SELECT VT.ID_VARIETAS AS ID_VARIETAS, VT.NAMA_LAB AS NAMA_LAB, VT.NAMA_RILIS AS NAMA_RILIS, VT.DASAR_HUKUM AS DASAR_HUKUM, VT.SIFAT_KEMASAKAN AS SIFAT_KEMASAKAN
	FROM TBL_VARIETAS VT
	ORDER BY VT.NAMA_LAB
END
GO
/****** Object:  StoredProcedure [dbo].[GET_ALL_KELOMPOKTANID]    Script Date: 03/12/2018 02:04:25 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		Bayu Anandavi Muhardika
-- Create date: 27-02-2018
-- Description:	Get All list Petani Tebu
-- =============================================
CREATE PROCEDURE [dbo].[GET_ALL_KELOMPOKTANID]
	-- Add the parameters for the stored procedure here
	
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    -- Insert statements for procedure here
	SELECT KD.IdKelompok AS ID_KELOMPOK, KD.IdPetani AS ID_PETANI, KD.JenisTebu AS JENIS_TEBU, KD.Luas AS LUAS,
		KD.MasaTanam AS MASA_TANAM, KD.NamaPetani AS NAMA_PETANI, KD.Tahun AS TAHUN
	FROM KelompokTaniD KD
	ORDER BY KD.IdPetani
END
GO
/****** Object:  StoredProcedure [dbo].[GET_ALL_KECAMATAN]    Script Date: 03/12/2018 02:04:25 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		BAYU ANANDAVI MUHARDIKA
-- Create date: 05-02-2018
-- Description:	GET LIST OF KECAMATAN FROM KECAMATAN ID
-- =============================================
CREATE PROCEDURE [dbo].[GET_ALL_KECAMATAN] 

AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    -- Insert statements for procedure here
	SELECT KC.ID_KECAMATAN AS ID_KECAMATAN, KC.NAMA_KECAMATAN AS NAMA_KECAMATAN 
	FROM TBL_KECAMATAN KC 
	ORDER BY KC.NAMA_KECAMATAN
END
GO
/****** Object:  StoredProcedure [dbo].[GET_ALL_DESA_BY_IDKECAMATAN]    Script Date: 03/12/2018 02:04:25 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		Bayu Anandavi Muhardika
-- Create date: 24-02-2018
-- Description:	Get List of Desa from ID Kecamatan
-- =============================================
CREATE PROCEDURE [dbo].[GET_ALL_DESA_BY_IDKECAMATAN] 
	-- Add the parameters for the stored procedure here
	@IDKECAMATAN VARCHAR
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    -- Insert statements for procedure here
	SELECT DS.ID_DESA AS ID_DESA, DS.ID_KECAMATAN AS ID_KECAMATAN, DS.NAMA_DESA AS NAMA_DESA
	FROM TBL_DESA DS
	WHERE DS.ID_KECAMATAN = @IDKECAMATAN
	ORDER BY DS.NAMA_DESA
END
GO
/****** Object:  StoredProcedure [dbo].[GET_ALL_DESA]    Script Date: 03/12/2018 02:04:25 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		Bayu Anandavi Muhardika
-- Create date: 24-02-2018
-- Description:	Get all list of Desa
-- =============================================
CREATE PROCEDURE [dbo].[GET_ALL_DESA] 

AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    -- Insert statements for procedure here
	SELECT DS.ID_DESA AS ID_DESA, DS.ID_KECAMATAN AS ID_KECAMATAN, DS.NAMA_DESA AS NAMA_DESA
	FROM TBL_DESA DS
	ORDER BY DS.NAMA_DESA; 
END
GO
/****** Object:  StoredProcedure [dbo].[GET_AFDELING_BY_IDAFD]    Script Date: 03/12/2018 02:04:25 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		BAYU ANANDAVI MUHARDIKA
-- Create date: 01-11-2018
-- Description:	GET AFDELING DATA BY IDAFD
-- =============================================
CREATE PROCEDURE [dbo].[GET_AFDELING_BY_IDAFD]
	-- Add the parameters for the stored procedure here
	@IDAFD VARCHAR(2)
	
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    -- Insert statements for procedure here
	SELECT A.IdAfd AS IDAFD, A.IdRayon AS IDRAYON, A.Afdeling AS AFDELING, 
	A.BatasRit AS BATASRIT, A.NamaAsisten AS NAMAASISTEN
	FROM Afdeling A WHERE IdAfd = @IDAFD
END
GO
