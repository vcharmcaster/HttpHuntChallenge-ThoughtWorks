package com.thought;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;

import com.sun.jersey.client.urlconnection.HttpURLConnectionFactory;

public class ConnectionFactory implements HttpURLConnectionFactory {

    Proxy proxy;

    private void initializeProxy() {
        proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("gateway.zscaler.net", 9400));
    }

    public HttpURLConnection getHttpURLConnection(URL url) throws IOException {
        initializeProxy();
        return (HttpURLConnection) url.openConnection(proxy);
    }
}