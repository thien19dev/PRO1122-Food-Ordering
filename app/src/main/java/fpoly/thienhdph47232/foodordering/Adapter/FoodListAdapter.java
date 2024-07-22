package fpoly.thienhdph47232.foodordering.Adapter;

import android.content.Context;
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

import fpoly.thienhdph47232.foodordering.Domain.Foods;
import fpoly.thienhdph47232.foodordering.R;

public class FoodListAdapter extends RecyclerView.Adapter<FoodListAdapter.viewholder> {
    ArrayList<Foods> items;
    Context context;

    public FoodListAdapter(ArrayList<Foods> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public FoodListAdapter.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View inflate = LayoutInflater.from(context).inflate(R.layout.viewholder_list_food, parent, false);
        return new viewholder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodListAdapter.viewholder holder, int position) {
        holder.titleTxt.setText(items.get(position).getTitle());
        holder.timeTxt.setText(items.get(position).getTimeValue() + " Phút");
//        holder.priceTxt.setText(String.valueOf(items.get(position).getPrice()));
//        holder.rateTxt.setText(String.valueOf(items.get(position).getStar()));
        holder.priceTxt.setText(items.get(position).getPrice() + " VND");
        holder.rateTxt.setText("" + items.get(position).getStar());


        Glide.with(context)
                .load(items.get(position).getImagePath())
                .transform(new CenterCrop(), new RoundedCorners(30))
                .into(holder.pic);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {
        TextView titleTxt, priceTxt, timeTxt, rateTxt;
        ImageView pic;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            titleTxt = itemView.findViewById(R.id.titleFoodListViewTxt);
            timeTxt = itemView.findViewById(R.id.timeListViewTxt);
            priceTxt = itemView.findViewById(R.id.priceListFoodTxt);
            rateTxt = itemView.findViewById(R.id.rateTxt);
            pic = itemView.findViewById(R.id.picFood);
        }
    }
}
