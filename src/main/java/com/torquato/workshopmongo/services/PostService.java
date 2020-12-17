package com.torquato.workshopmongo.services;

import com.torquato.workshopmongo.domain.Post;
import com.torquato.workshopmongo.repository.PostRepository;
import com.torquato.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    @Autowired
    private PostRepository repo;

    public Optional<Post> findById(String id){
        Optional<Post> post = repo.findById(id);
        if (!post.isPresent()){
            throw new ObjectNotFoundException("Objeto não encontrado");
        }
        return post;
    }

    public List<Post> finByTitle(String text){
        return repo.findByTitleContainingIgnoreCase(text);
    }

    public List<Post> finByTitulo(String text){
        return repo.findByTitulo(text);
    }

    public List<Post> fullSearch(String text, Date minDate, Date maxDate){
        maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
        return repo.fullSearch(text, minDate, maxDate);
    }
}
