package DSA.Hashmaps;

import java.util.ArrayList;
import java.util.HashMap;

public class MapUse {

    public static ArrayList<Integer> removeDuplicates(int[] arr){
        ArrayList<Integer> output = new ArrayList<>();
        HashMap<Integer, Boolean> seen = new HashMap<>();

        for(int i=0; i<arr.length; i++){
            if(seen.containsKey(arr[i])){
                continue;
            }
            seen.put(arr[i], true);
            output.add(arr[i]);
        }
        return output;
    }
    
    public static int maxFrequencyNumber(int[] arr){ 
        if(arr.length == 0){
            return -1;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<arr.length; i++){
            if(map.containsKey(arr[i])){
                map.put(arr[i], map.get(arr[i])+1);
            }
            else{
                map.put(arr[i], 1);
            }
        }

        int max = arr[0];
        for(int i=1; i<arr.length; i++){
            if(map.get(arr[i]) > max){
                max = arr[i];
            }
        }
        return max;
    }
    
    public static void printIntersection(int[] arr1,int[] arr2){

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i : arr1){
			if(map.containsKey(i)){
				map.put(i, map.get(i)+1);
			}else{
				map.put(i, 1);
			}
		}

        for(int j: arr2){
            if(map.containsKey(j)){
                int value = map.get(j);
                if(value > 0){
                    System.out.println(j);
                    map.put(j, value-1);
                }
            }
        }
        
    }
    
    public static int PairSum(int[] arr, int size) {
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i: arr){
            if(map.containsKey(i)){
                map.put(i, map.get(i)+1);
            }else{
                map.put(i,1);
            }
        }

        for(int i=0; i<arr.length; i++){
            if(map.containsKey(-arr[i]) && arr[i] !=0){
                count += map.get(arr[i]) * map.get(-arr[i]);
                map.put(arr[i], 0);
                map.put(-arr[i], 0);
            }
        }

        if(map.containsKey(0)){
            int temp = map.get(0);
            count +=  (temp * (temp-1)) / 2;
        }
        return count;
    }
    
    public static String uniqueChar(String str){
        HashMap<Character, Integer> map = new HashMap<>();
        String output = "";
        
        for(int i=0; i<str.length(); i++){
           char ch = str.charAt(i);
           if(map.containsKey(ch)){
                map.put(ch, map.get(ch)+1);
           }else{
                map.put(ch, 1);
                output += ch;
           }
        }
        return output;
    }
    
    public static ArrayList<Integer> longestConsecutiveIncreasingSequence(int[] arr) {
        ArrayList<Integer> output = new ArrayList<>();
        HashMap<Integer, Boolean> map = new HashMap<>();

        for(int i: arr){
            map.put(i, true);
        }

        for(int i: arr){
            if(map.containsKey(i-1)){
                map.put(i, false);
            }
        }

        int maxLen = 0;
        int msp = 0;

        for(int i: arr){
            int tempLen = 1;
            int tempVal = i;
            while(map.containsKey(tempVal+tempLen)){
                tempLen++;
            }

            if(tempLen > maxLen){
               maxLen = tempLen;
               msp = tempVal;
            }
        }

        output.add(msp);
        output.add(msp+ maxLen-1);
        return output;

  
    }
    
    public static int getPairsWithDifferenceK(int arr[], int k) {
        int count  = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i: arr){
           if(map.containsKey(i)){
            map.put(i, map.get(i)+1);
           }else{
            map.put(i, 1);
           }
        }
        for (int num : map.keySet()) {
            if (k == 0) {
                int freq = map.get(num);
                // Count unique pairs of duplicates:
                count += freq * (freq - 1) / 2;
            }else {
                int temp = num + k;
                if (map.containsKey(temp)) {
                    count += map.get(num) * map.get(temp);
                }
            }
        }
           
        return count;
            
        
    }
    public static void main(String[] args) {
        // HashMap<String, Integer> map = new HashMap<>();

        // map.put("abc",1);
        // map.put("def", 3);
        // System.out.println(map.containsKey("abc1"));
        // System.out.println(map.get("def"));

        // int a[] = {1,3,2,4,1,2,2,10000,3,2};
        // ArrayList<Integer> arr = removeDuplicates(a);
        // for(int i: arr){
        //     System.out.println(i);
        // }

        Map<String, Integer> map = new Map<>();
        for(int i=0; i<20; i++){
            map.insert("abc"+i, 1+i); 
            System.out.println("i=" + i + " lf=" + map.loadFactor());
        }

        map.removeKey("abc3");
        map.removeKey("abc7");

        for(int i=0; i<20; i++){
            System.out.println("abc" + i + ":" + map.getValue("abc" + i));
        }
    }
}
