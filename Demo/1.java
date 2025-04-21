public class SamplePMDIssues {

    public int counter = 0; // public field (Rule: `VariableNamingConventions`, `AvoidUsingPublicFields`)

    public static void main(String[] args) {
        SamplePMDIssues obj = new SamplePMDIssues();
        obj.doSomething();
    }

    public void doSomething() {
        int i = 0;
        if (i == 0) { // Rule: `UnnecessaryIf`, `SimplifyBooleanReturns`
            System.out.println("i is zero");
        }

        // Empty try/catch block (Rule: `EmptyCatchBlock`)
        try {
            int x = 1 / 0;
        } catch (Exception e) {
        }

        // Unused variable (Rule: `UnusedLocalVariable`)
        String unused = "This will never be used";

        // System.out.println in production code (Rule: `SystemPrintln`)
        System.out.println("Debugging info");

        // Empty method (Rule: `EmptyMethodInAbstractClass` or `EmptyMethod`)
        helperMethod();
    }

    public void helperMethod() {
    }

    // Rule: `LongVariable` and `MethodArgumentCouldBeFinal`
    public int calculateSum(int veryLongVariableNameThatIsHardToRead, int anotherOne) {
        return veryLongVariableNameThatIsHardToRead + anotherOne;
    }
}
