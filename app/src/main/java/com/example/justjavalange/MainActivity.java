
package com.example.justjavalange;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;


public class MainActivity extends AppCompatActivity {



    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void increment(View view) {
        quantity++;
        display(quantity);
    }


    public void decrement(View view)  {
        if (quantity>0) {
            quantity--;
            display(quantity);
        }
    }


    public void submitOrder(View view) {
        int price = quantity * 5;
        String priceMessage = "Total $" + price;
        priceMessage = priceMessage + "\nThank you!";
        displayMessage(priceMessage);
    }
    /**
     * This method displays the given text on the screen.
     */

    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }

    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText(" " + number);

    }
    private void displayPrice ( int number){
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

}