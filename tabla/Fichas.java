package tabla;

public class Fichas {
  
  public static String[][] PartidaNormal (String tablero[][]) {
    
    final String VACIO = " ";
    final String peonN = "♙";
    final String torreN = "♖";
    final String alfilN = "♗";
    final String caballoN = "♘";
    final String reinaN = "♕";
    final String reyN = "♔";
    final String peonB = "♟";
    final String torreB = "♜";
    final String alfilB = "♝";
    final String caballoB = "♞";
    final String reinaB = "♛";
    final String reyB = "♚";
    final String bordes = ".";
    
    int y;
    int x;
    
    //Inicializamos el array//
    for (y = 0; y < 10; y++) {
      for (x = 0; x < 10; x++) {
        
        //Inicializamos los bordes//
        if ((y == 0) || (y == 9)) {
        
          tablero[y][x] = bordes;
          
        }
        
        else if ((x == 0) || (x == 9)) {
        
          tablero[y][x] = bordes;
          
        }
        
        //Inicializamos las blancas//
        else if ((y == 1) && ((x == 1) ||(x == 8))) {
        
          tablero[y][x] = torreB ;
          
        }
        
        else if ((y == 1) && ((x == 2) || (x == 7))) {
        
          tablero[y][x] = caballoB ;
          
        }
        
        else if ((y == 1) && ((x == 3) || (x == 6))) {
        
          tablero[y][x] = alfilB ;
          
        }
        
        else if ((y == 1) && (x == 4)) {
        
          tablero[y][x] = reinaB ;
          
        }
        
        else if ((y == 1) && (x == 5)) {
        
          tablero[y][x] = reyB ;
          
        }
        
        else if (y == 2) {
        
          tablero[y][x] = peonB ;
          
        }
        
        //Inicializamos las negras//
        else if ((y == 8) && ((x == 1) || (x == 8))) {
        
        tablero[y][x] = torreN;
        
        }
        
        else if ((y == 8) && ((x == 2) || (x == 7))) {
        
          tablero[y][x] = caballoN;
          
        }
        
        else if ((y == 8) && ((x == 3) || (x == 6))) {
        
          tablero[y][x] = alfilN;
          
        }
        
        else if ((y == 8) && (x == 4)) {
        
          tablero[y][x] = reinaN;
          
        }
        
        else if ((y == 8) && (x == 5)) {
        
          tablero[y][x] = reyN;
          
        }
        
        else if (y == 7) {
        
          tablero[y][x] = peonN;
          
        }
        
        //Inicializamos los huecos//
        
        else {
          
          tablero[y][x] = VACIO;
          
        }
      }      
    }
    return tablero;
  }
  
  public static String[][] InicializarVACIO (String tablero[][]) {
    
    final String VACIO = " ";
    final String peonN = "♙";
    final String torreN = "♖";
    final String alfilN = "♗";
    final String caballoN = "♘";
    final String reinaN = "♕";
    final String reyN = "♔";
    final String peonB = "♟";
    final String torreB = "♜";
    final String alfilB = "♝";
    final String caballoB = "♞";
    final String reinaB = "♛";
    final String reyB = "♚";
    final String bordes = ".";
    
    int y;
    int x;
    
    for (y = 0; y < 10; y++) {
      
      for (x = 0;x < 10; x++) {
        
        if ((y == 0) || (y == 9)) {
        
          tablero[y][x] = bordes;
          
        }
        
        else if ((x == 0) || (x == 9)) {
        
          tablero[y][x] = bordes;
          
        }
        
        else {
          
          tablero[y][x] = VACIO;
        
        }
      }
    }
        
    return tablero;
  }
}
