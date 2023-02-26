package com.example.eventlistenerexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button myButton;
    private EditText myEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get references to the button and edit text views
        myButton = findViewById(R.id.myButton);
        myEditText = findViewById(R.id.myEditText);

        // Attach an event listener to the button
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Define a callback function to handle the click event
                handleButtonClick();
            }
        });

        // Attach an event listener to the edit text field
        myEditText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                // Define a callback function to handle key events
                if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
                        (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    handleEnterKey();
                    return true;
                }
                return false;
            }
        });
    }

    private void handleButtonClick() {
        // Perform some action when the button is clicked
        Toast.makeText(this, "Button clicked!", Toast.LENGTH_SHORT).show();
    }

    private void handleEnterKey() {
        // Perform some action when the enter key is pressed
        String input = myEditText.getText().toString();
        Toast.makeText(this, "You entered: " + input, Toast.LENGTH_SHORT).show();
        myEditText.getText().clear();
    }
}