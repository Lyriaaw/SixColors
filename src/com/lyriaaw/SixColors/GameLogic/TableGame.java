package com.lyriaaw.SixColors.GameLogic;

import java.util.ArrayList;
import java.util.List;

/**
 * (commentaires)
 *
 * @author Amalric Lombard de Buffières <amalric.debuffieres@icloud.com>
 * @version 1.0.0
 */
public class TableGame {


    private List<Player> playerList = new ArrayList<>();
    private Case[][] grid;

    private Player currentPlayer;

    private int gridSize = 13;

    private int playerAmount = 2;
    private int playerIndex = 0;





    public TableGame() {
        // gameLoop();
        //initGame();


    }

    public int getPlayerAmount() {
        return playerAmount;
    }

    public void setPlayerAmount(int playerAmount) {
        this.playerAmount = playerAmount;
    }

    public int getGridSize() {
        return gridSize;
    }

    public void setGridSize(int gridSize) {
        this.gridSize = gridSize;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public Case[][] getGrid() {
        return grid;
    }

    public void setGrid(Case[][] grid) {
        this.grid = grid;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }

    public void gameLoop() {
        System.out.println("Launching the game");


        initGame();


    }

    /**
     * This method init a game.
     * To reload a new game you must call this method again.
     */
    public void initGame() {
        System.out.println("Initing the game");

        // generating the grid
        grid = generateRandomGrid(gridSize);


        // Creating players
        for (int it = 0; it < playerAmount; it++) {

            currentPlayer = new Player(it + 1);
            currentPlayer.setCurrentCaseColor(CaseColor.values()[it]);

            if (it == 0) {
                currentPlayer.addCase(grid[0][0]);
            } else if (it == 1){
                currentPlayer.addCase(grid[gridSize - 1][gridSize - 1]);

            }


            playerList.add(currentPlayer);


        }

        // defining the player who will play
        currentPlayer = playerList.get(0);
        int currentPlayerIndex = 0;

    }

    /**
     * Method called when a player select his color
     * @param selectedCaseColor
     */
    public void somebodyPlayed(CaseColor selectedCaseColor) {

        // setting the selectedColor to the player
        currentPlayer.setNewColor(selectedCaseColor);


        infectGridWithColor(currentPlayer);


        // running throw players
        playerIndex++;
        if (playerIndex == playerAmount) playerIndex = 0;

        // setting the new currentPlayer
        currentPlayer = playerList.get(playerIndex);

    }




    public void infectGridWithColor(Player player) {

        // start the infection from the first case of the pplayer
        grid = currentPlayer.getBelongedCases().get(0).infectNeighbour(grid, player);

        //displayGrid();

    }



















    /**
     * Generate a random size*size game grid
     * @param size
     * @return
     */
    public Case[][] generateRandomGrid(int size) {
        System.out.println("generating a random grid ...");

        Case[][] grid = new Case[size][size];

        for (int jt = 0; jt < size; jt++) {
            for (int it = 0; it < size; it++) {
                grid[jt][it] = new Case(it, jt);
            }
        }
        return grid;
    }





    /**
     * Display the current game grid
     */
    public void displayGrid() {
        System.out.println("\nDisplaying the grid");
        int size = this.grid.length;

        for (int jt = 0; jt < size; jt++) {
            for (int it = 0; it < size; it++) {
                System.out.print(grid[jt][it].displayMyself());
            }
            System.out.println("");
        }

        System.out.println("Grid dimension : " + gridSize + " * " + gridSize + "\n");

    }


    /**
     * Return the safe coordinate of a index (V and H)
     * Avoid IndexArrayOutOfBoundException
     *
     * @param askedCoordinate
     * @return
     */
    public static int getSafeCoordinate(int askedCoordinate, int gridSize) {
        if (askedCoordinate >= gridSize) return gridSize - 1;
        else if (askedCoordinate < 0) return 0;
        else return askedCoordinate;
    }


}
