package nl.hva.msi.eventplanner.data.event.model.eventByIdModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import lombok.Data;

@Data
public class Links {

    @SerializedName("self")
    @Expose
    private Self self;
    @SerializedName("attractions")
    @Expose
    private List<Attraction> attractions = null;
    @SerializedName("venues")
    @Expose
    private List<Venue> venues = null;
}
