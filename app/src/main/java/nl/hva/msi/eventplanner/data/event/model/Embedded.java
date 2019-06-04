
package nl.hva.msi.eventplanner.data.event.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;
import lombok.Data;

@Data
@SuppressWarnings("unused")
public class Embedded {

    @SerializedName("venues")
    @Expose
    private List<Venue_> venues = null;
    @SerializedName("attractions")
    @Expose
    private List<Attraction_> attractions = null;

}
