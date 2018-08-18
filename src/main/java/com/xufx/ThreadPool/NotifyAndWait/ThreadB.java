package com.xufx.ThreadPool.NotifyAndWait;

class ThreadB extends Thread

{

    int total;

    public void run()

    {

      synchronized(this)

      {

        System.out.println("ThreadB is running..");

        for (int i=0;i<100;i++ )

        {

          total +=i;

          System.out.println("ThreadB total is "+total);
            try {
                if(i==50){
                    wait();
                }


            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        //notify();

      }

    }

}