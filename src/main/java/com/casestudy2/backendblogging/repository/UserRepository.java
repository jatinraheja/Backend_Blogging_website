package com.casestudy2.backendblogging.repository;

import com.casestudy2.backendblogging.Modal.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
    public Optional<Users> findByEmail(String email);
    public Users findAllByUsername(String username);

}
