
package nl.hva.msi.eventplanner.data.event.model;

import lombok.Data;

@Data
@SuppressWarnings("unused")
public class Dates {

    private Boolean spanMultipleDays;
    private Start start;
    private Status status;
    private String timezone;

}
