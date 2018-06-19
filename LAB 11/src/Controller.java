/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//package controller;

import model.Game;
import model.Move;
import model.Player;

import java.util.ArrayList;

/**
 *
 * @author grzech
 */
public class Controller
{
    //private DataBaseController db=new DataBaseController();
    private Player player;
    private Game game;
    private Move move;
    private int x; private int y; private int z;
    private boolean opponentType;
    private boolean[][] availableMove;
    private String creatorSign;
    private String lastSign;

    public String getLastSign() {
        return lastSign;
    }

    int coordinate[]= new int[2];

    public Move getMove() {
        return move;
    }



    public String getCreatorSign() {
        return creatorSign;
    }

    public int[] getCoordinate() {

        return coordinate;
    }

    //public void setMove() {
     //   move= move.getMoveMaxIdDb();
   // }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }


    public void login(String nick,String password)
    {
        player=db.login(nick, password);
    }

    public void createGame(int x,int y, int z,boolean opponentType)
    {
        this.x=x;this.y=y;this.z=z;this.opponentType=opponentType;
        game=new Game(x,y,z,Boolean.TRUE,Boolean.FALSE,Boolean.TRUE);
        player.setGame(game);
        game.addPlayerToSet(player);
        db.createGame(game, player);

        availableMove=new boolean[x][y];
        for(int i=0;i<x;i++){
            for(int j=0;j<z;j++)
                this.availableMove[i][j]=true;
        }
        //if(opponentType== true)
        //    waitTo2Player();

    }
    public void joinGame(int id)
    {

        game= db.joinToGameStep1(id, player);
        x=game.getBoardSizeX();
        y=game.getBoardSizeY();
        z=game.getSameSigns();
        game.addPlayerToSet(player);
        player.setGame(game);
        db.joinToGameStep2(game, player);
    }
    public String gameList()
    {
        String s="";
        ArrayList<Game> gamesL=new ArrayList<>();
        gamesL=db.gameList();
        for(int i=0;i<gamesL.size();i++)
        {
            s = s+ gamesL.get(i).toString();
            s = s+"\n";
        }

        return s;
    }

    public boolean waitFor2Player() throws InterruptedException
    {
        boolean d;

        d=db.waitFor2Player(game);

        return d;
    }

    public int[] getCoordinateAI(int ii, int jj,String mySign, String opponentSign) {

        int coordinate[]= new int[2];
        boolean end=false;
        availableMove[ii][jj]=false;
        move=new Move(game,ii,jj,mySign);
        game.addMoveToSet(move);
        move.setGame(game);
        db.saveMove(game,move);

        for(int i=0;i<x && end==false;i++)
        {
            for(int j=0;j<y && end==false;j++)
            {
                if(availableMove[i][j]==true)
                {
                    coordinate[0]=i;
                    coordinate[1]=j;
                    availableMove[i][j]=false;

                    move=new Move(game,i,j,mySign);
                    game.addMoveToSet(move);
                    move.setGame(game);
                    db.saveMove(game,move);

                    end=true;
                    break;
                }

            }

        }

        return coordinate;
    }



    public void saveMove(int ii, int jj, String mySign){

        move=new Move(game,ii,jj,mySign);
        game.addMoveToSet(move);
        move.setGame(game);
        db.saveMove(game,move);


    }
    public void getMoveMaxId()
    {
        Move move1;
        move1=db.getMoveMaxIdDb();
        coordinate[0]=move1.getX();
        coordinate[1]=move1.getY();
        lastSign=move1.getSign();
    }
    public boolean waitForMove() throws InterruptedException {

        boolean b=false;
//        System.out.print(move.toString());
//             model.Move move1=new model.Move();
//               while(move1!=null)
//                       {
//                           Thread.sleep(500);

        b=db.waitForMove(move);

//                           System.out.print("czeka na ruch controler");
//                       }
//              b=true;
//         System.out.print("znaleziono ruch controlert");
//        coordinate[0]=move1.getX();
//        coordinate[1]=move1.getY();
//        creatorSign=move1.getSign();
//        System.out.println(move1.toString());
        return b;

    }

}
