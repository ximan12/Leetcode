public class CountTeams {
    public static int factorial(int n) {
        if (n == 0)
            return 1;
        return n * factorial(n - 1);
    }

    public static int countTeams(int num, int[] skills, int minAssociates, int minLevel, int maxLevel){
        int n = 0;
        for (int skill : skills) {
            if (skill <= maxLevel && skill >= minLevel)
                n++;
        }

        int res = 0;
        for (int i = minAssociates; i <= n; i++){
            res += factorial(n) / (factorial(i) * factorial(n - i));
        }

        return res;

    }
}
