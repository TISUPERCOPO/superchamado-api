create table categoria (
id integer not null auto_increment,
descricao varchar(255),
status bit,
tenant_id integer,
primary key (id)
) engine=InnoDB

create table chamado (
id integer not null auto_increment,
descricao varchar(255),
status bit,
titulo varchar(255),
categoria_id integer,
setor_id integer,
tenant_id integer,
primary key (id)
) engine=InnoDB

create table classepermissao (
id integer not null auto_increment,
nome varchar(255),
primary key (id)
) engine=InnoDB

create table codigo (
id integer not null auto_increment,
codigo varchar(255),
telefone varchar(255),
primary key (id)
) engine=InnoDB

create table empresa (
id integer not null auto_increment,
bairro varchar(255),
cep varchar(255),
cidade varchar(255),
complemento varchar(255),
cpfoucnpj varchar(255),
editar bit,
email varchar(255),
logradouro varchar(255),
naturezapessoa varchar(255),
nomecontato varchar(255),
numero varchar(255),
razaosocial varchar(255),
status bit,
telefone varchar(255),
tenant_id integer,
uf varchar(255),
valor decimal(19,2),
whats varchar(255),
primary key (id)
) engine=InnoDB

create table log_sistema (
id integer not null auto_increment,
comando varchar(255),
datagravacao datetime,
loginusuario varchar(255),
status bit,
categoria_id integer  null,
chamado_id integer  null,
empresa_id integer  null,
permissao_id integer  null,
sac_id integer  null,
setor_id integer  null,
tenant_id integer,
usuario_id integer null,
primary key (id)
) engine=InnoDB

create table permissao (
id integer not null auto_increment,
descricao varchar(255),
classepermissao_id integer,
primary key (id)
) engine=InnoDB

create table sac (
id integer not null auto_increment,
cliente varchar(255),
credito varchar(255),
custo_total double precision,
dataprevisao datetime(6),
devolucao varchar(255),
empresa varchar(255),
frete varchar(255),
observacao varchar(255),
pedido varchar(255),
problema varchar(255),
setor varchar(255),
status bit,
tipopedido varchar(255),
transportadora varchar(255),
valorcredito decimal(19,2),
vendedor varchar(255),
tenant_id integer,
primary key (id)
) engine=InnoDB

create table setor (
id integer not null auto_increment,
descricao varchar(255),
status bit,
tenant_id integer,
primary key (id)
) engine=InnoDB

create table tenant (
id integer not null auto_increment,
descricao varchar(255),
primary key (id)
) engine=InnoDB

create table usuario (
id integer not null auto_increment,
gtenantativo integer,
login varchar(255),
nome varchar(255),
senha varchar(255),
status bit,
tenantativo integer,
tenant_id integer,
primary key (id)
) engine=InnoDB

create table usuario_permissao (
id_usuario integer not null,
id_permissao integer not null
) engine=InnoDB

create table usuario_empresa (
empresapadrao bit,
tenant_id integer,
id_empresa integer not null,
id_usuario integer not null,
primary key (id_empresa, id_usuario)
) engine=InnoDB

alter table empresa add constraint UK_ow6ddx531a4abnwv6eah7h3k7 unique (cpfoucnpj)

alter table categoria add constraint FK5grfw6g65w8qbqiajdspkswfh foreign key (tenant_id) references tenant (id)

alter table chamado add constraint FKntefhv75gc9w2hdkoq6e5d35h foreign key (categoria_id) references categoria (id)

alter table chamado add constraint FKss33t3vm8fq01a8qnvl7g9exa foreign key (setor_id) references setor (id)

alter table chamado add constraint FK6u4ogu0n5sgjjkwe5xej3haqk foreign key (tenant_id) references tenant (id)

alter table log_sistema add constraint FK5u6io1i8cn9yq29w7fxh05fuw foreign key (categoria_id) references categoria (id)

alter table log_sistema add constraint FKh53k6hag9ey8n4vlt5e99fdej foreign key (chamado_id) references chamado (id)

alter table log_sistema add constraint FKdtxgdxwvuxbb45995iirr9ase foreign key (empresa_id) references empresa (id)

alter table log_sistema add constraint FKlu2agpnij2euws8475xbxj5pf foreign key (permissao_id) references permissao (id)

alter table log_sistema add constraint FKrugknamq9wexe1xor0al6y28a foreign key (sac_id) references sac (id)

alter table log_sistema add constraint FKfn8fttrlqf9j8lj5bsn8xlhbt foreign key (setor_id) references setor (id)

alter table log_sistema add constraint FK70ecb2jvl5xk791a9ybtw1dsv foreign key (tenant_id) references tenant (id)

alter table log_sistema add constraint FKsltyfd8mjygt5amoo95i5p9iw foreign key (usuario_id) references usuario (id)

alter table permissao add constraint FKdiyasfskbnh46lmx2ywloji0d foreign key (classepermissao_id) references classepermissao (id)

alter table sac add constraint FKeffqfm8a8jmg6ou356c28dbpu foreign key (tenant_id) references tenant (id)

alter table setor add constraint FKrebkugvx635b2hk6mpr80pmxv foreign key (tenant_id) references tenant (id)

alter table usuario add constraint FKa10giac3ef9545ra7eyhmn4q1 foreign key (tenant_id) references tenant (id)

alter table usuario_permissao add constraint FKjvcxjnrmdhdv6eti5d7svm5xw foreign key (id_permissao) references permissao (id)

alter table usuario_permissao add constraint FKbo8hww1whbpxq8ancjokhnfds foreign key (id_usuario) references usuario (id)

alter table usuario_empresa add constraint FKkicrvlg5cwo9w2xi83xrq4ver foreign key (id_empresa) references empresa (id)

alter table usuario_empresa add constraint FK62hh8xjf2yjsncl8ti6vxjm7h foreign key (id_usuario) references usuario (id)






