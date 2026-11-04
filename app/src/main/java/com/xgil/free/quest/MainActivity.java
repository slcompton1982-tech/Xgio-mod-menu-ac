package com.xgil.free.quest;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private boolean isModActive = false;
    private final String username = "Mibox";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txtUser = findViewById(R.id.txtUser);
        txtUser.setText("User: " + username);

        Button btnToggle = findViewById(R.id.btnToggle);
        btnToggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isModActive = !isModActive;
                if (isModActive) {
                    btnToggle.setText("Mibox AI: ON");
                    btnToggle.setBackgroundColor(0xFF00FFCC);
                } else {
                    btnToggle.setText("Mibox AI: OFF");
                    btnToggle.setBackgroundColor(0xFF333333);
                }
            }
        });
    }
}
