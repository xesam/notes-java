package httpclient5;

import org.apache.hc.core5.net.URIBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.net.URISyntaxException;

public class URIBuilderTest {
    @Test
    public void testParameterAndCustomQuery1() {
        try {
            URIBuilder uriBuilder = new URIBuilder("")
                    .addParameter("name", "xesam")
                    .setCustomQuery("age=18");
            Assert.assertEquals("?age=18", uriBuilder.toString());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testParameterAndCustomQuery2() {
        try {
            URIBuilder uriBuilder = new URIBuilder("")
                    .setCustomQuery("age=18")
                    .addParameter("name", "xesam");
            Assert.assertEquals("?name=xesam", uriBuilder.toString());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
