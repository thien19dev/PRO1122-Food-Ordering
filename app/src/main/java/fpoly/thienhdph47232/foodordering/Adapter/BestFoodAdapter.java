package fpoly.thienhdph47232.foodordering.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;

import java.util.ArrayList;

import fpoly.thienhdph47232.foodordering.Activity.DetailFoodActivity;
import fpoly.thienhdph47232.foodordering.Domain.Foods;
import fpoly.thienhdph47232.foodordering.R;

public class BestFoodAdapter extends RecyclerView.Adapter<BestFoodAdapter.viewHolder> {
    ArrayList<Foods> item;
    Context context;

    public BestFoodAdapter(ArrayList<Foods> item) {
        this.item = item;
    }

    @NonNull
    @Override
    public BestFoodAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_best_deal,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BestFoodAdapter.viewHolder holder, int position) {
        holder.tittleTxt.setText(item.get(position).getTitle());
        holder.priceTxt.setText(item.get(position).getPrice() + "VND");
        holder.timeTxt.setText(item.get(position).getTimeValue() + "phút");
        holder.starTxt.setText("" + item.get(position).getStar());

        Glide.with(context).load(item.get(position).getImagePath())
                .transform(new CenterCrop(), new RoundedCorners(30))
                .into(holder.foodsImage);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailFoodActivity.class);
                intent.putExtra("object", item.get(position));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {

        return item.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView tittleTxt, priceTxt, starTxt, timeTxt;
        ImageView foodsImage;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            tittleTxt = itemView.findViewById(R.id.titleTxt);
            timeTxt = itemView.findViewById(R.id.timeTxt);
            starTxt = itemView.findViewById(R.id.starTxt);
            priceTxt = itemView.findViewById(R.id.priceTxt);
            foodsImage = itemView.findViewById(R.id.foodsImage);

        }
    }
}
