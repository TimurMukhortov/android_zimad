package me.tmukhortov.zimad.presentation.animal.list.activity;

import androidx.appcompat.app.AppCompatActivity;
import me.tmukhortov.zimad.R;
import me.tmukhortov.zimad.utility.network.NetworkService;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NetworkService.getInstance().getZimadAPI().catList();
    }
}
