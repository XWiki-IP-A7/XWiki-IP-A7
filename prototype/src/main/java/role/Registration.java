package role;

import model.Candidate;

import java.util.ArrayList;
import java.util.List;

public class Registration {
    private List<Candidate> candidates;
    private static Registration instance = null;

    private Registration() {
        this.candidates = new ArrayList<Candidate>();
    }

    public static Registration getInstance() {
        if (instance == null) {
            instance = new Registration();
        }
        return instance;
    }

    public boolean addCandidate(Candidate candidate) {
        this.candidates.add(candidate);
        return true;
    }

    public List<Candidate> getCandidates() {
        return candidates;
    }

}