
package nl.hva.msi.eventplanner.data.event.model.eventByIdModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
@SuppressWarnings("unused")
public class PriceRange {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("currency")
    @Expose
    private String currency;
    @SerializedName("min")
    @Expose
    private Double min;
    @SerializedName("max")
    @Expose
    private Double max;

}
