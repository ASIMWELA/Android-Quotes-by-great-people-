package com.auga.inspiration.quotes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.ArrayList;

public class QuotesPagerAdapter extends PagerAdapter {

    ArrayList<Quote> list;
    Context context;

    public QuotesPagerAdapter(ArrayList<Quote> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        final Quote quote = list.get(position);
        LayoutInflater layoutInflater = LayoutInflater.from(context);

        ViewGroup viewGroup = (ViewGroup) layoutInflater.inflate(R.layout.slide_layout, container, false);

        TextView quoteHolder = (TextView) viewGroup.findViewById(R.id.quote);


        TextView authorHolder = (TextView) viewGroup.findViewById(R.id.author);

        quoteHolder.setText(quote.getQuote());
        authorHolder.setText(quote.getAuthor());

        container.addView(viewGroup);

        return viewGroup;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }
}
