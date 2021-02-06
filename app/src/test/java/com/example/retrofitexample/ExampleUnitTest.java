package com.example.retrofitexample;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void password_iscorrect() {
        assertEquals(true, LoginActivity.verifyPassword("baby_yoda_ftw"));
    }

    @Test
    public void username_iscorrect() {
        assertNotEquals(true, LoginActivity.verifyPassword("aaa"));
    }
}