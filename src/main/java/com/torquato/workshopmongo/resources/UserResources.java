package com.torquato.workshopmongo.resources;

import com.torquato.workshopmongo.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value="/users")
public class UserResources {

    @GetMapping("/lista")
    public ResponseEntity<List<User>> findAll(){
        User maria = new User("1","maria","teste@teste");
        User alex = new User("2","alex","alex@teteste");
        List<User> list = new ArrayList<>();
        list.addAll(Arrays.asList(maria,alex));
        return ResponseEntity.ok(list);
    }
}
