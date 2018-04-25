package com.domain;

import java.util.LinkedList;
import java.util.Queue;

public class Graph {

    private int numbOfVertices;

    private Queue<Integer> queue;

    public static final int NO_COLOR = 0;
    public static final int WHITE = 1;
    public static final int BLACK = 2;

    public Graph(int numbOfVertices) {

        this.numbOfVertices = numbOfVertices;
        queue = new LinkedList<>();

    }
    public boolean isBipartite(int adjacencyMatrix[][], int source) {

        int[] colored = new int[numbOfVertices +  1];

        for (int vertex = 0; vertex < numbOfVertices; vertex++) {
            colored[vertex] = NO_COLOR;

        }

        colored[source] = WHITE;

        queue.add(source);
        int element, neighbour;

        while (!queue.isEmpty()) {

            element = queue.remove();

            neighbour = 0;

            while (neighbour < numbOfVertices) {

                if (adjacencyMatrix[element][neighbour] == 1 && colored[element]== colored[neighbour]) {
                    return false;

                }

                if (adjacencyMatrix[element][neighbour] == 1 && colored[neighbour]== NO_COLOR) {

                    colored[neighbour] = (colored[element] == WHITE ) ? BLACK :WHITE;

                    queue.add(neighbour);

                }

                neighbour++;

            }

        }

        return true;

    }




}
