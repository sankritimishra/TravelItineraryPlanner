package org.example.Services;

import org.example.DTOs.GroupDTO;
import org.example.Repositories.GroupRepository;
import org.springframework.stereotype.Service;

@Service
public class GroupService {

    private final GroupRepository groupRepository;

    public GroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    public void createNewGroup(GroupDTO body) {
        groupRepository.addNewGroupDetails(body);
    }

    public void updateDetails(Long groupId, GroupDTO body) {
        groupRepository.updateGroupDetails(groupId ,body);
    }

    public void deleteGroup(Long groupId) {
        groupRepository.deleteGroupDetails(groupId);
    }

    public GroupDTO getGroupDetails(Long groupId) {
        return groupRepository.getGroupInformation(groupId);
    }
}
