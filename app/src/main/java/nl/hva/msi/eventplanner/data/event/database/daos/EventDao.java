package nl.hva.msi.eventplanner.data.event.database.daos;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import nl.hva.msi.eventplanner.data.event.database.entities.EventEntity;

@Dao
public
interface EventDao {

    @Query("SELECT * FROM event")
    LiveData<List<EventEntity>> getAllEvents();

    @Insert
    void insertEvent(EventEntity event);

    @Delete
    void deleteEvent(EventEntity event);

    @Update
    void updateEvent(EventEntity event);


}
