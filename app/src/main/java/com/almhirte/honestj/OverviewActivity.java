package com.almhirte.honestj;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class OverviewActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initGui();
    }

    private void initGui()
    {
        View v = findViewById(R.id.tableLayout);
        if(v instanceof ViewGroup)
        {
            ((ViewGroup)v).removeAllViews();
        }

        createTable(v);
        loadDataFromDb();
    }

    private void createTable(View v)
    {

    }

    private void loadDataFromDb()
    {
    }



    public void onClickColumn(View view)
    {
        Toast.makeText(this, "Details view not available", Toast.LENGTH_SHORT).show();
    }
}
