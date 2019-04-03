package dao;

import domain.User;
import java.util.*;

public class UserDao {
  private Map<String, User> usersDB = new HashMap<>();
  {
    usersDB.put("tmelake@mum.edu", new User(1,"tmelake@mum.edu","123456789", "Tomas", "2029453732", "madison st apt3"));
    usersDB.put("sweldegiorgis@mum.edu", new User(2,"sweldegiorgis.edu","871520", "Semhar", "6143773939", "1000 N 4th"));
    usersDB.put("mkhong@mum.edu", new User(2,"feyasu@mum.edu","654321", "Fnan Eyasu", "4044909741", "501 w stone Ave"));
  }

  public boolean checkExistUser(String email, String password){
    if(usersDB.containsKey(email) && usersDB.get(email).getPassword().equals(password)){
      return true;
    }
    return false;
  }
  public User getUserByEmail(String email){
      return usersDB.get(email);
  }
  public User getUser(String email){
    return usersDB.get(email);
  }
  public boolean checkExistEmail(String email){
    if (usersDB.containsKey(email)){
      return true;
    }
    return false;
  }
  public int getMaxID(){
    return usersDB.entrySet().stream().max((entry1, entry2) -> entry1.getValue().getId() > entry2.getValue().getId() ? 1 : -1).get().getValue().getId();
  }
  public boolean addUser(String email, String pw,String fullname,String telephone,String address)
  {
    if (checkExistEmail(email)) {
      return false;
    }
    else {
      int newId = getMaxID() + 1;
      usersDB.put(email,new User(newId,email, pw, fullname, telephone, address));
      return true;
    }
  }

  public List<User> getUsersDB(){
    return new ArrayList<User>(usersDB.values());
  }
}
