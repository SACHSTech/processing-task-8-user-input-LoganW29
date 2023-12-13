import processing.core.PApplet;

/**
 * A program that draws a garden using mouse and keyboard input variables and event functions.
 * @author: L. Wong  
 */
public class Sketch extends PApplet {
	
  /**
   * Called once at the beginning of execution, the size call 
   */
  public void settings() {
	// size call 
    size(400, 400);
  }

  /** 
   * Called once at the beginning of execution. Initial set up
   * values, i.e background, stroke, fill etc.
   */
  public void setup() {
    background(12, 122, 232);
  }

  boolean blnLeftPressed = false; 
  boolean blnRightPressed = false; 
  float butterflyX = 200;
  float butterflyY = 200;

  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
   public void draw() {
        
    if (blnLeftPressed) {
      butterflyX--;
    }
  
    if (blnRightPressed) {
      butterflyX++;
    }
    drawButterfly(butterflyX, butterflyY);

    if (drawClouds == true) {
      for (int i = 10; i < width; i += 90){
        drawCloud(i, 40);
      }
    } 
   
    if (keyPressed && key != 'b' && key != 'B' && keyCode != UP && keyCode != LEFT && keyCode != RIGHT){
      for(int i = 0; i < width; i += 30){
        drawFence(i, 320);
      }
      for(int i = 360; i < height; i += 20){
      drawFence(0, i);
      }
    }
  }

  public void keyReleased() {
    if (keyCode == UP) {
      drawClouds = false;
    }

    if (keyCode == LEFT) {
        blnLeftPressed = false;
    } 
    else if (keyCode == RIGHT) {
        blnRightPressed = false;
    }

  }
  
  /**
   * If mouse is pressed a flower is drawn to the screen at the mouseX and mouseY position.
   */
  public void mousePressed() {
    drawFlower(mouseX, mouseY);
  }

  /**
   * If the mouse is dragged and mouseY is greater than 300, then grass is drawn. 
   */
  public void mouseDragged() {
    drawGrass(mouseX, mouseY);
  }

  /**
   * Changes the background colour if he 'B' or 'b' key is pressed. 
   * Adds clouds if the UP key is pressed.
   */
  public void keyPressed() {
    // Change background colour if the 'B' or 'b' key is pressed 
    if (key == 'B' || key == 'b') {
      background(28, 52, 115);
    }
    // if the UP key is pressed it draws a row of clouds in the sky.
    if (keyCode == UP) {
      drawClouds = true;
    } 
    if (keyCode == LEFT) {
      blnLeftPressed = true;
    } 
    else if (keyCode == RIGHT) {
      blnRightPressed = true;
    }
  }   

  /**
   * Calculates the shapes that make up the butter fly. 
   * @param butterflyX2 the X value 
   * @param butterflyY2 the Y value 
   */
  public void drawButterfly(float butterflyX2, float butterflyY2) {
   
    stroke(0);

    fill(154, 110, 230);
    ellipse(butterflyX2 + 5, butterflyY2 + 20, 25, 30);
    ellipse(butterflyX2 - 20, butterflyY2 + 20, 25, 30);

    fill(189, 34, 168);
    ellipse(butterflyX2 + 5, butterflyY2, 20, 30);
    ellipse(butterflyX2 - 20, butterflyY2, 20, 30);

    fill(83, 27, 168);
    ellipse(butterflyX2 - 7, butterflyY2 + 5, 10, 50);
  }

  /**
   * Calculations to draw the flower.
   * @param intX the X value 
   * @param intY the Y value 
   */
  public void drawFlower(int intX, int intY) {
    stroke(0);
    fill(47, 145, 42);
    rect(intX - 10, intY + 20, 10, 50);
   
    fill(232, 12, 188);
    ellipse(intX + 10, intY + 30, 30, 30);
    ellipse(intX - 20, intY + 30, 30, 30);
    ellipse(intX + 10, intY, 30, 30);
    ellipse(intX - 20, intY, 30, 30);
   
    fill(219, 76, 29);
    ellipse (intX - 5, intY + 15, 30, 30);
  }

  /**
   * Draws grass where the mouse is dragged if the mouse's Y position is greater than 300. 
   * @param intX the X value 
   * @param intY the Y value 
   */
  public void drawGrass(float fltX, float fltY) {
    if (mouseY > 300){
    noStroke();
    fill(66, 245, 96);
    ellipse(fltX, fltY, 30, 30);
    }
  }

  boolean drawClouds = false;

  /**
  * Calculations for the shapes that make up the cloud. 
  * @param intX the X value 
  * @param intY the Y value
  */
  public void drawCloud(int intX, int intY) {
    
    noStroke();
    fill(255);
    ellipse(intX + 5, intY + 15, 30, 30);
    ellipse(intX - 10, intY + 15, 30, 30);
    ellipse(intX + 10, intY, 30, 30);
    ellipse(intX - 5, intY, 30, 30);
  }

  public void drawFence(int intX, int intY){
    fill(71, 49, 45);
    rect(intX, intY, 10, 80);
    rect(intX, intY, width, 5);

  }
}
