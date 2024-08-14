-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 20-07-2024 a las 00:10:25
-- Versión del servidor: 10.4.27-MariaDB
-- Versión de PHP: 7.4.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `innovafacturas`
--
CREATE DATABASE IF NOT EXISTS `innovafacturas` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `innovafacturas`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ajuste`
--

DROP TABLE IF EXISTS `ajuste`;
CREATE TABLE `ajuste` (
  `id_ajuste` int(10) UNSIGNED NOT NULL,
  `id_empresa` int(10) UNSIGNED NOT NULL,
  `nombre_ajuste` varchar(50) NOT NULL,
  `acronimo` varchar(50) NOT NULL,
  `descripcion` varchar(255) NOT NULL,
  `status` varchar(50) NOT NULL,
  `created_at` date NOT NULL,
  `created_by` int(10) UNSIGNED NOT NULL,
  `updated_at` date NOT NULL,
  `updated_by` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Volcado de datos para la tabla `ajuste`
--

INSERT INTO `ajuste` (`id_ajuste`, `id_empresa`, `nombre_ajuste`, `acronimo`, `descripcion`, `status`, `created_at`, `created_by`, `updated_at`, `updated_by`) VALUES
(1, 1, 'CAMBIOS', '$', 'Dolar', 'Status', '2024-07-15', 1, '2024-07-15', 1),
(2, 1, 'CAMBIOS', '€', 'Euro', 'Status', '2024-07-15', 1, '2024-07-15', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `auditoria`
--

DROP TABLE IF EXISTS `auditoria`;
CREATE TABLE `auditoria` (
  `id_auditoria` int(10) UNSIGNED NOT NULL,
  `tabla_afectada` varchar(100) NOT NULL,
  `fecha_creacion` timestamp NOT NULL DEFAULT current_timestamp(),
  `creado_por` varchar(255) NOT NULL,
  `accion` varchar(100) NOT NULL,
  `accion_detalle` varchar(255) NOT NULL,
  `detalle` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

DROP TABLE IF EXISTS `cliente`;
CREATE TABLE `cliente` (
  `id_cliente` int(10) UNSIGNED NOT NULL,
  `id_empresa` int(10) UNSIGNED NOT NULL,
  `nombre_cliente` varchar(255) NOT NULL,
  `ruc_cliente` varchar(50) NOT NULL,
  `dv_ruc_cliente` varchar(10) NOT NULL,
  `ruc` varchar(50) NOT NULL,
  `direccion_cliente` text NOT NULL,
  `fecha_cierre_cliente` int(11) NOT NULL,
  `status_cliente` varchar(20) NOT NULL,
  `created_by` int(11) NOT NULL,
  `telefono_cliente` varchar(50) NOT NULL,
  `email_cliente` varchar(100) NOT NULL,
  `updated_by` int(11) NOT NULL,
  `created_at` date NOT NULL,
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`id_cliente`, `id_empresa`, `nombre_cliente`, `ruc_cliente`, `dv_ruc_cliente`, `ruc`, `direccion_cliente`, `fecha_cierre_cliente`, `status_cliente`, `created_by`, `telefono_cliente`, `email_cliente`, `updated_by`, `created_at`, `updated_at`) VALUES
(1, 1, 'DEMO SRL', '80001111', '2', '80001111-2', 'CALLE DEMO SRL', 10, 'ACTIVO', 1, '0972482200', 'demo@demo.com', 1, '2024-07-19', '2024-07-19 17:46:12'),
(2, 1, 'DASDASDASD', '89321514', '1', '89321514-1', 'ADSASDASD', 10, 'ACTIVO', 1, '215475845', 'demo@demo.com', 1, '2024-07-12', '2024-07-12 20:45:17'),
(3, 1, 'ADASDASDASD', '687986798', '1', '687986798-1', 'DASADASDAS', 3, 'ACTIVO', 1, 'dasdasdasd', 'dads@dasd.com', 1, '2024-07-12', '2024-07-12 20:45:17'),
(4, 1, 'DEMO SRL', '80001111', '2', '80001111-2', 'CALLE DEMO SRL', 10, 'ACTIVO', 1, '0972482200', 'demo@demo.com', 1, '2024-07-12', '2024-07-12 20:45:16'),
(5, 1, 'SDADASD', '478778', '1', '478778-1', 'ADADAD', 10, 'ACTIVO', 1, '54654897', 'demo@demo.com', 1, '2024-07-12', '2024-07-12 19:20:40');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cotizacion`
--

DROP TABLE IF EXISTS `cotizacion`;
CREATE TABLE `cotizacion` (
  `id_cotizacion` int(10) UNSIGNED NOT NULL,
  `id_ajuste` int(10) UNSIGNED NOT NULL,
  `compra` double NOT NULL,
  `venta` double NOT NULL,
  `status` varchar(50) NOT NULL,
  `created_at` date NOT NULL,
  `created_by` int(11) NOT NULL,
  `updated_at` date NOT NULL,
  `updated_by` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Volcado de datos para la tabla `cotizacion`
--

INSERT INTO `cotizacion` (`id_cotizacion`, `id_ajuste`, `compra`, `venta`, `status`, `created_at`, `created_by`, `updated_at`, `updated_by`) VALUES
(1, 1, 7440, 7500, 'ACTIVO', '2024-07-15', 1, '2024-07-15', 1),
(2, 2, 8400, 8750, 'ACTIVO', '2024-07-15', 1, '2024-07-15', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empresa`
--

DROP TABLE IF EXISTS `empresa`;
CREATE TABLE `empresa` (
  `id_empresa` int(10) UNSIGNED NOT NULL,
  `nombre_empresa` varchar(255) NOT NULL,
  `ruc_empresa` varchar(50) NOT NULL,
  `direccion_empresa` text NOT NULL,
  `telefono_empresa` varchar(100) NOT NULL,
  `correo_empresa` varchar(100) NOT NULL,
  `status_empresa` varchar(50) NOT NULL,
  `created_at` date NOT NULL,
  `created_by` int(11) NOT NULL,
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `updated_by` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Volcado de datos para la tabla `empresa`
--

INSERT INTO `empresa` (`id_empresa`, `nombre_empresa`, `ruc_empresa`, `direccion_empresa`, `telefono_empresa`, `correo_empresa`, `status_empresa`, `created_at`, `created_by`, `updated_at`, `updated_by`) VALUES
(1, 'Empresa DemoSRL', '80001111-2', 'Asuncion', '0991000001', 'demo@demo.com', 'ACTIVO', '2024-07-08', 1, '2024-07-09 14:57:10', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `factura`
--

DROP TABLE IF EXISTS `factura`;
CREATE TABLE `factura` (
  `id_factura` int(10) UNSIGNED NOT NULL,
  `id_empresa` int(10) UNSIGNED NOT NULL,
  `tipo_factura` varchar(255) NOT NULL,
  `timbrado_factura` varchar(255) NOT NULL,
  `fecha_inicio_vigencia_factura` date NOT NULL,
  `fecha_fin_vigencia_factura` date DEFAULT NULL,
  `cdc_factura` varchar(255) DEFAULT NULL,
  `codigo_control_factura` varchar(255) DEFAULT NULL,
  `numero_factura` varchar(255) NOT NULL,
  `ruc_emisor_factura` varchar(255) NOT NULL,
  `razon_social_emisor_factura` varchar(255) NOT NULL,
  `ruc_receptor_factura` varchar(255) NOT NULL,
  `razon_social_receptor_factura` varchar(255) NOT NULL,
  `fecha_emision_factura` date NOT NULL,
  `condicion_venta_factura` varchar(255) NOT NULL,
  `gravada_5` double DEFAULT NULL,
  `gravada_10` double DEFAULT NULL,
  `gravada_exenta` double DEFAULT NULL,
  `monto_total_factura` double NOT NULL,
  `monto_total_iva_factura` double DEFAULT NULL,
  `monto_5_factura` double DEFAULT NULL,
  `monto_10_factura` double DEFAULT NULL,
  `excenta_factura` double DEFAULT NULL,
  `created_at` date NOT NULL,
  `created_by` int(10) UNSIGNED NOT NULL,
  `updated_by` int(10) UNSIGNED NOT NULL,
  `updated_at` date NOT NULL,
  `status_factura` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Volcado de datos para la tabla `factura`
--

INSERT INTO `factura` (`id_factura`, `id_empresa`, `tipo_factura`, `timbrado_factura`, `fecha_inicio_vigencia_factura`, `fecha_fin_vigencia_factura`, `cdc_factura`, `codigo_control_factura`, `numero_factura`, `ruc_emisor_factura`, `razon_social_emisor_factura`, `ruc_receptor_factura`, `razon_social_receptor_factura`, `fecha_emision_factura`, `condicion_venta_factura`, `gravada_5`, `gravada_10`, `gravada_exenta`, `monto_total_factura`, `monto_total_iva_factura`, `monto_5_factura`, `monto_10_factura`, `excenta_factura`, `created_at`, `created_by`, `updated_by`, `updated_at`, `status_factura`) VALUES
(1, 1, 'FACTURA ELECTRONICA', '16764380', '2023-10-26', NULL, '01800608380001002000503222024053018419265337', NULL, '001-002-0005032', '80060838-0', 'TAKA II COLOR S.A.', '80001111-2', 'MORADO SOCIEDAD ANONIMA', '2024-05-30', 'CONTADO', NULL, NULL, NULL, 643370, 58488, 0, 58488, 0, '2024-06-28', 1, 1, '2024-07-09', 'ACTIVO'),
(2, 1, 'FACTURA VIRTUAL', '17177937', '2024-04-17', NULL, NULL, '930508EE', '001-001-0000001', '3968935-2', 'DADSASD', '80001111-2', 'GLOBAL,INFOCONTABLE', '2024-12-27', 'ASDAAA', NULL, NULL, NULL, 1500000, 0, 0, 0, 0, '2024-07-10', 1, 1, '2024-07-10', 'ACTIVO'),
(3, 1, 'FACTURA VIRTUAL', '17177937', '2024-04-20', NULL, NULL, '930508EE', '001-001-0000001', '3968935-2', 'EJEMPLO DEMOSRL', '80001111-2', 'GLOBAL,INFOCONTABLE', '2023-12-29', 'CONTADO', NULL, NULL, NULL, 555555, 0, 0, 0, 0, '2024-07-10', 1, 1, '2024-07-10', 'ACTIVO'),
(4, 1, 'FACTURA VIRTUAL', '17177937', '2024-04-21', NULL, NULL, '930508EE', '001-001-0000001', '3968935-2', 'dasdasdasd', '80001111-2', 'GLOBAL,INFOCONTABLE', '2023-12-30', 'CONTADO', NULL, NULL, NULL, 1500000, 1, 1, 1, 1, '2024-07-08', 1, 1, '2024-07-08', 'ACTIVO'),
(5, 1, 'FACTURA VIRTUAL', '17177937', '2024-04-20', NULL, NULL, '930508EE', '001-001-0000001', '3968935-2', 'DEMOSRL', '80001111-2', 'DEMO SRL', '2023-12-29', 'CREDITO', NULL, NULL, NULL, 1500000, 3, 3, 3, 3, '2024-07-10', 1, 1, '2024-07-10', 'ACTIVO'),
(6, 1, 'FACTURA VIRTUAL', '12345678', '2022-09-07', NULL, NULL, '9320EEE8', '001-001-0000245', '3385512-9', 'DEMO SRL', '80077042-0', '\'MORADO,SOCIEDAD,[ANONIMA\",I', '2023-12-30', 'CONTADO', NULL, NULL, NULL, 4, 4, 4, 4, 4, '2024-07-08', 1, 1, '2024-07-08', 'ACTIVO'),
(7, 1, 'FACTURA VIRTUAL', '17177937', '2024-04-21', NULL, NULL, '930508EE', '001-001-0000001', '3968935-2', 'ASDASDAS', '80113289-4', 'GLOBAL,INFOCONTABLE', '2023-12-30', 'CREDITO', NULL, NULL, NULL, 1500000, 5, 5, 5, 5, '2024-07-08', 1, 1, '2024-07-08', 'ACTIVO'),
(8, 1, 'FACTURA VIRTUAL', '17177937', '2024-04-19', NULL, NULL, '930508EE', '001-001-0000001', '3968935-2', 'Mi nueva factura ingresada', '80113289-4', 'GLOBAL,INFOCONTABLE', '2024-01-20', 'CREDITO', NULL, NULL, NULL, 1500000, 10, 0, 10, 0, '2024-07-09', 1, 1, '2024-07-09', 'ACTIVO'),
(9, 1, 'FACTURA VIRTUAL', '17177937', '2024-04-21', NULL, NULL, '930508EE', '001-001-0000001', '3968935-2', 'asasddas', '80113289-4', 'GLOBAL,INFOCONTABLE', '2023-12-30', 'CONTADO', NULL, NULL, NULL, 1500000, 1, 1, 1, 1, '2024-07-09', 1, 1, '2024-07-09', 'ACTIVO'),
(10, 1, 'FACTURA VIRTUAL', '17177937', '2024-04-21', NULL, NULL, '930508EE', '001-001-0000001', '3968935-2', 'DADASDASD', '80001111-2', 'DEMO SRL', '2024-11-30', 'DASDASD', NULL, NULL, NULL, 1500000, 1, 1, 1, 1, '2024-07-10', 1, 1, '2024-07-10', 'ACTIVO'),
(11, 1, 'FACTURA VIRTUAL', '17177937', '2024-04-21', NULL, NULL, '930508EE', '001-001-0000001', '3968935-2', 'DASDAS', '80001111-2', 'DEMO SRL', '2024-11-29', 'ADSADSAS', NULL, NULL, NULL, 1500000, 1, 1, 1, 1, '2024-07-10', 1, 1, '2024-07-10', 'ACTIVO'),
(12, 1, 'FACTURA VIRTUAL', '17177937', '2024-07-09', NULL, NULL, '930508EE', '001-001-0000001', '3968935-2', 'ADASD', '80001111-2', 'DEMO SRL', '2024-08-18', 'ADDA', NULL, NULL, NULL, 1500000, 1, 1, 1, 1, '2024-07-12', 1, 1, '2024-07-12', 'ACTIVO'),
(13, 1, 'FACTURA VIRTUAL', '798789797', '2024-04-22', NULL, NULL, '930508EE', '001-001-0000001', '3968935-2', 'DASDASDA', '80001111-2', 'DEMO SRL', '2024-07-09', 'CONTADO', NULL, NULL, NULL, 0, 0, 0, 0, 0, '2024-07-17', 1, 1, '2024-07-17', 'ACTIVO'),
(14, 1, 'FACTURA VIRTUAL', '17177937', '2024-04-22', NULL, NULL, '930508EE', '001-001-0000001', '3968935-2', 'FASFSADFSDA', '80001111-2', 'DEMO SRL', '2024-07-10', 'FASFSDFSD', NULL, NULL, NULL, 1500000, 4, 2, 3, 1, '2024-07-11', 1, 1, '2024-07-11', 'ACTIVO'),
(15, 1, 'FACTURA VIRTUAL', '17177937', '2024-04-22', NULL, NULL, '930508EE', '001-001-0000001', '3968935-2', 'DADASD', '80001111-2', 'DEMO SRL', '2024-07-10', 'DAS', NULL, NULL, NULL, 1500000, 1, 1, 1, 0, '2024-07-11', 1, 1, '2024-07-11', 'ACTIVO'),
(16, 1, 'FACTURA VIRTUAL', '17177937', '2024-04-21', NULL, NULL, '930508EE', '001-001-0000001', '3968935-2', 'DASKDAS', '80001111-2', 'DEMO SRL', '2024-07-09', 'JHGFDJHGF', NULL, NULL, NULL, 1500000, 1, 1, 1, 1, '2024-07-11', 1, 1, '2024-07-11', 'ACTIVO'),
(17, 1, 'FACTURA VIRTUAL', '17177937', '2024-04-20', NULL, NULL, '930508EE', '001-001-0000001', '3968935-2', 'ASDASD', '80001111-2', 'GLOBAL,INFOCONTABLE', '2024-07-08', 'CONTADO', NULL, NULL, NULL, 1500000, 12, 2, 2, 2, '2024-07-12', 1, 1, '2024-07-12', 'ACTIVO'),
(18, 1, 'FACTURA VIRTUAL', '17177937', '2024-04-23', NULL, NULL, '930508EE', '001-001-0000001', '3968935-2', 'ASDASDASD', '80113289-4', 'GLOBAL,INFOCONTABLE', '2024-07-10', 'DASDASD', NULL, NULL, NULL, 1500000, 12, 12, 12, 12, '2024-07-11', 1, 1, '2024-07-11', 'ACTIVO'),
(19, 1, 'FACTURA VIRTUAL', '17177937', '2024-04-22', NULL, NULL, '930508EE', '001-001-0000001', '3968935-2', 'DASDADASD', '80001111-2', 'GLOBAL,INFOCONTABLE', '2024-07-10', 'DDDDDD', NULL, NULL, NULL, 1500000, 12, 12, 12, 12, '2024-07-12', 1, 1, '2024-07-12', 'ACTIVO'),
(20, 1, 'FACTURA VIRTUAL', '17177937', '2024-04-23', NULL, NULL, '930508EE', '001-001-0000001', '3968935-2', 'ASDASDASD', '80113289-4', 'GLOBAL,INFOCONTABLE', '2024-07-11', 'ASDADA', NULL, NULL, NULL, 1500000, 12, 12, 12, 12, '2024-07-11', 1, 1, '2024-07-11', 'ACTIVO'),
(21, 1, 'FACTURA VIRTUAL', '17177937', '2024-04-23', NULL, NULL, '930508EE', '001-001-0000001', '3968935-2', 'ASDASDASD', '80113289-4', 'GLOBAL,INFOCONTABLE', '2024-07-11', 'ASDASDSAD', NULL, NULL, NULL, 1500000, 12, 12, 12, 12, '2024-07-11', 1, 1, '2024-07-11', 'ACTIVO'),
(22, 1, 'FACTURA VIRTUAL', '17177937', '2024-04-23', NULL, NULL, '930508EE', '001-001-0000001', '3968935-2', 'ASDADASD', '80113289-4', 'GLOBAL,INFOCONTABLE', '2024-07-11', 'ADASD', NULL, NULL, NULL, 1500000, 12, 12, 12, 12, '2024-07-11', 1, 1, '2024-07-11', 'ACTIVO'),
(23, 1, 'FACTURA VIRTUAL', '17177937', '2024-04-23', NULL, NULL, '930508EE', '001-001-0000001', '3968935-2', 'ASDASDASD', '80113289-4', 'GLOBAL,INFOCONTABLE', '2024-07-17', 'SDASDASDAD', NULL, NULL, NULL, 1500000, 12, 12, 12, 12, '2024-07-12', 1, 1, '2024-07-12', 'ACTIVO'),
(24, 1, 'FACTURA VIRTUAL', '17177937', '2024-04-22', NULL, NULL, '930508EE', '001-001-0000001', '3968935-2', 'NBMNBMBMN', '80001111-2', 'GLOBAL,INFOCONTABLE', '2024-06-10', 'CONTADO', NULL, NULL, NULL, 1500000, 12211212, 0, 12211212, 0, '2024-07-12', 1, 1, '2024-07-12', 'ACTIVO');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `historialinformes`
--

DROP TABLE IF EXISTS `historialinformes`;
CREATE TABLE `historialinformes` (
  `id_historial` int(10) UNSIGNED NOT NULL,
  `id_user` int(10) UNSIGNED NOT NULL,
  `cliente` varchar(50) NOT NULL,
  `mes` varchar(10) NOT NULL,
  `anho` varchar(10) NOT NULL,
  `datos` text NOT NULL,
  `status_historial` varchar(20) NOT NULL,
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `created_at` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Volcado de datos para la tabla `historialinformes`
--

INSERT INTO `historialinformes` (`id_historial`, `id_user`, `cliente`, `mes`, `anho`, `datos`, `status_historial`, `updated_at`, `created_at`) VALUES
(1, 1, '12345678', '06', '2024', 'demo', 'PROCESADO', '2024-07-19 14:38:47', '2024-07-19 10:37:06'),
(2, 1, '754', '06', '2024', 'demo', 'PROCESADO', '2024-07-19 14:38:50', '2024-07-19 10:38:02'),
(3, 1, '754', '06', '2024', 'demo', 'RE-PROCESADO', '2024-07-19 14:38:52', '2024-07-19 10:38:02');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `persona`
--

DROP TABLE IF EXISTS `persona`;
CREATE TABLE `persona` (
  `id_persona` int(10) UNSIGNED NOT NULL,
  `nombre_persona` varchar(255) NOT NULL,
  `apellido_persona` varchar(255) NOT NULL,
  `telefono_persona` varchar(255) NOT NULL,
  `ci_persona` varchar(255) NOT NULL,
  `status_persona` varchar(255) NOT NULL,
  `created_at` datetime NOT NULL,
  `created_by` int(10) UNSIGNED NOT NULL,
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `updated_by` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Volcado de datos para la tabla `persona`
--

INSERT INTO `persona` (`id_persona`, `nombre_persona`, `apellido_persona`, `telefono_persona`, `ci_persona`, `status_persona`, `created_at`, `created_by`, `updated_at`, `updated_by`) VALUES
(1, 'Root', 'Root', '0972123456', '1234567', 'ACTIVO', '2024-07-02 10:04:59', 1, '2024-07-02 14:04:59', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rgfactura`
--

DROP TABLE IF EXISTS `rgfactura`;
CREATE TABLE `rgfactura` (
  `id_rgfactura` int(10) UNSIGNED NOT NULL,
  `id_empresa` int(10) UNSIGNED NOT NULL,
  `ruc_receptor` varchar(50) NOT NULL,
  `razon_social_receptor` varchar(255) NOT NULL,
  `mes_periodo` varchar(10) NOT NULL,
  `anho_periodo` varchar(10) NOT NULL,
  `codigo_tipo_registro` varchar(10) NOT NULL,
  `codigo_tipo_comprador` varchar(10) NOT NULL,
  `nro_identificador_comprador` varchar(50) NOT NULL,
  `nombre_comprador` varchar(255) NOT NULL,
  `codigo_tipo_comprobante` varchar(50) NOT NULL,
  `fecha_emision` varchar(100) NOT NULL,
  `nro_timbrado` varchar(100) NOT NULL,
  `nro_comprobante` varchar(255) NOT NULL,
  `monto_iva_10` varchar(255) NOT NULL,
  `monto_iva_5` varchar(255) NOT NULL,
  `monto_exenta` varchar(255) NOT NULL,
  `monto_total_comprobante` varchar(255) NOT NULL,
  `condicion_venta` varchar(10) NOT NULL,
  `moneda_extranjera` varchar(10) NOT NULL,
  `imputa_iva` varchar(10) NOT NULL,
  `imputa_ire` varchar(10) NOT NULL,
  `imputa_irp_rsp` varchar(10) NOT NULL,
  `comprobante_asociado` varchar(255) DEFAULT NULL,
  `timbrado_comprobante_asociado` varchar(100) DEFAULT NULL,
  `created_by` int(11) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `updated_by` int(11) NOT NULL,
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Volcado de datos para la tabla `rgfactura`
--

INSERT INTO `rgfactura` (`id_rgfactura`, `id_empresa`, `ruc_receptor`, `razon_social_receptor`, `mes_periodo`, `anho_periodo`, `codigo_tipo_registro`, `codigo_tipo_comprador`, `nro_identificador_comprador`, `nombre_comprador`, `codigo_tipo_comprobante`, `fecha_emision`, `nro_timbrado`, `nro_comprobante`, `monto_iva_10`, `monto_iva_5`, `monto_exenta`, `monto_total_comprobante`, `condicion_venta`, `moneda_extranjera`, `imputa_iva`, `imputa_ire`, `imputa_irp_rsp`, `comprobante_asociado`, `timbrado_comprobante_asociado`, `created_by`, `created_at`, `updated_by`, `updated_at`) VALUES
(1, 1, '321', 'Demo SRL', '07', '2024', '1', '11', '3968935', 'Jonathan Leonardi', '102', '16/07/2024', '12558812', '001-001-0000007', '1100000', '0', '0', '1100000', '1', 'N', 'S', 'N', 'N', NULL, NULL, 1, '2024-07-16 04:00:00', 1, '2024-07-16 04:00:00'),
(2, 1, '754', 'ARCO', '07', '2024', '1', '11', '3968935', 'Jonathan Leonardi', '102', '17/07/2024', '12558812', '001-001-0000008', '2500000', '0', '0', '2500000', '1', 'N', 'S', 'N', 'N', NULL, NULL, 1, '2024-07-16 04:00:00', 1, '2024-07-16 04:00:00'),
(3, 1, '754', 'ARCO', '06', '2024', '1', '11', '3968935', 'Jonathan Leonardi', '102', '16/07/2024', '12558812', '001-001-0000009', '5500000', '0', '0', '5500000', '1', 'N', 'S', 'N', 'N', NULL, NULL, 1, '2024-07-16 04:00:00', 1, '2024-07-16 04:00:00'),
(4, 1, '10', 'Centro educativo nacional Paraguayo Japones', '07', '2024', '1', '11', '3968935', 'Jonathan Leonardi', '102', '16/07/2024', '12558812', '001-001-0000010', '2200000', '0', '0', '2200000', '1', 'N', 'S', 'N', 'N', NULL, NULL, 1, '2024-07-16 19:37:58', 1, '2024-07-16 19:38:02'),
(5, 1, '12345678', 'Morado', '07', '2024', '1', '11', '3968935', 'Jonathan Leonardi', '102', '16/07/2024', '12558812', '001-001-0000011', '2200000', '0', '0', '2200000', '1', 'N', 'S', 'N', 'N', NULL, NULL, 1, '2024-07-16 19:37:43', 1, '2024-07-16 19:37:43'),
(6, 1, '12345678', 'Morado', '06', '2024', '1', '11', '3968935', 'Jonathan Leonardi', '102', '05/06/2024', '12345679', '001-001-0000001', '550000', '0', '0', '550000', '1', 'N', 'S', 'N', 'N', NULL, NULL, 1, '2024-07-16 20:55:43', 1, '2024-07-16 20:55:43'),
(7, 1, '754', 'ARCO', '07', '2024', '1', '11', '3968935', 'Jonathan Leonardi', '102', '17/07/2023', '12558812', '001-001-0000008', '2500000', '0', '0', '2500000', '1', 'N', 'S', 'N', 'N', NULL, NULL, 1, '2024-07-16 04:00:00', 1, '2024-07-16 04:00:00');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rol`
--

DROP TABLE IF EXISTS `rol`;
CREATE TABLE `rol` (
  `id_rol` int(10) UNSIGNED NOT NULL,
  `nombre_rol` varchar(255) NOT NULL,
  `status_rol` varchar(255) NOT NULL,
  `created_at` datetime NOT NULL,
  `created_by` int(10) UNSIGNED NOT NULL,
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `updated_by` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Volcado de datos para la tabla `rol`
--

INSERT INTO `rol` (`id_rol`, `nombre_rol`, `status_rol`, `created_at`, `created_by`, `updated_at`, `updated_by`) VALUES
(1, 'ROOT', 'ACTIVO', '2024-06-28 17:30:30', 1, '2024-06-28 21:30:30', 1),
(2, 'CONTADOR', 'ACTIVO', '2024-07-01 17:08:52', 1, '2024-07-01 21:08:52', 1),
(3, 'CARGADOR', 'ACTIVO', '2024-07-01 17:08:52', 1, '2024-07-01 21:08:52', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id_user` int(10) UNSIGNED NOT NULL,
  `id_empresa` int(11) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `id_rol` int(10) UNSIGNED NOT NULL,
  `last_login` datetime NOT NULL,
  `created_at` datetime NOT NULL,
  `created_by` int(10) UNSIGNED NOT NULL,
  `id_persona` int(10) UNSIGNED NOT NULL,
  `status_user` varchar(255) NOT NULL,
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Volcado de datos para la tabla `user`
--

INSERT INTO `user` (`id_user`, `id_empresa`, `username`, `password`, `id_rol`, `last_login`, `created_at`, `created_by`, `id_persona`, `status_user`, `updated_at`) VALUES
(1, 1, 'elias', '123456', 1, '2024-06-28 12:01:00', '2024-06-28 12:01:00', 1, 1, 'ACTIVO', '2024-07-08 21:51:16'),
(5, 1, 'jels', '123789', 2, '2024-07-01 17:10:34', '2024-07-01 17:10:34', 1, 1, 'ACTIVO', '2024-07-08 21:51:18');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `ajuste`
--
ALTER TABLE `ajuste`
  ADD PRIMARY KEY (`id_ajuste`),
  ADD KEY `id_empresa` (`id_empresa`);

--
-- Indices de la tabla `auditoria`
--
ALTER TABLE `auditoria`
  ADD PRIMARY KEY (`id_auditoria`);

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`id_cliente`),
  ADD KEY `id_empresa` (`id_empresa`);

--
-- Indices de la tabla `cotizacion`
--
ALTER TABLE `cotizacion`
  ADD PRIMARY KEY (`id_cotizacion`),
  ADD KEY `moneda` (`id_ajuste`);

--
-- Indices de la tabla `empresa`
--
ALTER TABLE `empresa`
  ADD PRIMARY KEY (`id_empresa`);

--
-- Indices de la tabla `factura`
--
ALTER TABLE `factura`
  ADD PRIMARY KEY (`id_factura`),
  ADD KEY `factura_created_by` (`created_by`),
  ADD KEY `factura_updated_by` (`updated_by`),
  ADD KEY `id_empresa` (`id_empresa`);

--
-- Indices de la tabla `historialinformes`
--
ALTER TABLE `historialinformes`
  ADD PRIMARY KEY (`id_historial`),
  ADD KEY `id_user` (`id_user`);

--
-- Indices de la tabla `persona`
--
ALTER TABLE `persona`
  ADD PRIMARY KEY (`id_persona`);

--
-- Indices de la tabla `rgfactura`
--
ALTER TABLE `rgfactura`
  ADD PRIMARY KEY (`id_rgfactura`),
  ADD KEY `id_empresa` (`id_empresa`);

--
-- Indices de la tabla `rol`
--
ALTER TABLE `rol`
  ADD PRIMARY KEY (`id_rol`);

--
-- Indices de la tabla `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id_user`),
  ADD KEY `id_rol` (`id_rol`),
  ADD KEY `id_persona` (`id_persona`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `ajuste`
--
ALTER TABLE `ajuste`
  MODIFY `id_ajuste` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `auditoria`
--
ALTER TABLE `auditoria`
  MODIFY `id_auditoria` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `cliente`
--
ALTER TABLE `cliente`
  MODIFY `id_cliente` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `cotizacion`
--
ALTER TABLE `cotizacion`
  MODIFY `id_cotizacion` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `empresa`
--
ALTER TABLE `empresa`
  MODIFY `id_empresa` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `factura`
--
ALTER TABLE `factura`
  MODIFY `id_factura` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- AUTO_INCREMENT de la tabla `historialinformes`
--
ALTER TABLE `historialinformes`
  MODIFY `id_historial` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `persona`
--
ALTER TABLE `persona`
  MODIFY `id_persona` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `rgfactura`
--
ALTER TABLE `rgfactura`
  MODIFY `id_rgfactura` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `rol`
--
ALTER TABLE `rol`
  MODIFY `id_rol` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `user`
--
ALTER TABLE `user`
  MODIFY `id_user` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `ajuste`
--
ALTER TABLE `ajuste`
  ADD CONSTRAINT `ajuste_ibfk_1` FOREIGN KEY (`id_empresa`) REFERENCES `empresa` (`id_empresa`);

--
-- Filtros para la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD CONSTRAINT `cliente_ibfk_1` FOREIGN KEY (`id_empresa`) REFERENCES `empresa` (`id_empresa`);

--
-- Filtros para la tabla `cotizacion`
--
ALTER TABLE `cotizacion`
  ADD CONSTRAINT `cotizacion_ibfk_1` FOREIGN KEY (`id_ajuste`) REFERENCES `ajuste` (`id_ajuste`);

--
-- Filtros para la tabla `factura`
--
ALTER TABLE `factura`
  ADD CONSTRAINT `factura_created_by` FOREIGN KEY (`created_by`) REFERENCES `user` (`id_user`),
  ADD CONSTRAINT `factura_ibfk_1` FOREIGN KEY (`id_empresa`) REFERENCES `empresa` (`id_empresa`),
  ADD CONSTRAINT `factura_updated_by` FOREIGN KEY (`updated_by`) REFERENCES `user` (`id_user`);

--
-- Filtros para la tabla `historialinformes`
--
ALTER TABLE `historialinformes`
  ADD CONSTRAINT `historialinformes_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`);

--
-- Filtros para la tabla `rgfactura`
--
ALTER TABLE `rgfactura`
  ADD CONSTRAINT `rgfactura_ibfk_1` FOREIGN KEY (`id_empresa`) REFERENCES `empresa` (`id_empresa`);

--
-- Filtros para la tabla `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `user_ibfk_1` FOREIGN KEY (`id_rol`) REFERENCES `rol` (`id_rol`),
  ADD CONSTRAINT `user_ibfk_2` FOREIGN KEY (`id_persona`) REFERENCES `persona` (`id_persona`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
