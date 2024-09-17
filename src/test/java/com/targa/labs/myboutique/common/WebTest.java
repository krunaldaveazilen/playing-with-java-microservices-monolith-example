package com.targa.labs.myboutique.common;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WebTest {

    @Test
    public void testApiConstant() {
        assertEquals("/api", Web.API);
    }
}
