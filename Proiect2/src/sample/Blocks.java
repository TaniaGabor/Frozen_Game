package sample;

public class Blocks {
    private String path;
    private String blankPath;
    private boolean visible;

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        /* Check if o is an instance of Complex or not
          "null instanceof [type]" also returns false */
        if (!(o instanceof Blocks)) {
            return false;
        }

        // typecast o to Complex so that we can compare data members
        Blocks b = (Blocks) o;

        // Compare the data members and return accordingly
        return this.path.equals(b.getPath());
    }

    public String getBlankPath() {
        return blankPath;
    }

    Blocks()
    {
        this.blankPath = "img/Blank.png";
        visible = false;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

}
