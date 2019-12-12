create table veiculo
(
  vei_id serial not null primary key,
  vei_placa varchar(10),
  vei_tipo  varchar(10)	
);
create table usuario
(
  usu_id serial not null primary key,
  usu_nome varchar(40),
  usu_senha varchar(10)
);

create table posto
(
  pos_id serial not null primary key,
  pos_nome varchar(60)
);

create table abastecimento
(
  abas_id serial not null primary key,
  abas_data date,
  abas_nome varchar(60),
  abas_totLitros float,
  abas_odometro Integer,
  abas_vlr_total float,
  abas_vlr_unit float,
   vei_id int not null,
  constraint rel_veiculo_abastecimento foreign key (vei_id) references veiculo,
   pos_id int not null,
  constraint rel_posto_abastecimento foreign key (pos_id) references posto
	
);
