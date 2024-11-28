package org.example.Repositories;

import org.example.DTOs.GroupMembersDTO;
import org.example.DTOs.UserDetailsDTO;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class GroupMembersRepository {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public GroupMembersRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public void addNewMemberInGroup(Long groupId, GroupMembersDTO body) {
        String sql = "insert into groupMembers (groupId, userId) values(:groupId, :userId);";
        Map<String,Long> mpp = new HashMap<>();

        mpp.put("groupId", groupId);
        mpp.put("userId", body.getUserId());

        namedParameterJdbcTemplate.update(sql,mpp);
    }

    public List<UserDetailsDTO> getMembersInformation(Long groupId) {
        String sql = "SELECT u.*\n" +
                "FROM UserDetails u\n" +
                "INNER JOIN GroupMembers gm ON u.userId = gm.userId\n" +
                "WHERE gm.groupId = :groupId;";
        Map<String, Object> params = new HashMap<>();
        params.put("groupId", groupId);

        List<Map<String, Object>> results = namedParameterJdbcTemplate.queryForList(sql, params);

        return results.stream()
                .map(userDetails -> new UserDetailsDTO(
                        ((Number) userDetails.get("userId")).longValue(),
                        userDetails.get("userName").toString(),
                        userDetails.get("fullName") != null ? userDetails.get("fullName").toString() : null,
                        userDetails.get("email").toString(),
                        userDetails.get("age") != null ? ((Number) userDetails.get("age")).intValue() : null,
                        userDetails.get("phoneNumber") != null ? ((Number) userDetails.get("phoneNumber")).longValue() : null
                ))
                .collect(Collectors.toList());
    }

    public void removeMemberFromGroup(Long groupId, Long userId) {
        String sql = "delete from groupMembers where groupId = :groupId and userId = :userId;";
        Map<String,Long>mpp = new HashMap<>();

        mpp.put("groupId", groupId);
        mpp.put("userId", userId);

        namedParameterJdbcTemplate.update(sql,mpp);
    }
}
