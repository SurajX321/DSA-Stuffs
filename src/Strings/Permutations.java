package Strings;

import java.util.ArrayList;

public class Permutations {
    public static void main(String[] args) {
        System.out.println(permutationsCount("","abc"));
//          ArrayList<String> Ans=permutationsarr("","abc");
//        System.out.println(Ans);

    }
    static void permutations(String p, String up){
        if (up.isEmpty()){
            System.out.println(p);
            return;
        }
        char ch= up.charAt(0);

        for (int i = 0; i <=p.length(); i++) {
            String first= p.substring(0,i);
            String second= p.substring(i,p.length());
            permutations(first+ch+second,up.substring(1));
        }
    }
    static ArrayList<String> permutationsarr(String p, String up){
        if (up.isEmpty()){
            ArrayList<String> list=new ArrayList<>();
            list.add(p);
            return list;
        }
        char ch= up.charAt(0);

        ArrayList<String> ans= new ArrayList<>();

        for (int i = 0; i <=p.length(); i++) {
            String first= p.substring(0,i);
            String second= p.substring(i,p.length());
            ans.addAll(permutationsarr(first+ch+second,up.substring(1)));
        }
        return ans;
    }
    static int permutationsCount(String p, String up){
        if (up.isEmpty()){
            return 1;
        }
        char ch= up.charAt(0);
        int count=0;

        for (int i = 0; i <=p.length(); i++) {
            String first= p.substring(0,i);
            String second= p.substring(i,p.length());
            count=count + permutationsCount(first+ch+second,up.substring(1));
        }
        return count;
    }

}
