package org.example.Services;

import org.example.DTOs.GroupMembersDTO;
import org.example.DTOs.UserDetailsDTO;
import org.example.Repositories.GroupMembersRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupMembersService {

    private final GroupMembersRepository groupMembersRepository;

    public GroupMembersService(GroupMembersRepository groupMembersRepository) {
        this.groupMembersRepository = groupMembersRepository;
    }

    public void addMember(Long groupId, GroupMembersDTO body) {
        groupMembersRepository.addNewMemberInGroup(groupId,body);
    }

    public List<UserDetailsDTO> getMembersDetails(Long groupId) {
        return groupMembersRepository.getMembersInformation(groupId);
    }

    public void removeMemberByGroupId(Long groupId, Long userId) {
        groupMembersRepository.removeMemberFromGroup(groupId,userId);
    }
}
