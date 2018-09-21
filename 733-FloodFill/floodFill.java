class Solution {
    /*
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        if (oldColor == newColor) return image;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {sr, sc});

        int[][] dirs = new int[][] {{1, 0, -1, 0}, {0, 1, 0, -1}};
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            image[curr[0]][curr[1]] = newColor;
            for (int i = 0; i < dirs[0].length; i++) {
                int nr = curr[0] + dirs[0][i];
                int nc = curr[1] + dirs[1][i];
                if (nr < 0 || nr >= image.length || nc < 0 || nc >= image[0].length || image[nr][nc] != oldColor)
                    continue;
                queue.add(new int[] {nr, nc});
            }
        }
        return image;
    }
    */
    // faster without queue
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) return image;
        fill(image, sr, sc, image[sr][sc], newColor);
        return image;
    }
    
    private void fill(int[][] image, int sr, int sc, int color, int newColor) {
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != color) return;
        image[sr][sc] = newColor;
        fill(image, sr + 1, sc, color, newColor);
        fill(image, sr - 1, sc, color, newColor);
        fill(image, sr, sc + 1, color, newColor);
        fill(image, sr, sc - 1, color, newColor);
    }
}
}