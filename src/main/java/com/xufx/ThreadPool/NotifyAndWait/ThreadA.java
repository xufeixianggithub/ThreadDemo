package com.xufx.ThreadPool.NotifyAndWait;

class ThreadA

{

    public static void main(String[] args)

    {

      ThreadB b=new ThreadB();

      b.start();

      System.out.println("b is start....");

      synchronized(b)//括号里的b是什么意思,起什么作用?

      {

          System.out.println("Waiting for b to complete...");


          b.notify();
          System.out.println("Middle Total is :"+b.total);
          System.out.println("Completed.Now back to B thread");

      }

      System.out.println("Main Total is :"+b.total);

     }

}