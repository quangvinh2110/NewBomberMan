//package uet.oop.bomberman.entities.character.enemy.Enemies;
//
//import javafx.scene.image.Image;
//import uet.oop.bomberman.Board;
//import uet.oop.bomberman.Game;
//import uet.oop.bomberman.entities.character.enemy.Enemy;
//import uet.oop.bomberman.entities.character.enemy.ai.MediumAI;
//import uet.oop.bomberman.graphics.Sprite;
//
//public class Doria extends Enemy {
//    /**
//     * Khởi tạo đối tượng, chuyển từ tọa độ đơn vị sang tọa độ trong canvas
//     *
//     * @param xUnit
//     * @param yUnit
//     * @param img
//     */
//    public Doria(int xUnit, int yUnit, Image img) {
//        super(xUnit, yUnit, img);
//    }
////    public Doria (int x, int y , Board board ){
////        super(x, y, board,Sprite.kondoria_dead, Game.getBomberSpeed()*1.1, 400);
////        _sprite = Sprite.kondoria_left1;
////
////        _ai = new MediumAI(board.getBomber(), this);
////        _direction = _ai.calculateDirection();
////    }
//
////    @Override
////    protected void chooseSprite() {
////        switch(_direction) {
////            case 0:
////            case 1:
////                _sprite = Sprite.movingSprite(Sprite.kondoria_right1, Sprite.kondoria_right2, Sprite.kondoria_right3, _animate, 60);
////                break;
////            case 2:
////            case 3:
////                _sprite = Sprite.movingSprite(Sprite.kondoria_left1, Sprite.kondoria_left2, Sprite.kondoria_left3, _animate, 60);
////                break;
////        }
////    }
//
//    @Override
//    protected void chooseSprite() {
//
//    }
//}
