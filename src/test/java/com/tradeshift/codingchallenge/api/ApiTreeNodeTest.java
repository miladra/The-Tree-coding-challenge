package com.tradeshift.codingchallenge.api;

import com.tradeshift.codingchallenge.entity.TreeNode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.AutoConfigureWebClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, properties = "spring.h2.console.enabled=true")
@AutoConfigureWebClient(registerRestTemplate = true)
public class ApiTreeNodeTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int serverPort;

    @Test
    public void AddRootNode() {

        //Create
        //   A
        String saveUrl = "http://localhost:" + serverPort + "/rest/v1/nodes/{newPosition}/{addAsChild}";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

        Map<String, String > params = new HashMap <> ();
        params.put("newPosition", "0");
        params.put("addAsChild", "false");

        TreeNode node = new TreeNode();
        node.setName("A");
        node.setHeight(Long.valueOf(0));
        node.setRightNodeId(Long.valueOf(0));
        node.setLeftNodeId(Long.valueOf(0));
        node.setRootNode(null);
        node.setSubNodes(null);
        node.setSubRootNodes(null);
        node.setParentNode(null);

        HttpEntity<TreeNode> request = new HttpEntity<TreeNode>(node, headers);

        ResponseEntity<TreeNode> result = restTemplate.exchange(saveUrl, HttpMethod.POST, request, TreeNode.class , params);

        assertThat(result.getStatusCode())
                .as("GET API Node")
                .isEqualTo(HttpStatus.OK);
    }

    @Test
    public void AddChildNode() {
        // Create
        //   A
        //   |
        //   B
        String saveUrl = "http://localhost:" + serverPort + "/rest/v1/nodes/{newPosition}/{addAsChild}";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

        Map<String, String > params = new HashMap <> ();
        params.put("newPosition", "A");
        params.put("addAsChild", "true");

        TreeNode node = new TreeNode();
        node.setName("B");
        node.setHeight(Long.valueOf(0));
        node.setRightNodeId(Long.valueOf(0));
        node.setLeftNodeId(Long.valueOf(0));
        node.setRootNode(null);
        node.setSubNodes(null);
        node.setSubRootNodes(null);
        node.setParentNode(null);

        HttpEntity<TreeNode> request = new HttpEntity<TreeNode>(node, headers);

        ResponseEntity<TreeNode> result = restTemplate.exchange(saveUrl, HttpMethod.POST, request, TreeNode.class , params);



        assertThat(result.getStatusCode())
                .as("GET API Node")
                .isEqualTo(HttpStatus.OK);
    }

    @Test
    public void AddChildNode2() {
        // Create
        //   A
        //  / \
        //  B  C
        String saveUrl = "http://localhost:" + serverPort + "/rest/v1/nodes/{newPosition}/{addAsChild}";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

        Map<String, String > params = new HashMap <> ();
        params.put("newPosition", "B");
        params.put("addAsChild", "false");

        TreeNode node = new TreeNode();
        node.setName("C");
        node.setHeight(Long.valueOf(0));
        node.setRightNodeId(Long.valueOf(0));
        node.setLeftNodeId(Long.valueOf(0));
        node.setRootNode(null);
        node.setSubNodes(null);
        node.setSubRootNodes(null);
        node.setParentNode(null);

        HttpEntity<TreeNode> request = new HttpEntity<TreeNode>(node, headers);

        ResponseEntity<TreeNode> result = restTemplate.exchange(saveUrl, HttpMethod.POST, request, TreeNode.class , params);



        assertThat(result.getStatusCode())
                .as("GET API Node")
                .isEqualTo(HttpStatus.OK);
    }

    @Test
    public void AddChildNode3() {
        // Create
        //     B
        //  /  |  \
        //  B  C   D
        String saveUrl = "http://localhost:" + serverPort + "/rest/v1/nodes/{newPosition}/{addAsChild}";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

        Map<String, String > params = new HashMap <> ();
        params.put("newPosition", "C");
        params.put("addAsChild", "false");

        TreeNode node = new TreeNode();
        node.setName("D");
        node.setHeight(Long.valueOf(0));
        node.setRightNodeId(Long.valueOf(0));
        node.setLeftNodeId(Long.valueOf(0));
        node.setRootNode(null);
        node.setSubNodes(null);
        node.setSubRootNodes(null);
        node.setParentNode(null);

        HttpEntity<TreeNode> request = new HttpEntity<TreeNode>(node, headers);

        ResponseEntity<TreeNode> result = restTemplate.exchange(saveUrl, HttpMethod.POST, request, TreeNode.class , params);



        assertThat(result.getStatusCode())
                .as("GET API Node")
                .isEqualTo(HttpStatus.OK);
    }

    @Test
    public void AddChildNode4() {
        // Create
        //     B
        //  /  |  \
        //  B  C   D
        //     |
        //     E
        String saveUrl = "http://localhost:" + serverPort + "/rest/v1/nodes/{newPosition}/{addAsChild}";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

        Map<String, String > params = new HashMap <> ();
        params.put("newPosition", "C");
        params.put("addAsChild", "true");

        TreeNode node = new TreeNode();
        node.setName("E");
        node.setHeight(Long.valueOf(0));
        node.setRightNodeId(Long.valueOf(0));
        node.setLeftNodeId(Long.valueOf(0));
        node.setRootNode(null);
        node.setSubNodes(null);
        node.setSubRootNodes(null);
        node.setParentNode(null);

        HttpEntity<TreeNode> request = new HttpEntity<TreeNode>(node, headers);

        ResponseEntity<TreeNode> result = restTemplate.exchange(saveUrl, HttpMethod.POST, request, TreeNode.class , params);



        assertThat(result.getStatusCode())
                .as("GET API Node")
                .isEqualTo(HttpStatus.OK);
    }

    @Test
    public void AddChildNode5() {
        // Create
        //     B
        //  /  |  \
        //  B  C   D
        //     |   |
        //     E   F
        String saveUrl = "http://localhost:" + serverPort + "/rest/v1/nodes/{newPosition}/{addAsChild}";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

        Map<String, String > params = new HashMap <> ();
        params.put("newPosition", "D");
        params.put("addAsChild", "true");

        TreeNode node = new TreeNode();
        node.setName("F");
        node.setHeight(Long.valueOf(0));
        node.setRightNodeId(Long.valueOf(0));
        node.setLeftNodeId(Long.valueOf(0));
        node.setRootNode(null);
        node.setSubNodes(null);
        node.setSubRootNodes(null);
        node.setParentNode(null);

        HttpEntity<TreeNode> request = new HttpEntity<TreeNode>(node, headers);

        ResponseEntity<TreeNode> result = restTemplate.exchange(saveUrl, HttpMethod.POST, request, TreeNode.class , params);



        assertThat(result.getStatusCode())
                .as("GET API Node")
                .isEqualTo(HttpStatus.OK);
    }

    @Test
    public void AddChildNode6() {
        // Create
        //     B
        //  /  |  \
        //  B  C    D
        //     |   / \
        //     E   F  G
        String saveUrl = "http://localhost:" + serverPort + "/rest/v1/nodes/{newPosition}/{addAsChild}";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

        Map<String, String > params = new HashMap <> ();
        params.put("newPosition", "F");
        params.put("addAsChild", "false");

        TreeNode node = new TreeNode();
        node.setName("G");
        node.setHeight(Long.valueOf(0));
        node.setRightNodeId(Long.valueOf(0));
        node.setLeftNodeId(Long.valueOf(0));
        node.setRootNode(null);
        node.setSubNodes(null);
        node.setSubRootNodes(null);
        node.setParentNode(null);

        HttpEntity<TreeNode> request = new HttpEntity<TreeNode>(node, headers);

        ResponseEntity<TreeNode> result = restTemplate.exchange(saveUrl, HttpMethod.POST, request, TreeNode.class , params);



        assertThat(result.getStatusCode())
                .as("GET API Node")
                .isEqualTo(HttpStatus.OK);
    }

    @Test
    public void GetAllNode() {

        String saveUrl = "http://localhost:" + serverPort + "/rest/v1/nodes";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

        HttpEntity<?> request = new HttpEntity<>(headers);
        ResponseEntity<List<TreeNode>> result = restTemplate.exchange(saveUrl, HttpMethod.GET, request, new ParameterizedTypeReference<List<TreeNode>>(){});

        assertThat(result.getStatusCode())
                .as("GET API Node")
                .isEqualTo(HttpStatus.OK);

        List<TreeNode> resultBody = result.getBody();

        assertThat(resultBody.size())
                .as("Check size")
                .isEqualTo(7);
    }

    @Test
    public void GetSubTree() {

        String saveUrl = "http://localhost:" + serverPort + "/rest/v1/nodes/{name}";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

        Map<String, String > params = new HashMap <> ();
        params.put("name", "A");

        HttpEntity<?> request = new HttpEntity<>(headers);
        ResponseEntity<List<TreeNode>> result = restTemplate.exchange(saveUrl, HttpMethod.GET, request, new ParameterizedTypeReference<List<TreeNode>>(){} , params);

        assertThat(result.getStatusCode())
                .as("GET API Node")
                .isEqualTo(HttpStatus.OK);

        List<TreeNode> resultBody = result.getBody();

        assertThat(resultBody.size())
                .as("Check size")
                .isEqualTo(7);
    }

    @Test
    public void GetNotExistTreeNode() {

            String saveUrl = "http://localhost:" + serverPort + "/rest/v1/nodes/{name}";
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

            Map<String, String > params = new HashMap <> ();
            params.put("name", "F");

            HttpEntity<?> request = new HttpEntity<>(headers);
            ResponseEntity<Object> result = restTemplate.exchange(saveUrl, HttpMethod.GET, request, Object.class , params);

            assertThat(result.getStatusCode())
                    .as("GET API Node")
                    .isEqualTo(HttpStatus.NOT_FOUND);
    }

    @Test
    public void MoveToParentWithChildren() {

        //    move       to
        //     B                   B
        //  /  |  \             /     \
        //  B  C    D           B        D
        //     |   / \                 / / \
        //     E   F  G               C  F  G
        //                            |
        //                            E


        String saveUrl = "http://localhost:" + serverPort + "/rest/v1/nodes/{newPosition}/{currentNode}";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

        restTemplate.getRestTemplate().setRequestFactory(new HttpComponentsClientHttpRequestFactory());

        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("newPosition" , "F");
        parameters.put("currentNode" ,"E");

        HttpEntity<Map> request = new HttpEntity<Map>(headers);
        ResponseEntity<List<TreeNode>> result = restTemplate.exchange(saveUrl, HttpMethod.PATCH, null, new ParameterizedTypeReference<List<TreeNode>>(){} , parameters);

        assertThat(result.getStatusCode())
                .as("GET API Node")
                .isEqualTo(HttpStatus.OK);

    }

    @Test
    public void MoveToParentWithoutChildren() {

        String saveUrl = "http://localhost:" + serverPort + "/rest/v1/nodes/{newPosition}/{currentNode}";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        restTemplate.getRestTemplate().setRequestFactory(new HttpComponentsClientHttpRequestFactory());

        Map<String, String> parameters = new HashMap<>();
        parameters.put("newPosition" , "B");
        parameters.put("currentNode" ,"E");

        HttpEntity<Map> request = new HttpEntity<Map>( headers);
        ResponseEntity<List<TreeNode>> result = restTemplate.exchange(saveUrl, HttpMethod.PATCH, null,  new ParameterizedTypeReference<List<TreeNode>>(){},parameters);

        assertThat(result.getStatusCode())
                .as("GET API Node")
                .isEqualTo(HttpStatus.OK);
    }

    @Test
    public void DeleteRootTreeNode() {

        String saveUrl = "http://localhost:" + serverPort + "/rest/v1/nodes/{newPosition}/{currentNode}";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("newPosition" , 'A');
        parameters.put("currentNode" ,'E');

        HttpEntity<Map> request = new HttpEntity<Map>(parameters, headers);
        ResponseEntity<List<TreeNode>> result = restTemplate.exchange(saveUrl, HttpMethod.PATCH, request,  new ParameterizedTypeReference<List<TreeNode>>(){},parameters);

        assertThat(result.getStatusCode())
                .as("GET API Node")
                .isEqualTo(HttpStatus.OK);

    }

    @Test
    public void UpdateRootTreeNode() {

        String saveUrl = "http://localhost:" + serverPort + "/rest/v1/nodes/{newPosition}/{currentNode}";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("newPosition" , 'A');
        parameters.put("currentNode" ,'E');

        HttpEntity<Map> request = new HttpEntity<Map>(parameters, headers);
        ResponseEntity<List<TreeNode>> result = restTemplate.exchange(saveUrl, HttpMethod.PATCH, request,  new ParameterizedTypeReference<List<TreeNode>>(){},parameters);

        assertThat(result.getStatusCode())
                .as("GET API Node")
                .isEqualTo(HttpStatus.OK);

    }



}