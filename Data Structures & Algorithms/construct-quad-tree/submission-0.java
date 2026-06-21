/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
*/

class Solution {
    public Node construct(int[][] grid) {
        return getGrid(0, grid.length - 1, 0, grid[0].length - 1, grid);
    }

    public Node getGrid(int start, int end, int top, int bottom, int[][] grid) {
        int head = grid[start][top];
        Boolean val;
        if(head == 0) val = false; else val = true;
        Boolean isLeaf = true;
        Node topLeft = null, topRight = null, bottomLeft = null, bottomRight = null;
        for(int i = start; i<= end; i++) {
            for(int j = top; j<=bottom; j++) {
                if(grid[i][j] != head) {
                    isLeaf = false;
                    val = true;
                    Integer midX = start + (end - start)/2;
                    Integer midY = top + (bottom - top)/2;
                    topLeft = getGrid(start, midX, top, midY, grid);
                    bottomLeft = getGrid(midX + 1, end, top, midY, grid);
                    topRight = getGrid(start, midX, midY + 1, bottom, grid);
                    bottomRight = getGrid(midX + 1, end, midY+1, bottom, grid);
                    return new Node(val, isLeaf, topLeft, topRight, bottomLeft, bottomRight);
                }
            }
        }
        return new Node(val, isLeaf, topLeft, topRight, bottomLeft, bottomRight);
    }
}