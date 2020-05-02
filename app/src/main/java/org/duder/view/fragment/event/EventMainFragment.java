package org.duder.view.fragment.event;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import org.duder.R;
import org.duder.view.adapter.EventMainAdapter;
import org.duder.view.fragment.BaseFragment;

public class EventMainFragment extends BaseFragment {
    private EventMainAdapter adapter;
    private TabLayout tabLayout;
    private ViewPager viewPager;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_event_main, container, false);
        viewPager = root.findViewById(R.id.pager);
        tabLayout = root.findViewById(R.id.tab_layout);

        adapter = new EventMainAdapter(getFragmentManager());
        adapter.addFragment(new DummyFragment(), "My Events");
        adapter.addFragment(new EventPublicFragment(), "Public");
        adapter.addFragment(new DummyFragment(), "Private");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        return root;
    }
}