package nl.hva.msi.eventplanner.data.event.model.eventByIdModel;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import lombok.Data;

@Data
public class Attraction_ {
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("test")
    @Expose
    private Boolean test;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("locale")
    @Expose
    private String locale;
    @SerializedName("externalLinks")
    @Expose
    private ExternalLinks externalLinks;
    @SerializedName("images")
    @Expose
    private List<Image__> images = null;
    @SerializedName("classifications")
    @Expose
    private List<Classification_> classifications = null;
    @SerializedName("upcomingEvents")
    @Expose
    private UpcomingEvents_ upcomingEvents;
    @SerializedName("_links")
    @Expose
    private Links__ links;
}
