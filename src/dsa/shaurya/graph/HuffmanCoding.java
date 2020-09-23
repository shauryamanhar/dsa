package dsa.shaurya.graph;

import java.util.Collections;
import java.util.PriorityQueue;

//huffman coding is used to data compression 
//assing more bit for less frquent and less bits for character with high frequency
//this is greedy method
//get with two character with minimun frequency then add there frequency to create root node
//make thode min char left and right node and add this root node in priority queue
//do the same steps for every character
public class HuffmanCoding {
    public static void main(String[] args) {
        int fq[] = { 12, 2, 7, 13, 14, 85 };// frequency of characters
        char character[] = {'a','b','c','d','e','f'};//respective characters
        int n = fq.length;
        huffmanCoding(fq, character,n);
    }

    static void huffmanCoding(int fq[], char c[],int n) {
        //Min Priority Queue
        PriorityQueue<HuffmanNode> pq = new PriorityQueue<>(n, Collections.reverseOrder());

        //create Priority Queue with frquency and character
        int r=0;
        for (int a : fq) {
            pq.add(new HuffmanNode(a,c[r++]));
        }
        //create node for tree
        HuffmanNode temp;

        //end this loop when only one node left in priority queue and it going to root node
        //for loop for all character
        for (int i = 0; i < n && pq.size()>1; i++) {
            temp = new HuffmanNode();
            //get the two minimun node from Priority Queue
            temp.left = pq.poll();
            temp.right = pq.poll();

            System.out.println("left " + temp.left.data + " right " + temp.right.data);

            //add two min node to create one parent node
            temp.data = temp.left.data + temp.right.data;
            //add parent node to Priority Queue
            pq.add(temp);
        }

        System.out.println("completed building");
        System.out.println("Printing Binary");

        //printing all the binary code using preorder traversal
        printBinary(pq.peek(), "");

    }
    static void printBinary(HuffmanNode root,String str){
        if(root==null){
            return;
        }
        //check if it is leaf node and print all the leaf node
        if(root.left==null && root.right==null){
            System.out.println(str+" = "+root.character);
            return;
        }
        //go left with 0 and right with 1
        printBinary(root.left, str+"0");
        printBinary(root.right, str+"1");
    }

    static class HuffmanNode implements Comparable<HuffmanNode> {
        int data;//sum of frequency 
        HuffmanNode left, right;
        char character;
        HuffmanNode() {
        };

        HuffmanNode(int data,char c) {
            this.character=c;
            this.data = data;
            left = right = null;
        }

        //this compareTo is used in PriorityQueue for Min Heap
        @Override
        public int compareTo(HuffmanNode huffmanNode) {
            if (data < huffmanNode.data) {
                return 1;
            } else if (data > huffmanNode.data) {
                return -1;
            }
            return 0;
        }
    }// HuffmanNode
}
/*
output:
left 2 right 7
left 9 right 12
left 13 right 14
left 21 right 27
left 48 right 85
completed building
Printing Binary
0000 = b
0001 = c
001 = a
010 = d
011 = e
1 = f

*/