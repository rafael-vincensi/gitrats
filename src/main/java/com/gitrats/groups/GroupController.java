package com.gitrats.groups;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/group")
public class GroupController {

    private GroupService groupService;

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @PostMapping
    public Group createGroup(@RequestBody Group group){
        return groupService.createGroup(group);
    }

    @GetMapping("/{id}")
    public Group findGroupById(Long id){
        return groupService.findGroupById(id);
    }

    @GetMapping("/{code}")
    public Group findByCode(@PathVariable String code){
        return groupService.findByCode(code);
    }

    @PutMapping("/{id}")
    public Group updateGroup(@PathVariable Long id, @RequestBody Group group){
        return groupService.groupUpdate(id, group);
    }

    @DeleteMapping("/{id}")
    public void deleteGroup(@PathVariable Long id){
        groupService.deleteGroup(id);
    }
}

