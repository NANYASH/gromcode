package core.lesson19;


public class File {
    private long id;
    private String name;
    private String format;
    private long size;

    public File(long id, String name, String format, long size) throws Exception {
        this.id = id;
        if (name.length() > 10) throw new Exception("File cannot be created. Name is more than 10 symbols. ");
        this.name = name;
        this.format = format;
        this.size = size;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "File{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", format='" + format + '\'' +
                ", size=" + size +
                '}';
    }
}
