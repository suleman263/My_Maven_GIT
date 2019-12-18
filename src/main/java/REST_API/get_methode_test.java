package REST_API;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class get_methode_test {

	public static void main(String[] args) throws ClientProtocolException, IOException {
		// TODO Auto-generated method stub
		CloseableHttpClient httpclient = HttpClients.createDefault();
		String url = "https://reqres.in/api/users?page=2";
		HttpGet httpget = new HttpGet(url);
		CloseableHttpResponse chr = httpclient.execute(httpget);
		int status_code = chr.getStatusLine().getStatusCode();
		System.out.println(status_code);
		
		String response_string=EntityUtils.toString(chr.getEntity(),"UTF-8");
		System.out.println(response_string);
		
		Header[] h=chr.getAllHeaders();
		HashMap<String,String> allh=new HashMap<String, String>();
		for(Header h1:h)
		{
			allh.put(h1.getName(), h1.getValue());
		}
System.out.println(allh);
	}

}
