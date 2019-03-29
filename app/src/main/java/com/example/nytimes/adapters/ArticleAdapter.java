package com.example.nytimes.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nytimes.model.NyArticle;
import com.example.nytimes.R;

import java.util.List;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.CustomViewHolder> {

    private List<NyArticle> articlesList;
    private Context context;

    public ArticleAdapter(Context context,List<NyArticle> articlesList){
        this.context = context;
        this.articlesList = articlesList;
    }


    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.article_cardview, viewGroup, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CustomViewHolder customViewHolder, int i) {
        customViewHolder.titleTextView.setText(articlesList.get(i).getTitle());
        customViewHolder.byLineTextView.setText(articlesList.get(i).getByline());
        customViewHolder.publishDateTextView.setText(articlesList.get(i).getPublished_date());

        customViewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customViewHolder.byLineTextView.setVisibility(customViewHolder.byLineTextView.getVisibility()== View.VISIBLE? View.GONE: View.VISIBLE);
                customViewHolder.publishDateTextView.setVisibility(customViewHolder.publishDateTextView.getVisibility()== View.VISIBLE? View.GONE: View.VISIBLE);
            }
        });
    }

    @Override
    public int getItemCount() {
        return articlesList.size();
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {

        public final View mView;

        TextView titleTextView;
        TextView byLineTextView;
        TextView publishDateTextView;
        ImageView image;

        CardView cardView;
        CustomViewHolder(View itemView) {
            super(itemView);
            mView = itemView;

            titleTextView = itemView.findViewById(R.id.title_textView);
            byLineTextView = itemView.findViewById(R.id.byline_textView);
            publishDateTextView = itemView.findViewById(R.id.publishDate_textView);
            cardView = itemView.findViewById(R.id.card_view);

            image = mView.findViewById(R.id.image);

        }
    }
}
