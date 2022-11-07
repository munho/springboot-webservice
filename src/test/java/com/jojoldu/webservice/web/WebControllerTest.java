package com.jojoldu.webservice.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class WebControllerTest  {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void 페이지_로딩() {
        // when
        String body = testRestTemplate.getForObject("/", String.class);

        // then
        assertThat(body).contains("테스트");
    }
}