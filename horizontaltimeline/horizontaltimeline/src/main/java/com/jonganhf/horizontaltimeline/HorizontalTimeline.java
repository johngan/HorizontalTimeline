package com.jonganhf.horizontaltimeline;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class HorizontalTimeline {

    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private Context context;
    private String[] data;
    private View buttonPrevious;
    private View buttonNext;
    private int currentStep = -1;

    private HorizontalTimelineAdapter mAdapter;

    public HorizontalTimeline(Context context, RecyclerView recyclerView,
                              String[] data, View buttonPrevious, View buttonNext){
        this.context = context;
        this.recyclerView = recyclerView;
        this.data = data;
        this.buttonPrevious = buttonPrevious;
        this.buttonNext = buttonNext;

        setup();
        setupButtonsControl(currentStep);
    }

    private void setup() {
        // define horizontal recycleView layout
        layoutManager = new LinearLayoutManager(context.getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);

        // setup the recycleView
        recyclerView.setLayoutManager(layoutManager);

        mAdapter = new HorizontalTimelineAdapter(context.getApplicationContext(), data);

        recyclerView.setAdapter(mAdapter);
    }


    /**
     *  When previous button is pressed
     */
    public void stepForward(int currentStep){
        setupButtonsControl(currentStep);

        layoutManager.getChildAt(currentStep).findViewById(R.id.timeline_circle)
                .setBackgroundResource(R.drawable.timeline_circle);
        layoutManager.getChildAt(currentStep).findViewById(R.id.timeline_line_left)
                .setBackgroundResource(R.drawable.timeline_line);

        if (currentStep > 0) {
            layoutManager.getChildAt(currentStep - 1)
                    .findViewById(R.id.timeline_line_right)
                    .setBackgroundResource(R.drawable.timeline_line);
        }
        if (currentStep == data.length - 1)
            layoutManager.getChildAt(currentStep)
                    .findViewById(R.id.timeline_line_right)
                    .setBackgroundResource(R.drawable.timeline_line);
    }

    /**
     *  When next button is pressed
     */
    public void stepBackward(int currentStep){
        setupButtonsControl(currentStep);

        layoutManager.getChildAt(currentStep).findViewById(R.id.timeline_circle)
                .setBackgroundResource(R.drawable.timeline_circle_black);
        layoutManager.getChildAt(currentStep).findViewById(R.id.timeline_line_left)
                .setBackgroundResource(R.drawable.timeline_line_black);

        if (currentStep > 0) {
            View childView_1 = layoutManager.getChildAt(currentStep - 1);
            childView_1.findViewById(R.id.timeline_line_right).setBackgroundResource(R.drawable.timeline_line_black);
        }
        if (currentStep == data.length - 1)
            layoutManager.getChildAt(currentStep)
                    .findViewById(R.id.timeline_line_right)
                    .setBackgroundResource(R.drawable.timeline_line_black);
    }

    /**
     *  To show or hide the Previous and Next buttons
     */
    private void setupButtonsControl(int currentStep){
        if (currentStep == -1 || currentStep == 0)
            buttonPrevious.setVisibility(View.GONE);
        else
            buttonPrevious.setVisibility(View.VISIBLE);
        if (currentStep == data.length - 1)
            buttonNext.setVisibility(View.GONE);
        else
            buttonNext.setVisibility(View.VISIBLE);
    }

}
