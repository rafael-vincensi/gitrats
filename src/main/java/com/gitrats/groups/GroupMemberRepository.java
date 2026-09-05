package com.gitrats.groups;

import com.gitrats.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface GroupMemberRepository extends JpaRepository <GroupMember, Long> {
    Optional<GroupMember> findByUserAndGroup(User user, Group group);
}
