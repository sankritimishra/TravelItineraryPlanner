package org.example.Repositories;

import org.example.DTOs.ItineraryDTO;
import org.example.DTOs.ItineraryItemDTO;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Repository
public class ItineraryRepository {
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public ItineraryRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public ItineraryDTO getItineraryDetails(Integer itineraryId) {
        String sql = "select * from itinerary where itineraryId = :itineraryId";
        Map<String,Object> mpp = new HashMap<>();
        mpp.put("itineraryId", itineraryId);
        var itineraryDetails = namedParameterJdbcTemplate.queryForList(sql,mpp).get(0);
        return new ItineraryDTO((Long) itineraryDetails.get("itineraryId"),itineraryDetails.get("title").toString(),itineraryDetails.get("description").toString(), (Date) itineraryDetails.get("startDate"), (Date) itineraryDetails.get("endDate"), (Long)itineraryDetails.get("groupId"));
    }

    public void addNewItineraryDetails(ItineraryDTO body) {

        java.util.Date utilStartDate = body.getStartDate();
        java.util.Date utilEndDate = body.getEndDate();

        if (utilStartDate == null || utilEndDate == null) {
            throw new IllegalArgumentException("Start date and end date must not be null");
        }

        java.sql.Date sqlStartDate = new java.sql.Date(utilStartDate.getTime());
        java.sql.Date sqlEndDate = new java.sql.Date(utilEndDate.getTime());


        String sql = "insert into itinerary (title, description, startDate, endDate, groupId) " +
                "values (:title, :description, :startDate, :endDate, :groupId);";


        Map<String, Object> mpp = new HashMap<>();
        mpp.put("title", body.getTitle());
        mpp.put("description", body.getDescription());
        mpp.put("startDate", sqlStartDate);
        mpp.put("endDate", sqlEndDate);
        mpp.put("groupId", body.getGroupId());

        namedParameterJdbcTemplate.update(sql, mpp);
    }

    public void updateItineraryDetails(Long itineraryId, ItineraryDTO body) {

        String sql = "update itinerary set title = :title, description = :description, startDate = :startDate, endDate = :endDate, groupId = :groupId where itineraryId = :itineraryId; ";

        Map<String, Object> mpp = new HashMap<>();
        mpp.put("itineraryId", itineraryId);
        mpp.put("title", body.getTitle());
        mpp.put("description", body.getDescription());
        mpp.put("startDate", body.getStartDate());
        mpp.put("endDate", body.getEndDate());
        mpp.put("groupId", body.getGroupId());

        namedParameterJdbcTemplate.update(sql,mpp);

    }

    public void deleteItinerary(Long itineraryId){

        String sql = "delete from itinerary where itineraryId = :itineraryId";
        Map<String, Long>mpp = new HashMap<>();
        mpp.put("itineraryId", itineraryId);

        namedParameterJdbcTemplate.update(sql,mpp);
    }



}
