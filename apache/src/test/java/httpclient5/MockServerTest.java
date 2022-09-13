package httpclient5;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockserver.client.server.MockServerClient;
import org.mockserver.integration.ClientAndServer;
import org.mockserver.matchers.Times;
import org.mockserver.model.Header;
import org.mockserver.model.HttpRequest;
import org.mockserver.model.HttpResponse;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.concurrent.TimeUnit;

import static org.mockserver.integration.ClientAndServer.startClientAndServer;
import static org.mockserver.model.StringBody.exact;

public class MockServerTest {
    private static ClientAndServer mockServer;

    @BeforeClass
    public static void startServer() {
        mockServer = startClientAndServer(8081);
    }

    @AfterClass
    public static void stopServer() {
        mockServer.stop();
    }

    @Test
    public void testWithParams() throws IOException, URISyntaxException {
        new MockServerClient("127.0.0.1", 8081)
                .when(
                        HttpRequest.request()
                                .withMethod("POST")
                                .withPath("/validate")
                                .withHeader("\"Content-type\", \"application/json\"")
                                .withBody(exact("{username: 'foo', password: 'bar'}")),
                        Times.exactly(1)
                )
                .respond(
                        HttpResponse.response()
                                .withStatusCode(401)
                                .withHeaders(
                                        new Header("Content-Type", "application/json; charset=utf-8")
                                ).withBody("{ message: 'incorrect username and password combination' }")
                                .withDelay(TimeUnit.SECONDS, 1)
                );
//
//        HttpGet request = new HttpGet("http://httpbin.org");
//        request.addHeader("header1", "value1");


//        HttpClient httpClient = spy(HttpClient.class);
//        when(httpClient.execute(any())).thenReturn(null);
//        HttpResponse response = httpClient.execute(request);
//        System.out.println(response);
    }
}
