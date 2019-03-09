// considered
// 1. if it does not accepts a string of length n then the automata should not accepts a string of lenght n+1

import java.util.*;

class automate {

  public static void main(String[] args) {
    ArrayList <String> list = new ArrayList<String>();
    input_End(list,0);
    System.out.println(list);
  }


  public static void input_End(ArrayList <String> ls,int skip){
      ArrayList <String> ls1=new ArrayList<String>();
      String chk;
      boolean flag=false;//used for exiting when no combination are accepted

      //1st time when the list is empty
      // ***************************
      if(ls.isEmpty()){
        for (char c='a';c<='z';c++) {
          chk=String.valueOf(c);
          if(blind_Box(chk))
          ls1.add(chk);
        }
        flag=true;
        System.out.println("IN SINGLE CHARACTER");

      }
      // ****************************


      // for multiple alphabets
      // ****************************
      else{

        for (int i=skip;i<ls.size();i++) {


        for (char c='a';c<='z';c++) {

          chk=ls.get(i)+String.valueOf(c);

          if (blind_Box(chk)) {
            ls1.add(chk);
            flag=true;
          }
        }

      }

      }
      // ****************************

      skip=ls.size();
      ls.addAll(ls1);
      ls1.clear();
      System.out.println(ls);
      if (flag) {
        input_End(ls,skip);
      }
  }



//automata function.........

  public static boolean blind_Box(String input){
    //some acceptable dummy strings
    String ar[]= {"a","b","c","f","g","z","ac","ab","af","bz","bg","cz","fg","gg","abfg","abf"};



    for (int i =0;i<ar.length;i++){
      if(input.equals(ar[i])) {
        return true;
      }

    }
    return false;
  }

 }
