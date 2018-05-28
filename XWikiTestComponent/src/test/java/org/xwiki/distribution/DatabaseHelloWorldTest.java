package org.xwiki.distribution;

import org.xwiki.distribution.internal.DatabaseHelloWorld;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseHelloWorldTest
{

    @org.junit.jupiter.api.Test
    void sayHello()
    {
        assertNotNull(new DatabaseHelloWorld().sayHello());
    }
}