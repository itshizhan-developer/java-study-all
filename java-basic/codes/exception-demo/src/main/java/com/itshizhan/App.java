package com.itshizhan;

public class App 
{
    public static void main( String[] args )
    {
        /*

        try {
            int [] arr = {1,2,3};
            System.out.println(arr[5]);
            // 异常后的代码不会执行
            int a = 1/0;
            System.out.println("不会执行");
        }catch (ArithmeticException e){
            System.out.println(e.getMessage());
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println(e.getStackTrace());
        }catch (Exception e){
            System.out.println("其它异常");
        }finally {
            System.out.println("异常处理完毕");
        }
        */
        /**
         输出结果：
         / by zero
         异常处理完毕
         */
//
//        try {
//            int i = 1/0;
//        }catch (Exception e){
//            System.out.println(e.toString());
//        }

        try {
            int i = 1/0;
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
