package org.example.Repositories;

import org.example.DTOs.ItineraryItemDTO;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;


import java.sql.Time;
import java.util.*;
import java.util.stream.Collectors;

@Repository
public class ItineraryItemRepository {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public ItineraryItemRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }


    public void createNewItem(ItineraryItemDTO body) {

        String sql = "insert into itineraryItem(itemId, itineraryId, title, description, dateOfTravel, startTime, endTime, modeOfTransportation, contact) values(:itemId, :itineraryId, :title, :description, :dateOfTravel, :startTime, :endTime, :modeOfTransportation, :contact);";
        Map<String, Object>mpp = new HashMap<>();

        mpp.put("itemId", body.getItemId());
        mpp.put("itineraryId", body.getItineraryId());
        mpp.put("title", body.getTitle());
        mpp.put("description", body.getDescription());
        mpp.put("dateOfTravel", body.getDateOfTravel());
        mpp.put("startTime", body.getStartTime());
        mpp.put("endTime", body.getEndTime());
        mpp.put("modeOfTransportation", body.getModeOfTransportation());
        mpp.put("contact", body.getContact());

        namedParameterJdbcTemplate.update(sql,mpp);
    }

    public List<ItineraryItemDTO> getAllItemDetails(Long itineraryId) {

        String sql = "select i.itemId, i.itineraryId, i.title, i.description, i.dateOfTravel, i.startTime, i.endTime, i.modeOfTransportation, i.contact\n" +
                "from itineraryItem i where itineraryId = :itineraryId;";

        Map<String,Object>mpp = new HashMap<>();
        mpp.put("itineraryId", itineraryId);

        List<Map<String,Object>> itemDetails = namedParameterJdbcTemplate.queryForList(sql,mpp);


        return itemDetails.stream()
                .map(itemInfo -> new ItineraryItemDTO(
                        ((Long) itemInfo.get("itemId")),
                        ((Long) itemInfo.get("itineraryId")),
                        itemInfo.get("title").toString(),
                        itemInfo.get("description").toString(),
                        (Date) itemInfo.get("dateOfTravel"),
                        ((Time) itemInfo.get("startTime")).toLocalTime(),
                        ((Time) itemInfo.get("endTime")).toLocalTime(),
                        itemInfo.get("modeOfTransportation").toString(),
                        (Long) itemInfo.get("contact")
                )).collect(Collectors.toList());
    }

    public void removeItineraryItemByItemId(Long itemId) {

        String sql = "delete from itineraryItem where itemId = :itemId;";
        Map<String,Object>mpp = new HashMap<>();
        mpp.put("itemId",itemId);

        namedParameterJdbcTemplate.update(sql,mpp);
    }

    public void updateItineraryItemDetailsByItemId(Long itemId, ItineraryItemDTO body) {

        String sql = "update itineraryItem set title = :title, description = :description, dateOfTravel = :dateOfTravel, " +
                "startTime = :startTime, endTime = :endTime, modeOfTransportation = :modeOfTransportation, " +
                "contact = :contact where itemId = :itemId;";

        Map<String,Object> mpp = new HashMap<>();
        mpp.put("itemId", itemId);
        mpp.put("itineraryId", body.getItineraryId());
        mpp.put("title", body.getTitle());
        mpp.put("description", body.getDescription());
        mpp.put("dateOfTravel", body.getDateOfTravel());
        mpp.put("startTime", body.getStartTime());
        mpp.put("endTime", body.getEndTime());
        mpp.put("modeOfTransportation", body.getModeOfTransportation());
        mpp.put("contact",body.getContact());

        namedParameterJdbcTemplate.update(sql,mpp);
    }

    public ItineraryItemDTO getItemInfo(Long itemId, Long itineraryId) {

        String sql = "select i.itemId, i.itineraryId, i.title, i.description, i.dateOfTravel, i.startTime, i.endTime, i.modeOfTransportation, i.contact\n" +
                "from itineraryItem i where itineraryId = :itineraryId and itemId = :itemId;";

        Map<String,Long>mpp = new HashMap<>();
        mpp.put("itemId",itemId);
        mpp.put("itineraryId",itineraryId);

        var itemDetail = namedParameterJdbcTemplate.queryForList(sql,mpp).get(0);

        return new ItineraryItemDTO((Long) itemDetail.get("itemId"), (Long) itemDetail.get("itineraryId"), itemDetail.get("title").toString(),
                itemDetail.get("description").toString(), (Date) itemDetail.get("dateOfTravel"), ((Time) itemDetail.get("startTime")).toLocalTime(),
                ((Time) itemDetail.get("endTime")).toLocalTime(), itemDetail.get("modeOfTransportation").toString(), (Long) itemDetail.get("contact"));
    }
}
