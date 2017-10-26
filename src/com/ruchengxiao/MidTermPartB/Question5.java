package com.ruchengxiao.MidTermPartB;

import java.util.*;

public class Question5 {
    public static void main(String[] args) {
        Question5 test = new Question5();
        int[][] maze = {{1, 0, 0, 0},
                        {1, 1, 1, 1},
                        {0, 1, 0, 0},
                        {1, 1, 1, 1}};
        ArrayList<Cell> list = test.findPath(maze);
        //for(Cell c : list){
            System.out.println(Arrays.toString(new ArrayList[]{list}));
        //}
    }
    public ArrayList<Cell> findPath(int[][] maze) {
        ArrayList<ArrayList<Cell>> result = new ArrayList<>();
        Queue<Cell> queue = new LinkedList<>();
        queue.offer(new Cell(0, 0));
        ArrayList<Cell> temp1 = new ArrayList<>();
        temp1.add(new Cell(0, 0));
        result.add(temp1);
        int[] deltaX = {0, 1};
        int[] deltaY = {1, 0};
        while (!queue.isEmpty()) {
            Cell temp = queue.poll();
            temp1 = result.get(0);
            result.remove(0);
            maze[temp.x][temp.y] = 0;
            for (int i = 0; i < 2; i++) {
                Cell cell = new Cell(
                        temp.x + deltaX[i],
                        temp.y + deltaY[i]
                );

                if (!inBound(cell, maze)) {
                    continue;
                }

                if (maze[cell.x][cell.y] == 1) {
                    System.out.println(result.size());


                    ArrayList<Cell> temp2 = new ArrayList<>(temp1);
                    temp2.add(cell);
                    result.add(temp2);
                    queue.add(cell);
                    maze[cell.x][cell.y] = 0;
                    if (cell.x == maze.length - 1
                            && cell.y == maze[0].length - 1) {
                        return result.get(0);
                    }
                }


            }
        }


        return null;
    }

    private boolean inBound(Cell cell, int[][] maze) {
        return cell.x >= 0 && cell.x < maze.length
                && cell.y >= 0 && cell.y < maze[0].length;
    }
}

class Cell {
    int x, y;
    Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return "[" + this.x + ", " + this.y + "]";
    }
}