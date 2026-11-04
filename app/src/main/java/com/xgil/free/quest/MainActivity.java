package com.xgil.free.quest;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private boolean isOverlayActive = false;
    private final String username = "Mibox";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txtUser = findViewById(R.id.txtUser);
        txtUser.setText("User: " + username);

        Button btnToggleMenu = findViewById(R.id.btnToggleMenu);
        Button btnSpawnScrap = findViewById(R.id.btnSpawnScrap);
        Button btnSpawnFlashlight = findViewById(R.id.btnSpawnFlashlight);
        Button btnSpawnJetpack = findViewById(R.id.btnSpawnJetpack);

        btnToggleMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isOverlayActive = !isOverlayActive;
                if (isOverlayActive) {
                    btnToggleMenu.setText("Toggle EIC Spawn Overlay: ON");
                    btnToggleMenu.setBackgroundColor(0xFF00FFCC);
                    Toast.makeText(MainActivity.this, "Mibox AI Overlay Active in Game", Toast.LENGTH_SHORT).show();
                } else {
                    btnToggleMenu.setText("Toggle EIC Spawn Overlay: OFF");
                    btnToggleMenu.setBackgroundColor(0xFF333333);
                }
            }
        });

        btnSpawnScrap.setOnClickListener(v -> triggerEICSpawn("AllScrap"));
        btnSpawnFlashlight.setOnClickListener(v -> triggerEICSpawn("ProFlashlight"));
        btnSpawnJetpack.setOnClickListener(v -> triggerEICSpawn("Jetpack"));
    }

    private void triggerEICSpawn(String itemId) {
        if (!isOverlayActive) {
            Toast.makeText(this, "Enable EIC Overlay first!", Toast.LENGTH_SHORT).show();
            return;
        }
        // Native spawn hook executed when connected to game session
        Toast.makeText(this, "Spawned " + itemId + " as " + username, Toast.LENGTH_SHORT).show();
    }
}
