package org.example.Controllers;

import org.example.DTOs.GroupDTO;
import org.example.Services.GroupService;
import org.springframework.web.bind.annotation.*;

@RestController
public class GroupController {

    private final GroupService groupService;

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping("/group/groupDetails/{groupId}")
    public GroupDTO getGroupDetailsByGroupId(@PathVariable("groupId") Long groupId){
        return groupService.getGroupDetails(groupId);
    }

    @PostMapping("/group/createGroup")
    public void createGroup(@RequestBody GroupDTO body){
        groupService.createNewGroup(body);
    }

    @PostMapping("/group/updateDetails/{groupId}")
    public void updateGroupName(@PathVariable("groupId") Long groupId,@RequestBody GroupDTO body){
        groupService.updateDetails(groupId, body);
    }

    @DeleteMapping("/group/deleteGroup/{groupId}")
    public void deleteGroup(@PathVariable("groupId") Long groupId){
        groupService.deleteGroup(groupId);
    }
}
