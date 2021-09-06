package com.ranzan.events;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PreviewActivity extends AppCompatActivity {
    private TextView title, description, startDate, endDate, startTime, endTime, currency, price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview);
        initViews();
        DataModel dataModel = (DataModel) getIntent().getSerializableExtra("data");
        title.setText(dataModel.getTitle());
        description.setText(dataModel.getDescription());
        startDate.setText(dataModel.getStartDate());
        endDate.setText(dataModel.getEndDate());
        startTime.setText(dataModel.getStartTime());
        endTime.setText(dataModel.getEndTime());
        currency.setText(dataModel.getCurrency());
        price.setText(dataModel.getPrice());
    }

    private void initViews() {
        title = findViewById(R.id.tvTitle);
        description = findViewById(R.id.tvDescription);
        startDate = findViewById(R.id.tvStartDate);
        endDate = findViewById(R.id.tvEndDate);
        startTime = findViewById(R.id.tvStartTime);
        endTime = findViewById(R.id.tvEndTime);
        currency = findViewById(R.id.tvCurrency);
        price = findViewById(R.id.tvPrice);
    }
}