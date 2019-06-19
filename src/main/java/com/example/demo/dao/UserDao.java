package com.example.demo.dao;

import com.example.demo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by okten28 on 6/19/19.
 */

@Repository
public interface UserDao extends JpaRepository<User, Integer> {
}
