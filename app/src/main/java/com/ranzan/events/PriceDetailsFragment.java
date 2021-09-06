package com.ranzan.events;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class PriceDetailsFragment extends Fragment {
    private EditText etCurrency, etPrice;
    private Button btnPreview;
    private String title, description, startDate, startTime, endDate, endTime;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_price_details, container, false);
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            DataModel dataModel = (DataModel) getArguments().get("data");
            title = dataModel.getTitle();
            description = dataModel.getDescription();
            startDate = dataModel.getStartDate();
            startTime = dataModel.getStartTime();
            endTime = dataModel.getEndTime();
            endDate = dataModel.getEndDate();

        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        etCurrency = view.findViewById(R.id.etCurrency);
        etPrice = view.findViewById(R.id.etPrice);
        btnPreview = view.findViewById(R.id.btnPreview);
        btnPreview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), PreviewActivity.class);
                DataModel dataModel = new DataModel(
                        title, description,
                        startDate, endDate,
                        startTime, endTime,
                        etCurrency.getText().toString(),
                        etPrice.getText().toString()
                );
                intent.putExtra("data", dataModel);
                startActivity(intent);
            }
        });
    }
}