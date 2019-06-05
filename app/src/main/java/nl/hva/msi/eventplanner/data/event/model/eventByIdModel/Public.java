
package nl.hva.msi.eventplanner.data.event.model.eventByIdModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
@SuppressWarnings("unused")
public class Public {

    @SerializedName("startDateTime")
    @Expose
    private String startDateTime;
    @SerializedName("startTBD")
    @Expose
    private Boolean startTBD;
    @SerializedName("endDateTime")
    @Expose
    private String endDateTime;

}
