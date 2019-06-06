package nl.hva.msi.eventplanner.data.event.database.daos;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import nl.hva.msi.eventplanner.data.event.database.entities.GroupEntity;

@Dao
public interface GroupDao {
    @Query("SELECT * FROM groupTable")
    LiveData<List<GroupEntity>> getAllGroups();

    @Insert
    void insertGroup(GroupEntity groupEntity);

    @Delete
    void deleteGroup(GroupEntity groupEntity);

    @Update
    void updateGroup(GroupEntity groupEntity);
}
