package unilak.services;

public class GradeSchemeFactory {

    public static GradeScheme get(String type) {
        if (type == null) {
            return new LetterGradeScheme();
        }

        String t = type.trim().toUpperCase();

        if (t.equals("PASS_FAIL")) {
            return new PassFailGradeScheme();
        }

        if (t.equals("NUMERICAL")) {
            return new NumericalGradeScheme();
        }

        return new LetterGradeScheme();
    }
}