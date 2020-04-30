package DownloadDemo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();//表示有几组数据
        for (int i = 0; i < n; i++) {
            int m=sc.nextInt();//表示这组数据有几次操作
            Queue<Integer> que=new LinkedList<>();
            for (int j = 0; j < m+1; j++) {
                String s=sc.nextLine();
                s=s.toUpperCase();
                if(s.contains("PUSH")){
                    s=s.substring(4);
                    int anInt = Integer.parseInt(s.trim());
                    que.offer(anInt);
                }
                if(s.contains("TOP")){
                    if(!que.isEmpty()){
                        System.out.println(que.peek());
                    }
                    else{
                        System.out.println(-1);
                    }
                }
                if(s.contains("POP")){
                    if(!que.isEmpty()){
                        que.poll();
                    }
                    else{
                        System.out.println(-1);
                    }
                }
                if(s.contains("SIZE")){
                    System.out.println(que.size());
                }
                if(s.contains("ClEAR")){
                    que.clear();
                }
            }
        }
    }
}
