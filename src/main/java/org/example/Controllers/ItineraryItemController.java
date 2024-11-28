package org.example.Controllers;

import org.example.DTOs.ItineraryDTO;
import org.example.DTOs.ItineraryItemDTO;
import org.example.Services.ItineraryItemService;
import org.example.Services.ItineraryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ItineraryItemController {

    private final ItineraryItemService itineraryItemService;

    public ItineraryItemController(ItineraryItemService itineraryItemService) {
        this.itineraryItemService = itineraryItemService;
    }

    @PostMapping("/ItineraryItem/addNewItem")
    public void addItineraryItem(@RequestBody ItineraryItemDTO body){
        itineraryItemService.addNewItem(body);
    }

    @DeleteMapping("/ItineraryItem/removeItem/{itemId}")
    public void removeItineraryItem(@PathVariable("itemId") Long itemId){
        itineraryItemService.removeItemDetails(itemId);
    }

    @PostMapping("/ItineraryItem/updateItem/{itemId}")
    public void updateItineraryItem(@PathVariable("itemId") Long itemId, @RequestBody ItineraryItemDTO body){
        itineraryItemService.updateItineraryItemDetails(itemId,body);
    }

    @GetMapping("/ItineraryItem/getAllItems/{itineraryId}")
    public List<ItineraryItemDTO> getAllItemDetailsByItinerayId(@PathVariable("itineraryId") Long itineraryId){
        return itineraryItemService.getAllItemsByItineraryId(itineraryId);
    }

    @GetMapping("/ItineraryItem/getItemDetail/{itemId}/{itineraryId}")
    public ItineraryItemDTO getItemDetailsByItemId(@PathVariable("itemId") Long itemId,@PathVariable("itineraryId") Long itineraryId){
        return itineraryItemService.getItemDetails(itemId,itineraryId);
    }
}
