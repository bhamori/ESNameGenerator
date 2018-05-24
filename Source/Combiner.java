
/**
 * @Botond Hamori
 * @v0.24.05a
 */

import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Combiner
{
    String prefixFileFirst;
    String suffixFileFirst;
    
    String prefixFileLast;
    String suffixFileLast;
    
    Input input = new Input();
    
    String firstCombined = "";
    String tempStr;
    
    List<String> listOfNames = new ArrayList<String>(); //first names
    List<String> listOfLast = new ArrayList<String>(); //last names
    
    List<String> firstPre = new ArrayList<String>();
    List<String> firstSuff = new ArrayList<String>();
    List<String> lastPre = new ArrayList<String>();
    List<String> lastSuff = new ArrayList<String>();
    

    List<String> imperialMid = new ArrayList<String>();
    List<String> redguardMid = new ArrayList<String>();
    List<String> redguardSuff2 = new ArrayList<String>();
    int race = input.raceID();

    
    int i;
    int j;
    



    public void Combiner()
    {
        //input.start();
        if (race != 1 && race != 8 && race != 9)
        {
            this.prefixFileFirst = input.prefixFirst();
            this.suffixFileFirst = input.suffixFirst();
            this.prefixFileFirst = input.prefixLast();
            this.suffixFileFirst = input.suffixLast();
            
            this.firstName();
        
            if(race != 5 && race != 6)
            {
               this.lastName(); 
            }            
        }

    }    
    
    public void firstName()
    {
        i = 0;
        j = 0;
        
        if (race == 5)
        {
           try
           {
                Scanner fnp = new Scanner(new File(input.imperialPref()));
                //System.out.println(input.prefixFirst());
                while(fnp.hasNext())
                {
                    firstPre.add(fnp.next());
                }
                fnp.close();
                
                Scanner fnm = new Scanner(new File(input.imperialMid()));
                while(fnm.hasNext())
                {
                    imperialMid.add(fnm.next());
                }
                
                Scanner fns = new Scanner(new File(input.imperialSuff()));
                while(fns.hasNext())
                {
                    firstSuff.add(fns.next());
                }
                fns.close();
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
            
            while(i < firstPre.size())
            {
                while(j < firstSuff.size())
                {
                    tempStr = firstPre.get(i) + firstSuff.get(j);
                    listOfNames.add(tempStr);
                    //System.out.println(tempStr);
                    tempStr = "";
                    j++;
                }
                
                j = 0;
                i++;
            }
            
            int a = 0;
            int b = 0;
            int c = 0;
            while (a < firstPre.size())
            {
                while(b < imperialMid.size())
                {
                    while(c < firstSuff.size())
                    {
                        tempStr = firstPre.get(a) + imperialMid.get(b) + firstSuff.get(c);
                        listOfNames.add(tempStr);
                        tempStr = "";
                        c++;
                    }
                    c = 0;
                    b++;
                }
                b = 0;
                a++;
            }                       
        }
        
        else
        {
            try
            {
                Scanner fnp = new Scanner(new File(input.prefixFirst()));
                
                while(fnp.hasNext())
                {
                    firstPre.add(fnp.next());
                }
                fnp.close();
                
                Scanner fns = new Scanner(new File(input.suffixFirst()));
                while(fns.hasNext())
                {
                    firstSuff.add(fns.next());
                }
                fns.close();
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
            
            while(i < firstPre.size())
            {
                while(j < firstSuff.size())
                {
                    tempStr = firstPre.get(i) + firstSuff.get(j);
                    listOfNames.add(tempStr);
                    //System.out.println(tempStr);
                    tempStr = "";
                    j++;
                }
                
                j = 0;
                i++;
            }             
        }
        

    }
    
    public String getFirstName(int pos)
    {
        return this.listOfNames.get(pos);
    }
    
    public void lastName()
    {
        //int race = input.raceID();
        i = 0;
        j = 0;
        tempStr = "";
        //System.out.println("this: " + prefixFileLast);
        //if(race != 6)
        //{
        try
        {
            Scanner lnp = new Scanner(new File(input.prefixLast()));
            while(lnp.hasNext())
            {
                lastPre.add(lnp.next());
            }
            lnp.close();
            
            Scanner lns = new Scanner(new File(input.suffixLast()));
            while(lns.hasNext())
            {
                lastSuff.add(lns.next());
            }
            lns.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        
        while(i < lastPre.size())
        {
            while(j < lastSuff.size())
            {
                if (race == 7)
                {
                    tempStr += /*" " + */lastPre.get(i) + lastSuff.get(j);;
                }
                else
                {
                   tempStr = lastPre.get(i) + lastSuff.get(j); 
                }
                listOfLast.add(tempStr);
                //System.out.println(tempStr);
                tempStr = "";
                j++;
            }
            
            j = 0;
            i++;
        }            
        //}

    }
    
    public String getLastName(int pos)
    {
        return this.listOfLast.get(pos);
    }
    
    public int getFirstLength()
    {
        return this.listOfNames.size();
    }
    
    public int getLastLength()
    {
        return this.listOfLast.size();
    }
}
