package Matosuschek;
/**
 * Diese Klasse beschreibt die
 * Funktionsweise des Spiels "Lights Out",
 * welche danach zu einer graphischen 
 * Oberfläche hinzugefügt wird.
 * 
 * @author Marco Matouschek
 * @version 1.0
 *
 */

public class MyModel {

	private boolean[][] lightOn;
	
	/**
	 * Der Konstruktor initialisiert ein 2D-
	 * boolean Array, welches zur Erkennung
	 * ob ein Licht leuchtet dient. Weiters 
	 * wird die Init Methode aufgerufen, welche
	 * dieses Array mit zufälligen Werten 
	 * befüllt.
	 */
	public MyModel(){
		this.lightOn = new boolean[5][5];
		init();
	}
	/**
	 * Die Methode init() initialisiert alle
	 * Elemente des boolean arrays lightsOn 
	 * mit zufälligen Werten. (true, false)
	 */
	public void init(){
		//verschachtelte vorschleifen zum
		//durchlauf des 2D-Arrays
		for(int i = 0; i < 5; i++){
			for(int j = 0; j < 5; j++){
				//this.lightOn[i][j] = false;
				this.lightOn[i][j] = randomBoolean(); 
			}
		}
	}
	
	/**
	 * Die Methode randomBoolean() liefert einen
	 * zufälligen boolean-Wert zurück
	 * @return random boolean-Wert (true, false)
	 */
	public boolean randomBoolean(){
		int temp = (int)(Math.random()*2);
		if (temp == 0) return false;
		return true;
	}
	
	/**
	 * Die Methode changeLight ändert den
	 * Zustand eines booleans
	 * @param in Input (lightOn)
	 * @return umgekehrten Zustand (true->false, false->true)
	 */
	public boolean changeLight(boolean in){
		if(in == false) return true;
		else return false;
	}
	
	/**
	 * Die Methode getLightOn liefert das 
	 * 2D-Array lightOn zurück
	 * @return lightOn Array
	 */
	public boolean[][] getLightOn(){
		return this.lightOn;
	}
	
	/**
	 * Die Methode buttonClicked ändert, je nach Button
	 * angegeben, den Zustand von sich selbst und dem 
	 * darunter, darüber, rechts und links von ihm selbst.
	 * @param button Zahl des Buttons (0-24)
	 */
	public void buttonClicked(int button){
		
		//herausfinden der position (5x5)
		int row = button/5;
		int col = button%5;
		
		//je nach position des Buttons nicht vorhandene
		//elemente unverändert lassen
		if(row >= 1) changeLight(lightOn[row-1][col]);
		if(row <= 3) changeLight(lightOn[row+1][col]);
		if(col >= 1) changeLight(lightOn[row][col-1]);
		if(col <= 3) changeLight(lightOn[row][col+1]);
		changeLight(lightOn[row][col]);
		
	}
}
