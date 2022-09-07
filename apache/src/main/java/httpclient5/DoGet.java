package httpclient5;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;

import java.io.IOException;

public class DoGet {
    public static void main(String[] args) {
        HttpGet request = new HttpGet("https://httpbin.org/headers");
        try (CloseableHttpResponse response = HttpClients.createDefault().execute(request);) {
            System.out.println(response.getCode());
            System.out.println(EntityUtils.toString(response.getEntity()));
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
}
