package com.torquato.workshopmongo.resources;

import com.torquato.workshopmongo.domain.User;
import com.torquato.workshopmongo.dto.UserDTO;
import com.torquato.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="/users")
public class UserResources {

    @Autowired
    private UserService userService;

    @GetMapping("/lista")
    public ResponseEntity<List<UserDTO>> findAll(){

        List<User> list = userService.findAll();
        List<UserDTO> listDto = list.stream().map( x -> new UserDTO(x)).collect(Collectors.toList());

        return ResponseEntity.ok(listDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable String id){

        Optional<User> user = userService.findById(id);

        return ResponseEntity.ok(new UserDTO(user.get()));
    }

    @PostMapping
    public ResponseEntity<Void> insertUser(@RequestBody UserDTO objDTO){


        User user = userService.fromDto(objDTO);
        user = userService.insert(user);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id){

        userService.deleteUser(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updatetUser(@RequestBody UserDTO objDTO,@PathVariable String id){


        User user = userService.fromDto(objDTO);
        user.setId(id);
        user = userService.updateUser(user);

        return ResponseEntity.noContent().build();
    }
}
