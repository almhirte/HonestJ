package com.almhirte.honestj;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class OverviewActivity extends AppCompatActivity
{
    private static String appName = "HonestJ";
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
        Log.d(appName, v.toString());
        if(v instanceof ViewGroup)
        {
            ((ViewGroup)v).removeAllViews();
            loadDataFromDb(v);
        }
    }

    private void loadDataFromDb(View v)
    {
        DataBaseMock db = new DataBaseMock();

        int i = 0;

        while(db.hasNext())
        {
            String currentRecord = db.loadNextRecord();
            TableLayout table = (TableLayout)v;

            TableRow tr = createTableRow(currentRecord);

            table.addView(tr);
            i++;
        }
    }

    @NonNull
    private TableRow createTableRow(String currentRecord) {
        TableRow tr = new TableRow(this);
        tr.setLayoutParams(new TableRow.LayoutParams(TableLayout.LayoutParams.WRAP_CONTENT));
        TextView textview = new TextView(this);
        textview.setText(currentRecord);

        ImageView imageView = new ImageView(this);
        imageView.setImageResource(R.mipmap.ic_no_image_rect);

        ImageButton minusBtn = new ImageButton(this);
        minusBtn.setImageResource(R.mipmap.ic_launcher);

        tr.addView(minusBtn);
        tr.addView(imageView);
        tr.addView(textview);
        return tr;
    }


    public void onClickColumn(View view)
    {
        Toast.makeText(this, "Details view not available", Toast.LENGTH_SHORT).show();
    }
}
