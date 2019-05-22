
package nl.hva.msi.eventplanner.data.event.model;

import java.util.List;
import lombok.Data;

@Data
@SuppressWarnings("unused")
public class Venue {

    private nl.hva.msi.eventplanner.data.event.model._links _links;
    private String accessibleSeatingDetail;
    private Address address;
    private BoxOfficeInfo boxOfficeInfo;
    private City city;
    private Country country;
    private List<Dma> dmas;
    private GeneralInfo generalInfo;
    private String href;
    private String id;
    private List<Image> images;
    private String locale;
    private Location location;
    private List<Market> markets;
    private String name;
    private String parkingDetail;
    private String postalCode;
    private Social social;
    private State state;
    private Boolean test;
    private String timezone;
    private String type;
    private UpcomingEvents upcomingEvents;
    private String url;

}
