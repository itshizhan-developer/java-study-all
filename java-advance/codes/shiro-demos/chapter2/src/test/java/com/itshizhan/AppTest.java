package com.itshizhan;

import static org.junit.Assert.assertTrue;

import com.itshizhan.realms.MyRealm1;
import com.itshizhan.realms.MyRealm2;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.pam.AllSuccessfulStrategy;
import org.apache.shiro.authc.pam.AtLeastOneSuccessfulStrategy;
import org.apache.shiro.authc.pam.FirstSuccessfulStrategy;
import org.apache.shiro.authc.pam.ModularRealmAuthenticator;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * Unit test for simple Chapter2App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void testHelloWorld(){
        /** IniSecurityManagerFactory 已经废弃
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        SecurityManager securityManager = factory.getInstance();
        */
        DefaultSecurityManager securityManager = new DefaultSecurityManager();
        IniRealm iniRealm = new IniRealm("classpath:shiro.ini");
        securityManager.setRealm(iniRealm);

        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("wang","123");

        try {
            subject.login(token);
            System.out.println("是否有admin权限：" + subject.hasRole("admin"));
        }catch (AuthenticationException e){
            System.out.println("身份证验证失败:"+ e.getMessage());
        }

        Assert.assertEquals(true, subject.isAuthenticated()); //断言用户已经登录
        //6、退出
        subject.logout();

    }

    @Test
    public void testCustomRealm(){

        MyRealm1 myRealm1 = new MyRealm1();

        DefaultSecurityManager securityManager = new DefaultSecurityManager();
        securityManager.setRealm(myRealm1);


        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("zhang","123");

        try {
            subject.login(token);
            System.out.println("身份证验证成功:"+ subject.isAuthenticated());


        }catch (AuthenticationException e){
            System.out.println("身份证验证失败:"+ e.getMessage());
        }

        Assert.assertEquals(true, subject.isAuthenticated()); //断言用户已经登录
        //6、退出
        subject.logout();

    }

    @Test
    public void testCustomMultiRealm(){

        MyRealm1 myRealm1 = new MyRealm1();
        MyRealm2 myRealm2 = new MyRealm2();

        DefaultSecurityManager securityManager = new DefaultSecurityManager();
        //设置SecurityManager对象的认证策略
        ModularRealmAuthenticator modularRealmAuthenticator = new ModularRealmAuthenticator();
        modularRealmAuthenticator.setAuthenticationStrategy( new AtLeastOneSuccessfulStrategy());
        //modularRealmAuthenticator.setAuthenticationStrategy( new AllSuccessfulStrategy());

        securityManager.setAuthenticator(modularRealmAuthenticator);

        //securityManager.setRealm(myRealm1);
        //securityManager.setRealm(myRealm2);

        Set<Realm> realmHashSet = new HashSet<Realm>();
        realmHashSet.add(myRealm1);
        realmHashSet.add(myRealm2);
        //SecurityManager必须先设置Authenticator再设置Realm
        securityManager.setRealms(realmHashSet);


        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("wang","123");

        try {
            subject.login(token);
            System.out.println(String.format("认证结果为：%s", subject.isAuthenticated()));
            System.out.println("是否有admin权限：" + subject.hasRole("admin"));

        }catch (AuthenticationException e){
            System.out.println("认证失败");
            e.printStackTrace();
        }

        subject.logout();

        System.out.println(String.format("认证结果为：%s", subject.isAuthenticated()));



    }
}
