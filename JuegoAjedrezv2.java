import java.util.Scanner;
import movimientos.MovimientosB;
import movimientos.MovimientosN;
import tabla.Tabla;
import tabla.Fichas;

/*COSAS QUE NO FUCIONAN / Faltan por implementar:
 * - Contador de reinas/ caballos / torres/ alfiles si el peon llega al final porque puede haber mas en una fila / columna ?? Creo que deberia funcionar...
 * - Turno se cambia pero el tablero sigue en el jugador anterior (ocurre a veces). Ocurre tras movimiento de peon, tambien puede deberse a algun fallo en el chequeo de 
 * jaquemates, ahogados o las variables para inciar los turnos ?? Creo que deberia funcionar... 
 * - No comprueba si una ficha esta pillada cuando comprueba el jaquemate ?? Creo que deberia funcionar...
 * */


public class JuegoAjedrezv2 {
  
  public static void main (String[] args)
  throws InterruptedException {
    
    Scanner s = new Scanner(System.in);
    

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

    
    int x;
    int y;
    int g;
    int fO;
    int cO;
    int posFiB = 0;
    int posCoB = 0;
    int posFiN = 0;
    int posCoN = 0;
    int objFiB = 0;
    int objCoB = 0;
    int objFiN = 0;
    int objCoN = 0;
    int movTorreDB = 0;
    int movTorreIB = 0;
    int movTorreDN = 0;
    int movTorreIN = 0;
    int movReyB = 0;
    int movReyN = 0;
    int turnos = 0;
    int columnaObjetivo = 0;
    int filaObjetivo = 0;
    int columna = 0;
    int fila = 0;
    int ireinaB = 0;
    int ireyB = 0;
    int itorreB = 0;
    int icaballoB = 0;
    int ipeonB = 0;
    int ialfilB = 0;
    int ireinaN = 0;
    int ireyN = 0;
    int icaballoN = 0;
    int ipeonN = 0;
    int itorreN = 0;
    int ialfilN = 0;
    int jaquemate = 0;
    int[] coordinadasJaque = new int[2];
    
    boolean fichasColocadas = false;
    boolean ilegal = true;
    boolean cancelar = true;
    boolean existente = true;
    boolean turno = false;
    boolean vJ1 = false;
    boolean vJ2 = false;

    String a = "";
    String b = "";
    String aux1 = "";
    String aux2 = "";
    String objetivoFicha = "";
    String posicionFicha = "";    
    String[][] aux = new String [10][10];
    String[][] tablero = new String[10][10];
    
    System.out.println("BIENVENIDO AL AJEDREZ!");
    System.out.println("\nQuieres jugar una partida NORMAL o quieres PRACTICAR movimientos?");
    System.out.print("N/P: ");
    String tipoPartida = s.nextLine();
    System.out.println();
    
    if ((tipoPartida.toLowerCase().equals("p")) || (tipoPartida.toLowerCase().equals("practicar"))) {
      
      tablero = (tabla.Fichas.InicializarVACIO(tablero));
      System.out.print(tabla.Tabla.ImprimirTablaB(tablero, turnos, aux1, aux2));
      
      while (!fichasColocadas) {
        
        System.out.print("\nDeclare donde desea colocar una ficha o escriba TERMINAR para empezar.\n(E.j h2 para colocar ficha en segunda fila): ");
        posicionFicha = s.nextLine();
          
        //comprobamos si se quiere continuar//
        if (posicionFicha.toLowerCase().equals("terminar")) {
          
          if ((ireyB != 1) && (ireyN != 1)) {
            
            System.out.print(tabla.Tabla.ImprimirTablaB(tablero, turnos, aux1, aux2));
            System.out.print("\nTiene que haber un unico REY por lado.");
            
          }
          
          else {
          
            fichasColocadas = true;
            System.out.print("\n" + tabla.Tabla.ImprimirTablaB(tablero, turnos, aux1, aux2));
          }
        }  
        
        //comprobamos que no le haya dado al enter sin introducir un valor//
        else if (posicionFicha.length() != 2) {
          
            System.out.print(tabla.Tabla.ImprimirTablaB(tablero, turnos, aux1, aux2));
            System.out.print("\nNo has introducido ningun valor.");
                          
        }
        
        else {
        
          columna = (int)(posicionFicha.toLowerCase().charAt(0)) - 96;
          fila = (int)(posicionFicha.charAt(1)) - 48;
          
         
          
          //comprobamos que ha seleccionado una ficha posible//
          if ((columna > 8) || (columna < 1) || (fila > 8) || (fila < 1)) {
            
            System.out.print(tabla.Tabla.ImprimirTablaB(tablero, turnos, aux1, aux2));
            System.out.print("\nPosicion no existe.");
            
          }
          
          else {
            
            System.out.println(tabla.Tabla.ImprimirTablaSubrayadoB(tablero, turnos, columna, fila, aux1, aux2));
            
            System.out.print("\nQue ficha quieres colocar: REINA, REY, PEON, TORRE, CABALLO, ALFIL o VACIO \n(para borrar)?: ");
            a = s.nextLine();
            
            if (!a.toLowerCase().equals("vacio")) {
              
              System.out.print("\nDe que color: BLANCO O NEGRO?: ");
              b = s.nextLine();
            }
            
            switch(a.toLowerCase()) {
              
              case "reina":
              
                if (b.toLowerCase().equals("blanco")) {
                  
                  tablero[fila][columna] = reinaB;
                  
                  ireinaB ++;                  
                }
                
                else {
                  
                  tablero[fila][columna] = reinaN;
                  
                  ireinaN ++;
                }        
                System.out.print(tabla.Tabla.ImprimirTablaB(tablero, turnos, aux1, aux2));          
              break;
              
              case "rey":
              
                if (b.toLowerCase().equals("blanco")) {
                  
                  tablero[fila][columna] = reyB;
                  
                  ireyB ++;
                }
                
                else {
                  
                  tablero[fila][columna] = reyN;
                  
                  ireyN ++;
                }     
                System.out.print(tabla.Tabla.ImprimirTablaB(tablero, turnos, aux1, aux2));             
              break;
              
              case "peon":
              
                if (b.toLowerCase().equals("blanco")) {
                  
                  tablero[fila][columna] = peonB;
                  
                  ipeonB ++;
                }
                
                else {
                  
                  tablero[fila][columna] = peonN;
                  
                  ipeonN ++;
                }     
                System.out.print(tabla.Tabla.ImprimirTablaB(tablero, turnos, aux1, aux2));             
              break;
              
              case "torre":
              
                if (b.toLowerCase().equals("blanco")) {
                  
                  tablero[fila][columna] = torreB;
                  
                  itorreB ++;
                }
                
                else {
                  
                  tablero[fila][columna] = torreN;
                  
                  itorreN ++;
                } 
                System.out.print(tabla.Tabla.ImprimirTablaB(tablero, turnos, aux1, aux2));                 
              break;
              
              case "alfil":
              
                if (b.toLowerCase().equals("blanco")) {
                  
                  tablero[fila][columna] = alfilB;
                    
                  ialfilB ++;
                }
                
                else {
                  
                  tablero[fila][columna] = alfilN;
                  
                  ialfilN ++;
                }  
                System.out.print(tabla.Tabla.ImprimirTablaB(tablero, turnos, aux1, aux2));                
              break;
              
              case "caballo":
              
                if (b.toLowerCase().equals("blanco")) {
                  
                  tablero[fila][columna] = caballoB;
                  
                  icaballoB ++;
                }
                
                else {
                  
                  tablero[fila][columna] = caballoN;
                  
                  icaballoN ++;
                }  
                System.out.print(tabla.Tabla.ImprimirTablaB(tablero, turnos, aux1, aux2));                
              break;
              
              case "vacio":
                
                tablero[fila][columna] = VACIO;
                System.out.print(tabla.Tabla.ImprimirTablaB(tablero, turnos, aux1, aux2));                
              break;
                  
              default:
              System.out.print("Ficha no existente");
              System.out.print(tabla.Tabla.ImprimirTablaB(tablero, turnos, aux1, aux2));
              break;                
            }            
          }        
        }        
      }      
    }
    
    else {
      
      ireinaB = 1;
      itorreB = 2;
      ipeonB = 2;
      icaballoB = 8;
      ialfilB = 2;
      ireinaN = 1;
      itorreN = 2;
      ipeonN = 2;
      icaballoN = 8;
      ialfilN = 2;
      
      //Inicializamos el array//
      tablero = (tabla.Fichas.PartidaNormal(tablero));
      System.out.print(tabla.Tabla.ImprimirTablaB(tablero, turnos, aux1, aux2));
    }
    
    
    
    
    //COMIENZA EL JUEGO//
    while ((!vJ1) && (!vJ2)) {
      
      turno = false;
      cancelar = true;
      
      //buscamos la posicion del rey//
      for(y = 1; y < 9; y++) {
        
        for (x = 1; x < 9; x++) {
            
          if (tablero[y][x] == reyB) {
            
            fila = y;
            columna = x;
          }
        }
      }
      
      if ((ipeonB + ialfilB + itorreB + icaballoB + ireinaB) < 1) {
        
        vJ2 = true;
        vJ1 = true;
      }
      
      
      //COMPROBAMOS SI HAY JAQUE MATE//
      if (movimientos.MovimientosB.JaqueAlRey(tablero)) {
        
        //derecha//
        if ((tablero[fila][columna + 1] == VACIO) || ((tablero[fila][columna + 1] == peonN) || (tablero[fila][columna + 1] == alfilN) || (tablero[fila][columna + 1] == torreN) 
        
        || (tablero[fila][columna + 1] == caballoN) || (tablero[fila][columna + 1] == reinaN))) {
           
          aux[fila][columna + 1] = tablero[fila][columna + 1];
          
          //hacemos el cambio de ficha//
          tablero[fila][columna + 1] = reyB;
          tablero[fila][columna] = VACIO; 
          
          if (movimientos.MovimientosB.JaqueAlRey(tablero)) {
                            
                jaquemate ++;
          }       
          
          tablero[fila][columna + 1] = aux[fila][columna + 1];
          tablero[fila][columna] = reyB;
               
        }
        
        else {
          
          jaquemate ++;
          
        }
        
        // izquierda//
        if ((tablero[fila][columna - 1] == VACIO) || ((tablero[fila][columna - 1] == peonN) || (tablero[fila][columna - 1] == alfilN) || (tablero[fila][columna - 1] == torreN) 
        
        || (tablero[fila][columna - 1] == caballoN) || (tablero[fila][columna - 1] == reinaN))) {
          
          aux[fila][columna - 1] = tablero[fila][columna - 1];
          
          //hacemos el cambio de ficha//
          tablero[fila][columna - 1] = reyB;
          tablero[fila][columna] = VACIO; 
          
          if (movimientos.MovimientosB.JaqueAlRey(tablero)) {
                                  
                jaquemate ++;
          } 
          
          tablero[fila][columna - 1] = aux[fila][columna - 1];
          tablero[fila][columna] = reyB;
          
        }
        
        else {
          
          jaquemate ++;
          
        }
        
        //arriba a la derecha//
        if ((tablero[fila + 1][columna + 1] == VACIO) || ((tablero[fila + 1][columna + 1] == peonN) || (tablero[fila +1][columna + 1] == alfilN) || (tablero[fila + 1][columna + 1] == torreN) 
        
        || (tablero[fila + 1][columna + 1] == caballoN) || (tablero[fila + 1][columna + 1] == reinaN))) {
          
          aux[fila + 1][columna + 1] = tablero[fila + 1][columna + 1];
          
          //hacemos el cambio de ficha//
          tablero[fila + 1][columna + 1] = reyB;
          tablero[fila][columna] = VACIO; 
          
          if (movimientos.MovimientosB.JaqueAlRey(tablero)) {
                                  
                jaquemate ++;
          }     
          
          tablero[fila + 1][columna + 1] = aux[fila + 1][columna + 1];
          tablero[fila][columna] = reyB;
                  
        }
        
        else {
          
          jaquemate ++;
          
        }
        
        //abajo a la derecha//
        if ((tablero[fila - 1][columna + 1] == VACIO) || ((tablero[fila - 1][columna + 1] == peonN) || (tablero[fila - 1][columna + 1] == alfilN) || (tablero[fila - 1][columna + 1] == torreN) 
        
        || (tablero[fila - 1][columna + 1] == caballoN) || (tablero[fila - 1][columna + 1] == reinaN))) {
          
          aux[fila - 1][columna + 1] = tablero[fila - 1][columna + 1];
          
          //hacemos el cambio de ficha//
          tablero[fila - 1][columna + 1] = reyB;
          tablero[fila][columna] = VACIO; 
          
          if (movimientos.MovimientosB.JaqueAlRey(tablero)) {
                                  
                jaquemate ++;
          }     
          
          tablero[fila - 1][columna + 1] = aux[fila - 1][columna + 1];
          tablero[fila][columna] = reyB;
                  
        }
        
        else {
          
          jaquemate ++;
          
        }
        
        //abajo//
        if ((tablero[fila - 1][columna] == VACIO) || ((tablero[fila - 1][columna] == peonN) || (tablero[fila - 1][columna] == alfilN) || (tablero[fila - 1][columna] == torreN) 
        
        || (tablero[fila - 1][columna] == caballoN) || (tablero[fila - 1][columna] == reinaN))) {
          
          aux[fila - 1][columna] = tablero[fila - 1][columna];
          
          //hacemos el cambio de ficha//
          tablero[fila -1][columna] = reyB;
          tablero[fila][columna] = VACIO; 
          
          if (movimientos.MovimientosB.JaqueAlRey(tablero)) {
                                  
                jaquemate ++;
          }             
          
          tablero[fila - 1][columna] = aux[fila - 1][columna];
          tablero[fila][columna] = reyB;
          
        }
        
        else {
          
          jaquemate ++;
          
        }
        
        //arriba//
        if ((tablero[fila + 1][columna] == VACIO) || ((tablero[fila + 1][columna] == peonN) || (tablero[fila + 1][columna] == alfilN) || (tablero[fila + 1][columna] == torreN) 
        
        || (tablero[fila + 1][columna] == caballoN) || (tablero[fila + 1][columna] == reinaN))) {
          
          aux[fila + 1][columna] = tablero[fila + 1][columna];
          
          //hacemos el cambio de ficha//
          tablero[fila + 1][columna] = reyB;
          tablero[fila][columna] = VACIO; 
          
          if (movimientos.MovimientosB.JaqueAlRey(tablero)) {
                            
                jaquemate ++;
          }       
          
          tablero[fila + 1][columna] = aux[fila + 1][columna];
          tablero[fila][columna] = reyB;
                
        }
        
        else {
          
          jaquemate ++;
          
        }
        
        //abajo a la izquierda//
        if ((tablero[fila - 1][columna - 1] == VACIO) || ((tablero[fila - 1][columna - 1] == peonN) || (tablero[fila - 1][columna - 1] == alfilN) || (tablero[fila - 1][columna - 1] == torreN) 
        
        || (tablero[fila - 1][columna - 1] == caballoN) || (tablero[fila - 1][columna - 1] == reinaN))) {
          
          aux[fila - 1][columna - 1] = tablero[fila - 1][columna - 1];
          
          //hacemos el cambio de ficha//
          tablero[fila - 1][columna - 1] = reyB;
          tablero[fila][columna] = VACIO; 
          
          if (movimientos.MovimientosB.JaqueAlRey(tablero)) {
                                  
                jaquemate ++;
          }     
          
          tablero[fila - 1][columna - 1] = aux[fila - 1][columna - 1];
          tablero[fila][columna] = reyB;
                  
        }
        
        else {
          
          jaquemate ++;
          
        }
        
        //arriba a la izquierda//
        if ((tablero[fila + 1][columna - 1] == VACIO) || ((tablero[fila + 1][columna - 1] == peonN) || (tablero[fila + 1][columna - 1] == alfilN) || (tablero[fila + 1][columna - 1] == torreN) 
        
        || (tablero[fila + 1][columna - 1] == caballoN) || (tablero[fila + 1][columna - 1] == reinaN))) {
          
          aux[fila + 1][columna - 1] = tablero[fila + 1][columna - 1];
          
          //hacemos el cambio de ficha//
          tablero[fila + 1][columna - 1] = reyB;
          tablero[fila][columna] = VACIO; 
          
          if (movimientos.MovimientosB.JaqueAlRey(tablero)) {
                                  
                jaquemate ++;
          }
          
          tablero[fila + 1][columna - 1] = aux[fila + 1][columna - 1];
          tablero[fila][columna] = reyB;    
          
        }  
        
        else {
          
          jaquemate ++;
          
        }      
          
        if (jaquemate == 8) {
          
          vJ2 = true;
          
          //COMPROBAMOS SI PUEDE BLOQUEAR EL JAQUE//
          coordinadasJaque = (movimientos.MovimientosB.PosicionesEntreJaque(tablero));
                      
          //Vemos si hay alguna ficha que se pueda comer la ficha haciendo el jaque//                                          
          for (int i = 1; ((i < 9) && (vJ2)); i++) {
            
            for (int j = 1; j < 9; j++) {
              
              x = columna;
              g = fila;
              
              filaObjetivo = coordinadasJaque[0];
              columnaObjetivo = coordinadasJaque[1];
              fO = filaObjetivo;
              cO = columnaObjetivo;
             
              if (tablero[i][j] == torreB) {
                
                fila = i;
                columna = j;
                
                if (movimientos.MovimientosB.MovimientoTorre (tablero, fila, columna, filaObjetivo, columnaObjetivo)) {
                  
                  aux[fila][columna] = tablero[filaObjetivo][columnaObjetivo];
          
                  //hacemos el cambio de ficha//
                  tablero[filaObjetivo][columnaObjetivo] = torreB;
                  tablero[fila][columna] = VACIO; 
                  
                  if (movimientos.MovimientosB.JaqueAlRey(tablero)) {} 
                  
                  else { 
                    
                    vJ2 = false;                    
                  }  
                  
                  tablero[fila][columna] = torreB; 
                  tablero[filaObjetivo][columnaObjetivo] = aux[fila][columna];
                                          
                }
                
                //Si no es posible vemos si esta ficha puede bloquearlo//
                else {
                  
                  for (y = g + 1; ((y < fO) && (vJ2)); y++) {
            
                    if (x < cO) {
                      
                      x ++;
                    }
                    
                    filaObjetivo = y;
                    columnaObjetivo = x; 
                    
                    if ((movimientos.MovimientosB.MovimientoTorre (tablero, fila, columna, filaObjetivo, columnaObjetivo)) 
                    
                    && (tablero[coordinadasJaque[0]][coordinadasJaque[1]] != caballoN)) {
                  
                       aux[fila][columna] = tablero[filaObjetivo][columnaObjetivo];
          
                      //hacemos el cambio de ficha//
                      tablero[filaObjetivo][columnaObjetivo] = torreB;
                      tablero[fila][columna] = VACIO; 
                      
                      if (movimientos.MovimientosB.JaqueAlRey(tablero)) {} 
                      
                      else { 
                        
                        vJ2 = false;
                      }                    
                      
                      tablero[fila][columna] = torreB; 
                      tablero[filaObjetivo][columnaObjetivo] = aux[fila][columna];
                        
                    }                  
                  }              
                }
              }
              
              else if (tablero[i][j] == alfilB) {
                
                fila = i;
                columna = j;
                
                if (movimientos.MovimientosB.MovimientoAlfil (tablero, fila, columna, filaObjetivo, columnaObjetivo)) {
                  
                  aux[fila][columna] = tablero[filaObjetivo][columnaObjetivo];
          
                  //hacemos el cambio de ficha//
                  tablero[filaObjetivo][columnaObjetivo] = alfilB;
                  tablero[fila][columna] = VACIO; 
                  
                  if (movimientos.MovimientosB.JaqueAlRey(tablero)) {} 
                  
                  else { 
                    
                    vJ2 = false;
                  } 
                  
                  tablero[fila][columna] = alfilB; 
                  tablero[filaObjetivo][columnaObjetivo] = aux[fila][columna];
                  
                }
                
                //Si no es posible vemos si esta ficha puede bloquearlo//
                else {
                  
                  for (y = g + 1; ((y < fO) && (vJ2)); y++) {
            
                    if (x < cO) {
                      
                      x ++;
                    }
                    
                    filaObjetivo = y;
                    columnaObjetivo = x; 
                    
                    if ((movimientos.MovimientosB.MovimientoAlfil (tablero, fila, columna, filaObjetivo, columnaObjetivo)) 
                    
                    && (tablero[coordinadasJaque[0]][coordinadasJaque[1]] != caballoN)) {
                  
                      aux[fila][columna] = tablero[filaObjetivo][columnaObjetivo];
          
                      //hacemos el cambio de ficha//
                      tablero[filaObjetivo][columnaObjetivo] = alfilB;
                      tablero[fila][columna] = VACIO; 
                      
                      if (movimientos.MovimientosB.JaqueAlRey(tablero)) {} 
                      
                      else { 
                        
                        vJ2 = false;
                      }   
                      
                      tablero[fila][columna] = alfilB; 
                      tablero[filaObjetivo][columnaObjetivo] = aux[fila][columna];
                                          
                    }                
                  }
                }
              }
                
              else if (tablero[i][j] == peonB) {
                
                fila = i;
                columna = j;
                
                if (movimientos.MovimientosB.MovimientoPeon (tablero, fila, columna, filaObjetivo, columnaObjetivo)) {
                  
                  aux[fila][columna] = tablero[filaObjetivo][columnaObjetivo];
          
                  //hacemos el cambio de ficha//
                  tablero[filaObjetivo][columnaObjetivo] = peonB;
                  tablero[fila][columna] = VACIO; 
                  
                  if (movimientos.MovimientosB.JaqueAlRey(tablero)) {} 
                  
                  else { 
                    
                    vJ2 = false;
                  }
                   
                  tablero[fila][columna] = peonB; 
                  tablero[filaObjetivo][columnaObjetivo] = aux[fila][columna];
                }
                //Si no es posible vemos si esta ficha puede bloquearlo//
                else {
                  
                  for (y = g + 1; ((y < fO) && (vJ2)); y++) {
            
                    if (x < cO) {
                      
                      x ++;
                    }
                    
                    filaObjetivo = y;
                    columnaObjetivo = x; 
                    
                    if ((movimientos.MovimientosB.MovimientoPeon (tablero, fila, columna, filaObjetivo, columnaObjetivo)) 
                    
                    && (tablero[coordinadasJaque[0]][coordinadasJaque[1]] != caballoN)) {
                  
                      aux[fila][columna] = tablero[filaObjetivo][columnaObjetivo];
          
                      //hacemos el cambio de ficha//
                      tablero[filaObjetivo][columnaObjetivo] = peonB;
                      tablero[fila][columna] = VACIO; 
                      
                      if (movimientos.MovimientosB.JaqueAlRey(tablero)) {} 
                      
                      else { 
                        
                        vJ2 = false;
                      } 
                      
                      tablero[fila][columna] = peonB; 
                      tablero[filaObjetivo][columnaObjetivo] = aux[fila][columna];
                      
                    }                
                  }
                }
              }
                
              else if (tablero[i][j] == caballoB) {
                
                fila = i;
                columna = j;
                
                if (movimientos.MovimientosB.MovimientoCaballo (tablero, fila, columna, filaObjetivo, columnaObjetivo)) {
                  
                  aux[fila][columna] = tablero[filaObjetivo][columnaObjetivo];
          
                  //hacemos el cambio de ficha//
                  tablero[filaObjetivo][columnaObjetivo] = caballoB;
                  tablero[fila][columna] = VACIO; 
                  
                  if (movimientos.MovimientosB.JaqueAlRey(tablero)) {} 
                  
                  else { 
                    
                    vJ2 = false;
                  } 
                  
                  tablero[fila][columna] = caballoB; 
                  tablero[filaObjetivo][columnaObjetivo] = aux[fila][columna];
                  
                }
                //Si no es posible vemos si esta ficha puede bloquearlo//
                else {
                  
                  for (y = g + 1; ((y < fO) && (vJ2)); y++) {
            
                    if (x < cO) {
                      
                      x ++;
                    }
                    
                    filaObjetivo = y;
                    columnaObjetivo = x; 
                    
                    if ((movimientos.MovimientosB.MovimientoCaballo (tablero, fila, columna, filaObjetivo, columnaObjetivo)) 
                    
                    && (tablero[coordinadasJaque[0]][coordinadasJaque[1]] != caballoN)) {
                  
                      aux[fila][columna] = tablero[filaObjetivo][columnaObjetivo];
          
                      //hacemos el cambio de ficha//
                      tablero[filaObjetivo][columnaObjetivo] = caballoB;
                      tablero[fila][columna] = VACIO; 
                      
                      if (movimientos.MovimientosB.JaqueAlRey(tablero)) {} 
                      
                      else { 
                        
                        vJ2 = false;
                      } 
                      
                      tablero[fila][columna] = caballoB; 
                      tablero[filaObjetivo][columnaObjetivo] = aux[fila][columna];
                      
                    }
                  }              
                }
              }
                
              else if (tablero[i][j] == reinaB) {
                
                fila = i;
                columna = j;
                
                if (movimientos.MovimientosB.MovimientoReina (tablero, fila, columna, filaObjetivo, columnaObjetivo)) {
                  
                  aux[fila][columna] = tablero[filaObjetivo][columnaObjetivo];
          
                  //hacemos el cambio de ficha//
                  tablero[filaObjetivo][columnaObjetivo] = reinaB;
                  tablero[fila][columna] = VACIO; 
                  
                  if (movimientos.MovimientosB.JaqueAlRey(tablero)) {} 
                  
                  else { 
                    
                    vJ2 = false;
                  } 
                  
                  tablero[fila][columna] = reinaB; 
                  tablero[filaObjetivo][columnaObjetivo] = aux[fila][columna];
                  
                }
                
                //Si no es posible vemos si esta ficha puede bloquearlo//
                else {
                  
                  for (y = g + 1; ((y < fO) && (vJ2)); y++) {
            
                    if (x < cO) {
                      
                      x ++;
                    }
                    
                    filaObjetivo = y;
                    columnaObjetivo = x; 
                                          
                    if ((movimientos.MovimientosB.MovimientoReina (tablero, fila, columna, filaObjetivo, columnaObjetivo))
                    
                    && (tablero[coordinadasJaque[0]][coordinadasJaque[1]] != caballoN)) {
                  
                      aux[fila][columna] = tablero[filaObjetivo][columnaObjetivo];
          
                      //hacemos el cambio de ficha//
                      tablero[filaObjetivo][columnaObjetivo] = reinaB;
                      tablero[fila][columna] = VACIO; 
                      
                      if (movimientos.MovimientosB.JaqueAlRey(tablero)) {} 
                      
                      else { 
                        
                        vJ2 = false;
                      } 
                      
                      tablero[fila][columna] = reinaB; 
                      tablero[filaObjetivo][columnaObjetivo] = aux[fila][columna];
                      
                    }
                  }
                }
              }                
            }
          }                                       
          
          
          if (vJ2) {
            
            System.out.print("\nJaque mate.");
            
          }             
        }          
      }
      
      jaquemate = 0;
      
      //COMPROBAMOS SI HA SIDO AHOGADO//
      if ((!vJ1) && (!vJ2)) {
        
        vJ2 = true;
        vJ1 = true;
        
        for (y = 1; ((y < 9) && (vJ1) && (vJ2)); y++) {
          
          for (x = 1; x < 9; x++) {
            
            fila = y;
            columna = x;
            
            if (tablero[y][x] == torreB) {
              
              for (int i = 1; ((i < 9) && (vJ1) && (vJ2)); i++) {
          
                for (int j = 1; j < 9; j++) {
                  
                  columnaObjetivo = j;
                  filaObjetivo = i;
                  
                  if (tablero[filaObjetivo][columnaObjetivo] != VACIO) {}
                  
                  else if (movimientos.MovimientosB.MovimientoTorre (tablero, fila, columna, filaObjetivo, columnaObjetivo)) {
                    
                    aux[fila][columna] = tablero[filaObjetivo][columnaObjetivo];
          
                    //hacemos el cambio de ficha//
                    tablero[filaObjetivo][columnaObjetivo] = torreB;
                    tablero[fila][columna] = VACIO; 
                    
                    if (movimientos.MovimientosB.JaqueAlRey(tablero)) {} 
                    
                    else { 
                      
                      vJ1 = false;
                      vJ2 = false;
                    } 
                    
                    tablero[fila][columna] = torreB; 
                    tablero[filaObjetivo][columnaObjetivo] = aux[fila][columna];
                                        
                  }
                }
              }
            }
            
            else if (tablero[y][x] == alfilB) {
              
              for (int i = 1; ((i < 9) && (vJ1) && (vJ2)); i++) {
          
                for (int j = 1; j < 9; j++) {
                  
                  columnaObjetivo = j;
                  filaObjetivo = i;
                  
                  if ((tablero[filaObjetivo][columnaObjetivo] == peonB) || (tablero[filaObjetivo][columnaObjetivo] == torreB) || (tablero[filaObjetivo][columnaObjetivo] == alfilB) 
          
                  || (tablero[filaObjetivo][columnaObjetivo] == reinaB) || (tablero[filaObjetivo][columnaObjetivo] == reyB) || (tablero[filaObjetivo][columnaObjetivo] == caballoB)) {}
                  
                  else if (movimientos.MovimientosB.MovimientoAlfil (tablero, fila, columna, filaObjetivo, columnaObjetivo)) {
                    
                    aux[fila][columna] = tablero[filaObjetivo][columnaObjetivo];
          
                    //hacemos el cambio de ficha//
                    tablero[filaObjetivo][columnaObjetivo] = alfilB;
                    tablero[fila][columna] = VACIO; 
                    
                    if (movimientos.MovimientosB.JaqueAlRey(tablero)) {} 
                    
                    else { 
                      
                      vJ1 = false;
                      vJ2 = false;
                    } 
                    
                    tablero[fila][columna] = alfilB; 
                    tablero[filaObjetivo][columnaObjetivo] = aux[fila][columna];
                    
                  }
                }
              }
            }
            
            else if (tablero[y][x] == caballoB) {
              
              for (int i = 1; ((i < 9) && (vJ1) && (vJ2)); i++) {
          
                for (int j = 1; j < 9; j++) {
                  
                  columnaObjetivo = j;
                  filaObjetivo = i;
                  
                  if ((tablero[filaObjetivo][columnaObjetivo] == peonB) || (tablero[filaObjetivo][columnaObjetivo] == torreB) || (tablero[filaObjetivo][columnaObjetivo] == alfilB) 
          
                  || (tablero[filaObjetivo][columnaObjetivo] == reinaB) || (tablero[filaObjetivo][columnaObjetivo] == reyB) || (tablero[filaObjetivo][columnaObjetivo] == caballoB)) {}
                  
                  else if (movimientos.MovimientosB.MovimientoCaballo (tablero, fila, columna, filaObjetivo, columnaObjetivo)) {
                    
                    aux[fila][columna] = tablero[filaObjetivo][columnaObjetivo];
          
                    //hacemos el cambio de ficha//
                    tablero[filaObjetivo][columnaObjetivo] = caballoB;
                    tablero[fila][columna] = VACIO; 
                    
                    if (movimientos.MovimientosB.JaqueAlRey(tablero)) {} 
                    
                    else { 
                      
                      vJ1 = false;
                      vJ2 = false;
                    } 
                    
                    tablero[fila][columna] = caballoB; 
                    tablero[filaObjetivo][columnaObjetivo] = aux[fila][columna];
                    
                  }
                }
              }
            }
            
            else if (tablero[y][x] == peonB) {
              
              for (int i = 1; ((i < 9) && (vJ1) && (vJ2)); i++) {
          
                for (int j = 1; j < 9; j++) {
                  
                  columnaObjetivo = j;
                  filaObjetivo = i;
                  
                  if ((tablero[filaObjetivo][columnaObjetivo] == peonB) || (tablero[filaObjetivo][columnaObjetivo] == torreB) || (tablero[filaObjetivo][columnaObjetivo] == alfilB) 
          
                  || (tablero[filaObjetivo][columnaObjetivo] == reinaB) || (tablero[filaObjetivo][columnaObjetivo] == reyB) || (tablero[filaObjetivo][columnaObjetivo] == caballoB)) {}
                  
                  else if (movimientos.MovimientosB.MovimientoPeon (tablero, fila, columna, filaObjetivo, columnaObjetivo)) {
                    
                    aux[fila][columna] = tablero[filaObjetivo][columnaObjetivo];
          
                    //hacemos el cambio de ficha//
                    tablero[filaObjetivo][columnaObjetivo] = peonB;
                    tablero[fila][columna] = VACIO; 
                    
                    if (movimientos.MovimientosB.JaqueAlRey(tablero)) {} 
                    
                    else { 
                      
                      vJ1 = false;
                      vJ2 = false;
                    } 
                    
                    tablero[fila][columna] = peonB; 
                    tablero[filaObjetivo][columnaObjetivo] = aux[fila][columna];
                    
                  }
                }
              }
            }
            
            else if (tablero[y][x] == reinaB) {
              
              for (int i = 1; ((i < 9) && (vJ1) && (vJ2)); i++) {
          
                for (int j = 1; j < 9; j++) {
                  
                  columnaObjetivo = j;
                  filaObjetivo = i;
                  
                  if ((tablero[filaObjetivo][columnaObjetivo] == peonB) || (tablero[filaObjetivo][columnaObjetivo] == torreB) || (tablero[filaObjetivo][columnaObjetivo] == alfilB) 
          
                  || (tablero[filaObjetivo][columnaObjetivo] == reinaB) || (tablero[filaObjetivo][columnaObjetivo] == reyB) || (tablero[filaObjetivo][columnaObjetivo] == caballoB)) {}
                  
                  else if (movimientos.MovimientosB.MovimientoReina (tablero, fila, columna, filaObjetivo, columnaObjetivo)) {
                    
                    aux[fila][columna] = tablero[filaObjetivo][columnaObjetivo];
          
                    //hacemos el cambio de ficha//
                    tablero[filaObjetivo][columnaObjetivo] = reinaB;
                    tablero[fila][columna] = VACIO; 
                    
                    if (movimientos.MovimientosB.JaqueAlRey(tablero)) {} 
                    
                    else { 
                      
                      vJ1 = false;
                      vJ2 = false;
                    } 
                    
                    tablero[fila][columna] = reinaB; 
                    tablero[filaObjetivo][columnaObjetivo] = aux[fila][columna];
                    
                  }
                }
              }
            }
            
            else if (tablero[y][x] == reyB) {
              
              for (int i = 1; ((i < 9) && (vJ1) && (vJ2)); i++) {
          
                for (int j = 1; j < 9; j++) {
                  
                  columnaObjetivo = j;
                  filaObjetivo = i;
                  
                  if ((tablero[filaObjetivo][columnaObjetivo] == peonB) || (tablero[filaObjetivo][columnaObjetivo] == torreB) || (tablero[filaObjetivo][columnaObjetivo] == alfilB) 
          
                  || (tablero[filaObjetivo][columnaObjetivo] == reinaB) || (tablero[filaObjetivo][columnaObjetivo] == reyB) || (tablero[filaObjetivo][columnaObjetivo] == caballoB)) {}
                  
                  else if (movimientos.MovimientosB.MovimientoRey (tablero, fila, columna, filaObjetivo, columnaObjetivo)) {
                    
                    aux[filaObjetivo][columnaObjetivo] = tablero[filaObjetivo][columnaObjetivo];
                    
                    tablero[filaObjetivo][columnaObjetivo] = tablero[fila][columna];
                    tablero[fila][columna] = VACIO;
                    
                    if (movimientos.MovimientosB.JaqueAlRey(tablero)) {}
                    
                    else {
                      
                      vJ1 = false;
                      vJ2 = false;
                      
                    }
                  
                    tablero[filaObjetivo][columnaObjetivo] = aux[filaObjetivo][columnaObjetivo];
                    tablero[fila][columna] = reyB;                    
                  }
                }
              }
            }
          }
        }
      }
      
      
        
      
      //Turno Jugador 1//
      while ((cancelar) && (!vJ2) && (!vJ1) && (!turno))  {
        
        cancelar = false;          
        
        //Pedimos el movimiento jugador 1// 
        do {
          existente = true;
          
          if (movimientos.MovimientosB.JaqueAlRey(tablero)) {
            
            System.out.print("\nLe estan haciendo jaque.");
            
          }
          
          System.out.print("\nDeclare la ficha que desea mover Jugador 1 o escribe RENDIRSE para terminar.\n(E.j h2 para mover el peon de segunda fila): ");
          posicionFicha = s.nextLine();
          
          //comprobamos que no le haya dado al enter sin introducir un valor//
          if (posicionFicha.equals("")) {
          
              System.out.print(tabla.Tabla.ImprimirTablaB(tablero, turnos, aux1, aux2));
              System.out.print("\nNo has introducido ningun valor.");
              existente = false;
                            
          }
          
          //comprobamos que no haya introducida una unica letra o numero//
          else if (posicionFicha.length() == 1) {
          
              System.out.print(tabla.Tabla.ImprimirTablaB(tablero, turnos, aux1, aux2));
              System.out.print("\nValor introducido no valido.");
              existente = false;
                            
          }
          
          else {
          
            columna = (int)(posicionFicha.toLowerCase().charAt(0)) - 96;
            fila = (int)(posicionFicha.charAt(1)) - 48;
            
            posFiB = fila;
            posCoB = columna;
            
            //comprobamos si se quiere rendir//
            if (posicionFicha.toLowerCase().equals("rendirse")) {
              
              vJ2 = true;
              turno = false;
              
            }
            
            //comprobamos que ha seleccionado una ficha posible//
            else if ((columna > 8) || (columna < 1) || (fila > 8) || (fila < 1) || ((tablero[fila][columna] != peonB) && (tablero[fila][columna] != torreB)  && (tablero[fila][columna] != alfilB) 
          
            && (tablero[fila][columna] != reinaB) && (tablero[fila][columna] != reyB) && (tablero[fila][columna] != caballoB))){
              
              System.out.print(tabla.Tabla.ImprimirTablaB(tablero, turnos, aux1, aux2));
              System.out.print("\nFicha inexistente.");
              existente = false;
              
            }
          }
          
        } while ((!existente) && (!vJ2));
        
        //Imprimimos la tabla con la ficha seleccionada subrayada//
        System.out.println(tabla.Tabla.ImprimirTablaSubrayadoB(tablero, turnos, columna, fila, aux1, aux2));
        
        ilegal = true; 
        
        //Comprobamos si el movimiento es posible//
        while ((ilegal) && (!vJ2)) {
          
          System.out.print("Declare donde desea mover la ficha o cancela el movimiento. \n(Tiene que ser un movimiento legal o escribe CANCELAR): ");
          objetivoFicha = s.nextLine();
          
          //comprobamos que no le haya dado al enter sin introducir un valor//
          if (objetivoFicha.equals("")) {
              
              System.out.print(tabla.Tabla.ImprimirTablaSubrayadoB(tablero, turnos, columna, fila, aux1, aux2));
              System.out.println("\nNo has introducido ningun valor.");
                          
          }
          
          //comprobamos que no haya introducida una unica letra o numero//
          else if (objetivoFicha.length() == 1) {
          
              System.out.print(tabla.Tabla.ImprimirTablaB(tablero, turnos, aux1, aux2));
              System.out.print("\nValor introducido no valido.");
                                          
          }
          
          else {
            
            
            columnaObjetivo = (int)(objetivoFicha.toLowerCase().charAt(0)) - 96;
            filaObjetivo = (int)(objetivoFicha.charAt(1)) - 48;
            
            objFiB = filaObjetivo;
            objCoB = columnaObjetivo;
            
            //comprobamos si queremos cambiar la ficha//
            if (objetivoFicha.toLowerCase().equals("cancelar")) {
              
              cancelar = true;
              ilegal = false;
              System.out.print(tabla.Tabla.ImprimirTablaB(tablero, turnos, aux1, aux2));
              
            }
            
            //comprobamos que este dentro del tablero//
            else if ((columnaObjetivo > 8) || (columnaObjetivo < 1) || (filaObjetivo > 8) || (filaObjetivo < 1)) {
              
              System.out.print(tabla.Tabla.ImprimirTablaSubrayadoB(tablero, turnos, columna, fila, aux1, aux2));
              System.out.println("\nMovimiento ilegal.");
              
            }
            
            //comprobamos si ha movido la ficha//
            else if ((fila == filaObjetivo) && (columna == columnaObjetivo)) {
              
              System.out.print(tabla.Tabla.ImprimirTablaSubrayadoB(tablero, turnos, columna, fila, aux1, aux2));
              System.out.println("\nTienes que mover la ficha.");
                  
            }
            
            //comprobamos si hay una ficha del mismo color en el objetivo//
            else if ((tablero[filaObjetivo][columnaObjetivo] == peonB) || (tablero[filaObjetivo][columnaObjetivo] == torreB) || (tablero[filaObjetivo][columnaObjetivo] == alfilB) 
          
              || (tablero[filaObjetivo][columnaObjetivo] == reinaB) || (tablero[filaObjetivo][columnaObjetivo] == reyB) || (tablero[filaObjetivo][columnaObjetivo] == caballoB)) {
              
              System.out.print(tabla.Tabla.ImprimirTablaSubrayadoB(tablero, turnos, columna, fila, aux1, aux2));
              System.out.println("\nMovimiento ilegal.");
              
            }
            
            //si la ficha seleccionada es una torre//
            else if (tablero[fila][columna] == torreB) {
              
              if (movimientos.MovimientosB.MovimientoTorre(tablero, fila, columna, filaObjetivo, columnaObjetivo)) {
                  
                aux[filaObjetivo][columnaObjetivo] = tablero[filaObjetivo][columnaObjetivo];
                
                //hacemos el cambio de ficha//
                tablero[filaObjetivo][columnaObjetivo] = tablero[fila][columna];
                tablero[fila][columna] = VACIO;  
                
                if (movimientos.MovimientosB.JaqueAlRey(tablero)) {
                  
                  tablero[filaObjetivo][columnaObjetivo] = aux[filaObjetivo][columnaObjetivo];
                  tablero[fila][columna] = torreB;  
                  System.out.println(tabla.Tabla.ImprimirTablaSubrayadoB(tablero, turnos, columna, fila, aux1, aux2));
                  System.out.println("Le hacen jaque."); 
                  
                }
                
                else {
                
                  ilegal = false;  
                  
                  if ((fila == 1) && (columna == 8)) {
                    
                    movTorreDB ++;
                    
                  }
                  
                  else if ((fila == 1) && (columna == 1)) {
                    
                    movTorreIB ++;
                    
                  }
                                                  
                  //Comprobamos si se ha comido una ficha//
                  aux1 = tabla.Tabla.FichasComidasB(tablero, aux1, ireinaB, itorreB, ialfilB, ipeonB, icaballoB);
                  aux2 = tabla.Tabla.FichasComidasN(tablero, aux2, ireinaN, itorreN, ialfilN, ipeonN, icaballoN);      
                  
                  System.out.print(tabla.Tabla.ImprimirTablaB(tablero, turnos, aux1, aux2));
                  Thread.sleep(1000);     
                  System.out.print(tabla.Tabla.ImprimirTablaN(tablero, turnos, aux1, aux2));
                  turno = true;
                }
              }
              
              else {
                
                System.out.print(tabla.Tabla.ImprimirTablaSubrayadoB(tablero, turnos, columna, fila, aux1, aux2));
                System.out.println("\nMovimiento ilegal.");
                
              }            
            }
            
            //si la ficha seleccionada es un peon//
            else if (tablero[fila][columna] == peonB) {
              
              if (movimientos.MovimientosB.MovimientoPeon(tablero, fila, columna, filaObjetivo, columnaObjetivo)) {
                  
                aux[filaObjetivo][columnaObjetivo] = tablero[filaObjetivo][columnaObjetivo];
                
                //hacemos el cambio de ficha//
                tablero[filaObjetivo][columnaObjetivo] = tablero[fila][columna];
                tablero[fila][columna] = VACIO; 
                
                if (filaObjetivo == 8) {
                  
                  if ((movimientos.MovimientosB.ConversionPeon(tablero, filaObjetivo, columnaObjetivo)) == reinaB) {
                    
                    ireinaB++;
                  }
                  
                  else if ((movimientos.MovimientosB.ConversionPeon(tablero, filaObjetivo, columnaObjetivo)) == torreB) {
                    
                    itorreB++;
                  }
                  
                  else if ((movimientos.MovimientosB.ConversionPeon(tablero, filaObjetivo, columnaObjetivo)) == alfilB) {
                    
                    ialfilB++;
                  }
                  
                  else if ((movimientos.MovimientosB.ConversionPeon(tablero, filaObjetivo, columnaObjetivo)) == caballoB) {
                    
                    icaballoB++;
                  }
                  
                }
                
                if (movimientos.MovimientosB.JaqueAlRey(tablero)) {
                  
                  tablero[filaObjetivo][columnaObjetivo] = aux[filaObjetivo][columnaObjetivo];
                  tablero[fila][columna] = peonB;  
                  System.out.println(tabla.Tabla.ImprimirTablaSubrayadoB(tablero, turnos, columna, fila, aux1, aux2));
                  System.out.println("Le hacen jaque.");
                  
                }
                
                else {
                  
                  ilegal = false;  
                  
                  //Comprobamos si se ha comido una ficha//
                  aux1 = tabla.Tabla.FichasComidasB(tablero, aux1, ireinaB, itorreB, ialfilB, ipeonB, icaballoB);
                  aux2 = tabla.Tabla.FichasComidasN(tablero, aux2, ireinaN, itorreN, ialfilN, ipeonN, icaballoN); 
                  
                  System.out.print(tabla.Tabla.ImprimirTablaB(tablero, turnos, aux1, aux2));
                  Thread.sleep(1000);          
                  System.out.print(tabla.Tabla.ImprimirTablaN(tablero, turnos, aux1, aux2));
                  turno = true;
                }
              }
              
              else if (movimientos.MovimientosB.CapturaEnMovimientoPeon(tablero, fila, columna, filaObjetivo, columnaObjetivo, posFiN, posCoN, objFiN, objCoN)) {
                
                aux[filaObjetivo][columnaObjetivo] = tablero[filaObjetivo][columnaObjetivo];
                
                //hacemos el cambio de ficha//
                tablero[filaObjetivo][columnaObjetivo] = tablero[fila][columna];
                tablero[fila][columna] = VACIO; 
                tablero[objFiN][objCoN] = VACIO;
                                
                if (movimientos.MovimientosB.JaqueAlRey(tablero)) {
                  
                  tablero[filaObjetivo][columnaObjetivo] = aux[filaObjetivo][columnaObjetivo];
                  tablero[fila][columna] = peonB;  
                  tablero[objFiN][objCoN] = peonN;
                  System.out.println(tabla.Tabla.ImprimirTablaSubrayadoB(tablero, turnos, columna, fila, aux1, aux2));
                  System.out.println("Le hacen jaque.");
                  
                }
                
                else {
                  
                  ilegal = false;  
                  
                  //Comprobamos si se ha comido una ficha//
                  aux1 = tabla.Tabla.FichasComidasB(tablero, aux1, ireinaB, itorreB, ialfilB, ipeonB, icaballoB);
                  aux2 = tabla.Tabla.FichasComidasN(tablero, aux2, ireinaN, itorreN, ialfilN, ipeonN, icaballoN); 
                  
                  System.out.print(tabla.Tabla.ImprimirTablaB(tablero, turnos, aux1, aux2));
                  Thread.sleep(1000);          
                  System.out.print(tabla.Tabla.ImprimirTablaN(tablero, turnos, aux1, aux2));
                  turno = true;
                }
                
              }
              
              else {
                
                System.out.print(tabla.Tabla.ImprimirTablaSubrayadoB(tablero, turnos, columna, fila, aux1, aux2));
                System.out.println("\nMovimiento ilegal.");
                
              }            
            }
              
            //si la ficha seleccionada es un caballo//
            else if (tablero[fila][columna] == caballoB) {
              
              if (movimientos.MovimientosB.MovimientoCaballo(tablero, fila, columna, filaObjetivo, columnaObjetivo)) {
                
                aux[filaObjetivo][columnaObjetivo] = tablero[filaObjetivo][columnaObjetivo];
                                            
                //hacemos el cambio de ficha//
                tablero[filaObjetivo][columnaObjetivo] = tablero[fila][columna];
                tablero[fila][columna] = VACIO; 
                
                if (movimientos.MovimientosB.JaqueAlRey(tablero)) {
                  
                  tablero[filaObjetivo][columnaObjetivo] = aux[filaObjetivo][columnaObjetivo];
                  tablero[fila][columna] = caballoB;  
                  System.out.println(tabla.Tabla.ImprimirTablaSubrayadoB(tablero, turnos, columna, fila, aux1, aux2));
                  System.out.println("Le hacen jaque.");  
                  
                }
                
                else {
                
                  ilegal = false;
                  
                  //Comprobamos si se ha comido una ficha//
                  aux1 = tabla.Tabla.FichasComidasB(tablero, aux1, ireinaB, itorreB, ialfilB, ipeonB, icaballoB);
                  aux2 = tabla.Tabla.FichasComidasN(tablero, aux2, ireinaN, itorreN, ialfilN, ipeonN, icaballoN); 
                   
                  System.out.print(tabla.Tabla.ImprimirTablaB(tablero, turnos, aux1, aux2));
                  Thread.sleep(1000);            
                  System.out.print(tabla.Tabla.ImprimirTablaN(tablero, turnos, aux1, aux2));
                  turno = true;
                }
              }        
              
              else {
                
                System.out.print(tabla.Tabla.ImprimirTablaSubrayadoB(tablero, turnos, columna, fila, aux1, aux2));
                System.out.println("\nMovimiento ilegal.");
                
              }  
            }
            
            //si la ficha seleccionada es un alfil//
            else if (tablero[fila][columna] == alfilB) {
              
              if (movimientos.MovimientosB.MovimientoAlfil(tablero, fila, columna, filaObjetivo, columnaObjetivo)) {
                
                aux[filaObjetivo][columnaObjetivo] = tablero[filaObjetivo][columnaObjetivo];
                        
                //hacemos el cambio de ficha//
                tablero[filaObjetivo][columnaObjetivo] = tablero[fila][columna];
                tablero[fila][columna] = VACIO; 
                
                if (movimientos.MovimientosB.JaqueAlRey(tablero)) {
                  
                  tablero[filaObjetivo][columnaObjetivo] = aux[filaObjetivo][columnaObjetivo];
                  tablero[fila][columna] = alfilB;  
                  System.out.println(tabla.Tabla.ImprimirTablaSubrayadoB(tablero, turnos, columna, fila, aux1, aux2));
                  System.out.println("Le hacen jaque.");  
                  
                }
                
                else {
                             
                  ilegal = false; 
                  
                 //Comprobamos si se ha comido una ficha//
                  aux1 = tabla.Tabla.FichasComidasB(tablero, aux1, ireinaB, itorreB, ialfilB, ipeonB, icaballoB);
                  aux2 = tabla.Tabla.FichasComidasN(tablero, aux2, ireinaN, itorreN, ialfilN, ipeonN, icaballoN); 
                  
                  System.out.print(tabla.Tabla.ImprimirTablaB(tablero, turnos, aux1, aux2));
                  Thread.sleep(1000);              
                  System.out.print(tabla.Tabla.ImprimirTablaN(tablero, turnos, aux1, aux2));
                  turno = true;
                }
              }
              
              else {
                
                System.out.print(tabla.Tabla.ImprimirTablaSubrayadoB(tablero, turnos, columna, fila, aux1, aux2));
                System.out.println("\nMovimiento ilegal.");
                
              }
            }
            
            //si la ficha seleccionada es la reina//
            else if (tablero[fila][columna] == reinaB) {
              
              if (movimientos.MovimientosB.MovimientoReina(tablero, fila, columna, filaObjetivo, columnaObjetivo)) {
                
                aux[filaObjetivo][columnaObjetivo] = tablero[filaObjetivo][columnaObjetivo];
                
                //hacemos el cambio de ficha//
                tablero[filaObjetivo][columnaObjetivo] = tablero[fila][columna];
                tablero[fila][columna] = VACIO; 
                
                if (movimientos.MovimientosB.JaqueAlRey(tablero)) {
                  
                  tablero[filaObjetivo][columnaObjetivo] = aux[filaObjetivo][columnaObjetivo];
                  tablero[fila][columna] = reinaB;  
                  System.out.println(tabla.Tabla.ImprimirTablaSubrayadoB(tablero, turnos, columna, fila, aux1, aux2));
                  System.out.println("Le hacen jaque.");
                  
                }
                
                else {
                               
                  ilegal = false; 
                  
                  //Comprobamos si se ha comido una ficha//
                  aux1 = tabla.Tabla.FichasComidasB(tablero, aux1, ireinaB, itorreB, ialfilB, ipeonB, icaballoB);
                  aux2 = tabla.Tabla.FichasComidasN(tablero, aux2, ireinaN, itorreN, ialfilN, ipeonN, icaballoN); 
                  
                  System.out.print(tabla.Tabla.ImprimirTablaB(tablero, turnos, aux1, aux2));
                  Thread.sleep(1000);
                  System.out.print(tabla.Tabla.ImprimirTablaN(tablero, turnos, aux1, aux2));
                  turno = true;
                }
              }
              
              else {
                
                System.out.print(tabla.Tabla.ImprimirTablaSubrayadoB(tablero, turnos, columna, fila, aux1, aux2));
                System.out.println("\nMovimiento ilegal.");
                
              }          
            }
            
            //si la ficha seleccionada es el rey//
            else if (tablero[fila][columna] == reyB) {
              
              //Comprobamos enroque hacia la derecha//
              if (movimientos.MovimientosB.EnroqueD(tablero, fila, columna, filaObjetivo, columnaObjetivo, movReyB, movTorreDB)) {
                
                tablero[1][7] = reyB; 
                tablero[1][5] = VACIO;
                tablero[1][6] = torreB;
                tablero[1][8] = VACIO;
                
                if (movimientos.MovimientosB.JaqueAlRey(tablero)) {
                  
                  tablero[1][7] = VACIO; 
                  tablero[1][5] = reyB;
                  tablero[1][6] = VACIO;
                  tablero[1][8] = torreB;
                  System.out.println(tabla.Tabla.ImprimirTablaSubrayadoB(tablero, turnos, columna, fila, aux1, aux2));
                  System.out.println("Le hacen jaque.");
                }
                
                else {
                               
                  ilegal = false;
                  movReyB ++;
                  movTorreDB ++;                                     
                  System.out.print(tabla.Tabla.ImprimirTablaB(tablero, turnos, aux1, aux2));
                  Thread.sleep(1000);                  
                  System.out.print(tabla.Tabla.ImprimirTablaN(tablero, turnos, aux1, aux2));
                  turno = true;
                }                
              }
              
              //Comprobamos enroque hacia la izquierda//
              else if (movimientos.MovimientosB.EnroqueI(tablero, fila, columna, filaObjetivo, columnaObjetivo, movReyB, movTorreIB)) {
                
                tablero[1][3] = reyB; 
                tablero[1][5] = VACIO;
                tablero[1][4] = torreB;
                tablero[1][1] = VACIO;
                
                if (movimientos.MovimientosB.JaqueAlRey(tablero)) {
                  
                  tablero[1][3] = VACIO; 
                  tablero[1][5] = reyB;
                  tablero[1][4] = VACIO;
                  tablero[1][1] = torreB;
                  System.out.println(tabla.Tabla.ImprimirTablaSubrayadoB(tablero, turnos, columna, fila, aux1, aux2));
                  System.out.println("Le hacen jaque.");
                }
                
                else {
                               
                  ilegal = false;
                  movReyB ++;
                  movTorreIB ++;                                     
                  System.out.print(tabla.Tabla.ImprimirTablaB(tablero, turnos, aux1, aux2));
                  Thread.sleep(1000);                  
                  System.out.print(tabla.Tabla.ImprimirTablaN(tablero, turnos, aux1, aux2));
                  turno = true;
                }                
              }
              
              else if (movimientos.MovimientosB.MovimientoRey(tablero, fila, columna, filaObjetivo, columnaObjetivo)) {
                              
                aux[filaObjetivo][columnaObjetivo] = tablero[filaObjetivo][columnaObjetivo];
                
                //hacemos el cambio de ficha//
                tablero[filaObjetivo][columnaObjetivo] = tablero[fila][columna];
                tablero[fila][columna] = VACIO; 
                
                if (movimientos.MovimientosB.JaqueAlRey(tablero)) {
                  
                  tablero[filaObjetivo][columnaObjetivo] = aux[filaObjetivo][columnaObjetivo];
                  tablero[fila][columna] = reyB;  
                  System.out.println(tabla.Tabla.ImprimirTablaSubrayadoB(tablero, turnos, columna, fila, aux1, aux2));
                  System.out.println("Le hacen jaque.");
                  
                }
                
                else {
                               
                  ilegal = false;
                  movReyB ++;    
                  
                  //Comprobamos si se ha comido una ficha//
                  aux1 = tabla.Tabla.FichasComidasB(tablero, aux1, ireinaB, itorreB, ialfilB, ipeonB, icaballoB);
                  aux2 = tabla.Tabla.FichasComidasN(tablero, aux2, ireinaN, itorreN, ialfilN, ipeonN, icaballoN); 
                  
                  System.out.print(tabla.Tabla.ImprimirTablaB(tablero, turnos, aux1, aux2));
                  Thread.sleep(1000);                  
                  System.out.print(tabla.Tabla.ImprimirTablaN(tablero, turnos, aux1, aux2));
                  turno = true;
                }
              } 
              
              else {
                
                System.out.print(tabla.Tabla.ImprimirTablaSubrayadoB(tablero, turnos, columna, fila, aux1, aux2));
                System.out.println("\nMovimiento ilegal.");
                
              }         
            }
          }
        }
      }
      
      turno = false;
      cancelar = true;
      
      //buscamos la posicion del rey//
      for(y = 1; y < 9; y++) {
        
        for (x = 1; x < 9; x++) {
            
          if (tablero[y][x] == reyN) {
            
            fila = y;
            columna = x;
          }          
        }
      }
      
      if ((ipeonN + ialfilN + itorreN + icaballoN + ireinaN) < 1) {
        
        vJ2 = true;
        vJ1 = true;
      }
      
      //COMPROBAMOS SI HAY JAQUE MATE//
      if (movimientos.MovimientosN.JaqueAlRey(tablero)) {
        
        //derecha//
        if ((tablero[fila][columna + 1] == VACIO) || ((tablero[fila][columna + 1] == peonB) || (tablero[fila][columna + 1] == alfilB) || (tablero[fila][columna + 1] == torreB) 
        
        || (tablero[fila][columna + 1] == caballoB) || (tablero[fila][columna + 1] == reinaB))) {
           
          aux[fila][columna + 1] = tablero[fila][columna + 1]; 
          
          //hacemos el cambio de ficha//
          tablero[fila][columna + 1] = reyN;
          tablero[fila][columna] = VACIO; 
          
          if (movimientos.MovimientosN.JaqueAlRey(tablero)) {
                
              jaquemate ++;
          }    
          
          tablero[fila][columna + 1] = aux[fila][columna + 1];
          tablero[fila][columna] = reyN;
                  
        }
        
        else {
          
          jaquemate ++;
          
        }
        
        // izquierda//
        if ((tablero[fila][columna - 1] == VACIO) || ((tablero[fila][columna - 1] == peonB) || (tablero[fila][columna - 1] == alfilB) || (tablero[fila][columna - 1] == torreB) 
        
        || (tablero[fila][columna - 1] == caballoB) || (tablero[fila][columna - 1] == reinaB))) {
          
          aux[fila][columna - 1] = tablero[fila][columna - 1];
          
          //hacemos el cambio de ficha//
          tablero[fila][columna - 1] = reyN;
          tablero[fila][columna] = VACIO; 
          
          if (movimientos.MovimientosN.JaqueAlRey(tablero)) {
                                  
                jaquemate ++;
          } 
          
          tablero[fila][columna - 1] = aux[fila][columna - 1];
          tablero[fila][columna] = reyN;
          
        }
        
        else {
          
          jaquemate ++;
          
        }
        
        //arriba a la derecha//
        if ((tablero[fila + 1][columna + 1] == VACIO) || ((tablero[fila + 1][columna + 1] == peonB) || (tablero[fila +1][columna + 1] == alfilB) || (tablero[fila + 1][columna + 1] == torreB) 
        
        || (tablero[fila + 1][columna + 1] == caballoB) || (tablero[fila + 1][columna + 1] == reinaB))) {
          
          aux[fila + 1][columna + 1] = tablero[fila + 1][columna + 1];
          
          //hacemos el cambio de ficha//
          tablero[fila + 1][columna + 1] = reyN;
          tablero[fila][columna] = VACIO; 
          
          if (movimientos.MovimientosN.JaqueAlRey(tablero)) {
                                  
                jaquemate ++;
          }             
          
          tablero[fila + 1][columna + 1] = aux[fila + 1][columna + 1];
          tablero[fila][columna] = reyN;
          
        }
        
        else {
          
          jaquemate ++;
          
        }
        
        //abajo a la derecha//
        if ((tablero[fila - 1][columna + 1] == VACIO) || ((tablero[fila - 1][columna + 1] == peonB) || (tablero[fila - 1][columna + 1] == alfilB) || (tablero[fila - 1][columna + 1] == torreB) 
        
        || (tablero[fila - 1][columna + 1] == caballoB) || (tablero[fila - 1][columna + 1] == reinaB))) {
          
          aux[fila - 1][columna + 1] = tablero[fila - 1][columna + 1];
          
          //hacemos el cambio de ficha//
          tablero[fila - 1][columna + 1] = reyN;
          tablero[fila][columna] = VACIO; 
          
          if (movimientos.MovimientosN.JaqueAlRey(tablero)) {
                                  
                jaquemate ++;
          }     
          
          tablero[fila - 1][columna + 1] = aux[fila - 1][columna + 1];
          tablero[fila][columna] = reyN;
                  
        }
        
        else {
          
          jaquemate ++;
          
        }
        
        //abajo//
        if ((tablero[fila - 1][columna] == VACIO) || ((tablero[fila - 1][columna] == peonB) || (tablero[fila - 1][columna] == alfilB) || (tablero[fila - 1][columna] == torreB) 
        
        || (tablero[fila - 1][columna] == caballoB) || (tablero[fila - 1][columna] == reinaB))) {
          
          aux[fila - 1][columna] = tablero[fila - 1][columna];
          
          //hacemos el cambio de ficha//
          tablero[fila -1][columna] = reyN;
          tablero[fila][columna] = VACIO; 
          
          if (movimientos.MovimientosN.JaqueAlRey(tablero)) {
                                  
                jaquemate ++;
          }             
          
          tablero[fila - 1][columna] = aux[fila - 1][columna];
          tablero[fila][columna] = reyN;
          
        }
        
        else {
          
          jaquemate ++;
          
        }
        
        //arriba//
        if ((tablero[fila + 1][columna] == VACIO) || ((tablero[fila + 1][columna] == peonB) || (tablero[fila + 1][columna] == alfilB) || (tablero[fila + 1][columna] == torreB) 
        
        || (tablero[fila + 1][columna] == caballoB) || (tablero[fila + 1][columna] == reinaB))) {
          
          aux[fila + 1][columna] = tablero[fila + 1][columna];
          
          //hacemos el cambio de ficha//
          tablero[fila + 1][columna] = reyN;
          tablero[fila][columna] = VACIO; 
          
          if (movimientos.MovimientosN.JaqueAlRey(tablero)) {
                                  
                jaquemate ++;
          }    
          
          tablero[fila + 1][columna] = aux[fila + 1][columna];
          tablero[fila][columna] = reyN;
                   
        }
        
        else {
          
          jaquemate ++;
          
        }
        
        //abajo a la izquierda//
        if ((tablero[fila - 1][columna - 1] == VACIO) || ((tablero[fila - 1][columna - 1] == peonB) || (tablero[fila - 1][columna - 1] == alfilB) || (tablero[fila - 1][columna - 1] == torreB) 
        
        || (tablero[fila - 1][columna - 1] == caballoB) || (tablero[fila - 1][columna - 1] == reinaB))) {

          aux[fila - 1][columna - 1] = tablero[fila - 1][columna - 1];
          
          //hacemos el cambio de ficha//
          tablero[fila - 1][columna - 1] = reyN;
          tablero[fila][columna] = VACIO; 
          
          if (movimientos.MovimientosN.JaqueAlRey(tablero)) {
                                  
                jaquemate ++;
          }     
          
          tablero[fila - 1][columna - 1] = aux[fila - 1][columna - 1];
          tablero[fila][columna] = reyN;
                  
        }
        
        else {
          
          jaquemate ++;
          
        }
        
        //arriba a la izquierda//
        if ((tablero[fila + 1][columna - 1] == VACIO) || ((tablero[fila + 1][columna - 1] == peonB) || (tablero[fila + 1][columna - 1] == alfilB) || (tablero[fila + 1][columna - 1] == torreB) 
        
        || (tablero[fila + 1][columna - 1] == caballoB) || (tablero[fila + 1][columna - 1] == reinaB))) {
          
          aux[fila + 1][columna - 1] = tablero[fila + 1][columna - 1];
          
          //hacemos el cambio de ficha//
          tablero[fila + 1][columna - 1] = reyN;
          tablero[fila][columna] = VACIO; 
          
          if (movimientos.MovimientosN.JaqueAlRey(tablero)) {
                                  
                jaquemate ++;
          }
        
          tablero[fila + 1][columna - 1] = aux[fila + 1][columna - 1];
          tablero[fila][columna] = reyN;
          
        }
        
        else {
          
          jaquemate ++;
          
        }
          
        if (jaquemate == 8) {
          
          vJ1 = true;
          
          //COMPROBAMOS SI PUEDE BLOQUEAR EL JAQUE//
          coordinadasJaque = (movimientos.MovimientosN.PosicionesEntreJaque(tablero));
          
          //Vemos si hay alguna ficha que se pueda comer la ficha haciendo el jaque//                                           
          for (int i = 1; ((i < 9) && (vJ1)); i++) {
            
            for (int j = 1; j < 9; j++) {
              
              x = columna;
              g = fila;
              
              filaObjetivo = coordinadasJaque[0];
              columnaObjetivo = coordinadasJaque[1];
              fO = filaObjetivo;
              cO = columnaObjetivo;
             
              if (tablero[i][j] == torreN) {
                
                fila = i;
                columna = j;
                
                if (movimientos.MovimientosN.MovimientoTorre (tablero, fila, columna, filaObjetivo, columnaObjetivo)) {
                  
                  aux[fila][columna] = tablero[filaObjetivo][columnaObjetivo];
          
                  //hacemos el cambio de ficha//
                  tablero[filaObjetivo][columnaObjetivo] = torreN;
                  tablero[fila][columna] = VACIO; 
                  
                  if (movimientos.MovimientosN.JaqueAlRey(tablero)) {} 
                  
                  else { 
                    
                    vJ1 = false;
                  } 
                  
                  tablero[fila][columna] = torreN; 
                  tablero[filaObjetivo][columnaObjetivo] = aux[fila][columna];
                  
                }
                
                //Si no es posible vemos si esta ficha puede bloquearlo//
                else {
                  
                  for (y = g + 1; ((y < fO) && (vJ2)); y++) {
            
                    if (x < cO) {
                      
                      x ++;
                    }
                    
                    filaObjetivo = y;
                    columnaObjetivo = x; 
                    
                    if ((movimientos.MovimientosN.MovimientoTorre (tablero, fila, columna, filaObjetivo, columnaObjetivo))
                    
                    && (tablero[coordinadasJaque[0]][coordinadasJaque[1]] != caballoB)) {
                      
                      aux[fila][columna] = tablero[filaObjetivo][columnaObjetivo];
                      
                      //hacemos el cambio de ficha//
                      tablero[filaObjetivo][columnaObjetivo] = torreN;
                      tablero[fila][columna] = VACIO; 
                      
                      if (movimientos.MovimientosN.JaqueAlRey(tablero)) {} 
                      
                      else { 
                        
                        vJ1 = false;
                      } 
                      
                      tablero[fila][columna] = torreN; 
                      tablero[filaObjetivo][columnaObjetivo] = aux[fila][columna];
                      
                    }                  
                  }              
                }
              }
              
              else if (tablero[i][j] == alfilN) {
                
                fila = i;
                columna = j;
                
                if (movimientos.MovimientosN.MovimientoAlfil (tablero, fila, columna, filaObjetivo, columnaObjetivo)) {
                  
                  aux[fila][columna] = tablero[filaObjetivo][columnaObjetivo];
                  
                  //hacemos el cambio de ficha//
                  tablero[filaObjetivo][columnaObjetivo] = alfilN;
                  tablero[fila][columna] = VACIO; 
                  
                  if (movimientos.MovimientosN.JaqueAlRey(tablero)) {} 
                  
                  else { 
                    
                    vJ1 = false;
                  } 
                  
                  tablero[fila][columna] = alfilN; 
                  tablero[filaObjetivo][columnaObjetivo] = aux[fila][columna];
                  
                }
                
                //Si no es posible vemos si esta ficha puede bloquearlo//
                else {
                  
                  for (y = g + 1; ((y < fO) && (vJ2)); y++) {
            
                    if (x < cO) {
                      
                      x ++;
                    }
                    
                    filaObjetivo = y;
                    columnaObjetivo = x; 
                    
                    if ((movimientos.MovimientosN.MovimientoAlfil (tablero, fila, columna, filaObjetivo, columnaObjetivo)) 
                    
                    && (tablero[coordinadasJaque[0]][coordinadasJaque[1]] != caballoB)) {
                      
                      aux[fila][columna] = tablero[filaObjetivo][columnaObjetivo];
                      
                      //hacemos el cambio de ficha//
                      tablero[filaObjetivo][columnaObjetivo] = alfilN;
                      tablero[fila][columna] = VACIO; 
                      
                      if (movimientos.MovimientosN.JaqueAlRey(tablero)) {} 
                      
                      else { 
                        
                        vJ1 = false;
                      } 
                      
                      tablero[fila][columna] = alfilN; 
                      tablero[filaObjetivo][columnaObjetivo] = aux[fila][columna];
                          
                    }                
                  }
                }
              }
                
              else if (tablero[i][j] == peonN) {
                
                fila = i;
                columna = j;
                
                if (movimientos.MovimientosN.MovimientoPeon (tablero, fila, columna, filaObjetivo, columnaObjetivo)) {
                  
                  aux[fila][columna] = tablero[filaObjetivo][columnaObjetivo];
                  
                  //hacemos el cambio de ficha//
                  tablero[filaObjetivo][columnaObjetivo] = peonN;
                  tablero[fila][columna] = VACIO; 
                  
                  if (movimientos.MovimientosN.JaqueAlRey(tablero)) {} 
                  
                  else { 
                    
                    vJ1 = false;
                  } 
                  
                  tablero[fila][columna] = peonN; 
                  tablero[filaObjetivo][columnaObjetivo] = aux[fila][columna];
                  
                }
                //Si no es posible vemos si esta ficha puede bloquearlo//
                else {
                  
                  for (y = g + 1; ((y < fO) && (vJ2)); y++) {
            
                    if (x < cO) {
                      
                      x ++;
                    }
                    
                    filaObjetivo = y;
                    columnaObjetivo = x; 
                    
                    if ((movimientos.MovimientosN.MovimientoPeon (tablero, fila, columna, filaObjetivo, columnaObjetivo)) 
                    
                    && (tablero[coordinadasJaque[0]][coordinadasJaque[1]] != caballoB)) {
                      
                      aux[fila][columna] = tablero[filaObjetivo][columnaObjetivo];
                      
                      //hacemos el cambio de ficha//
                      tablero[filaObjetivo][columnaObjetivo] = peonN;
                      tablero[fila][columna] = VACIO; 
                      
                      if (movimientos.MovimientosN.JaqueAlRey(tablero)) {} 
                      
                      else { 
                        
                        vJ1 = false;
                      } 
                      
                      tablero[fila][columna] = peonN; 
                      tablero[filaObjetivo][columnaObjetivo] = aux[fila][columna];
                      
                    }                
                  }
                }
              }
                
              else if (tablero[i][j] == caballoN) {
                
                fila = i;
                columna = j;
                
                if (movimientos.MovimientosN.MovimientoCaballo (tablero, fila, columna, filaObjetivo, columnaObjetivo)) {
                  
                  aux[fila][columna] = tablero[filaObjetivo][columnaObjetivo];
                      
                  //hacemos el cambio de ficha//
                  tablero[filaObjetivo][columnaObjetivo] = caballoN;
                  tablero[fila][columna] = VACIO; 
                  
                  if (movimientos.MovimientosN.JaqueAlRey(tablero)) {} 
                  
                  else { 
                    
                    vJ1 = false;
                  } 
                  
                  tablero[fila][columna] = caballoN; 
                  tablero[filaObjetivo][columnaObjetivo] = aux[fila][columna];
              
                }
                //Si no es posible vemos si esta ficha puede bloquearlo//
                else {
                  
                  for (y = g + 1; ((y < fO) && (vJ2)); y++) {
            
                    if (x < cO) {
                      
                      x ++;
                    }
                    
                    filaObjetivo = y;
                    columnaObjetivo = x; 
                    
                    if ((movimientos.MovimientosN.MovimientoCaballo (tablero, fila, columna, filaObjetivo, columnaObjetivo))
                    
                    && (tablero[coordinadasJaque[0]][coordinadasJaque[1]] != caballoB)) {
                  
                      aux[fila][columna] = tablero[filaObjetivo][columnaObjetivo];
                      
                      //hacemos el cambio de ficha//
                      tablero[filaObjetivo][columnaObjetivo] = caballoN;
                      tablero[fila][columna] = VACIO; 
                      
                      if (movimientos.MovimientosN.JaqueAlRey(tablero)) {} 
                      
                      else { 
                        
                        vJ1 = false;
                      } 
                      
                      tablero[fila][columna] = caballoN; 
                      tablero[filaObjetivo][columnaObjetivo] = aux[fila][columna];
                      
                    }
                  }              
                }
              }
                
              else if (tablero[i][j] == reinaN) {
                
                fila = i;
                columna = j;
                
                if (movimientos.MovimientosN.MovimientoReina (tablero, fila, columna, filaObjetivo, columnaObjetivo)) {
                  
                  aux[fila][columna] = tablero[filaObjetivo][columnaObjetivo];
                      
                    //hacemos el cambio de ficha//
                    tablero[filaObjetivo][columnaObjetivo] = reinaN;
                    tablero[fila][columna] = VACIO; 
                    
                    if (movimientos.MovimientosN.JaqueAlRey(tablero)) {} 
                    
                    else { 
                      
                      vJ1 = false;
                    } 
                    
                    tablero[fila][columna] = reinaN; 
                    tablero[filaObjetivo][columnaObjetivo] = aux[fila][columna];
                  
                }
                
                //Si no es posible vemos si esta ficha puede bloquearlo//
                else {
                  
                  for (y = g + 1; ((y < fO) && (vJ2)); y++) {
            
                    if (x < cO) {
                      
                      x ++;
                    }
                    
                    filaObjetivo = y;
                    columnaObjetivo = x; 
                                          
                    if ((movimientos.MovimientosN.MovimientoReina (tablero, fila, columna, filaObjetivo, columnaObjetivo)) 
                    
                    && (tablero[coordinadasJaque[0]][coordinadasJaque[1]] != caballoB)) {
                  
                      aux[fila][columna] = tablero[filaObjetivo][columnaObjetivo];
                      
                      //hacemos el cambio de ficha//
                      tablero[filaObjetivo][columnaObjetivo] = reinaN;
                      tablero[fila][columna] = VACIO; 
                      
                      if (movimientos.MovimientosN.JaqueAlRey(tablero)) {} 
                      
                      else { 
                        
                        vJ1 = false;
                      } 
                      
                      tablero[fila][columna] = reinaN; 
                      tablero[filaObjetivo][columnaObjetivo] = aux[fila][columna];
                      
                    }
                  }
                }
              }                
            }
          } 
          
          if (vJ1) { 
              
              System.out.print("\nJaque mate.");
              
          }            
        }          
      }
      
      jaquemate = 0;
      
      //COMPROBAMOS SI HA SIDO AHOGADO//
      if ((!vJ1) && (!vJ2)) {
        
        vJ2 = true;
        vJ1 = true;
        
        for (y = 1; ((y < 9) && (vJ1) && (vJ2)); y++) {
          
          for (x = 1; x < 9; x++) {
            
            fila = y;
            columna = x;
            
            if (tablero[y][x] == torreN) {
              
              for (int i = 1; ((i < 9) && (vJ1) && (vJ2)); i++) {
          
                for (int j = 1; j < 9; j++) {
                  
                  columnaObjetivo = j;
                  filaObjetivo = i;
                  
                  if ((tablero[filaObjetivo][columnaObjetivo] == peonN) || (tablero[filaObjetivo][columnaObjetivo] == torreN) || (tablero[filaObjetivo][columnaObjetivo] == alfilN) 
          
                  || (tablero[filaObjetivo][columnaObjetivo] == reinaN) || (tablero[filaObjetivo][columnaObjetivo] == reyN) || (tablero[filaObjetivo][columnaObjetivo] == caballoN)) {}
                  
                  else if (movimientos.MovimientosN.MovimientoTorre (tablero, fila, columna, filaObjetivo, columnaObjetivo)) {
                    
                    aux[fila][columna] = tablero[filaObjetivo][columnaObjetivo];
                      
                    //hacemos el cambio de ficha//
                    tablero[filaObjetivo][columnaObjetivo] = torreN;
                    tablero[fila][columna] = VACIO; 
                    
                    if (movimientos.MovimientosN.JaqueAlRey(tablero)) {} 
                    
                    else { 
                      
                      vJ1 = false;
                      vJ2 = false;
                    } 
                    
                    tablero[fila][columna] = torreN; 
                    tablero[filaObjetivo][columnaObjetivo] = aux[fila][columna];                    
                  }
                }
              }
            }
            
            else if (tablero[y][x] == alfilN) {
              
              for (int i = 1; ((i < 9) && (vJ1) && (vJ2)); i++) {
          
                for (int j = 1; j < 9; j++) {
                  
                  columnaObjetivo = j;
                  filaObjetivo = i;
                  
                  if ((tablero[filaObjetivo][columnaObjetivo] == peonN) || (tablero[filaObjetivo][columnaObjetivo] == torreN) || (tablero[filaObjetivo][columnaObjetivo] == alfilN) 
          
                  || (tablero[filaObjetivo][columnaObjetivo] == reinaN) || (tablero[filaObjetivo][columnaObjetivo] == reyN) || (tablero[filaObjetivo][columnaObjetivo] == caballoN)) {}
                  
                  else if (movimientos.MovimientosN.MovimientoAlfil (tablero, fila, columna, filaObjetivo, columnaObjetivo)) {
                    
                    aux[fila][columna] = tablero[filaObjetivo][columnaObjetivo];
                      
                    //hacemos el cambio de ficha//
                    tablero[filaObjetivo][columnaObjetivo] = alfilN;
                    tablero[fila][columna] = VACIO; 
                    
                    if (movimientos.MovimientosN.JaqueAlRey(tablero)) {} 
                    
                    else { 
                      
                      vJ1 = false;
                      vJ2 = false;
                    } 
                    
                    tablero[fila][columna] = alfilN; 
                    tablero[filaObjetivo][columnaObjetivo] = aux[fila][columna]; 
                    
                  }
                }
              }
            }
            
            else if (tablero[y][x] == caballoN) {
              
              for (int i = 1; ((i < 9) && (vJ1) && (vJ2)); i++) {
          
                for (int j = 1; j < 9; j++) {
                  
                  columnaObjetivo = j;
                  filaObjetivo = i;
                  
                  if ((tablero[filaObjetivo][columnaObjetivo] == peonN) || (tablero[filaObjetivo][columnaObjetivo] == torreN) || (tablero[filaObjetivo][columnaObjetivo] == alfilN) 
          
                  || (tablero[filaObjetivo][columnaObjetivo] == reinaN) || (tablero[filaObjetivo][columnaObjetivo] == reyN) || (tablero[filaObjetivo][columnaObjetivo] == caballoN)) {}
                  
                  else if (movimientos.MovimientosN.MovimientoCaballo (tablero, fila, columna, filaObjetivo, columnaObjetivo)) {
                    
                    aux[fila][columna] = tablero[filaObjetivo][columnaObjetivo];
                      
                    //hacemos el cambio de ficha//
                    tablero[filaObjetivo][columnaObjetivo] = caballoN;
                    tablero[fila][columna] = VACIO; 
                    
                    if (movimientos.MovimientosN.JaqueAlRey(tablero)) {} 
                    
                    else { 
                      
                      vJ1 = false;
                      vJ2 = false;
                    } 
                    
                    tablero[fila][columna] = caballoN; 
                    tablero[filaObjetivo][columnaObjetivo] = aux[fila][columna]; 
                    
                  }
                }
              }
            }
            
            else if (tablero[y][x] == peonN) {
              
              for (int i = 1; ((i < 9) && (vJ1) && (vJ2)); i++) {
          
                for (int j = 1; j < 9; j++) {
                  
                  columnaObjetivo = j;
                  filaObjetivo = i;
                  
                  if ((tablero[filaObjetivo][columnaObjetivo] == peonN) || (tablero[filaObjetivo][columnaObjetivo] == torreN) || (tablero[filaObjetivo][columnaObjetivo] == alfilN) 
          
                  || (tablero[filaObjetivo][columnaObjetivo] == reinaN) || (tablero[filaObjetivo][columnaObjetivo] == reyN) || (tablero[filaObjetivo][columnaObjetivo] == caballoN)) {}
                  
                  else if (movimientos.MovimientosN.MovimientoPeon (tablero, fila, columna, filaObjetivo, columnaObjetivo)) {
                    
                    aux[fila][columna] = tablero[filaObjetivo][columnaObjetivo];
                      
                    //hacemos el cambio de ficha//
                    tablero[filaObjetivo][columnaObjetivo] = peonN;
                    tablero[fila][columna] = VACIO; 
                    
                    if (movimientos.MovimientosN.JaqueAlRey(tablero)) {} 
                    
                    else { 
                      
                      vJ1 = false;
                      vJ2 = false;
                    } 
                    
                    tablero[fila][columna] = peonN; 
                    tablero[filaObjetivo][columnaObjetivo] = aux[fila][columna]; 
                    
                  }
                }
              }
            }
            
            else if (tablero[y][x] == reinaN) {
              
              for (int i = 1; ((i < 9) && (vJ1) && (vJ2)); i++) {
          
                for (int j = 1; j < 9; j++) {
                  
                  columnaObjetivo = j;
                  filaObjetivo = i;
                  
                  if ((tablero[filaObjetivo][columnaObjetivo] == peonN) || (tablero[filaObjetivo][columnaObjetivo] == torreN) || (tablero[filaObjetivo][columnaObjetivo] == alfilN) 
          
                  || (tablero[filaObjetivo][columnaObjetivo] == reinaN) || (tablero[filaObjetivo][columnaObjetivo] == reyN) || (tablero[filaObjetivo][columnaObjetivo] == caballoN)) {}
                  
                  else if (movimientos.MovimientosN.MovimientoReina (tablero, fila, columna, filaObjetivo, columnaObjetivo)) {
                    
                    aux[fila][columna] = tablero[filaObjetivo][columnaObjetivo];
                      
                    //hacemos el cambio de ficha//
                    tablero[filaObjetivo][columnaObjetivo] = reinaN;
                    tablero[fila][columna] = VACIO; 
                    
                    if (movimientos.MovimientosN.JaqueAlRey(tablero)) {} 
                    
                    else { 
                      
                      vJ1 = false;
                      vJ2 = false;
                    } 
                    
                    tablero[fila][columna] = reinaN; 
                    tablero[filaObjetivo][columnaObjetivo] = aux[fila][columna]; 
                    
                  }
                }
              }
            }
            
            else if (tablero[y][x] == reyN) {
              
              for (int i = 1; ((i < 9) && (vJ1) && (vJ2)); i++) {
          
                for (int j = 1; j < 9; j++) {
                  
                  columnaObjetivo = j;
                  filaObjetivo = i;
                  
                  if ((tablero[filaObjetivo][columnaObjetivo] == peonN) || (tablero[filaObjetivo][columnaObjetivo] == torreN) || (tablero[filaObjetivo][columnaObjetivo] == alfilN) 
          
                  || (tablero[filaObjetivo][columnaObjetivo] == reinaN) || (tablero[filaObjetivo][columnaObjetivo] == reyN) || (tablero[filaObjetivo][columnaObjetivo] == caballoN)) {}
                  
                  else if (movimientos.MovimientosN.MovimientoRey (tablero, fila, columna, filaObjetivo, columnaObjetivo)) {
                    
                    aux[filaObjetivo][columnaObjetivo] = tablero[filaObjetivo][columnaObjetivo];
                    
                    tablero[filaObjetivo][columnaObjetivo] = tablero[fila][columna];
                    tablero[fila][columna] = VACIO;
                    
                    if (movimientos.MovimientosN.JaqueAlRey(tablero)) {}
                    
                    else {
                      
                      vJ1 = false;
                      vJ2 = false;
                      
                    }
                  
                    tablero[filaObjetivo][columnaObjetivo] = aux[filaObjetivo][columnaObjetivo];
                    tablero[fila][columna] = reyN;                    
                  }
                }
              }
            }
          }
        }
      }
      
            
      
      //Turno Jugador 2//
      while ((cancelar) && (!vJ2) && (!vJ1) && (!turno)) {
        
        cancelar = false;
        
        //Pedimos el movimiento jugador 2// 
        do {
          existente = true;
          
          if (movimientos.MovimientosN.JaqueAlRey(tablero)) {
            
            System.out.print("\nLe estan haciendo jaque.");
            
          }
          
          System.out.print("\nDeclare la ficha que desea mover \033[31mJugador 2\033[97m o escribe RENDIRSE para terminar.\n(E.j h2 para mover el peon de segunda fila): ");
          posicionFicha = s.nextLine();
          
          //comprobamos que no le haya dado al enter sin introducir un valor//
          if (posicionFicha.equals("")) {
              
              System.out.print(tabla.Tabla.ImprimirTablaN(tablero, turnos, aux1, aux2));
              System.out.print("\nNo has introducido ningun valor");
              existente = false;
              
          }
          
          //comprobamos que no haya introducida una unica letra o numero//
          else if (posicionFicha.length() == 1) {
          
              System.out.print(tabla.Tabla.ImprimirTablaB(tablero, turnos, aux1, aux2));
              System.out.print("\nValor introducido no valido.");
              existente = false;
                            
          }
          
          else {
          
            columna = (int)(posicionFicha.toLowerCase().charAt(0)) - 96;
            fila = (int)(posicionFicha.charAt(1)) - 48;
            
            posFiN = fila;
            posCoN = columna;

            //comprobamos si se quiere rendir//
            if (posicionFicha.toLowerCase().equals("rendirse")) {
              
              vJ1 = true;
              
            }
            
            //comprobamos que ha seleccionado una ficha posible//
            else if ((columna > 8) || (columna < 1) || (fila > 8) || (fila < 1) || ((tablero[fila][columna] != peonN) && (tablero[fila][columna] != torreN)  && (tablero[fila][columna] != alfilN) 
          
            && (tablero[fila][columna] != reinaN) && (tablero[fila][columna] != reyN) && (tablero[fila][columna] != caballoN))){
              
              System.out.print(tabla.Tabla.ImprimirTablaN(tablero, turnos, aux1, aux2));
              System.out.print("\nFicha inexistente.");
              existente = false;
              
            }
          }
          
        } while ((!existente) && (!vJ1));
        
        //Imprimimos la tabla con la ficha seleccionada subrayada//
        System.out.println(tabla.Tabla.ImprimirTablaSubrayadoN(tablero, turnos, columna, fila, aux1, aux2));
        
        ilegal = true; 
        
        //Comprobamos si el movimiento es posible//
        while ((ilegal) && (!vJ1)) {
          
          System.out.print("Declare donde desea mover la ficha o cancela el movimiento. \n(Tiene que ser un movimiento legal o escribe CANCELAR): ");
          objetivoFicha = s.nextLine();
          
          //comprobamos que no le haya dado al enter sin introducir un valor//
          if (objetivoFicha.equals("")) {
              
              System.out.print(tabla.Tabla.ImprimirTablaSubrayadoN(tablero, turnos, columna, fila, aux1, aux2));
              System.out.println("\nNo has introducido ningun valor");
            
          }
          
          //comprobamos que no haya introducida una unica letra o numero//
          else if (posicionFicha.length() == 1) {
          
              System.out.print(tabla.Tabla.ImprimirTablaB(tablero, turnos, aux1, aux2));
              System.out.print("\nValor introducido no valido.");
                                          
          }
          
          else {
            
            columnaObjetivo = (int)(objetivoFicha.toLowerCase().charAt(0)) - 96;
            filaObjetivo = (int)(objetivoFicha.charAt(1)) - 48;
            
            objCoN = columnaObjetivo;
            objFiN = filaObjetivo;
            
            //comprobamos si queremos cambiar la ficha//
            if (objetivoFicha.toLowerCase().equals("cancelar")) {
              
              cancelar = true;
              ilegal = false;
              System.out.print(tabla.Tabla.ImprimirTablaN(tablero, turnos, aux1, aux2));
              
            }
            
            //comprobamos que este dentro del tablero//
            else if ((columnaObjetivo > 8) || (columnaObjetivo < 1) || (filaObjetivo > 8) || (filaObjetivo < 1)) {
              
              System.out.print(tabla.Tabla.ImprimirTablaSubrayadoN(tablero, turnos, columna, fila, aux1, aux2));
              System.out.println("\nMovimiento ilegal.");
              
            }
            
            //comprobamos si ha movido la ficha//
            else if ((fila == filaObjetivo) && (columna == columnaObjetivo)) {
              
              System.out.print(tabla.Tabla.ImprimirTablaSubrayadoN(tablero, turnos, columna, fila, aux1, aux1));
              System.out.println("\nTienes que mover la ficha.");
                  
            }
            
            //comprobamos si hay una ficha del mismo color en el objetivo//
            else if ((tablero[filaObjetivo][columnaObjetivo] == peonN) || (tablero[filaObjetivo][columnaObjetivo] == torreN) || (tablero[filaObjetivo][columnaObjetivo] == alfilN) 
          
              || (tablero[filaObjetivo][columnaObjetivo] == reinaN) || (tablero[filaObjetivo][columnaObjetivo] == reyN) || (tablero[filaObjetivo][columnaObjetivo] == caballoN)) {
              
              System.out.print(tabla.Tabla.ImprimirTablaSubrayadoN(tablero, turnos, columna, fila, aux1, aux2));
              System.out.println("\nMovimiento ilegal.");
              
            }
            
            //si la ficha seleccionada es una torre//
            else if (tablero[fila][columna] == torreN) {
              
              if (movimientos.MovimientosN.MovimientoTorre(tablero, fila, columna, filaObjetivo, columnaObjetivo)) {
                  
                aux[filaObjetivo][columnaObjetivo] = tablero[filaObjetivo][columnaObjetivo];
                
                //hacemos el cambio de ficha//
                tablero[filaObjetivo][columnaObjetivo] = tablero[fila][columna];
                tablero[fila][columna] = VACIO; 
                
                if (movimientos.MovimientosN.JaqueAlRey(tablero)) {
                  
                  tablero[filaObjetivo][columnaObjetivo] = aux[filaObjetivo][columnaObjetivo];
                  tablero[fila][columna] = torreN; 
                  System.out.println(tabla.Tabla.ImprimirTablaSubrayadoN(tablero, turnos, columna, fila, aux1, aux2));
                  System.out.println("Le hacen jaque.");  
                
                }
                
                else {
                
                  ilegal = false;
                  turnos++;
                  
                  if ((fila == 8) && (columna == 8)) {
                    
                    movTorreIN ++;
                    
                  }
                  
                  else if ((fila == 8) && (columna == 1)) {
                    
                    movTorreDN ++;
                    
                  }
                                    
                  //Comprobamos si se ha comido una ficha//
                  aux1 = tabla.Tabla.FichasComidasB(tablero, aux1, ireinaB, itorreB, ialfilB, ipeonB, icaballoB);
                  aux2 = tabla.Tabla.FichasComidasN(tablero, aux2, ireinaN, itorreN, ialfilN, ipeonN, icaballoN); 
                  
                  System.out.print(tabla.Tabla.ImprimirTablaN(tablero, turnos, aux1, aux2));
                  Thread.sleep(1000);
                  System.out.print(tabla.Tabla.ImprimirTablaB(tablero, turnos, aux1, aux2));
                  turno = true;
                }
              }
              
              else {
                
                System.out.print(tabla.Tabla.ImprimirTablaSubrayadoN(tablero, turnos, columna, fila, aux1, aux2));
                System.out.println("\nMovimiento ilegal.");
                
              }            
            }
            
            //si la ficha seleccionada es un peon//
            else if (tablero[fila][columna] == peonN) {
              
              if (movimientos.MovimientosN.MovimientoPeon(tablero, fila, columna, filaObjetivo, columnaObjetivo)) {
                
                aux[filaObjetivo][columnaObjetivo] = tablero[filaObjetivo][columnaObjetivo];
                
                //hacemos el cambio de ficha//
                tablero[filaObjetivo][columnaObjetivo] = tablero[fila][columna];
                tablero[fila][columna] = VACIO;                                    
         
                if (filaObjetivo == 1) {
                  
                  if ((movimientos.MovimientosN.ConversionPeon(tablero, filaObjetivo, columnaObjetivo)) == reinaN) {
                    
                    ireinaN++;
                  }
                  
                  else if ((movimientos.MovimientosN.ConversionPeon(tablero, filaObjetivo, columnaObjetivo)) == torreN) {
                    
                    itorreN++;
                  }
                  
                  else if ((movimientos.MovimientosN.ConversionPeon(tablero, filaObjetivo, columnaObjetivo)) == alfilN) {
                    
                    ialfilN++;
                  }
                  
                  else if ((movimientos.MovimientosN.ConversionPeon(tablero, filaObjetivo, columnaObjetivo)) == caballoN) {
                    
                    icaballoN++;
                  }
                  
                }
                
                if (movimientos.MovimientosN.JaqueAlRey(tablero)) {
                  
                  tablero[filaObjetivo][columnaObjetivo] = aux[filaObjetivo][columnaObjetivo];
                  tablero[fila][columna] = peonN; 
                  System.out.println(tabla.Tabla.ImprimirTablaSubrayadoN(tablero, turnos, columna, fila, aux1, aux2));
                  System.out.println("Le hacen jaque.");  
                
                }
                
                else {
                
                  ilegal = false;
                  turnos++; 
                  
                  //Comprobamos si se ha comido una ficha//
                  aux1 = tabla.Tabla.FichasComidasB(tablero, aux1, ireinaB, itorreB, ialfilB, ipeonB, icaballoB);
                  aux2 = tabla.Tabla.FichasComidasN(tablero, aux2, ireinaN, itorreN, ialfilN, ipeonN, icaballoN); 
                  
                  System.out.print(tabla.Tabla.ImprimirTablaN(tablero, turnos, aux1, aux2));
                  Thread.sleep(1000);        
                  System.out.print(tabla.Tabla.ImprimirTablaB(tablero, turnos, aux1, aux2));
                  turno = true;
                }
              }
              
              else if (movimientos.MovimientosN.CapturaEnMovimientoPeon(tablero, fila, columna, filaObjetivo, columnaObjetivo, posFiB, posCoB, objFiB, objCoB)) {
                
                aux[filaObjetivo][columnaObjetivo] = tablero[filaObjetivo][columnaObjetivo];
                
                //hacemos el cambio de ficha//
                tablero[filaObjetivo][columnaObjetivo] = tablero[fila][columna];
                tablero[fila][columna] = VACIO;   
                tablero[objFiB][objCoB] = VACIO;                                 
                         
                if (movimientos.MovimientosN.JaqueAlRey(tablero)) {
                  
                  tablero[filaObjetivo][columnaObjetivo] = aux[filaObjetivo][columnaObjetivo];
                  tablero[fila][columna] = peonN; 
                  tablero[objFiB][objCoB] = peonB;
                  System.out.println(tabla.Tabla.ImprimirTablaSubrayadoN(tablero, turnos, columna, fila, aux1, aux2));
                  System.out.println("Le hacen jaque.");  
                
                }
                
                else {
                
                  ilegal = false;
                  turnos++; 
                  
                  //Comprobamos si se ha comido una ficha//
                  aux1 = tabla.Tabla.FichasComidasB(tablero, aux1, ireinaB, itorreB, ialfilB, ipeonB, icaballoB);
                  aux2 = tabla.Tabla.FichasComidasN(tablero, aux2, ireinaN, itorreN, ialfilN, ipeonN, icaballoN); 
                  
                  System.out.print(tabla.Tabla.ImprimirTablaN(tablero, turnos, aux1, aux2));
                  Thread.sleep(1000);        
                  System.out.print(tabla.Tabla.ImprimirTablaB(tablero, turnos, aux1, aux2));
                  turno = true;
                }                
              }
                
              else {
                
                System.out.print(tabla.Tabla.ImprimirTablaSubrayadoN(tablero, turnos, columna, fila, aux1, aux2));
                System.out.println("\nMovimiento ilegal.");
                
              }            
            }
              
            //si la ficha seleccionada es un caballo//
            else if (tablero[fila][columna] == caballoN) {
              
              if (movimientos.MovimientosN.MovimientoCaballo(tablero, fila, columna, filaObjetivo, columnaObjetivo)) {
                 
                aux[filaObjetivo][columnaObjetivo] = tablero[filaObjetivo][columnaObjetivo];
                
                //hacemos el cambio de ficha//
                tablero[filaObjetivo][columnaObjetivo] = tablero[fila][columna];
                tablero[fila][columna] = VACIO;
                
                if (movimientos.MovimientosN.JaqueAlRey(tablero)) {
                  
                  tablero[filaObjetivo][columnaObjetivo] = aux[filaObjetivo][columnaObjetivo];
                  tablero[fila][columna] = caballoN; 
                  System.out.println(tabla.Tabla.ImprimirTablaSubrayadoN(tablero, turnos, columna, fila, aux1, aux2));
                  System.out.println("Le hacen jaque.");  
                
                }
                
                else {
                
                  ilegal = false;
                  turnos++;                 
                  
                  //Comprobamos si se ha comido una ficha//
                  aux1 = tabla.Tabla.FichasComidasB(tablero, aux1, ireinaB, itorreB, ialfilB, ipeonB, icaballoB);
                  aux2 = tabla.Tabla.FichasComidasN(tablero, aux2, ireinaN, itorreN, ialfilN, ipeonN, icaballoN); 
                  
                  System.out.print(tabla.Tabla.ImprimirTablaN(tablero, turnos, aux1, aux2));
                  Thread.sleep(1000);       
                  System.out.print(tabla.Tabla.ImprimirTablaB(tablero, turnos, aux1, aux2));
                  turno = true;
                }
              }        
              
              else {
                
                System.out.print(tabla.Tabla.ImprimirTablaSubrayadoN(tablero, turnos, columna, fila, aux1, aux2));
                System.out.println("\nMovimiento ilegal.");
              }  
            }
            
            //si la ficha seleccionada es un alfil//
            else if (tablero[fila][columna] == alfilN) {
              
              if (movimientos.MovimientosN.MovimientoAlfil(tablero, fila, columna, filaObjetivo, columnaObjetivo)) {
                              
                aux[filaObjetivo][columnaObjetivo] = tablero[filaObjetivo][columnaObjetivo];
                
                //hacemos el cambio de ficha//
                tablero[filaObjetivo][columnaObjetivo] = tablero[fila][columna];
                tablero[fila][columna] = VACIO;
                
                if (movimientos.MovimientosN.JaqueAlRey(tablero)) {
                  
                  tablero[filaObjetivo][columnaObjetivo] = aux[filaObjetivo][columnaObjetivo];
                  tablero[fila][columna] = alfilN; 
                  System.out.println(tabla.Tabla.ImprimirTablaSubrayadoN(tablero, turnos, columna, fila, aux1, aux2));
                  System.out.println("Le hacen jaque."); 
                
                }
                
                else {
                
                  ilegal = false;
                  turnos++;  
                
                  //Comprobamos si se ha comido una ficha//
                  aux1 = tabla.Tabla.FichasComidasB(tablero, aux1, ireinaB, itorreB, ialfilB, ipeonB, icaballoB);
                  aux2 = tabla.Tabla.FichasComidasN(tablero, aux2, ireinaN, itorreN, ialfilN, ipeonN, icaballoN); 
                  
                  System.out.print(tabla.Tabla.ImprimirTablaN(tablero, turnos, aux1, aux2));
                  Thread.sleep(1000);       
                  System.out.print(tabla.Tabla.ImprimirTablaB(tablero, turnos, aux1, aux2));
                  turno = true;
                }
              }
              
              else {
                
                System.out.print(tabla.Tabla.ImprimirTablaSubrayadoN(tablero, turnos, columna, fila, aux1, aux2));
                System.out.println("\nMovimiento ilegal.");
              }
            }
            
            //si la ficha seleccionada es la reina//
            else if (tablero[fila][columna] == reinaN) {
              
              if (movimientos.MovimientosN.MovimientoReina(tablero, fila, columna, filaObjetivo, columnaObjetivo)) {
                              
                aux[filaObjetivo][columnaObjetivo] = tablero[filaObjetivo][columnaObjetivo];
                
                //hacemos el cambio de ficha//
                tablero[filaObjetivo][columnaObjetivo] = tablero[fila][columna];
                tablero[fila][columna] = VACIO;
                
                if (movimientos.MovimientosN.JaqueAlRey(tablero)) {
                  
                  tablero[filaObjetivo][columnaObjetivo] = aux[filaObjetivo][columnaObjetivo];
                  tablero[fila][columna] = reinaN; 
                  System.out.println(tabla.Tabla.ImprimirTablaSubrayadoN(tablero, turnos, columna, fila, aux1, aux2));
                  System.out.println("Le hacen jaque.");   
                
                }
                
                else {
                
                  ilegal = false;
                  turnos++; 
                
                  //Comprobamos si se ha comido una ficha//
                  aux1 = tabla.Tabla.FichasComidasB(tablero, aux1, ireinaB, itorreB, ialfilB, ipeonB, icaballoB);
                  aux2 = tabla.Tabla.FichasComidasN(tablero, aux2, ireinaN, itorreN, ialfilN, ipeonN, icaballoN); 
                  
                  System.out.print(tabla.Tabla.ImprimirTablaN(tablero, turnos, aux1, aux2));
                  Thread.sleep(1000);       
                  System.out.print(tabla.Tabla.ImprimirTablaB(tablero, turnos, aux1, aux2));
                  turno = true;
                }
              }
              
              else {
                
                System.out.print(tabla.Tabla.ImprimirTablaSubrayadoN(tablero, turnos, columna, fila, aux1, aux2));
                System.out.println("\nMovimiento ilegal.");
              }          
            }
            
            //si la ficha seleccionada es el rey//
            else if (tablero[fila][columna] == reyN) {
              
              //Comprobamos enroque hacia la derecha//
              if (movimientos.MovimientosN.EnroqueD(tablero, fila, columna, filaObjetivo, columnaObjetivo, movReyN, movTorreDN)) {
                
                tablero[8][7] = reyN; 
                tablero[8][5] = VACIO;
                tablero[8][6] = torreN;
                tablero[8][8] = VACIO;
                
                if (movimientos.MovimientosN.JaqueAlRey(tablero)) {
                  
                  tablero[1][7] = VACIO; 
                  tablero[1][5] = reyN;
                  tablero[1][6] = VACIO;
                  tablero[1][8] = torreN;
                  System.out.println(tabla.Tabla.ImprimirTablaSubrayadoN(tablero, turnos, columna, fila, aux1, aux2));
                  System.out.println("Le hacen jaque.");
                }
                
                else {
                               
                  ilegal = false;
                  movReyN ++;
                  movTorreDN ++;                                     
                  System.out.print(tabla.Tabla.ImprimirTablaN(tablero, turnos, aux1, aux2));
                  Thread.sleep(1000);                  
                  System.out.print(tabla.Tabla.ImprimirTablaB(tablero, turnos, aux1, aux2));
                  turno = true;
                }                
              }
              
              //Comprobamos enroque hacia la izquierda//
              else if (movimientos.MovimientosN.EnroqueI(tablero, fila, columna, filaObjetivo, columnaObjetivo, movReyN, movTorreIN)) {
                                
                tablero[8][3] = reyN; 
                tablero[8][5] = VACIO;
                tablero[8][4] = torreN;
                tablero[8][1] = VACIO;
                
                if (movimientos.MovimientosN.JaqueAlRey(tablero)) {
                  
                  tablero[8][3] = VACIO; 
                  tablero[8][5] = reyN;
                  tablero[8][4] = VACIO;
                  tablero[8][1] = torreN;
                  System.out.println(tabla.Tabla.ImprimirTablaSubrayadoN(tablero, turnos, columna, fila, aux1, aux2));
                  System.out.println("Le hacen jaque.");
                }
                
                else {
                               
                  ilegal = false;
                  movReyN ++;
                  movTorreIN ++;                                     
                  System.out.print(tabla.Tabla.ImprimirTablaN(tablero, turnos, aux1, aux2));
                  Thread.sleep(1000);                  
                  System.out.print(tabla.Tabla.ImprimirTablaB(tablero, turnos, aux1, aux2));
                  turno = true;
                }                
              }
              
              else if (movimientos.MovimientosN.MovimientoRey(tablero, fila, columna, filaObjetivo, columnaObjetivo)) {
                              
                aux[filaObjetivo][columnaObjetivo] = tablero[filaObjetivo][columnaObjetivo];
                
                //hacemos el cambio de ficha//
                tablero[filaObjetivo][columnaObjetivo] = tablero[fila][columna];
                tablero[fila][columna] = VACIO;
                
                if (movimientos.MovimientosN.JaqueAlRey(tablero)) {
                  
                  tablero[filaObjetivo][columnaObjetivo] = aux[filaObjetivo][columnaObjetivo];
                  tablero[fila][columna] = reyN; 
                  System.out.println(tabla.Tabla.ImprimirTablaSubrayadoN(tablero, turnos, columna, fila, aux1, aux2));
                  System.out.println("Le hacen jaque."); 
                
                }
                
                else {
                
                  ilegal = false;
                  turnos++; 
                  movReyN ++;
                
                 //Comprobamos si se ha comido una ficha//
                  aux1 = tabla.Tabla.FichasComidasB(tablero, aux1, ireinaB, itorreB, ialfilB, ipeonB, icaballoB);
                  aux2 = tabla.Tabla.FichasComidasN(tablero, aux2, ireinaN, itorreN, ialfilN, ipeonN, icaballoN); 
                   
                  System.out.print(tabla.Tabla.ImprimirTablaN(tablero, turnos, aux1, aux2));
                  Thread.sleep(1000);      
                  System.out.print(tabla.Tabla.ImprimirTablaB(tablero, turnos, aux1, aux2));
                  turno = true;
                }
              } 
              
              else {
                
                System.out.print(tabla.Tabla.ImprimirTablaSubrayadoN(tablero, turnos, columna, fila, aux1, aux2));
                System.out.println("\nMovimiento ilegal.");
              }         
            }
          }
        }
      }
    }
    
    if ((vJ1) && (vJ2)) {
      
      System.out.println("\n-----Empate");
      
    }
    
    else if (vJ1) {
      
      System.out.println("\n-----Gana Jugador 1");
      
    }
    
    else if (vJ2) {
      
      System.out.println("\n-----Gana Jugador 2");
      
    }
    
  }
}

/*Por PABLO ARIÑO MUÑOZ*/
