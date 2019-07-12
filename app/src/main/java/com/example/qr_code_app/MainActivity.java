package com.example.qr_code_app;

        import android.app.Activity;
        import android.app.AlertDialog;
        import android.content.Intent;
        import android.os.Bundle;
        import android.util.Log;
        import android.view.Gravity;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.TextView;
        import android.widget.Toast;

        import com.google.zxing.Result;

        import me.dm7.barcodescanner.zxing.ZXingScannerView;


public class MainActivity extends Activity implements ZXingScannerView.ResultHandler {

    private ZXingScannerView mScannerView;
    TextView textView;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LayoutInflater inflater = getLayoutInflater();
        View appearance = inflater.inflate(R.layout.custom_toast, (ViewGroup) findViewById(R.id.custom_toast_linear));
        Toast toast = new Toast(this);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.setView(appearance);
        toast.show();
    }

    public void onClick(View v){
        mScannerView = new ZXingScannerView(this);
        setContentView(mScannerView);
        mScannerView.setResultHandler(this);
        mScannerView.startCamera();
        count++;

    }



    @Override
    protected void onPause() {
        super.onPause();
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
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.tv1);
        textView.append(result.getText());
        if (textView.getText().toString().equals("Intellikart Cart 12345")){
            mScannerView.stopCamera();
            Intent i = new Intent(MainActivity.this , login_authentication.class);
            startActivity(i);
        }
    }
}
