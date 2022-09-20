public class ClosestPairProblem {
        //method to calculate distance using distance formula
        public static double distance(double[] p1,double[] p2){
                  double dist=  (double)Math.sqrt(((p1[0]-p2[0]) * (p1[0]-p2[0]))+
                  ((p1[1]-p2[1])*(p1[1]-p2[1])));
                  return dist;
        }
        //method to calculate minimum distance between 3 or less than 3 points
        public static double BruteForce(double[][] arr,int n){
                      double min=Double.MAX_VALUE;
                      double currmin=0;
                      for (int i = 0; i < n; i++) {
                                            
                                            for (int j = i + 1; j < n; j++) {
                                              currmin = distance(arr[i], arr[j]);
                                              
                                              if (currmin < min ) {
                                                min = currmin;
                                              }
                                            }
                                          }
                      return min;
        }
        //recursive method to calculate minimum distance
        public static double findMinDistance(double[][] arr,int lb,int ub){
                      if((ub-lb)<=3){
                         return BruteForce(arr,arr.length);
                      }
                      int mid=(lb+(ub-lb))/2;
                      double[] midpoint={arr[mid][0],arr[mid][1]};
                      double d1=findMinDistance(arr, lb, mid);
                      double d2=findMinDistance(arr, mid, ub);
                      double d=Math.min(d1,d2);
                      //checking for min distance in the middle area
                      //adding all points in band which have distance <d
                      double[][] band=new double[ub][2];
                      int size=0;
                      for (int i = 0; i < ub; i++) {
                                            if (Math.abs(arr[i][0] - midpoint[0]) < d) {
                                              band[size] = arr[i];
                                              size++;
                                            }
                                          }
                      return Math.min(d, bandMinimum(band, size, d));
                      // return d;
                      
        }

        public static double bandMinimum(double[][] arr,int size,double d){
                      double dmin=d;
                      MergeSortArray.mergeSort(arr, 0, arr.length-1, 1);//sort wrt y
                      for (int i = 0; i < size; i++) {
                                  for (int j = i + 1; j < size && (arr[j][1] - arr[i][1]) < dmin; j++) {
                                            if (distance(arr[i], arr[j]) < dmin && distance(arr[i], arr[j])!=0) {
                                            dmin = distance(arr[i], arr[j]);
                                            }
                      }
                      }
                      
                      return dmin;
        }
}
