// TollGate - March'16 Advance Test problem Solution using DFS or Preorder Tree traversal
#include <stdio.h>
#include<time.h>
//  no.of.toll gate(between 5 and 20, cost at toll gate, total hire available at tollgate, minimum cost
int N,   t_cost  [22], t_hire[22], min_cost = 1000000;

void dfs(int t_pos, int bpool3, int bpool2, int bpool1, int cur_cost)
{
	int  tot_bpool  = bpool3 + bpool2 + bpool1;
	if (cur_cost > min_cost) return;   // condition important to avoid unnecessary cpu cycle
	if (t_pos == N-1)   //base condition to check last toll gate
	{
		if ( tot_bpool  < t_hire[t_pos]) cur_cost += t_cost[t_pos];
		if ( cur_cost   < min_cost) min_cost = cur_cost;
		return;
	}

   dfs(t_pos+1, bpool3 , bpool2, bpool1 , cur_cost+t_cost[t_pos]);  //toll pay option
   dfs(t_pos+1, bpool3+t_hire[t_pos], bpool2, bpool1 , cur_cost+2*t_cost[t_pos]);  //toll hire option

	if ( tot_bpool  >= t_hire[t_pos] )  //toll battle option
	{
		if (t_hire[t_pos] > bpool2 + bpool1 )
        {
            bpool3  =  tot_bpool - t_hire[t_pos];
            bpool1 = bpool2 = 0;
        }
		else if (t_hire[t_pos] > bpool1 )
        {
             bpool2 = (bpool1+bpool2) - t_hire[t_pos];
             bpool1 = 0;
        }
		dfs(t_pos+1, 0,  bpool3 , bpool2, cur_cost); // note: pool3 is zero, pool3 becomes pool2 and pool2 as pool1
    }
}

int main()
{
    int i, TC;
    clock_t start, end;
    double cpu_time_used;

    printf("No.of.TC? ");      scanf("%d", &TC);
    start = clock();
    while( TC-- )
    {
    	scanf("%d", &N);
    	for ( i = 0; i < N; ++i)
    	    scanf("%d %d", &t_hire[i], & t_cost  [i]);


    	dfs(0, 0, 0, 0, 0);
    	printf("\nMinCost= %d\n\n", min_cost );
    	min_cost = 1000000;  //some large number
     }
   end = clock();
   cpu_time_used = ((double) (end - start)) / CLOCKS_PER_SEC;
   printf("fun() took %f seconds to execute \n", cpu_time_used);
//   getch();
	return 0;
}


/*  input test case  5 is no.of.TC, 7 is no.of. toll gates,  each line no.of.hire and toll cost
cut and paste from next line*/ /*
5
7
10 100
70 5
80 15
20 60
50 90
30 80
10 10

9
600 800
300 400
300 400
1000 400
300 600
100 300
600 300
600 500
1000 300

11
1000 10
700 900
400 500
300 10
900 900
300 10
50 900
50 900
700 900
500 900
50 10

20
896 546
543 216
454 310
408 367
40 602
252 582
954 627
850 234
763 479
232 278
301 538
528 508
936 154
629 443
758 336
432 700
882 256
278 738
517 882
317 136

20
410 610
831 909
675 629
421 774
386 869
544 219
492 414
996 557
499 482
231 285
804 978
304 881
489 911
75 315
927 648
252 914
330 396
937 133
813 717
495 882

*/
/*
Output for below sample input
150 3000 2370 4721 8231
*/

