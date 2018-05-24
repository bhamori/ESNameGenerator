
/**
 * @Botond Hamori 
 * @v0.24.05a
 */

import java.util.Scanner;

public class driver
{
    public static void main(String[] args)
    {
        Input input = new Input();
        input.start();
        
        NameGenerator generator = new NameGenerator();
        generator.nameResult();
        System.out.println("press 0 to reroll, 1 to exit");
        
        Scanner userInput = new Scanner(System.in);
        int command = userInput.nextInt();
        
        //ExistingName existingName = new ExistingName();
        //existingName.getFirstLength();
        System.out.println();
        
        while(command == 0)
        {
            //existingName.getFirstLength();
            generator.nameResult();
            //String name = 
            //System.out.println(name);
            

            command = userInput.nextInt();
            if(command != 0 && command != 1)
            {
               System.out.println("invalid input");
            }
            
        }
        
    }
}
