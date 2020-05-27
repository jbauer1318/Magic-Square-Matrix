import java.util.*;
public class Bauer_HW_01_02 {
	
  public static void main(String[] args) {
	  
    Scanner input = new Scanner(System.in);
    char select;
    int size;
    
    do {
      System.out.print("Enter the size of magic square (positive & odd): ");
      size = getInt(input);
    
      while (size % 2 == 0 || size < 0) {
        System.out.println("INPUT ERROR!!! Invalid size.");
        System.out.print("Enter the size of magic square (positive & odd): ");
        size = getInt(input);
      }
    
      int[][] magicSquare = new int[size][size];
      System.out.println("The magic square with size = " + size + " is");
    
      build(magicSquare, size);
    
      System.out.println("Do you want to continue? Y/N: ");
      select = input.next().charAt(0);
    } while (select == 'Y' || select == 'y');
    
  }
    
  public static int getInt(Scanner input) {
    int num;
    while (!input.hasNextInt()) {
      System.out.print("Not an integer! Try again! ");
      input.next();
    }
    num = input.nextInt();
    return num;
  }
    
  public static void build(int[][] magicSquare, int size) {
    int row = 0;
    int col = size / 2 ;
    int temprow, tempcol;
    magicSquare[row][col] = 1;
    
    for (int k = 2; k <= size*size; k++) {
       
      temprow = row;
      tempcol = col;
      row--;
      col++;
      
      if ( row < 0 ) row = size - 1;
      col = col % size;
      
      if ( magicSquare[row][col] == 0 ) {
        magicSquare[row][col] = k;
      } 
      else 
      {
        row = temprow;
        col = tempcol;
        row++;
        row = row % size;
        magicSquare[row][col] = k; 
        
        
      }
      
    }
  
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        if (magicSquare[i][j] < 10) {
          System.out.print(" ");
        }
        if (magicSquare[i][j] < 100) {
          System.out.print(" ");
        }
        System.out.print(magicSquare[i][j] + " ");
      }
      System.out.println();
    }
  
    int sum = size * ((size*size + 1)/2);
    System.out.println("The " + size + "x" + size + " magic square adds up to " + sum);
  }
}