package httpclient5;

import org.apache.hc.core5.net.URIBuilder;

import java.net.URISyntaxException;

public class _URIBuilder {
    public static void main(String[] args) {
        try {
            URIBuilder uriBuilder = new URIBuilder("")
                    .addParameter("name", "xesam")
                    .setCustomQuery("age=18");
            System.out.println(uriBuilder.toString());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
