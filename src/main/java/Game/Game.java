package Game;
//
//import Utils.ConsoleRenderer;
//import World.World;
//
//public class Game extends Thread {
//
//    public void run(Menu menu, World world) {
//        loop(menu, world);
//    }
//
//    public void loop(Menu menu, World world) {
//
//        while (menu.getGameState() == GameState.ONGOING) {
//
//            //ConsoleRenderer.renderWorld(world);
//
//            GameAction.playSimulation(world);
//
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//            ConsoleRenderer.clean();
//        }
//
//        if (menu.getGameState() == GameState.STOP) {
//            ConsoleRenderer.renderMessage("Конец симуляции");
//        }
//    }
//}
