package com.example.duofrencholingo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.duofrencholingo.Readings.ConceptLandingPage;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    FirebaseAuth auth;
    Button logoutButton;
    TextView userInfo;
    FirebaseUser user;
    Button grammarTutorialButton;
    TextView profileImagePrompt;
    EditText profileImageUrl;
    ImageView profileImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        auth = FirebaseAuth.getInstance();
        logoutButton = findViewById(R.id.logout_button);
        userInfo = findViewById(R.id.user_details);
        user = auth.getCurrentUser();
        grammarTutorialButton = findViewById(R.id.reading_button);
        profileImagePrompt = findViewById(R.id.profile_image_prompt);
        profileImageUrl = findViewById(R.id.image_url);
        profileImage = findViewById(R.id.profile_image);


        if (user == null) {
            Intent intent = new Intent(getApplicationContext(), Login.class);
            startActivity(intent);
            finish();
        } else {
            userInfo.setText(user.getEmail());
        }

        LinearLayout linearLayout = findViewById(R.id.main_activity_layout);
        AnimationDrawable buttonAnimation = (AnimationDrawable) linearLayout.getBackground();
        buttonAnimation.setEnterFadeDuration(2000);
        buttonAnimation.setExitFadeDuration(4000);
        buttonAnimation.start();

        grammarTutorialButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ConceptLandingPage.class);
                startActivity(intent);
                finish();
            }
        });

        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
                finish();
            }
        });

        //TODO accept more file types (preferably manual upload), make sure image actually changes
        profileImageUrl.addTextChangedListener(new TextWatcher() {
            boolean exit = false;
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void afterTextChanged(Editable editable) {
                if (exit) {
                    return;
                }

                if (String.valueOf(profileImageUrl.getText()).contains("jpg") ||
                        String.valueOf(profileImageUrl.getText()).contains("png")) {
                    exit = true;
                    profileImagePrompt.setVisibility(View.GONE);
                    ImageStore.loadIntroImageWithGlide(profileImage, String.valueOf(profileImageUrl.getText()));
                    profileImageUrl.getText().clear();
                    exit = false;
                }
            }
        });

    }
}