package com.example.todo.Alert;

import android.content.Context;
import android.content.DialogInterface;

import androidx.appcompat.app.AlertDialog;

public class Alert {
    public static void alertdi(Context context,String sms){
        AlertDialog.Builder alertDialog =new AlertDialog.Builder(context);
        alertDialog.setTitle(sms).setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        }).create().show();
    }
}
