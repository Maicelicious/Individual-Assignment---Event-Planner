
package nl.hva.msi.eventplanner.data.event.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
@SuppressWarnings("unused")
public class City {

    @SerializedName("name")
    @Expose
    private String name;

}
