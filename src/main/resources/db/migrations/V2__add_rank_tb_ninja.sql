-- V2: Migrations para adicionar a coluna de RANK na tabela de ninjas

alter table tb_ninja
add column rank varchar(255);