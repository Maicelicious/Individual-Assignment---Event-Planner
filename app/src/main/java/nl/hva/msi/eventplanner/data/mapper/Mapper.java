package nl.hva.msi.eventplanner.data.mapper;


import java.util.ArrayList;
import java.util.List;

import nl.hva.msi.eventplanner.data.event.database.entities.EventEntity;
import nl.hva.msi.eventplanner.data.event.model.eventByCountryCodeModel.EventResponse;
import nl.hva.msi.eventplanner.data.event.model.eventByCountryCodeModel.EventsItem;
import nl.hva.msi.eventplanner.data.event.model.eventByIdModel.Address;
import nl.hva.msi.eventplanner.data.event.model.eventByIdModel.City;
import nl.hva.msi.eventplanner.data.event.model.eventByIdModel.Country;
import nl.hva.msi.eventplanner.data.event.model.eventByIdModel.Event;
import nl.hva.msi.eventplanner.data.event.model.eventByIdModel.Genre;
import nl.hva.msi.eventplanner.data.event.model.eventByIdModel.Public;

public class Mapper {

    private static Mapper instance;

    public Mapper getInstance() {
        if (instance == null) {
            instance = new Mapper();
            return instance;
        } else {
            return instance;
        }
    }

    public List<EventEntity> EventResponseToEntity(EventResponse eventResponse) {
        List<EventEntity> eventEntities = new ArrayList<>();

        for (EventsItem eventsItem : eventResponse.getEmbedded().getEvents()) {
            EventEntity eventEntity = new EventEntity();
            eventEntity.setTicketSaleState(eventsItem.getSales().getJsonMemberPublic().isStartTBD());
            eventEntity.setSalesStartDateTime(eventsItem.getSales().getJsonMemberPublic().getStartDateTime());
            eventEntity.setSalesEndDateTime(eventsItem.getSales().getJsonMemberPublic().getEndDateTime());
            eventEntity.setUrl(eventsItem.getUrl());
            eventEntity.setStatusCode(eventsItem.getDates().getStatus().getCode());
            eventEntity.setName(eventsItem.getName());
            eventEntity.setId(eventsItem.getId());
            eventEntity.setCountryCode(eventsItem.getEmbedded().getVenues().get(1).getCountry().getCountryCode());
            eventEntity.setCountry(eventsItem.getEmbedded().getVenues().get(1).getCountry().getName());
            eventEntity.setImageUrl(eventsItem.getImages().get(1).getUrl());
            eventEntity.setCity(eventsItem.getEmbedded().getVenues().get(1).getCity().getName());
            eventEntity.setAdress(eventsItem.getEmbedded().getVenues().get(1).getAddress().getLine1());
            eventEntity.setStartDate(eventsItem.getDates().getStart().getDateTime());
            eventEntity.setGenre(eventsItem.getClassifications().get(1).getGenre().getName());
            eventEntity.setPriceMax(eventsItem.getPriceRanges().get(1).getMax());
            eventEntity.setPriceMin(eventsItem.getPriceRanges().get(1).getMin());
            eventEntities.add(eventEntity);
        }

        return eventEntities;
    }

//    @Deprecated
//    public EventEntity mapEventtoEntityEvent(Event event, Address adress, City city, Country country, Dates dates, Genre genre, Image image, Start start, Status status, Public p) {
//        EventEntity eventEntity = new EventEntity();
//        eventEntity.setAdress(adress.getLine1());
//        eventEntity.setCity(city.getName());
//        eventEntity.setCountry(country.getName());
//        eventEntity.setCountryCode(country.getCountryCode());
//        eventEntity.setGenre(genre.getName());
//        eventEntity.setImageUrl(image.getUrl());
//        eventEntity.setId(event.getId());
//        eventEntity.setName(event.getName())
//        eventEntity.setUrl(event.getUrl());
//        eventEntity.setUrl(event.getUrl());
//        eventEntity.setSalesEndDateTime(p.getEndDateTime());
//        eventEntity.setSalesStartDateTime(p.getStartDateTime());
//        eventEntity.setTicketSaleState(status.getCode());
//
//        //TODO Rewrite to new Models
//        return eventEntity;
//    }

    public Event mapEventEntityToEvent(EventEntity eventEntity) {
        Event event = new Event();

        event.setUrl(eventEntity.getUrl());

        return event;
    }

    public Address mapEntityToAdress(EventEntity eventEntity) {
        Address address = new Address();
        address.setLine1(eventEntity.getAdress());
        return address;
    }

    public Genre mapEntityToGenre(EventEntity eventEntity) {
        Genre genre = new Genre();
        genre.setName(eventEntity.getName());
        return genre;
    }

    public City mapEntityToCity(EventEntity eventEntity) {
        City city = new City();
        city.setName(eventEntity.getName());
        return city;
    }

    public Country mapEntityToCountry(EventEntity eventEntity) {
        Country country = new Country();
        country.setCountryCode(eventEntity.getCountryCode());
        country.setName(eventEntity.getCountry());
        return country;
    }

//    public Dates mapEntityToDates(EventEntity eventEntity) {
//        Dates date = new Dates();
//        Start start = new Start();
//
//
//        Status state = new Status();
//        state.setCode(eventEntity.getTicketSaleState());
//        date.setStart(start);
//        date.setStatus(state);
//
//        return date;
//    }

    public Public mapEntityToPublic(EventEntity eventEntity) {
        Public aPublic = new Public();
        aPublic.setEndDateTime(eventEntity.getSalesEndDateTime());
        aPublic.setStartDateTime(eventEntity.getSalesStartDateTime());
        return aPublic;
    }


//    public Image mapEntityToImage(EventEntity eventEntity) {
//        Image image = new Image();
//        image.setHeight((int) eventEntity.getImageHeight());
//        image.setRatio(eventEntity.getImageRatio());
//        image.setUrl(eventEntity.getUrl());
//        image.setWidth((int) eventEntity.getImageWidth());
//        return image;
//    }
}
