package com.example.justjavalange;



import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import java.text.NumberFormat;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int quantity = 0;

    public void increment(View view) {
        int quantity = 2;
        quantity = 3;
        quantity = 4;
        quantity = 5;
        display(quantity);
    }

    public void decrement(View view) {
        int quantity = 1;
        display(quantity);
    }

    public void submitOrder(View view) {
        int numberOfCoffees = quantity;
        display(quantity );
        displayPrice(numberOfCoffees*5);
    }


    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }
}