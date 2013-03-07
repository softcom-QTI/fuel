package pro.softcom.fuel.fueldroid.request;

import java.net.URI;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.impl.client.DefaultHttpClient;

import com.octo.android.robospice.request.SpiceRequest;

public class RefillRequest extends SpiceRequest<Void> {
	
	private String tankerId;
	private String machineId;
	private long timestamp;
	private long liters;
	
	public RefillRequest(String tankerId, String machineId, long timestamp,
			long liters) {
		super(Void.class);
		this.tankerId = tankerId;
		this.machineId = machineId;
		this.timestamp = timestamp;
		this.liters = liters;
	}
	
	@Override
	public Void loadDataFromNetwork() throws Exception {
		
		DefaultHttpClient httpClient = new DefaultHttpClient();
		
		String uriStr = "http://fuel.reto.cloudbees.net/ws/refill";
		uriStr += "/" + timestamp;
		uriStr += "/" + tankerId;
		uriStr += "/" + machineId;
		uriStr += "?liters=" + liters;
		
		HttpPut putReq = new HttpPut(new URI(uriStr));
		
		httpClient.execute(putReq);
		
		return null;
	}
	
	public String getTankerId() {
		return tankerId;
	}
	
	public String getMachineId() {
		return machineId;
	}
	
	public long getTimestamp() {
		return timestamp;
	}
	
	public long getLiters() {
		return liters;
	}

	@Override
	public boolean equals(Object o) {
		return EqualsBuilder.reflectionEquals(this, o, false);
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this, false);
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}


}
