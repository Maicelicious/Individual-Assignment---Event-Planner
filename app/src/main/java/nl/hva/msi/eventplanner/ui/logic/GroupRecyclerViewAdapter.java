package nl.hva.msi.eventplanner.ui.logic;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

import nl.hva.msi.eventplanner.R;
import nl.hva.msi.eventplanner.data.event.database.entities.GroupEntity;

/**
 * Adapter for the GroupRecyclerView
 */
public class GroupRecyclerViewAdapter extends RecyclerView.Adapter<GroupRecyclerViewAdapter.ViewHolder> {

    List<GroupEntity> allGroupEntities;

    public GroupRecyclerViewAdapter(List<GroupEntity> groupEntities) {
        this.allGroupEntities = groupEntities;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.group_listitem, viewGroup, false);
        GroupRecyclerViewAdapter.ViewHolder viewHolder =  new GroupRecyclerViewAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final GroupEntity groupEntity = allGroupEntities.get(i);
        viewHolder.groupName.setText((groupEntity.getGroupName()));
        viewHolder.created.setText(groupEntity.getCreated());
        viewHolder.description.setText(groupEntity.getDescription());

        viewHolder.favourite.setChecked(groupEntity.isFavourite());
    }


    @Override
    public int getItemCount() {
        return allGroupEntities.size();
    }

    public void swapList (List<GroupEntity> newList) {
        allGroupEntities = newList;
        if (newList != null) {
            // Force the RecyclerView to refresh
            this.notifyDataSetChanged();
        }
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        CardView parentLayout;
        TextView groupName;
        TextView created;
        TextView description;
        CheckBox favourite;


        ViewHolder(View itemView) {
            super(itemView);
            groupName = itemView.findViewById(R.id.groupListName);
            description = itemView.findViewById(R.id.description);
            created = itemView.findViewById(R.id.dateCreatedText);
            parentLayout = itemView.findViewById(R.id.cardViewEdit);
            favourite = itemView.findViewById(R.id.groupFavourite);
            parentLayout.setClickable(true);
        }
    }

}
