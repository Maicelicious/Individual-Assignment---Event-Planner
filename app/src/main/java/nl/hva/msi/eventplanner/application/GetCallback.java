package nl.hva.msi.eventplanner.application;

import nl.hva.msi.eventplanner.data.event.model.eventByCountryCodeModel.EventResponse;

public interface GetCallback {
    void onSuccess(EventResponse event);

    void onError();

}
