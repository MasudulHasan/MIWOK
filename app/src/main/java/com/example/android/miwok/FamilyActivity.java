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
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    public MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        //creating an ArrayList
        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("father", "әpә", R.drawable.family_father,R.raw.family_father));
        words.add(new Word("mother", "әṭa", R.drawable.family_mother,R.raw.family_mother));
        words.add(new Word("son", "angsi", R.drawable.family_son,R.raw.family_son));
        words.add(new Word("daughter", "tune", R.drawable.family_daughter,R.raw.family_daughter));
        words.add(new Word("older brother", "taachi", R.drawable.family_older_brother,R.raw.family_older_brother));
        words.add(new Word("younger brother", "chalitti", R.drawable.family_younger_brother,R.raw.family_younger_brother));
        words.add(new Word("older sister", "teṭe", R.drawable.family_older_sister,R.raw.family_older_sister));
        words.add(new Word("younger sister", "kolliti", R.drawable.family_younger_sister,R.raw.family_younger_sister));
        words.add(new Word("grandmother ", "ama", R.drawable.family_grandmother,R.raw.family_grandmother));
        words.add(new Word("grandfather", "paapa", R.drawable.family_grandfather,R.raw.family_grandfather));


//        LinearLayout RootView=(LinearLayout)findViewById(R.id.rootView);
//        for(int i=0;i<arrayList.size();i++) {
//            TextView words = new TextView(this);
//            words.setText(arrayList.get(i));
//            RootView.addView(words);
//        }

        WordAdapter iteamAdapter=new WordAdapter(this,words,R.color.category_family);
        ListView lstView=(ListView)findViewById(R.id.list);
        //GridView lstView=(GridView)findViewById(R.id.list);
        lstView.setAdapter(iteamAdapter);

        lstView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(NumbersActivity.this,"List item clicked",Toast.LENGTH_SHORT).show();
                Word word = words.get(position);
                mediaPlayer = MediaPlayer.create(FamilyActivity.this, word.getmAudioResourceID());
                mediaPlayer.start();
            }
        });

    }
}
