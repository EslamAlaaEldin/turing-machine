/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project2;

import java.util.Scanner;

/**
 *
 * @author Eslam
 */
public class turingMachine {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("please enter number of state");
        int numState =sc.nextInt();
          System.out.println("please enter number of alphabet");
        int numAlphabet =sc.nextInt();
        System.out.println("please enter states ");
        String[] states =new String[numState];
        for (int i = 0; i < numState; i++) {
        states [i]=sc.next();
        
        }

        System.out.println("please enter alphabets ");
        String[] alphabets=new String[numAlphabet];
        for (int i = 0; i < numAlphabet; i++) {
            alphabets[i] =sc.next();
            
        }
        String[][] transitionFunction =new String[numState*numAlphabet][5];
        for (int i = 0; i < numState*numAlphabet; i++) {
            System.out.println("please enter the transition "+(i+1)+" ");
            String tempalaryTrasition =sc.next();
            String[] tempalaryTransitionSplit =tempalaryTrasition.split("-");
            for (int j = 0; j < 5; j++) {
                transitionFunction[i][j] =tempalaryTransitionSplit[j];
                
            }
            System.out.println(" ");
        }
                
                System.out.println("please enter the initial state ");
            String initialState =sc.next();

                System.out.println("please enter the initial head psition ");
                int initialHead =sc.nextInt();
                
                 System.out.println("please enter your input string ");
                 String inputString =sc.next();
                 char[] tape =new char[inputString.length()];
                 for (int i = 0; i < inputString.length(); i++) {
                    tape[i] =inputString.charAt(i);
                }
                 
                 String currentState =transitionFunction[0][0];
                 int headPosition =initialHead;
                  while(true){
                      int indexOfState =getIndex(states ,currentState);
                      String nextState ="";
                      char newSymbol =0;
                      char Action =0;
                      for (int i = 0; i < numAlphabet; i++) {
                          if(String.valueOf(tape[headPosition]).equals(transitionFunction[(indexOfState*numAlphabet) + i ][1])){
                               nextState =transitionFunction[(indexOfState*numAlphabet)+i][2];
                               newSymbol =transitionFunction[(indexOfState*numAlphabet)+i][3].charAt(0);
                               Action =transitionFunction[(indexOfState*numAlphabet)+i][4].charAt(0);
                               break;
                      
                          }
                      }
                          
                      tape[headPosition] =newSymbol;
                      if(Action == 'R' || Action =='r'){
                          if(headPosition ==tape.length-1){
                              char[] newTape =new char[tape.length+1];
                              for (int i = 0; i < tape.length; i++) {
                                  newTape[i] =tape[i];
                                  
                              }
                              newTape[newTape.length-1]='#';
                              tape=newTape;
                          }
                          headPosition++;
                      }
                      
                      else if(Action == 'L' || Action =='l'){
                          headPosition--;
                      }
                      if(Action == 'Y'|| Action == 'y'){
                          System.out.println("Accepted");
                          System.out.println(new String(tape));
                          System.out.println("the head position is: "+headPosition);
                          break;
                      }
                      else if(Action == 'N' || Action == 'n'){
                          System.out.println("Rejected");
                           System.out.println(new String(tape));
                          System.out.println("the head position is: "+headPosition);
                          break;
                      }
                      currentState =nextState;
                          
                  }
                  
    }
    private static int getIndex(String[] arr ,String x){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i].equals(x)){
                return i;
            } 
        }
        return -1;
    }
            
}
