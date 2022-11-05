package com.user.UserService.reposotory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.user.UserService.Entity.User_1;

@Repository
public interface UserReposotory extends JpaRepository<User_1, Long>{

}
