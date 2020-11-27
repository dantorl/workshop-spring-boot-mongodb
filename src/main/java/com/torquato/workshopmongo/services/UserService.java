package com.torquato.workshopmongo.services;

import com.torquato.workshopmongo.domain.User;
import com.torquato.workshopmongo.dto.UserDTO;
import com.torquato.workshopmongo.repository.UserRepository;
import com.torquato.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.soap.SOAPBinding;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repo;

    public List<User> findAll(){
        return repo.findAll();
    }

    public Optional<User> findById(String id){
        Optional<User> user = repo.findById(id);
        if (!user.isPresent()){
            throw new ObjectNotFoundException("Objeto não encontrado");
        }
        return user;
    }

    public User insert(User obj){
        return repo.insert(obj);
    }

    public User fromDto(UserDTO objDto){
        return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
    }
}
