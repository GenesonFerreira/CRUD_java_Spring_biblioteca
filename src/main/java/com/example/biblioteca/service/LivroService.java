package com.example.biblioteca.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.biblioteca.entity.Livro;
import com.example.biblioteca.repository.LivroRepository;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {
    @Autowired
    private LivroRepository repository;

    public Livro create(Livro obj){
        return repository.save(obj);
    }

    public void delete(long id){
        repository.deleteById(id);
    }

    public Livro getId(long id){
        Optional<Livro> obj = repository.findById(id);
        return obj.get();
    }
    public List<Livro> getAll(){
        return repository.findAll();
    }
    public Livro update(Livro obj){
        Optional<Livro> newObj = repository.findById(obj.getId());
        updateLivro(newObj, obj);
        return repository.save(newObj.get());
    }
    private void updateLivro(Optional<Livro> newObj, Livro obj){
        newObj.get().setTitulo(obj.getTitulo());
    }
}
