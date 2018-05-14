package registration;

import org.xwiki.component.annotation.Role;
import registration.model.Candidate;

@Role
public interface InputHandler {
    Candidate execute();
}
