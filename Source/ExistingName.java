
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

public class ExistingName
{
    Input input = new Input();
    List<String> firstNames = new ArrayList<String>();
    List<String> lastNames = new ArrayList<String>();
    List<String> cyroArg = new ArrayList<String>();
    
    List<String> orsimerTitles = new ArrayList<String>();
    
    List<String> workingList = new ArrayList<String>();
    
    List<Integer> numbers = new ArrayList<Integer>();
    
    String tempStr;
    String workingValue = "";
    String contentCop = "";
    
    int race = input.raceID();
    
    public ExistingName()
    {
        this.firstName();
        if(race != 1 && race != 6)
        {
            this.lastName();
        }
    }
    
    public void firstName()
    {
        int i = 0;
        int j = 0;
        tempStr = null;
        try
        {
           Scanner firstScanner = new Scanner(new File(input.fullFirst()));
           while(firstScanner.hasNext())
           {
               workingList.add(firstScanner.next());
           }
            
           workingValue = workingList.toString();
           
           //System.out.println("workingValue length = " + workingValue.length());
           
           while(i < workingValue.length())
           {
               if(workingValue.charAt(i) >= 65 && workingValue.charAt(i) <= 90)
               {
                   contentCop += workingValue.charAt(i);
               }
               else if(workingValue.charAt(i) >= 97 && workingValue.charAt(i) <= 122)
               {
                   contentCop += workingValue.charAt(i);
               }
               else if(workingValue.charAt(i) == 39 || workingValue.charAt(i) == 45)
               {
                  contentCop += workingValue.charAt(i); 
               }
               else if(workingValue.charAt(i) == 61)
               {
                   contentCop += " ";
               }               
               else
               {
                   if(contentCop != "")
                   {
                       this.firstNames.add(contentCop);
                       contentCop = "";
                   }
               }
               i++;
           }
           
           if (race == 1)
           {
               int z = 0;
               String cyroValue = "";
               
               Scanner cyroScanner = new Scanner(new File(input.cyrodArg()));
               
               while(cyroScanner.hasNext())
               {
                   cyroArg.add(cyroScanner.next());
               }
                
               cyroValue = cyroArg.toString();
               
               //System.out.println("cyroValue length = " + cyroValue.length());
               //System.out.println("z = " + z);
               
               while(z < cyroValue.length())
               {
                   if(cyroValue.charAt(z) == 32)
                   {
                       contentCop += cyroValue.charAt(z);
                   }
                   if(cyroValue.charAt(z) >= 65 && cyroValue.charAt(z) <= 90)
                   {
                       contentCop += cyroValue.charAt(z);
                   }
                   else if(cyroValue.charAt(z) >= 97 && cyroValue.charAt(z) <= 122)
                   {
                       contentCop += cyroValue.charAt(z);
                   }
                   else if(cyroValue.charAt(z) == 39 || cyroValue.charAt(z) == 45)
                   {
                      contentCop += cyroValue.charAt(z); 
                   }
                   /*else if(workingValue.charAt(i) == 61)
                   {
                       contentCop += " ";
                   }*/              
                   else
                   {
                       if(contentCop != "")
                       {
                           if(contentCop.charAt(0) == 32)
                           {
                               contentCop = contentCop.substring(1);
                           }                                                 
                           this.firstNames.add(contentCop);
                           contentCop = "";
                       }
                   }
                   z++;
               }               
           }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    
    public void lastName()
    {
        try
        {
            if(race == 0 || race == 2 || race == 7)
            {
                int i = 0;
                int j = 0;
                
                tempStr = null;
                workingList.clear();
    
                Scanner lastScanner = new Scanner(new File(input.fullLast()));
                while(lastScanner.hasNext())
                {
                    workingList.add(lastScanner.nextLine());
                }
                
                workingValue = workingList.toString();
                
                while(i < workingValue.length())
                {
                   if(workingValue.charAt(i) == 32)
                   {
                       contentCop += workingValue.charAt(i); 
                   }
                   else if(workingValue.charAt(i) == 39 || workingValue.charAt(i) == 45)
                   {
                       contentCop += workingValue.charAt(i); 
                   }
                   else if(workingValue.charAt(i) >= 65 && workingValue.charAt(i) <= 90)
                   {
                       contentCop += workingValue.charAt(i); 
                   }
                   else if(workingValue.charAt(i) >= 97 && workingValue.charAt(i) <= 122)
                   {
                       contentCop += workingValue.charAt(i); 
                   }
                   else
                   {
                       if(contentCop != "")
                       {
                           if(contentCop.charAt(0) == 32)
                           {
                               contentCop =contentCop.substring(1);
                           }
                           //contentCop = formatStr.toString();
                           this.orsimerTitles.add(contentCop);
                           contentCop = null;
                       }
                   }
                    
                   i++;
                }
            }
            
            else if (race == 8)
            {
                int i = 0;
                int j = 0;

                tempStr = null;

                Scanner lastScanner = new Scanner(new File(input.fullLast()));
                while(lastScanner.hasNext())
                {
                    workingList.add(lastScanner.nextLine());
                }
                
                workingValue = workingList.toString();
                
                while(i < workingValue.length())
                {
                   if(workingValue.charAt(i) == 32)
                   {
                       contentCop += workingValue.charAt(i); 
                   }
                   else if(workingValue.charAt(i) == 39 || workingValue.charAt(i) == 45)
                   {
                       contentCop += workingValue.charAt(i); 
                   }
                   else if(workingValue.charAt(i) >= 65 && workingValue.charAt(i) <= 90)
                   {
                       contentCop += workingValue.charAt(i); 
                   }
                   else if(workingValue.charAt(i) >= 97 && workingValue.charAt(i) <= 122)
                   {
                       contentCop += workingValue.charAt(i); 
                   }
                   else
                   {
                       if(contentCop != "")
                       {
                           if(contentCop.charAt(0) == 32)
                           {
                               contentCop =contentCop.substring(1);
                           }
                           //contentCop = formatStr.toString();
                           this.lastNames.add(contentCop);
                           contentCop = "";
                       }
                   }
                    
                   i++;
                }
                
                workingValue = "";
                workingList.clear();
                i = 0;
                
                //titles
                Scanner titleScanner = new Scanner(new File(input.orsimerTitles()));
                while(titleScanner.hasNext())
                {
                    workingList.add(titleScanner.nextLine());
                } 
                
                workingValue = workingList.toString();
                
                while(i < workingValue.length())
                {
                   if(workingValue.charAt(i) == 32)
                   {
                       contentCop += workingValue.charAt(i); 
                   }
                   else if(workingValue.charAt(i) == 39 || workingValue.charAt(i) == 45)
                   {
                       contentCop += workingValue.charAt(i); 
                   }
                   else if(workingValue.charAt(i) >= 65 && workingValue.charAt(i) <= 90)
                   {
                       contentCop += workingValue.charAt(i); 
                   }
                   else if(workingValue.charAt(i) >= 97 && workingValue.charAt(i) <= 122)
                   {
                       contentCop += workingValue.charAt(i); 
                   }
                   else
                   {
                       if(contentCop != "")
                       {
                           if(contentCop.charAt(0) == 32)
                           {
                               contentCop = contentCop.substring(1);
                           }
                           //contentCop = formatStr.toString();
                           this.orsimerTitles.add(contentCop);
                           contentCop = "";
                       }
                   }
                    
                   i++;
                }
            }
            else
            {
               int i = 0;
               int j = 0;
               tempStr = "";
               workingList.clear();
    
               Scanner lastScanner = new Scanner(new File(input.fullLast()));
               while(lastScanner.hasNext())
               {
                   workingList.add(lastScanner.next());
               }
                
               workingValue = workingList.toString();
                
               while(i < workingValue.length())
               {
                   if(workingValue.charAt(i) >= 65 && workingValue.charAt(i) <= 90)
                   {
                       contentCop += workingValue.charAt(i);
                   }
                   else if(workingValue.charAt(i) >= 97 && workingValue.charAt(i) <= 122)
                   {
                       contentCop += workingValue.charAt(i);
                   }
                   else if(workingValue.charAt(i) == 39 || workingValue.charAt(i) == 45)
                   {
                       contentCop += workingValue.charAt(i); 
                   }
                   else
                   {
                       if(contentCop != "")
                       {
                           this.lastNames.add(contentCop);
                           contentCop = "";
                       }
                   }
                    
                   i++;             
                }
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    
    public String getFirstName(int pos)
    {
        return this.firstNames.get(pos);
    }
    
    public String getLastName(int pos)
    {
        return this.lastNames.get(pos);
    }
    
    public String getTitle(int pos)
    {
        return this.orsimerTitles.get(pos);
    }
    
    public String getCyroArg(int pos)
    {
        return this.cyroArg.get(pos);
    }
    
    public int getFirstLength()
    {
        return this.firstNames.size();
    }
    
    public int getLastLength()
    {
        return this.lastNames.size();
    }
    
    public int getTitleLength()
    {
        return this.orsimerTitles.size();
    }
}
