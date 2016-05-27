package com.lyriaaw.SixColors.GameLogic;

/**
 * (commentaires)
 *
 * @author Amalric Lombard de Buffières <amalric.debuffieres@icloud.com>
 * @version 1.0.0
 */
public class Case {


    private boolean belonged;

    private int player;

    private CaseColor caseColor;

    private int x, y;




    public Case() {
        this.caseColor = CaseColor.getRandomCaseColor();
        belonged = false;
        player = -1;
    }

    /**
     * Generate a random case
     * @param x
     * @param y
     */
    public Case(int x, int y) {
        this.x = x;
        this.y = y;

        this.caseColor = CaseColor.getRandomCaseColor();
        belonged = false;
        player = -1;

    }

    public Case(CaseColor caseColor) {
        this.caseColor = caseColor;
        belonged = false;
        player = -1;
    }

    public Case(int player, CaseColor caseColor) {
        this.player = player;
        this.caseColor = caseColor;
        belonged = true;
    }



    public boolean isBelonged() {
        return belonged;
    }

    public void setBelonged(boolean belonged) {
        this.belonged = belonged;
    }

    public int getPlayer() {
        return player;
    }

    public void setPlayer(int player) {
        this.player = player;
    }

    public CaseColor getColor() {
        return caseColor;
    }

    public void setColor(CaseColor caseColor) {
        this.caseColor = caseColor;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public CaseColor getCaseColor() {
        return caseColor;
    }

    public void setCaseColor(CaseColor caseColor) {
        this.caseColor = caseColor;
    }

    public void setBelonged(int player, CaseColor caseColor) {
        belonged = true;

        this.player = player;
        this.caseColor = caseColor;
    }


    public String displayMyself() {

        String message = "[";

        //message += (this.player == null) ? this.color.getColorSummary().toLowerCase() + ",/]" : this.color.getColorSummary().toUpperCase() + "," + this.player.getId() + "]";

        if (this.belonged) {
            message += this.caseColor.getCaseColorSummary().toUpperCase() + "," + this.player + "]";
        } else {
            message += this.caseColor.getCaseColorSummary().toLowerCase() + ",/]";
        }




        return message;


    }



    public Case[][] infectNeighbour(Case[][] grid, Player player) {

        int gridSize = grid.length;

        if (!belonged) setBelonged(player.getId(), player.getCurrentCaseColor());
        System.out.println("Searching in case[" + y + "][" + x + "]");

        // run throw all the neighbours and infect them
        for (int jt = y - 1; jt <= y + 1; jt++) {
            for (int it = x - 1; it <= x + 1; it++) {
                int xSearched = TableGame.getSafeCoordinate(it, gridSize);
                int ySearched = TableGame.getSafeCoordinate(jt, gridSize);

                // System.out.println("it = " + it + " jt = " + jt + " X = " + xSearched + " Y = " + ySearched);

                if (xSearched != x && ySearched != y) {
                    if (grid[ySearched][xSearched].getCaseColor() == getCaseColor()) {
                        System.out.println("Searching in new case");
                        grid[ySearched][xSearched].infectNeighbour(grid, player);
                    }
                }

            }
        }

        return grid;

    }





}
