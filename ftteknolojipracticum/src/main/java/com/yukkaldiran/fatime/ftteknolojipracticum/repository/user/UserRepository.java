package com.yukkaldiran.fatime.ftteknolojipracticum.repository.user;

import com.yukkaldiran.fatime.ftteknolojipracticum.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
