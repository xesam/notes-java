package httpclient5;

import org.apache.hc.client5.http.classic.methods.HttpPatch;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.entity.UrlEncodedFormEntity;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.NameValuePair;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.message.BasicNameValuePair;
import org.apache.hc.core5.net.URIBuilder;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class DoPatch {
    public static void main(String[] args) {
        HttpPatch request = new HttpPatch("https://httpbin.org/anything");
        request.addHeader("Token", "1234567890");
        List<NameValuePair> pairs = new ArrayList<>();
        pairs.add(new BasicNameValuePair("name", "xesam"));
        pairs.add(new BasicNameValuePair("age", "18"));
        request.setEntity(new UrlEncodedFormEntity(pairs, StandardCharsets.UTF_8));
        try (CloseableHttpResponse response = HttpClients.createDefault().execute(request);) {
            System.out.println(response.getCode());
            System.out.println(EntityUtils.toString(response.getEntity()));
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
}
