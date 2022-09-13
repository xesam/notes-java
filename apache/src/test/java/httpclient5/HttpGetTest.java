package httpclient5;

import org.apache.hc.client5.http.classic.HttpClient;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.classic.methods.HttpUriRequestBase;
import org.apache.hc.client5.http.entity.UrlEncodedFormEntity;
import org.apache.hc.core5.http.HttpResponse;
import org.apache.hc.core5.http.NameValuePair;
import org.apache.hc.core5.http.message.BasicNameValuePair;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.stubbing.Answer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class HttpGetTest {

    @Test
    public void testGet() throws IOException {
        HttpGet request = new HttpGet("http://httpbin.org/1");
        request.addHeader("header1", "value1");

        HttpClient httpClient = spy(HttpClient.class);
        when(httpClient.execute(any())).thenAnswer((Answer<HttpResponse>) invocationOnMock -> {
            Object[] args = invocationOnMock.getArguments();
            HttpUriRequestBase argRequest = (HttpUriRequestBase) args[0];
            Assert.assertEquals("/1", argRequest.getPath());
            Assert.assertEquals("GET", argRequest.getMethod());
            Assert.assertEquals("value1", argRequest.getHeader("header1").getValue());
            return null;
        });
        httpClient.execute(request);
    }

    @Test
    public void testPost() throws IOException {
        HttpPost request = new HttpPost("http://httpbin.org/1");
        request.addHeader("header1", "value1");
        List<NameValuePair> data = new ArrayList<>();
        data.add(new BasicNameValuePair("name", "value"));
        data.add(new BasicNameValuePair("name2", "value2"));
        request.setEntity(new UrlEncodedFormEntity(data));

        HttpClient httpClient = spy(HttpClient.class);
        when(httpClient.execute(any())).thenAnswer((Answer<HttpResponse>) invocationOnMock -> {
            Object[] args = invocationOnMock.getArguments();
            HttpPost argRequest = (HttpPost) args[0];
            Assert.assertEquals("/1", argRequest.getPath());
            Assert.assertEquals("POST", argRequest.getMethod());
            System.out.println(new BufferedReader(new InputStreamReader(argRequest.getEntity().getContent())).readLine());
            Assert.assertEquals("value1", argRequest.getHeader("header1").getValue());
            return null;
        });
        httpClient.execute(request);
    }
}
