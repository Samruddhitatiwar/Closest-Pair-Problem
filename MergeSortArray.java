public class MergeSortArray{
     public static void merge(double[][] arr,int l,int m,int r,int col){
                      int n1=m-l+1;
                      int n2=r-m;
                      double L[][]=new double[n1][2];
                      double R[][]=new double[n2][2];
                      for(int i=0;i<n1;i++)
                      {
                        L[i][0]=arr[l+i][0];
                        L[i][1]=arr[l+i][1];
                        
                      }
                      for(int j=0;j<n2;j++){
                      R[j][0]=arr[m+1+j][0];
                      R[j][1]=arr[m+1+j][1];
                      }
                      int i=0,j=0;
                      int k=l;
                      while(i<n1 && j<n2){
                        if(L[i][col]<=R[j][col]){
                                            arr[k][0]=L[i][0];
                                            arr[k][1]=L[i][1];
                                            i++;
                        }
                        else{
                         arr[k][0]=R[j][0];
                         arr[k][1]=R[j][1];
                         j++;
                        }
                        k++;
                      }
               while(i<n1) {
                      arr[k][0]=L[i][0];
                      arr[k][1]=L[i][1];
                      i++;
                      k++;
               }
               while(j<n2){
                      arr[k][0]=R[j][0];
                      arr[k][1]=R[j][1];
                      j++;
                      k++;
               }

     }
  public static void mergeSort(double[][] arr,int l,int r,int col){
     if(l<r){
                      int m=l+(r-l)/2;
                      mergeSort(arr, l, m,col);
                      mergeSort(arr,m+1,r,col);
                      merge(arr,l,m,r,col);
     }
  }
  public static void display1(double arr[][]){
                      for (int i = 0; i < arr.length; i++) {
                             for (int j = 0; j < arr[i].length; j++)
                                 System.out.print(arr[i][j] + " ");
                             System.out.println();
                         }
               }
}