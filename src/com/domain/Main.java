package com.domain;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int numbOfNodes, source;
        Scanner scanner = null;

        try {

            System.out.println("Enter the number of nodes in the graph: ");
            scanner = new Scanner(System.in);
            numbOfNodes = scanner.nextInt();



            int adjacencyMatrix[][] = new int[numbOfNodes + 1][numbOfNodes + 1];

            System.out.println("Enter the adjacency matrix");

            for (int i = 0; i < numbOfNodes; i++) {

                for (int j = 0; j < numbOfNodes; j++) {

                    adjacencyMatrix[i][j] = scanner.nextInt();
                }
            }

            for (int i = 0; i < numbOfNodes; i++) {
                for (int j = 0; j < numbOfNodes; j++) {
                    if(adjacencyMatrix[i][j] == 1 && adjacencyMatrix[j][i] == 0) {
                        adjacencyMatrix[j][i] = 1;
                        }
                }
            }

            System.out.println("Enter the source for the graph: ");
            source = scanner.nextInt();

            Graph bipartiteBfs = new Graph(numbOfNodes);

            if (bipartiteBfs.isBipartite(adjacencyMatrix, source)) {
                System.out.println("The given graph is bipartite! =)");
            } else{
                System.out.println("The given graph is not bipartite! =)");
            }

            } catch (InputMismatchException inputMismatch){
            System.out.println("Wrong Input format =(");
            }

            scanner.close();
    }
}
