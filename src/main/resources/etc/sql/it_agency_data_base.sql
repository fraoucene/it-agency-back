-- Database generated with pgModeler (PostgreSQL Database Modeler).
-- pgModeler  version: 0.8.2-beta
-- PostgreSQL version: 9.5
-- Project Site: pgmodeler.com.br
-- Model Author: ---


-- Database creation must be done outside an multicommand file.
-- These commands were put in this file only for convenience.
-- -- object: nouvelle_base | type: DATABASE --
-- -- DROP DATABASE IF EXISTS db_it_agency;
-- -- CREATE DATABASE db_it_agency;
-- -- ddl-end --
--

-- object: it_agency | type: SCHEMA --
-- DROP SCHEMA IF EXISTS it_agency CASCADE;
CREATE SCHEMA it_agency;
-- ddl-end --
ALTER SCHEMA it_agency OWNER TO postgres;
-- ddl-end --

SET search_path TO pg_catalog,public,it_agency;
-- ddl-end --

-- object: it_agency.t_candidat | type: TABLE --
-- DROP TABLE IF EXISTS it_agency.t_candidat CASCADE;
CREATE TABLE it_agency.t_candidat(
	id_candidat serial NOT NULL,
	nom character varying(60),
	prenom character varying(30),
	poste character varying(60),
	phone character varying(20),
	email character varying(70),
	CONSTRAINT c_client PRIMARY KEY (id_candidat)

);
-- ddl-end --
ALTER TABLE it_agency.t_candidat OWNER TO postgres;
-- ddl-end --

-- object: it_agency.t_candidat | type: TABLE --
-- DROP TABLE IF EXISTS it_agency.t_user CASCADE;
CREATE TABLE it_agency.t_user(
	id_user serial NOT NULL,
	password character varying(32) NOT NULL,
	name character varying(255) DEFAULT NULL,
	CONSTRAINT c_user PRIMARY KEY (id_user)

);

-- ddl-end --
ALTER TABLE it_agency.t_user OWNER TO postgres;
-- ddl-end --

-- object: it_agency.t_recrut | type: TABLE --
-- DROP TABLE IF EXISTS it_agency.t_recrut CASCADE;
CREATE TABLE it_agency.t_recrut(
	id_recrut serial NOT NULL,
	societe character varying(40),
	nom character varying(60),
	prenom character varying(30),
	poste character varying(70),
	phone character varying(20),
	email character varying(70),
	CONSTRAINT c_recrut PRIMARY KEY (id_recrut)

);
-- ddl-end --
ALTER TABLE it_agency.t_recrut OWNER TO postgres;
-- ddl-end --
