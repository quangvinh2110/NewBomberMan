//package uet.oop.bomberman.entities.character.enemy.Enemies;
//
//import javafx.scene.image.Image;
//import uet.oop.bomberman.entities.character.enemy.Enemy;
//
//public class Minvo extends Enemy {
//
//    /**
//     * Khởi tạo đối tượng, chuyển từ tọa độ đơn vị sang tọa độ trong canvas
//     *
//     * @param xUnit
//     * @param yUnit
//     * @param img
//     */
//    public Minvo(int xUnit, int yUnit, Image img) {
//        super(xUnit, yUnit, img);
//    }
//
//        public Minvo (int x, int y, Board board){
//        super(x, y, board, Sprite.minvo_dead, Game.getBomberSpeed(), 300);
//        _sprite = Sprite.minvo_left1;
//
//        _ai = new MediumAI(board.getBomber(), this);
//        _direction = _ai.calculateDirection();
//    }
//    @Override
//    protected void chooseSprite() {
//        switch(_direction) {
//            case 0:
//            case 1:
//                _sprite = Sprite.movingSprite(Sprite.minvo_right1, Sprite.minvo_right2, Sprite.minvo_right3, _animate, 60);
//                break;
//            case 2:
//            case 3:
//                _sprite = Sprite.movingSprite(Sprite.minvo_left1, Sprite.minvo_left2, Sprite.minvo_left3, _animate, 60);
//                break;
//        }
//    }
//    @Override
//    protected  void chooseSprite() {
//
//    }
//}
