package com.example.demo1;
import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    //Масив для зберігання відвіданих вершин
    boolean[] visited;

    int[][] graph;
    int [][] Tree = new int[14][14];
    int start;
    int current;
    int len;
    //Використовуємо чергу
    Queue<Integer> queue;

    BFS(Graph matrix, int start) {
        len = matrix.getMatrix().length;
        graph = new int[len][];
        visited = new boolean[len];
        queue = new LinkedList<>();

        for (int i = 0; i < len; i++) {
            graph[i] = matrix.getMatrix()[i].clone();
            visited[i] = false;
        }
        this.start = start - 1;
        // Додаємо стартовий вузол до черги та вважаємо його відвіданим
        visited[this.start] = true;
        current = this.start;
        queue.add(this.start);
    }

    public boolean next_step() {
        if (queue.isEmpty()) {
            return false; // Якщо черга порожня, алгоритм завершено
        }

        current = queue.poll();

        // Проходимо по сусідах поточного вузла
        for (int i = 0; i < len; i++) {
            if (graph[current][i] != 0 && !visited[i]) { // Якщо є з'єднання та вузол не відвіданий, то Додаємо вузол до черги
                visited[i] = true;
                queue.add(i);
                Tree[current][i] = 1;
            }
        }

        return true;
    }

    public int getCurrent() {
        return current;
    }

    public int[][] getTree() {
        return Tree;
    }
}
