package com.example.animationsgame.model;

public class PositionBarrier {

    public PositionBarrier() {
    }
    public int[][] map1Barrier(){
        int[][] barrier = new int[16][30];
        for(int i = 0; i < 30; i++){
            barrier[0][i] = 2;
            barrier[15][i] = 2;
        }
        for(int i = 1; i < 15; i++){
            barrier[i][0] = 2;
            barrier[i][29] = 2;
        }
        barrier = downConnection(barrier);
        return barrier;
    }
    /*
    public int[][] map2Barrier(){
        int[][] barrier = new int[16][30];
        for(int i = 0; i < 30; i++){
            barrier[0][i] = 2;
            barrier[15][i] = 2;
        }
        for(int i = 1; i < 15; i++){
            barrier[i][0] = 2;
            barrier[i][29] = 2;
        }
        barrier = downConnection(barrier);
        barrier = upConnection(barrier);
        return barrier;
    }
    public int[][] map3Barrier(){
        int[][] barrier = new int[16][30];
        for(int i = 0; i < 30; i++){
            barrier[0][i] = 2;
            barrier[15][i] = 2;
        }
        for(int i = 1; i < 15; i++){
            barrier[i][0] = 2;
            barrier[i][29] = 2;
        }
        barrier = downConnection(barrier);
        barrier = upConnection(barrier);
        return barrier;
    }
     */
    private int[][] downConnection(int[][] barrier){
        barrier[15][15]=0;
        barrier[15][14]=0;
        barrier[15][13]=0;
        barrier[15][16]=0;
        barrier[14][6] = 1;
        barrier[14][7] = 1;
        barrier[14][8] = 1;
        barrier[14][9] = 1;
        barrier[13][6] = 1;
        barrier[13][7] = 1;
        barrier[13][8] = 1;
        barrier[13][9] = 1;
        return barrier;
    }
    private int[][] upConnection(int[][] barrier){
        barrier[0][6] = 0;
        barrier[0][7] = 0;
        barrier[0][8] = 0;
        barrier[0][9] = 0;
        barrier[1][6] = 3;
        barrier[1][7] = 3;
        barrier[1][8] = 3;
        barrier[1][9] = 3;
        return barrier;
    }

}
