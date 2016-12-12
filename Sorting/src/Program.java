class Program {

    public static void main(String[] args) {
        Student students[] = new Student[5];
        initStudents(students);
        displayStudents(students);
        System.out.println("-------------------------");
        sortStudents(students);
        displayStudents(students);
    }

    private static void initStudents(Student students[]){
        int[] marksOleg = {9,8,7,3,9};
        int[] marksIvan = {2,3,8,3,2};
        int[] marksMisha = {4,2,5,6,3};
        int[] marksMasha = {5,5,5,5,5};
        int[] marksRoma = {4,7,9,8,3};

        students[0] = new Student("Oleg", 20, marksOleg);
        students[1] = new Student("Ivan", 21, marksIvan);
        students[2] = new Student("Misha", 22, marksMisha);
        students[3] = new Student("Masha", 23, marksMasha);
        students[4] = new Student("Roman", 24, marksRoma);
    }

    private static void sortStudents(Student students[]){
        boolean flag = true;
        Student swap;
        while (flag) {
            flag = false;
            for (int i = 0; i <= 3; i++) {
                if (students[i].raiting() < students[i + 1].raiting()) {
                    swap = students[i];
                    students[i] = students[i + 1];
                    students[i + 1] = swap;
                    flag = true;
                }
            }
        }
    }

    private static void displayStudents(Student students[]){
        for (int i=0; i<=4; i++ ){
            System.out.println( students[i].getName() + " " +
                                students[i].getAge() + " " +
                                students[i].raiting());
        }
    }
}

