//question 1
import java.util.ArrayList;
import java.util.Iterator;
/**
 * Store details of club memberships.
 * 
 * @author (your name) 
 * @version 7.0
 */
public class Club
{
    // Define any necessary fields here ...
    
    //question 1
    private ArrayList<Membership>members;
    
    
    /**
     * Constructor for objects of class Club
     */
    public Club()
    {
        //question 1
        members = new ArrayList<>();
        join(new Membership("Peter", 6, 2025));
        join(new Membership("Markiplier", 10, 2025));
        join(new Membership("Go Diego Go", 3, 2015));
    }

    /**
     * Add a new member to the club's list of members.
     * @param member The member object to be added.
     */
    public void join(Membership member)
    {
        //question 3
        members.add(member);
    }

    /**
     * @return The number of members (Membership objects) in
     *         the club.
     */
    public int numberOfMembers()
    {
        //question 2
        return members.size();
    }
    
    /**
    * Determine the number of members who joined in the
    * given month.
    * @param month The month we are interested in.
    * @return The number of members who joined in that month.
    */
    public int joinInMonth(int month){
        if (month > 12 || month < 1){
             System.out.println("invalid range");
             return 0;
            }
        else{
            int count = 0;
            for (Membership m : members){
                if (m.getMonth() == month){
                    count++;
                }
            }
            return count;
        }
    }
    
    /**
    * Remove from the club's collection all members who
    * joined in the given month, and return them stored
    * in a separate collection object.
    * @param month The month of the membership.
    * @param year The year of the membership.
    * @return The members who joined in the given month and year.
    */
    public ArrayList<Membership> purge(int month, int year){
        ArrayList<Membership> purgeList = new ArrayList<>();
        if (month > 12 || month < 1){
            System.out.println("no more members");
            return null;
        }else {
            Iterator<Membership> it = members.iterator();
            while(it.hasNext()){
                Membership m = it.next();
                if (m.getMonth() == month && m.getYear() == year){
                    purgeList.add(m);
                    it.remove();
                }
            }
        }
        return purgeList;
    }
    
    public ArrayList<Membership> altPurge (int month, int year){
        if ((month > 12|| month < 1) || (year < 1950 || year > 2026)){
            System.out.println("invalid month "+ month);
            return null;
        }
        
        else {
            ArrayList<Membership> purgeList = new ArrayList<>();
            for (Membership m :members){
                if (m.getMonth() == month && m.getYear() == year){
                    purgeList.add(m);
                }
            }
            members.removeAll(purgeList);
            return purgeList;
        }
    }
}