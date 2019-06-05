package nl.hva.msi.eventplanner.data.event.model.eventByIdModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class UpcomingEvents_ {
    @SerializedName("_total")
    @Expose
    private Integer total;
    @SerializedName("mfx-nl")
    @Expose
    private Integer mfxNl;
    @SerializedName("ticketmaster")
    @Expose
    private Integer ticketmaster;
    @SerializedName("mfx-be")
    @Expose
    private Integer mfxBe;
    @SerializedName("mfx-pl")
    @Expose
    private Integer mfxPl;
}
