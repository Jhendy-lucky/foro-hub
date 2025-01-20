ALTER TABLE respuesta
ADD COLUMN topico_id INT;

ALTER TABLE respuesta
ADD CONSTRAINT fk_topico FOREIGN KEY (topico_id) REFERENCES topico(id);
