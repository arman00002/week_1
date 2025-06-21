package MVCPatternExample;

public class Test {
    public static void main(String[] args) {
        Student model = new Student("Arman Pattnaik", "CSE6346", "A");
        StudentView view = new StudentView();

        StudentController controller = new StudentController(model, view);

        controller.updateView();

        System.out.println("\nUpdating student grade...\n");

        controller.setStudentGrade("A+");

        controller.updateView();
    }
}
