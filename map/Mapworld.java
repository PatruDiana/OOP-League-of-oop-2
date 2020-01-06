package map;

import common.Constants;
public class Mapworld {
    private static Mapworld instance = null;
    private int[][] map;
    private int row;
    private int col;


    Mapworld(final int row, final int column) {
        this.map = new int[row][column];
        this.row = row;
        this.col = column;
    }
    public static Mapworld getInstance(final int row, final int column) {
        instance = new Mapworld(row, column);
        return instance;
    }
    public static Mapworld getInstance() {
        return instance;
    }

    /**
     * @return  - the map
     */
    public int[][] getMap() {
        return map;
    }

    /**
     * @param location - the types of land on the current line of the map.
     * @param currRow - the current row.
     */
    public void setLocation(final String location, final int currRow) {
        char[] lArray = location.toCharArray();
        int currCol = 0;
        for (char c : lArray) {
            if (c == 'L') {
                this.map[currRow][currCol++] = Constants.LAND_TYPE;
            } else if (c == 'V') {
                this.map[currRow][currCol++] = Constants.VOLCANIC_TYPE;
            } else if (c == 'D') {
                this.map[currRow][currCol++] = Constants.DESERT_TYPE;
            } else {
                this.map[currRow][currCol++] = Constants.WOODS_TYPE;
            }

        }
    }
    /**
     * @param i - the current row
     * @param j - the current column
     * @return - the type of land.
     */
    public int getlocation(final int i, final int j) {
        return map[i][j];
    }
}
