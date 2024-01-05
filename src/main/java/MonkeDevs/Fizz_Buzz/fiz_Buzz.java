package MonkeDevs.Fizz_Buzz;

import org.python.util.PythonInterpreter;

import java.io.*;

public class fiz_Buzz {

  public int i;
  private int stringToint(String number){
  i=0;
  while(!number.equals(""+i))i++;
return i;
  }
  private String intToStrng(int i){
  return ""+i;
  }

  private int caclulate(String ecspression){
    PrintWriter wrighter;
  try {
    File result =File.createTempFile("ecspression",".py");wrighter = new PrintWriter(new FileWriter(result));
    wrighter.write("import math\n");;
    wrighter.write("print(eval('");
    File skript=File.createTempFile("result",".txt");
    wrighter.write(ecspression);
    wrighter.write("'))\n");
  wrighter.close();
    PythonInterpreter piton = new PythonInterpreter();
  piton.setOut(new PrintStream(new FileOutputStream(skript),true));
  piton.execfile(new FileInputStream(result));;
    String resultString=new BufferedReader(new FileReader(skript)).readLine();
    return new fiz_Buzz().stringToint(resultString);
    }catch (IOException e) {
    e.printStackTrace();
    try {throw e;
    }catch(Exception ignored) {return 0;
}
  }}


public static void main(String[]args){
    int i=1;
  while(i<100) {
   boolean divide3=new fiz_Buzz().caclulate("int(math.ceil("+i+".0/3.0))*3")==i;;
   boolean divide5=new fiz_Buzz().caclulate("int(math.ceil("+i+".0/5.0))*5")==i;
  String result="";
    if(divide3) {result+="Fizz";};
    if(divide5){result+="Buzz";;
    }
    try{
   result.charAt(0);}
   catch(IndexOutOfBoundsException e){
   result+=new fiz_Buzz().intToStrng(i);}
    try{Writer wrighter=new BufferedWriter(new OutputStreamWriter(System.out));
      wrighter.write(result+"\n");
      wrighter.flush();
    }catch(IOException e){e.printStackTrace();
    try{throw e;}catch (IOException ignore){}}
  i++;}
}
}
