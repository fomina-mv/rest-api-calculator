package com.fomina;

import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) // for restTemplate
@ActiveProfiles("test")
public class CalculatorControllerRestTemplateTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void calculate_division_OK() throws JSONException {

        String expected = "{result:8}";

        ResponseEntity<String> response = restTemplate.getForEntity("/calculate?firstParam=8&sign=/&secondParam=1", String.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(MediaType.APPLICATION_JSON_UTF8, response.getHeaders().getContentType());

        JSONAssert.assertEquals(expected, response.getBody(), false);

    }

    @Test
    public void calculate_subtraction_OK() throws JSONException {

        String expected = "{result:7}";

        ResponseEntity<String> response = restTemplate.getForEntity("/calculate?firstParam=8&sign=-&secondParam=1", String.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(MediaType.APPLICATION_JSON_UTF8, response.getHeaders().getContentType());

        JSONAssert.assertEquals(expected, response.getBody(), false);

    }

    @Test
    public void calculate_multiplication_OK() throws JSONException {

        String expected = "{result:8}";

        ResponseEntity<String> response = restTemplate.getForEntity("/calculate?firstParam=8&sign=*&secondParam=1", String.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(MediaType.APPLICATION_JSON_UTF8, response.getHeaders().getContentType());

        JSONAssert.assertEquals(expected, response.getBody(), false);

    }

    @Test
    public void calculate_addition_OK() throws JSONException {

        String expected = "{result:9}";

        ResponseEntity<String> response = restTemplate.getForEntity("/calculate?firstParam=8&sign=%2b&secondParam=1", String.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(MediaType.APPLICATION_JSON_UTF8, response.getHeaders().getContentType());

        JSONAssert.assertEquals(expected, response.getBody(), false);

    }

    @Test
    public void calculate_400_BAD_REQUEST() {

        ResponseEntity<String> response = restTemplate.getForEntity("/calculate?firstParam=8&sign=/&secondParam=0", String.class);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());

    }




}
