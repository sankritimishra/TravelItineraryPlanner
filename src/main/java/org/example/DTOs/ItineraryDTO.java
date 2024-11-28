package org.example.DTOs;

import java.util.Date;

public class ItineraryDTO {
    private Long itineraryId;
    private String title;
    private String description;
    private Date startDate;
    private Date endDate;
    private Long groupId;

    public ItineraryDTO(Long itineraryId, String title,String description, Date startDate, Date endDate, Long groupId) {
        this.itineraryId = itineraryId;
        this.title = title;
        this.endDate = endDate;
        this.startDate = startDate;
        this.description = description;
        this.groupId = groupId;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroup(Long groupId) {
        this.groupId = groupId;
    }

    public Long getItineraryId() {
        return itineraryId;
    }

    public void setItineraryId(Long itineraryId) {
        this.itineraryId = itineraryId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
