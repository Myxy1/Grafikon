package com.example.petrik.grafikon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    /*
            https://github.com/PhilJay/MPAndroidChart
     */

    private Button buttonGrafikon;
    private BarChart barChart;
    private boolean lathatatlan = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        ArrayList<BarEntry> barEntries = new ArrayList<>();
        barEntries.add(new BarEntry(0f,60f));
        barEntries.add(new BarEntry(1f,15f));
        barEntries.add(new BarEntry(2f,5f));
        barEntries.add(new BarEntry(3f,20f));

        BarDataSet barDataSet = new BarDataSet(barEntries,"Kérdések");

        ArrayList<IBarDataSet> dataSets = new ArrayList<>();
        dataSets.add(barDataSet);


        final ArrayList<String> questions = new ArrayList<>();
        questions.add("A");
        questions.add("B");
        questions.add("C");
        questions.add("D");

        BarData barData = new BarData(dataSets);

        barChart.setData(barData);

        //barData.setBarWidth(0.9f); // set custom bar width
        barChart.setFitBars(true); // make the x-axis fit exactly all bars
        barChart.invalidate(); // refresh
        barChart.setVisibility(View.GONE);
        barChart.animateXY(3000, 3000);



        buttonGrafikon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (lathatatlan)
                {
                    barChart.setVisibility(View.VISIBLE);
                    lathatatlan = false;
                }else
                {
                    barChart.setVisibility(View.GONE);
                    lathatatlan = true;
                }
            }
        });

    }



    public void init()
    {
        barChart = (BarChart) findViewById(R.id.barChart);
        buttonGrafikon = (Button) findViewById(R.id.buttonGrafikon);
    }
}
