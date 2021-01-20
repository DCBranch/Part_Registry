package Parts;

/**
 * Part - Describes a part for a maintenance system
 * 
 * @author Dawson Branch
 * @version 2.0.0
 * @since 0.0.0
 */
 public abstract class Part {
   
   private String name;    // The description of the Part
   private String number;  // The Part number
   private String ncage;   // NCAGE ( 5 characters )
   private String niin;    // ID ( 9 characters )
   private UnusableException stopper = null; //The reason the part is no longer usable
   
   
   // ========= Object Class Overrides ========= //
   
   @Override
   public String toString() {
      return ( this.name + "| P/N: " + this.number + "| CAGE: " + this.ncage + "| NIIN: " + this.niin );
   }
   
   @Override
   public boolean equals( Object otherPart ) {
      boolean result = false;

      if (otherPart instanceof Part) {

         Part other = (Part)otherPart;

         if (
            this.number.equals(other.number) &&
            this.ncage.equals(other.ncage) &&
            this.niin.equals(other.niin)
            )
            result = true;
      }
      
      return ( result );
   }
   
   /**
    * No-argument constructor calls Full Argument Constructor (FAC) with default values
    */
   public Part () {
      this( "Unknown Part Name", "", "00000", "0000-00-000-0000" );
   }
   
   public Part (String name) throws IllegalArgumentException {
       this( name, "", "00000", "0000-00-000-0000" );
   }
   
   /**
    * One Argument constructor calls FAC with Part number and default values
    * @param number an alphanumeric string for the Part number
    */
   public Part(String name, String number ) throws IllegalArgumentException {
      this( name, number, "00000", "0000-00-000-0000" );
   }
   
   /**
    * Two argument constructor calls FAC with Part number, ncage, and default values
    * @param number an alphanumeric string for the Part number
    * @param ncage A five-character string for the CAGE code
    */
   public Part(String name, String number, String ncage ) throws IllegalArgumentException {
      this(name, number, ncage, "0000-00-000-0000");
   }
   
   /**
    * Three argument constructor calls FAC with Part number, ncage, niin and defaults
    * @param number an alphanumeric string for the Part number
    * @param ncage A five-character string for the CAGE code
    * @param niin A 13-number string for the NIIN of the form XXXX-XX-XXX-XXXX
    */
   public Part( String name, String number, String ncage, String niin )  throws IllegalArgumentException {
      this.name = name;
      
      this.number = number;
      
      if(ncage.matches("[A-Z0-9]{5}"))
          this.ncage = ncage.toUpperCase();
      else
          System.err.println("Invalid Ncage input");
      
      if(niin.matches("\\d{4}-\\d{2}-\\d{3}-\\d{4}"))
          this.niin = niin;
      else
          System.err.println("Invalid Niin input");
   }
   
   /**
    * intCheck - Checks to see if a string is numeric (an integer)
    * 
    * @param s - String to be tested if it's a number
    * @return - True if string is formatted correctly and false otherwise
    */
    public static boolean intCheck(String s)
    {
        try{
            int i = Integer.parseInt(s);
            return true;
        } catch(IllegalArgumentException e)
        {
            return false;
        }
    }

    /**
    * doubleCheck - Checks to see if a string is numeric (an double)
    * 
    * @param s - String to be tested if it's a number
    * @return - True if string is formatted correctly and false otherwise
    */
    public static boolean doubleCheck(String s)
    {
        try{
            double i = Double.parseDouble(s);
            return true;
        } catch(IllegalArgumentException e)
        {
            return false;
        }
    }
   
   /**
    * ncageCheck - Checks a potential ncage and returns true or false depending 
    * on whether it fits the proper ncage format, a five-character string for 
    * the CAGE code
    * 
    * @param ncage - String to be tested for ncage formatting
    * @return - True if string is formatted correctly and false otherwise
    */
   public static boolean ncageCheck(String ncage)
   {
       if(ncage.matches("[A-Z0-9]{5}"))
          return true;
      else
          return false;
   }
   
   /**
    * ncageCheck - Checks a potential ncage and returns true or false depending 
    * on whether it fits the proper ncage format, a 13-number string for the 
    * NIIN of the form XXXX-XX-XXX-XXXX
    * 
    * @param niin - String to be tested for niin formatting
    * @return - True if string is formatted correctly and false otherwise
    */
   public static boolean niinCheck(String niin)
   {
       if(niin.matches("\\d{4}-\\d{2}-\\d{3}-\\d{4}"))
          return true;
      else
          return false;
   }
   
   /**
    * Takes a string to set the name for the Part
    * @param name an alphanumeric string for the Part name
    */
   public void setName( String name ) throws IllegalArgumentException {
      this.name=name;
   }
   
   /**
    * Takes a string to set the number for the Part
    * @param number an alphanumeric string for the Part number
    */
   public void setNumber( String number ) throws IllegalArgumentException {
      try{
          this.number = number;
      }
      catch(IllegalArgumentException illegalArgumentException){
          System.out.printf("%nInput must be a string.%n%n");
      }
       
   }
   
   /**
    * Takes a string to set the CAGE Code for the Part
    * @param ncage A five-character string for the CAGE code
    */
   public void setNcage( String ncage ) throws IllegalArgumentException {
      
      if(ncage.matches("[A-Za-z0-9]{5}"))
          this.ncage = ncage.toUpperCase();
      else
          System.err.println("Invalid Ncage input");
   }
   /**
    * Takes a string to set the NIIN for the Part
    * @param niin A 13-character string for the NIIN of the form XXXX-XX-XXX-XXXX
    */
   public void setNiin( String niin )  throws IllegalArgumentException  {
      if(niin.matches("\\d{4}-\\d{2}-\\d{3}-\\d{4}"))
          this.niin = niin;
      else
          System.err.println("Invalid Niin input");
   }
   
   /**
    * setStopper - decommissions this part's future usage
    * 
    * @param reason - cause for the unusable exception's creation and its future
    * throws
    */
   public void setStopper (String reason){
       this.stopper = new UnusableException(reason);
   }
   
   /**
    * Returns the String name of the part
    * @return the name of the part
    */
   public String getName( )  {
      return this.name;
   }
   
   /**
    * Returns the String number of the part
    * @return the number of the part
    */
   public String getNumber( ) {
      return this.number;
   }
   
   /**
    * Returns the String ncage of the part
    * @return the ncage of the part
    */
   public String getNcage( ) {
      return this.ncage;
   }
   
   /**
    * Returns the String niin of the part
    * @return the niin of the part
    */
   public String getNiin( ) {
      return this.niin;
   }
   
   /**
    * getStopper - supplies the reason for this part's decommissioning
    * 
    * @return cause for the unusable exception's creation and its future throws
    */
   public UnusableException getStopper(){
       return this.stopper;
   }
} // end Class Part