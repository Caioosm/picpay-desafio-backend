package com.picpaysimplificado.services;

import com.picpaysimplificado.domain.user.User;
import com.picpaysimplificado.domain.user.UserType;
import com.picpaysimplificado.dtos.UserDTO;
import com.picpaysimplificado.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void transactionValidation(User sender, BigDecimal amount) throws Exception{
        if (sender.getUserType() == UserType.MERCHANT) {
            throw new Exception("Usuario do tipo Lojista nao pode fazer transacao!");
        }
        if (sender.getBalance().compareTo(amount) < 0) {
            throw new Exception("Saldo insuficiente!");
        }
    }

    public User findUserById(Long id) throws Exception{
        return userRepository.findById(id).orElseThrow(() -> new Exception("Usuario nao encontrado!"));
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public User createUser(UserDTO userDTO) {
        User user = new User(userDTO);
        this.saveUser(user);
        return user;
    }

    public void saveUser(User user){
        this.userRepository.save(user);
    }
}
