package nl.hva.msi.eventplanner.ui.logic;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import nl.hva.msi.eventplanner.R;
import nl.hva.msi.eventplanner.data.event.database.entities.GroupEntity;

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

    class ViewHolder extends RecyclerView.ViewHolder {
        CardView parentLayout;
        TextView groupName;
        TextView created;

        ViewHolder(View itemView) {
            super(itemView);
            groupName = itemView.findViewById(R.id.groupListName);
            created = itemView.findViewById(R.id.dateCreatedText);
            parentLayout = itemView.findViewById(R.id.cardViewEdit);
            parentLayout.setClickable(true);
        }
    }

}
