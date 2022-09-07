public class Board {
    private static final int MAX_L = 13;
    private static final int MAX_H = 60;
    private boolean[][] field;

    public Board(int aliveCount) {
        field = generateField(aliveCount);
    }

    private static boolean[][] generateField(int aliveCount) {
        boolean[][] field = new boolean[MAX_L][MAX_H];
        for (int i = 0; i < aliveCount; i++) {
            int x = (int) (Math.random() * MAX_L);
            int y = (int) (Math.random() * MAX_H);
            if (field[x][y]){
                i++;
            }else {
                field[x][y] = true;
            }
        }
        return field;
    }

    public void print(){
        for (boolean[] rov:field) {
            for (boolean cell:rov) {
                System.out.print((cell)?"*" : ".");
            }
            System.out.println();
        }
    }

    public int nextStep() {
        boolean[][] nextField = new boolean[MAX_L][MAX_H];
        int alive = 0;
        for (int x = 0; x < MAX_L; x++) {
            for (int y = 0; y < MAX_H; y++) {
                int countAlive = countAlive(x, y);
                boolean isAlive = countAlive == 2 || countAlive == 3;
               if (isAlive){
                   nextField[x][y] = true;
                   alive++;
               }
            }
        }
        field = nextField;
        return alive;

    }
    private int countAlive(int collx,int colly) {
        int count = 0;
        for (int x = Math.max(collx - 1, 0); x < Math.min( collx + 1,MAX_L + 1); x++) {
            for (int y = Math.max(colly - 1, 0); y < Math.min(colly + 1,MAX_H + 1); y++){
                if (field[x][y]) count++;
        }
    }
        return count;
    }
}
