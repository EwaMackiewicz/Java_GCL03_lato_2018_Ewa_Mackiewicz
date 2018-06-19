
//package controller;


import model.Move;



public class Testy {



    public static void main(String[] args) throws InterruptedException {

        DataBaseController db=new DataBaseController();
//        model.Game game=new model.Game(3,3,3,Boolean.TRUE,Boolean.FALSE,Boolean.FALSE);
//        model.Move move=new model.Move(game,2,1,"x");
        //       model.Player player=new model.Player("bb","qq");
//        model.Player p;
//        model.Player p2;
        Move move=new Move();
        Controller c = new Controller();
        c.setMove();
        move=c.getMove();
        System.out.println(move.toString());
//       move=db.getMoverMaxIdDb();
//      System.out.println( move.toString());
//         c.login("aa", "qq");
//        // c.joinGame(1);
//         c.createGame(6, 6, 6, true);
//         c.saveMove(2, 1, "x");
//         //System.out.print(c.gameList());
        //  db.addNewPlayer(player);
//        c.waitFor2Player();
// the could room

        //db.createGame(game,player);

    }

}
