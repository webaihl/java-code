package org.example.jdk.jdk11;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.WebSocket;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.TimeUnit;

/**
 * HttpClient
 *
 * @author zhaochun
 */
public class HttpClientDemo {
    public static void main(String[] args) throws Exception {
        HttpClientDemo me = new HttpClientDemo();
        me.testHttpClientGetSync();
        me.testHttpClientGetAsync();
        me.testHttpClientPost();

        // 同一个HttpClient先登录网站获取token，再请求受限制资源，从而爬取需要认证的资源
        me.testLogin();

        // HttpClient支持websocket
        me.testWebsocket();
    }

    private void testHttpClientGetSync() {
        var url = "https://openjdk.java.net/";
        var request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();
        var client = HttpClient.newHttpClient();
        try {
            System.out.printf("send begin at %s%n", LocalDateTime.now());
            // 同步请求
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.printf("send end at %s%n", LocalDateTime.now());
            System.out.printf("receive response : %s%n", response.body().substring(0, 10));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void testHttpClientGetAsync() {
        var url = "https://openjdk.java.net/";
        var request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();
        var client = HttpClient.newHttpClient();
        try {
            System.out.printf("sendAsync begin at %s%n", LocalDateTime.now());
            // 异步请求
            client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                    .thenApply(stringHttpResponse -> {
                        System.out.printf("receive response at %s%n", LocalDateTime.now());
                        return stringHttpResponse.body();
                    })
                    .thenAccept(s -> System.out.printf("receive response : %s at %s%n", s.substring(0, 10), LocalDateTime.now()));
            System.out.printf("sendAsync end at %s%n", LocalDateTime.now());

            // 为了防止异步请求尚未返回主线程就结束(jvm会退出)，这里让主线程sleep 10秒
            System.out.println("Main Thread sleep 10 seconds start...");
            Thread.sleep(10000);
            System.out.println("Main Thread sleep 10 seconds stop...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void testHttpClientPost() {
        var url = "http://localhost:30001/jdk11/test/helloByPost";
        var request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "text/plain")
                .POST(HttpRequest.BodyPublishers.ofString("zhangsan"))
                .build();
        var client = HttpClient.newHttpClient();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.statusCode());
            System.out.println(response.body());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void testLogin() throws Exception {
        var client = HttpClient.newHttpClient();
        // 某测试环境用户登录URL
        var urlLogin = "http://x.x.x.x:xxxx/xxx/login";
        var requestObj = new HashMap<String, Object>();
        requestObj.put("username", "xxxxxx");
        requestObj.put("password", "xxxxxxxxxxxxxxxx");
        var objectMapper = new ObjectMapper();
        var requestBodyJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(requestObj);
        var requestLogin = HttpRequest.newBuilder()
                .uri(URI.create(urlLogin))
                .header("Content-Type", "application/json;charset=UTF-8")
                .POST(HttpRequest.BodyPublishers.ofString(requestBodyJson))
                .build();
        HttpResponse<String> responseLogin = client.send(requestLogin, HttpResponse.BodyHandlers.ofString());
        // 这里的登录网站使用token，而没有使用session，因此我们需要从返回的报文主体中查找token信息；
        // 如果是使用session的网站，这里需要从响应的headers中查找"set-cookie"从而获取session id，并在后续请求中，将sid设置到header的Cookie中。
        // 如： responseLogin.headers().map().get("set-cookie")获取cookies，再从中查找sid。
        var loginResponse = responseLogin.body();
        var mpLoginResponse = objectMapper.readValue(loginResponse, Map.class);
        var dataLogin = (Map<String, Object>) mpLoginResponse.get("data");
        var token = dataLogin.get("token").toString();
        // 测试环境获取某资源的URL
        var urlGetResource = "http://xxxx:xxxx/xxx/resource";
        var requestRes = HttpRequest.newBuilder()
                .uri(URI.create(urlGetResource))
                .header("Content-Type", "application/json;charset=UTF-8")
                // 注意，token并非一定设置到header的Authorization中，这取决于网站验证的方式，也有可能token也放到cookie里。
                // 但对于使用session的网站，sid都是设置在cookie里的。如: .header("Cookie", "JSESSIONID=" + sid)
                .header("Authorization", token)
                .GET()
                .build();
        HttpResponse<String> responseResource = client.send(requestRes, HttpResponse.BodyHandlers.ofString());
        var response = responseResource.body();
        System.out.println(response);
    }

    private void testWebsocket() {
        var wsUrl = "ws://localhost:30001/ws/test";
        var httpClient = HttpClient.newHttpClient();
        WebSocket websocketClient = httpClient.newWebSocketBuilder()
                .buildAsync(URI.create(wsUrl), new WebSocket.Listener() {
                    @Override
                    public void onOpen(WebSocket webSocket) {
                        System.out.println("onOpen : webSocket opened.");
                        webSocket.request(1);
                    }

                    @Override
                    public CompletionStage<?> onText(WebSocket webSocket, CharSequence data, boolean last) {
                        System.out.println("onText");
                        webSocket.request(1);
                        return CompletableFuture.completedFuture(data)
                                .thenAccept(System.out::println);
                    }

                    @Override
                    public CompletionStage<?> onClose(WebSocket webSocket, int statusCode, String reason) {
                        System.out.println("ws closed with status(" + statusCode + "). cause:" + reason);
                        webSocket.sendClose(statusCode, reason);
                        return null;
                    }

                    @Override
                    public void onError(WebSocket webSocket, Throwable error) {
                        System.out.println("error: " + error.getLocalizedMessage());
                        webSocket.abort();
                    }
                }).join();

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // last参数用于指示websocketClient，本次发送的数据是否是完整消息的最后部分。
        // 如果是false，则websocketClient不会把消息发送给websocket后台的listener，只会把数据缓存起来；
        // 当传入true时，会将之前缓存的数据和这次的数据拼接起来一起发送给websocket后台的listener。
        websocketClient.sendText("test1", false);
        websocketClient.sendText("test2", true);

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        websocketClient.sendText("org_all_request", true);

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        websocketClient.sendText("employee_all_request", true);

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        websocketClient.sendClose(WebSocket.NORMAL_CLOSURE, "Happy ending.");
    }
}