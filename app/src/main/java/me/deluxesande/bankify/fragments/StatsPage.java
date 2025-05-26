package me.deluxesande.bankify.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;

import me.deluxesande.bankify.R;

public class StatsPage extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.fragment_stats, container, false);

        PieChart pieChart = view.findViewById(R.id.pieChart);

        ArrayList<PieEntry> entries = new ArrayList<PieEntry>();
        entries.add(new PieEntry(40f, "Food"));
        entries.add(new PieEntry(30f, "Transport"));
        entries.add(new PieEntry(20f, "Entertainment"));
        entries.add(new PieEntry(10f, "Other"));

        PieDataSet dataSet = new PieDataSet(entries, "Expenses");
        dataSet.setColors(new int[]{Color.BLUE, Color.GREEN, Color.MAGENTA, Color.CYAN});
        PieData data = new PieData(dataSet);

        pieChart.setData(data);

        pieChart.getDescription().setEnabled(false);
//        pieChart.setDrawHoleEnabled(false);
        pieChart.invalidate(); // refresh

        return view;
    }
}
