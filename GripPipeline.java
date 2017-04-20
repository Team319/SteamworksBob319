package visiontest;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.HashMap;

import org.opencv.core.*;
import org.opencv.core.Core.*;
import org.opencv.features2d.FeatureDetector;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.*;
import org.opencv.objdetect.*;

/**
* GripPipeline class.
*
* <p>An OpenCV pipeline generated by GRIP.
*
* @author GRIP
*/
public class GripPipeline {

	//Outputs
	private Mat valveOutput = new Mat();
	private Mat hsvThresholdOutput = new Mat();
	private Mat cvErodeOutput = new Mat();
	private Mat maskOutput = new Mat();
	private ArrayList<MatOfPoint> findContoursOutput = new ArrayList<MatOfPoint>();

	private boolean valveValve = true;
	static {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
	}

	/**
	 * This is the primary method that runs the entire pipeline and updates the outputs.
	 */
	public void process(Mat source0) {
		// Step Valve0:
		//Input
		Mat valveInput = source0;
		//Output
		Ref<Mat> valveOutputRef = new Ref<Mat>();
		pipelineValve(valveValve, valveInput, valveOutputRef);
		//output assignment
		valveOutput = valveOutputRef.get();
		// Step HSV_Threshold0:
		Mat hsvThresholdInput = valveOutput;
		double[] hsvThresholdHue = {87.41007194244604, 139.83637904777734};
		double[] hsvThresholdSaturation = {38.98381294964029, 224.94949494949495};
		double[] hsvThresholdValue = {166.7625899280575, 255.0};
		hsvThreshold(hsvThresholdInput, hsvThresholdHue, hsvThresholdSaturation, hsvThresholdValue, hsvThresholdOutput);

		// Step CV_erode0:
		Mat cvErodeSrc = hsvThresholdOutput;
		Mat cvErodeKernel = new Mat();
		Point cvErodeAnchor = new Point(-1, -1);
		double cvErodeIterations = 0.0;
		int cvErodeBordertype = Core.BORDER_CONSTANT;
		Scalar cvErodeBordervalue = new Scalar(-1);
		cvErode(cvErodeSrc, cvErodeKernel, cvErodeAnchor, cvErodeIterations, cvErodeBordertype, cvErodeBordervalue, cvErodeOutput);

		// Step Mask0:
		Mat maskInput = valveOutput;
		Mat maskMask = cvErodeOutput;
		mask(maskInput, maskMask, maskOutput);

		// Step Find_Contours0:
		Mat findContoursInput = hsvThresholdOutput;
		boolean findContoursExternalOnly = false;
		findContours(findContoursInput, findContoursExternalOnly, findContoursOutput);

	}

	/**
	 * This method is a generated setter for the condition of Valve
	 * @param the condition to set
	 */
	 public void setvalve0(boolean value) {
	 	valveValve = value;
	 }

	/**
	 * This method is a generated getter for the output of a Valve.
	 * @return Mat output from Valve.
	 */
	public Mat valveOutput() {
		return valveOutput;
	}

	/**
	 * This method is a generated getter for the output of a HSV_Threshold.
	 * @return Mat output from HSV_Threshold.
	 */
	public Mat hsvThresholdOutput() {
		return hsvThresholdOutput;
	}

	/**
	 * This method is a generated getter for the output of a CV_erode.
	 * @return Mat output from CV_erode.
	 */
	public Mat cvErodeOutput() {
		return cvErodeOutput;
	}

	/**
	 * This method is a generated getter for the output of a Mask.
	 * @return Mat output from Mask.
	 */
	public Mat maskOutput() {
		return maskOutput;
	}

	/**
	 * This method is a generated getter for the output of a Find_Contours.
	 * @return ArrayList<MatOfPoint> output from Find_Contours.
	 */
	public ArrayList<MatOfPoint> findContoursOutput() {
		return findContoursOutput;
	}


	/**
	 * Sets an output if a value is true.
	 * @param sw The boolean that determines the output.
	 * @param input The output if sw is true.
	 * @param output The output which is equal to the input or null.
	 */
	private static <T> void pipelineValve(boolean sw, T input, Ref<T> output) {
		if (sw) {
			output.set(input);
		}
		else {
			output.set(null);
		}
	}

	/**
	 * Segment an image based on hue, saturation, and value ranges.
	 *
	 * @param input The image on which to perform the HSL threshold.
	 * @param hue The min and max hue
	 * @param sat The min and max saturation
	 * @param val The min and max value
	 * @param output The image in which to store the output.
	 */
	private void hsvThreshold(Mat input, double[] hue, double[] sat, double[] val,
	    Mat out) {
		Imgproc.cvtColor(input, out, Imgproc.COLOR_BGR2HSV);
		Core.inRange(out, new Scalar(hue[0], sat[0], val[0]),
			new Scalar(hue[1], sat[1], val[1]), out);
	}

	/**
	 * Expands area of lower value in an image.
	 * @param src the Image to erode.
	 * @param kernel the kernel for erosion.
	 * @param anchor the center of the kernel.
	 * @param iterations the number of times to perform the erosion.
	 * @param borderType pixel extrapolation method.
	 * @param borderValue value to be used for a constant border.
	 * @param dst Output Image.
	 */
	private void cvErode(Mat src, Mat kernel, Point anchor, double iterations,
		int borderType, Scalar borderValue, Mat dst) {
		if (kernel == null) {
			kernel = new Mat();
		}
		if (anchor == null) {
			anchor = new Point(-1,-1);
		}
		if (borderValue == null) {
			borderValue = new Scalar(-1);
		}
		Imgproc.erode(src, dst, kernel, anchor, (int)iterations, borderType, borderValue);
	}

	/**
	 * Filter out an area of an image using a binary mask.
	 * @param input The image on which the mask filters.
	 * @param mask The binary image that is used to filter.
	 * @param output The image in which to store the output.
	 */
	private void mask(Mat input, Mat mask, Mat output) {
		mask.convertTo(mask, CvType.CV_8UC1);
		Core.bitwise_xor(output, output, output);
		input.copyTo(output, mask);
	}

	/**
	 * Sets the values of pixels in a binary image to their distance to the nearest black pixel.
	 * @param input The image on which to perform the Distance Transform.
	 * @param type The Transform.
	 * @param maskSize the size of the mask.
	 * @param output The image in which to store the output.
	 */
	private void findContours(Mat input, boolean externalOnly,
		List<MatOfPoint> contours) {
		Mat hierarchy = new Mat();
		contours.clear();
		int mode;
		if (externalOnly) {
			mode = Imgproc.RETR_EXTERNAL;
		}
		else {
			mode = Imgproc.RETR_LIST;
		}
		int method = Imgproc.CHAIN_APPROX_SIMPLE;
		Imgproc.findContours(input, contours, hierarchy, mode, method);
	}


	/**
	 * Enables C-style output parameters in Java to avoid creating custom data classes for each
	 * operation.
	 *
	 * <p>Syntax is {@code Ref<T> varName = new Ref<T>(initValue)}.
	 * Where varName is the name of the variable and initValue is of type T and contains initial value.
	 * </p>
	 * @param <T> The type of object being referenced
	 */
	private static class Ref<T> {
		private T value;

		/**
		 * Constructor for a Ref object.
		 * @param initValue Type T initial value for the object.
		 */
		public Ref(T initValue) {
			value = initValue;
		}

		/**
		 * Constructor for a Ref object without an initial value.
		 * Equivalent to calling Ref(null)
		 */
		public Ref() {
			this(null);
		}

		/**
		 * Sets the object to contain a new value.
		 *
		 * @param newValue the new value being referenced
		 */
		public void set(T newValue) {
			value = newValue;
		}

		/**
		 * Gets the current referenced value
		 *
		 * @return the current referenced value
		 */
		public T get() {
			return value;
		}
	}

}

