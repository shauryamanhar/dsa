package samsung;

public class Bipartite {

	public static void main(String[] args) {
		boolean g[][] = {{false, true, false, true}, 
		        {true, false, true, false}, 
		        {false, true, false, true}, 
		        {true, false, true, false} 
		    }; 
		System.out.println(bfs(g,4,0));
	}
	
	static boolean bfs(boolean graph[][],int vertex,int source) {
		Queue q = new Queue();
		int colored[] = new int[vertex];
		boolean visited[] = new boolean[vertex];
		for(int i=0;i<vertex;i++) {
			colored[i]=-1;
		}
		q.push(source);
		colored[source]=1;
		visited[source]=true;
		while(!q.isEmpty()) {
			int temp = q.pop();
			for(int v=0;v<vertex;v++) {
				if(visited[v]==false && graph[temp][v]==true ) {
					visited[v]=true;
					q.push(v);
					colored[v] = 1-colored[temp];
				}else if(graph[temp][v]==true && colored[v]==colored[temp]) {
					return false;
				}
			}
		}//while
		return true;
	}//bfs
	
}

class Queue{
	private class Node{
		int data;
		Node next;
		Node(int data) {
			this.data=data;
			this.next=null;
		}
	}
	Node head=null;
	Node tail=null;
	boolean isEmpty(){
		return head==null;
	}
	void push(int data) {
		Node newNode = new Node(data);
		if(head==null) {
			head = newNode;
			tail = newNode;
		}else {
			tail.next=newNode;
			tail=newNode;
		}
	}
	Integer pop() {
		if(isEmpty()) {
			return null;
		}else {
			Node temp = head;
			head = head.next;
			if(head==null) {
				tail=null;
			}
			return temp.data;
		}
	}
	Integer peek() {
		return head.data;
	}
}//class
