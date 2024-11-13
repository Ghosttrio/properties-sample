package org.ghosttrio.properties;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class PropertiesApplicationTests {

    @Autowired
    private Environment environment;

    @Value("${test.id}")
    private String id;
    @Value("${test.password}")
    private String password;

    @Autowired
    private TestProperties testProperties;

    @Test
    void envTest() {
        String id = environment.getProperty("test.id");
        String password = environment.getProperty("test.password");

        assertEquals(id, "testId");
        assertEquals(password, "testPassword");
    }

    @Test
    void valueTest() {
        assertEquals(this.id, "testId");
        assertEquals(this.password, "testPassword");
    }

    @Test
    void configTest() {
        assertEquals(testProperties.getId(), "testId");
        assertEquals(testProperties.getPassword(), "testPassword");
    }

}
