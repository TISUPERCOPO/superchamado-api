create table categoria (
id integer not null auto_increment,
descricao varchar(255),
status bit,
tenant_id integer,
primary key (id)
) engine=InnoDB default charset=utf8MB4; 

create table chamado (
id integer not null auto_increment,
descricao varchar(255),
status bit,
titulo varchar(255),
categoria_id integer,
setor_id integer,
tenant_id integer,
primary key (id)
) engine=InnoDB default charset=utf8MB4; 

create table classepermissao (
id integer not null auto_increment,
nome varchar(255),
primary key (id)
) engine=InnoDB default charset=utf8MB4; 

create table codigo (
id integer not null auto_increment,
codigo varchar(255),
telefone varchar(255),
primary key (id)
) engine=InnoDB default charset=utf8MB4; 

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
) engine=InnoDB default charset=utf8MB4; 

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
) engine=InnoDB default charset=utf8MB4; 

create table permissao (
id integer not null auto_increment,
descricao varchar(255),
classepermissao_id integer,
primary key (id)
) engine=InnoDB default charset=utf8MB4; 

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
) engine=InnoDB default charset=utf8MB4; 

create table setor (
id integer not null auto_increment,
descricao varchar(255),
status bit,
tenant_id integer,
primary key (id)
) engine=InnoDB default charset=utf8MB4; 

create table tenant (
id integer not null auto_increment,
descricao varchar(255),
primary key (id)
) engine=InnoDB default charset=utf8MB4; 

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
) engine=InnoDB default charset=utf8MB4; 

create table usuario_permissao (
id_usuario integer not null,
id_permissao integer not null
) engine=InnoDB default charset=utf8MB4; 

create table usuario_empresa (
empresapadrao bit,
tenant_id integer,
id_empresa integer not null,
id_usuario integer not null,
primary key (id_empresa, id_usuario)
) engine=InnoDB default charset=utf8MB4; 

alter table empresa add constraint UK_ow6ddx531a4abnwv6eah7h3k7 unique (cpfoucnpj);

alter table categoria add constraint FK_categoriaTenant foreign key (tenant_id) references tenant (id);

alter table chamado add constraint FK_chamadoCategoria foreign key (categoria_id) references categoria (id);

alter table chamado add constraint FK_chamadoSetor foreign key (setor_id) references setor (id);

alter table chamado add constraint FK_chamadoTenant foreign key (tenant_id) references tenant (id);

alter table log_sistema add constraint FK_logsistemaCategoria foreign key (categoria_id) references categoria (id);

alter table log_sistema add constraint FK_logsistemaChamado foreign key (chamado_id) references chamado (id);

alter table log_sistema add constraint FK_logsistemaEmpresa foreign key (empresa_id) references empresa (id);

alter table log_sistema add constraint FK_logsistemaPermissao foreign key (permissao_id) references permissao (id);

alter table log_sistema add constraint FK_logsistemaSac foreign key (sac_id) references sac (id);

alter table log_sistema add constraint FK_logsistemaSetor foreign key (setor_id) references setor (id);

alter table log_sistema add constraint FK_logsistemaTenant foreign key (tenant_id) references tenant (id);

alter table log_sistema add constraint FK_logsistemaUsuario foreign key (usuario_id) references usuario (id);

alter table permissao add constraint FK_permissaoClassepermisao foreign key (classepermissao_id) references classepermissao (id);

alter table sac add constraint FK_sacTenant foreign key (tenant_id) references tenant (id);

alter table setor add constraint FK_setorTenant foreign key (tenant_id) references tenant (id);

alter table usuario add constraint FK_usuarioTenant foreign key (tenant_id) references tenant (id);

alter table usuario_permissao add constraint FK_usuariopermissaiPermissao foreign key (id_permissao) references permissao (id);

alter table usuario_permissao add constraint FK_usuariopermissaoUsuario foreign key (id_usuario) references usuario (id);

alter table usuario_empresa add constraint FK_usuarioempresaEmpresa foreign key (id_empresa) references empresa (id);

alter table usuario_empresa add constraint FK_usuarioempresaUsuario foreign key (id_usuario) references usuario (id);






