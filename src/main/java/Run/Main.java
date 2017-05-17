/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Run;

import DomainLayer.Controller;

/**
 *
 * @author mustafahakimi
 */
public class Main {
    public static void main(String[] args) {
        
        Controller c = new Controller();
        
        c.getAuthor("1");
        System.out.println("");
        c.getLocation("1000501");
        System.out.println("");
        c.getBook("1");
    }
}
