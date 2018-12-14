package com.example.manue.numbertrivia;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


public class TriviaQuoteAdapter extends RecyclerView.Adapter<TriviaQuoteAdapter.ViewHolder> {

    private List<TriviaQuoteItem> items;

    public TriviaQuoteAdapter(List<TriviaQuoteItem> data) {
        items = data;
    }

    @NonNull
    @Override
    public TriviaQuoteAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view;

        if (i == 0) {
            view = inflater.inflate(R.layout.quote_left, parent, false);
        } else {
            view = inflater.inflate(R.layout.quote_right, parent, false);
        }
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TriviaQuoteAdapter.ViewHolder viewHolder, int i) {
        final int number = items.get(i).getNumber();
        viewHolder.number.setText(String.valueOf(number));
        final String text = items.get(i).getText();
        viewHolder.quote.setText(text);
    }

    public int getItemViewType(int i) {
        return i %2*2;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView number;
        public TextView quote;
        public View view;

        public ViewHolder(View itemView){
            super(itemView);
            view = itemView;
            number = (TextView) view.findViewById(R.id.number);
            quote = (TextView) view.findViewById(R.id.text);
        }
        @Override
        public void onClick(View view) {

        }
    }
}
