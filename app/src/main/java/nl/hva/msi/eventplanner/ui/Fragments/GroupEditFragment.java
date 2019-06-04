package nl.hva.msi.eventplanner.ui.Fragments;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import nl.hva.msi.eventplanner.R;
import nl.hva.msi.eventplanner.data.event.database.entities.GroupEntity;
import nl.hva.msi.eventplanner.ui.Fragments.Viewmodel.GroupEditViewModel;

public class GroupEditFragment extends Fragment {

    private GroupEditViewModel mViewModel;

    private static GroupEntity toEditGroup;
    private static final String GROUP_KEY = "suchKeyMuchWow";


    public static GroupEditFragment newInstance(GroupEntity groupEntity) {
        GroupEditFragment groupEditFragment = new GroupEditFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(GROUP_KEY, groupEntity);
        groupEditFragment.setArguments(bundle);
        return groupEditFragment;
    }



    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.group_edit_fragment, container, false);

        toEditGroup = (GroupEntity) getArguments().getSerializable(GROUP_KEY);



        Button save = view.findViewById(R.id.editSaveButton);

        mViewModel = ViewModelProviders.of(this).get(GroupEditViewModel.class);

        EditText groupEditText = view.findViewById(R.id.groupEditNameInput);
        EditText groupEditDescr = view.findViewById(R.id.descriptionEditInput);
        CheckBox favourite = view.findViewById(R.id.favouriteCheckbox);

        if (toEditGroup != null ){
            groupEditText.setText(toEditGroup.getGroupName());
            groupEditDescr.setText(toEditGroup.getDescription());
            favourite.setChecked(toEditGroup.isFavourite());
        }



        save.setOnClickListener(view1 -> {
            GroupFragment newFragment = null;
            if (getFragmentManager() != null) {
                newFragment = new GroupFragment();
            }
            if (newFragment != null) {
                FragmentManager manager = getFragmentManager();
                if (manager != null) {
                    GroupEntity groupEntity = new GroupEntity();

                    String groupName = groupEditText.getText().toString();
                    String editDescr = groupEditDescr.getText().toString();
                    boolean isFav = favourite.isChecked();
                    System.out.println(isFav);
                    groupEntity.setGroupName(groupName);
                    groupEntity.setDescription(editDescr);
                    groupEntity.setFavourite(isFav);
                    mViewModel.updateGroup(groupEntity);
                    manager.beginTransaction().replace(R.id.fragment_container, newFragment).commit();

                } else {
                    //TODO: Error handling
                }
            }
        });

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(GroupEditViewModel.class);
        // TODO: Use the ViewModel
    }

}
