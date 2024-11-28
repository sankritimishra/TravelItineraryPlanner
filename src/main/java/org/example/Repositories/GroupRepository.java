package org.example.Repositories;

import org.example.DTOs.GroupDTO;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class GroupRepository {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public GroupRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public void addNewGroupDetails(GroupDTO body) {
        String sql = "insert into groupInfo(groupId, groupName) values (:groupId, :groupName);";
        Map<String,Object>mpp = new HashMap<>();

        mpp.put("groupId", body.getGroupId());
        mpp.put("groupName", body.getGroupName());

        namedParameterJdbcTemplate.update(sql,mpp);
    }

    public void updateGroupDetails(Long groupId, GroupDTO body) {
        String sql = "update groupInfo set groupName = :groupName where groupId = :groupId;";
        Map<String,Object>mpp = new HashMap<>();

        mpp.put("groupId", groupId);
        mpp.put("groupName", body.getGroupName());

        namedParameterJdbcTemplate.update(sql,mpp);
    }

    public void deleteGroupDetails(Long groupId) {
        String sql = "delete from groupInfo where groupId = :groupId;";
        Map<String, Object>mpp = new HashMap<>();

        mpp.put("groupId", groupId);

        namedParameterJdbcTemplate.update(sql,mpp);

    }

    public GroupDTO getGroupInformation(Long groupId) {
        String sql = "select * from groupInfo where groupId = :groupId;";
        Map<String,Object>mpp = new HashMap<>();

        mpp.put("groupId", groupId);

        var groupInformation = namedParameterJdbcTemplate.queryForList(sql,mpp).get(0);

        return new GroupDTO((Long) groupInformation.get("groupId"), groupInformation.get("groupName").toString());
    }
}
