package jdbc.lesson4.hw;

import jdbc.lesson4.hw.exception.BadRequestException;

public class File {
    private long id;
    private String name;
    private String format;
    private long size;
    private long storageID;

    public File() {
    }

    public File(long id, String name, String format, long size, long storageID) throws BadRequestException {
        this.id = id;
        this.name = name;
        if (name.length() > 10) throw new BadRequestException("File cannot be created. Name is more than 10 symbols. ");
        this.format = format;
        this.size = size;
        this.storageID = storageID;
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

    public long getStorageID() {
        return storageID;
    }

    public void setStorageID(long storageID) {
        this.storageID = storageID;
    }

    @Override
    public String toString() {
        return "File{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", format='" + format + '\'' +
                ", size=" + size +
                ", storageID=" + storageID +
                '}';
    }
}
