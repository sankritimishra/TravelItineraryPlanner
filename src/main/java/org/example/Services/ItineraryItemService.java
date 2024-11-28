package org.example.Services;

import org.example.DTOs.ItineraryItemDTO;
import org.example.Repositories.ItineraryItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItineraryItemService {

    private final ItineraryItemRepository itineraryItemRepository;


    public ItineraryItemService(ItineraryItemRepository itineraryItemRepository) {
        this.itineraryItemRepository = itineraryItemRepository;
    }


    public void addNewItem(ItineraryItemDTO body) {
        itineraryItemRepository.createNewItem(body);
    }

    public List<ItineraryItemDTO> getAllItemsByItineraryId(Long itineraryId) {
        return itineraryItemRepository.getAllItemDetails(itineraryId);
    }

    public void removeItemDetails(Long itemId) {
        itineraryItemRepository.removeItineraryItemByItemId(itemId);
    }

    public void updateItineraryItemDetails(Long itemId, ItineraryItemDTO body) {
        itineraryItemRepository.updateItineraryItemDetailsByItemId(itemId,body);
    }

    public ItineraryItemDTO getItemDetails(Long itemId, Long itineraryId) {
        return itineraryItemRepository.getItemInfo(itemId,itineraryId);
    }
}
