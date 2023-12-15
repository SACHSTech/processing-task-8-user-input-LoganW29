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
    size(400, 400);
  }

  /** 
   * Called once at the beginning of execution. Initial set up values, i.e background, stroke, fill etc.
   */
  public void setup() {
    background(12, 122, 232);
  }
  
  // Initializing variables 
  boolean drawClouds = false;

  boolean drawMoon = false; 

  boolean blnLeftPressed = false; 
  boolean blnRightPressed = false; 
  float fltButterflyX = 200;
  float fltButterflyY = 200;

  /**
   * Called repeatedly, anything drawn to the screen
   */
  public void draw() {
    // For the butterfly
    if (blnLeftPressed) {
      fltButterflyX--;
    }
    if (blnRightPressed) {
      fltButterflyX++;
    }
    drawButterfly(fltButterflyX, fltButterflyY);

    // For the clouds
    if (drawClouds == true) {
      for (int i = 10; i < width; i += 90){
        drawCloud(i, 40);
      }
    } 
    
    // For the fence 
    if (keyPressed && key != 'b' && key != 'B' && keyCode != UP && keyCode != LEFT && keyCode != RIGHT){
      for(int i = 0; i < width; i += 30){
        drawFence(i, 320);
      }
      for(int i = 360; i < height; i += 20){
        drawFence(0, i);
      }
    }

    // For the mushroom 
    if (mousePressed){
      drawMushroom(300, 300);
    }
  }

  /**
   * If the UP key is released, it stops drawing clouds.
   * If the LEFT or RIGHT key is released, it sets the left or right movement of the butterfly to false.
   */
  public void keyReleased() {
    // For the clouds
    if (keyCode == UP) {
      drawClouds = false;
    }
    // For the butterfly 
    else if (keyCode == LEFT) {
      blnLeftPressed = false;
    } 
    else if (keyCode == RIGHT) {
      blnRightPressed = false;
    }
  }

  /**
   * Changes the background colour if the 'B' or 'b' key is pressed. 
   * Adds clouds if the UP key is pressed.
   */
  public void keyPressed() {
    // For the background colour
    if (key == 'B' || key == 'b') {
      background(28, 52, 115);
    }
    // For the clouds 
    else if (keyCode == UP) {
      drawClouds = true;
    } 
    // For butterfly movement
    else if (keyCode == LEFT) {
      blnLeftPressed = true;
    } 
    else if (keyCode == RIGHT) {
      blnRightPressed = true;
    }
  }   
  
  /**
   * When the mouse is pressed a moon is drawn to (70, 70).
   */
  public void mousePressed() {
    drawMoon(70, 70);
  }
  
  /**
   * When the mouse is released a moon is drawn to (330, 70).
   */
  public void mouseReleased() {
    drawMoon(330, 70);
  }

  /**
   * If the mouse is dragged and mouseY is greater than 300, then grass is drawn. 
   */
  public void mouseDragged() {
    drawGrass(mouseX, mouseY);
  }
  
  /**
   * If the mouse is clicked a flower is drawn to the screen at the mouseX and mouseY position.
   */
  public void mouseClicked() {
    drawFlower(mouseX, mouseY);
  }

  /**
   * When the mouse is moved a mushroom is drawn to the screen. 
   */
  public void mouseMoved(){
    drawMushroom(60, 300);
  }

  /**
   * Calculates the shapes that make up the butterfly. 
   * @param fltButterflyX2 the X value 
   * @param fltButterflyY2 the Y value 
   */
  public void drawButterfly(float fltButterflyX2, float fltButterflyY2) {
    stroke(0);

    fill(154, 110, 230);
    ellipse(fltButterflyX2 + 5, fltButterflyY2 + 20, 25, 30);
    ellipse(fltButterflyX2 - 20, fltButterflyY2 + 20, 25, 30);

    fill(189, 34, 168);
    ellipse(fltButterflyX2 + 5, fltButterflyY2, 20, 30);
    ellipse(fltButterflyX2 - 20, fltButterflyY2, 20, 30);

    fill(83, 27, 168);
    ellipse(fltButterflyX2 - 7, fltButterflyY2 + 5, 10, 50);
  }

  /**
   * Calculations of the shapes and colours of the flower.
   * @param intX the X value 
   * @param intY the Y value 
   */
  public void drawFlower(int intX, int intY) {
    stroke(0);
    
    // Flower stem
    fill(47, 145, 42);
    rect(intX - 10, intY + 20, 10, 50);
   
    // Flower Petals 
    fill(232, 12, 188);
    ellipse(intX + 10, intY + 30, 30, 30);
    ellipse(intX - 20, intY + 30, 30, 30);
    ellipse(intX + 10, intY, 30, 30);
    ellipse(intX - 20, intY, 30, 30);
   
    // Middle of flower 
    fill(219, 76, 29);
    ellipse (intX - 5, intY + 15, 30, 30);
  }

  /**
   * Draws green grass where the mouse is dragged, if the mouse's Y position is greater than 300. 
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

  /**
   * Calculations for the shapes and colours that make up the cloud. 
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

  /**
   * Calculates the shapes and colours for the fence. 
   * @param intX the X value 
   * @param intY the Y value 
   */
  public void drawFence(int intX, int intY){
    fill(71, 49, 45);
    rect(intX, intY, 10, 80);
    rect(intX, intY, width, 5);
  }

  /**
   * Calculations for the shapes and colours of the mushroom.
   * @param intX the X value 
   * @param intY the Y value
   */
  public void drawMushroom(int intX, int intY) {
    // Mushroom stem
    fill(217, 175, 167); 
    rect(intX, intY, 40, 100);
  
    // Mushroom cap
    fill(255, 0, 0); 
    arc(intX + 20, intY, 120, 120, PI, TWO_PI);
  
    // White dots on the mushroom cap
    fill(255); 
    ellipse(intX, intY - 15, 20, 20);
    ellipse(intX + 40, intY - 15, 20, 20);
    ellipse(intX + 20, intY - 45, 20, 20);
  }

  /**
   * Calculations for the shapes and colours included to make the moon.
   * @param intX the X value
   * @param intY the Y value
   */
  public void drawMoon(int intX, int intY){
    fill(255);
    ellipse(intX, intY, 60, 60);

    // Gray spots on moon
    fill(207, 198, 186);
    ellipse(intX - 10, intY, 5, 5);
    ellipse(intX + 5, intY, 5, 5);
    ellipse(intX, intY - 10, 10, 10);
    ellipse(intX, intY + 15, 15, 15);
  }
}
