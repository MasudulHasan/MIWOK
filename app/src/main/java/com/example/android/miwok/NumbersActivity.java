/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.miwok;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    public MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        //creating an ArrayList
        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("one", "lutti", R.drawable.number_one,R.raw.number_one));
        words.add(new Word("two", "otiiko", R.drawable.number_two,R.raw.number_two));
        words.add(new Word("three", "tolookosu", R.drawable.number_three,R.raw.number_three));
        words.add(new Word("four", "oyyisa", R.drawable.number_four,R.raw.number_four));
        words.add(new Word("five", "massokka", R.drawable.number_five,R.raw.number_five));
        words.add(new Word("six", "temmokka", R.drawable.number_six,R.raw.number_six));
        words.add(new Word("seven", "kenekaku", R.drawable.number_seven,R.raw.number_seven));
        words.add(new Word("eight", "kawinta", R.drawable.number_eight,R.raw.number_eight));
        words.add(new Word("nine", "wo’e", R.drawable.number_nine,R.raw.number_nine));
        words.add(new Word("ten", "na’aacha", R.drawable.number_ten,R.raw.number_ten));

//        LinearLayout RootView=(LinearLayout)findViewById(R.id.rootView);
//        for(int i=0;i<arrayList.size();i++) {
//            TextView words = new TextView(this);
//            words.setText(arrayList.get(i));
//            RootView.addView(words);
//        }

        WordAdapter iteamAdapter=new WordAdapter(this,words,R.color.category_numbers);
        ListView lstView=(ListView)findViewById(R.id.list);
        //GridView lstView=(GridView)findViewById(R.id.list);
        lstView.setAdapter(iteamAdapter);

        lstView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(NumbersActivity.this,"List item clicked",Toast.LENGTH_SHORT).show();
                Word word=words.get(position);
                mediaPlayer = MediaPlayer.create(NumbersActivity.this, word.getmAudioResourceID());
                mediaPlayer.start();
            }
        });

    }
}
