package com.gmail.elnora.fet.recyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private static List<String> CITY_LIST = new ArrayList<String>() {{
        add("Minsk");
        add("Grodno");
        add("Brest");
        add("Madrid");
        add("Kiev");
        add("London");
        add("Minsk");
        add("Grodno");
        add("Brest");
        add("Madrid");
        add("Kiev");
        add("London");
        add("Minsk");
        add("Grodno");
        add("Brest");
        add("Madrid");
        add("Kiev");
        add("London");
        add("Minsk");
        add("Grodno");
        add("Brest");
        add("Madrid");
        add("Kiev");
        add("London");
    }};

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setAdapter(new RecyclerViewAdapter(CITY_LIST));
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false ));
    }

    private static class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder> {

        private List<String> items;

        public RecyclerViewAdapter(List<String> items) {
            this.items = items;
        }

        //create view and add to view holder and give recyclerview
        @NonNull
        @Override
        public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recyclerview, parent, false);
            return new RecyclerViewHolder(view);
        }

        //set data
        @Override
        public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
            // String itemText = items.get(position);
            // holder.itemTextTitle.setText(itemText);
            holder.bind(items.get(position));
        }

        //return count of data
        @Override
        public int getItemCount() {
            return items != null ? items.size() : 0;
        }

        public void addItem(String text) {
            items.add(text);
            notifyItemChanged(items.indexOf(text));
        }

        static class RecyclerViewHolder extends RecyclerView.ViewHolder {

            private TextView itemTextTitle;

            public RecyclerViewHolder(@NonNull View itemView) {
                super(itemView);
                itemTextTitle.findViewById(R.id.itemTextTitle);
            }

            public void bind(String text){
                itemTextTitle.setText(text);
            }
        }
    }
}
