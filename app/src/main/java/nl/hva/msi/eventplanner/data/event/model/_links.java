
package nl.hva.msi.eventplanner.data.event.model;

import java.util.List;
import lombok.Data;

@Data
@SuppressWarnings("unused")
public class _links {

    private List<Attraction> attractions;
    private Self self;
    private List<Venue> venues;

}
