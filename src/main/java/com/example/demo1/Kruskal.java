package com.example.demo1;

public class Kruskal {
    int [][] graph;
    int [][] Tree = new int [14] [14];
    Kruskal(Graph matrix)
    {
        graph = new int[matrix.getMatrix().length][];
        for (int i = 0; i < matrix.getMatrix().length; i++) {
            graph[i] = matrix.getMatrix()[i].clone();
        }
    }
    public boolean next_step ()
    {
        //Шукаємо в графі ребро з мінімальною вагою
        int min = Integer.MAX_VALUE;
        int min_i=-1, min_j=-1;
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                if ( graph[i][j]!=0 && graph[i][j] < min) {
                    min = graph[i][j];
                    min_i =i;
                    min_j=j;
                }
            }
        }
        if (min_i==-1) return false;
        else
        {
            Tree[min_i][min_j]=min; //Додаємо ребро до дерева
            //Більше не розглядаємо ребра, що напрямлені на приєднану вершину
            for (int i = 0; i < graph.length; i++) {
                graph[i][min_j]=0;
            }
            return true;
        }
    }

    public int[][] getTree() {
        return Tree;
    }
}

