package com.reality.escape.partnerapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CheckBox;

/**
 * Created by JR HARI NANDHA on 28-12-2016.
 */

public class Payment extends AppCompatActivity {

    private CheckBox net,cod,debit,credit;
    static int netc,codc,debitc,creditc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        net=(CheckBox) findViewById(R.id.net);
        if(net.isChecked()){
            netc = 1;
        }
        else{
            netc = 0;
        }
        cod=(CheckBox) findViewById(R.id.COD);
        if(cod.isChecked()){
            codc = 1;
        }
        else{
            codc = 0;
        }
        debit=(CheckBox) findViewById(R.id.debit);
        if(debit.isChecked()){
            debitc = 1;
        }
        else{
            debitc = 0;
        }
        credit=(CheckBox) findViewById(R.id.credit);
        if(credit.isChecked()){
            creditc = 1;
        }
        else{
            creditc = 0;
        }
        if(netc == 1){
            net.setChecked(true);
        }
        if(codc == 1){
            net.setChecked(true);
        }
        if(debitc == 1){
            net.setChecked(true);
        }
        if(creditc == 1){
            net.setChecked(true);
        }
    }
}
