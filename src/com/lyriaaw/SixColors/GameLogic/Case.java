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




    public Case() {
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





}
