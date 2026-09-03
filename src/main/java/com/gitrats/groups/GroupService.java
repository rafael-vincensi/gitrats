package com.gitrats.groups;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GroupService {

    private GroupRepository groupRepository;

    public GroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    public Group createGroup(Group group){
        return groupRepository.save(group);
    }

    public Group findByCode(String code){
        Optional<Group> group = groupRepository.findByCode(code);
        return group.orElse(null);
    }

}
