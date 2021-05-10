
package com.example.justjavalange;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
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
        CheckBox whippedCreamCheckBox = (CheckBox)findViewById(R.id.whipped_cream_checkbox);
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();
        Log.v("MainActivity", "Has whipped cream:" + hasWhippedCream);
        int price = calculatePrice();
        String priceMessage = createOrderSummary(price, hasWhippedCream);
        displayMessage(priceMessage);



    }
    /**
     * This method displays the given text on the screen.
     */
    private int calculatePrice() {
        int price = quantity * 5;
        return price;
    }

    /**
     *
     * @param price of the order
     * @param addWhippedCream is whether or not the user wants whipped cream topping
     * @return priceMessage
     */

    /**
     * Create a summary of our order
     *
     * @param price
     * @return priceMessage
     */
    private String createOrderSummary(int price, boolean addWhippedCream) {
        String priceMessage = "Thank you for ordering " + quantity + " Coffees! \nAmount Due: $" + price;
        priceMessage += "\nAdd Whipped Cream? " + addWhippedCream;
        priceMessage += "\n\nYour order will be right up!";
        return priceMessage;
    }

    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }

    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText(" " + number);
    }}