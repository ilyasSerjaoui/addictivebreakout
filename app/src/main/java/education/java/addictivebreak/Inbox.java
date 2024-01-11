package education.java.addictivebreak;

public class Inbox {
    String title, icon, text;

    private Inbox(){}

    public Inbox(String title, String icon, String text) {
        this.title = title;
        this.icon = icon;
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
