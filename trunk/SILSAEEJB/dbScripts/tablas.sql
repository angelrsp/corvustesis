
/*==============================================================*/
/* table: bem_aviso                                             */
/*==============================================================*/
create table bem_aviso (
   avi_nombre           serial               not null,
   avi_empresa          int4                 null,
   avi_puesto           int4                 null,
   avi_remuneracion     numeric              null,
   avi_descripcion      varchar(1000)        null,
   avi_fecha_caducidad  timestamp            null,
   avi_vacantes         int4                 null,
   constraint pk_bem_aviso primary key (avi_nombre)
);

/*==============================================================*/
/* table: bem_candidato                                         */
/*==============================================================*/
create table bem_candidato (
   can_codigo           serial               not null,
   can_usuario          int4                 null,
   can_nombres          varchar(255)         null,
   can_apellido_paterno varchar(255)         null,
   can_apellido_materno varchar(255)         null,
   can_identificacion   varchar(15)          null,
   can_tipo_identificacion int4                 null,
   can_foto             bytea                null,
   constraint pk_bem_candidato primary key (can_codigo)
);

/*==============================================================*/
/* table: bem_catalogo                                          */
/*==============================================================*/
create table bem_catalogo (
   cat_codigo           serial               not null,
   cat_padre            int4                 null,
   cat_descripcion      varchar(255)         null,
   constraint pk_bem_catalogo primary key (cat_codigo)
);

/*==============================================================*/
/* table: bem_contacto                                          */
/*==============================================================*/
create table bem_contacto (
   con_codigo           serial               not null,
   con_nombres          varchar(255)         null,
   con_apellidos        varchar(255)         null,
   con_mail             varchar(255)         null,
   con_telefono         varchar(10)          null,
   con_cargo            int4                 null,
   constraint pk_bem_contacto primary key (con_codigo)
);

/*==============================================================*/
/* table: bem_empresa                                           */
/*==============================================================*/
create table bem_empresa (
   emp_codigo           serial               not null,
   emp_usuario          int4                 null,
   emp_contacto         int4                 null,
   emp_razon_social     varchar(255)         null,
   emp_nombre_comercial varchar(255)         null,
   emp_ruc              varchar(13)          null,
   emp_web              varchar(255)         null,
   emp_ubicacion        int4                 null,
   emp_sector           int4                 null,
   constraint pk_bem_empresa primary key (emp_codigo)
);

/*==============================================================*/
/* table: bem_estudio                                           */
/*==============================================================*/
create table bem_estudio (
   est_codigo           serial               not null,
   est_candidato        int4                 null,
   est_nivel            int4                 null,
   est_establecimiento  int4                 null,
   est_pais             int4                 null,
   est_carrera          varchar(255)         null,
   est_mes_inicio       int4                 null,
   est_anio_inicio      int4                 null,
   est_mes_fin          int4                 null,
   est_anio_fin         int4                 null,
   constraint pk_bem_estudio primary key (est_codigo)
);

/*==============================================================*/
/* table: bem_experiencia                                       */
/*==============================================================*/
create table bem_experiencia (
   exp_codigo           serial               not null,
   exp_candidato        int4                 null,
   exp_entidad          varchar(100)         null,
   exp_fecha_inicio     timestamp            null,
   exp_fecha_fin        timestamp            null,
   exp_tareas           varchar(255)         null,
   exp_puesto           varchar(255)         null,
   exp_rubro            numeric              null,
   exp_tipo_experiencia int4                 null,
   constraint pk_bem_experiencia primary key (exp_codigo)
);

/*==============================================================*/
/* table: bem_idioma                                            */
/*==============================================================*/
create table bem_idioma (
   idi_codigo           serial               not null,
   idi_candidato        int4                 null,
   idi_idioma           int4                 null,
   idi_nivel            int4                 null,
   constraint pk_bem_idioma primary key (idi_codigo)
);

/*==============================================================*/
/* table: bem_modulo                                            */
/*==============================================================*/
create table bem_modulo (
   mod_codigo           serial               not null,
   mod_descripcion      varchar(100)         null,
   constraint pk_bem_modulo primary key (mod_codigo)
);

/*==============================================================*/
/* table: bem_pantalla                                          */
/*==============================================================*/
create table bem_pantalla (
   pan_codigo           serial               not null,
   pan_modulo           int4                 null,
   pan_descripcion      varchar(100)         null,
   pan_url              varchar(255)         null,
   pan_orden            int4                 null,
   pan_padre            int4                 null,
   pan_on_click         varchar(255)         null,
   constraint pk_bem_pantalla primary key (pan_codigo)
);

/*==============================================================*/
/* table: bem_parametro                                         */
/*==============================================================*/
create table bem_parametro (
   par_codigo           serial               not null,
   par_nombre           varchar(100)         null,
   par_valor            varchar(100)         null,
   constraint pk_bem_parametro primary key (par_codigo)
);

/*==============================================================*/
/* table: bem_perfil                                            */
/*==============================================================*/
create table bem_perfil (
   per_codigo           serial               not null,
   per_descripcion      varchar(100)         null,
   constraint pk_bem_perfil primary key (per_codigo)
);

/*==============================================================*/
/* table: bem_perfil_permiso                                    */
/*==============================================================*/
create table bem_perfil_permiso (
   ppe_codigo           serial               not null,
   ppe_perfil           int4                 null,
   ppe_pantalla         int4                 null,
   constraint pk_bem_perfil_permiso primary key (ppe_codigo)
);

/*==============================================================*/
/* table: bem_postulacion                                       */
/*==============================================================*/
create table bem_postulacion (
   pos_codigo           serial               not null,
   pos_candidato        int4                 null,
   pos_aviso            int4                 null,
   constraint pk_bem_postulacion primary key (pos_codigo)
);

/*==============================================================*/
/* table: bem_referencia                                        */
/*==============================================================*/
create table bem_referencia (
   ref_codigo           serial               not null,
   ref_nombre           varchar(255)         null,
   ref_telefono         varchar(10)          null,
   ref_mail             varchar(255)         null,
   constraint pk_bem_referencia primary key (ref_codigo)
);

/*==============================================================*/
/* table: bem_software                                          */
/*==============================================================*/
create table bem_software (
   pro_codigo           serial               not null,
   pro_candidato        int4                 null,
   pro_programa         int4                 null,
   pro_nivel            int4                 null,
   constraint pk_bem_software primary key (pro_codigo)
);

/*==============================================================*/
/* table: bem_usuario                                           */
/*==============================================================*/
create table bem_usuario (
   usu_codigo           serial               not null,
   usu_perfil           int4                 null,
   usu_password         varchar(255)         null,
   usu_mail             varchar(255)         null,
   usu_celular          varchar(255)         null,
   usu_telefono         varchar(255)         null,
   usu_direccion        varchar(255)         null,
   constraint pk_bem_usuario primary key (usu_codigo)
);

alter table bem_aviso
   add constraint fk_bem_avis_reference_bem_empr foreign key (avi_empresa)
      references bem_empresa (emp_codigo)
      on delete restrict on update restrict;

alter table bem_candidato
   add constraint fk_bem_cand_reference_bem_usua foreign key (can_usuario)
      references bem_usuario (usu_codigo)
      on delete restrict on update restrict;

alter table bem_catalogo
   add constraint fk_bem_cata_reference_bem_cata foreign key (cat_padre)
      references bem_catalogo (cat_codigo)
      on delete restrict on update restrict;

alter table bem_empresa
   add constraint fk_bem_empr_reference_bem_cont foreign key (emp_contacto)
      references bem_contacto (con_codigo)
      on delete restrict on update restrict;

alter table bem_empresa
   add constraint fk_bem_empr_reference_bem_usua foreign key (emp_usuario)
      references bem_usuario (usu_codigo)
      on delete restrict on update restrict;

alter table bem_estudio
   add constraint fk_bem_estu_reference_bem_cand foreign key (est_candidato)
      references bem_candidato (can_codigo)
      on delete restrict on update restrict;

alter table bem_experiencia
   add constraint fk_bem_expe_reference_bem_cand foreign key (exp_candidato)
      references bem_candidato (can_codigo)
      on delete restrict on update restrict;

alter table bem_idioma
   add constraint fk_bem_idio_reference_bem_cand foreign key (idi_candidato)
      references bem_candidato (can_codigo)
      on delete restrict on update restrict;

alter table bem_pantalla
   add constraint fk_bem_pant_reference_bem_modu foreign key (pan_modulo)
      references bem_modulo (mod_codigo)
      on delete restrict on update restrict;

alter table bem_perfil_permiso
   add constraint fk_bem_perf_reference_bem_perf foreign key (ppe_perfil)
      references bem_perfil (per_codigo)
      on delete restrict on update restrict;

alter table bem_perfil_permiso
   add constraint fk_bem_perf_reference_bem_pant foreign key (ppe_pantalla)
      references bem_pantalla (pan_codigo)
      on delete restrict on update restrict;

alter table bem_postulacion
   add constraint fk_bem_post_reference_bem_cand foreign key (pos_candidato)
      references bem_candidato (can_codigo)
      on delete restrict on update restrict;

alter table bem_postulacion
   add constraint fk_bem_post_reference_bem_avis foreign key (pos_aviso)
      references bem_aviso (avi_nombre)
      on delete restrict on update restrict;

alter table bem_software
   add constraint fk_bem_soft_reference_bem_cand foreign key (pro_candidato)
      references bem_candidato (can_codigo)
      on delete restrict on update restrict;

alter table bem_usuario
   add constraint fk_bem_usua_reference_bem_perf foreign key (usu_perfil)
      references bem_perfil (per_codigo)
      on delete restrict on update restrict;
