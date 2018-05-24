
/**
 * @Botond Hamori
 * @v0.24.05a
 */

import java.*;
import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class NameGenerator
{
    String name = "";
    String tempStr1 = "";
    String tempStr2 = "";
    
    Input input = new Input();
    int raceID = input.raceID();
    int genderID = input.genderID();
    
    List<String> namesFirst = new ArrayList<String>();
    List<String> namesLast = new ArrayList<String>();
    //List<String> cyroArg = new ArrayList<String>();
    
    public NameGenerator()
    {
        this.numGen();
        this.createNames();
    }
    
    public void nameResult()
    {
        //this.generate();
        name = this.pickName();
        System.out.println("Here's your name: " + name);
        //this.reset();
    }

    public void createNames()
    {
        //Combine prefix/suffix
        
        ExistingName existing = new ExistingName();
               
        if(raceID != 1)
        {
            Combiner combiner = new Combiner();
            combiner.Combiner();
            int i = 0;
            int firstLength = combiner.getFirstLength();  
            while(i < firstLength)
            {
                this.namesFirst.add(combiner.getFirstName(i));
                i++;
            }
            
            if(raceID != 6) //argonians and khajiits have no last names
            {
                int j = 0;   
                int lastLength = combiner.getLastLength();
                while(j < lastLength)
                {
                    this.namesLast.add(combiner.getLastName(j));
                    j++;
                }
                
                int l = 0;
                int existLastLength = existing.getLastLength();
                while(l < existLastLength)
                {
                    this.namesLast.add(existing.getLastName(l));
                    l++;
                }                
            }
        }
       
        //Add existing first names
        int k = 0;
        int existFirstLength = existing.getFirstLength();
        while(k < existFirstLength)
        {
            this.namesFirst.add(existing.getFirstName(k));
            k++;
        }
    }
    
    public String pickName()
    {
        int a = this.namesFirst.size();
        
        int i, j;
        String fullName;
        Random randFirst = new Random();
        i = randFirst.nextInt(a);
        
        if(raceID != 1 && raceID != 6)
        {
            int b = this.namesLast.size();
            Random randLast = new Random();
            j = randLast.nextInt(b);
            
            if(raceID == 8)
            {
                ExistingName existingName = new ExistingName();
                int rand = this.numGen();
                
                int c, k;
                
                if(rand == 0)
                {
                    if(genderID == 0)
                    {
                        fullName = namesFirst.get(i) + " gro-" + namesLast.get(j);
                    }
                    else
                    {
                        fullName = namesFirst.get(i) + " gra-" + namesLast.get(j);
                    }                    
                }
                else
                {
                    c = existingName.getTitleLength();
                    k = randLast.nextInt(c);
                    fullName = namesFirst.get(i) + " " + existingName.getTitle(k);
                }
            }            
            else if(raceID != 0 || raceID != 2 || raceID != 7 || raceID != 8)
            {
                fullName = namesFirst.get(i) + " " + namesLast.get(j);
            }

            else
            {
                fullName = namesFirst.get(i) + namesLast.get(j);               
            }
        }
        else
        {
            fullName = namesFirst.get(i);
        }
        
        return fullName;
    }
    
    /*public String getName()
    {
        String fullName = tempStr1 + " " + tempStr2;
        return fullName;
    }*/
    
    public void reset()
    {
        this.namesFirst.clear();
        this.namesLast.clear();
    }
    
    public int numGen()
    {
        List<Integer> rng = new ArrayList<Integer>();
        int x = 0;
        while(x < 50)
        {
            rng.add(x, 0);
            x++;
        }
        
        while(x < 100)
        {
            rng.add(x, 1);
            x++;
        }
        
        Collections.shuffle(rng);
        return rng.get(0);
    }
}
