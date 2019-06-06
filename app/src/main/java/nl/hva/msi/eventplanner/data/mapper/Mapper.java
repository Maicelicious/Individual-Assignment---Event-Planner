package nl.hva.msi.eventplanner.data.mapper;


import java.util.ArrayList;
import java.util.List;

import nl.hva.msi.eventplanner.data.event.database.entities.EventEntity;
import nl.hva.msi.eventplanner.data.event.model.EventResponse;
import nl.hva.msi.eventplanner.data.event.model.EventsItem;

public class Mapper {

    private static Mapper instance;

    private Mapper() {

    }

    public static Mapper getInstance() {
        if (instance == null) {
            instance = new Mapper();
            return instance;
        } else {
            return instance;
        }
    }

    public List<EventEntity> EventResponseToEntity(EventResponse eventResponse) {
        List<EventEntity> eventEntities = new ArrayList<>();

        if (eventResponse.getEmbedded() != null) {
            for (EventsItem eventsItem : eventResponse.getEmbedded().getEvents()) {
                EventEntity eventEntity = new EventEntity();
                if (eventsItem.getSales() != null) {
                    eventEntity.setTicketSaleState(eventsItem.getSales().getJsonMemberPublic().isStartTBD());
                    eventEntity.setSalesStartDateTime(eventsItem.getSales().getJsonMemberPublic().getStartDateTime());
                    eventEntity.setSalesEndDateTime(eventsItem.getSales().getJsonMemberPublic().getEndDateTime());
                } else {
                    eventEntity.setTicketSaleState(false);
                    eventEntity.setSalesEndDateTime("not present");
                    eventEntity.setSalesStartDateTime("not present");
                }
                eventEntity.setUrl(eventsItem.getUrl());
                if (eventsItem.getDates() != null) {
                    eventEntity.setStatusCode(eventsItem.getDates().getStatus().getCode());
                } else {
                    eventEntity.setStatusCode("not present");
                }
                eventEntity.setName(eventsItem.getName());
                eventEntity.setId(eventsItem.getId());

                if (eventsItem.getImages() != null) {
                    eventEntity.setImageUrl(eventsItem.getImages().get(0).getUrl());
                } else {
                    eventEntity.setImageUrl("not present");
                }
                eventEntity.setCity(eventsItem.getEmbedded().getVenues().get(0).getCity().getName());
                if (eventsItem.getEmbedded() != null && eventsItem.getEmbedded().getVenues() != null) {
                    eventEntity.setAdress(eventsItem.getEmbedded().getVenues().get(0).getAddress().getLine1());
                    eventEntity.setCountryCode(eventsItem.getEmbedded().getVenues().get(0).getCountry().getCountryCode());
                    eventEntity.setCountry(eventsItem.getEmbedded().getVenues().get(0).getCountry().getName());
                } else {
                    eventEntity.setAdress("not present");
                    eventEntity.setCity("not present");
                    eventEntity.setCountry("not present");
                }
                eventEntity.setStartDate(eventsItem.getDates().getStart().getDateTime());
                if (eventsItem.getClassifications() != null) {
                    eventEntity.setGenre(eventsItem.getClassifications().get(0).getGenre().getName());
                } else {
                    eventEntity.setGenre("not present");
                }
                if (eventsItem.getPriceRanges() != null) {
                    eventEntity.setPriceMax(eventsItem.getPriceRanges().get(0).getMax());
                    eventEntity.setPriceMin(eventsItem.getPriceRanges().get(0).getMin());
                } else {
                    eventEntity.setPriceMin(-1.0);
                    eventEntity.setPriceMax(-1.0);
                }
                eventEntities.add(eventEntity);
            }
        }


        return eventEntities;
    }


}
