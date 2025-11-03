package com.example.biblioteca.config;

import com.example.biblioteca.entity.Autor;
import com.example.biblioteca.entity.Livro;
import com.example.biblioteca.repository.AutorRepository;
import com.example.biblioteca.repository.LivroRepository;
import com.example.biblioteca.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private AutorRepository autorRepository;
    @Autowired
    private LivroRepository livroRepository;


    @Override
    public void run(String... args) throws Exception {

        Autor a1 = new Autor(null,"Carlos");
        Autor a2 = new Autor(null,"Rodrigo");

        autorRepository.saveAll(Arrays.asList(a1,a2));

        Livro l1 = new Livro(null,"Senhor dos Aneis",a1);
        Livro l2 = new Livro(null,"MadMax 2",a2);

        livroRepository.saveAll(Arrays.asList(l1,l2));

    }

}
