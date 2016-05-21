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

    public static boolean NumberFormatMinMax(String number, int min, int max) {
        try {
            int number_format = Integer.parseInt(number);
            if(number_format < min || number_format > max){
                throw new Exception();
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public static boolean StringFormatMinMax(String input, int minlenght, int maxlenght) {
        if(input.length() < minlenght || input.length() > maxlenght){
            return false;
        }
        return true;
    }
}
