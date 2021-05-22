CREATE TABLE usuario (
  id BIGINT PRIMARY KEY NOT NULL auto_increment,
  id_veiculo BIGINT NOT NULL,
  nome VARCHAR(60) NOT NULL,
  email VARCHAR(25) NOT NULL,
  cpf VARCHAR(11) NOT NULL,
  data_nascimento DATE NOT NULL,
  UNIQUE(email, cpf),
  CONSTRAINT fk_id_veiculo FOREIGN KEY (id_veiculo) REFERENCES veiculo(id)
);