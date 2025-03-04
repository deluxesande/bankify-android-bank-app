package me.deluxesande.bankify;

import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import me.deluxesande.bankify.fragments.HomePage;
import me.deluxesande.bankify.fragments.ProfilePage;
import me.deluxesande.bankify.fragments.StatsPage;
import me.deluxesande.bankify.fragments.WalletPage;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setSelectedItemId(R.id.bottom_home);
        bottomNavigationView.setOnItemSelectedListener(navListener);

        Fragment selectedFragment = new HomePage();

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();

    }

    private NavigationBarView.OnItemSelectedListener navListener = item -> {
        int itemId = item.getItemId();

        Fragment selectedFragment = null;

        if(itemId == R.id.bottom_home) {
            selectedFragment = new HomePage();
        } else if(itemId == R.id.bottom_wallet) {
            selectedFragment = new WalletPage();
        } else if(itemId == R.id.bottom_stats) {
            selectedFragment = new StatsPage();
        } else if(itemId == R.id.bottom_profile) {
            selectedFragment = new ProfilePage();
        }

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();

        return true;
    };
}