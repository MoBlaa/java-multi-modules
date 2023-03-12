package org.myshelf.java19modules;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.time.*;
import java.time.format.DateTimeFormatter;


public class UserRegisterTest extends TestBase {
    @Autowired
    private WebTestClient webTestClient;

    @Autowired
    private Clock clock;

    @Test
    void happyCase() {
        var userRequestJson = """
                {
                    "name": "TestUser",
                    "password": "12345"
                }""";

        this.webTestClient.post()
                .uri("/user")
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .bodyValue(userRequestJson)
                .exchange()
                .expectStatus()
                .is2xxSuccessful()
                .expectBody()
                .json("{\"id\":1,\"name\":\"TestUser\",\"createdAt\":\"%s\"}"
                        .formatted(LocalDateTime.now(clock).format(DateTimeFormatter.ofPattern("hh:mm:ss"))));
    }
}
