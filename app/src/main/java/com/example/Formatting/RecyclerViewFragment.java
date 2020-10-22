package com.example.Formatting;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.farmermate.R;
import com.example.farmermate.WeatherPage;


public class RecyclerViewFragment extends Fragment {

    public RecyclerViewFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setRetainInstance(true);
        return inflater.inflate( R.layout.fragment_recycler_view, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        View view = getView();
        if (view == null)
            return;

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        FragmentActivity activity = getActivity();
        Bundle bundle = this.getArguments();
        if (activity instanceof WeatherPage && bundle != null && bundle.containsKey("day")) {
            WeatherPage mainActivity = (WeatherPage) getActivity();
            recyclerView.setAdapter(mainActivity.getAdapter(bundle.getInt("day")));
        }
    }
}
