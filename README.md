## Team Information
**Group Members:**
1. Kwizera Dieume: 30654/2025  - User Management (Component 1)
2. Isaac Smith: 20434/2022 - User Management (Component 1)
3. Muzerwa 30265/2025 - Course Management (Component 2)
4. ⁠Mohanad Hamad: 29570/2025 - Enrollment System (Component 3)
5. Ayham mamdouh 29484/2025 - Grade Management (Component 4)
6. Ahmed HASHIM 26622/2024 - Notification System (Component 5)
7. ELMOIZ ABDAllA 27449/2024 - Reporting System (Component 6)
8. FATHELRahman Hussein 25464/2024 - Authentication & Data Persistence (Components 7 & 8)


Question 4:-
Reg Number: 30265/2025

This project implements grading schemes and GPA calculation for a simple course enrollment system.

## Implemented Features
 Multiple grading schemes using `GradeScheme`:
  - Letter grading (A, B, C, D, F)
  - Pass/Fail grading (PASS/FAIL or P/F)
  - Numerical grading (0–100)
 `GradeSchemeFactory` to select the correct scheme based on the course grading scheme type.
 Instructor can assign grades to enrolled students.
 Student GPA calculation based on completed courses (schemes that count in GPA).

## Project Structure
 `src/unilak/services/`
  - `GradeScheme.java`
  - `GradeSchemeFactory.java`
  - `LetterGradeScheme.java`
  - `PassFailGradeScheme.java`
  - `NumericalGradeScheme.java`
  - `enrollmentmanager.java`
- `src/unilak/Main.java` (entry point)

## How to Run
1. Open the project in Eclipse (or any Java IDE).
2. Run `src/unilak/Main.java`.

## How to Test (Example)
### Instructor
 Login:
  - Username: `prof1`
  - Password: `prof123`
 Choose: `2` (Assign Grade)
 Enter:
  - Course Code: `BIT211`
  - Student Username: `student1`
  - Grade: `A` (for Letter scheme)

### Student
 Login:
  - Username: `student1`
  - Password: `student123`
 Choose: `4` (GPA)
 GPA will be printed based on completed courses that count in GPA.

## Notes
 A grade can only be assigned if the student is enrolled in the course and the enrollment status is `ACTIVE`.
 GPA is computed only for completed enrollments and only for schemes that count in GPA.
