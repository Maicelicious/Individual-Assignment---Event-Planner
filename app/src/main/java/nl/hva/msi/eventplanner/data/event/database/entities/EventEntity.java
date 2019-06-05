package nl.hva.msi.eventplanner.data.event.database.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "event")
public class EventEntity implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private Long EntityID;

    @ColumnInfo(name = "statusCode")
    private String statusCode;

    @ColumnInfo(name = "imageUrl")
    private String imageUrl;

    @ColumnInfo(name = "id")
    private String id;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "url")
    private String url;
    @ColumnInfo(name = "genre")
    private String genre;

    @ColumnInfo(name = "city")
    private String city;
    @ColumnInfo(name = "country")
    private String country;
    @ColumnInfo(name = "countryCode")
    private String countryCode;
    @ColumnInfo(name = "adress")
    private String adress;

    @ColumnInfo(name = "salesEndDateTime")
    private String salesEndDateTime;
    @ColumnInfo(name = "salesStartDateTime")
    private String salesStartDateTime;

    @ColumnInfo(name = "ticketSaleState")
    private boolean ticketSaleState;
    @ColumnInfo(name = "priceMin")
    private Double priceMin;

    @ColumnInfo(name = "priceMax")
    private Double priceMax;

    @ColumnInfo(name = "startDate")
    private String startDate;

    public boolean getTicketSaleState() {
        return ticketSaleState;
    }

    public void setTicketSaleState(boolean ticketSaleState) {
        this.ticketSaleState = ticketSaleState;
    }

    public Long getEntityID() {
        return EntityID;
    }

    public void setEntityID(Long entityID) {
        EntityID = entityID;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getSalesStartDateTime() {
        return salesStartDateTime;
    }

    public void setSalesStartDateTime(String salesStartDateTime) {
        this.salesStartDateTime = salesStartDateTime;
    }

    public String getSalesEndDateTime() {
        return salesEndDateTime;
    }

    public void setSalesEndDateTime(String salesEndDateTime) {
        this.salesEndDateTime = salesEndDateTime;
    }

    public Double getPriceMin() {
        return priceMin;
    }

    public void setPriceMin(Double priceMin) {
        this.priceMin = priceMin;
    }

    public Double getPriceMax() {
        return priceMax;
    }

    public void setPriceMax(Double priceMax) {
        this.priceMax = priceMax;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
}
