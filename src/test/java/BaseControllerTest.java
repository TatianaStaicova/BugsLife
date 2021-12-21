package com.tatiana.staicova.BugTrackerSystem;

import com.fasterxml.jackson.databind.ObjectMapper;

public class BaseControllerTest {
    protected static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
