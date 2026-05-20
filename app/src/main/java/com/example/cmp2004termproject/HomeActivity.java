package com.example.cmp2004termproject;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import com.example.cmp2004termproject.data.InfoRepository;
import com.example.cmp2004termproject.model.InfoCategory;

public class HomeActivity extends AppCompatActivity {

    private static final String TAG = "HomeActivity";
    private InfoRepository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Log.d(TAG, "onCreate called");
        repository = InfoRepository.getInstance();

        CardView cardHealth = findViewById(R.id.cardHealth);
        CardView cardLegal = findViewById(R.id.cardLegal);
        CardView cardSocial = findViewById(R.id.cardSocial);
        LinearLayout titleContainer = findViewById(R.id.titleContainer);

        Animation fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in);

        titleContainer.startAnimation(fadeIn);
        cardHealth.startAnimation(AnimationUtils.loadAnimation(this, R.anim.slide_up_long));
        cardLegal.startAnimation(AnimationUtils.loadAnimation(this, R.anim.slide_up_long));
        cardSocial.startAnimation(AnimationUtils.loadAnimation(this, R.anim.slide_up_long));

        cardHealth.setOnClickListener(v -> openCategory("health"));
        cardLegal.setOnClickListener(v -> openCategory("legal"));
        cardSocial.setOnClickListener(v -> openCategory("social"));

        checkNotificationPermission();
    }

    private void checkNotificationPermission() {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.TIRAMISU) {
            if (androidx.core.content.ContextCompat.checkSelfPermission(this, android.Manifest.permission.POST_NOTIFICATIONS) != android.content.pm.PackageManager.PERMISSION_GRANTED) {
                androidx.core.app.ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.POST_NOTIFICATIONS}, 101);
            } else {
                startTipNotificationService();
            }
        } else {
            startTipNotificationService();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @androidx.annotation.NonNull String[] permissions, @androidx.annotation.NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 101) {
            if (grantResults.length > 0 && grantResults[0] == android.content.pm.PackageManager.PERMISSION_GRANTED) {
                startTipNotificationService();
            } else {
                Log.w(TAG, "Notification permission denied by user.");
            }
        }
    }

    private void openCategory(String categoryId) {
        InfoCategory category = repository.getCategoryById(categoryId);
        if (category != null) {
            Intent intent = new Intent(HomeActivity.this, CategoryDetailActivity.class);
            intent.putExtra("CATEGORY_ID", categoryId);
            intent.putExtra("CATEGORY_NAME", category.getName());
            intent.putExtra("CATEGORY_ICON", category.getIconName());
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        }
    }

    private void startTipNotificationService() {
        Intent serviceIntent = new Intent(this, TipNotificationService.class);
        startService(serviceIntent);
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
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_about) {
            Intent intent = new Intent(HomeActivity.this, AboutActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}