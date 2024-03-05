set foreign_key_checks = 0;
set sql_safe_updates=0;
delete from classepermissao;
delete from config;
delete from empresa;
delete from log_sistema;
delete from permissao;
delete from tenant;
delete from usuario; 
delete from usuario_permissao;
delete from usuario_empresa;


set foreign_key_checks = 1;
alter table classepermissao auto_increment = 1;
alter table classepermissao auto_increment = 1;
alter table log_sistema auto_increment = 1;
alter table permissao auto_increment = 1;
alter table usuario auto_increment = 1;

INSERT INTO classepermissao VALUES (1,'Empresa',NULL,NULL),(2,'Usuario',NULL,NULL),(3,'Relatório',NULL,NULL);
INSERT INTO permissao VALUES (1,'C_EMP',NULL),(2,'U_EMP',NULL),(3,'D_EMP',NULL),(4,'R_EMP',NULL),(5,'S_EMP',NULL),(6,'C_USU',NULL),(7,'U_USU',NULL),(8,'D_USU',NULL),(9,'R_USU',NULL),(10,'S_USU',NULL)(11,'R_REL',NULL),(12,'C_SAC',NULL),(13,'U_SAC',NULL),(14,'D_SAC',NULL),(15,'R_SAC',NULL),(16,'S_SAC',NULL);

INSERT INTO usuario VALUES (1, 'RRIBEIRO', 'ROMARIO RIBEIRO', '$2a$10$rYIYsiBh5LGrxud5mAcS4O.LcDalEwfl.TsgWASdWRV3FGdToiVQ.', 1, 1, 0, 1, NULL),(3,'Controle','Controle','1',1,0,1,0,NULL);

INSERT INTO usuario_permissao VALUES 
(1,1),(1,2),(1,3),(1,4),(1,5),(1,6),(1,7),(1,8),(1,9),(1,10),
(1,11),(1,12),(1,13),(1,14),(1,15),(1,16);

INSERT INTO tenant (id, descricao) VALUES ('1', 'GASOT E MARQUES SERVICO DE RADIOLOGIA LTDA');

INSERT INTO empresa (id, cidade, razaosocial, cpfoucnpj, naturezapessoa, uf, cep, logradouro, numero, bairro, whats, tenant_id,status, editar) 
VALUES ('1', 'ARAPONGAS', 'GASOT E MARQUES SERVICO DE RADIOLOGIA LTDA', '35502138000173', 'JURIDICA', 'PR', '86703530', 'PEPIRA DE CRISTA AMARELA', '81', 'VILA COELHO', '(43)9841-18809', '1', '1', '1');
INSERT INTO usuario_empresa (id_usuario, id_empresa, empresapadrao, tenant_id) VALUES ('1', '1', '1', '1');

set foreign_key_checks = 1;