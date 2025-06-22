
public class Main {
    public static void main(String[] args) {

        System.out.println();

        Student model = new Student("sakthi", 1, "A");
        
        StudentView view = new StudentView();
        
        StudentController controller = new StudentController(model, view);
        
        controller.updateView();
        
        controller.setStudentName("Jhon");
        controller.setStudentGrade("B");
        
        controller.updateView();
    }
}
