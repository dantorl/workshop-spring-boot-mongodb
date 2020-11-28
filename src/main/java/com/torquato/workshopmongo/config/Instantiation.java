package com.torquato.workshopmongo.config;

import com.torquato.workshopmongo.domain.Post;
import com.torquato.workshopmongo.domain.User;
import com.torquato.workshopmongo.dto.AuthorDTO;
import com.torquato.workshopmongo.repository.PostRepository;
import com.torquato.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria,alex,bob));

        Post post1 = new Post(null, sdf.parse("21/03/2018"), "teste", "teste",new AuthorDTO(maria));
        Post post2 = new Post(null, sdf.parse("21/04/2018"), "teste 2", "teste body",new AuthorDTO(maria));
        postRepository.saveAll(Arrays.asList(post1,post2));

    }
}
