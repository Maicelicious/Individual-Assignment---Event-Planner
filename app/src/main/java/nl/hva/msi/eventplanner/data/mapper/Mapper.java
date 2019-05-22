package nl.hva.msi.eventplanner.data.mapper;


import nl.hva.msi.eventplanner.data.event.database.EventEntity;
import nl.hva.msi.eventplanner.data.event.model.Event;

public class Mapper {

    private static Mapper instance;

    public Mapper getInstance(){
        if (instance == null) {
            instance = new Mapper();
            return instance;
        } else {
            return instance;
        }
    }

    public EventEntity mapEventtoEntityEvent(Event event){
        EventEntity eventEntity = new EventEntity();
        eventEntity.set_embedded(event.get_embedded());
        eventEntity.set_links(event.get_links());
        eventEntity.setClassifications(event.getClassifications());
        eventEntity.setDates(event.getDates());
        eventEntity.setId(event.getId());
        eventEntity.setImages(event.getImages());
        eventEntity.setLocale(event.getLocale());
        eventEntity.setName(event.getName());
        eventEntity.setPleaseNote(event.getPleaseNote());
        eventEntity.setPriceRanges(event.getPriceRanges());
        eventEntity.setPromoter(event.getPromoter());
        eventEntity.setPromoters(event.getPromoters());
        eventEntity.setSales(event.getSales());
        eventEntity.setSeatmap(event.getSeatmap());
        eventEntity.setTest(event.getTest());
        eventEntity.setTicketLimit(event.getTicketLimit());
        eventEntity.setType(event.getType());
        eventEntity.setUrl(event.getUrl());
        return eventEntity;
    }

    public Event mapEventEntityToEvent(EventEntity eventEntity) {
        Event event = new Event();
        event.set_embedded(eventEntity.get_embedded());
        event.set_links(eventEntity.get_links());
        event.setClassifications(eventEntity.getClassifications());
        event.setDates(eventEntity.getDates());
        event.setId(eventEntity.getId());
        event.setImages(eventEntity.getImages());
        event.setLocale(eventEntity.getLocale());
        event.setName(eventEntity.getName());
        event.setPleaseNote(eventEntity.getPleaseNote());
        event.setPriceRanges(eventEntity.getPriceRanges());
        event.setPromoter(eventEntity.getPromoter());
        event.setPromoters(eventEntity.getPromoters());
        event.setSales(eventEntity.getSales());
        event.setSeatmap(eventEntity.getSeatmap());
        event.setTest(eventEntity.getTest());
        event.setTicketLimit(eventEntity.getTicketLimit());
        event.setType(eventEntity.getType());
        event.setUrl(eventEntity.getUrl());

        return event;
    }
}
