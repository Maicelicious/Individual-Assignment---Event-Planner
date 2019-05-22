package nl.hva.msi.eventplanner.data.event.database;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.io.Serializable;
import java.util.List;

import lombok.Data;
import nl.hva.msi.eventplanner.data.event.model.Classification;
import nl.hva.msi.eventplanner.data.event.model.Dates;
import nl.hva.msi.eventplanner.data.event.model.Image;
import nl.hva.msi.eventplanner.data.event.model.PriceRange;
import nl.hva.msi.eventplanner.data.event.model.Promoter;
import nl.hva.msi.eventplanner.data.event.model.Sales;
import nl.hva.msi.eventplanner.data.event.model.Seatmap;
import nl.hva.msi.eventplanner.data.event.model.TicketLimit;

@Data
@Entity(tableName = "event")
public class EventEntity implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private Long EntityID;

    @ColumnInfo(name = "_embedded")
    private nl.hva.msi.eventplanner.data.event.model._embedded _embedded;
    @ColumnInfo(name = "_links")
    private nl.hva.msi.eventplanner.data.event.model._links _links;
    @ColumnInfo(name = "classifications")
    private List<Classification> classifications;
    @ColumnInfo(name = "dates")
    private Dates dates;
    @ColumnInfo(name = "id")
    private String id;
    @ColumnInfo(name = "images")
    private List<Image> images;
    @ColumnInfo(name = "locale")
    private String locale;
    @ColumnInfo(name = "name")
    private String name;
    @ColumnInfo(name = "pleaseNote")
    private String pleaseNote;
    @ColumnInfo(name = "priceRanges")
    private List<PriceRange> priceRanges;
    @ColumnInfo(name = "promoter")
    private Promoter promoter;
    @ColumnInfo(name = "promoters")
    private List<Promoter> promoters;
    @ColumnInfo(name = "sales")
    private Sales sales;
    @ColumnInfo(name = "seatmap")
    private Seatmap seatmap;
    @ColumnInfo(name = "test")
    private Boolean test;
    @ColumnInfo(name = "ticketLimit")
    private TicketLimit ticketLimit;
    @ColumnInfo(name = "type")
    private String type;
    @ColumnInfo(name = "url")
    private String url;
}
