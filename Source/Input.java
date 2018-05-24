
/**
 * @Botond Hamori
 * @v0.24.05a
 */

//need new class for identifying filename

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.*;



public class Input
{
    public static int race;
    public static int gender;
    //public int random;
    
    String[] listOfRaces = {"Altmer", "Argonian", "Bosmer", "Breton", "Dunmer", "Imperial", "Khajiit", "Nord", "Orsimer", "Redguard"};
    
    
    public void Input()
    {
        
    }

    
    public void start()
    {
        
        Scanner readRace = new Scanner(System.in);
        Scanner readGender = new Scanner(System.in);
        System.out.println("Below is the list of playable races in the Elder Scrolls universe.");
        System.out.println("Each of the races have a corresponding number, choose a race by entering their assigned number.");
        System.out.println("Altmer = 0");
        System.out.println("Argonian = 1");
        System.out.println("Bosmer = 2");
        System.out.println("Breton = 3");
        System.out.println("Dunmer = 4");
        System.out.println("Imperial = 5");
        System.out.println("Khajiit = 6");
        System.out.println("Nord = 7");
        System.out.println("Orsimer = 8");
        System.out.println("Redguard = 9");
        
        this.race = readRace.nextInt();
        System.out.println(this.charRace(race)); 
        while(race < 0 || race > 9)
        {
            System.out.println("I know there are sloads, sea elves, ash creatures, and many more races in the Elder Scrolls universe, but please try to select one from the list");
            this.race = readRace.nextInt();
        }
        
        System.out.println("Define the gender by entering either 0 or 1.");
        System.out.println("0 is for male and 1 is for female.");

        this.gender = readGender.nextInt();
        System.out.println(this.charGender(gender));
        while(gender < 0 || gender > 1)
        {
            System.out.println("There are 2 genders.");
            this.gender = readGender.nextInt();
        }
        
        System.out.println("R: " + race + " G: " + gender);
        //this.testMethod(this.race, this.gender);        
    }
    
    private void testMethod(int a, int b)
    {
        String race = this.charRace(a);
        String gender = this.charGender(b);
        System.out.println("LAD... " + race + " " + gender);
    }
    
    public String charRace(int r)
    {
        String raceName = this.listOfRaces[r];
        return raceName;
    }
    
    public String charGender(int g)
    {
        String genderName;
        g = this.gender;
        
        if(g == 0)
        {
            genderName = "(M)";
        }
        else
        {
            genderName = "(F)";
        }
        
        return genderName;
        
        
    }
    
    public String prefixFirst()
    {
        //int raceName = this.race;
        //int genderName = this.gender;        
        String r = this.charRace(this.race);
        String g = this.charGender(this.gender);
        
        String fileInFolder = "Names/" + r + " Prefixes " + g + ".txt";
        //System.out.println(fileInFolder);
        return fileInFolder;
    }
    
    public String suffixFirst()
    {
        //int raceName = this.race;
        //int genderName = this.gender;        
        String r = this.charRace(this.race);
        String g = this.charGender(this.gender);
        
        String fileInFolder = "Names/" + r + " Suffixes " + g + ".txt";
        //System.out.println(fileInFolder);
        return fileInFolder;
    }
    
    public String prefixLast()
    {     
        String r = this.charRace(this.race);
        
        String fileInFolder = "Names/" + r + " Prefixes (L)" + ".txt";
        //System.out.println(fileInFolder);
        return fileInFolder;
    }
    
    public String suffixLast()
    {
        //int raceName = this.race;      
        String r = this.charRace(this.race);
        
        String fileInFolder = "Names/" + r + " Suffixes (L)" + ".txt";
        //System.out.println(fileInFolder);
        return fileInFolder;
    }
    
    public String fullFirst()
    {
        //int raceName = this.race;
        //int genderName = this.gender;
        
        String r = this.charRace(this.race);
        String g = this.charGender(this.gender);
        
        String fileInFolder = "Names/" + r + " First Names " + g + ".txt";
        //System.out.println(fileInFolder);
        return fileInFolder;
    }
    
    public String fullLast()
    {
        int raceName = this.race;
        
        String r = this.charRace(raceName);
        
        String fileInFolder = "Names/" + r + " Last Names.txt";
        //System.out.println(fileInFolder);
        return fileInFolder;        
    }
    
    public String imperialPref()
    {
        String fileInFolder = "Names/Imperial Prefixes (U).txt";
        return fileInFolder;
    }
    
    public String imperialMid()
    {
        String fileInFolder = "Names/Imperial Middle (U).txt";
        return fileInFolder;
    }
    
    public String imperialSuff()
    {
        String fileInFolder = "Names/Imperial Suffixes (U).txt";
        return fileInFolder;
    }
    
    public String redguardPref()
    {
        String fileInFolder = "Names/Redguard Prefixes (U).txt";
        return fileInFolder;
    }
    
    public String redguardMid()
    {
        String fileInFolder = "Names/Redguard Middle (U).txt";
        return fileInFolder;
    }
    
    public String redguardSuff1()
    {
        String fileInFolder = "Names/Redguard Suffixes (U).txt";
        return fileInFolder;
    }

    public String redguardSuff2()
    {
        String fileInFolder = "Names/Redguard Second Suffixes (U).txt";
        return fileInFolder;
    }
    
    public String orsimerTitles()
    {
        String fileInFolder = "Names/Orsimer Titles.txt";
        return fileInFolder;
    }
    
    public int raceID()
    {
        return this.race;
    }
    
    public int genderID()
    {
        return this.gender;
    }
    
    /*public String argonianName()
    {
        String g = this.charGender(this.gender);
        String fileInFolder = "Names/Argonian First Names " + g + ".txt";
        return fileInFolder;
    }*/
    
    public String cyrodArg()
    {
        String g = this.charGender(this.gender);
        String fileInFolder = "Names/Argonian Cyrodilic Names " + g + ".txt";
        return fileInFolder;        
    }
}
