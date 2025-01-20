package challenge.alura.foroHub.Presentacion.DTOs.Status;

import org.springframework.validation.FieldError;

public record Status400DTO(

        String campo,
        String error
) {

    public Status400DTO(FieldError fieldError){
        this(fieldError.getField(), fieldError.getDefaultMessage());
    }
}
