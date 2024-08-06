package com.example.android.taskcreation;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SplashActivity extends AppCompatActivity {

    ImageView loader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        loader = findViewById(R.id.loader);
        loader.bringToFront();

        // Create the rotate animation
        RotateAnimation rotateAnimation = new RotateAnimation(
                0, 360, // Start and end angle for the rotation
                Animation.RELATIVE_TO_SELF, 0.5f, // Pivot point of X at 50% of view width
                Animation.RELATIVE_TO_SELF, 0.5f // Pivot point of Y at 50% of view height
        );

        // Set the duration and repeat count
        rotateAnimation.setDuration(3000); // 1 second for a full rotation
        rotateAnimation.setRepeatCount(Animation.INFINITE); // Repeat indefinitely

        // Start the animation on the loader ImageView
        loader.startAnimation(rotateAnimation);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                finish();
            }
        },3000);

    }

}
