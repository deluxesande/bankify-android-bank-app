package me.deluxesande.bankify.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import me.deluxesande.bankify.R;

public class HomePage extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedIsanceState) {
        super.onCreate(savedIsanceState);

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        return view;
    }

    private void fetchRecentTransactions() {
        // Get data for transactions
        // Using the Transaction service
    }
}
