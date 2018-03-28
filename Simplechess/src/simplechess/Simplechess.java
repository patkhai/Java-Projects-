/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplechess;
import java.util.Scanner;

/**
 *
 * @author patkhai
 */
public class Simplechess {

    /**
     * @param chessBoard
     */
    public static void printboard(String [][] chessBoard){ //different methods for chessboard
         System.out.println(" ");
        for(int row = 0; row < chessBoard.length;row++){ //printing out the chessboard outline
            System.out.print("|\t ");
            for(int column = 0; column < chessBoard[row].length; column++){
                System.out.print( chessBoard[row][column] + " \t| ");
            }
            System.out.println("\n");
       
        }
    }
    
     public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[][] chessBoard; //creating an array
        chessBoard = new String[8][8]; //assigning the array
        chessBoard[0][0] = "R";
        chessBoard[0][1] = "N";
        chessBoard[0][2] = "B";
        chessBoard[0][3] = "Q";
        chessBoard[0][4] = "K";
        chessBoard[0][5] = "B";
        chessBoard[0][6] = "N";
        chessBoard[0][7] = "R";
        chessBoard[7][0] = "r";
        chessBoard[7][1] = "n";
        chessBoard[7][2] = "b";
        chessBoard[7][3] = "q";
        chessBoard[7][4] = "k";
        chessBoard[7][5] = "b";
        chessBoard[7][6] = "n";
        chessBoard[7][7] = "r";                
        
     String [] pieceorder = {"rook", "knight","bishop", "king","queen","bishop","knight","rook"};

     int [] pieceordernumbers = {0,1,2,3,4,5,6,7};
     for(int i = 0; i<8; i++) { //inputing the loops
    for (int j =0; j<8; j++) {
    
    if (i>1 & i<6) {
    chessBoard [i][j] = "empty";}

    if (i == 0) {

    chessBoard [i][j] = "white " + pieceorder [j];

}
    if (i==7) {

    chessBoard [i][j]= "black " + pieceorder [j];

}      if (i==1){

    chessBoard [i][j] = "white pawn"; }

       if (i==6){

    chessBoard [i][j] = "black pawn"; }
    }
      
        
        String board; //prompting the user the input a colo
                do {
                    System.out.print("Choose the color black or white: ");

                   board = input.next();

                    }while(!(board.contentEquals("white") || board.contentEquals("black")));
            String ReadyToPlay; //showing game is ready 
            System.out.println("Game is ready to play"); 
             if ("black".equals(board)) { //Display the current status and the color that use is playing
                System.out.println("You are currently black"); 
                }
                 if ("white".equals(board)) {
                System.out.println("You are currently white"); }

        printboard(chessBoard); //printing the chess board
        System.out.print("Input your moves-> rows,column (eg: 0 1) : "); //asking the user to choose the moves
        int location_rows = input.nextInt(); //ask the user to choose the current location of the piece
        int location_column = input.nextInt();
        
       
         System.out.print("choose the desired destination of pieces rows,column (eg: 1 0): "); //
        int desired_column = input.nextInt();//ask the user to choose the desired location of the piece
        int desired_rows = input.nextInt();
             
            if(location_column >= 0 & location_column <8) { //check for valid index
            if(location_rows>= 0 & location_rows <8) 
            if(desired_column >= 0 & desired_column<8)

            if (desired_rows >=0 & desired_rows <8)

            System.out.println("location and desired destination are valid");
        }else{
         
            System.out.println("location and desired destination are not valid");        
            }
            //check whether current location is empty
         if(location_column <2 || location_column >5){ 
        if (location_rows <2 || location_rows >5)
        System.out.println("location is valid");
        }
        else {
        System.out.println("choose different moves");   

        }
        if (desired_column >1 & desired_column <6){

        if (desired_rows >1 & desired_rows <6)

        System.out.println("desired destination is empty");   

        }

        else {

        System.out.println("desired destination is occupied");

        }
        // Switch the color that user will now make a new move for

        System.out.print("choose the color black or white : ");
        
        if ("black".equals(board)) {
        System.out.println("You are currently black"); 
        }
        if ("white".equals(board)) {
        System.out.println("You are currently white"); }
        
       
        printboard(chessBoard);
        
     
     
     

     }    


     

     
}  

     
    
     
     
     
     
     
    
     
     
     
     
}


    
}
