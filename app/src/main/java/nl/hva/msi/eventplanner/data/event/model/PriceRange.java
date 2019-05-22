
package nl.hva.msi.eventplanner.data.event.model;

import lombok.Data;

@Data
@SuppressWarnings("unused")
public class PriceRange {

    private String currency;
    private long max;
    private long min;
    private String type;

}
