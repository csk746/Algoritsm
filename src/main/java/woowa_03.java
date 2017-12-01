import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by csk746(csk746@naver.com) on 2017. 11. 4..
 */
public class woowa_03 {
    public static void main(String[] args) {
        int A[] = {40};
        int B[] = {1};
        int M = 1;
        int X = 5;
        int Y = 200;
        System.out.println(solution(A, B, M, X, Y));
    }

    public static int solution(int[] A, int[] B, int M, int X, int Y) {
        Queue<Person> line = new LinkedList<Person>();
        Elevator elevator = new Elevator();
        elevator.setCurrentFloor(1);
        int maxPeopleCount = X;
        int totalFloor = M;
        int limitWeight = Y;

        for (int i = 0; i < A.length; i++) {
            line.add(new Person(A[i], B[i]));
        }
        int count = 0;
        while (true) {
            while (true) {
                if (line.size() > 0 && elevator.getCurrentWeight() + line.peek().getWeight() <= limitWeight && elevator.getPersons().size() <= X) {
                    Person p = line.poll();
                    elevator.getPersons().add(p);
                    elevator.setCurrentWeight(elevator.getCurrentWeight() + p.getWeight());
                } else
                    break;
            }
            int currentFloor = 2;
            boolean upOrDown = true;
            int prevFloor = 1;
            while (true) {

                elevator.setCurrentFloor(currentFloor);
                if (currentFloor == 1) {
                    break;
                }
                if (elevator.getPersons().size() > 0 && elevator.getPersons().peek().getTargetFloor() == currentFloor) {
                    if (prevFloor != currentFloor){
                        count++;
                        prevFloor = currentFloor;
                    }

                    Person p = elevator.getPersons().poll();
                    elevator.setCurrentWeight(elevator.getCurrentWeight() - p.getWeight());
                } else {
                    if (upOrDown) {
                        if (currentFloor == totalFloor) {
                            upOrDown = false;
                        }
                    }

                    if (upOrDown)
                        currentFloor++;
                    else
                        currentFloor--;
                }
            }
            if (line.size() == 0 && elevator.getCurrentFloor() == 1)
                break;
        }

        return count+2;
    }

    private static class Elevator {

        int currentWeight;

        int currentFloor;

        Queue<Person> persons = new LinkedList<Person>();

        public int getCurrentWeight() {
            return currentWeight;
        }

        public void setCurrentWeight(int currentWeight) {
            this.currentWeight = currentWeight;
        }

        public Queue<Person> getPersons() {
            return persons;
        }

        public void setPersons(Queue persons) {
            this.persons = persons;
        }

        public int getCurrentFloor() {
            return currentFloor;
        }

        public void setCurrentFloor(int currentFloor) {
            this.currentFloor = currentFloor;
        }

    }

    private static class Person {
        int weight;
        int targetFloor;

        Person(int weight, int targetFloor) {
            this.weight = weight;
            this.targetFloor = targetFloor;
        }

        public int getWeight() {
            return weight;
        }

        public int getTargetFloor() {
            return targetFloor;
        }

    }
}
