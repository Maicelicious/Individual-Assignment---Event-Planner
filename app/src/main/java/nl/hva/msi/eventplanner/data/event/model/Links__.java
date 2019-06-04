package nl.hva.msi.eventplanner.data.event.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class Links__ {
    @SerializedName("self")
    @Expose
    private Self__ self;
}
