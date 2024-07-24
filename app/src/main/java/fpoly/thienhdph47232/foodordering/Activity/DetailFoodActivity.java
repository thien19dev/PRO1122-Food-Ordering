package fpoly.thienhdph47232.foodordering.Activity;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;

import fpoly.thienhdph47232.foodordering.Domain.Foods;
import fpoly.thienhdph47232.foodordering.Helper.ManagmentCart;
import fpoly.thienhdph47232.foodordering.R;
import fpoly.thienhdph47232.foodordering.databinding.ActivityDetailFoodBinding;
import fpoly.thienhdph47232.foodordering.databinding.ActivityLoginBinding;

public class DetailFoodActivity extends BaseActivity {
    ActivityDetailFoodBinding binding;
    private Foods object;
    private int num = 1;
    private ManagmentCart managmentCart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        binding = ActivityDetailFoodBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getWindow().setStatusBarColor(getResources().getColor(R.color.black));

        getIntentExtra();
        setVariable();
    }

    private void setVariable() {
        managmentCart = new ManagmentCart(this);

        binding.backBtn.setOnClickListener(v -> finish());

        Glide.with(DetailFoodActivity.this).load(object.getImagePath()).into(binding.pic);

        binding.titleTxt.setText(object.getTitle());
        binding.priceTxt.setText(object.getPrice() + " VND");
        binding.rateTxt.setText("" + object.getStar());
        binding.descriptionTxt.setText(object.getDescription());
        binding.timeTxt.setText(object.getTimeValue() + " phút");
        binding.totalTxt.setText(num + object.getPrice()+" VND");

        binding.plusBtn.setOnClickListener(v -> {
            num = num + 1;
            binding.numTxt.setText(num + "");
            binding.totalTxt.setText((num * object.getPrice()) + " VND");
        });
        binding.minusBtn.setOnClickListener(v -> {
            num = num - 1;
            binding.numTxt.setText(num + "");
            binding.totalTxt.setText((num * object.getPrice()) + " VND");
        });
        binding.AddToCartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                object.setNumberInCart(num);
                managmentCart.insertFood(object);
            }
        });
    }

    private void getIntentExtra() {
        object =  (Foods) getIntent().getSerializableExtra("object");
    }
}