package com.example.core.thread;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ThreadTest {

    @Test
    @DisplayName("Running Thread created by extending Thread class")
    void testCustomThreadCreatedByExtendingThreadClass(){
        Thread threadOne = new CustomThread();
        threadOne.run();
    }

}
