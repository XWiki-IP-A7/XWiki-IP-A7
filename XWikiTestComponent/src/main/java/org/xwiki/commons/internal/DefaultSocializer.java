package org.xwiki.commons.internal;

import org.xwiki.commons.HelloWorld;
import org.xwiki.commons.Socializer;
import org.xwiki.component.annotation.Component;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

@Component
@Singleton
public class DefaultSocializer implements Socializer
{

    /** Will be injected by the component manager */
    @Inject
    private HelloWorld helloWorld;

    /** Will be injected by the component manager */
    @Inject
    @Named("database")
    private HelloWorld databaseWorld;

    public void startConversation()
    {
        this.helloWorld.sayHello();
    }
}