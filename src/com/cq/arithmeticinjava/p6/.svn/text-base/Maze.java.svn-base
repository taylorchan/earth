/******************************************************************************
 * Copyright (C) 2012 ShenZhen Xinyi Technology Co.Ltd,.
 * All Rights Reserved.
 * 本软件为深圳信义科技开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、
 * 复制、修改或发布本软件.
 *****************************************************************************/
package com.cq.arithmeticinjava.p6;


/**
 * 迷宫
 * @author: qiang.chen
 * @since:    2012-7-9
 * @version : 1.0
 * @E-mail： qiang.chen@xinyi-tech.com
 */
public class Maze {
    private static final int MAX_SIZE = 8;
    // 这样组成了向周围4个方向 依次是 ← ↓ → ↑
    int h[] = { 0, 1, 0, -1 };
    int v[] = { -1, 0, 1, 0 };
    char Maze[][] = {
        { 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' },
        { ' ',   ' ',   ' ',  ' ',  ' ',  'X', 'X', 'X' },
        { 'X',  ' ',  'X', 'X', ' ',  ' ',   ' ',  'X' },
        { 'X',  ' ',  'X', 'X', ' ',  'X',  'X',  ' ' },
        { 'X',  ' ',  'X', 'X', 'X', 'X', 'X', 'X' },
        { 'X',  ' ',  'X', 'X',  ' ',  ' ',  ' ',  'X' },
        { 'X',  ' ',  ' ',   ' ',   ' ',  'X', ' ',   ' ' },
        { 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' } 
        };
    void findPath(int X,int Y){
        
        if (X == MAX_SIZE || Y == MAX_SIZE) {//表明指针已经移动到边缘 准备输出
            for (int i = 0; i < MAX_SIZE; i++) {
                for (int j = 0; j < MAX_SIZE; j++) {
                    if (j < MAX_SIZE - 1) {
                        System.out.print(Maze[i][j] + " ");
                    } else {//到达列末尾 准备换行
                        System.out.println(Maze[i][j]);
                    }
                }
            }
        } else {
                checkAround(X, Y);
        }
    }
    void checkAround(int X, int  Y){
        if (X >= 0 && Y >= 0 && Y < MAX_SIZE && X < MAX_SIZE
                && ' ' == Maze[X][Y]) {
            Maze[X][Y] = '.';
            for (int k = 0; k < 4; k++) {
                findPath(X + v[k], Y + h[k]);// 检查周围4个方向是不是也是o    
            }
            Maze[X][Y] = ' ';//沿着路线走 最终有的路可能是走不通 标记回来
        }
    }
    public static void main(String[] args) {
        Maze maze = new Maze();
        maze.findPath(1, 0);
        
    }
}
