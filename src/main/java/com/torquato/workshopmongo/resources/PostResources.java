package com.torquato.workshopmongo.resources;

import com.torquato.workshopmongo.domain.Post;
import com.torquato.workshopmongo.domain.User;
import com.torquato.workshopmongo.dto.UserDTO;
import com.torquato.workshopmongo.resources.util.URL;
import com.torquato.workshopmongo.services.PostService;
import com.torquato.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="/posts")
public class PostResources {

    @Autowired
    private PostService postService;

    @GetMapping("/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id){

        Optional<Post> post = postService.findById(id);

        return ResponseEntity.ok(post.get());
    }

    @GetMapping("/titlesearch")
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value="text",defaultValue = "") String text){

        text = URL.decodeParam(text);

        List<Post> posts = postService.finByTitle(text);

        return ResponseEntity.ok(posts);
    }

    @GetMapping("/titulosearch")
    public ResponseEntity<List<Post>> findByTitulo(@RequestParam(value="text",defaultValue = "") String text){

        text = URL.decodeParam(text);

        List<Post> posts = postService.finByTitulo(text);

        return ResponseEntity.ok(posts);
    }

    @GetMapping("/fullsearch")
    public ResponseEntity<List<Post>> fullSearch(@RequestParam(value="text",defaultValue = "") String text,
                                                 @RequestParam(value="minDate",defaultValue = "") String minDate,
                                                 @RequestParam(value="maxDate",defaultValue = "") String maxDate){

        text = URL.decodeParam(text);
        Date min = URL.convertDate(minDate, new Date(0L));
        Date max = URL.convertDate(maxDate, new Date());

        List<Post> posts = postService.fullSearch(text, min, max);

        return ResponseEntity.ok(posts);
    }
}
