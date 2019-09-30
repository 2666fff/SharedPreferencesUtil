import android.graphics.Matrix;
import android.os.Parcel;
import android.os.Parcelable;

//matrix implements parcelable which can be passing by intent
public class ParcelableMatrix extends Matrix implements Parcelable {
    public static final Creator<ParcelableMatrix> CREATOR = new Creator<ParcelableMatrix>() {
        @Override
        public ParcelableMatrix createFromParcel(Parcel source) {
            return new ParcelableMatrix(source);
        }

        @Override
        public ParcelableMatrix[] newArray(int size) {
            return new ParcelableMatrix[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        float[] f = new float[9];
        getValues(f);
        dest.writeFloatArray(f);
    }

    protected ParcelableMatrix(Parcel in) {
        float[] f = new float[9];
        in.readFloatArray(f);
        setValues(f);
    }

    public ParcelableMatrix() {
        super();
    }

    public ParcelableMatrix(Matrix m) {
        super(m);
    }
}
