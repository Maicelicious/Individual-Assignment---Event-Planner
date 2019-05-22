
package nl.hva.msi.eventplanner.data.event.model;

import lombok.Data;

@Data
@SuppressWarnings("unused")
public class Classification {

    private Boolean family;
    private Genre genre;
    private Boolean primary;
    private Segment segment;
    private SubGenre subGenre;
    private SubType subType;
    private Type type;

}
