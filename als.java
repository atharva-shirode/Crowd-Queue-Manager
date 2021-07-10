/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ADS
 */
import java.util.*;

public class als {
    static void display(int A[])
    {
        for(int i=1;i<A.length;i++)
        {
            System.out.print(A[i]);
            System.out.print("    ");
        }
    }
    static void displaycopy(int A[],int a[])
    {
        for(int i=1;i<A.length;i++)
        {
            System.out.print(A[i]);
            System.out.print(" ");
            System.out.print(a[i]);
            System.out.print("   ");

        }
    }

   
    public static void main(String[] args) 

    {
        int i,j,k;
        Scanner sc=new Scanner (System.in);
        System.out.println("..............All the best -Iron Man and Captain America save us from Corona .............");
        System.out.println("Enter the no. of tolls from Isengard to Middle-Earth");
        int n=sc.nextInt();
        int a1[]=new int[n+1];
        int a2[]=new int[n+1];
        int t1[]=new int[n];
        int t2[]=new int[n];
        int f1[]=new int[n+1];
        int f2[]=new int[n+1];
        int l1[]=new int[n+1];
        int l2[]=new int[n+1];
        int l_op,f_op;

        

        
        System.out.println("Now enter the stage wise toll cost for the first route");
        for(i=1;i<a1.length;i++)
        {
            System.out.println("Enter the " +i+ " stage toll cost");
            a1[i]=sc.nextInt();
        }
        System.out.println("Now enter the stage wise toll cost for the second route");
        for(i=1;i<a2.length;i++)
        {
            System.out.println("Enter the " +i+ " stage toll cost");
            a2[i]=sc.nextInt();
        }
        System.out.println("Now enter the stage wise route switch cost for the first route");
        for(i=1;i<t1.length;i++)
        {
            System.out.println("Enter the "+i+ " stage switch cost from route 1 to "+(i+1)+ " stage of route 2");
            t1[i]=sc.nextInt();
        }
        System.out.println("Now enter the stage wise route switch cost for the second route");
       for(i=1;i<t2.length;i++)
        {
            System.out.println("Enter the "+i+" stage switch cost from route 2 to "+(i+1)+" stage of route 1");
            t2[i]=sc.nextInt();
        }
        f1[1]=a1[1];
                    //In this case the entry cost is zero and i think so is the exit cost ....(considering the standard ALS problems)..
        f2[0]=a2[1];
        l1[1]=1;
        l2[1]=2;
        System.out.println(" PS: The left is switched cost from route 1 to route 2 and hence is the right one vice-versa");
        display(a1);
        System.out.println();
        System.out.print(" ");
        displaycopy(t1,t2);
        System.out.println();
        display(a2);

      System.out.println();
        System.out.println("Nowcomputing the shortest path");
        for( j=2;j<n;j++)
        {
            if( f1[j - 1] + a1[j] <= f2[j - 1] + t2[j-1] + a1[j])
               {
                   f1[j] = f1[j - 1] + a1[j];
                      l1[j] = 1;
                    //  System.out.print("1-> ");
               }
            else 
            {
                f1[j] = f2[j - 1] + t2[j-1] + a1[j];
                      l1[j]= 2;
                     // System.out.print("2-> ");
            }
            if (f2[j - 1] + a2[j] <= f1[j- 1] + t1[j-1] + a2[j])
               {
                   f2[j] = f2[j - 1] + a2[j];
                      l2[j]=2;
                     // System.out.print("2-> ");
               }
               else
               { f2[j]=f1[j - 1] + t1[j-1] + a2[j];
                      l2[j]=1;
                    //  System.out.print("1-> ");
               }
              


        }
        if (f1[n] <= f2[n])
        {
         f_op= f1[n] ;    //x1 and x2 i.e exit cost in this case are zero....
         l_op = 1;
        // System.out.println("1->is the end");

     }

       else
       {
           f_op = f2[n];
         l_op = 2;
         //System.out.println("2->is the end");
      }
        
        if(l_op==1)
        {
        for(i=1;i<l1.length;i++)
        {
            
            System.out.print("a"+l1[i]+","+i);
            System.out.print("->");
            System.out.print(" ");
        }
        }
        else
        {
            for(i=1;i<l2.length;i++)
        {
            
            System.out.print("a"+l2[i]+","+i);
            System.out.print("->");
            System.out.print(" ");
        }
        }

      System.out.println("hence the shortest toll fee is :"+f_op);



        
       
    }
    
}

