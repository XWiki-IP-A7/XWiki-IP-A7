package org.xwiki.commons.internal;

import org.xwiki.commons.Distribution.Main;
import org.xwiki.commons.HelloWorld;
import org.xwiki.component.annotation.Component;

import javax.inject.Named;

@Component
@Named("database")
public class DatabaseHelloWorld implements HelloWorld
{

    @Override
    public String sayHello() {
        return Main.algoritmCall();
    }
}