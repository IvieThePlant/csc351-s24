import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Integer[] coins = { 0, 5, 2, 3, 1, 1, 7, 1, 2 };
        int change = 10;

        MakingChange changer = new MakingChange(coins, change);

        int countRecDP = changer.solveRecDP();
        ArrayList<Integer> solutionRecDP = changer.getChoices();
        System.out.println("solveRecDP  = " + countRecDP + "\n" + solutionRecDP);

        int countIterDP = changer.solveIterDP();
        ArrayList<Integer> solutionIterDP = changer.getChoices();
        System.out.println("solveIterDP = " + countIterDP + "\n" + solutionIterDP);

        ArrayList<Integer> greedySolution = changer.solveGreedy();
        System.out.println(greedySolution);

    }
}
