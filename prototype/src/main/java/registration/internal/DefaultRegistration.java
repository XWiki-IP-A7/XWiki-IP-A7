package registration.internal;

import org.xwiki.component.annotation.Component;
import registration.Registration;
import registration.model.Candidate;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;

@Component
@Singleton
public class DefaultRegistration implements Registration {

    private List<Candidate> candidates;
    public DefaultRegistration(){
        this.candidates = new ArrayList<>();
    }

    @Override
    public boolean addCandidate(Candidate candidate) {
        this.candidates.add(candidate);
        return true;
    }

    @Override
    public List<Candidate> getCandidates() {
        return this.candidates;
    }
}
