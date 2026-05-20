package com.example.cmp2004termproject;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class AboutActivity extends AppCompatActivity {

    private static final String TAG = "AboutActivity";
    private EditText etFeedback;
    private EditText etEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        Log.d(TAG, "onCreate called");

        etFeedback = findViewById(R.id.etFeedback);
        etEmail = findViewById(R.id.etEmail);

        View btnSendEmail = findViewById(R.id.btnSendEmail);
        View btnCallHelp = findViewById(R.id.btnCallHelp);
        
        findViewById(R.id.btnBack).setOnClickListener(v -> finish());

        btnSendEmail.setOnClickListener(v -> sendEmail());
        btnCallHelp.setOnClickListener(v -> makePhoneCall());
    }

    private void sendEmail() {
        String feedback = etFeedback.getText().toString().trim();
        String email = etEmail.getText().toString().trim();

        if (feedback.isEmpty()) {
            etFeedback.setError("Please write your feedback");
            return;
        }

        Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"support@infoapp.com"});
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "App Feedback");
        emailIntent.putExtra(Intent.EXTRA_TEXT, feedback + "\n\nFrom: " + email);

        if (emailIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(Intent.createChooser(emailIntent, "Send Email"));
        } else {
            Toast.makeText(this, "No email app found", Toast.LENGTH_SHORT).show();
        }
    }

    private void makePhoneCall() {
        try {
            Intent callIntent = new Intent(Intent.ACTION_DIAL);
            callIntent.setData(Uri.parse("tel:112"));
            startActivity(callIntent);
        } catch (Exception e) {
            Toast.makeText(this, "Unable to make call", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy called");
    }
}