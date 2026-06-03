package com.example.cmp2004termproject;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.cmp2004termproject.data.InfoRepository;
import com.example.cmp2004termproject.model.InfoCategory;
import com.example.cmp2004termproject.model.InfoItem;
import com.example.cmp2004termproject.network.HttpRequestTask;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

public class CategoryDetailActivity extends AppCompatActivity implements InfoItemAdapter.OnItemClickListener {

    private static final String TAG = "CategoryDetailActivity";
    private String categoryId;
    private TextView tvCategoryName;
    private TextView tvCategoryDesc;
    private TextView tvTipText;
    private RecyclerView recyclerView;
    private InfoItemAdapter adapter;
    private List<InfoItem> itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_detail);

        Log.d(TAG, "onCreate called");

        tvCategoryName = findViewById(R.id.tvCategoryName);
        tvCategoryDesc = findViewById(R.id.tvCategoryDesc);
        tvTipText = findViewById(R.id.tvTipText);
        
        findViewById(R.id.btnBack).setOnClickListener(v -> finish());
        recyclerView = findViewById(R.id.recyclerView);

        Intent intent = getIntent();
        categoryId = intent.getStringExtra("CATEGORY_ID");
        String categoryName = intent.getStringExtra("CATEGORY_NAME");

        tvCategoryName.setText(categoryName);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        itemList = new ArrayList<>();

        loadCategoryData();
        fetchOnlineData();
    }

    private void loadCategoryData() {
        InfoRepository repository = InfoRepository.getInstance();
        InfoCategory category = repository.getCategoryById(categoryId);

        if (category != null) {
            tvCategoryName.setText(category.getName());
            tvCategoryDesc.setText(category.getDescription());

            for (InfoItem item : category.getItems()) {
                itemList.add(item);
            }

            adapter = new InfoItemAdapter(itemList, this);
            recyclerView.setAdapter(adapter);
        }
    }

    private void fetchOnlineData() {
        // Using AdviceSlip API to get real English text instead of Latin placeholder text
        String url = "https://api.adviceslip.com/advice";
        new HttpRequestTask(new HttpRequestTask.onHttpResultListener() {
            @Override
            public void onSuccess(String result) {
                try {
                    JSONObject json = new JSONObject(result);
                    // Extract the "advice" string from the "slip" object
                    final String title = json.getJSONObject("slip").optString("advice");
                    Log.d(TAG, "Online data fetched: " + title);
                    
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if (tvTipText != null) {
                                tvTipText.setText(title);
                            }
                        }
                    });
                } catch (Exception e) {
                    Log.e(TAG, "JSON parse error: " + e.getMessage());
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if (tvTipText != null) tvTipText.setText("Stay healthy and stay safe!");
                        }
                    });
                }
            }

            @Override
            public void onError(Exception e) {
                Log.e(TAG, "Network error: " + e.getMessage());
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (tvTipText != null) tvTipText.setText("Stay healthy and stay safe!");
                    }
                });
            }
        }).execute(url);
    }

    @Override
    public void onItemClick(InfoItem item) {
        Intent intent = new Intent(CategoryDetailActivity.this, InfoDetailActivity.class);
        intent.putExtra("ITEM_TITLE", item.getTitle());
        intent.putExtra("ITEM_CONTENT", item.getContent());
        intent.putExtra("ITEM_SUMMARY", item.getSummary());
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
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