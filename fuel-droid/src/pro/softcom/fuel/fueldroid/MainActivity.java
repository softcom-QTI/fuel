package pro.softcom.fuel.fueldroid;

import pro.softcom.fuel.fueldroid.request.RefillRequest;
import android.app.Activity;
import android.os.Bundle;
import android.text.format.Time;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.octo.android.robospice.SpiceManager;
import com.octo.android.robospice.UncachedSpiceService;
import com.octo.android.robospice.persistence.exception.SpiceException;
import com.octo.android.robospice.request.listener.RequestListener;

public class MainActivity extends Activity {
	
	private SpiceManager spiceMgr = new SpiceManager(UncachedSpiceService.class);
	
	private EditText machineId;
	private EditText liters;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		spiceMgr.start(this);
		initUI();
	}
	
	@Override
	protected void onStop() {
		spiceMgr.shouldStop();
		super.onStop();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	
	private void initUI() {
		Button sendButton = (Button) findViewById(R.id.button1);
		machineId = (EditText) findViewById(R.id.autoCompleteTextView1);
		liters = (EditText) findViewById(R.id.editText1);
		
		sendButton.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View view) {
				performRequest(machineId.getText().toString(), liters.getText().toString());
			}
		});
	}
	
	private void performRequest(String machineId, String liters) {
		setProgressBarIndeterminateVisibility(true);
		
		String tankerId = "T111";
		long ltrs = Long.parseLong(liters);
		long timestamp = (new Time()).toMillis(false);
		
		RefillRequest req = new RefillRequest(tankerId, machineId, timestamp, ltrs);
		spiceMgr.execute(req, new RefillRequestListener());
	}
	
	/**
	 * Listener class for Refill request. 
	 */
	private class RefillRequestListener implements RequestListener<Void> {

		public void onRequestFailure(SpiceException spiceException) {
			// TODO Auto-generated method stub
			
		}

		public void onRequestSuccess(Void result) {
			// TODO Auto-generated method stub
			
		}
		
	}

}
