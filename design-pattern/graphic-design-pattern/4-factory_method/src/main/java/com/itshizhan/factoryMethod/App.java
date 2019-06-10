package com.itshizhan.factoryMethod;

import com.itshizhan.factoryMethod.framework.Factory;
import com.itshizhan.factoryMethod.framework.Product;
import com.itshizhan.factoryMethod.idcard.IDCardFactory;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        Factory factory = new IDCardFactory();
        Product card1 = factory.create("小明");
        Product card2 = factory.create("小红");
        Product card3 = factory.create("小刚");
        card1.use();
        card2.use();
        card3.use();

    }
}
