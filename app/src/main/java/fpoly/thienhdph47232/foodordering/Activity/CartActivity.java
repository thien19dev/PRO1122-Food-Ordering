package fpoly.thienhdph47232.foodordering.Activity;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import fpoly.thienhdph47232.foodordering.Adapter.CartAdapter;
import fpoly.thienhdph47232.foodordering.Helper.ChangeNumberItemsListener;
import fpoly.thienhdph47232.foodordering.Helper.ManagmentCart;
import fpoly.thienhdph47232.foodordering.R;
import fpoly.thienhdph47232.foodordering.databinding.ActivityCartBinding;

public class CartActivity extends AppCompatActivity {
    private ActivityCartBinding binding;
    private RecyclerView.Adapter adapter;
    private ManagmentCart managmentCart;
    private  double tax;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCartBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        managmentCart = new ManagmentCart(this);

        setVariable();
        caculataCart();
        initList();

    }

    private void initList() {
        if (managmentCart.getListCart().isEmpty()){
            binding.emptyTxt.setVisibility(View.VISIBLE);
            binding.scrollviewCart.setVisibility(View.GONE);
        }else{
            binding.emptyTxt.setVisibility(View.GONE);
            binding.scrollviewCart.setVisibility(View.VISIBLE);
        }

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        binding.cartRec.setLayoutManager(linearLayoutManager);
        adapter = new CartAdapter(managmentCart.getListCart(), this, () -> caculataCart());

        binding.cartRec.setAdapter(adapter);
    }

    private void caculataCart() {
        double percentTax = 0.02;
        double delivery = 10000;

        tax = Math.round((managmentCart.getTotalFee() * percentTax) * 100) / 100;
        double total = Math.round((managmentCart.getTotalFee() + tax + delivery) * 100) / 100;
        double itemTotal = Math.round(managmentCart.getTotalFee() * 100) / 100;

        binding.totalFeeTxt.setText(itemTotal + " VND");
        binding.taxTxt.setText(tax + " VND");
        binding.deliveryFeeTxt.setText(delivery + " VND");
        binding.totalTxt.setText(total + " VND");
    }

    private void setVariable() {
        binding.backBtn.setOnClickListener(view -> finish());
    }
}