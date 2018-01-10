-- Project iFacture
-- ---------------------------------------------------------------------------
-- SQL Script to add unite
-- ---------------------------------------------------------------------------
-- COMMANDS IN THIS SCRIPT SHOULD BE EXECUTED WITH SUPERUSER
-- psql -U postgres -d db_ifacture -a -f unite.sql psql -U postgres -h localhost -f src/main/resources/etc/sql/it_agency_data_base.sql
-- ---------------------------------------------------------------------------

INSERT INTO ifacture.t_unite VALUES ('cm','Centimetre');
INSERT INTO ifacture.t_unite VALUES ('h','Heure');
INSERT INTO ifacture.t_unite VALUES ('j','Jour');
INSERT INTO ifacture.t_unite VALUES ('kg','Kilogramme');
INSERT INTO ifacture.t_unite VALUES ('m','Metre');
INSERT INTO ifacture.t_unite VALUES ('pce','Pouce');