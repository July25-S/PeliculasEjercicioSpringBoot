package com.example.PeliculasEjercicioSpringBoot.domain.service;


import dev.langchain4j.service.SystemMessage;
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

    @SystemMessage("""
            Eres un experto en cine y tu tarea es recomendar películas a los usuarios.
            Basándote en el mensaje del usuario, sugiere una película que se ajuste a sus gustos.
            Proporciona el título de la película y una breve descripción de por qué la recomiendas.
            """)
    String generateMovieSuggestion(@UserMessage String userMessage);
}

