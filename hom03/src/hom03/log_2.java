/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hom03;

/**
 * Basic algorithm to compute the integer part of log_2(n)
 * @author Jacob Huesman
 */
public class log_2 {
    public static int log_2(int n) {
        if(n < 2) {
            return 0;
        } else {
            return 1 + log_2(n / 2);
        }
    }
}
