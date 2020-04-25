package org.duder.view.adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.duder.R;

import java.util.ArrayList;
import java.util.List;

public class HobbyCategoriesAdapter extends RecyclerView.Adapter<HobbyCategoriesAdapter.ViewHolder> {
    private List<String> hobbies;
    private List<String> selectedHobbies = new ArrayList<>();

    public HobbyCategoriesAdapter(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    @NonNull
    @Override
    public HobbyCategoriesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.hobby_list_item, viewGroup, false);
        return new HobbyCategoriesAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.bind(hobbies.get(i));
        viewHolder.toggleButton.setOnCheckedChangeListener((toggleButton, isChecked) -> {
            String text = toggleButton.getText().toString();
            if (isChecked) {
                toggleButton.setTextColor(Color.parseColor("#FFFFFF"));
                toggleButton.setBackgroundResource(R.drawable.hobby_toggle_button_on);
                selectedHobbies.add(text);
            } else {
                toggleButton.setTextColor(Color.parseColor("#757575"));
                toggleButton.setBackgroundResource(R.drawable.hobby_toggle_button_off);
                selectedHobbies.remove(text);
            }
        });
    }

    public List<String> getSelectedHobbies() {
        return selectedHobbies;
    }

    @Override
    public int getItemCount() {
        return hobbies.size();
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private ToggleButton toggleButton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            toggleButton = itemView.findViewById(R.id.hobbu_toggle_btn);
        }

        private void bind(String hobby) {
            toggleButton.setText(hobby);
            toggleButton.setTextOn(hobby);
            toggleButton.setTextOff(hobby);
        }
    }
}
