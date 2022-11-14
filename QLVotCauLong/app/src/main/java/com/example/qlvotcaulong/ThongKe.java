package com.example.qlvotcaulong;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class ThongKe extends AppCompatActivity {
BarChart barChart, barChart1;
PieChart pieChart, pieChart1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_ke);
        barChart = findViewById(R.id.bar_chart);
        pieChart = findViewById(R.id.pie_chart);
//        barChart1 = findViewById(R.id.bar_chart1);
//        pieChart1 = findViewById(R.id.pie_chart1);
        ArrayList<BarEntry> barEntries = new ArrayList<>();
//        ArrayList<BarEntry> barEntries1 = new ArrayList<>();
        ArrayList<PieEntry> pieEntries = new ArrayList<>();
//        ArrayList<PieEntry> pieEntries1 = new ArrayList<>();
        for(int i =1; i<10;i++){
            float value = (float) (i*10.0);
            BarEntry barEntry = new BarEntry(i,value);
            PieEntry pieEntry = new PieEntry(i,value);
            barEntries.add(barEntry);
            pieEntries.add(pieEntry);
        }
//        for(int i =1; i<10;i++){
//            float value = (float) (i*10.0);
//            BarEntry barEntry1 = new BarEntry(i,value);
//            PieEntry pieEntry1 = new PieEntry(i,value);
//            barEntries1.add(barEntry1);
//            pieEntries1.add(pieEntry1);
//        }
        BarDataSet barDataSet = new BarDataSet(barEntries, "Nike");
        barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        barDataSet.setDrawValues(false);
        barChart.setData(new BarData(barDataSet));
        barChart.animateY(5000);
        barChart.getDescription().setText("Nike chart");
        barChart.getDescription().setTextColor(Color.BLUE);
        barChart.getDescription().setText("Adidas chart");
        barChart.getDescription().setTextColor(Color.GREEN);
        barChart.getDescription().setText("Yonex chart");
        barChart.getDescription().setTextColor(Color.RED);
        barChart.getDescription().setText("Puma chart");
        barChart.getDescription().setTextColor(Color.YELLOW);

//        BarDataSet barDataSet1 = new BarDataSet(barEntries1, "Yonex");
//        barDataSet1.setColors(ColorTemplate.COLORFUL_COLORS);
//        barDataSet1.setDrawValues(false);
//        barChart.setData(new BarData(barDataSet1));
//        barChart.animateY(5000);
//        barChart.getDescription().setText("Yonex chart");
//        barChart.getDescription().setTextColor(Color.GREEN);

        PieDataSet pieDataSet = new PieDataSet(pieEntries,"Adidas");
        pieDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        pieChart.setData(new PieData(pieDataSet));
        pieChart.animateXY(5000,5000);
        pieChart.getDescription().setEnabled(false);

//        PieDataSet pieDataSet1 = new PieDataSet(pieEntries1,"Puma");
//        pieDataSet1.setColors(ColorTemplate.COLORFUL_COLORS);
//        pieChart.setData(new PieData(pieDataSet1));
//        pieChart.animateXY(5000,5000);
//        pieChart.getDescription().setEnabled(false);
    }
}