package com.delisar.relo.Dashboard;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.delisar.relo.DetailNews;
import com.delisar.relo.Profile.ImageActivity;
import com.delisar.relo.R;

import java.util.List;

public class DashboardAdapter extends RecyclerView.Adapter<DashboardAdapter.NewsViewHolder> {
    private Context mContext;
    private List<News> newsList;


    public DashboardAdapter(Context mContext, List<News> newsList) {
        this.mContext = mContext;
        this.newsList = newsList;
    }

    @Override
    public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate( R.layout.content_dashboard, null);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NewsViewHolder news, int i) {
        news.bind(newsList.get(i));
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    class NewsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView titleNews, textNews;
        ImageView imageNews;

        public NewsViewHolder(View itemView) {
            super(itemView);

            titleNews = itemView.findViewById(R.id.titleNews);
            textNews = itemView.findViewById(R.id.textNews);
            imageNews = itemView.findViewById(R.id.imageNews);
            itemView.setOnClickListener(this);
        }

        void bind(News news) {
            titleNews.setText(news.getTitleNews());
            textNews.setText(news.getBodyNews());
            imageNews.setImageResource(news.getImage());

            textNews.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(view.getContext(), DetailNews.class);
                    view.getContext().startActivity(intent);

                    //Toast.makeText(mContext, "Clicked Text", Toast.LENGTH_SHORT).show();
                }
            });
        }

        @Override
        public void onClick(View view) {
            //Toast.makeText(mContext, titleNews.getText().toString(), Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(view.getContext(), DetailNews.class);
            view.getContext().startActivity(intent);
        }
    }

}
