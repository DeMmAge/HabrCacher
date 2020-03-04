package com.demmage.habr;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HabrCacherTest {

    @Test
    void checkPostExists() {
        HabrCacher cacher = new HabrCacher();
        assertTrue(cacher.checkPost(1)); // Exists
        assertFalse(cacher.checkPost(5)); // Forbidden
    }

    @Test
    void cache() {
        HabrCacher cacher = new HabrCacher();
        assertNotNull(cacher);
    }
}