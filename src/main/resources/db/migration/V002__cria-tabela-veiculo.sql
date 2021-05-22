CREATE TABLE veiculo (
  id BIGINT PRIMARY KEY NOT NULL auto_increment,
  id_usuario BIGINT NOT NULL,
  marca VARCHAR(20) NOT NULL,
  modelo VARCHAR(60) NOT NULL,
  ano DATE NOT NULL,
  CONSTRAINT fk_id_usuario FOREIGN KEY (id_usuario) REFERENCES usuario(id)
);