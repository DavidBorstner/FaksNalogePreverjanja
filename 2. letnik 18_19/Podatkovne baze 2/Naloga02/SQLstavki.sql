drop view artikli;
drop view artikli_vrste;
drop view narocila;
DROP TRIGGER dodajanje_artikla;

alter table Artikel
   drop constraint FK_ARTIKEL_VRSTA_ART_VRSTA_AR;

alter table Artikel_narocilo_rel
   drop constraint FK_ARTIKEL__ARTIKEL_N_ARTIKEL;

alter table Artikel_narocilo_rel
   drop constraint FK_ARTIKEL__ARTIKEL_N_NAROCILO;

alter table Narocilo
   drop constraint FK_NAROCILO_NAROCILO__NACIN_DO;

alter table Narocilo
   drop constraint FK_NAROCILO_NAROCILO__STRANKA;

alter table Naslov
   drop constraint FK_NASLOV_NASLOV_PO_POSTA;

alter table Postavka_ponudba
   drop constraint FK_POSTAVKA_ARTIKEL_P_ARTIKEL;

alter table Postavka_ponudba
   drop constraint FK_POSTAVKA_POSTAVKA__AKCIJA;

alter table Stevilo_velikost_artikel
   drop constraint FK_STEVILO__ARTIKEL_S_ARTIKEL;

alter table Stevilo_velikost_artikel
   drop constraint FK_STEVILO__VELIKOST__VELIKOST;

alter table Stranka_naslov_rel
   drop constraint FK_STRANKA__STRANKA_N_STRANKA;

alter table Stranka_naslov_rel
   drop constraint FK_STRANKA__STRANKA_N_NASLOV;

drop table Akcija cascade constraints;

drop index Vrsta_artikel_rel_FK;

drop table Artikel cascade constraints;

drop index Artikel_narocilo_rel2_FK;

drop index Artikel_narocilo_rel_FK;

drop table Artikel_narocilo_rel cascade constraints;

drop table Nacin_dostave cascade constraints;

drop index Narocilo_stranka_rel_FK;

drop index Narocilo_dostava_rel_FK;

drop table Narocilo cascade constraints;

drop index Naslov_posta_rel_FK;

drop table Naslov cascade constraints;

drop table Posta cascade constraints;

drop index Postavka_ponudba_rel_FK;

drop index Artikel_postavka_rel_FK;

drop table Postavka_ponudba cascade constraints;

drop index Artikel_st_rel_FK;

drop index Velikost_st_rel_FK;

drop table Stevilo_velikost_artikel cascade constraints;

drop table Stranka cascade constraints;

drop index Stranka_naslov_rel2_FK;

drop index Stranka_naslov_rel_FK;

drop table Stranka_naslov_rel cascade constraints;

drop table Velikost_artikel cascade constraints;

drop table Vrsta_artikla cascade constraints;

/*==============================================================*/
/* Table: Akcija                                                */
/*==============================================================*/
create table Akcija  (
   ID_ponudbe           INTEGER                         not null,
   Datum_od             DATE                            not null,
   Datum_do             DATE                            not null,
   Naziv_akcije         VARCHAR2(50)                    not null,
   constraint PK_AKCIJA primary key (ID_ponudbe)
);

/*==============================================================*/
/* Table: Artikel                                               */
/*==============================================================*/
create table Artikel  (
   ID_artikel           INTEGER                         not null,
   ID_vrsta_artikla     INTEGER                         not null,
   Naziv_artikla        VARCHAR2(50)                    not null,
   constraint PK_ARTIKEL primary key (ID_artikel)
);

/*==============================================================*/
/* Index: Vrsta_artikel_rel_FK                                  */
/*==============================================================*/
create index Vrsta_artikel_rel_FK on Artikel (
   ID_vrsta_artikla ASC
);

/*==============================================================*/
/* Table: Artikel_narocilo_rel                                  */
/*==============================================================*/
create table Artikel_narocilo_rel  (
   ID_artikel           INTEGER                         not null,
   ID_narocilo          INTEGER                         not null,
   constraint PK_ARTIKEL_NAROCILO_REL primary key (ID_artikel, ID_narocilo)
);

/*==============================================================*/
/* Index: Artikel_narocilo_rel_FK                               */
/*==============================================================*/
create index Artikel_narocilo_rel_FK on Artikel_narocilo_rel (
   ID_artikel ASC
);

/*==============================================================*/
/* Index: Artikel_narocilo_rel2_FK                              */
/*==============================================================*/
create index Artikel_narocilo_rel2_FK on Artikel_narocilo_rel (
   ID_narocilo ASC
);

/*==============================================================*/
/* Table: Nacin_dostave                                         */
/*==============================================================*/
create table Nacin_dostave  (
   ID_nacin_dostava     INTEGER                         not null,
   Naziv_dostave        VARCHAR2(50),
   constraint PK_NACIN_DOSTAVE primary key (ID_nacin_dostava)
);

/*==============================================================*/
/* Table: Narocilo                                              */
/*==============================================================*/
create table Narocilo  (
   ID_narocilo          INTEGER                         not null,
   ID_stranka           INTEGER                         not null,
   ID_nacin_dostava     INTEGER                         not null,
   Skupen_znesek        NUMBER(8,2)                     not null,
   Datum_narocila       DATE                            not null,
   constraint PK_NAROCILO primary key (ID_narocilo)
);

/*==============================================================*/
/* Index: Narocilo_dostava_rel_FK                               */
/*==============================================================*/
create index Narocilo_dostava_rel_FK on Narocilo (
   ID_nacin_dostava ASC
);

/*==============================================================*/
/* Index: Narocilo_stranka_rel_FK                               */
/*==============================================================*/
create index Narocilo_stranka_rel_FK on Narocilo (
   ID_stranka ASC
);

/*==============================================================*/
/* Table: Naslov                                                */
/*==============================================================*/
create table Naslov  (
   Postna_stevilka      INTEGER                         not null,
   ID_naslov            INTEGER                         not null,
   Hisna_stevilka       NUMBER                          not null,
   constraint PK_NASLOV primary key (Postna_stevilka, ID_naslov, Hisna_stevilka)
);

/*==============================================================*/
/* Index: Naslov_posta_rel_FK                                   */
/*==============================================================*/
create index Naslov_posta_rel_FK on Naslov (
   Postna_stevilka ASC
);

/*==============================================================*/
/* Table: Posta                                                 */
/*==============================================================*/
create table Posta  (
   Postna_stevilka      INTEGER                         not null,
   Kraj                 VARCHAR2(50)                    not null,
   constraint PK_POSTA primary key (Postna_stevilka)
);

/*==============================================================*/
/* Table: Postavka_ponudba                                      */
/*==============================================================*/
create table Postavka_ponudba  (
   ID_artikel           INTEGER                         not null,
   ID_ponudbe           INTEGER                         not null,
   Cena_brez_DDV        NUMBER(8,2)                     not null,
   Popust               NUMBER                          not null,
   constraint PK_POSTAVKA_PONUDBA primary key (ID_artikel, ID_ponudbe)
);

/*==============================================================*/
/* Index: Artikel_postavka_rel_FK                               */
/*==============================================================*/
create index Artikel_postavka_rel_FK on Postavka_ponudba (
   ID_artikel ASC
);

/*==============================================================*/
/* Index: Postavka_ponudba_rel_FK                               */
/*==============================================================*/
create index Postavka_ponudba_rel_FK on Postavka_ponudba (
   ID_ponudbe ASC
);

/*==============================================================*/
/* Table: Stevilo_velikost_artikel                              */
/*==============================================================*/
create table Stevilo_velikost_artikel  (
   ID_velikosti         INTEGER                         not null,
   ID_artikel           INTEGER                         not null,
   Stevila              NUMBER                          not null,
   constraint PK_STEVILO_VELIKOST_ARTIKEL primary key (ID_velikosti, ID_artikel)
);

/*==============================================================*/
/* Index: Velikost_st_rel_FK                                    */
/*==============================================================*/
create index Velikost_st_rel_FK on Stevilo_velikost_artikel (
   ID_velikosti ASC
);

/*==============================================================*/
/* Index: Artikel_st_rel_FK                                     */
/*==============================================================*/
create index Artikel_st_rel_FK on Stevilo_velikost_artikel (
   ID_artikel ASC
);

/*==============================================================*/
/* Table: Stranka                                               */
/*==============================================================*/
create table Stranka  (
   ID_stranka           INTEGER                         not null,
   Ime                  VARCHAR2(50)                    not null,
   Priimek              VARCHAR2(50)                    not null,
   Telefonska_stevilka  VARCHAR2(12),
   Elektronski_naslov   VARCHAR2(50)                    not null,
   Geslo                CHAR(20)                        not null,
   constraint PK_STRANKA primary key (ID_stranka)
);

/*==============================================================*/
/* Table: Stranka_naslov_rel                                    */
/*==============================================================*/
create table Stranka_naslov_rel  (
   ID_stranka           INTEGER                         not null,
   Postna_stevilka      INTEGER                         not null,
   ID_naslov            INTEGER                         not null,
   Hisna_stevilka       NUMBER                          not null,
   constraint PK_STRANKA_NASLOV_REL primary key (ID_stranka, Postna_stevilka, ID_naslov, Hisna_stevilka)
);

/*==============================================================*/
/* Index: Stranka_naslov_rel_FK                                 */
/*==============================================================*/
create index Stranka_naslov_rel_FK on Stranka_naslov_rel (
   ID_stranka ASC
);

/*==============================================================*/
/* Index: Stranka_naslov_rel2_FK                                */
/*==============================================================*/
create index Stranka_naslov_rel2_FK on Stranka_naslov_rel (
   Postna_stevilka ASC,
   ID_naslov ASC,
   Hisna_stevilka ASC
);

/*==============================================================*/
/* Table: Velikost_artikel                                      */
/*==============================================================*/
create table Velikost_artikel  (
   ID_velikosti         INTEGER                         not null,
   Velikost             VARCHAR2(10)                    not null,
   constraint PK_VELIKOST_ARTIKEL primary key (ID_velikosti)
);

/*==============================================================*/
/* Table: Vrsta_artikla                                         */
/*==============================================================*/
create table Vrsta_artikla  (
   ID_vrsta_artikla     INTEGER                         not null,
   Naziv_vrste          VARCHAR2(50)                    not null,
   constraint PK_VRSTA_ARTIKLA primary key (ID_vrsta_artikla)
);

alter table Artikel
   add constraint FK_ARTIKEL_VRSTA_ART_VRSTA_AR foreign key (ID_vrsta_artikla)
      references Vrsta_artikla (ID_vrsta_artikla);

alter table Artikel_narocilo_rel
   add constraint FK_ARTIKEL__ARTIKEL_N_ARTIKEL foreign key (ID_artikel)
      references Artikel (ID_artikel);

alter table Artikel_narocilo_rel
   add constraint FK_ARTIKEL__ARTIKEL_N_NAROCILO foreign key (ID_narocilo)
      references Narocilo (ID_narocilo);

alter table Narocilo
   add constraint FK_NAROCILO_NAROCILO__NACIN_DO foreign key (ID_nacin_dostava)
      references Nacin_dostave (ID_nacin_dostava);

alter table Narocilo
   add constraint FK_NAROCILO_NAROCILO__STRANKA foreign key (ID_stranka)
      references Stranka (ID_stranka);

alter table Naslov
   add constraint FK_NASLOV_NASLOV_PO_POSTA foreign key (Postna_stevilka)
      references Posta (Postna_stevilka);

alter table Postavka_ponudba
   add constraint FK_POSTAVKA_ARTIKEL_P_ARTIKEL foreign key (ID_artikel)
      references Artikel (ID_artikel);

alter table Postavka_ponudba
   add constraint FK_POSTAVKA_POSTAVKA__AKCIJA foreign key (ID_ponudbe)
      references Akcija (ID_ponudbe);

alter table Stevilo_velikost_artikel
   add constraint FK_STEVILO__ARTIKEL_S_ARTIKEL foreign key (ID_artikel)
      references Artikel (ID_artikel);

alter table Stevilo_velikost_artikel
   add constraint FK_STEVILO__VELIKOST__VELIKOST foreign key (ID_velikosti)
      references Velikost_artikel (ID_velikosti);

alter table Stranka_naslov_rel
   add constraint FK_STRANKA__STRANKA_N_STRANKA foreign key (ID_stranka)
      references Stranka (ID_stranka);

alter table Stranka_naslov_rel
   add constraint FK_STRANKA__STRANKA_N_NASLOV foreign key (Postna_stevilka, ID_naslov, Hisna_stevilka)
      references Naslov (Postna_stevilka, ID_naslov, Hisna_stevilka);


INSERT INTO POSTA
VALUES (3305,'Vransko');
INSERT INTO POSTA
VALUES (1000,'Ljubljana');
INSERT INTO POSTA
VALUES (3320,'Velenje');

INSERT INTO NASLOV
VALUES (3305,1, 123);
INSERT INTO NASLOV
VALUES (1000,2, 321);
INSERT INTO NASLOV
VALUES (3320,3,444);

INSERT INTO STRANKA
VALUES (1, 'David', 'Borstner', '123 123 123', 'db3596@student.uni-lj.si', 'Geslo123');
INSERT INTO STRANKA
VALUES (2, 'Borut', 'Pahor', '040 286 714', 'bp1234@student.uni-lj.si', '123456');
INSERT INTO STRANKA
VALUES (3, 'Jan', 'Centrih', '051 223 224', 'jc3096@student.uni-lj.si', '123geslO');

INSERT INTO STRANKA_NASLOV_REL
VALUES(1,3305,1,123);
INSERT INTO STRANKA_NASLOV_REL
VALUES(2,1000,2,321);
INSERT INTO STRANKA_NASLOV_REL
VALUES(3,3320,3,444);

INSERT INTO NACIN_DOSTAVE
VALUES(1, 'Prevzem v trgovini');
INSERT INTO NACIN_DOSTAVE
VALUES(2, 'Dostava na dom');

INSERT INTO VRSTA_ARTIKLA
VALUES(1, 'Pulover');
INSERT INTO VRSTA_ARTIKLA
VALUES(2,'Bunda');
INSERT INTO VRSTA_ARTIKLA
VALUES(3, 'Hlace');

INSERT INTO VELIKOST_ARTIKEL
VALUES(1, 'S');
INSERT INTO VELIKOST_ARTIKEL
VALUES(2, 'M');
INSERT INTO VELIKOST_ARTIKEL
VALUES(3, 'L');


INSERT INTO AKCIJA
VALUES(1, '10/December/2018','30/December/2018','Velika bozicna akcija');
INSERT INTO AKCIJA
VALUES(2, '8/February/2016','9/February/2016','Presernov popust');

INSERT INTO ARTIKEL
VALUES(1,1, 'Bel pulover');
INSERT INTO ARTIKEL
VALUES(2,2, 'Dolga bunda');
INSERT INTO ARTIKEL
VALUES(3,3, 'Sportne hlace');

INSERT INTO STEVILO_VELIKOST_ARTIKEL
VALUES (1, 1, 5);
INSERT INTO STEVILO_VELIKOST_ARTIKEL
VALUES (2, 1, 3);
INSERT INTO STEVILO_VELIKOST_ARTIKEL
VALUES (3, 1, 1);
INSERT INTO STEVILO_VELIKOST_ARTIKEL
VALUES (1, 2, 2);
INSERT INTO STEVILO_VELIKOST_ARTIKEL
VALUES (2, 2, 2);
INSERT INTO STEVILO_VELIKOST_ARTIKEL
VALUES (3, 2, 2);
INSERT INTO STEVILO_VELIKOST_ARTIKEL
VALUES (1, 3, 2);
INSERT INTO STEVILO_VELIKOST_ARTIKEL
VALUES (2, 3, 1);
INSERT INTO STEVILO_VELIKOST_ARTIKEL
VALUES (3, 3, 0);

INSERT INTO POSTAVKA_PONUDBA
VALUES (1,1, 20, 15);
INSERT INTO POSTAVKA_PONUDBA
VALUES (2,1, 50, 15);
INSERT INTO POSTAVKA_PONUDBA
VALUES (3,2, 25, 8);

INSERT INTO NAROCILO
VALUES (1,2,2,90, '15/january/2017');
INSERT INTO NAROCILO
VALUES (2,1,1,25, '8/february/2018');

INSERT INTO ARTIKEL_NAROCILO_REL
VALUES(1, 1);  
INSERT INTO ARTIKEL_NAROCILO_REL
VALUES(2,1);
INSERT INTO ARTIKEL_NAROCILO_REL
VALUES(3,2);

SET TRANSACTION READ ONLY NAME 'Narocila';
  SELECT *
  FROM NAROCILO;
COMMIT;

SET TRANSACTION NAME 'Pregled_artiklov';
  SELECT ARTIKEL.NAZIV_ARTIKLA, STEVILO_VELIKOST_ARTIKEL.STEVILA, VELIKOST_ARTIKEL.VELIKOST
  FROM ARTIKEL join STEVILO_VELIKOST_ARTIKEL on ARTIKEL.ID_ARTIKEL = STEVILO_VELIKOST_ARTIKEL.ID_ARTIKEL
  join VELIKOST_ARTIKEL on STEVILO_VELIKOST_ARTIKEL.ID_VELIKOSTI = VELIKOST_ARTIKEL.ID_VELIKOSTI;
COMMIT;

SET TRANSACTION NAME 'Pregled_narocnikov';
  SELECT IME, PRIIMEK, TELEFONSKA_STEVILKA, ELEKTRONSKI_NASLOV, NASLOV.HISNA_STEVILKA, POSTA.KRAJ
  FROM STRANKA join STRANKA_NASLOV_REL on STRANKA.ID_STRANKA = STRANKA_NASLOV_REL.ID_STRANKA
  join NASLOV on STRANKA_NASLOV_REL.ID_NASLOV = NASLOV.ID_NASLOV
  join POSTA on POSTA.POSTNA_STEVILKA = NASLOV.POSTNA_STEVILKA;
COMMIT;

SET TRANSACTION NAME 'Pregled_narocil';
  SELECT NAROCILO.ID_NAROCILO, ARTIKEL.NAZIV_ARTIKLA, CENA_BREZ_DDV*1.10 as "Cena"
  FROM NACIN_DOSTAVE join NAROCILO on NACIN_DOSTAVE.ID_NACIN_DOSTAVA = NAROCILO.ID_NACIN_DOSTAVA
  join ARTIKEL_NAROCILO_REL on NAROCILO.ID_NAROCILO = ARTIKEL_NAROCILO_REL.ID_NAROCILO
  join ARTIKEL on ARTIKEL.ID_ARTIKEL = ARTIKEL_NAROCILO_REL.ID_ARTIKEL
  join POSTAVKA_PONUDBA on POSTAVKA_PONUDBA.ID_ARTIKEL = ARTIKEL.ID_ARTIKEL;
COMMIT;

SET TRANSACTION NAME 'Pregled_krajev_narocnikov';
  SELECT POSTA.POSTNA_STEVILKA, KRAJ, NASLOV.HISNA_STEVILKA
  FROM POSTA join NASLOV on POSTA.POSTNA_STEVILKA = NASLOV.POSTNA_STEVILKA;
COMMIT;

SET TRANSACTION NAME 'Dodaj_velikosti';
  UPDATE STEVILO_VELIKOST_ARTIKEL
  SET STEVILA = STEVILA + 5
  WHERE ID_ARTIKEL = 1 and ID_VELIKOSTI = 1;
  
  UPDATE STEVILO_VELIKOST_ARTIKEL
  SET STEVILA = STEVILA + 5
  WHERE ID_ARTIKEL = 1 and ID_VELIKOSTI = 2;
  
  UPDATE STEVILO_VELIKOST_ARTIKEL
  SET STEVILA = STEVILA + 5
  WHERE ID_ARTIKEL = 1 and ID_VELIKOSTI = 3;
  
  SELECT *
  FROM STEVILO_VELIKOST_ARTIKEL
  WHERE ID_ARTIKEL = 1;
COMMIT;

SET TRANSACTION NAME 'Spremeni_telefon_narocnik';
  UPDATE STRANKA
  SET TELEFONSKA_STEVILKA = '123 123 123'
  WHERE ID_STRANKA = 1;
  
  SELECT *
  FROM STRANKA
  WHERE ID_STRANKA = 1;
COMMIT;

SET TRANSACTION NAME 'Dodajanje_kape_v_vrste';
  INSERT INTO VRSTA_ARTIKLA
  VALUES(4, 'Kapa');

  SELECT *
  FROM VRSTA_ARTIKLA;
COMMIT;

SET TRANSACTION NAME 'Brisanje_kape_v_vrstah';
  DELETE FROM VRSTA_ARTIKLA
  WHERE NAZIV_VRSTE = 'Kapa';
  
  SELECT *
  FROM VRSTA_ARTIKLA;
COMMIT;

SET TRANSACTION NAME 'VREDNOSTI NAROCIL'
  SELECT NAROCILO.ID_NAROCILO, sum(POSTAVKA_PONUDBA.CENA_BREZ_DDV) as "Cena narocila"
  FROM STRANKA join NAROCILO on STRANKA.ID_STRANKA = NAROCILO.ID_STRANKA
  join ARTIKEL_NAROCILO_REL on NAROCILO.ID_NAROCILO = ARTIKEL_NAROCILO_REL.ID_NAROCILO
  join ARTIKEL on ARTIKEL_NAROCILO_REL.ID_ARTIKEL = ARTIKEL.ID_ARTIKEL
  join POSTAVKA_PONUDBA on ARTIKEL.ID_ARTIKEL = POSTAVKA_PONUDBA.ID_ARTIKEL
  group by NAROCILO.ID_NAROCILO;
COMMIT;

CREATE INDEX NAROCILA_IZPIS
ON NAROCILO(SKUPEN_ZNESEK, DATUM_NAROCILA);

CREATE INDEX ARTIKEL_IZPIS
ON ARTIKEL(NAZIV_ARTIKLA);

CREATE INDEX ARTIKEL_VRSTE
ON VRSTA_ARTIKLA(NAZIV_VRSTE);

CREATE INDEX STRANKE
ON STRANKA(IME, PRIIMEK);

CREATE INDEX POSTAVKA_PON
ON POSTAVKA_PONUDBA(CENA_BREZ_DDV);

CREATE VIEW ARTIKLI as
SELECT ARTIKEL.NAZIV_ARTIKLA as "Naziv artikla", STEVILO_VELIKOST_ARTIKEL.STEVILA as "Stevilo na zalogi", VELIKOST_ARTIKEL.VELIKOST as "Velikost", CENA_BREZ_DDV*1.1 as "Cena artikla"
FROM POSTAVKA_PONUDBA join ARTIKEL on ARTIKEL.ID_ARTIKEL = POSTAVKA_PONUDBA.ID_ARTIKEL 
join STEVILO_VELIKOST_ARTIKEL on ARTIKEL.ID_ARTIKEL = STEVILO_VELIKOST_ARTIKEL.ID_ARTIKEL
join VELIKOST_ARTIKEL on STEVILO_VELIKOST_ARTIKEL.ID_VELIKOSTI = VELIKOST_ARTIKEL.ID_VELIKOSTI
order by ARTIKEL.NAZIV_ARTIKLA asc;

CREATE VIEW ARTIKLI_VRSTE as 
SELECT ARTIKEL.NAZIV_ARTIKLA as "Naziv artikla", VRSTA_ARTIKLA.NAZIV_VRSTE as "Vrsta artikla"
FROM ARTIKEL join VRSTA_ARTIKLA on ARTIKEL.ID_VRSTA_ARTIKLA = VRSTA_ARTIKLA.ID_VRSTA_ARTIKLA
order by VRSTA_ARTIKLA.NAZIV_VRSTE;

CREATE VIEW NAROCILA as
SELECT STRANKA.IME as "Ime", STRANKA.PRIIMEK as "Priimek", NAROCILO.ID_NAROCILO, NAROCILO.DATUM_NAROCILA, ARTIKEL.NAZIV_ARTIKLA, POSTAVKA_PONUDBA.CENA_BREZ_DDV*1.1 as "Cena"
FROM STRANKA join NAROCILO on STRANKA.ID_STRANKA = NAROCILO.ID_STRANKA
join ARTIKEL_NAROCILO_REL on NAROCILO.ID_NAROCILO = ARTIKEL_NAROCILO_REL.ID_NAROCILO
join ARTIKEL on ARTIKEL_NAROCILO_REL.ID_ARTIKEL = ARTIKEL.ID_ARTIKEL
join POSTAVKA_PONUDBA on ARTIKEL.ID_ARTIKEL = POSTAVKA_PONUDBA.ID_ARTIKEL;

SELECT *
FROM NAROCILA;

CREATE TRIGGER Dodajanje_artikla
AFTER INSERT ON ARTIKEL
BEGIN
  DECLARE
  id ARTIKEL.ID_ARTIKEL%TYPE;
  
  BEGIN
  SELECT MAX(ID_ARTIKEL) into id
  FROM ARTIKEL;
  
  INSERT INTO STEVILO_VELIKOST_ARTIKEL
  VALUES(1,id,5);
  INSERT INTO STEVILO_VELIKOST_ARTIKEL
  VALUES(2,id,5);
  INSERT INTO STEVILO_VELIKOST_ARTIKEL
  VALUES(3,id,5);
  END;
END;
