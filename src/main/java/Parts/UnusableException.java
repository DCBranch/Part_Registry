package Parts;

/**
 * UsusableException - thrown when a Part an attempt to use an unusable part is 
 * made
 *
 * @author Dawson C. Branch
 * @version 1.2.0
 * @since 1.2.0
 */
public class UnusableException extends Exception
{
    UnusableException(String s)
    {
        super(s);
    }
}