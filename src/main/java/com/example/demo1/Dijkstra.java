package com.example.demo1;
import java.util.List;
import java.util.ArrayList;
import java.util.Vector;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Dijkstra {
    int[] way;
    //Масив для зберігання відвіданих вершин
    boolean[] visited;
    int[][] graph;
    int [][] Tree = new int [14] [14];
    int start;
    int current;
    //Значення міток вершин
    int[] distance;
    int len;

    Dijkstra(Graph matrix, int start){
        len = matrix.getMatrix().length;
        graph = new int[len][];
        distance = new int[len];
        way = new int[len];
        visited = new boolean[len];

        for (int i = 0; i < len; i++) {
            graph[i] = matrix.getMatrix()[i].clone();
            //Усі вершини напочатку невідвідані та мають мітку нескінченності
            visited[i] = false;
            distance[i] = Integer.MAX_VALUE;
        }
        this.start = start - 1;
        distance[this.start] = 0; // стартова вершина має мітку 0 та відвідана
        visited[this.start] = true;
        current = this.start;
    }

    public boolean next_step() {
        int min_i = -1, min_d = Integer.MAX_VALUE;
        //Аналізуємо вершини сусідні до поточної та змінюємо мітки
        for (int i = 0; i < len; i++) {
            if (!visited[i] && graph[current][i] != 0) {
                int newDist = distance[current] + graph[current][i];
                if (newDist < distance[i]) {
                    distance[i] = newDist;
                    way[i] = current;
                }
            }
        }
        //Знаходимо невідвідану вершину з мінімальною міткою та приєднуємо до дерева

        for (int i = 0; i < len; i++) {
            if (!visited[i] && distance[i] < min_d) {
                min_d = distance[i];
                min_i = i;
            }
        }

        if (min_i == -1) return false;
        Tree[way[min_i]][min_i]=graph[way[min_i]][min_i];
        visited[min_i] = true;
        current = min_i;
        return true;
    }

    public int[] getDistances() {
        return distance;
    }

    public int[] getPath() {
        return way;
    }

    public int getCurrent() {
        return current;
    }

    public int[][] getTree() {
        return Tree;
    }


}
