package com.gitrats.groups;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface GroupsRepository extends JpaRepository <Groups, Long> {
    Optional<Groups> findByCode(String code);
}
