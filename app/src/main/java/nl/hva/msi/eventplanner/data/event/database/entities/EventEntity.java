package nl.hva.msi.eventplanner.data.event.database.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "event")
public class EventEntity implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private Long EntityID;

    @ColumnInfo(name = "dateTime")
    private String dateTime;
    @ColumnInfo(name = "localDate")
    private String localDate;
    @ColumnInfo(name = "localTime")
    private String localTime;
    @ColumnInfo(name = "statusCode")
    private String statusCode;
    @ColumnInfo(name = "timezone")
    private String timezone;
    @ColumnInfo(name = "imageHeight")
    private long imageHeight;
    @ColumnInfo(name = "imageRatio")
    private String imageRatio;
    @ColumnInfo(name = "imageUrl")
    private String imageUrl;
    @ColumnInfo(name = "imageWidth")
    private long imageWidth;
    @ColumnInfo(name = "id")
    private String id;
    @ColumnInfo(name = "locale")
    private String locale;
    @ColumnInfo(name = "name")
    private String name;
    @ColumnInfo(name = "pleaseNote")
    private String pleaseNote;
    @ColumnInfo(name = "type")
    private String type;
    @ColumnInfo(name = "url")
    private String url;
    @ColumnInfo(name = "genre")
    private String genre;
    @ColumnInfo(name = "childRule")
    private String childRule;
    @ColumnInfo(name = "generalRule")
    private String generalRule;
    @ColumnInfo(name = "city")
    private String city;
    @ColumnInfo(name = "country")
    private String country;
    @ColumnInfo(name = "countryCode")
    private String countryCode;
    @ColumnInfo(name = "adress")
    private String adress;
    @ColumnInfo(name = "eventType")
    private String eventType;

    @ColumnInfo(name = "salesEndDateTime")
    private String salesEndDateTime;
    @ColumnInfo(name = "salesStartDateTime")
    private String salesStartDateTime;

    @ColumnInfo(name = "ticketSaleState")
    private String ticketSaleState;

    public String getTicketSaleState() {
        return ticketSaleState;
    }

    public void setTicketSaleState(String ticketSaleState) {
        this.ticketSaleState = ticketSaleState;
    }

    public Long getEntityID() {
        return EntityID;
    }

    public void setEntityID(Long entityID) {
        EntityID = entityID;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getLocalDate() {
        return localDate;
    }

    public void setLocalDate(String localDate) {
        this.localDate = localDate;
    }

    public String getLocalTime() {
        return localTime;
    }

    public void setLocalTime(String localTime) {
        this.localTime = localTime;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public long getImageHeight() {
        return imageHeight;
    }

    public void setImageHeight(long imageHeight) {
        this.imageHeight = imageHeight;
    }

    public String getImageRatio() {
        return imageRatio;
    }

    public void setImageRatio(String imageRatio) {
        this.imageRatio = imageRatio;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public long getImageWidth() {
        return imageWidth;
    }

    public void setImageWidth(long imageWidth) {
        this.imageWidth = imageWidth;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPleaseNote() {
        return pleaseNote;
    }

    public void setPleaseNote(String pleaseNote) {
        this.pleaseNote = pleaseNote;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public String getChildRule() {
        return childRule;
    }

    public void setChildRule(String childRule) {
        this.childRule = childRule;
    }

    public String getGeneralRule() {
        return generalRule;
    }

    public void setGeneralRule(String generalRule) {
        this.generalRule = generalRule;
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

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
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
}
