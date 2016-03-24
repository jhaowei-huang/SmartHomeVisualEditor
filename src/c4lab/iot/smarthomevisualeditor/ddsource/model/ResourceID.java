package c4lab.iot.smarthomevisualeditor.ddsource.model;

/**
 * Created by user on 2014/11/5.
 */
public class ResourceID extends Entity {
    private long id;
    private long classID;
    private long typeId;
    private String name;
    private int type; //actuator = 1,sensor = 0

    public ResourceID() {
    }

    public ResourceID(long id,long typeId ,long classID, String name,int type) {
        this.id = id;
        this.typeId = typeId;
        this.classID = classID;
        this.name = name;
        this.type = type;
    }

    /*public static final Creator<ResourceID> CREATOR = new Creator<ResourceID>() {
        @Override
        public ResourceID createFromParcel(Parcel in) {
            return new ResourceID(in);
        }

        @Override
        public ResourceID[] newArray(int size) {
            return new ResourceID[size];
        }
    };*/

    @Override
    public String toString() {
        return "Ip{" +
                "id=" + id +
                ", typeId='" + typeId + '\'' +
                ", classID='" + classID + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    public long getClassID() {
        return classID;
    }

    public void setClassID(long classID) {
        this.classID = classID;
    }

    public long getTypeId() {
        return typeId;
    }

    public void setTypeId(long typeId) {
        this.typeId = typeId;
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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}

