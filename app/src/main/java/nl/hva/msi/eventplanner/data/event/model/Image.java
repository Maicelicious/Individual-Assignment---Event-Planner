
package nl.hva.msi.eventplanner.data.event.model;

import lombok.Data;

@Data
@SuppressWarnings("unused")
public class Image {

    private Boolean fallback;
    private long height;
    private String ratio;
    private String url;
    private long width;

}
