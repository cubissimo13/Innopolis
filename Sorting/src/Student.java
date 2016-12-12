class Student {
    private String name;
    private int age;
    private int [] marks;

    public Student(String name, int age, int[] marks) {
        this.name = name;
        this.age = age;
        this.marks = marks;
    }

    public String getName() {

        return this.name;
    }

    public int getAge(){

        return this.age;
    }

    public int [] getMarks(){

        return this.marks;
    }

    public double raiting(){

        double sum = 0;

        for (int i=0; i<=4; i++){

            sum=sum+this.marks[i];
        }

        return sum/5;

    }

}
