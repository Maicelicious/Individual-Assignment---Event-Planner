package nl.hva.msi.eventplanner.data.event.database.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "groupTable")
public class GroupEntity implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private long id;
    @ColumnInfo(name = "groupName")
    private String groupName;
    @ColumnInfo(name = "created")
    private String created;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }
}
