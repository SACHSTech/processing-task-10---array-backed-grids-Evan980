import processing.core.PApplet;

public class Sketch extends PApplet {
	
  // Global Variables
  int CELL_WIDTH = 20;
  int CELL_HEIGHT = 20;
  int MARGIN = 5;
  int ROW_COUNT = 10;
  int COLUMN_COUNT = 10;
  int SCREEN_WIDTH = (CELL_WIDTH + MARGIN) * COLUMN_COUNT + MARGIN;
  int SCREEN_HEIGHT = (CELL_HEIGHT + MARGIN) * ROW_COUNT + MARGIN;

  int intMouseX;
  int intMouseY;

  boolean blnGridPressed = false;
  boolean blnGridPrint = false;

  int intCellSelected = 0;
  int intRowSelected = 0;
  int intColumnSelected = 0;
  int intContinuos = 0;

  int[][] intGrid = new int [ROW_COUNT][COLUMN_COUNT];
  
  public void settings() {
    // put your size call here
    size(SCREEN_WIDTH, SCREEN_HEIGHT);
  }

  /** 
   * Called once at the beginning of execution.  Add initial set up
   * values here i.e background, stroke, fill etc.
   */
  public void setup() {
    background(0);
  }

  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {
	  
  }

  /**
   * Drawing the grid and calculates values
   */
  public void drawGrid(){
    for(int COLUMNS = 0; COLUMNS < COLUMNS_COUNT; COLUMNS++){
      for(int ROWS = 0; ROWS < ROW_COUNT; ROWS++){
        if(blnGridPressed && intMouseX == COLUMNS && intMouseY == ROWS){
          // Block in the middle
          if(intGrid[ROWS][COLUMNS] == 0){
            intGrid[ROWS][COLUMNS] = 1;
            intCellSelected++;
          }
          else if(intGrid[ROWS][COLUMNS] == 1){
            intGrid[ROWS][COLUMNS] = 0;
            intCellSelected--;
          }
          // Block on the left
          if(COLUMNS > 0 && intGrid[ROWS][COLUMNS-1] == 0){
            intGrid[ROWS][COLUMNS-1] = 1;
            intCellSelected++;
          }
          else if(COLUMNS > 0 && intGrid[ROWS][COLUMNS-1] == 1){
            intGrid[ROWS][COLUMNS-1] = 0;
            intCellSelected--;
          }
          // Block on the right
           if(COLUMNS < COLUMN_COUNT - 1 && intGrid[ROWS][COLUMNS+1] == 0){
             intGrid[ROWS][COLUMNS+1] = 1;
             intCellSelected++;
           }
          else if(COLUMNS < COLUMN_COUNT - 1 && intGrid[ROWS][COLUMNS+1] == 1){
            intGrid[ROWS][COLUMNS+1] = 0;
            intCellSelected--;
          }
          // Block on the top
          if(ROWS > 0 && intGrid[ROWS-1][COLUMNS] == 0){
            intGrid[ROWS-1][COLUMNS] = 1;
            intCellSelected++;
          }
          else if(ROWS > 0 && intGrid[ROWS-1][COLUMNS] == 1){
            intGrid[ROWS-1][COLUMNS] = 0;
            intCellSelected--;
          }
          // Block on the bottom
           if(ROWS < ROW_COUNT - 1 && intGrid[ROWS+1][COLUMNS] == 0){
             intGrid[ROWS+1][COLUMNS] = 1;
             intCellSelected++;
           }
          else if(ROWS < ROW_COUNT - 1 && intGrid[ROWS+1][COLUMNS] == 1){
            intGrid[ROWS+1][COLUMNS] = 0;
            intCellSelected--;
          }
          // Outputting message
          System.out.println("Total of " + intCellSelected + "cells are selected.")
          blnGridPressed = false;
        }
        // Changing colour to green
        if(intGrid[ROWS][COLUMNS] == 1){
          fill(0, 255, 0);
        }
        else{
          fill(255, 255, 255);
        }
        // Drawing grid
         rect(MARGIN + (COLUMNS * (CELL_WIDTH + MARGIN)), MARGIN + (ROWS * (CELL_HEIGHT + MARGIN)), CELL_WIDTH, CELL_HEIGHT);
      }
    }
  }

  public void gridSystem(){
    if(blnGridPrint){
      for(int i = 0; i < ROW_COUNT; i++){
        for(int f = 0; f < COLUMN_COUNT; f++){
          
        }
      }
    }
  }
  
  public void mousePressed(){
    
  }
}
