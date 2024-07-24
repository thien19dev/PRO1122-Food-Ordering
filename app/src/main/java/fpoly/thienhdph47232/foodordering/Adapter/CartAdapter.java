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
import fpoly.thienhdph47232.foodordering.Helper.ChangeNumberItemsListener;
import fpoly.thienhdph47232.foodordering.Helper.ManagmentCart;
import fpoly.thienhdph47232.foodordering.R;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder> {
    ArrayList<Foods> list = new ArrayList<>();
    private ManagmentCart managmentCart;
    ChangeNumberItemsListener changeNumberItemsListener;

    public CartAdapter(ArrayList<Foods> list, Context context, ChangeNumberItemsListener changeNumberItemsListener) {
        this.list = list;
        managmentCart = new ManagmentCart(context);
        this.changeNumberItemsListener = changeNumberItemsListener;
    }

    @NonNull
    @Override
    public CartAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cart, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull CartAdapter.ViewHolder holder, int position) {
        holder.titleTxt.setText(list.get(position).getTitle());
        holder.priceItemTxt.setText(list.get(position).getPrice() + " VND");
        holder.totalPriceTxt.setText(list.get(position).getPrice() * list.get(position).getNumberInCart() + " VND");
        holder.numTxt.setText(list.get(position).getNumberInCart() + "");

        holder.minusBtn.setOnClickListener(v -> {
            managmentCart.minusNumberItem(list, position, () -> changeNumberItemsListener.change());
        });

        holder.plusBtn.setOnClickListener(v -> {
            managmentCart.plusNumberItem(list, position, () -> changeNumberItemsListener.change());
        });

        Glide.with(holder.itemView.getContext())
                .load(list.get(position).getImagePath())
                .transform(new CenterCrop(), new RoundedCorners(30))
                .into(holder.pic);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView titleTxt, priceItemTxt, totalPriceTxt, minusBtn, numTxt, plusBtn;
        ImageView pic;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTxt = itemView.findViewById(R.id.titleTxt);
            priceItemTxt = itemView.findViewById(R.id.priceItemTxt);
            totalPriceTxt = itemView.findViewById(R.id.totalPriceTxt);
            minusBtn = itemView.findViewById(R.id.minusBtnInCart);
            numTxt = itemView.findViewById(R.id.numTxtInCart);
            plusBtn = itemView.findViewById(R.id.plusBtnInCart);
            pic = itemView.findViewById(R.id.pic);
        }

    }
}
