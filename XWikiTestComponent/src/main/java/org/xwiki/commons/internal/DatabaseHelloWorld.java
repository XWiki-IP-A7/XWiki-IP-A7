package org.xwiki.commons.internal;

import org.xwiki.commons.Distribution.Main;
import org.xwiki.commons.Distribution.Models.Committee;
import org.xwiki.commons.HelloWorld;
import org.xwiki.component.annotation.Component;

import javax.inject.Named;
import java.util.List;

@Component
@Named("database")
public class DatabaseHelloWorld implements HelloWorld
{

    @Override
    public List<Committee> sayHello() {
        return Main.algoritmCall();
    }
}