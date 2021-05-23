CREATE TABLE usuario (
  id BIGINT PRIMARY KEY NOT NULL auto_increment,
  nome VARCHAR(60) NOT NULL,
  email VARCHAR(25) NOT NULL,
  cpf VARCHAR(11) NOT NULL,
  data_nascimento DATE NOT NULL,
  UNIQUE(email, cpf)
);