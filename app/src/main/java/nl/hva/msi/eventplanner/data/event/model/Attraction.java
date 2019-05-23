
package nl.hva.msi.eventplanner.data.event.model;

import java.util.List;
import lombok.Data;

@Data
@SuppressWarnings("unused")
public class Attraction {

    private _links _links;
    private List<Classification> classifications;
    private String href;
    private String id;
    private List<Image> images;
    private String locale;
    private String name;
    private Boolean test;
    private String type;
    private UpcomingEvents upcomingEvents;
    private String url;

}
