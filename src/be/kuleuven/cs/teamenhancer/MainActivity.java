package be.kuleuven.cs.teamenhancer;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
      loadWebApp();
      
      final Button reloadButton = (Button) findViewById(R.id.reloadButton);
      reloadButton.setOnClickListener(this);
      
    }

	private WebView getWebView() {
		return (WebView) findViewById(R.id.webView1);
	}
	
	@SuppressLint("SetJavaScriptEnabled")
	private void loadWebApp() {
		final WebView mapsView = getWebView();
		mapsView.getSettings().setJavaScriptEnabled(true);
		mapsView.getSettings().setGeolocationEnabled(true);
		mapsView.loadUrl(getResources().getString(R.string.coos_server));
	}
	
	@Override
	public void onClick(View v) {
		getWebView().reload();
	}
}