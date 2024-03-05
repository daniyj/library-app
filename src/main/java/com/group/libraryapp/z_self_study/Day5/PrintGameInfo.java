package com.group.libraryapp.z_self_study.Day5;

public class PrintGameInfo {
    public void printStartInfo(){
        System. out.print("주사위를 던질 횟수를 입력하세요 : ");
    }
    public void printResults(int[] results){
        for (int i = 0; i < 6; i++) {
            System.out.printf("%d는 %d번 나왔습니다. \n",(i+1),results[i]);
        }
    }
}
