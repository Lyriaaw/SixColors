package com.lyriaaw.SixColors.GameLogic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 * (commentaires)
 *
 * @author Amalric Lombard de Buffières <amalric.debuffieres@icloud.com>
 * @version 1.0.0
 */
public enum CaseColor {



    ORANGE("o"),
    YELLOW("y"),
    GREEN("g"),
    BLUE("b"),
    PURPLE("p"),
    RED("r"),


    VOID(".");


    private String colorSummary;

    CaseColor(String colorSummary) {
        this.colorSummary = colorSummary;
    }

    public String getCaseColorSummary() {
        return colorSummary;
    }


    /**
     * Return the color from the colorSummary
     * @param letter
     * @return
     */
    public static CaseColor getCaseColorFromLetter(String letter) {
        for (CaseColor color : CaseColor.values()) {
            if (color.getCaseColorSummary().equals(letter)) return color;
        }

        return CaseColor.VOID;

    }







    /**
     * Return a totally random CaseColor among available CaseColors;
     *
     * This method will not return CaseColor.VOID !!
     * @return
     */
    public static CaseColor getRandomCaseColor() {
        List<String> colorList = new ArrayList<>();



        for (CaseColor color : CaseColor.values()) {
            if (color != CaseColor.VOID) colorList.add(color.getCaseColorSummary());
        }


        Random random = new Random();       // Java object to take Random value

        int colorListSize = colorList.size();
        int randomIndex = random.nextInt(colorListSize);
        String colorChar = colorList.get(randomIndex);


        return getCaseColorFromLetter(colorChar);


    }



}
