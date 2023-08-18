package br.com.erudio.restwithspringboot.integrationtests.controller.withjson.PersonControllerTest;

import br.com.erudio.restwithspringboot.vo.v1.PersonVOV1;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PersonControllerCorsJsonTest {

    private static RequestSpecification specification;
    private static ObjectMapper objectMapper;

    private static PersonVOV1 person;
}
