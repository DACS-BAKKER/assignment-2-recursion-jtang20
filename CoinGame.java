public class CoinGame {
    public static void main(String args[]){ //1 is the player with the first move, the negative of player is the other player
        Winner(30, 1);
        System.out.println(strats + " strats");
        System.out.println(winner + " winner");
    }

    public static int strats;
    public static int winner;

    public static void Winner(int coins, int player){
        if(coins>-1){
            if(coins==0){
                strats++;
                winner = -player;
            } else {
                if((coins-1)%3==0){
                    Winner(coins-1,-player);
                    Winner(coins-4,player);
                } else if ((coins-2)%3==0){
                    Winner(coins-2,-player);
                } else {
                    Winner(coins-1,-player);
                    Winner(coins-2,-player);
                    Winner(coins-4,-player);
                }
            }
        }
    }

}
