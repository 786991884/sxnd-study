package ch02;

public class TestStudentArray {

    public static void main(String[] args) {
        StudentArray sArr = new StudentArray();
        Student stu1 = new Student(509302, "d张三", "男", 20);
        Student stu2 = new Student(509301, "c李四", "男", 21);
        Student stu3 = new Student(609302, "a王五", "女", 22);
        Student stu4 = new Student(509402, "b赵六", "男", 23);

        sArr.insert(stu1);
        sArr.insert(stu2);
        sArr.insert(stu3);
        sArr.insert(stu4);

        sArr.display();
        System.out.println("-------------------------");
        sArr.sortByName();
        sArr.display();
    }

}
