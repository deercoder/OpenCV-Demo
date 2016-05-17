#include <jni.h>
#include <string.h>

/*
#include "opencv2/opencv.hpp"

#include "opencv2/core.hpp"
#include "opencv2/core/mat.hpp"
#include "opencv2/imgproc.hpp"
#include "opencv2/photo.hpp"
#include "opencv2/video.hpp"
#include "opencv2/features2d.hpp"
#include "opencv2/objdetect.hpp"
#include "opencv2/calib3d.hpp"
#include "opencv2/imgcodecs.hpp"
#include "opencv2/videoio.hpp"
#include "opencv2/highgui.hpp"
#include "opencv2/ml.hpp"
//using namespace cv;
//using namespace std;




int main_test()
{
    cv::Mat image = cv::imread(argv[1]);
    cv::Mat blank(image.size(),CV_8U,cv::Scalar(0xFF));
    cv::Mat dest;
    imshow("originalimage", image);

    // Create markers image
    cv::Mat markers(image.size(),CV_8U,cv::Scalar(-1));
    //Rect(topleftcornerX, topleftcornerY, width, height);
    //top rectangle
    markers(Rect(0,0,image.cols, 5)) = Scalar::all(1);
    //bottom rectangle
    markers(Rect(0,image.rows-5,image.cols, 5)) = Scalar::all(1);
    //left rectangle
    markers(Rect(0,0,5,image.rows)) = Scalar::all(1);
    //right rectangle
    markers(Rect(image.cols-5,0,5,image.rows)) = Scalar::all(1);
    //centre rectangle
    int centreW = image.cols/4;
    int centreH = image.rows/4;
    markers(Rect((image.cols/2)-(centreW/2),(image.rows/2)-(centreH/2), centreW, centreH)) = Scalar::all(2);
    markers.convertTo(markers,CV_BGR2GRAY);
    imshow("markers", markers);

    //Create watershed segmentation object
    WatershedSegmenter segmenter;
    segmenter.setMarkers(markers);
    cv::Mat wshedMask = segmenter.process(image);
    cv::Mat mask;
    convertScaleAbs(wshedMask, mask, 1, 0);

    // raw threshold baseline version
    // double thresh = threshold(mask, mask, 1, 255, THRESH_BINARY);

    // Add the so-called OSTU-value
    double thresh = threshold(mask, mask, 1, 255, THRESH_OTSU+THRESH_BINARY);
    bitwise_and(image, image, dest, mask);
    dest.convertTo(dest,CV_8U);

    imshow("final_result", dest);
    cv::waitKey(0);

    return 0;
}
*/


extern "C" {

JNIEXPORT jstring JNICALL
Java_deercoder_uml_com_opencvdemo_MainActivity_getMsgFromJni(JNIEnv *env, jobject instance) {

    // TODO


    return (*env).NewStringUTF("Hello From Jni");
}

}