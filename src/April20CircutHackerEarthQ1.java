import java.util.*;
public class April20CircutHackerEarthQ1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while(t-->0) {
			String s[] = sc.nextLine().split(" ");
			int n = Integer.parseInt(s[0]);
			int d = Integer.parseInt(s[1]);
			String c = s[2];
			String nBin = Integer.toBinaryString(n);
			if(nBin.length()<16) {
				int addZero = 16-nBin.length();
				for(int i=0;i<addZero;i++) {
					nBin='0'+nBin;
				}
			}
			char binaryChar[] = nBin.toCharArray();
			switch (c) {
			case "L":
				leftRotate(binaryChar, d, binaryChar.length);
				System.out.println(Integer.parseInt(new String(binaryChar),2));
				break;
			case "R":
				rightRotate(binaryChar, d, binaryChar.length);
				System.out.println(Integer.parseInt(new String(binaryChar),2));
				break;
			}
		}
	}
	static void leftRotate(char arr[], int d, int n) 
    { 
        for (int i = 0; i < d; i++) 
            leftRotatebyOne(arr, n); 
    } 
  
    static void leftRotatebyOne(char arr[], int n) 
    { 
        int i; char temp; 
        temp = arr[0]; 
        for (i = 0; i < n - 1; i++) 
            arr[i] = arr[i + 1]; 
        arr[i] = temp; 
    } 
    static void rightRotate(char arr[], int d, int n) 
    { 
    	for (int i = 0; i < d; i++) 
    		rightRotatebyOne(arr, n); 
    } 
    
    static void rightRotatebyOne(char arr[], int n) 
    { 
    	int i; char temp; 
    	temp = arr[n-1]; 
    	for (i = n-1; i >0; i--) 
    		arr[i] = arr[i - 1]; 
    	arr[i] = temp; 
    } 
}

