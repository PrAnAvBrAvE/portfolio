#include<stdio.h>
struct times
{
       int p,art,but,wtt,tat,rnt;
};
void sortart(struct times a[],int pro)
{
       int i,j;
       struct times temp;
       for(i=0;i<pro;i++)
       {
	      for(j=i+1;j<pro;j++)
	      {
		     if(a[i].art > a[j].art)
		     {
			   temp = a[i];
			   a[i] = a[j];
			   a[j] = temp;
		     }
	      }
       }
       return;
}
int main()
{
       int i,j,pro,time,remain,flag=0,ts;
       struct times a[100];
       float avgwt=0,avgtt=0;
       clrscr();
       printf("\t\t\t***Round Robin Scheduling Algorithm***\n\n\n");
       printf("Enter Number Of Processes : ");
       scanf("%d",&pro);
       remain=pro;
       for(i=0;i<pro;i++)
       {
	      printf("Enter Arrival time for Process P[%d] : ",i);
	      scanf("%d",&a[i].art);
	       printf("Enter Burst time for Process P[%d] : ",i);
		scanf("%d",&a[i].but);
	      a[i].p = i;
	      a[i].rnt = a[i].but;
       }
       sortart(a,pro);
       printf("Enter Time Quantum : ");
       scanf("%d",&ts);
       printf("\n***************************************\n\n");
       printf("Gantt Chart\n\n");
       printf("%d",a[0].art);
       for(time=a[0].art,i=0;remain!=0;)
       {
	      if(a[i].rnt<=ts && a[i].rnt>0)
	      {
		     time = time + a[i].rnt;
		     printf(" -> [P%d] <- %d",a[i].p,time);
		     a[i].rnt=0;
		     flag=1;
	      }
	      else if(a[i].rnt > 0)
	      {
		     a[i].rnt = a[i].rnt - ts;
		     time = time + ts;
		     printf(" -> [P%d] <- %d",a[i].p,time);
	      }
	      if(a[i].rnt==0 && flag==1)
	      {
		     remain--;
		     a[i].tat = time-a[i].art;
		     a[i].wtt = time-a[i].art-a[i].but;
		     avgwt = avgwt + time-a[i].art-a[i].but;
		     avgtt = avgtt + time-a[i].art;
		     flag=0;
	      }
	      if(i==pro-1)
		     i=0;
	      else if(a[i+1].art <= time)
		     i++;
	      else
		     i=0;
       }
printf("\n\n");
printf("*************************************************************************\n\n");
       printf("| Process | Arrival Time | Burst Time | Turnaround Time | Waiting Time |\n");
       for(i=0;i<pro;i++)
       {
	      printf("| P[%d]\t  |   %d\t\t |   %d\t      |   %d\t\t|    %d\t       |\n",a[i].p,a[i].art,a[i].but,a[i].tat,a[i].wtt);
       }
	printf("\n\n*************************************************************************\n\n");
       printf("Results\n");
       avgwt = avgwt/pro;
       avgtt = avgtt/pro;
       printf("Average Waiting Time : %.2f\n",avgwt);
       printf("Average Turnaround Time : %.2f\n",avgtt);
       printf("\n*************************************************************************\n\n");
       getch();
       return 0;
}

