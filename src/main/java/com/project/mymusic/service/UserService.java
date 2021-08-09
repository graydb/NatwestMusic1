package com.project.mymusic.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.mymusic.model.User;
import com.project.mymusic.repository.UserRepository;
@Service
public class UserService {
@Autowired
 private UserRepository repo;
public List<User> searchAll() {
 return this.repo.findAll();
 }
public User searchById(Long id) {
 Optional<User> obj = this.repo.findById(id);
 return obj.orElseThrow(null);
}
public User create(User obj) {
 return this.repo.save(obj);
 }
public User update(User obj) {
 this.searchById(obj.getId());
 return this.repo.save(obj);
 }
public void delete(Long id) {
 this.searchById(id);
 this.repo.deleteById(id);
 }
}