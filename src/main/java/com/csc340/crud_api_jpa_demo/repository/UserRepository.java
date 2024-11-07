package com.csc340.crud_api_jpa_demo.repository;


import com.csc340.crud_api_jpa_demo.objects.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
