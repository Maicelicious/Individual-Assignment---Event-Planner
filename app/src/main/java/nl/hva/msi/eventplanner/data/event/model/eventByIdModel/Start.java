
package nl.hva.msi.eventplanner.data.event.model.eventByIdModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
@SuppressWarnings("unused")
public class Start {

    @SerializedName("localDate")
    @Expose
    private String localDate;
    @SerializedName("localTime")
    @Expose
    private String localTime;
    @SerializedName("dateTime")
    @Expose
    private String dateTime;
    @SerializedName("dateTBD")
    @Expose
    private Boolean dateTBD;
    @SerializedName("dateTBA")
    @Expose
    private Boolean dateTBA;
    @SerializedName("timeTBA")
    @Expose
    private Boolean timeTBA;
    @SerializedName("noSpecificTime")
    @Expose
    private Boolean noSpecificTime;

}
