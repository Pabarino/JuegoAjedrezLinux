package tabla;

public class Tabla {
  
  public static String ImprimirTablaB (String tablero[][], int turnos, String aux1, String aux2) {
  
  int x;
  int y;
  
  //Mostramos el tablero//
    System.out.println("\nTurno: " + turnos);
    System.out.printf("\n%5s%4s%4s%4s%4s%4s%4s%4s\n","a","b","c","d","e","f","g","h");
    System.out.print("  ┏");
    
    for(int i = 0; i < 7; i++) {
          System.out.print("━━━┳");
    }
      
    System.out.print("━━━┓\n");
    
    for (y = 8; y >= 1; y--) {
      
      System.out.print(y + " ");
      
      for (x = 1; x < 9; x++) {

        System.out.print("┃ " + tablero[y][x] + " ");
        
      }
      
      if (y == 6) {
        
        System.out.printf("┃ "+ y +"\033[31m%9s\033[97m%s", "J2:", aux1);
        
        System.out.print("\n  ┣");
      
        for(int z = 0; z < 7; z++) {
          System.out.print("━━━╋");
        }
        
        System.out.println("━━━┫");
        
      }
      
      else  if (y == 3) {
        
        System.out.printf("┃ "+ y +"%9s%s", "J1:", aux2);
        
        System.out.print("\n  ┣");
      
        for(int z = 0; z < 7; z++) {
          System.out.print("━━━╋");
        }
        
        System.out.println("━━━┫");
        
      }
      
      else if (y == 1) {
        
        System.out.println("┃ "+ y);
        
      }
      
      else {
        
        System.out.println("┃ "+ y);
        
        System.out.print("  ┣");
      
        for(int z = 0; z < 7; z++) {
          System.out.print("━━━╋");
        }
        
        System.out.println("━━━┫");
      
      }
    }
    
    System.out.print("  ┗");
    
    for(int i = 0; i < 7; i++) {
        System.out.print("━━━┻");
    }
    
    System.out.print("━━━┛\n");
    
    System.out.printf("%5s%4s%4s%4s%4s%4s%4s%4s\n","a","b","c","d","e","f","g","h");
    
    return "";
    
  }  
  
  
  
  
  public static String ImprimirTablaSubrayadoB (String tablero[][], int turnos, int columna, int fila, String aux1, String aux2) {
  
  int x;
  int y;
  
  //Mostramos el tablero//
    System.out.println("\nTurno: " + turnos);
    System.out.printf("\n%5s%4s%4s%4s%4s%4s%4s%4s\n","a","b","c","d","e","f","g","h");
    System.out.print("  ┏");
    
    for(int i = 0; i < 7; i++) {
          System.out.print("━━━┳");
    }
      
    System.out.print("━━━┓\n");
    
    for (y = 8; y >= 1; y--) {
      
      System.out.print(y + " ");
      
      for (x = 1; x < 9; x++) {
        
        if ((y == fila) && (x == columna)) {
          
          System.out.print("┃\u001B[44m " + tablero[y][x] + " \u001B[40m");
          
        }
        
        else { 
        
          System.out.print("┃ " + tablero[y][x] + " ");
        
        }
        
      }
      
      if (y == 6) {
        
        System.out.printf("┃ "+ y +"\033[31m%9s\033[97m%s\n", "J2:", aux1);
        
        System.out.print("  ┣");
      
        for(int z = 0; z < 7; z++) {
          System.out.print("━━━╋");
        }
        
        System.out.println("━━━┫");
        
      }
      
      else  if (y == 3) {
        
        System.out.printf("┃ "+ y +"%9s%s\n", "J1:", aux2);
        
        System.out.print("  ┣");
      
        for(int z = 0; z < 7; z++) {
          System.out.print("━━━╋");
        }
        
        System.out.println("━━━┫");
        
      }
      
      else if (y == 1) {
        
        System.out.println("┃ "+ y);
        
      }
      
      else {
        
        System.out.println("┃ "+ y);
        
        System.out.print("  ┣");
      
        for(int z = 0; z < 7; z++) {
          System.out.print("━━━╋");
        }
        
        System.out.println("━━━┫");
        
      }      
    }
    
    System.out.print("  ┗");
    
    for(int i = 0; i < 7; i++) {
        System.out.print("━━━┻");
    }
    
    System.out.print("━━━┛\n");
    
    System.out.printf("%5s%4s%4s%4s%4s%4s%4s%4s\n","a","b","c","d","e","f","g","h");
    
    return "";
    
  } 
  
  
  
  
  public static String ImprimirTablaN (String tablero[][], int turnos, String aux1, String aux2) {
  
  int x;
  int y;
  
  //Mostramos el tablero//
    System.out.println("\nTurno: " + turnos);
    System.out.printf("\n%5s%4s%4s%4s%4s%4s%4s%4s\n","h","g","f","e","d","c","b","a");
    System.out.print("  ┏");
    
    for(int i = 0; i < 7; i++) {
          System.out.print("━━━┳");
    }
      
    System.out.print("━━━┓\n");
    
    for (y = 1; y < 9; y++) {
      
      System.out.print(y + " ");
      
      for (x = 8; x >= 1; x--)  {

        System.out.print("┃ " + tablero[y][x] + " ");
        
      }
      
      if (y == 6) {
        
        System.out.printf("┃ "+ y +"\033[31m%9s\033[97m%s\n", "J2:", aux1);
        
        System.out.print("  ┣");
      
        for(int z = 0; z < 7; z++) {
          System.out.print("━━━╋");
        }
        
        System.out.println("━━━┫");
        
      }
      
      else  if (y == 3) {
        
        System.out.printf("┃ "+ y +"%9s%s\n", "J1:", aux2);
        
        System.out.print("  ┣");
      
        for(int z = 0; z < 7; z++) {
          System.out.print("━━━╋");
        }
        
        System.out.println("━━━┫");
        
      }
      
      else if (y == 8) {
        
        System.out.println("┃ "+ y);
        
      }
      
      else {
        
        System.out.println("┃ "+ y);
        
        System.out.print("  ┣");
      
        for(int z = 0; z < 7; z++) {
          System.out.print("━━━╋");
        }
        
        System.out.println("━━━┫");
        
      }
    }
    
    System.out.print("  ┗");
    
    for(int i = 0; i < 7; i++) {
        System.out.print("━━━┻");
    }
    
    System.out.print("━━━┛\n");
    
    System.out.printf("%5s%4s%4s%4s%4s%4s%4s%4s\n","h","g","f","e","d","c","b","a");
    
    return "";
    
  }  
  
  
  
  
  public static String ImprimirTablaSubrayadoN (String tablero[][], int turnos, int columna, int fila, String aux1, String aux2) {
  
  int x;
  int y;
  
  //Mostramos el tablero//
    System.out.println("\nTurno: " + turnos);
    System.out.printf("\n%5s%4s%4s%4s%4s%4s%4s%4s\n","h","g","f","e","d","c","b","a");
    System.out.print("  ┏");
    
    for(int i = 0; i < 7; i++) {
          System.out.print("━━━┳");
    }
      
    System.out.print("━━━┓\n");
    
    for (y = 1; y < 9; y++) {
      
      System.out.print(y + " ");
      
      for (x = 8; x >= 1; x--)  {
        
        if ((y == fila) && (x == columna)) {
          
          System.out.print("┃\u001B[44m " + tablero[y][x] + " \u001B[40m");
          
        }
        
        else { 
        
          System.out.print("┃ " + tablero[y][x] + " ");
        
        }
        
      }
      
      if (y == 6) {
        
        System.out.printf("┃ "+ y +"\033[31m%9s\033[97m%s\n", "J2:", aux1);
        
        System.out.print("  ┣");
      
        for(int z = 0; z < 7; z++) {
          System.out.print("━━━╋");
        }
        
        System.out.println("━━━┫");
        
      }
      
      else  if (y == 3) {
        
        System.out.printf("┃ "+ y +"%9s%s\n", "J1:", aux2);
        
        System.out.print("  ┣");
      
        for(int z = 0; z < 7; z++) {
          System.out.print("━━━╋");
        }
        
        System.out.println("━━━┫");
        
      }
      
      else if (y == 8) {
        
        System.out.println("┃ "+ y);
        
      }
        
      
      else {
        
        System.out.println("┃ "+ y);
        
        System.out.print("  ┣");
      
        for(int z = 0; z < 7; z++) {
          System.out.print("━━━╋");
        }
        
        System.out.println("━━━┫");
      
      }      
    }
    
    System.out.print("  ┗");
    
    for(int i = 0; i < 7; i++) {
        System.out.print("━━━┻");
    }
    
    System.out.print("━━━┛\n");
    
    System.out.printf("%5s%4s%4s%4s%4s%4s%4s%4s\n","h","g","f","e","d","c","b","a");
    
    return "";
    
  } 
  
  
  
  
  public static String FichasComidasB (String tablero[][], String aux1, int ireinaB, int itorreB, int ialfilB, int icaballoB, int ipeonB) {
    
    final String VACIO = "";
    final String peonB = "♟";
    final String torreB = "♜";
    final String alfilB = "♝";
    final String caballoB = "♞";
    final String reinaB = "♛";
    
    String rB = VACIO;
    String pB = VACIO;
    String cB = VACIO;
    String aB = VACIO;
    String tB = VACIO;
    
    int x;
    int y;
    
    //vemos si se ha comido alguna ficha//
    for (y = 1; y < 9; y++) {
      
      for (x = 1; x < 9; x++) {
        
        if (tablero[y][x] == reinaB) {
        
          ireinaB --;

        }
        
        else if (tablero[y][x] == torreB) {
          
          itorreB --;
          
        }
        
        else if (tablero[y][x] == alfilB) {
          
          ialfilB --;

        }
        
        else if (tablero[y][x] == peonB) {
          
          ipeonB --;
          
        }
        
        else if (tablero[y][x] == caballoB) {
          
          icaballoB --;
          
        }
      }
    }
    
    if (ireinaB > 0) {
      
      rB = "  " + ireinaB + "*" + reinaB + "";
      
    }
    
    if (itorreB > 0) {
      
      tB = "  " + itorreB + "*" + torreB + "";
      
    }
    
    if (ialfilB > 0) {
      
      aB = "  " + ialfilB + "*" + alfilB + "";
      
    }
    
    if (ipeonB > 0) {
      
      pB = "  " + ipeonB + "*" + peonB + "";
      
    }
    
    if (icaballoB > 0) {
      
      cB = "  " + icaballoB +"*" + caballoB + "";
      
    }
    
    aux1 = (pB + cB + tB + aB + rB);
    
    return aux1;
  }
  
  
  
  
  public static String FichasComidasN (String tablero[][], String aux2, int ireinaN, int itorreN, int icaballoN, int ialfilN, int ipeonN) {
    
    final String VACIO = "";
    final String peonN = "♙";
    final String torreN = "♖";
    final String alfilN = "♗";
    final String caballoN = "♘";
    final String reinaN = "♕";
    
    String rN = VACIO;
    String pN = VACIO;
    String cN = VACIO;
    String aN = VACIO;
    String tN = VACIO;
    
    int x;
    int y;
    
    //vemos si se ha comido alguna ficha//
    for (y = 1; y < 9; y++) {
      
      for (x = 1; x < 9; x++) {
        
        if (tablero[y][x] == reinaN) {
        
          ireinaN --;

        }
        
        else if (tablero[y][x] == torreN) {
          
          itorreN --;
          
        }
        
        else if (tablero[y][x] == alfilN) {
          
          ialfilN --;

        }
        
        else if (tablero[y][x] == peonN) {
          
          ipeonN --;
          
        }
        
        else if (tablero[y][x] == caballoN) {
          
          icaballoN --;
          
        }
      }
    }
    
    if (ireinaN > 0) {
      
      rN = "  \033[31m" + ireinaN + "*" + reinaN + "\033[97m";
      
    }
    
    if (itorreN > 0) {
      
      tN = "  \033[31m" + itorreN + "*" + torreN + "\033[97m";
      
    }
    
    if (ialfilN > 0) {
      
      aN = "  \033[31m" + ialfilN + "*" + alfilN + "\033[97m";
      
    }
    
    if (ipeonN > 0) {
      
      pN = "  \033[31m" + ipeonN + "*" + peonN + "\033[97m";
      
    }
    
    if (icaballoN > 0) {
      
      cN = "  \033[31m" + icaballoN + "*" + caballoN + "\033[97m";
      
    }
    
    aux2 = (pN + cN + tN + aN + rN);
    
    return aux2;
  }
}

/*Por PABLO ARIÑO MUÑOZ*/
