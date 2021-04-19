
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
        displayQuantity(quantity);
    }


    public void decrement(View view)  {
        if (quantity>0) {
            quantity--;
            displayQuantity(quantity);
        }
    }


    public void submitOrder(View view) {
        // int coffeesOrdered = quantity;
        int price = quantity * 5;
        String priceMessage = "Thank you for ordering " + quantity + " Coffees! \nAmount Due: $" + price; //I used an escape sequence \" to include the quotes around free
        priceMessage = priceMessage + "\n\nYour order will be right up!"; //Double \n escape key for w line separation
        displayMessage(priceMessage);
    }
    /**
     * This method displays the given text on the screen.
     */

    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }

    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText(" " + number);

    }
    private void displayPrice ( int number){
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

}