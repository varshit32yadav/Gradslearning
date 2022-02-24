package academy.learnprograming;

public class StringUtilities {
    StringBuilder sbuilder=new StringBuilder();
    private  int charAdded=0;
    public void addChar(StringBuilder sbuilder,char c){
        this.sbuilder.append(c);
        charAdded++;
    }
}
