import java.util.ArrayList;
import java.util.Comparator;

public class MakingChange {

    // Coin list
    private Integer[] X;

    // Memoization Table
    private int[][] m;

    // Choices Table
    private int[][] c;

    // Change we need to make
    private int change;

    // Construct the ploblem solver
    public MakingChange(Integer[] coins, int change) {
        X = coins;
        this.change = change;
        m = new int[X.length + 1][change + 1];
        c = new int[X.length + 1][change + 1];
    }

    public int solveRecDP() {
        int solution = solveRecDPHelper(X.length, change);

        if (solution > X.length) {
            solution = -1;
        }

        return solution;
    }

    public int solveRecDPHelper(int i, int j) {
        // Have we solved this problem?
        if (m[i][j] != 0) {
            return m[i][j];
        }

        // Is this possible?
        if (i == 0 && j > 0) {
            m[i][j] = X.length + 1;
            return m[i][j];
        }

        // Are we done yet?
        if (j == 0) {
            return m[i][j];
        }

        // Do we really have a choice?
        if (X[i - 1] > j) {
            m[i][j] = solveRecDPHelper(i - 1, j);
            return m[i][j];
        }

        int take = solveRecDPHelper(i - 1, j - X[i - 1]) + 1;
        int noTake = solveRecDPHelper(i - 1, j);

        if (take < noTake) {
            // We might as well
            m[i][j] = take;
            c[i][j] = 1;
            return m[i][j];
        } else {
            m[i][j] = noTake;
            return m[i][j];
        }
    }

    public int solveIterDP() {
        for (int i = 0; i <= X.length; i++) {
            for (int j = 0; j <= change; j++) {

                if (i == 0) {
                    // Is this possible?
                    if (j > 0) {
                        m[i][j] = X.length + 1;
                    }
                } else {
                    // Do we really have a choice?
                    if (X[i - 1] > j) {
                        m[i][j] = m[i - 1][j];
                    } else {
                        int take = m[i - 1][j - X[i - 1]] + 1;
                        int noTake = m[i - 1][j];

                        if (take < noTake) {
                            // We might as well
                            m[i][j] = take;
                            c[i][j] = 1;
                        } else {
                            m[i][j] = noTake;
                        }
                    }
                }
            }
        }
        return m[X.length][change];
    }

    public ArrayList<Integer> solveGreedy() {
        // Create copy of coins to work with
        ArrayList<Integer> tempCoins = new ArrayList<>();
        for (Integer coin : X) {
            tempCoins.add(coin);
        }

        // Sort the coins in decending order
        tempCoins.sort(Comparator.reverseOrder());

        // Create copy of change to work with
        int changeNeeded = change;

        // look at each coin in tempCoins
        for (int i = 0; i < tempCoins.size();) {
            // removing it if to large, else keep and count it
            if (changeNeeded - tempCoins.get(i) < 0) {
                tempCoins.remove(i);
            } else {
                changeNeeded -= tempCoins.get(i);
                i++;
            }
        }

        // return the remaining coins
        return tempCoins;
    }

    public ArrayList<Integer> getChoices() {
        ArrayList<Integer> solution = new ArrayList<>();
        int workingChange = change;

        for (int i = X.length; i >= 0; i--) {
            if (c[i][workingChange] == 1) {
                solution.add(X[i - 1]);
                workingChange -= X[i - 1];
            }
        }

        return solution;
    }
}
