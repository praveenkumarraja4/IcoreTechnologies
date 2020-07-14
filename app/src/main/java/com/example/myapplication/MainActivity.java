package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final LinearLayout view=findViewById(R.id.view);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        View view2 = this.getLayoutInflater().inflate(R.layout.popup_layout, null);

        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_feed, R.id.navigation_post,R.id.navigation_chat,R.id.navigation_profile)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View dialogView = getLayoutInflater().inflate(R.layout.popup_layout, null);
                BottomSheetDialog dialog = new BottomSheetDialog(MainActivity.this);

                dialog.setContentView(dialogView);
                dialog.show();



//                final BottomSheetDialog mBottomSheetDialog = new BottomSheetDialog(MainActivity.this, R.style.SheetDialog);
//                mBottomSheetDialog.setContentView(view);
//                mBottomSheetDialog.show();
//                ((View) view.getParent()).setBackgroundColor(MainActivity.this.getResources().getColor(android.R.color.transparent));
            }
        });


    }

}