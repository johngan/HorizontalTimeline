package com.jonganhf.horizontaltimelinedemo;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.jonganhf.horizontaltimeline.HorizontalTimeline;

public class MainActivity extends Activity{

    private RecyclerView mRecyclerView;
    private TextView tv_next;
    private TextView tv_previous;

    private HorizontalTimeline timeline;

    public static int CURRENT_STEP = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        tv_next = (TextView) findViewById(R.id.tv_next);
        tv_previous = (TextView) findViewById(R.id.tv_previous);

        final String[] data = {
                "AAAAA",
                "AAAAA",
                "AAAAA",
                "AAAAA",
                "AAAAA",
        };

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        // using the class
        timeline = new HorizontalTimeline(
                this,
                mRecyclerView,
                data,
                tv_previous,
                tv_next);


        tv_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CURRENT_STEP++;

                if (CURRENT_STEP < data.length)
                    timeline.stepForward(CURRENT_STEP);
            }
        });

        tv_previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (CURRENT_STEP < data.length)
                    timeline.stepBackward(CURRENT_STEP);

                CURRENT_STEP--;
            }
        });

    }

}
