package unilak.services;

public class LetterGradeScheme implements GradeScheme {

    @Override
    public String getType() {
        return "LETTER";
    }

    @Override
    public boolean isValid(String raw) {
        if (raw == null) return false;
        String g = raw.trim().toUpperCase();
        return g.equals("A") || g.equals("B") || g.equals("C")
            || g.equals("D") || g.equals("F");
    }

    @Override
    public String normalize(String raw) {
        return raw.trim().toUpperCase();
    }

    @Override
    public double gradePoints(String normalized) {
        String g = normalize(normalized);
        if (g.equals("A")) return 4.0;
        if (g.equals("B")) return 3.0;
        if (g.equals("C")) return 2.0;
        if (g.equals("D")) return 1.0;
        return 0.0;
    }

    @Override
    public boolean countsInGpa() {
        return true;
    }
}