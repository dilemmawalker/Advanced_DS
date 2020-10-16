public static class fenwicktree{  //BIT(Binary Indexed Tree)
    public static int[]BIT;
    fenwicktree(int n){
        BIT=new int[n+1];
    }
   public static int sum(int i){
       return get_sum(i);
   }
   public static int get_sum(int i){
       int index=i+1;
       int sum=0;
       while(index>0){
        sum+=BIT[index];
        index=index-(index&(-index));
       }
       return sum;
   }
   public static void update(int[]arr,int value,int i){
       int diff=value-arr[i];
       arr[i]=value;
       int n=arr.length;
    update_diff(diff,i);
   }
   public static void update_diff(int value,int i){
       int index=i+1;
       int n=BIT.length;
       while(index<n){
           BIT[index]+=value;
           index+=index&(-index);
       }
   }
   public static void construct(int[]arr){
       int n=arr.length;
       for(int i=0;i<n;i++)
       update_diff(arr[i],i);
   }
   public static void display(){
    for(int i=0;i<BIT.length;i++)
    System.out.print(BIT[i]+" ");
    System.out.println();
}
}