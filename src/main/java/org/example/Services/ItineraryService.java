package org.example.Services;

import org.example.DTOs.ItineraryDTO;
import org.example.Repositories.ItineraryRepository;
import org.springframework.stereotype.Service;

@Service
public class ItineraryService {

    private final ItineraryRepository itineraryRepository;

    public ItineraryService(ItineraryRepository itineraryRepository) {
        this.itineraryRepository = itineraryRepository;
    }

    public ItineraryDTO getItinerary(Integer itineraryId) {
        return itineraryRepository.getItineraryDetails(itineraryId);
    }

    public void addDetails(ItineraryDTO body) {
        itineraryRepository.addNewItineraryDetails(body);
    }

    public void updateDetails(Long itineraryId, ItineraryDTO body) {
        itineraryRepository.updateItineraryDetails(itineraryId,body);
    }

    public void deleteDetails(Long itineraryId){
        itineraryRepository.deleteItinerary(itineraryId);
    }
}
