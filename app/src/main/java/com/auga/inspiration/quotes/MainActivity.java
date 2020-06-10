package com.auga.inspiration.quotes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Quote> quotes = new ArrayList<>();

        AssetManager assetManager = getAssets();
        try {
            InputStream in = assetManager.open("data.txt");
            Scanner scanner = new Scanner(in);

            while(scanner.hasNext()){
                String temp = scanner.nextLine();
                String quote = temp.split("[|]")[0];
                String author = temp.split("[|]")[1];

                Quote qt = new Quote(quote, author);

                quotes.add(qt);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);

        QuotesPagerAdapter quotesPagerAdapter = new QuotesPagerAdapter(quotes, this);
        viewPager.setAdapter(quotesPagerAdapter);
    }
}
