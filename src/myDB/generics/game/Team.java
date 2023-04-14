package myDB.generics.game;

import myDB.generics.game.doesntmatter.Participant;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/* public class Team {  -> в команду школьников мы можем добавить и студентов и работников,
                           из-за того что лист (в классе Team принимает любого participant),
                           такой вариант не подойдет, можно случайно занести в команду участника
                           которого там не должно быть */
public class Team <T extends Participant>{
    private String name;
    private List<T> participants = new ArrayList<>();

    public Team(String name) {
        this.name = name;
    }

    public void addNewParticipant(T participant) {
        participants.add(participant);
        System.out.printf(
                "В команду %s был добавлен новый участник %s\n",
                name, ((Participant)participant).getName());
        // у переменной типа T нет метода getName, поэтому нужно кастить,
        // но за счет того что мы переделали <T> в классе на <T extends Participant>
        // (для того чтобы невозможно было создать список строк, машин и т.д.), можно уже не кастить
    }

    public void playWith(Team<T> team) {
        String winnerName;
        Random random = new Random();
        int i = random.nextInt(2);
        if (i == 0) {
            winnerName = this.name;
        } else {
            winnerName = team.name;
        }
        System.out.printf("Выиграла команда %s\n", winnerName);
    }
}
