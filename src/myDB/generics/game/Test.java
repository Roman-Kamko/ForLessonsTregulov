package myDB.generics.game;

import myDB.generics.game.doesntmatter.Employee;
import myDB.generics.game.doesntmatter.Schoolar;
import myDB.generics.game.doesntmatter.Student;

public class Test {
    public static void main(String[] args) {
        Schoolar ivan = new Schoolar("ivan", 11);
        Schoolar maria = new Schoolar("Marya", 12);

        Student nikolay = new Student("Nikolay", 20);
        Student kseniya = new Student("Kseniya", 18);

        Employee roman = new Employee("Roman", 32);
        Employee mikhail = new Employee("Mikhail", 40);

        Team<Schoolar> schollarTeam = new Team<>("drakoni");
        schollarTeam.addNewParticipant(ivan);
        schollarTeam.addNewParticipant(maria);
//        schollarTeam.addNewParticipant(roman);  ->  теперь компилятор не разрешает добавить работника, благодаря дженерику

        Team<Student> studentTeam = new Team<>("vpered");
        studentTeam.addNewParticipant(nikolay);
        studentTeam.addNewParticipant(kseniya);

        Team<Employee> employeeTeam = new Team<>("rabotyagi");
        employeeTeam.addNewParticipant(roman);
        employeeTeam.addNewParticipant(mikhail);

//        Team<String> stringTeam = new Team<>("fantazia");
//        stringTeam.addNewParticipant("hello");
//        Но из-за параметризации теперь мы можем создать команду чего угодно строк,
//        машин и т.д., так нашей программе нельзя позволять работать.
//        Для этого изменим класс с Team<T> на Team<T extends Participant>,
//        (для имплементации интерфейса так же используется ключевое слово extends)

        Team<Schoolar> schollarTeam2 = new Team<>("mudreci");
        Schoolar sergei = new Schoolar("sergei", 14);
        Schoolar olga = new Schoolar("olga", 12);
        schollarTeam2.addNewParticipant(sergei);
        schollarTeam2.addNewParticipant(olga);

        schollarTeam.playWith(schollarTeam2);

//        schollarTeam.playWith(studentTeam); школьники должны играть только со школьниками,
//        для этого нам просто нужно немного изменить метод playWith, добавить дженерик к принимаемому методом параметру
//        С public void playWith(Team team) на public void playWith(Team<T> team)
    }
}
