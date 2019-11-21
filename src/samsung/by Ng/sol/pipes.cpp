#include<bits/stdc++.h>
using namespace std;
int n,m,x,y,l;
int mt[100][100];
int vi[100][100];
int depth[100][100];
int f=0;
int r=0;
struct node{
	int x;
	int y;
	int d;
};
node  q[1000];
void push(int a,int b,int d)
{
	node temp;
	temp.x=a;
	temp.y=b;
	temp.d=d;
	q[r++]=temp;
	vi[a][b]=1;
}
node pop()
{
	node temp;
	temp.x=q[f].x;
	temp.y=q[f].y;
	temp.d=q[f].d;
	f++;
	return temp;
}
bool s1(int i,int j)
{
	if(i>=0&&i<m&&j>=0&&j<n&&vi[i][j]==0&&(mt[i][j]==1||mt[i][j]==3||mt[i][j]==6||mt[i][j]==7)) //left
	return true;
	else
	return false;
}
bool s2(int i,int j)
{
	if(i>=0&&i<m&&j>=0&&j<n&&vi[i][j]==0&&(mt[i][j]==1||mt[i][j]==2||mt[i][j]==4||mt[i][j]==7)) //top
	return true;
	else
	return false;
}
bool s3(int i,int j)
{
	if(i>=0&&i<m&&j>=0&&j<n&&vi[i][j]==0&&(mt[i][j]==1||mt[i][j]==3||mt[i][j]==4||mt[i][j]==5)) //right
	return true;
	else
	return false;
}
bool s4(int i,int j)
{
	if(i>=0&&i<m&&j>=0&&j<n&&vi[i][j]==0&&(mt[i][j]==1||mt[i][j]==2||mt[i][j]==6||mt[i][j]==5)) //bottom
	return true;
	else
	return false;
}

void bfs(int x,int y,int d)
{
	push(x,y,d);
	while(r>f)
	{
		node temp=pop();
		int i=temp.x;
		int j=temp.y;
		int c=temp.d;
		depth[i][j]=c;
		if(mt[i][j]==1||mt[i][j]==3||mt[i][j]==4||mt[i][j]==5) //right
		{
			if(s1(i,j+1))
			push(i,j+1,c+1);
		}
		if(mt[i][j]==1||mt[i][j]==2||mt[i][j]==6||mt[i][j]==5) //bottom
		{
			if(s2(i+1,j))
			push(i+1,j,c+1);
		}
		if(mt[i][j]==1||mt[i][j]==3||mt[i][j]==7||mt[i][j]==6) //left
		{
			if(s3(i,j-1))
			push(i,j-1,c+1);
		}
		if(mt[i][j]==1||mt[i][j]==2||mt[i][j]==4||mt[i][j]==7) //top
		{
			if(s4(i-1,j))
			push(i-1,j,c+1);
		}
	}
}
int main()
{
	int t;
	cin>>t;
	while(t--)
	{
		f=0;
		r=0;
	cin>>m>>n>>x>>y>>l;	
	for(int i=0;i<m;i++)
	{
		for(int j=0;j<n;j++)
		{
		cin>>mt[i][j];
		vi[i][j]=0;
		depth[i][j]=10000;
		}
		
	}
	if(mt[x][y]!=0)
	bfs(x,y,1);
	
	int nc=0;
	for(int i=0;i<m;i++)
	{
		for(int j=0;j<n;j++)
		{
			if(depth[i][j]<=l)
			nc++;
		}
	}
	cout<<nc<<"\n";
	}
}
