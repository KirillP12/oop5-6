import java.io.Serializable;

public class Student extends Human implements Comparable, Serializable {
    private Group group;
    private int course;
    private int studBook;
    private double averageRating;

    public Student() {
    }

    public Student(String surname, String name, boolean sex, int course, int studBook, double averageRating) {
        super(surname,name, sex);
        if(course > 0 && course <=6){
            this.course = course;
        }
        else{
            System.out.println("Неверная цифра курса" + getName() + " " + getSurname());
        }
        if(studBook > 0 && studBook <=10000){
            this.studBook = studBook;
        }
        else{
            System.out.println("Неверный номер студенческого билета" + getName() + " " + getSurname());
        }
        if(averageRating > 0 && averageRating <=5){
            this.averageRating = averageRating;
        }
        else{
            System.out.println("Неверный средний рейтинг студента" + getName() + " " + getSurname());
        }
        info();
    }

    public Student(String surname, String name, boolean sex, int course, int studBook, double averageRating,
                   int age, int height, int weight) {
        super(surname, name, sex, age, height, weight);
        if(course > 0 && course <=6){
            this.course = course;
        }
        else{
            System.out.println("Неверный номер курса студента" + getName() + " " + getSurname());
        }
        if(studBook > 0 && studBook <=10000){
            this.studBook = studBook;
        }
        else{
            System.out.println("Неверный номер студенческого билета" + getName() + " " + getSurname());
        }
        if(averageRating > 0 && averageRating <=5){
            this.averageRating = averageRating;
        }
        else{
            System.out.println("Неверный средний рейтинг студента" + getName() + " " + getSurname());
        }
        info();
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        if(course > 0 && course <=6) this.course = course;
        else System.out.println("Неправильный номер курса");
    }

    public int getStudBook() {
        return studBook;
    }

    public void setStudBook(int studBook) {
        if(studBook > 0 && studBook <=10000){
            this.studBook = studBook;
        }
        else{
            System.out.println("Неверный номер студенческого билета");
        }
    }

    public double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(double averageRating) {
        if(averageRating > 0 && averageRating <=5){
            this.averageRating = averageRating;
        }
        else{
            System.out.println("Неверный средний рейтинг студента");
        }
    }

    @Override
    public String toString() {
        return  "Student {" + "surname: " + getSurname()  +
                ", name: " + getName()+
                ", sex = " + (isSex()?"man":"woman") +
                (getAge() != 0 ? ", age = " + getAge() : "") +
                (getHeight() != 0 ?  ", height = " + getHeight()  : "") +
                (getWeight() != 0 ?  ", weight = " + getWeight() : "") +
                (group != null ? ", group = " + group.getGroupName() : "")  +
                (course != 0 ? ", course = " + course  : "") +
                (studBook != 0 ? ", studBook = " + studBook  : "") +
                (averageRating != 0 ? ", averageRating = " + averageRating  : "") +
                '}';
    }


    
    public int compareTo(Object o) {
        if (o == null) {
            return -1;
        }
        Human anotherHuman = (Human) o;
        return this.getSurname().compareToIgnoreCase(anotherHuman.getSurname());
    }

    public String printStudentToFile(){
        return getSurname()+";"+getName()+";"+isSex()+";"+getAge()+";"+getHeight()+";"+getWeight()+";"+course+";"+studBook+";"+averageRating;
    }
}