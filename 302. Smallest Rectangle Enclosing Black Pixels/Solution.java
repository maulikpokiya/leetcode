class Solution {
    public int minArea(char[][] image, int x, int y) {
        int[] area = new int[] {x,x,y,y};
        helper(image, x, y, area);
        return (area[1]-area[0]+1) * (area[3]-area[2]+1);
    }

    private void helper(char[][] image, int x, int y, int[] area) {
        if(x < 0 || y < 0 || x == image.length || y == image[0].length || image[x][y] == '0') {
            return;
        }

        image[x][y] = '0';

        area[0] = Math.min(area[0], x);
        area[1] = Math.max(area[1], x);
        area[2] = Math.min(area[2], y);
        area[3] = Math.max(area[3], y);

        helper(image, x+1, y, area);
        helper(image, x, y+1, area);
        helper(image, x-1, y, area);
        helper(image, x, y-1, area);
    }
}
