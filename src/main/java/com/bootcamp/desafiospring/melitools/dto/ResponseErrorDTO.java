package com.bootcamp.desafiospring.melitools.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseErrorDTO {
    private String nombre;
    private String descripcion;

    @Override
    public String toString() {
        return "ErrorDTO{" +
                "nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
