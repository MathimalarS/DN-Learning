public class MVCPatternDemo {
    public static void main(String[] args) {
        Student student = new Student("John Doe", 101, "A");
        StudentView view = new StudentView();
        StudentController controller = new StudentController(student, view);
        controller.updateView();
        controller.setStudentName("Jane Smith");
        controller.setStudentGrade("A+");
        controller.setStudentId(102);
        controller.updateView();
    }
}
