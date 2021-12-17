//public abstract class Entity implements GraphicsObject {
//
//	protected Position _position = new Position(); // tọa độ x, y tính từ góc trái trên trong canvas
//	protected boolean _removed = false;
//	protected Image img;
//
//
//	/**
//	 * Khởi tạo đối tượng, chuyển từ tọa độ đơn vị sang tọa độ trong canvas
//	 */
//	public Entity( int xUnit, int yUnit, Image img) {
//		this._position.setCoordinateX(xUnit * Sprite.SCALED_SIZE);
//		this._position.setCoordinateY(yUnit * Sprite.SCALED_SIZE);
//		this.img = img;
//	}
//
//	/**
//	 * Phương thức này được gọi liên tục trong vòng lặp game,
//	 * mục đích để xử lý sự kiện và cập nhật trạng thái Entity
//	 */
//	@Override
//	public abstract void update();
//
//	/**
//	 * Phương thức này được gọi liên tục trong vòng lặp game,
//	 * mục đích để cập nhật hình ảnh của entity theo trạng thái
//	 */
//	@Override
//	public void render(GraphicsContext gc) {
//		gc.drawImage(img, _position.getCoordinateX(), _position.getCoordinateY());
//	}
//
//	public void remove() {
//		this._removed = true;
//	}
//
//	public boolean isRemoved() {
//		return _removed;
//	}
//
//	/**
//	 * Phương thức này được gọi để xử lý khi hai entity va chạm vào nhau
//	 */
//	public abstract boolean collide(Entity e);




package uet.oop.bomberman.entities;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;


public abstract class Entity {

	protected Coordinate coordinate = new Coordinate();
	protected Image entityGraphics;
	protected BoundaryBox boundaryBox;



	public Entity(int x, int y) {
		this.coordinate.setX(x);
		this.coordinate.setY(y);
		this.boundaryBox = new BoundaryBox(coordinate, this.getImageWidth(), this.getImageHeight());
	}

	public Entity(int x, int y, Image image) {
		this.coordinate.setX(x);
		this.coordinate.setY(y);
		this.entityGraphics = image;
		this.boundaryBox = new BoundaryBox(coordinate, this.getImageWidth(), this.getImageHeight());
	}

	public void render(GraphicsContext gc) {
		if(gc == null || this.entityGraphics == null) {
			return;
		}
		gc.drawImage(this.entityGraphics, this.coordinate.getX(), this.coordinate.getY());
		gc.strokeRect(this.boundaryBox.getTop_left().getX(), this.boundaryBox.getTop_left().getY(),
				this.boundaryBox.getBoundaryBoxWidth(), this.boundaryBox.getBoundaryBoxHeight());
	};

	public abstract void update();

	public int getX() {
		return this.coordinate.getX();
	}

	public int getY() {
		return this.coordinate.getY();
	}

	public int getImageWidth() {
		return (entityGraphics == null)? 0 : (int) entityGraphics.getWidth();
	}

	public int getImageHeight() {
		return (entityGraphics == null)? 0 : (int) entityGraphics.getHeight();
	}

	public Coordinate getCoordinate() {
		return coordinate;
	}

	@Override
	protected void finalize() {
		System.out.println("Garbage collector in action! Deleted one object!");
	}
}

