package com.alexktp.chaywela.service.implementation;

import com.alexktp.chaywela.model.User;
import com.alexktp.chaywela.repository.UserRepository;
import com.alexktp.chaywela.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepo;

    @Override
    public User create(User user) {
        log.info("Creating a user: {}", user.getUsername());
        return userRepo.save(user);
    }

    @Override
    public User get(Long id) {
        log.info("Fetching a user by ID: {}", id);
        return userRepo.findById(id).get();
    }

    @Override
    public User update(User user) {
        log.info("Updating a user: {}", user.getUsername());
        return userRepo.save(user);
    }

    @Override
    public Boolean delete(Long id) {
        log.info("Deleting a user by ID: {}", id);
        userRepo.deleteById(id);
        return Boolean.TRUE;
    }

    @Override
    public Collection<User> getAll(int limit) {
        log.info("Fetching all users");
        return userRepo.findAll();
    }
}
