package com.example.PeliculasEjercicioSpringBoot.presistence.mapper;

import com.example.PeliculasEjercicioSpringBoot.domain.Genere;
import org.mapstruct.Named;

public class GenereMapper {

    @Named("stringToGenere")
    public static Genere stringToGenere(String genere) {
        if (genere == null) return null;
        return switch (genere.toUpperCase()) {
            case "ACCION" -> Genere.ACTION;
            case "COMEDY" -> Genere.COMEDY;
            case "DRAMA" -> Genere.DRAMA;
            case "ANIMACION" -> Genere.ANIMATE;
            case "HORROR" -> Genere.HORROR;
            case "CIENCIA FICCION" -> Genere.CSI_FI;
            case "ROMANCE" -> Genere.ROMANCE;
            case "MUSICAL" -> Genere.MUSICAL;
            case "THRILLER" -> Genere.THRILLER;
            case "FANTASIA" -> Genere.FANTASIA;
            case "AVENTURA" -> Genere.ADVENTURE;
            default -> null; // O puedes lanza una excepción si el género no es válido
        };
    }
    @Named("genereToString")
    public static String genereToString(Genere genere) {
        if (genere == null) return null;
        return switch (genere){
            case ACTION -> "ACCION";
            case COMEDY -> "COMEDY";
            case DRAMA -> "DRAMA";
            case ANIMATE -> "ANIMACION";
            case HORROR -> "HORROR";
            case CSI_FI -> "CIENCIA FICCION";
            case ROMANCE -> "ROMANCE";
            case MUSICAL -> "MUSICAL";
            case ADVENTURE -> "AVENTURA";
            case THRILLER -> "THRILLER";
            case FANTASIA -> "FANTASIA";
        };
    }
}
