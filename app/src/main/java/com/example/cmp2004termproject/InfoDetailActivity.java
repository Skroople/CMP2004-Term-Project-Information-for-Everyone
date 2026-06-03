package com.example.cmp2004termproject;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class InfoDetailActivity extends AppCompatActivity {

    private static final String TAG = "InfoDetailActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_detail);

        Log.d(TAG, "onCreate called");

        TextView tvTitle = findViewById(R.id.tvDetailTitle);
        TextView tvContent = findViewById(R.id.tvDetailContent);
        TextView tvSummary = findViewById(R.id.tvDetailSummary);

        Intent intent = getIntent();
        String title = intent.getStringExtra("ITEM_TITLE");
        String content = intent.getStringExtra("ITEM_CONTENT");
        String summary = intent.getStringExtra("ITEM_SUMMARY");

        tvTitle.setText(title);
        tvContent.setText(content);
        
        findViewById(R.id.btnBack).setOnClickListener(v -> finish());
        tvSummary.setText(summary);

        Animation fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        View contentView = findViewById(R.id.contentContainer);
        contentView.startAnimation(fadeIn);
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

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}