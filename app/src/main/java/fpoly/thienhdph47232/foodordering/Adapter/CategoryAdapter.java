package fpoly.thienhdph47232.foodordering.Adapter;

import static fpoly.thienhdph47232.foodordering.R.drawable.cat_3_background;

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

import fpoly.thienhdph47232.foodordering.Domain.Categories;
import fpoly.thienhdph47232.foodordering.Domain.Foods;
import fpoly.thienhdph47232.foodordering.R;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.viewHolder> {
    ArrayList<Categories> items;
    Context context;

    public CategoryAdapter(ArrayList<Categories> item) {
        this.items = item;
    }

    @NonNull
    @Override
    public CategoryAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_holder_categories,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.viewHolder holder, int position) {
        holder.catNameTxt.setText(items.get(position).getName());

        switch (position){
            case 0:{
                holder.imgCat.setBackgroundResource(R.drawable.cat_0_background);
                break;
            }
            case 1:{
                holder.imgCat.setBackgroundResource(R.drawable.cat_1_background);
                break;
            }
            case 2:{
                holder.imgCat.setBackgroundResource(R.drawable.cat_2_background);
                break;
            }
            case 3:{
                holder.imgCat.setBackgroundResource(R.drawable.cat_0_background);
                break;
            }
            case 4:{
                holder.imgCat.setBackgroundResource(R.drawable.cat_8_background);
                break;
            }
            case 5:{
                holder.imgCat.setBackgroundResource(R.drawable.cat_5_background);
                break;
            }
            case 6:{
                holder.imgCat.setBackgroundResource(R.drawable.cat_0_background);
                break;
            }
            case 7:{
                holder.imgCat.setBackgroundResource(R.drawable.cat_2_background);
                break;
            }
        }

        int drawableResourceId = context.getResources().getIdentifier(items.get(position).getImagePath(),
                "drawable",
                holder.itemView.getContext().getPackageName());

        Glide.with(context)
                .load(drawableResourceId)
                .into(holder.imgCat);

    }

    @Override
    public int getItemCount() {

        return items.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView catNameTxt;
        ImageView imgCat;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            imgCat = itemView.findViewById(R.id.imgCat);
            catNameTxt = itemView.findViewById(R.id.catNameTxt);

        }
    }
}
