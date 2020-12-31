package com.heshmat.learnandroid;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.heshmat.learnandroid.models.Topic;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class TopicAdapter extends RecyclerView.Adapter<TopicAdapter.ViewHolder> {
    List<Topic> topics;
    Context context;

    public TopicAdapter(List<Topic> topics, Context context) {
        this.topics = topics;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.topic_layout, parent, false);
        return new ViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Topic topic=topics.get(position);
        holder.topicNameTv.setText(topic.getTitle());
        holder.levelTv.setText(topic.getLevel());
        holder.statusIv.setImageResource(topic.getStatus()==0?R.drawable.ic_radio_button_unchecked_black_24dp:R.drawable.ic_check_circle_black_24dp);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Topic.currentChosenTopic=topic;
                Intent intent=new Intent(context,TopicActivity.class);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return topics.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        TextView topicNameTv;
        TextView levelTv;
        ImageView statusIv;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView=itemView.findViewById(R.id.topicCv);
            topicNameTv=itemView.findViewById(R.id.topicNameTv);
            levelTv=itemView.findViewById(R.id.levelTv);
            statusIv=itemView.findViewById(R.id.statusIv);


        }
    }
}
