package nl.hva.msi.eventplanner.data.event.model.eventByIdModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class Links_ {

    @SerializedName("self")
    @Expose
    private Self_ self;
}
