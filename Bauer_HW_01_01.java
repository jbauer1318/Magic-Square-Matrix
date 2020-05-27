import java.util.*;
public class Bauer_HW_01_01{
	
	
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in); 
    menu(input);
  }
    public static void menu(Scanner input) {
      int option;
      menu();
      option = getInt(input);
 
      while (option != 0) {
      
        System.out.println();
        System.out.println("Enter the size of the square matrices");
        int size = getInt(input);
        System.out.println();
        int[][] matrix1 = new int[size][size];
        int[][] matrix2 = new int[size][size];
        int[][] sum = new int[size][size];
        int[][] difference = new int[size][size];
        int[][] product = new int[size][size];
        
        if (option == 1) {
          
          randomizeMatrix(matrix1);
          randomizeMatrix(matrix2);
          
          System.out.println("First matrix is: ");
          printMatrix(matrix1);
          System.out.println("Second matrix is: ");
          printMatrix(matrix2);
          
          sum = addMatrix(matrix1,matrix2);
          
          System.out.println("The resulting matrix is:");
          for (int row = 0; row < sum.length; row++) {
            for (int col = 0; col < sum.length; col++) {
              System.out.printf(sum[row][col] + "    ");
            }
            System.out.println();
          }
          System.out.println("                Command number 1 completed.");
        }
          
        if (option == 2) {
         
          randomizeMatrix(matrix1);
          randomizeMatrix(matrix2);
          
          System.out.println("First matrix is: ");
          printMatrix(matrix1);
          System.out.println("Second matrix is: ");
          printMatrix(matrix2);
          
          System.out.println("The resulting matrix is:");
          difference = subtractMatrix(matrix1, matrix2);
          printMatrix(difference);
          
          System.out.println("                Command number 2 completed.");
        }
        
        if (option == 3) {
         
          randomizeMatrix(matrix1);
          randomizeMatrix(matrix2);
          
          System.out.println("First matrix is: ");
          printMatrix(matrix1);
          System.out.println("Second matrix is: ");
          printMatrix(matrix2);
         
          System.out.println("The resulting matrix is:");
          product = multiplyMatrix(matrix1, matrix2);
          printMatrix(product);
          
          System.out.println("                Command number 3 completed.");
        }
        
        if (option == 4) {
          
          randomizeMatrix(matrix1);
          randomizeMatrix(matrix2);
          
          System.out.println("Enter the multiplication constant");
          int constant = getInt(input);
          System.out.println();
          
          System.out.println("The matrix is:");
          printMatrix(matrix1);
          System.out.println();
          
          System.out.println("The original matrix multiplied by " + constant +  " is:");
          product = multiplyMatrixConstant(matrix1, constant);
          printMatrix(product);
          
          System.out.println("                Command number 4 completed.");
        }
        
        if (option == 5) {
          
          randomizeMatrix(matrix1);
          System.out.println("First matrix is: ");
          printMatrix(matrix1);
          
          System.out.println("The transposed matrix is: ");
          sum = transposeMatrix(matrix1);
          printMatrix(sum);
          
          System.out.println("                Command number 5 completed.");
        }
          
        if(option == 6) {
          randomizeMatrix(matrix1);
          System.out.println("The matrix is: ");
          printMatrix(matrix1);
          int trace = traceMatrix(matrix1);
          System.out.println("The trace for this matrix is : "+ trace);
            
          System.out.println("                Command number 6 completed.");
        }
        System.out.println();
        menu();
        option = getInt(input);
        }
      System.out.println("Testing completed.");
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
    
    public static void randomizeMatrix(int[][] matrix) {
      Random rng = new Random();
      int range = rng.nextInt(10) + 1;
      
      for (int row = 0; row < matrix.length; row++) {
        for (int col = 0; col < matrix.length; col++) {
          matrix[row][col] = rng.nextInt(range) + 1;
        }
      }
    }
    
    public static void printMatrix(int[][] matrix) {
      for (int row = 0; row < matrix.length; row++) {
        for (int col = 0; col < matrix.length; col++) {
          System.out.print(matrix[row][col] + "  ");
        }
        System.out.println();
      }
    }
    
    
    public static int[][] addMatrix(int[][] a, int[][] b)
    {
     int[][] sum = new int[a.length][a.length];
     for (int row = 0; row < sum.length; row++) {
            for(int col = 0; col < sum.length; col++) {
              sum[row][col] = a[row][col] + b[row][col];
            }
          }
     return sum;
    }
    
    
    public static int[][] subtractMatrix(int[][] a, int[][] b)
    {
     int[][] diff = new int[a.length][a.length];
     for (int row = 0; row < diff.length; row++) {
            for(int col = 0; col < diff.length; col++) {
              diff[row][col] = a[row][col] - b[row][col];
            }
          }
     return diff;
    }
    
    public static int[][] transposeMatrix(int[][] a) {
     int[][] sum = new int[a.length][a.length];
     for (int row = 0; row < sum.length; row++) {
            for(int col = 0; col < sum.length; col++) {
              sum[col][row] = a[row][col];
            }
          }
     return sum;
    }
    
    public static int[][] multiplyMatrix(int[][] a,int[][] b) {
     int[][] sum = new int[a.length][a.length];
     for (int row = 0; row < sum.length; row++) {
            for(int col = 0; col < sum.length; col++) {
              for (int k = 0; k < sum.length; k++)
                    sum[row][col] += a[row][k] * b[k][col];
            }
     }
     return sum;
    }
    
    public static int[][] multiplyMatrixConstant(int[][] a, int constant) {
      int[][] product = new int[a.length][a.length];
      for (int row = 0; row < product.length; row++) {
        for (int col = 0; col < product.length; col++) {
          for (int i = 0; i < product.length; i++) {
            product[row][col] = a[row][col] * constant;
          }
        }
      }
      return product;
    }
    
    public static int traceMatrix(int[][] a) {
      int sum = 0;
      for(int row = 0; row < a.length; row++) {
        for(int col = 0; col < a.length; col++) {
          if(row == col) {
           sum += a[row][col];
         }
       }
     }
     return sum;
    }
    
    public static void menu() {
      System.out.println("Your options are: ");
         System.out.println("-------------------");
         System.out.println("1) Add 2 matrices");
         System.out.println("2) Subtract 2 matrices");
         System.out.println("3) Multiply 2 matrices");
         System.out.println("4) Multiply matrix by a constant");
         System.out.println("5) Transpose matrix");
         System.out.println("6) Matrix trace");
         System.out.println("0) EXIT");
         System.out.println("Please enter your option: ");
    }
    
}
      
                                                  