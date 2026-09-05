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

    public Group findGroupById(Long id){
        Optional<Group> group = groupRepository.findById(id);
        return group.orElse(null);
    }

    public void deleteGroup(Long id){
        groupRepository.deleteById(id);
    }

    public Group groupUpdate(Long id, Group groupUpdate){
        Optional<Group> groupOpt = groupRepository.findById(id);

        if (groupOpt.isPresent()){

            Group group = groupOpt.get();

            if (groupUpdate.getName() != null) group.setName(groupUpdate.getName());
            if (groupUpdate.getGroupPicture() != null) group.setGroupPicture(groupUpdate.getGroupPicture());

            return groupRepository.save(group);
        }
        return null;
    }
}
