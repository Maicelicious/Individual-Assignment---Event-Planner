
package nl.hva.msi.eventplanner.data.event.model;

import lombok.Data;

@Data
@SuppressWarnings("unused")
public class Start {

    private Boolean dateTBA;
    private Boolean dateTBD;
    private String dateTime;
    private String localDate;
    private String localTime;
    private Boolean noSpecificTime;
    private Boolean timeTBA;

}
