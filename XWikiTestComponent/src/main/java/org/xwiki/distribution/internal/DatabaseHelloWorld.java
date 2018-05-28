package org.xwiki.distribution.internal;

import org.xwiki.distribution.HelloWorld;
import org.xwiki.distribution.Distribution.Algorithm.AlgorithmCall;
import org.xwiki.component.annotation.Component;

import javax.inject.Named;

@Component
@Named("database")
public class DatabaseHelloWorld implements HelloWorld
{

    @Override
    public AlgorithmCall sayHello() {
        return new AlgorithmCall();
    }
}