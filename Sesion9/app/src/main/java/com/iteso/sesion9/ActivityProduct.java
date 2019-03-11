package com.iteso.sesion9;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.iteso.sesion9.beans.ItemProduct;

public class ActivityProduct extends AppCompatActivity {

    private ImageView image;
    private EditText title;
    private EditText store;
    private EditText location;
    private EditText phone;
    private Button save;
    private Button cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        final ItemProduct itemProduct = getIntent().getParcelableExtra("ITEM");

        image = findViewById(R.id.activity_product_image);
        title = findViewById(R.id.activity_product_title);
        store = findViewById(R.id.activity_product_store);
        location = findViewById(R.id.activity_product_location);
        phone = findViewById(R.id.activity_product_phone);
        save = findViewById(R.id.activity_product_save);
        cancel = findViewById(R.id.activity_product_cancel);

        title.setText(itemProduct.getTitle());
        store.setText(itemProduct.getStore());
        location.setText(itemProduct.getLocation());
        phone.setText(itemProduct.getPhone());

        switch (itemProduct.getImage()) {
            case 0:
                image.setImageResource(R.drawable.mac); break;
            case 1:
                image.setImageResource(R.drawable.alienware); break;
            case 2:
                image.setImageResource(R.drawable.pillows); break;
            case 3:
                image.setImageResource(R.drawable.micro); break;
        }

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemProduct.setTitle(title.getText().toString());
                itemProduct.setStore(store.getText().toString());
                itemProduct.setLocation(location.getText().toString());
                itemProduct.setPhone(phone.getText().toString());

                Intent intent = new Intent();
                intent.putExtra("ITEM", itemProduct);
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("ITEM", itemProduct);
                setResult(Activity.RESULT_CANCELED, intent);
                finish();
            }
        });

    }
}
