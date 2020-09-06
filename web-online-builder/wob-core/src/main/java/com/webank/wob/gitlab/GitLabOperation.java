package com.webank.wob.gitlab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Component
public class GitLabOperation {

    @Autowired
    RestTemplate restTemplate;

    private String generateRequestParameters(String protocol, String uri, Map<String, String> params) {
        StringBuilder sb = new StringBuilder(protocol).append("://").append(uri);
        if (params != null) {
            sb.append("?");
            for (Map.Entry map : params.entrySet()) {
                sb.append(map.getKey())
                        .append("=")
                        .append(map.getValue())
                        .append("&");
            }
            uri = sb.substring(0, sb.length() - 1);
            return uri;
        }
        return sb.toString();
    }

    private HttpEntity<Map<String, String>> generatePostJson(Map<String, String> jsonMap) {

        //如果需要其它的请求头信息、都可以在这里追加
        HttpHeaders httpHeaders = new HttpHeaders();

        MediaType type = MediaType.parseMediaType("application/json;charset=UTF-8");

        httpHeaders.setContentType(type);

        HttpEntity<Map<String, String>> httpEntity = new HttpEntity<>(jsonMap, httpHeaders);

        return httpEntity;
    }

    public String getPrivateToken() {
        String uri = "http://gitlab.com/MyNameIsJBL/api/v3/session";
        Map<String, String> jsonMap = new HashMap<>(6);
        jsonMap.put("login", "MyNameIsJBL");
        jsonMap.put("password", "xxx");

        ResponseEntity<String> apiResponse = restTemplate.postForEntity
                (
                        uri,
                        generatePostJson(jsonMap),
                        String.class
                );
        return apiResponse.getBody();

    }
}
