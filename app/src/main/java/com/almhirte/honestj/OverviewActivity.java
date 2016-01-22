package com.almhirte.honestj;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
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
            loadDataFromDb(v);
        }
    }

    private void loadDataFromDb(View v)
    {
        DataBaseMock db = new DataBaseMock();
        while(db.hasNext())
        {
            String currentRecord = db.loadNextRecord();
            TableLayout table = (TableLayout)v;

            TableRow tr = new TableRow(this);
            tr.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.WRAP_CONTENT));
            TextView textview = new TextView(this);
            textview.setText(currentRecord);

            table.addView(tr);
            table.invalidate();
        }
    }



    public void onClickColumn(View view)
    {
        Toast.makeText(this, "Details view not available", Toast.LENGTH_SHORT).show();
    }
}
