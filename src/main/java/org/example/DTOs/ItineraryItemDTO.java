package org.example.DTOs;

import java.time.LocalTime;
import java.util.Date;

public class ItineraryItemDTO {
    private Long itemId;
    private Long itineraryId;
    private String title;
    private String description;
    private Date dateOfTravel;
    private LocalTime startTime;
    private LocalTime endTime;
    private String modeOfTransportation;
    private Long contact;


    public ItineraryItemDTO(Long itemId, Long itineraryId, String title, String description, Date dateOfTravel, LocalTime startTime, LocalTime endTime, String modeOfTransportation, Long contact) {
        this.itemId = itemId;
        this.itineraryId = itineraryId;
        this.title = title;
        this.description = description;
        this.dateOfTravel = dateOfTravel;
        this.startTime = startTime;
        this.endTime = endTime;
        this.modeOfTransportation = modeOfTransportation;
        this.contact = contact;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateOfTravel() {
        return dateOfTravel;
    }

    public void setDateOfTravel(Date dateOfTravel) {
        this.dateOfTravel = dateOfTravel;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public String getModeOfTransportation() {
        return modeOfTransportation;
    }

    public void setModeOfTransportation(String modeOfTransportation) {
        this.modeOfTransportation = modeOfTransportation;
    }

    public Long getContact() {
        return contact;
    }

    public void setContact(Long contact) {
        this.contact = contact;
    }
}
