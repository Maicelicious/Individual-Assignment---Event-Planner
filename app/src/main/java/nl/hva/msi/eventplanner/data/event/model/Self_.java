package nl.hva.msi.eventplanner.data.event.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class Self_ {

    @SerializedName("href")
    @Expose
    private String href;
}
