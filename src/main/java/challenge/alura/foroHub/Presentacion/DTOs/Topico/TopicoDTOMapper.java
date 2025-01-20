package challenge.alura.foroHub.Presentacion.DTOs.Topico;

import challenge.alura.foroHub.Dominio.Topico;

import java.util.List;
import java.util.stream.Collectors;

public class TopicoDTOMapper {

    public static List<TopicoLecturaDTO> convertirTopicosATopicosLecturaDTO(List<Topico> topicos){
        return topicos.stream()
                .map(TopicoLecturaDTO::new)
                .collect(Collectors.toList());
    }

    public static  TopicoLecturaDTO convertirTopicoATopicoLecturaDTO(Topico topico){
        return new TopicoLecturaDTO(topico);
    }

    public static Topico convertirTopicoRegistroDTOATopico(TopicoRegistroDTO topicoRegistroDTO){
        return new Topico(topicoRegistroDTO);
    }

    public static Topico convertirTopicoActualizacionDTOATopico(TopicoActualizacionDTO topicoActualizacionDTO){
        return new Topico(topicoActualizacionDTO);
    }
}
