package Recursion;

public class LeetCode5366 {
    static class Solution {
        char streets[][] = new char[][]{
                {'-','-'},
                {'L','R'},
                {'U','D'},
                {'L','D'},
                {'R','D'},
                {'U','L'},
                {'U','R'}
        };

        public boolean hasValidPath(int[][] grid) {
            return travel(grid, 0, 0, '-');
        }

        public boolean travel(int[][] grid, int x, int y, char prev) {
            if(x < 0 || y < 0) return false;
            if(x >= grid.length || y >= grid[x].length) return false;

            int path = grid[x][y];
            if(x == grid.length - 1 && y == grid[x].length - 1) {
                if(prev == '-') return true;
                if ((prev == 'D') && ((streets[path][0] == 'U') || (streets[path][1] == 'U'))) {
                    return true;
                }
                if ((prev == 'R') && ((streets[path][0] == 'L') || (streets[path][1] == 'L'))) {
                    return true;
                }
            }

            if(prev != '-') {
                if(prev == 'U' && streets[path][0] != 'D' && streets[path][1] != 'D') return false;
                if(prev == 'D' && streets[path][0] != 'U' && streets[path][1] != 'U') return false;
                if(prev == 'L' && streets[path][0] != 'R' && streets[path][1] != 'R') return false;
                if(prev == 'R' && streets[path][0] != 'L' && streets[path][1] != 'L') return false;
            }

            boolean res = false;
            if((prev != 'R') && (streets[path][0] == 'L' || streets[path][1] == 'L')) {
                res = res || travel(grid, x, y - 1, 'L');
            }
            if((prev != 'L') && (streets[path][0] == 'R' || streets[path][1] == 'R')) {
                res = res || travel(grid, x, y + 1, 'R');
            }
            if((prev != 'D') && (streets[path][0] == 'U' || streets[path][1] == 'U')) {
                res = res || travel(grid, x - 1, y, 'U');
            }
            if((prev != 'U') && (streets[path][0] == 'D' || streets[path][1] == 'D')) {
                res = res || travel(grid, x + 1, y, 'D');
            }
            return res;
        }
    }

    public static void main(String args[]) {
        int grid[][] = new int[][]{
                {1}
        };
        System.out.println(new Solution().hasValidPath(grid));
    }
}
