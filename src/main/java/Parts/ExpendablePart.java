package Parts;

import Parts.Part;
import Parts.ConsumablePart;
import java.util.ArrayList;

/**
 * ExpendablePart - A Part object that is reusable, generally used until failure,
 * and has a notable lead time on replacements coming in
 * 
 * @author Dawson C. Branch
 * @version 1.2.0
 * @since 0.0.0
 */
public class ExpendablePart extends Part
{
    private int failureRate = 0; //average number of failures per operational hour of the part
    private int leadTime = 0; //number of days it takes to replace the part in the supply system
    private boolean usable = true; //Whether the part is still in use
    ArrayList<ConsumablePart> toolsRequired = new ArrayList<ConsumablePart>();

    /**
     * ExpendablePart - Default constructor.
     */
    public ExpendablePart ()
    {
        super();
    }

    /**
     * ExpendablePart - Constructs an Expendable Part.
     * 
     * @param failureRate - int for average number of failures per 
     * operational hour of the part
     */
    public ExpendablePart (int failureRate)
    {
        super();
        this.failureRate = failureRate;
    }

    /**
     * ExpendablePart - Constructs an Expendable Part.
     * 
     * @param failureRate - int for average number of failures per 
     * operational hour of the part
     * @param leadTime - number of days it takes to replace the part in the 
     * supply system
     */
    public ExpendablePart (int failureRate, int leadTime)
    {
        super();
        this.failureRate = failureRate;
        this.leadTime = leadTime;
    }

    /**
     * ExpendablePart - Constructs an Expendable Part.
     * 
     * @param name - The description of the Part
     * @param failureRate - int for average number of failures per 
     * operational hour of the part
     * @param leadTime - number of days it takes to replace the part in the 
     * supply system
     */
    public ExpendablePart (String name,int failureRate, int leadTime)
    {
        super(name);
        this.failureRate = failureRate;
        this.leadTime = leadTime;
    }

    /**
     * ExpendablePart - Constructs an Expendable Part.
     * 
     * @param name - The description of the Part
     * @param number - The Part number
     * @param failureRate - int for average number of failures per 
     * operational hour of the part
     * @param leadTime - number of days it takes to replace the part in the 
     * supply system
     */
    public ExpendablePart (String name,String number, int failureRate, int leadTime)
    {
        super(name,number);
        this.failureRate = failureRate;
        this.leadTime = leadTime;
    }

    /**
     * ExpendablePart - Constructs an Expendable Part.
     * 
     * @param name - The description of the Part
     * @param number - The Part number
     * @param ncage - NCAGE code ( 5 characters )
     * @param failureRate - int for average number of failures per 
     * operational hour of the part
     * @param leadTime - number of days it takes to replace the part in the 
     * supply system
     */
    public ExpendablePart (String name,String number, String ncage, int failureRate, int leadTime)
    {
        super(name,number,ncage);
        this.failureRate = failureRate;
        this.leadTime = leadTime;
    }

    /**
     * ExpendablePart - Constructs an Expendable Part.
     * 
     * @param name - The description of the Part
     * @param number - The Part number
     * @param ncage - NCAGE code ( 5 characters )
     * @param niin - ID ( 9 characters )
     * @param failureRate - int for average number of failures per 
     * operational hour of the part
     * @param leadTime - number of days it takes to replace the part in the 
     * supply system
     */
    public ExpendablePart (String name,String number, String ncage, String niin, int failureRate, int leadTime)
    {
        super(name,number,ncage,niin);
        this.failureRate = failureRate;
        this.leadTime = leadTime;
    }

    /**
     * ExpendablePart - Constructs an Expendable Part.
     * 
     * @param name - The description of the Part
     */
    public ExpendablePart (String name)
    {
        super(name);
    }

    /**
     * ExpendablePart - Constructs an Expendable Part.
     * 
     * @param name - The description of the Part
     * @param number - The Part number
     */
    public ExpendablePart (String name,String number)
    {
        super(name,number);
    }

    /**
     * ExpendablePart - Constructs an Expendable Part.
     * 
     * @param name - The description of the Part
     * @param number - The Part number
     * @param ncage - NCAGE code ( 5 characters )
     */
    public ExpendablePart (String name,String number, String ncage)
    {
        super(name,number,ncage);
    }

    /**
     * ExpendablePart - Constructs an Expendable Part.
     * 
     * @param name - The description of the Part
     * @param number - The Part number
     * @param ncage - NCAGE code ( 5 characters )
     * @param niin - ID ( 9 characters )
     */
    public ExpendablePart (String name,String number, String ncage, String niin)
    {
        super(name,number,ncage,niin);
    }

    /**
     * addTool - Adds a tool, a consumable part, to the list of tools 
     * required
     * 
     * @param tool - Consumable part to be added to the list of required 
     * tools
     */
    public void addTool(ConsumablePart tool)
    {
        toolsRequired.add(tool);
    }
    
    /**
     * use - Tests the part's failure rate to see if the part breaks on this 
     * operational hour. Returns boolean for whether the part is still usable
     * 
     * @return boolean for if the part is still usable
     * @throw 
     */
/*    public boolean use()
    {
        try{
           if(getStopper() == null)
           {
               if(randomly gen-ed number > break chance){
                   usable = false;
                   setStopper("Part " getName() + " is broken.");
               }
               return usable;
           }
           else
            {
               throw getStopper();
            }
        }
        catch(UnusableException stopper)
        {
            System.err.println(stopper.getMessage());
            return usable;
        }
    }
    
    /**
     * stoppage - decommissions this part's future usage
     * 
     * @param reason - cause for the part use preventing exception to be thrown
     */
    public void stoppage(String reason)
    {
        setStopper(reason);
    }
}