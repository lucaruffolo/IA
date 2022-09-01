package logic;

import javafx.scene.image.Image;

public class Purple_Player implements Player{
	private Image img;
	private String colore;

	public Image getImg() {
		return img;
	}

	public void setImg(Image img) {
		this.img = img;
	}
	
	public void setColore(String colore) {
		this.colore = colore;
	}

	@Override
	public void collition() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getColore() {
		// TODO Auto-generated method stub
		return colore;
	}
	
	
}
