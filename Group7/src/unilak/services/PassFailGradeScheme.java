package unilak.services;

public class PassFailGradeScheme implements GradeScheme {

    @Override
    public String getType() {
        return "PASS_FAIL";
    }

    @Override
    public boolean isValid(String raw) {
        if (raw == null) return false;
        String v = raw.trim().toUpperCase();
        return v.equals("P") || v.equals("PASS")
            || v.equals("F") || v.equals("FAIL");
    }

    @Override
    public String normalize(String raw) {
        String v = raw.trim().toUpperCase();
        if (v.equals("PASS")) return "P";
        if (v.equals("FAIL")) return "F";
        return v;
    }

    @Override
    public double gradePoints(String normalized) {
        return 0.0;
    }

    @Override
    public boolean countsInGpa() {
        return false;
    }
}