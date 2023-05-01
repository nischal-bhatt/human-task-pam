package com.example.demo.controller;

import com.example.demo.model.PlaceHolder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.util.HashMap;

@RestController
@RequestMapping("/api/v1/userTask")
public class UserTaskController {

    @GetMapping
    public String userTask()
    {

        RestTemplate restTemplate = new RestTemplate();

        String url = "http://localhost:8080/kie-server/services/rest/server/containers/userTaskLatestThis_1.0.0-SNAPSHOT/processes/userTaskLatestThis.usertasklatest/instances";

        HttpHeaders headers = new HttpHeaders();

        String x  = HttpHeaders.encodeBasicAuth("rhpamAdmin","Codezero88*", Charset.defaultCharset());

        System.out.println(x);

        headers.set("Authorization","Basic " + x);

        PlaceHolder placeHolder  = new PlaceHolder();
        placeHolder.setPlaceholder("going to watch netflix now is here");

        HttpEntity<PlaceHolder> httpEntity = new HttpEntity<>(placeHolder,headers);
        String instanceId = restTemplate.postForObject(url,httpEntity,String.class);

        System.out.println(instanceId);
        String url2 = "http://localhost:8080/kie-server/services/rest/server/containers/userTaskLatestThis_1.0.0-SNAPSHOT/processes/instances/240/variables/instances/message";

        HttpEntity<Void> requestEntity = new HttpEntity<>(headers);

        ResponseEntity<HashMap<Object,Object>> response;
        response = restTemplate.exchange(url2, HttpMethod.GET,requestEntity,new ParameterizedTypeReference<HashMap<Object,Object>>() {});

        System.out.println(response);
        ///////////////////////////////////////

        String url3 = "http://localhost:8080/kie-server/services/rest/server/containers/userTaskLatestThis_1.0.0-SNAPSHOT/processes/instances/259/variables/instances/message";

        HttpEntity<Void> requestEntity2 = new HttpEntity<>(headers);

        ResponseEntity<HashMap<Object,Object>> response2;
        response2 = restTemplate.exchange(url3, HttpMethod.GET,requestEntity2,new ParameterizedTypeReference<HashMap<Object,Object>>() {});

        System.out.println(response2);

        //////

        String url8 = "http://localhost:8080/kie-server/services/rest/server/containers/userTaskLatestThis_1.0.0-SNAPSHOT/processes/instances/261/variables/instances/message";

        HttpEntity<Void> requestEntity8 = new HttpEntity<>(headers);

        ResponseEntity<HashMap<Object,Object>> response8;
        response8 = restTemplate.exchange(url8, HttpMethod.GET,requestEntity8,new ParameterizedTypeReference<HashMap<Object,Object>>() {});

        System.out.println(response8);


        /////

        String url4 = "http://localhost:8080/kie-server/services/rest/server/containers/userTaskLatestThis_1.0.0-SNAPSHOT/processes/instances/259";

        HttpEntity<Void> requestEntity3 = new HttpEntity<>(headers);

        ResponseEntity<HashMap<Object,Object>> response3;
        response3 = restTemplate.exchange(url4, HttpMethod.GET,requestEntity3,new ParameterizedTypeReference<HashMap<Object,Object>>() {});

        System.out.println(response3);


        //////


        String url5 = "http://localhost:8080/kie-server/services/rest/server/containers/userTaskLatestThis_1.0.0-SNAPSHOT/processes/instances/259/variables/instances/placeholder";

        HttpEntity<Void> requestEntity4 = new HttpEntity<>(headers);

        ResponseEntity<HashMap<Object,Object>> response6;
        response6 = restTemplate.exchange(url5, HttpMethod.GET,requestEntity4,new ParameterizedTypeReference<HashMap<Object,Object>>() {});

        System.out.println(response6);

        return instanceId;

    }


}
