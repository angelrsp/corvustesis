drop sequence IF EXISTS sec_bem_aviso cascade;

/*==============================================================*/
/* SECUENCIA: SEC_DCCT_ARCHIVOS                                     */
/*==============================================================*/
CREATE SEQUENCE sec_bem_aviso
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE sec_bem_aviso OWNER TO postgres;
--asignamos la secuencia la base de datos
ALTER TABLE bem_aviso
    ALTER COLUMN avi_nombre SET DEFAULT NEXTVAL('sec_bem_aviso');