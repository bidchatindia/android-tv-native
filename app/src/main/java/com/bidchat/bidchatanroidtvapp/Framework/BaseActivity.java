package com.bidchat.bidchatanroidtvapp.Framework;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.Toast;

/**
 * Created by abhik on 05-10-2016.
 */
public class BaseActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


    public BidApplication getBidApplication()
    {
        return ((BidApplication) getApplication());
    }

    public void showToast(String message)
    {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    public ProgressDialog progressDialog;
    public void showProgressBar(String message)
    {
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle(message);
        progressDialog.show();
    }

    public void hideProgressBar()
    {
        progressDialog.dismiss();
    }


    public void showInDailog(String title, String message)
    {
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle(title)
                .setMessage(message)
                .create();
        dialog.show();
    }
}