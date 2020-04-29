package com.example.ex052;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText aValue;
    EditText bValue;
    EditText cValue;

    Button btnGraph;
    Button btnClear;

    WebView wV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        aValue = (EditText)findViewById(R.id.aValue);
        bValue = (EditText)findViewById(R.id.bValue);
        cValue = (EditText)findViewById(R.id.cValue);

        btnGraph = (Button)findViewById(R.id.btnGraph);
        btnClear = (Button)findViewById(R.id.btnClear);

        wV = (WebView)findViewById(R.id.wV);

        wV.getSettings().setJavaScriptEnabled(true);
        wV.setWebViewClient(new MyWebViewClient());

        wV.loadUrl("https://media.tenor.com/images/bdc934496f843d4863a960ca3ffd355f/tenor.gif");
    }

    public void showGraph(View view) {
        String aString = aValue.getText().toString();
        String bString = bValue.getText().toString();
        String cString = cValue.getText().toString();

        // if one of the cells is empty
        if (aString.equals("") || bString.equals("") || cString.equals("") || aString.equals("-") || cString.equals("-") || bString.equals("-"))
        {
            Toast.makeText(this, "Enter a number in each cell!", Toast.LENGTH_SHORT).show();
        }
        else if (Float.parseFloat(aString) == 0){
            Toast.makeText(this, "a cannot be equal to 0!", Toast.LENGTH_SHORT).show();
        }
        else {
            wV.loadUrl("https://www.google.com/search?q=" + aString + "x%5E2%2B" + bString + "*x%2B" + cString);
        }
    }

    public void clear(View view) {
        aValue.setText("");
        bValue.setText("");
        cValue.setText("");

        wV.loadUrl("https://media.tenor.com/images/bdc934496f843d4863a960ca3ffd355f/tenor.gif");
    }

    private class MyWebViewClient extends WebViewClient {
        public boolean shouldOverideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}
