package com.android.shikha.textinputlayoutexample;

import android.content.Context;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    private Context mContext;
    private TextInputLayout mUsernameConatiner, mPasswordContainer;
    private EditText mUsername, mPassword;
    private Button mSubmit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeComponents();
        mSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validate()) {
                    Toast.makeText(mContext, "Information added successfully!!!", Toast.LENGTH_LONG).show();
                    clearText();
                }
            }
        });
    }

    private void clearText() {
        mUsername.setText("");
        mPassword.setText("");
    }

    /**
     * Function to validate for not empty condition
     */

    private boolean validate() {
        if (mUsername.getText().toString().equals("")) {
            showError(mUsernameConatiner, "Enter username!!!");
            return false;
        } else if (mPassword.getText().toString().equals("")) {
            showError(mPasswordContainer, "Enter password");
            return false;
        } else return true;

    }


    /**
     * Function to initialize required components
     */
    private void initializeComponents() {
        mContext = this;
        mUsernameConatiner = (TextInputLayout) findViewById(R.id.usernameContainer);
        mPasswordContainer = (TextInputLayout) findViewById(R.id.passwordContainer);
        mUsername = (EditText) findViewById(R.id.etUsername);
        mPassword = (EditText) findViewById(R.id.etPassword);
        mSubmit = (Button) findViewById(R.id.btnSubmit);
        mUsername.addTextChangedListener(customTextWatcher);
        mPassword.addTextChangedListener(customTextWatcher);


    }


    /**
     * Function to hide error message from textinputlayout
     */
    private void hideError(TextInputLayout mContainer) {
        mContainer.setErrorEnabled(false);
        mContainer.setError(null);
    }

    /**
     * Function to show error message from textinputlayout
     */
    private void showError(TextInputLayout mConatiner, String s) {
        mConatiner.setErrorEnabled(true);
        mConatiner.setError(s);
    }

    private TextWatcher customTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            if (mUsername.getText().hashCode() == s.hashCode()) {
                hideError(mUsernameConatiner);
            } else if (mPassword.getText().hashCode() == s.hashCode()) {
                hideError(mPasswordContainer);
            }

        }
    };


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
