package movimientos;
import java.util.Scanner;

public class MovimientosN {
  
  public static boolean MovimientoTorre (String tablero[][], int fila, int columna,int filaObjetivo,int columnaObjetivo) {
   
   String VACIO = " ";
   int x;
   int y;
    
    //comprobamos si se puede hacer el movimiento en el eje x//
    if (fila == filaObjetivo) {
      
      //mover hacia la derecha//
      if (columna < columnaObjetivo) {
      
        for (x = columna + 1; (x < columnaObjetivo); x++) {
          
          if (tablero[fila][x] != VACIO) {

            return false;
            
          }            
        }  
      } 
      
      //mover hacia la izquierda//
      else {
        
        for (x = columna - 1; (x > columnaObjetivo); x--) {
          
          if (tablero[fila][x] != VACIO) {

            return false;
            
          }            
        }
      }         
    }
    
    //comprobamos si se puede hacer el movimiento en el eje y//
    else if (columna == columnaObjetivo) {
      
      //mover hacia arriba//
      if (fila < filaObjetivo) {
        
        for (y = fila + 1; (y < filaObjetivo); y++) {
          
          if (tablero[y][columna] != VACIO) {

            return false;
          }            
        }
      }
      
      //mover hacia abajo//
      else {
       
       for (y = fila - 1; (y > filaObjetivo); y--) {
          
          if (tablero[y][columna] != VACIO) {

            return false;
          }            
        }
        
      }
    }
    
    else if ((columnaObjetivo != columna) && (filaObjetivo != fila)) { 

      return false;
      
    }
    
    return true;
     
  }
  
  
  
  
  public static boolean EnroqueD (String tablero[][], int fila, int columna,int filaObjetivo,int columnaObjetivo, int movReyN, int movTorreDN) {
    
    final String VACIO = " ";
    final String reyN = "♔";
    final String torreN = "♖";
    
    int y;
    int x;
    
    if ((filaObjetivo == 8) && (columnaObjetivo == 7) && (tablero[fila][columna] == reyN) && (tablero[8][8] == torreN)) {
      
      if ((movReyN == 0) && (movTorreDN == 0)) {
      
        for (x = columna + 1; x < 8; x++) {
      
          if (tablero[fila][x] != VACIO) {
          
            return false;
          }   
        }
        return true;
      }  
    }
    return false;
  }
    
  public static boolean EnroqueI (String tablero[][], int fila, int columna,int filaObjetivo,int columnaObjetivo, int movReyN, int movTorreIN) {
    
    final String VACIO = " ";
    final String reyN = "♔";
    final String torreN = "♖";
    
    int y;
    int x;
    
    if ((filaObjetivo == 8) && (columnaObjetivo == 3) && (tablero[fila][columna] == reyN) && (tablero[8][1] == torreN)) {
      
      if ((movReyN == 0) && (movTorreIN == 0)) {
      
        for (x = columna - 1; x > 1; x--) {
      
          if (tablero[fila][x] != VACIO) {
          
            return false;
          }   
        }
        return true;        
      }  
    }
    return false;
  }
  
  
  
  
  public static boolean MovimientoPeon (String tablero[][], int fila, int columna,int filaObjetivo,int columnaObjetivo) {
    Scanner s = new Scanner(System.in);
    
    
    final String VACIO = " ";
    final String peonB = "♟";
    final String torreB = "♜";
    final String alfilB = "♝";
    final String caballoB = "♞";
    final String reinaB = "♛";
    final String reyB = "♚";
    int x;
    int y;
    String seleccion = "";
    
    //comprobamos si se puede mover dos veces//
    if (fila == 7){
      
      if ((filaObjetivo-fila >= -2) && (filaObjetivo-fila <= -1) && (columnaObjetivo == columna) 
      
      && (tablero[filaObjetivo][columnaObjetivo] == VACIO) && (tablero[fila - 1][columna] == VACIO)) {
        
        return true;
        
      }   
    }
    
    //comprobamos si se puede comer a un enemigo
     if ((filaObjetivo == fila - 1) && ((columnaObjetivo == columna + 1) || (columnaObjetivo == columna - 1))
    
        && ((tablero[filaObjetivo][columnaObjetivo] == peonB) || (tablero[filaObjetivo][columnaObjetivo] == torreB) 
        
        || (tablero[filaObjetivo][columnaObjetivo] == alfilB) || (tablero[filaObjetivo][columnaObjetivo] == reinaB) 
        
        || (tablero[filaObjetivo][columnaObjetivo] == caballoB))) {
      
      return true;
    }
    
    //comprobamos si se puede hacer el moviemiento 
    else if ((filaObjetivo - fila == -1) && (columnaObjetivo == columna) && tablero[filaObjetivo][columnaObjetivo] == VACIO) {
      
      return true;
      
    }

    return false;
  }
  
  
  
  public static boolean CapturaEnMovimientoPeon (String tablero[][], int fila, int columna,int filaObjetivo,int columnaObjetivo,int posFiB, int posCoB, int objFiB, int objCoB) {
    
    final String peonB = "♟";
    
    //comprobamos si se puede comer a un enemigo en movimiento//
    if ((filaObjetivo == fila - 1) && (columnaObjetivo == objCoB) && (posFiB == 2) 
    
    && (fila == 4) && (tablero[objFiB][objCoB] == peonB) && (objFiB == fila)) {
      
      return true;
      
    }   
    return false;
  }
  
  
  
  
  public static String ConversionPeon (String tablero[][], int filaObjetivo, int columnaObjetivo) { 
    Scanner s = new Scanner(System.in);
    
    final String torreN = "♖";
    final String alfilN = "♗";
    final String caballoN = "♘";
    final String reinaN = "♕";
    
    String seleccion = "";
    boolean fichaElegida = false;
    
    do {  
      
      System.out.print("\nEn que desea convertir su peon, en TORRE, CABALLO, ALFIL o DAMA: ");
      seleccion = s.nextLine();
      
      if (seleccion.toLowerCase().equals("dama")) {
    
        tablero[filaObjetivo][columnaObjetivo] = reinaN;
        return reinaN;
      }
      
      else if (seleccion.toLowerCase().equals("alfil")) {
    
        tablero[filaObjetivo][columnaObjetivo] = alfilN;
        return alfilN;
      }
      
      else if (seleccion.toLowerCase().equals("torre")) {
    
        tablero[filaObjetivo][columnaObjetivo] = torreN;
        return torreN;
      }
      
      else if (seleccion.toLowerCase().equals("caballo")) {
    
        tablero[filaObjetivo][columnaObjetivo] = caballoN;
        return caballoN;   
        
      }
      
      System.out.print("Ficha no valida.");
      
    } while (!fichaElegida);
 
    return "";
  }
  
  
  
  
  
  public static boolean MovimientoCaballo (String tablero[][], int fila, int columna,int filaObjetivo,int columnaObjetivo) {
   
    final String VACIO = " ";
    
    //Comprobamos si se puede mover donde indicado//
    if (((Math.abs(filaObjetivo - fila) ==  2) && (Math.abs(columnaObjetivo - columna) == 1)) 
    
    || ((Math.abs(columnaObjetivo - columna) == 2) && (Math.abs(filaObjetivo - fila) == 1))) {

      return true;
    
    }
    
    return false;
  }  
  
  
  
  
  public static boolean MovimientoAlfil (String tablero[][], int fila, int columna,int filaObjetivo,int columnaObjetivo) {
    
    final String VACIO = " ";

    int x;
    int y = fila;
    boolean up = false;
    boolean right = false;
    
    //Comprobamos si se puede mover donde indicado//
    if (Math.abs(filaObjetivo - fila) == Math.abs(columnaObjetivo - columna)) {
      
      if (Math.abs(filaObjetivo - fila) == (filaObjetivo - fila)) {
        
        up = true;
        
      }
      
      if (Math.abs(columnaObjetivo - columna) == (columnaObjetivo - columna)) {
        
        right = true;
        
      }
      
      //para movimientos diagonales arriba a la derecha//
      if ((up) && (right)) {
        
        for (x = columna + 1; (x < columnaObjetivo); x++) {
            
          y ++;
          
          if (tablero[y][x] != VACIO) {

            return false;
            
          }            
        }  
      }
      
      //para movimientos diagonales abajo a la derecha//
      else if ((!up) && (right)) {
        
        for (x = columna + 1; (x < columnaObjetivo); x++) {
            
          y --;
          
          if (tablero[y][x] != VACIO) {

            return false;
            
          }            
        }  
      }
            
      //para movimientos diagonales arriba a la izquierda//
      else if ((up) && (!right)) {
        
        for (x = columna - 1; (x > columnaObjetivo); x--) {
            
          y ++;
          
          if (tablero[y][x] != VACIO) {

            return false;
            
          }            
        }
      }  
      
      //para movimientos diagonales abajo a la izquierda//
      else if ((!up) && (!right)) {
        
        for (x = columna - 1; (x > columnaObjetivo); x--) {
            
          y --;
          
          if (tablero[y][x] != VACIO) {

            return false;
            
          }            
        }
      }  
    
      return true;
    
    }
    
    return false;
  }    
  
  
  
  
  public static boolean MovimientoReina (String tablero[][], int fila, int columna,int filaObjetivo,int columnaObjetivo) {
    
    final String VACIO = " ";

    int x;
    int y = fila;
    boolean up = false;
    boolean right = false;
    
    //Comprobamos si se puede mover donde indicado diagonalmente//
    if (Math.abs(filaObjetivo - fila) == Math.abs(columnaObjetivo - columna)) {
      
      if (Math.abs(filaObjetivo - fila) == (filaObjetivo - fila)) {
        
        up = true;
        
      }
      
      if (Math.abs(columnaObjetivo - columna) == (columnaObjetivo - columna)) {
        
        right = true;
        
      }
      
      //para movimientos diagonales arriba a la derecha//
      if ((up) && (right)) {
        
        for (x = columna + 1; (x < columnaObjetivo); x++) {
            
          y ++;
          
          if (tablero[y][x] != VACIO) {

            return false;
            
          }            
        }  
      }
      
      //para movimientos diagonales abajo a la derecha//
      else if ((!up) && (right)) {
        
        for (x = columna + 1; (x < columnaObjetivo); x++) {
            
          y --;
          
          if (tablero[y][x] != VACIO) {

            return false;
            
          }            
        }  
      }
      
      //para movimientos diagonales arriba a la izquierda//
      else if ((up) && (!right)) {
        
        for (x = columna - 1; (x > columnaObjetivo); x--) {
            
          y ++;
          
          if (tablero[y][x] != VACIO) {

            return false;
            
          }            
        }
      }  
      
      //para movimientos diagonales abajo a la izquierda//
      else if ((!up) && (!right)) {
        
        for (x = columna - 1; (x > columnaObjetivo); x--) {
            
          y --;
          
          if (tablero[y][x] != VACIO) {

            return false;
            
          }            
        }
      }  

      return true;
    
    }
    
    //comprobamos si el movimiento se puede hacer horizontalmente o verticalmente//
    else {
      
      //comprobamos si se puede hacer el movimiento en el eje x//
      if (fila == filaObjetivo) {
        
        //mover hacia la derecha//
        if (columna < columnaObjetivo) {
        
          for (x = columna + 1; (x < columnaObjetivo); x++) {
            
            if (tablero[fila][x] != VACIO) {

              return false;
              
            }            
          }  
        } 
        
        //mover hacia la izquierda//
        else {
          
          for (x = columna - 1; (x > columnaObjetivo); x--) {
            
            if (tablero[fila][x] != VACIO) {

              return false;
              
            }            
          }
        }         
      }
      
      //comprobamos si se puede hacer el movimiento en el eje y//
      else if (columna == columnaObjetivo) {
        
        //mover hacia arriba//
        if (fila < filaObjetivo) {
          
          for (y = fila + 1; (y < filaObjetivo); y++) {
            
            if (tablero[y][columna] != VACIO) {

              return false;
            }            
          }
        }
        
        //mover hacia abajo//
        else {
         
         for (y = fila - 1; (y > filaObjetivo); y--) {
            
            if (tablero[y][columna] != VACIO) {

              return false;
            }            
          }
          
        }
      }
      
      else if ((columnaObjetivo != columna) && (filaObjetivo != fila)) { 

        return false;
        
      }
    }

    return true;
  }       
  
  
  
  
  public static boolean MovimientoRey (String tablero[][], int fila, int columna,int filaObjetivo,int columnaObjetivo) {
    
    final String VACIO = " ";

    int x;
    int y;
    
    //Comprobamos si se puede mover donde indicado diagonalmente//
    if ((Math.abs(filaObjetivo - fila) == 1) && (Math.abs(columnaObjetivo - columna) == 1)) {
      
      return true;
      
    }
    
    //comprobamos si el movimiento se puede hacer horizontalmente o verticalmente//
    else {
      
      //comprobamos si se puede hacer el movimiento en el eje y//
      if ((Math.abs(filaObjetivo - fila) == 1) && (Math.abs(columnaObjetivo - columna) == 0)) {

        return true; 
        
      }
      
      //comprobamos si se puede hacer el movimiento en el eje x//
      if ((Math.abs(filaObjetivo - fila) == 0) && (Math.abs(columnaObjetivo - columna) == 1)) {
        
        return true; 
        
      }
    }

    return false;
  }         
  
  
  
  
  public static boolean JaqueAlRey (String tablero[][]) {
    
    final String VACIO = " ";
    final String peonB = "♟";
    final String torreB = "♜";
    final String alfilB = "♝";
    final String caballoB = "♞";
    final String reinaB = "♛";
    final String reyB = "♚";
    final String reyN = "♔";
    
    boolean up = false;
    boolean right = false;
    boolean valido = true;
    
    int fila = 0;
    int columna = 0;
    int x;
    int y;
    int j;
    int horizontal = 0;
    int vertical = 0;
    int diagonal = 0;
    
    //buscamos la posicion del rey//
    for(y = 1; y < 9; y++) {
      
      for (x = 1; x < 9; x++) {
          
        if (tablero[y][x] == reyN) {
          
          fila = y;
          columna = x;
        }          
      }
    }    
    //COMPROBAMOS SI SE LE ESTA HACIENDO JAQUE AL REY//
    
    //vemos si le haria jaque el rey enemigo//
    if ((tablero[fila][columna + 1] == reyB) || (tablero[fila][columna - 1] == reyB) || (tablero[fila + 1][columna] == reyB) || (tablero[fila - 1][columna] == reyB) 
    
    || (tablero[fila + 1][columna + 1] == reyB) || (tablero[fila - 1][columna + 1] == reyB) || (tablero[fila + 1][columna - 1] == reyB) || (tablero[fila - 1][columna - 1] == reyB)) {
      
      return true;
      
    }
   
    //contamos cuantas reinas o torres hay horizontalmente//
    for (x = 1; x < 9; x++) {
      
      if ((tablero[fila][x] == reinaB) || (tablero[fila][x] == torreB))  {
        
        horizontal ++;
        
      }
    }
       
    //comprobamos horizontalmente//
    for (x = 1; ((x < 9) && (horizontal != 0)); x++) {
      
      valido = true;      
          
      if (Math.abs(x - columna) == (x - columna)) {
            
            right = true;
            
      }
      
      else {
          
          right = false;
          
      }
    
      if ((tablero[fila][x] == reinaB) || (tablero[fila][x] == torreB))  {
          
        //jaque desde la derecha//
        if (right) {
        
          for (int i = columna + 1; ((i < x) && (valido)); i++) {
            
            if (tablero[fila][i] != VACIO) {
              
              valido = false;
              horizontal --;
              
            }
          }
        }           
            
        //jaque desde la izquierda//
        else {
        
          for (int i = columna - 1; ((i > x) && (valido)); i--) {
            
            if (tablero[fila][i] != VACIO) {
              
              valido = false;
              horizontal --;
              
            }            
          }
        }
        
        if (valido) {
          
          return true;
          
        }
      }
    }
    
    
    //contamos cuantas reinas o torres hay verticalmente//
    for (y = 1; y < 9; y++) {
      
      if ((tablero[y][columna] == reinaB) || (tablero[y][columna] == torreB))  {
        
        vertical ++;
        
      }
    }
    
    //comprobamos verticalmente// 
    for (y = 1; ((y < 9) && (vertical != 0)); y++) {
      
      valido = true;
      
      if ((tablero[y][columna] == reinaB) || (tablero[y][columna] == torreB))  {
        
        //jaque desde arriba//
        if (fila < y) {
          
          for (int i = fila + 1; ((i < y) && (valido)); i++) {
            
            if (tablero[i][columna] != VACIO) {
              
              valido = false;
              vertical --;          
            
            }            
          }
        }
    
        //jaque desde abajo//
        else {
         
          for (int i = fila - 1; ((i > y) && (valido)); i--) {
            
            if (tablero[i][columna] != VACIO) {
              
              valido = false;
              vertical --;
              
            }            
          }            
        }
        
        if (valido) {
          
          return true;
          
        }
      }
    }
  
    
    //contamos cuantas reinas o alfiles hay diagonalmente// 
    for (y = 1; y < 9; y++) {
        
      for (x = 1; x < 9; x++) {
          
         if (((Math.abs(y - fila)) == (Math.abs(x - columna))) && ((tablero[y][x] == reinaB) || (tablero[y][x] == alfilB))) {
           
           diagonal ++;
           
         }          
      }
    }
    
    //comprobamos diagonalmente//
    for (y = 1; ((y < 9) && (diagonal != 0)); y++) {

      for (x = 1; x < 9; x++) {
        
        valido = true;
       
        if (Math.abs(y - fila) == (y - fila)) {
      
          up = true;
      
        }
        
        else {
          
          up = false;
          
        } 
        
        if (Math.abs(x - columna) == (x - columna)) {
          
          right = true;
          
        }
        
        else {
          
          right = false;
          
        }
        
        if (((tablero[y][x] == reinaB) || (tablero[y][x] == alfilB)) && (Math.abs(y - fila) == Math.abs(x - columna))) {
        
          //desde arriba a la derecha//
          if ((up) && (right)) {
            
            j = fila;
            
            for (int i = columna + 1; ((i < x) && (valido)); i++) {
            
              j ++;
              
              if (tablero[j][i] != VACIO) {
                
                valido = false;
                diagonal --;
                
              }            
            }
          }
          
          //desde abajo a la derecha//
          else if ((!up) && (right)) {
            
            j = fila;
            
            for (int i = columna + 1; ((i < x) && (valido)); i++) {
            
              j--;
          
              if (tablero[j][i] != VACIO) {
                
                valido = false;
                diagonal --;
                
              }            
            }            
          }
          
          
          //desde abajo a la izquierda//
          else if ((!up) && (!right)) {
              
            j = fila;
              
            for (int i = columna - 1; ((i > x) && (valido)); i--) {
            
              j --;
              
              if (tablero[j][i] != VACIO) {
                
                valido = false;
                diagonal --;
                
              }
            }
          }            

          //desde arriba a la izquierda// 
          else if ((up) && (!right)) {  
             
            j = fila;
             
            for (int i = columna - 1; ((i > x) && (valido)); i--) {
            
              j ++;
                
              if (tablero[j][i] != VACIO) {
                  
                valido = false;
                diagonal --;
                  
              }            
            }
          }
          
          if (valido) {
          
          return true;
          
          }          
        }
      }
    }
    
    //para peones//
      if ((tablero[fila - 1][columna - 1] == peonB) || (tablero[fila - 1][columna + 1] == peonB)) {
        
        return true;
      
      }
    
    //para los caballos//
    for (y = 1; y < 9; y ++) {
      
      for (x = 1; x < 9; x++) {
        
        if ((((Math.abs(y - fila) ==  2) && (Math.abs(x - columna) == 1)) 
  
        || ((Math.abs(x - columna) == 2) && (Math.abs(y - fila) == 1))) && (tablero[y][x] == caballoB)) {
          
          return true;
          
        }
      }
    }

    return false;
  }
  
  public static int[] PosicionesEntreJaque (String tablero[][]) {
    
    final String VACIO = " ";
    final String peonB = "♟";
    final String torreB = "♜";
    final String alfilB = "♝";
    final String caballoB = "♞";
    final String reinaB = "♛";
    final String reyN = "♔";
    
    boolean up = false;
    boolean right = false;
    boolean valido = true;
    
    int fila = 0;
    int columna = 0;
    int x;
    int y;
    int j;
    int horizontal = 0;
    int vertical = 0;
    int diagonal = 0;
    int[] coordinadasJaque = new int[2];
    
    //buscamos la posicion del rey//
    for(y = 1; y < 9; y++) {
      
      for (x = 1; x < 9; x++) {
          
        if (tablero[y][x] == reyN) {
          
          fila = y;
          columna = x;
        }          
      }
    }    
    //COMPROBAMOS SI SE LE ESTA HACIENDO JAQUE AL REY//
   
    //contamos cuantas reinas o torres hay horizontalmente//
    for (x = 1; x < 9; x++) {
      
      if ((tablero[fila][x] == reinaB) || (tablero[fila][x] == torreB))  {
        
        horizontal ++;
        
      }
    }
       
    //comprobamos horizontalmente//
    for (x = 1; ((x < 9) && (horizontal != 0)); x++) {
      
      valido = true;      
          
      if (Math.abs(x - columna) == (x - columna)) {
            
            right = true;
            
      }
      
      else {
          
          right = false;
          
      }
    
      if ((tablero[fila][x] == reinaB) || (tablero[fila][x] == torreB))  {
          
        //jaque desde la derecha//
        if (right) {
        
          for (int i = columna + 1; ((i < x) && (valido)); i++) {
            
            if (tablero[fila][i] != VACIO) {
              
              valido = false;
              horizontal --;
              
            }
          }
        }           
            
        //jaque desde la izquierda//
        else {
        
          for (int i = columna - 1; ((i > x) && (valido)); i--) {
            
            if (tablero[fila][i] != VACIO) {
              
              valido = false;
              horizontal --;
              
            }            
          }
        }
        
        if (valido) {
          
          coordinadasJaque[0] = fila;
          coordinadasJaque[1] = x;
          return coordinadasJaque;
          
        }
      }
    }
    
    
    //contamos cuantas reinas o torres hay verticalmente//
    for (y = 1; y < 9; y++) {
      
      if ((tablero[y][columna] == reinaB) || (tablero[y][columna] == torreB))  {
        
        vertical ++;
        
      }
    }
    
    //comprobamos verticalmente// 
    for (y = 1; ((y < 9) && (vertical != 0)); y++) {
      
      valido = true;
      
      if ((tablero[y][columna] == reinaB) || (tablero[y][columna] == torreB))  {
        
        //jaque desde arriba//
        if (fila < y) {
          
          for (int i = fila + 1; ((i < y) && (valido)); i++) {
            
            if (tablero[i][columna] != VACIO) {
              
              valido = false;
              vertical --;          
            
            }            
          }
        }
    
        //jaque desde abajo//
        else {
         
          for (int i = fila - 1; ((i > y) && (valido)); i--) {
            
            if (tablero[i][columna] != VACIO) {
              
              valido = false;
              vertical --;
              
            }            
          }            
        }
        
        if (valido) {
          
          coordinadasJaque[0] = y;
          coordinadasJaque[1] = columna;
          return coordinadasJaque;
          
        }
      }
    }
  
    
    //contamos cuantas reinas o alfiles hay diagonalmente// 
    for (y = 1; y < 9; y++) {
        
      for (x = 1; x < 9; x++) {
          
         if (((Math.abs(y - fila)) == (Math.abs(x - columna))) && ((tablero[y][x] == reinaB) || (tablero[y][x] == alfilB))) {
           
           diagonal ++;
           
         }          
      }
    }
    
    //comprobamos diagonalmente//
    for (y = 1; ((y < 9) && (diagonal != 0)); y++) {

      for (x = 1; x < 9; x++) {
        
        valido = true;
       
        if (Math.abs(y - fila) == (y - fila)) {
      
          up = true;
      
        }
        
        else {
          
          up = false;
          
        } 
        
        if (Math.abs(x - columna) == (x - columna)) {
          
          right = true;
          
        }
        
        else {
          
          right = false;
          
        }
        
        if (((tablero[y][x] == reinaB) || (tablero[y][x] == alfilB)) && (Math.abs(y - fila) == Math.abs(x - columna))) {
        
          //desde arriba a la derecha//
          if ((up) && (right)) {
            
            j = fila;
            
            for (int i = columna + 1; ((i < x) && (valido)); i++) {
            
              j ++;
              
              if (tablero[j][i] != VACIO) {
                
                valido = false;
                diagonal --;
                
              }            
            }
          }
          
          //desde abajo a la derecha//
          else if ((!up) && (right)) {
            
            j = fila;
            
            for (int i = columna + 1; ((i < x) && (valido)); i++) {
            
              j--;
          
              if (tablero[j][i] != VACIO) {
                
                valido = false;
                diagonal --;
                
              }            
            }            
          }
          
          
          //desde abajo a la izquierda//
          else if ((!up) && (!right)) {
              
            j = fila;
              
            for (int i = columna - 1; ((i > x) && (valido)); i--) {
            
              j --;
              
              if (tablero[j][i] != VACIO) {
                
                valido = false;
                diagonal --;
                
              }
            }
          }            

          //desde arriba a la izquierda// 
          else if ((up) && (!right)) {  
             
            j = fila;
             
            for (int i = columna - 1; ((i > x) && (valido)); i--) {
            
              j ++;
                
              if (tablero[j][i] != VACIO) {
                  
                valido = false;
                diagonal --;
                  
              }            
            }
          }
          
          if (valido) {
          
          coordinadasJaque[0] = y;
          coordinadasJaque[1] = x;
          return coordinadasJaque;
          
          }          
        }
      }
    }
    
    //para peones//
      if (tablero[fila - 1][columna - 1] == peonB) {
        
        coordinadasJaque[0] = fila - 1;
        coordinadasJaque[1] = columna - 1;
        return coordinadasJaque;
      
      }
      
      else if (tablero[fila - 1][columna + 1] == peonB) {
        
        coordinadasJaque[0] = fila - 1;
        coordinadasJaque[1] = columna + 1;
        return coordinadasJaque;
        
      }
    
    
    return coordinadasJaque;
  }
    
}

/*Por PABLO ARIÑO MUÑOZ*/
