//package uet.oop.bomberman.entities.character.enemy.Enemies;
//
//
//import javafx.scene.image.Image;
//import uet.oop.bomberman.Board;
//import uet.oop.bomberman.Game;
//import uet.oop.bomberman.entities.character.enemy.Enemy;
//import uet.oop.bomberman.entities.character.enemy.ai.MediumAI;
//import uet.oop.bomberman.graphics.Sprite;
//
//public class Oneal extends Enemy {
//	/**
//	 * Khởi tạo đối tượng, chuyển từ tọa độ đơn vị sang tọa độ trong canvas
//	 *
//	 * @param xUnit
//	 * @param yUnit
//	 * @param img
//	 */
//	public Oneal(int xUnit, int yUnit, Image img) {
//		super(xUnit, yUnit, img);
//	}
//
////	public Oneal(int x, int y, Board board) {
////		super(x, y, board, Sprite.oneal_dead, Game.getBomberSpeed(), 200);
////
////		_sprite = Sprite.oneal_left1;
////
////		_ai = new MediumAI(_board.getBomber(), this);
////		_direction  = _ai.calculateDirection();
////	}
//
////	@Override
////	protected void chooseSprite() {
////		switch(_direction) {
////			case 0:
////			case 1:
////				if(_moving)
////					_sprite = Sprite.movingSprite(Sprite.oneal_right1, Sprite.oneal_right2, Sprite.oneal_right3, _animate, 60);
////				else
////					_sprite = Sprite.oneal_left1;
////				break;
////			case 2:
////			case 3:
////				if(_moving)
////					_sprite = Sprite.movingSprite(Sprite.oneal_left1, Sprite.oneal_left2, Sprite.oneal_left3, _animate, 60);
////				else
////					_sprite = Sprite.oneal_left1;
////				break;
////		}
////	}
//
//	protected void chooseSprite() {
//
//	}
//}
