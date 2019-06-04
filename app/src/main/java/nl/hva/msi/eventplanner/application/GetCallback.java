package nl.hva.msi.eventplanner.application;

import java.util.List;

import nl.hva.msi.eventplanner.data.event.model.Event;

public interface GetCallback {
    void onSuccess(Event event);

    void onError();

    void onSuccess(List<Event> event);
}
