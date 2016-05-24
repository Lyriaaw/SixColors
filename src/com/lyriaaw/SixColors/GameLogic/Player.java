package com.lyriaaw.SixColors.GameLogic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * (commentaires)
 *
 * @author Amalric Lombard de Buffières <amalric.debuffieres@icloud.com>
 * @version 1.0.0
 */
public class Player {

    private final int id;        // Allow us to determinate the player easily

    private CaseColor currentCaseColor;

    private List<Case> belongedCases;


    public Player(int id) {
        this.id = id;

        belongedCases = new ArrayList<>();



    }



    public CaseColor getCurrentCaseColor() {
        return currentCaseColor;
    }

    public void setCurrentCaseColor(CaseColor currentCaseColor) {
        this.currentCaseColor = currentCaseColor;
    }


    public List<Case> getBelongedCases() {
        return belongedCases;
    }

    public void setBelongedCases(List<Case> belongedCases) {
        this.belongedCases = belongedCases;
    }

    public int getId() {
        return id;
    }


    public void addCase(Case caseAdded) {

        belongedCases.add(caseAdded);

        caseAdded.setBelonged(this.getId(), this.getCurrentCaseColor());




    }


    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", currentCaseColor=" + currentCaseColor +
                ", belongedCases=" + belongedCases.size() +
                '}';
    }



    /**
     * This method allow the user to select a color from the console
     */
    public void selectColorFromConsole() {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        CaseColor selectedColor = null;
        String selectedColorChar = ".";



        // read letter from the user
        do {
            System.out.print("Which color do you want to select  : " );
            try {
                selectedColorChar = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            selectedColor = CaseColor.getCaseColorFromLetter(selectedColorChar);

            // System.out.println(selectedColor.toString());

            // if (selectedColor == Color.VOID) System.err.println("Color must not be void");

        } while (selectedColor == CaseColor.VOID);      // While loop help be sure that the user selected a real color

        this.currentCaseColor = selectedColor;

    }


    /**
     * This method search for cases that will belong to the current player
     *
     */
    public void spreadBelong(Case[][] grid, int gridZise) {


    }



    public int getAmountOfBelongedCase() {
        return this.belongedCases.size();
    }

    public void setNewColor(CaseColor currentCaseColor) {
        this.currentCaseColor = currentCaseColor;

        for (Case currentCase : belongedCases) {
            currentCase.setColor(currentCaseColor);
        }
    }











}
