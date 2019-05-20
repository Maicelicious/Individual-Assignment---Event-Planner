package nl.hva.msi.eventplanner;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.view.MenuItem;

import nl.hva.msi.eventplanner.Fragments.EventFragment;
import nl.hva.msi.eventplanner.Fragments.EventSearchFragment;
import nl.hva.msi.eventplanner.Fragments.GroupFragment;
import nl.hva.msi.eventplanner.Fragments.HomeFragment;

public class MainActivity extends AppCompatActivity {

    private Fragment homeFragment;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    selectedFragment = homeFragment;

                    break;
                case R.id.navigation_group:
                    selectedFragment = new GroupFragment();
                    break;
                case R.id.navigation_event_search:
                    selectedFragment = new EventSearchFragment();
                    break;
                case R.id.navigation_event:
                    selectedFragment = new EventFragment();
                    break;
            }
            if (selectedFragment != null) {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();

            } else {
                selectedFragment = new HomeFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();

            }
            return true;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.bottom_nav);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        homeFragment = new HomeFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, homeFragment).commit();

    }

}
