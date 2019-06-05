package nl.hva.msi.eventplanner.data.event.model.eventByIdModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import lombok.Data;

@Data
public class Event {

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
    @SerializedName("images")
    @Expose
    private List<Image> images = null;
    @SerializedName("sales")
    @Expose
    private Sales sales;
    @SerializedName("dates")
    @Expose
    private Dates dates;
    @SerializedName("classifications")
    @Expose
    private List<Classification> classifications = null;
    @SerializedName("promoter")
    @Expose
    private Promoter promoter;
    @SerializedName("promoters")
    @Expose
    private List<Promoter_> promoters = null;
    @SerializedName("priceRanges")
    @Expose
    private List<PriceRange> priceRanges = null;
    @SerializedName("_links")
    @Expose
    private Links links;
    @SerializedName("_embedded")
    @Expose
    private Embedded embedded;
}
