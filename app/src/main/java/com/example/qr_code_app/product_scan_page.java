package com.example.qr_code_app;

import android.app.Activity;
import android.app.AlertDialog;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.Result;



import me.dm7.barcodescanner.zxing.ZXingScannerView;


public class product_scan_page extends Activity implements ZXingScannerView.ResultHandler {

    private ZXingScannerView mScannerView;
    TextView textView;
    MediaPlayer ScanSound;
    public String scanText;
    int count = 0, sl_no = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_scan_page);


        Toast.makeText(getApplicationContext(), "Congratulations! You have successfully entered Intellikart", Toast.LENGTH_LONG).show();


    }

    public void onClick(View v){
        mScannerView = new ZXingScannerView(this);
        setContentView(mScannerView);
        mScannerView.setResultHandler(this);
        mScannerView.startCamera();

    }



    @Override
    protected void onPause() {
        super.onPause();
        ScanSound.release();
        mScannerView.stopCamera();
    }



    @Override
    public void handleResult(Result result) {
        Log.w("handleResult", result.getText());
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Scan Result");
        builder.setMessage(result.getText());
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

        mScannerView.resumeCameraPreview(this);
        mScannerView.stopCamera();
        ScanSound = MediaPlayer.create(product_scan_page.this, R.raw.scan_sound);
        ScanSound.start();
        setContentView(R.layout.product_scan_page);
        textView = (TextView) findViewById(R.id.tv1);

        if(sl_no % 10 == 0)
        {
            int x = sl_no + 1;
            Toast.makeText(getApplicationContext(), "You have shopped for " + x + " items", Toast.LENGTH_LONG).show();
        }


            if (count == 0) {
                textView.setText("\n" + (sl_no + 1) + ") " + result.getText());
                scanText = "";
                count += 1;
                sl_no += 1;


            } else {
                textView.append(scanText + "\n" + (sl_no + 1) + ") " + result.getText());
                sl_no += 1;

            }
            if (scanText == null) {
                scanText = sl_no + ") " + result.getText();
            } else {
                scanText += "\n" + sl_no + ") " + result.getText();
            }


    }
}
