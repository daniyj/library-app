package com.group.libraryapp.z_self_study.Day5;

import java.util.Scanner;
public class DiceGame {
    private static final int DICE_SIZE = 6;
    private final int[] results = new int[DICE_SIZE];

    public void startGame(){
        int playNumber = getPlayNumber(); //사용자 입력받기
        playDice(playNumber); // 게임 플레이
        new PrintGameInfo().printResults(results); // 결과 출력
    }
    private int getPlayNumber(){
        new PrintGameInfo().printStartInfo();
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private void playDice(int playNumber){
        for (int i = 0; i < playNumber; i++) {
            int result = (int) (Math.random() * DICE_SIZE);
            results[result]++;
        }
    }

}
