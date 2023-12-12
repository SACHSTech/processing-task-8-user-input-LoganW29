import processing.core.PApplet;

public class Sketch extends PApplet {
	
	
  /**
   * Called once at the beginning of execution, put your size all in this method
   */
  public void settings() {
	// put your size call here
    size(400, 400);
  }

  /** 
   * Called once at the beginning of execution.  Add initial set up
   * values here i.e background, stroke, fill etc.
   */
  public void setup() {
    background(210, 255, 173);
  }

  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {

  }
  
  public void mouseDragged() {
    drawGrass(mouseX, mouseY, 20, 20);
  }
  
  /**
   * Draws grass where the mouse is dragged
   * @param intX
   * @param intY
   * @param intWidth
   * @param intHeight
   */
  public void drawGrass(int intX, int intY, int intWidth, int intHeight) {
    fill(66, 245, 96);
    ellipse(intX, intY, intWidth, intHeight);
  }

}