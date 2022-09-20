import java.util.*;

public class Test {

       public static void main(String args[]){
           Scanner sc=new Scanner(System.in);
           System.out.println("Enter number of points in the plane: ");
           int num=sc.nextInt();
           double[][] arr=new double[num][2];
           for(int i=0;i<num;i++)
              for(int j=0;j<2;j++){
                arr[i][j]=sc.nextDouble();
                
                
              }        
        MergeSortArray.display1(arr);
           MergeSortArray.mergeSort(arr, 0, arr.length-1, 0);
           System.out.println("-----POINTS AFTER SORTING-----");
        
        MergeSortArray.display1(arr);
           System.out.println("middle x="+arr[arr.length/2][0]);
           double d=ClosestPairProblem.findMinDistance(arr, 0,arr.length);//find d=min(d1,d2)
           System.out.println("closest distance is: "+d);
}
}
