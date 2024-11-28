package org.example.Controllers;

import org.example.DTOs.ItineraryDTO;
import org.example.Services.ItineraryService;
import org.springframework.web.bind.annotation.*;

@RestController
public class ItineraryController {

   private final ItineraryService itineraryService;

    public ItineraryController(ItineraryService itineraryService) {
        this.itineraryService = itineraryService;
    }

    @GetMapping("itinerary/info/{itineraryId}")
    public ItineraryDTO getItineraryById(@PathVariable("itineraryId") Integer itineraryId){
      return itineraryService.getItinerary(itineraryId);
   }

   @PostMapping("/itinerary/addItinerary")
   public void createNewItinerary(@RequestBody ItineraryDTO body){
        itineraryService.addDetails(body);
   }

   @PostMapping("/itinerary/updateItinerary/{itineraryId}")
   public void updateItinerary(@PathVariable("itineraryId") Long itineraryId, @RequestBody ItineraryDTO body){
        itineraryService.updateDetails(itineraryId,body);
   }

   @DeleteMapping("/itinerary/deleteItinerary/{itineraryId}")
   public void deleteItinerary(@PathVariable("itineraryId") Long itineraryId){
        itineraryService.deleteDetails(itineraryId);
   }
}
