class segment_tree{
    int[]st;
    public static void construct(int[]arr,int n){
        int x=Math.ceil(Math.log(n)/Math.log(2));
        int size=2*(Math.pow(2,x))-1;
        st=new int[size];
        construct_rec(arr,n,0,n-1,0);
    }
    public static int construct_rec(int[]arr,int n,int ss,int se,int si){

        if(ss==se){
            st[si]=arr[ss];
            return arr[ss];
        }

        int mid=ss+(se-ss)/2;
        st[si]=construct_rec(arr,n,ss,mid,si*2+1)+
        construct_rec(arr,n,mid+1,se,si*2+2);
        return st[si];

    }
    public static int sum(int[]arr,int ss,int se,int qs,int qe,int si){
        if(qs<ss || qe>se)
        return 0;

        if(qs>=ss && qe<=se){
            return st[si];
        }

        int mid=ss+(se-ss)/2;
        int s=sum(arr,ss,mid,qs,qe,si*2+1)+
              sum(arr,mid+1,se,qs,qe,si*2+2);
              return sum;
        }
    public static void main(String[]args){
        int[]arr={1,3,5,7,9,11};
        int n=arr.length;
        construct(arr,n);
    }
}