package com.torquato.workshopmongo.resources;

import com.torquato.workshopmongo.domain.User;
import com.torquato.workshopmongo.dto.UserDTO;
import com.torquato.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
