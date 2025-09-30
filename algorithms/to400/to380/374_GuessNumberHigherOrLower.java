package to400.to380;

class GuessNumberHigherOrLower {
    private static final int ANSWER = 1_700_000_000;

    public static void main(String[] args) {
        GuessNumberHigherOrLower c = new GuessNumberHigherOrLower();
        System.out.println(ANSWER == c.guessNumber(Integer.MAX_VALUE));
    }

    public int guessNumber(int n) {
        int l = 1;
        int r = n;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int result = guess(mid);
            if (result == 0) {
                return mid;
            } else if (result > 0) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return 0;
    }

    private int guess(int g) {
        return Integer.compare(ANSWER, g);
    }
}
