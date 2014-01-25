package motuary;

/**
 * @author Njihia
 */
public class transMode 
{   
    typeOfTransMode statusTrans;       

    public enum typeOfTransMode
    {
        Wait, AddRecord, EditRecord     
    }   
     
    public void setTransMode(typeOfTransMode status) 
    {
      this.statusTrans = status;
    }

    public typeOfTransMode getTransMode()
    {
      return statusTrans;
    }      
}
