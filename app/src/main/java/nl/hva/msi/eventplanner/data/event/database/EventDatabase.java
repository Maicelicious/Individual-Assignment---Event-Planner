package nl.hva.msi.eventplanner.data.event.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import nl.hva.msi.eventplanner.data.event.database.daos.EventDao;
import nl.hva.msi.eventplanner.data.event.database.daos.GroupDao;
import nl.hva.msi.eventplanner.data.event.database.entities.EventEntity;
import nl.hva.msi.eventplanner.data.event.database.entities.GroupEntity;

@Database(entities = {EventEntity.class, GroupEntity.class}, version = 1, exportSchema = false)
public abstract class EventDatabase extends RoomDatabase {

    private final static String NAME_DATABASE = "db_even";

    public abstract EventDao eventDao();
    public abstract GroupDao groupDao();

    private static volatile EventDatabase INSTANCE;

    public static EventDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (EventDatabase.class) {
                if (INSTANCE == null) {
                    // Create database here
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            EventDatabase.class, NAME_DATABASE)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

}
