package nl.hva.msi.eventplanner.data.mapper;


import nl.hva.msi.eventplanner.data.event.database.entities.EventEntity;
import nl.hva.msi.eventplanner.data.event.model.Address;
import nl.hva.msi.eventplanner.data.event.model.City;
import nl.hva.msi.eventplanner.data.event.model.Country;
import nl.hva.msi.eventplanner.data.event.model.Dates;
import nl.hva.msi.eventplanner.data.event.model.Event;
import nl.hva.msi.eventplanner.data.event.model.Genre;
import nl.hva.msi.eventplanner.data.event.model.Image;
import nl.hva.msi.eventplanner.data.event.model.Public;
import nl.hva.msi.eventplanner.data.event.model.Start;
import nl.hva.msi.eventplanner.data.event.model.Status;

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

    public EventEntity mapEventtoEntityEvent(Event event, Address adress, City city, Country country, Dates dates, Genre genre, Image image, Start start, Status status, Public p){
        EventEntity eventEntity = new EventEntity();
        eventEntity.setAdress(adress.getLine1());
        eventEntity.setCity(city.getName());
        eventEntity.setCountry(country.getName());
        eventEntity.setCountryCode(country.getCountryCode());
        eventEntity.setDateTime(start.getDateTime());
        eventEntity.setEventType(event.getType());
        eventEntity.setGenre(genre.getName());
        eventEntity.setImageHeight(image.getHeight());
        eventEntity.setImageRatio(image.getRatio());
        eventEntity.setImageUrl(image.getUrl());
        eventEntity.setImageWidth(image.getWidth());
        eventEntity.setId(event.getId());
        eventEntity.setLocalDate(start.getLocalDate());
        eventEntity.setLocale(event.getLocale());
        eventEntity.setLocalTime(start.getLocalTime());
        eventEntity.setName(event.getName());
        eventEntity.setTimezone(dates.getTimezone());
        eventEntity.setUrl(event.getUrl());
        eventEntity.setType(event.getType());
        eventEntity.setType(event.getType());
        eventEntity.setUrl(event.getUrl());
        eventEntity.setSalesEndDateTime(p.getEndDateTime());
        eventEntity.setSalesStartDateTime(p.getStartDateTime());
        eventEntity.setTicketSaleState(status.getCode());
        //TODO Rewrite to new Models
        return eventEntity;
    }

    public Event mapEventEntityToEvent(EventEntity eventEntity) {
        Event event = new Event();
        event.setType(eventEntity.getType());
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

    public Dates mapEntityToDates(EventEntity eventEntity) {
        Dates date = new Dates();
        Start start = new Start();
        start.setDateTime(eventEntity.getDateTime());
        start.setLocalDate(eventEntity.getLocalDate());
        start.setLocalTime(eventEntity.getLocalTime());
        Status state = new Status();
        state.setCode(eventEntity.getTicketSaleState());
        date.setStart(start);
        date.setStatus(state);
        date.setTimezone(eventEntity.getTimezone());
        return date;
    }

    public Public mapEntityToPublic(EventEntity eventEntity) {
        Public aPublic = new Public();
        aPublic.setEndDateTime(eventEntity.getSalesEndDateTime());
        aPublic.setStartDateTime(eventEntity.getSalesStartDateTime());
        return aPublic;
    }


    public Image mapEntityToImage(EventEntity eventEntity) {
        Image image = new Image();
        image.setHeight((int) eventEntity.getImageHeight());
        image.setRatio(eventEntity.getImageRatio());
        image.setUrl(eventEntity.getUrl());
        image.setWidth((int) eventEntity.getImageWidth());
        return image;
    }
}
