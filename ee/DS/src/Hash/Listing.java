package Hash;


public class Listing implements DS
{ private String name;  // key field
   private String address;
   private String number;
   public Listing(String n, String a, String num )
  {  name = n;
      address = a;
      number = num;
  }
   public String toString( )
   {   return("Name is " + name +
                    "\nAddress is " + address +
                    "\nNumber is " + number + "\n");
   }
   public Listing deepCopy( )
   {  Listing clone = new Listing(name, address, number);
      return clone;
   }
   public int compareTo(Object targetKey)
   {  return(name.compareTo((String) targetKey));
   }
   public void setAddress(String a) // coded to demonstrate encapsulation
   {  address = a;
   }
   public String getKey()
   {   return name;
   }}

