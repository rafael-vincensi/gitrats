package com.gitrats.groups;

import jakarta.websocket.server.ServerEndpoint;
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

    @GetMapping("{/code}")
    public Group findByCode(@RequestParam String code){
        return groupService.findByCode(code);
    }

    @PutMapping("/{id}")
    public Group updateGroup(@RequestParam Long id, @RequestBody Group group){
        return groupService.groupUpdate(id, group);
    }

}
