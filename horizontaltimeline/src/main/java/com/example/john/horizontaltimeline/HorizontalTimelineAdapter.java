package com.example.john.horizontaltimeline;

import android.content.Context;
import android.graphics.Point;
import android.support.v7.widget.RecyclerView;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

public class HorizontalTimelineAdapter extends RecyclerView.Adapter<HorizontalTimelineAdapter.HorizontalTimelineViewHolder> {

    private HorizontalTimelineViewHolder viewHolder;

    private static String[] timelineElements;
    private Context context;
    private LayoutInflater mInflater = null;

    private View timeline_circle;

    private static WindowManager wm;

    // Constructor
    public HorizontalTimelineAdapter(Context context, String[] timelineElements) {
        this.context = context;
        this.timelineElements = timelineElements;

        wm = (WindowManager) this.context.getSystemService(Context.WINDOW_SERVICE);

        if (context != null)
            mInflater = LayoutInflater.from(this.context);
    }

    @Override
    public HorizontalTimelineViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        timeline_circle = parent.findViewById(R.id.timeline_circle);
        viewHolder = new HorizontalTimelineViewHolder(mInflater.inflate(R.layout.timeline_list_item, parent, false));

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(HorizontalTimelineViewHolder holder, int position) {

        holder.tv.setText(timelineElements[position]);
    }

    @Override
    public int getItemCount() {
        return timelineElements.length;
    }

    public static class HorizontalTimelineViewHolder extends RecyclerView.ViewHolder {

        public TextView tv;

        Display display = wm.getDefaultDisplay();

        HorizontalTimelineViewHolder(View view) {
            super(view);

            Point size = new Point();
            display.getSize(size);
            int width = size.x;
            int height = size.y; // not in use

            tv = (TextView) view.findViewById(R.id.tv);

            view.setLayoutParams(new LinearLayout.LayoutParams(
                    width / (timelineElements.length),
                    LinearLayout.LayoutParams.MATCH_PARENT));


//            view.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Log.d("ViewHolder--", "Is clicked on position: " + getPosition());
//                }
//            });
        }
    }
}
