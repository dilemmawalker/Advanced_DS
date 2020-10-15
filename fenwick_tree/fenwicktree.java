public class fenwicktree{  //BIT(Binary Indexed Tree)
    public static int[]BIT;
   public static int sum(int[]arr,int i){
       return get_sum(arr,i);
   }
   public static int get_sum(int[]arr,int i){
       int index=i+1;
       int sum=0;
       while(index>0){
        sum+=BIT[index];
        index=index-(index&(-index));
       }
       return sum;
   }
   public static void update(int[]arr,int value,int i){
       int index=i+1;
        int n=arr.length;
       while(index<=n){
           BIT[index]+=value;
           index+=index&(-index);
       }
   }
   public static void construct(int[]arr){
       int n=arr.length;
       for(int i=0;i<n;i++)
       update(arr,arr[i],i);
   }
   public static void display(){
    for(int i=0;i<BIT.length;i++)
    System.out.print(BIT[i]+" ");
    System.out.println();
}
    public static void main(String[]args){
        int[]arr={1,3,5,7,9,11};
        int n=arr.length;
        BIT=new int[n+1];
        construct(arr);
        display();
        int s=sum(arr,4);
        System.out.println(s);
        
    }
}