package nl.hva.msi.eventplanner.ui.logic;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import nl.hva.msi.eventplanner.R;
import nl.hva.msi.eventplanner.data.event.database.entities.EventEntity;

/**
 * The Recycler View Adapter Class for the the Group Event Link Fragment
 */
public class GroupListRecyclerViewAdapter extends RecyclerView.Adapter<GroupListRecyclerViewAdapter.ViewHolder> {

    private List<EventEntity> allEventEntities;

    public GroupListRecyclerViewAdapter(List<EventEntity> allEventEntities) {
        this.allEventEntities = allEventEntities;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.event_list_listitem, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final EventEntity eventEntity = allEventEntities.get(i);
        if (eventEntity != null) {
            String dateDuration;
            if(eventEntity.getStartDate() != null) {
                 dateDuration = eventEntity.getStartDate();
            } else {
                dateDuration = "NaN";
            }
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
            new ImageStream(viewHolder.cardViewBackground).execute(eventEntity.getImageUrl());
        }
    }

    @Override
    public int getItemCount() {
        return allEventEntities.size();
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
            parentLayout.setClickable(true);
        }
    }

    public void swapList(List<EventEntity> newList) {
        allEventEntities = newList;
        if (newList != null) {
            // Force the RecyclerView to refresh
            this.notifyDataSetChanged();
        }
    }
}
