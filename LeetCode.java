/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;
import java.util.*;

/**
 *
 * @author christopherii
 */
public class LeetCode {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//        twoSum(new int[] {2,7,11,15}, 9);
//        twoSum(new int[] {3,2,4}, 6);
//        int x = lengthOfLongestSubstring("");
//        System.out.println(x);
        System.out.println(romanToInt("ID"));
    }
    
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> result = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            if (result.size() >= 2) 
                break;
            
            for (int j = i; j < nums.length; j++) {
                if (result.size() >= 2) 
                    break;
                
                if (nums[i] + nums[j] == target) {
                    System.out.println(nums[i] + " " + nums[j]);
                    System.out.println(i + " " + j);
                    result.put(i, nums[i]);
                    result.put(j, nums[j]);
                    break;
                }
                    
            }
        }
        
        int[] container = new int[result.size()];
        int index = 0;
        for (int key: result.keySet()) {
            System.out.println(key);
            container[index++] = key;
        }
        
        return container;
    }
    
    public static int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) return 0;
        
        HashSet<Character> set = new HashSet();
        int explorer = 0;
        int starting = 0;
        int max = 0;
        
        while (explorer < s.length()) {
            if (!set.contains(s.charAt(explorer))) {
                set.add(s.charAt(explorer));
                explorer++;
                max = Math.max(max, set.size());
            } else {
                set.remove(s.charAt(starting++));
            }
        }
        
        return max;
    }
    
    public static boolean isPalindrome(int x) {
        StringBuilder builder = new StringBuilder(Integer.toString(x));
        System.out.println(Integer.toString(x) + " " + builder.reverse().toString());
        return builder.reverse().toString().equals(Integer.toString(x));
    }
    
    public static int romanToInt(String s) {
        if (s.trim().isEmpty()) return 0;
        
        Hashtable<Character, Integer> table = romanTable();
        
        int total = 0;
        int previous = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            int value = table.get(s.charAt(i));
            if (previous == 0)
                previous = value;
            
            if (value < previous) {
                total -= value;
                previous = 0;
            } else {
                total += value;
                previous = value;
            }

        }
        return total;
    }
    
    public static Hashtable<Character, Integer> romanTable() {
        Hashtable<Character, Integer> table = new Hashtable();
        table.put('I', 1);
        table.put('V', 5);
        table.put('X', 10);
        table.put('L', 50);
        table.put('C', 100);
        table.put('D', 500);
        table.put('M', 1000);
        
        return table;
    }
}
