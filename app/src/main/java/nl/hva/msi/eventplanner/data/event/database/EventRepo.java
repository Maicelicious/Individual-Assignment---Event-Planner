package nl.hva.msi.eventplanner.data.event.database;

import android.arch.lifecycle.LiveData;
import android.content.Context;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

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

