ALTER TABLE topico
ADD COLUMN curso_id INT;

ALTER TABLE topico
ADD CONSTRAINT fk_curso FOREIGN KEY (curso_id) REFERENCES curso(id);
