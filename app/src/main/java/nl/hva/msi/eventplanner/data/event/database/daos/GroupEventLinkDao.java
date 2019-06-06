package nl.hva.msi.eventplanner.data.event.database.daos;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import nl.hva.msi.eventplanner.data.event.database.entities.GroupEventLink;

@Dao
public interface GroupEventLinkDao {

    @Query("SELECT * FROM groupEventLink")
    LiveData<List<GroupEventLink>> getAllLinks();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertLink(GroupEventLink link);

    @Delete
    void deleteLink(GroupEventLink link);

    @Update
    void updateLink(GroupEventLink link);


}
