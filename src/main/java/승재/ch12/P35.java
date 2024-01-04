package 승재.ch12;

public class P35 {
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(i, j, grid);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(int i, int j, char[][] grid) {
        if (isOutOfBound(i, grid.length) || isOutOfBound(j, grid[i].length) || grid[i][j] == '0') {
            return;
        }

        // 해당 좌표 방문여부를 갱신하지 않는다면 무한루프 Stackoverflow
        grid[i][j] = '0';

        // 상하좌우
        dfs(i, j - 1, grid);
        dfs(i - 1, j, grid);
        dfs(i + 1, j, grid);
        dfs(i, j + 1, grid);
    }

    private boolean isOutOfBound(int index, int length) {
        return index < 0 || index >= length;
    }
}
