package org.xwiki.distribution;

import org.xwiki.component.annotation.Role;

@Role
public interface Socializer
{
    /**
     * Says hello by returning a greeting to the caller.
     *
     * @return a greeting
     */
    void startConversation();
}
