public class TwoPointer {
    // given a sorted array find all the pairs whose sum is equal to k
    public static int[] sumEqualTokBF(int []arr, int k){

        for(int i =0; i<arr.length; i++){
            for(int j=1; j<arr.length; j++){
                 if(arr[i] + arr[j] == k){
                    return new int[] {i,j};
                 }
            }
        }
        return null;
    }

    public static int[] sumEqualTok(int []arr, int k){
        int count = 0;
        int n = arr.length;
        int i = 0;
        int j = n-1;

        if(arr[i] + arr[j] > k){
            j--;
        }
        else if(arr[i] + arr[j] < k){
            i++;
        }
        
        else{
            count ++;
        }
        return new int[] {i,j};
        
    }
    public static void main(String []args){
        int[] arr = {2,7,11,15};
        int [] ans = sumEqualTokBF(arr, 9);
        int [] ans1 = sumEqualTokBF(arr, 9);
        for(int i: ans1){
            System.out.println(i);
        }
            
    }

}
