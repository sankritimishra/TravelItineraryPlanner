package org.example.Controllers;

import org.example.DTOs.GroupMembersDTO;
import org.example.DTOs.UserDetailsDTO;
import org.example.Services.GroupMembersService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GroupMembersController {

    private final GroupMembersService groupMembersService;

    public GroupMembersController(GroupMembersService groupMembersService) {
        this.groupMembersService = groupMembersService;
    }


    @PostMapping("/groupMembers/addMember/{groupId}")
    public void addMemberByGroupId(@PathVariable("groupId") Long groupId, @RequestBody GroupMembersDTO body){
        groupMembersService.addMember(groupId,body);
    }

    @DeleteMapping("/groupMembers/removeMembers/{groupId}/{userId}")
    public void removeMember(@PathVariable("groupId") Long groupId, @PathVariable("userId") Long userId){
        groupMembersService.removeMemberByGroupId(groupId,userId);

    }

    @GetMapping("/groupMembers/details/{groupId}")
    public List<UserDetailsDTO> getAllMemberDetails(@PathVariable("groupId") Long groupId){
        return groupMembersService.getMembersDetails(groupId);
    }


}
