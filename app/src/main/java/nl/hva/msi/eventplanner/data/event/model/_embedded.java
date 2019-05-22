
package nl.hva.msi.eventplanner.data.event.model;

import java.util.List;
import lombok.Data;

@Data
@SuppressWarnings("unused")
public class _embedded {

    private List<Attraction> attractions;
    private List<Venue> venues;

}
