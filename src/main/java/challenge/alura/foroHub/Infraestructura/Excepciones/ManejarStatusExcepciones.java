package challenge.alura.foroHub.Infraestructura.Excepciones;

import challenge.alura.foroHub.Presentacion.DTOs.Status.Status400DTO;
import challenge.alura.foroHub.Presentacion.DTOs.Status.Status403DTO;
import challenge.alura.foroHub.Presentacion.DTOs.Status.Status404DTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ManejarStatusExcepciones {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity manejarStatus404(){
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity manejarStatus400( MethodArgumentNotValidException e){

        var errors = e.getFieldErrors().stream().map(Status400DTO::new).toList();

        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(InternalAuthenticationServiceException.class)
    public ResponseEntity<Status403DTO> manejarStatus403(){
        return ResponseEntity.status(HttpStatusCode.valueOf(403)).body(new Status403DTO("Acción no autorizada"));
    }

    @ExceptionHandler(ValidacionExcepcion.class)
    public ResponseEntity<Status404DTO> manejarStatusValidacion404( ValidacionExcepcion e){
       return ResponseEntity.status(HttpStatusCode.valueOf(404)).body(new Status404DTO(e.getMessage()));
    }
}
