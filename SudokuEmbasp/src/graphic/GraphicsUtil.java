package graphic;

import javafx.scene.image.Image;

public class GraphicsUtil {

	private static final String resources = "/ia/CCMMYY/src/graphic/";
	//the current image to draw
	private static Image[] images = new Image[] {
		new Image(GraphicsUtil.class.getResourceAsStream(resources + "test.gif")),
		new Image(GraphicsUtil.class.getResourceAsStream(resources + "test.gif")),
		new Image(GraphicsUtil.class.getResourceAsStream(resources + "test.gif")),
		new Image(GraphicsUtil.class.getResourceAsStream(resources + "test.gif"))
	};
	private static Image img = images[0];	
	
	public static Image getImg() {
		return img;
	}
	
	public static void updateDirection(int direction) {
		if(direction < images.length)
			img = images[direction];
	}
}
