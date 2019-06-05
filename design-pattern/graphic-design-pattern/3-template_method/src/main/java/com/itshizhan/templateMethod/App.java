package com.itshizhan.templateMethod;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       AbstractDisplay d1 = new CharDisplay('H');
       AbstractDisplay d2 = new StringDisplay("Hello,world.");
       AbstractDisplay d3 = new StringDisplay("您好，世界。");
       d1.display();
       d2.display();
       d3.display();
    }
}
