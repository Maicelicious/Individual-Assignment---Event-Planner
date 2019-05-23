
package nl.hva.msi.eventplanner.data.event.model;

import java.util.List;
import lombok.Data;

@Data
@SuppressWarnings("unused")
public class Event {

    private _embedded _embedded;
    private _links _links;
    private List<Classification> classifications;
    private Dates dates;
    private String id;
    private List<Image> images;
    private String locale;
    private String name;
    private String pleaseNote;
    private List<PriceRange> priceRanges;
    private Promoter promoter;
    private List<Promoter> promoters;
    private Sales sales;
    private Seatmap seatmap;
    private Boolean test;
    private TicketLimit ticketLimit;
    private String type;
    private String url;

}
