package unilak.services;

public class NumericalGradeScheme implements GradeScheme {

    @Override
    public String getType() {
        return "NUMERICAL";
    }

    @Override
    public boolean isValid(String raw) {
        if (raw == null) return false;
        try {
            double x = Double.parseDouble(raw.trim());
            return x >= 0 && x <= 100;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public String normalize(String raw) {
        double x = Double.parseDouble(raw.trim());
        return String.format("%.1f", x);
    }

    @Override
    public double gradePoints(String normalized) {
        double x = Double.parseDouble(normalized);
        if (x >= 90) return 4.0;
        if (x >= 80) return 3.0;
        if (x >= 70) return 2.0;
        if (x >= 60) return 1.0;
        return 0.0;
    }

    @Override
    public boolean countsInGpa() {
        return true;
    }
}