package com.gitrats.user;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface UserRepository extends JpaRepository <User, Long> {
    List<User> findByUsernameContainingIgnoreCaseOrDisplayNameContainingIgnoreCase (String username, String displayName);
}
