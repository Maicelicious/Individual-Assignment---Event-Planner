package nl.hva.msi.eventplanner.data.event.database.repos;

import android.arch.lifecycle.LiveData;
import android.content.Context;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import nl.hva.msi.eventplanner.data.event.database.EventDatabase;
import nl.hva.msi.eventplanner.data.event.database.entities.EventEntity;
import nl.hva.msi.eventplanner.data.event.database.daos.EventDao;

/**
 * This is the Event Repository that holds the CRUD functionality for the EventEntities
 */
public class EventRepo implements EventDao {

    private EventDatabase eventDatabase;
    private EventDao eventDao;
    private Executor executor = Executors.newSingleThreadExecutor();
    private LiveData<List<EventEntity>> allEvents;

    public EventRepo(Context context) {
        this.eventDatabase = EventDatabase.getDatabase(context);
        this.eventDao = eventDatabase.eventDao();
        this.allEvents = eventDao.getAllEvents();
    }

    @Override
    public LiveData<List<EventEntity>> getAllEvents() {
        return allEvents;
    }

    @Override
    public LiveData<EventEntity> getEventByID(String id) {
        return eventDao.getEventByID(id);
    }

    @Override
    public void insertEvent(EventEntity event) {
        executor.execute(()-> eventDao.insertEvent(event));
    }

    @Override
    public void deleteEvent(EventEntity event) {
        executor.execute(()-> eventDao.deleteEvent(event));
    }

    @Override
    public void updateEvent(EventEntity event) {
        executor.execute(()-> eventDao.updateEvent(event));
    }
}

