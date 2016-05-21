/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.fpt.project.bo;

/**
 *
 * @author MyPC
 */
public class Validation {

    String showErrors;

    public Validation() {
        showErrors = "";

    }

    public void setShowErrors(String showErrors) {
        this.showErrors = showErrors;
    }

    public boolean NumberFormatMinMax(String number, int min, int max, String name) {
        try {
            int number_format = Integer.parseInt(number);
            if (number_format < min || number_format > max) {
                showErrors += name + " must be greater than " + min + " and less than " + max + "\n";
                throw new Exception();
            }
            return true;
        } catch (Exception e) {
            showErrors += name + "must be number";
            return false;
        }
    }

    public boolean StringFormatMinMax(String input, int minlenght, int maxlenght, String name) {
        if (input.length() < minlenght || input.length() > maxlenght) {
            showErrors += name + " lenght must be greater than " + minlenght + " and less than " + maxlenght + "\n";
            return false;
        }
        return true;
    }

    public boolean StringFormatOnlyLetterAndDigits(String input, int minlenght, int maxlenght, String name) {
        if (input.matches("^[\\w]{" + minlenght + "," + maxlenght + "}$")) {
            showErrors += name + " must be letter or number \n";
            return true;
        }
        return false;
    }

    public boolean isEmpltyOrNull(String input, String name) {
        if (input == null) {
            showErrors += name + " is null \n";
            return false;
        }
        if (input.equals("")) {
            showErrors += name + " is emplty \n";
            return false;
        }
        return true;
    }

    public String getShowErrors() {
        return showErrors;
    }

}
