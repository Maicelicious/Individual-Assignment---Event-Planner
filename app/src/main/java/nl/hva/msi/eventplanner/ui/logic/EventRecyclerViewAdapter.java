package nl.hva.msi.eventplanner.ui.logic;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import nl.hva.msi.eventplanner.R;
import nl.hva.msi.eventplanner.data.event.database.entities.EventEntity;
import nl.hva.msi.eventplanner.data.event.database.entities.GroupEntity;
import nl.hva.msi.eventplanner.data.event.database.entities.GroupEventLink;
import nl.hva.msi.eventplanner.data.event.database.repos.GroupEventLinkRepo;

/**
 * The Recycler View Adapter Class for the Event Fragment
 */
public class EventRecyclerViewAdapter extends RecyclerView.Adapter<EventRecyclerViewAdapter.ViewHolder> {


    private List<EventEntity> allEventEntities;
    private List<GroupEntity> allGroups;
    private Context context;
    private Spinner groupSpinner;
    private GroupEntity groupToAddToEntity;
    private EventEntity eventToAddToGroup;


    public EventRecyclerViewAdapter(List<EventEntity> allEventEntities, List<GroupEntity> allGroups, Context context) {
        this.allEventEntities = allEventEntities;
        this.allGroups = allGroups;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.event_listitem, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final EventEntity eventEntity = allEventEntities.get(i);
        this.groupSpinner = viewHolder.spinner;
        //Setting the Spinner with the groupNames
        List<String> spinnerItems = new LinkedList<>();
        for (GroupEntity g :
                allGroups) {
            String groupName = g.getGroupName();
            spinnerItems.add(groupName);
        }

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(Objects.requireNonNull(context),
                android.R.layout.simple_spinner_item, spinnerItems);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);

        viewHolder.spinner.setAdapter(dataAdapter);
        viewHolder.spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                groupToAddToEntity = allGroups.get(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        String dateDuration = eventEntity.getStartDate();
        viewHolder.date.setText(dateDuration);
        String priceRange = eventEntity.getPriceMin().toString() + " - " + eventEntity.getPriceMax().toString();
        viewHolder.priceRange.setText(priceRange);

        String availabillity = "";
        if (eventEntity.getTicketSaleState()) {
            availabillity = "true";
        } else {
            availabillity = "false";
        }
        viewHolder.availabillity.setText(availabillity);
        viewHolder.eventUrl.setText(eventEntity.getUrl());
        viewHolder.city.setText(eventEntity.getCity());
        viewHolder.country.setText(eventEntity.getCountry());
        viewHolder.eventName.setText(eventEntity.getName());
        viewHolder.addToGroup.setOnClickListener(v -> {
            Toast.makeText(context, "The Event " + eventEntity.getName() + " has been added", Toast.LENGTH_SHORT).show();
            addEventToGroup(eventEntity);
        });
        new ImageStream(viewHolder.cardViewBackground).execute(eventEntity.getImageUrl());
    }

    @Override
    public int getItemCount() {
        return allEventEntities.size();
    }

    public void addEventToGroup(EventEntity addToGroupEntity) {
        GroupEventLink groupEventLink = new GroupEventLink();
        groupEventLink.setEventId(String.valueOf(addToGroupEntity.getEntityID()));
        groupEventLink.setGroupId(String.valueOf(groupToAddToEntity.getId()));

        GroupEventLinkRepo groupEventLinkRepo = new GroupEventLinkRepo(context);
        groupEventLinkRepo.insertLink(groupEventLink);
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        CardView parentLayout;
        TextView date;
        TextView country;
        TextView city;
        TextView address;
        TextView eventUrl;
        TextView availabillity;
        TextView priceRange;
        TextView eventName;
        Spinner spinner;
        ImageButton addToGroup;
        ImageView cardViewBackground;


        ViewHolder(View itemView) {
            super(itemView);
            parentLayout = itemView.findViewById(R.id.cardEventViewEdit);
            eventName = itemView.findViewById(R.id.eventNameHead);
            date = itemView.findViewById(R.id.dateEventTextView);
            country = itemView.findViewById(R.id.countryText);
            city = itemView.findViewById(R.id.cityText);
            eventUrl = itemView.findViewById(R.id.eventUrlText);
            address = itemView.findViewById(R.id.addressText);
            availabillity = itemView.findViewById(R.id.ticketAvailabilityText);
            priceRange = itemView.findViewById(R.id.priceRangeText);
            cardViewBackground = itemView.findViewById(R.id.cardViewBackgroundImage);
            spinner = itemView.findViewById(R.id.spinnerGroup);
            addToGroup = itemView.findViewById(R.id.addToGroupButton);
            parentLayout.setClickable(true);

        }
    }

    public void swapList(List<EventEntity> newList, List<GroupEntity> newGroupList) {
        allEventEntities = newList;
        allGroups = newGroupList;
        if (newList != null && newGroupList != null) {
            // Force the RecyclerView to refresh
            this.notifyDataSetChanged();
        }
    }
}
