package github.action.experiment;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.runtime.server.EmbeddedServer;
import io.micronaut.test.annotation.MicronautTest;

@MicronautTest
public class HelloControllerSpec {
  @Inject
  EmbeddedServer sercer;

  @Inject
  @Client("/")
  HttpClient client;

  @Test
  void testHelloWorldResponse() {
    String response = client.toBlocking().retrieve(HttpRequest.GET("/hello"));
    assertEquals("Hello World!", response);
  }
}
