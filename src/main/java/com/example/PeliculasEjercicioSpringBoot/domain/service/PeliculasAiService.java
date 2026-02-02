package com.example.PeliculasEjercicioSpringBoot.domain.service;


import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;
import dev.langchain4j.service.spring.AiService;

@AiService
public interface PeliculasAiService {

    @UserMessage("""
            Genera un saludo de bienvenida a la plataforma de Gestión de Películas {{plataform}}.
            Usa menos de 120 caracteres y hazlo con el estilo de Platzi.
            """)
    String generateGreeting(@V("plataform") String plataform);
}

