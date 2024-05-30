//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package cm.domeni.demo.e2e.steps;

import java.net.URI;
import java.util.Map;
import java.util.function.Function;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.client.MockMvcWebTestClient;
import org.springframework.web.util.UriBuilder;

public abstract class BaseHttpClient {
    public static final String TOKEN = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwiaXNzIjoiaHR0cHM6Ly9hdXRoLmxhby1zYXJsLmNtL3JlYWxtcy9kZW1vIiwibmFtZSI6IlRhbW8iLCJzY29wZSI6InByb2ZpbGUgZW1haWwiLCJpYXQiOjE1MTYyMzkwMjJ9.uL2HuLqmRHIMwuTtpPM6eNwJw8grJPI05MVeyomsJ_xi2lgxER3BnZ8OqxQBC9o4eWc8okYVjcJ6sFWgU99XzwYoY0Jk_Lz8NVvgExh-B1IINCt6KtdXPQTtj0p5S-mmUpIyZG6aqZ7bX1qZQpn7RBrb2wD3iLyfQI0he6xc-AD7e1welfb5ywvHUAJ0zZQp-Wn4XcZ2mwj4isTiXKOaqTa7W54LU_wuruNlaPhGXf6QiqB7W0QayUf_aMsFI5IgkvHgNoQRNor15daLmf8422tE-pL18ZTKUjApl1ja-dSfX3a5TpL-dyhKT4IMt7b1-e6DOAQGRrYErrWAd6sdmA";
    protected final WebTestClient webTestClient;
    private LastRequestResponse lastResponse;
    private String currentTenantId = "1";
    private String currentLocale = "en";
    public boolean shouldBeConnected = true;

    public BaseHttpClient(MockMvc mockMvc) {
        this.webTestClient = MockMvcWebTestClient.bindTo(mockMvc).build();
    }

    public void shouldBeDisconnected() {
        this.shouldBeConnected = false;
    }

    public WebTestClient.RequestHeadersSpec get(String uri, Object... uriVariables) {
        return this.defaultHeaders(this.webTestClient.get().uri(uri, uriVariables));
    }

    public WebTestClient.RequestHeadersSpec get(String uri, Map<String, ?> uriVariables) {
        return this.defaultHeaders(this.webTestClient.get().uri(uri, uriVariables));
    }

    public WebTestClient.RequestHeadersSpec get(Function<UriBuilder, URI> uriFunction) {
        return this.defaultHeaders(this.webTestClient.get().uri(uriFunction));
    }

    private WebTestClient.RequestHeadersSpec<?> defaultHeaders(WebTestClient.RequestHeadersSpec<?> requestHeadersSpec) {
        WebTestClient.RequestHeadersSpec<?> headers = requestHeadersSpec.headers((httpHeaders) -> {
            httpHeaders.set("tenant-id", this.currentTenantId);
        }).headers((httpHeaders) -> {
            httpHeaders.set("Accept-Language", this.currentLocale);
        });
        return this.shouldBeConnected ? headers.headers((httpHeaders) -> {
            httpHeaders.setBearerAuth("eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwiaXNzIjoiaHR0cHM6Ly9hdXRoLmxhby1zYXJsLmNtL3JlYWxtcy9kZW1vIiwibmFtZSI6IlRhbW8iLCJzY29wZSI6InByb2ZpbGUgZW1haWwiLCJpYXQiOjE1MTYyMzkwMjJ9.uL2HuLqmRHIMwuTtpPM6eNwJw8grJPI05MVeyomsJ_xi2lgxER3BnZ8OqxQBC9o4eWc8okYVjcJ6sFWgU99XzwYoY0Jk_Lz8NVvgExh-B1IINCt6KtdXPQTtj0p5S-mmUpIyZG6aqZ7bX1qZQpn7RBrb2wD3iLyfQI0he6xc-AD7e1welfb5ywvHUAJ0zZQp-Wn4XcZ2mwj4isTiXKOaqTa7W54LU_wuruNlaPhGXf6QiqB7W0QayUf_aMsFI5IgkvHgNoQRNor15daLmf8422tE-pL18ZTKUjApl1ja-dSfX3a5TpL-dyhKT4IMt7b1-e6DOAQGRrYErrWAd6sdmA");
        }) : headers;
    }

    public WebTestClient.RequestHeadersSpec delete(String uri, Object... uriVariables) {
        return this.defaultHeaders(this.webTestClient.delete().uri(uri, uriVariables));
    }

    public WebTestClient.RequestHeadersSpec delete(String uri, Map<String, ?> uriVariables) {
        return this.defaultHeaders(this.webTestClient.delete().uri(uri, uriVariables));
    }

    public WebTestClient.RequestHeadersSpec delete(Function<UriBuilder, URI> uriFunction) {
        return this.defaultHeaders(this.webTestClient.delete().uri(uriFunction));
    }

    public WebTestClient.RequestBodySpec post(Function<UriBuilder, URI> uriFunction) {
        return (WebTestClient.RequestBodySpec)this.defaultHeaders(this.webTestClient.post().uri(uriFunction));
    }

    public WebTestClient.RequestBodySpec post(String uri, Object... uriVariables) {
        return (WebTestClient.RequestBodySpec)this.defaultHeaders(this.webTestClient.post().uri(uri, uriVariables));
    }

    public WebTestClient.RequestBodySpec post(String uri, Map<String, ?> uriVariables) {
        return (WebTestClient.RequestBodySpec)this.defaultHeaders(this.webTestClient.post().uri(uri, uriVariables));
    }

    public WebTestClient.RequestBodySpec put(Function<UriBuilder, URI> uriFunction) {
        return (WebTestClient.RequestBodySpec)this.defaultHeaders(this.webTestClient.put().uri(uriFunction));
    }

    public WebTestClient.RequestBodySpec put(String uri, Object... uriVariables) {
        return (WebTestClient.RequestBodySpec)this.defaultHeaders(this.webTestClient.put().uri(uri, uriVariables));
    }

    public WebTestClient.RequestBodySpec put(String uri, Map<String, ?> uriVariables) {
        return (WebTestClient.RequestBodySpec)this.defaultHeaders(this.webTestClient.put().uri(uri, uriVariables));
    }

    public WebTestClient getWebTestClient() {
        return this.webTestClient;
    }

    public LastRequestResponse getLastResponse() {
        return this.lastResponse;
    }

    public String getCurrentTenantId() {
        return this.currentTenantId;
    }

    public String getCurrentLocale() {
        return this.currentLocale;
    }

    public boolean isShouldBeConnected() {
        return this.shouldBeConnected;
    }

    public void setLastResponse(final LastRequestResponse lastResponse) {
        this.lastResponse = lastResponse;
    }

    public void setCurrentTenantId(final String currentTenantId) {
        this.currentTenantId = currentTenantId;
    }

    public void setCurrentLocale(final String currentLocale) {
        this.currentLocale = currentLocale;
    }
}
