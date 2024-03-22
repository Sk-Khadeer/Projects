package com.sampletest;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class StarEx extends Thread{
    public void run()
    {
    	
    	try{Thread.sleep(1000);}catch(InterruptedException e){System.out.println(e);}
        
            for(int i=1;i<=5;i++)
            {
                for(int j=1;j<=35;j++)
                {
                    try{Thread.sleep(15);}catch(InterruptedException e){System.out.println(e);}
                    if((i==1 && (j==1|| j==5||(j>=7&&j<=10)||j==12||j==13||j==14||(j>=17&&j<=20)))||
                       (i==2 && (j==1 ||j==2|| j==4 ||j==5|| j==7 || j==12 || j==15 || j==17))||
                    	(i==3 &&(j==1||j==3 ||j==5||(j>=7 && j<=10)|| (j>=12&&j<=14)  || (j>=17&&j<=20) ))||
                    	(i==4 &&(j==1 ||j==5||j==7|| j==12||j==14||j==17))||
                    	(i==5 &&(j==1 || j==5||(j>=7&&j<=10)||j==12||j==15||j>=17&&j<=20)))
                        System.out.print("# ");
                    else
                         System.out.print("  ");
                }
                System.out.println();
            }
            System.out.println();
            System.out.println();
            System.out.println();
            try{Thread.sleep(1000);}catch(InterruptedException e){System.out.println(e);}
            System.out.println();
                for(int i=1;i<=5;i++)
                {
                    for(int j=1;j<=22;j++)
                    {
                        try{Thread.sleep(15);}catch(InterruptedException e){System.out.println(e);}
                        if((i==1 && ((j>=1&&j<=3)|| j==8||(j>=12&&j<=14)||(j>=17&&j<=20)))||
                           (i==2 && (j==1 || j==4 || j==7 ||j==9|| j==12 || j==15 || j==17))||
                        	(i==3 &&((j>=1&&j<=3) ||(j>=6 && j<=10)|| j==12 || j==15||(j>=17&&j<=20) ))||
                        	(i==4 &&(j==1 ||j==4||j==6||j==10|| j==12||j==15||j==17))||
                        	(i==5 &&((j>=1&&j<=3) || j==6||j==10||(j>=12&&j<=14)||(j>=17&&j<=20))))
                            System.out.print("* ");
                        else
                             System.out.print("  ");
                    }
                    System.out.println();
                }
                System.out.println();
                System.out.println();
                System.out.println();
                try{Thread.sleep(1000);}catch(InterruptedException e){System.out.println(e);}
                System.out.println();
                    for(int i=1;i<=5;i++)
                    {
                        for(int j=1;j<=22;j++)
                        {
                            try{Thread.sleep(50);}catch(InterruptedException e){System.out.println(e);}
                            if((i==1 && ((j>=1&&j<=3)|| j==6||j==9||j==13||(j>=17&&j<=21)))||
                               (i==2 && (j==1 || j==4||j==6 ||j==9 || j==12 || j==14 || j==19))||
                            	(i==3 &&((j>=1&&j<=3) ||(j>=6 && j<=9)||(j>=11&&j<=15)||j==19))||
                            	(i==4 &&(j==1 ||j==4||j==6||j==9|| j==11||j==15||j==19))||
                            	(i==5 &&((j>=1&&j<=3) || j==6||j==9|| j==11||j==15||(j>=17&&j<=21))))
                                System.out.print("~ ");
                            else
                                 System.out.print("  ");
                        }
                        System.out.println();
                    }

                    try{Thread.sleep(1000);}catch(InterruptedException e){System.out.println(e);}
                    System.out.println();
                    System.out.println();
                    System.out.println();
                    try{Thread.sleep(50);}catch(InterruptedException e){System.out.println(e);}
                    
                    System.out.println("           *     *   *       *   ");
                    System.out.println("           *   *     *       *   ");
                    System.out.println("           * *       *       *    ");
                    System.out.println("           *   *     *       *     ");
                    System.out.println("           *     *     * * *    ");
                    System.out.println();
                    System.out.println();
                    System.out.println();
                    try{Thread.sleep(1000);}catch(InterruptedException e){System.out.println(e);}
                    System.out.println();
                        for(int i=1;i<=5;i++)
                        {
                            for(int j=1;j<=40;j++)
                            {
                                try{Thread.sleep(15);}catch(InterruptedException e){System.out.println(e);}
                                if((i==1 && ((j>=2&&j<=4)|| j==8||(j>=12&&j<=14)||j==22||(j>=28&&j<=30)||(j>=34&&j<=37)))||
                                   (i==2 && (j==1 || j==7||j==9 || j==12 || j==15 || j==22||j==27||j==31||j==33))||
                                	(i==3 &&((j>=1&&j<=4) ||(j>=6 && j<=10)||(j>=12&&j<=14)||j==22||j==27||j==31||j==33||(j>=35&&j<=37)))||
                                	
                                	(i==4 &&(j==4 ||j==6||j==10||j==12|| j==15||j==22||j==27||j==31||j==33||j==37))||
                                	(i==5 &&((j>=1&&j<=3) || j==6||j==10||(j>=12&&j<=14)||(j>=22&&j<=25)||(j>=28&&j<=30)||(j>=34&&j<=37))))
                                    System.out.print("# ");
                                else
                                     System.out.print("  ");
                            }
                            System.out.println();
                        }
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        
                        try{Thread.sleep(1000);}catch(InterruptedException e){System.out.println(e);}
                        System.out.println();
                            for(int i=1;i<=5;i++)
                            {
                                for(int j=1;j<=32;j++)
                                {
                                    try{Thread.sleep(15);}catch(InterruptedException e){System.out.println(e);}
                                    if((i==1 && ((j>=1&&j<=3)||(j>=7&&j<=9)||j==12||(j>=18&&j<=20)))||
                                       (i==2 && (j==1 || j==4||j==6 || j==10 || j==12 || j==17||j==21))||
                                    	(i==3 &&((j>=1&&j<=3) ||j==6 || j==10 || j==12 || j==17||j==21))||
                                    	
                                    	(i==4 &&(j==1 || j==4||j==6 || j==10 || j==12 || j==17||j==21))||
                                    	(i==5 &&((j>=1&&j<=3)||(j>=7&&j<=9)||(j>=12&&j<=15)||(j>=18&&j<=20))))
                                        System.out.print("@ ");
                                    else
                                         System.out.print("  ");
                                }
                                System.out.println();
                            }
                            System.out.println();
                            System.out.println();
                            System.out.println();
        try{Thread.sleep(1000);}catch(InterruptedException e){System.out.println(e);}
        for(int i=1;i<=7;i++)
        {
            for(int j=1;j<=5;j++)
            {
                if(i==1&& j==1||i==1&&j==5||i==2&&j==1||i==2&&j==5||i==3&& j==1||i==3&&j==5||i==4&&j<=5||i==5&&j==1||i==5&&j==5||i==6&&j==1||i==6&&j==5||i==7&&j==1||i==7&&j==5)
                    System.out.print("H ");
                else
                     System.out.print("  ");
            }
            System.out.println();
        }
        try{Thread.sleep(1000);}catch(InterruptedException e){System.out.println(e);}
        System.out.println();
        for(int i=0;i<6;i++)//AAA
        {
            for(int j=0;j<5;j++)
            {
                if((i==0 && j==2)||(i==1 && (j==1 || j==3)) || (i==2 && (j==0 || j==4))||(i==3)||((i==4 || i==5)&&(j==0 || j==4)))
                    System.out.print("A ");
                else
                    System.out.print("  ");
            }
            System.out.println();
        }
        try{Thread.sleep(1000);}catch(InterruptedException e){System.out.println(e);}
        System.out.println();
        for(int i=1;i<=6;i++)
        {
            for(int j=1;j<=5;j++)
            {
                if(i==1&& j<5||i==2&&j<=1||i==2&&j>=5||i==3&&j<=1||i==3&&j>=5||i==4&&j<5||i==5&&j<=1||i==6&&j<=1)
                    System.out.print("P ");
                else
                     System.out.print("  ");
            }
            System.out.println();
        }
        try{Thread.sleep(1000);}catch(InterruptedException e){System.out.println(e);}
        System.out.println();
        for(int i=1;i<=6;i++)
        {
            for(int j=1;j<=5;j++)
            {
                if(i==1&& j<5||i==2&&j<=1||i==2&&j>=5||i==3&&j<=1||i==3&&j>=5||i==4&&j<5||i==5&&j<=1||i==6&&j<=1)
                    System.out.print("P ");
                else
                     System.out.print("  ");
            }
            System.out.println();
        }
        try{Thread.sleep(1000);}catch(InterruptedException e){System.out.println(e);}
        System.out.println();
        for(int i=1;i<=6;i++)
        {
            for(int j=1;j<=5;j++)
            {
                if((i==1 && (j==1 || j==5))||(i==2 && (j==2 || j==4))||(i==3 || i==4 || i ==5) &&(j==3))
                    System.out.print("Y ");
                else
                     System.out.print("  ");
            }
            System.out.println();
        }
        try{Thread.sleep(1000);}catch(InterruptedException e){System.out.println(e);}
        System.out.println();
        for(int i=1;i<=7;i++)
        {
            for(int j=1;j<=5;j++)
            {
                if(i==1&& j<5||i==2&&j<=1||i==2&&j>=5||i==3&&j==1||i==3&&j>=5||i==4&&j<5||i==4&&j>5||i==5&&j==1||i==5&&j>=5||i==6&&j==1||i==6&&j>=5||i==7&&j<5)
                    System.out.print("B ");
                else
                     System.out.print("  ");
            }
            System.out.println();
        }
        try{Thread.sleep(1000);}catch(InterruptedException e){System.out.println(e);}
        System.out.println();
    for(int i=1;i<=7;i++)
    {
        for(int j=1;j<=5;j++)
        {
            if(i==1&& j<=5||i==2&&j==5||i==3&&j==5||i==4&&j==5||i==5&&j==5||i==6&&j==5||i==7&&j<=5)
                System.out.print("I ");
            else
                 System.out.print(" ");
        }
        System.out.println();
    }
    try{Thread.sleep(1000);}catch(InterruptedException e){System.out.println(e);}
    System.out.println();
            for(int i=1;i<=7;i++)
            {
                for(int j=1;j<=5;j++)
                {
                    if(i==1&& j<5||i==2&&j<=1||i==2&&j>=5||i==3&&j==1||i==3&&j>=5||i==4&&j<5||i==4&&j>5||i==5&&j==1||i==5&&j==3||i==6&&j==1||i==6&&j==4||i==7&&j==1||i==7&&j==5)
                        System.out.print("R ");
                    else
                         System.out.print("  ");
                }
                System.out.println();
            }
            try{Thread.sleep(1000);}catch(InterruptedException e){System.out.println(e);}
            System.out.println();
    for(int i=1;i<=7;i++)
        {
            for(int j=1;j<=5;j++)
            {
                if(i==1&& j<=5||i==2&&j==5||i==3&&j==5||i==4&&j==5||i==5&&j==5||i==6&&j==5||i==7&&j==5)
                    System.out.print("T ");
                else
                     System.out.print(" ");
            }
            System.out.println();
        }
    try{Thread.sleep(1000);}catch(InterruptedException e){System.out.println(e);}
    System.out.println();
    for(int i=1;i<=7;i++)
    {
        for(int j=1;j<=5;j++)
        {
            if(i==1&& j==1||i==1&&j==5||i==2&&j==1||i==2&&j==5||i==3&& j==1||i==3&&j==5||i==4&&j<=5||i==5&&j==1||i==5&&j==5||i==6&&j==1||i==6&&j==5||i==7&&j==1||i==7&&j==5)
                System.out.print("H ");
            else
                 System.out.print("  ");
        }
        System.out.println();
    }
    try{Thread.sleep(1000);}catch(InterruptedException e){System.out.println(e);}
    System.out.println();
    //d
    for(int i=1;i<=7;i++)
        {
            for(int j=1;j<=5;j++)
            {
                if(i==1&& j<5||i==2&&j==1||i==2&&j>=5||i==3&&j==1||i==3&&j>=5||i==4&&j==1||i==4&&j>=5||i==5&&j==1||i==5&&j>=5||i==6&&j==1||i==6&&j>=5||i==7&&j<5)
                    System.out.print("D ");
                else
                     System.out.print("  ");
            }
            System.out.println();
        }
    try{Thread.sleep(1000);}catch(InterruptedException e){System.out.println(e);}
        System.out.println();
    //a
    for(int i=1;i<=7;i++)
    {
        for(int j=1;j<=5;j++)
        {

            if(i==1&& j==2||i==1&&j==3||i==1&&j==4||i==2&&j<=1||i==2&&j>=5||i==3&&j==1||i==3&&j>=5||i==4&&j<=5||i==5&&j==1||i==5&&j>=5||i==6&&j==1||i==6&&j>=5||i==7&&j==1||i==7&&j>=5)
                System.out.print("A ");
            else
                 System.out.print("  ");
        }
        System.out.println();
    }
    try{Thread.sleep(1000);}catch(InterruptedException e){System.out.println(e);}
    System.out.println();
    for(int i=1;i<=6;i++)
    {
        for(int j=1;j<=5;j++)
        {
            try{Thread.sleep(30);}catch(InterruptedException e){System.out.println(e);}
            if((i==1 && (j==1 || j==5))||(i==2 && (j==2 || j==4))||(i==3 || i==4 || i ==5) &&(j==3))
                System.out.print("Y ");
            else
                 System.out.print("  ");
        }
        System.out.println();
    }
    System.out.println();
    System.out.println();
    System.out.println();
    try{Thread.sleep(1000);}catch(InterruptedException e){System.out.println(e);}
	 System.out.println(" ###    ####   #####  #####  ####       #       ####  ");
     System.out.println("#       #   #  #      #      #    #    #  #     #   #");
     System.out.println("####    ###    ####   ####   #    #   ######    ####");
     System.out.println("   #    #  #   #      #      #    #   #    #    # #");
     System.out.println("###     #   #  #####  #####  ####     #    #    #   #");
//    System.out.println();
//        for(int i=1;i<=5;i++)
//        {
//            for(int j=1;j<=35;j++)
//            {
//                try{Thread.sleep(80);}catch(InterruptedException e){System.out.println(e);}
//                if((i==1 && (j==1||j==4 || j==6||j==9||j==13||j==17||(j>=22&&j<=25)||(j>=27&&j<=30)||j==32))||
//                   (i==2 && (j==1 ||j==3|| j==6 || j==9 || j==12 || j==14 || j==17|| j==22 || j==27||j==32))||
//                	(i==3 &&(j==1||j==2 ||(j>=6 && j<=9)|| (j>=11&&j<=15) || j==17 || (j>=22&&j<=25) || (j>=27 && j<=30)||j==32 ))||
//                	(i==4 &&(j==1 ||j==3|| j==6||j==9||j==11||j==15||j==17||j==22||j==27||j==32))||
//                	(i==5 &&(j==1 || j==4||j==6||j==9||j==11||j==15||(j>=17&&j<=20)||(j>=22&&j<=25)||(j>=27&&j<=30)||(j>=32&&j<=35))))
//                    System.out.print("# ");
//                else
//                     System.out.print("  ");
//            }
//            System.out.println();
//        }
        System.out.println();
        System.out.println();
        try{Thread.sleep(80);}catch(InterruptedException e){System.out.println(e);}
        
        
        System.out.println("                                   ~~");
        System.out.println("                                   ||");
        System.out.println("                                   ||");
        System.out.println("                           ~~~~~~~~~~~~~~~~~   ");
        System.out.println("                          |                 |");
        System.out.println("                          |  DEALING STAR   |");
        System.out.println("                      ____|                 |___");
        System.out.println("                     |     `````````````````    |");
        System.out.println("                     |     Keep Rocking Bro!    |");
        System.out.println("                _____|                          |_____   ");
        System.out.println("               |      ```````````````````````````     | ");
        System.out.println("               |       Happy 24th Birthday CEO!   | ");
        System.out.println("               |______________________________________|    ");


         
        
    }
    
   
    public static void main(String[] args) throws IOException {
        StarEx s =new StarEx();
        s.start();
        
       
       
}}