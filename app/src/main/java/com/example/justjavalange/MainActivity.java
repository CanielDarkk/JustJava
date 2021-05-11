
package com.example.justjavalange;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
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
        // Figure out if user wants Whipped Cream
        EditText nameField = (EditText) findViewById(R.id.name_field)
        String value = nameField.getText().toString();
        Log.v(tag: "MainActivity", msg: "Name: " + value);

        // Figure out if user wants chocolate topping
        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.chocolate_checkbox);
        boolean hasChocolate = chocolateCheckBox.isChecked();

        // Calculate Price
        int price = calculatePrice();

        // Display the order summary on the screen
        CheckBox whippedCreamCheckBox= (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();
        Log.v(tag: "MainActivity", msg: "Has whipped cream: " + hasWhippedCream)

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
    private String createOrderSummary(int price, boolean addWhippedCream, boolean addChocolate) {
        String priceMessage = "Thank you for ordering " + quantity + " Coffees! \nAmount Due: $" + price;
        priceMessage += "\nAdd Whipped Cream? " + addWhippedCream;
        priceMessage += "/nAdd Chocolate Topping " + addChocolate;
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