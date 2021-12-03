package test;
import com.sap.httpclient.HostConfiguration;
import com.sap.httpclient.HttpClient;
import com.sap.httpclient.http.methods.GET;

public class TestHTTP {
	public String targetHost = "10.14.8.61";
	public int targetPort = 8055;
	int status = 0;
	public int triggerHTTP(){
		String jwks_url = "https://10.14.8.61:8055/.well-known/openid-configuration/jwks";
		final HostConfiguration hostConfig = new HostConfiguration(this.targetHost, this.targetPort);
		final HttpClient httpClient = new HttpClient();
		httpClient.setHostConfiguration(hostConfig);
		final GET httpGet = new GET(jwks_url);
		httpGet.setFollowRedirects(true);
		try {
			System.out.println("Jwks:" + jwks_url);
			// Executing the method and get response
		    this.status = httpClient.executeMethod(httpGet);
			System.out.println("Status: " + this.status);
			System.out.println("Response: " + httpGet.getResponseBodyAsString());
	} catch (Exception e) {
		System.out.println("Error http" + e.getMessage());
	}
	return status;
	}
}
