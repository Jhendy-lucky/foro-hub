CREATE TABLE respuesta (
     id INT AUTO_INCREMENT PRIMARY KEY,
     comentario VARCHAR(300) NOT NULL,
     fecha DATETIME NOT NULL,
     usuario_id INT NOT NULL,
     FOREIGN KEY (usuario_id) REFERENCES usuario (id)
)