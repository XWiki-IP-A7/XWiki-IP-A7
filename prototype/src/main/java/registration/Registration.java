package registration;

import org.xwiki.component.annotation.Role;
import registration.model.Candidate;

import java.util.List;

@Role
public interface Registration {
    boolean addCandidate(Candidate candidate);
    List<Candidate> getCandidates();
}
