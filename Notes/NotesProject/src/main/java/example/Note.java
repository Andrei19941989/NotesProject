package example;

public class Note {
    private String title;
    private String text;
    private int userid;
    public Note(String title,String text, int userid)
    {
       this.title =title;
       this.text=text;
       this.userid=userid;

    }
     public String getTitle()
     {
        return title;
     }
     public String getText()
     {
        return text;
     }
     public int getUserid()
     {
        return userid;
     }

}
