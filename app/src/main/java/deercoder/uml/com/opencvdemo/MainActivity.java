package deercoder.uml.com.opencvdemo;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.opencv.android.BaseLoaderCallback;
import org.opencv.android.LoaderCallbackInterface;
import org.opencv.android.OpenCVLoader;
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;


public class MainActivity extends Activity {


    final String TAG = "OpenCVDemo";

    private BaseLoaderCallback mLoaderCallback = new BaseLoaderCallback(this) {
        @Override
        public void onManagerConnected(int status) {
            switch(status) {
                case LoaderCallbackInterface.SUCCESS:
                    Log.e(TAG, "OpenCV Manager Connected");
                    //from now onwards, you can use OpenCV API
                    Mat m = new Mat(5, 10, CvType.CV_8UC1, new Scalar(0));

                    // Process the image
                    String filename = "seg.png";
                    System.out.println(String.format("Writing %s", filename));

                    Mat result_img = imgSegProcess("/sdcard/Download/lena1.jpg");
                    Imgcodecs.imwrite(filename, result_img);
                    break;
                case LoaderCallbackInterface.INIT_FAILED:
                    Log.i(TAG,"Init Failed");
                    break;
                case LoaderCallbackInterface.INSTALL_CANCELED:
                    Log.i(TAG,"Install Cancelled");
                    break;
                case LoaderCallbackInterface.INCOMPATIBLE_MANAGER_VERSION:
                    Log.i(TAG,"Incompatible Version");
                    break;
                case LoaderCallbackInterface.MARKET_ERROR:
                    Log.i(TAG,"Market Error");
                    break;
                default:
                    Log.i(TAG,"OpenCV Manager Install");
                    super.onManagerConnected(status);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.e(TAG, getMsgFromJni());

        if (!OpenCVLoader.initDebug()) {
            Log.e(TAG, "OpenCV init error!");
        }

        //initialize OpenCV manager
        OpenCVLoader.initAsync(OpenCVLoader.OPENCV_VERSION_2_4_9, this, mLoaderCallback);
        mLoaderCallback.onManagerConnected(LoaderCallbackInterface.SUCCESS);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }


    public Mat imgSegProcess(String imgPath) {
        Mat threeChannel = new Mat();
        String picturePath = getResources().getDrawable(R.drawable.lena1, null).toString(); // or "/sdcard/Download/lena1.jpg", but both not work
        Mat mRgba = Imgcodecs.imread(picturePath);
        Log.e(TAG, "Image Path: " + picturePath);
        Log.e(TAG, "channels: "+ mRgba.channels() + " depths: " + mRgba.depth() + " size: " + mRgba.size());
        //Imgproc.cvtColor(mRgba, threeChannel, Imgproc.COLOR_BGR2GRAY);
        Imgproc.threshold(threeChannel, threeChannel, 100, 255, Imgproc.THRESH_BINARY);

        Mat fg = new Mat(mRgba.size(),CvType.CV_8U);
        Imgproc.erode(threeChannel,fg,new Mat(),new Point(-1,-1),2);

        Mat bg = new Mat(mRgba.size(),CvType.CV_8U);
        Imgproc.dilate(threeChannel,bg,new Mat(),new Point(-1,-1),3);
        Imgproc.threshold(bg,bg,1, 128,Imgproc.THRESH_BINARY_INV);

        Mat markers = new Mat(mRgba.size(),CvType.CV_8U, new Scalar(0));
        Core.add(fg, bg, markers);

        WatershedSegmenter segmenter = new WatershedSegmenter();
        segmenter.setMarker(markers);
        Mat result = segmenter.process(mRgba);

        Log.e(TAG, "finish watershed processing!");

        return result;
    }

    // new code
    static {
        System.loadLibrary("hello-android-jni");
    }
    public native String getMsgFromJni();
    // new code done

}


